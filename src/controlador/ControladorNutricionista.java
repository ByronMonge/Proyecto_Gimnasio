package controlador;

import java.util.Date;
import javax.swing.JOptionPane;
import modelo.ModeloNutricionista;
import modelo.ModeloPersona;
import vista.VistaNutricionista;

public class ControladorNutricionista {

    ModeloNutricionista modelo;
    VistaNutricionista vista;

    public ControladorNutricionista(ModeloNutricionista modelo, VistaNutricionista vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }

    public void iniciarControl() {
        vista.getBtnCrear().addActionListener(l -> abrirJDlgNutricionista());
        vista.getBtnGuardar().addActionListener(l -> crearModificarNutricionista());

    }

    public void abrirJDlgNutricionista() {
        vista.getjDlgNutricionista().setVisible(true);
        vista.getjDlgNutricionista().setSize(809, 460);
        vista.getjDlgNutricionista().setLocationRelativeTo(null);
        vista.getjDlgNutricionista().setName("Crear nuevo nutricionista");
        vista.getjDlgNutricionista().setTitle("Crear nuevo nutricionista");
    }

    public void crearModificarNutricionista() {

        if ("Crear nuevo nutricionista".equals(vista.getjDlgNutricionista().getName())) {

            //Validar datos
            ModeloPersona persona = new ModeloPersona();
            if (persona.validarRepetidos(vista.getTxtCedula().getText()) == 0) {

                //Setear datos de persona
                persona.setPer_cedula(vista.getTxtCedula().getText());
                persona.setPer_nombre(vista.getTxtNombre().getText());
                persona.setPer_apellido(vista.getTxtApellido().getText());
                persona.setPer_telefono(vista.getTxtTelefono().getText());
                persona.setPer_direccion(vista.getTxtDireccion().getText());

                Date fecha = vista.getFechaDeNacimiento().getDate();
                java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
                persona.setPer_fechaNac(fechaSQL);

                //Setear datos de nutricionista
                modelo.setNutri_aniosExperiencia(Integer.parseInt(vista.getSpinnerAniosExperiencia().getValue().toString()));

                if (persona.crearPersona()) {
                    //Guarda el codigo de la persona
                    System.out.println("Persona");
                    modelo.setNutri_codper(persona.traerCodigoDePersonaCreada());
                    if (modelo.crearNutricionista()) {
                        JOptionPane.showMessageDialog(null, "Se creo exitosamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo registrar");
                        persona.eliminarPersonaNoCreada(vista.getTxtCedula().getText());
                    }
                } else {
                    System.out.println("Error");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El numero de cedula ya se encuentra registrado en la base de datos");
            }
        }

    }
}
