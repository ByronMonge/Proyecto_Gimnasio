package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.xml.ws.Holder;
import modelo.Cliente;
import modelo.Instructor;
import modelo.ModeloAdquirirServicio;
import modelo.ModeloCliente;
import modelo.ModeloInstructor;
import modelo.ModeloNutricionista;
import modelo.ModeloServicio;
import modelo.Nutricionista;
import modelo.Servicio;
import vista.VistaAdquirirServicio;

public class ControladorAdquirirServicio {

    ModeloAdquirirServicio modelo;
    VistaAdquirirServicio vista;

    public ControladorAdquirirServicio(ModeloAdquirirServicio modelo, VistaAdquirirServicio vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }

    public void iniciarControl() {
        //AdquirirServicio
        vista.getBtnCrear().addActionListener(l -> abrirjDialogAdquirirServicio());
        vista.getBtnCalcular().addActionListener(l -> calcularTotal());

        //Cliente
        vista.getBtnBuscarCli().addActionListener(l -> abrirjDialogCliente());
        vista.getBtnCargarCli().addActionListener(l -> cargarDatosClienteEnTXT());

        //Instructor
        vista.getBtnBuscarIns().addActionListener(l -> abrirjDialogInstructor());
        vista.getBtnCargarIns().addActionListener(l -> cargarDatosInstructorEnTXT());

        //Nutricionista
        vista.getBtnBuscarNut().addActionListener(l -> abrirjDialogNutricionista());
        vista.getBtnCargarNut().addActionListener(l -> cargarDatosNutricionistaEnTXT());

        //Servicio
        vista.getBtnBuscarSer().addActionListener(l -> abrirjDialogServicio());
        vista.getBtnCargarSer().addActionListener(l -> cargarDatosServicioEnTXT());
    }

    public void abrirjDialogAdquirirServicio() {
        vista.getjDlgAdquirirServicio().setVisible(true);
        vista.getjDlgAdquirirServicio().setSize(885, 638);
        vista.getjDlgAdquirirServicio().setLocationRelativeTo(null);
        vista.getjDlgAdquirirServicio().setTitle("Seleccionar curso");

        //Quito la visibilidad del txt del codigo del curso
        vista.getTxtCodigoCliente().setVisible(false);
        vista.getTxtCodigoInstructor().setVisible(false);
        vista.getTxtCodigoNutricionista().setVisible(false);
        vista.getTxtCodigoServicio().setVisible(false);

        cargarRegistroDeCliente();
        //buscarCurso();
    }

    
    //Todo sobre el registro de clientes en el jDialog
    public void abrirjDialogCliente() {
        vista.getjDlgBuscarCliente().setVisible(true);
        vista.getjDlgBuscarCliente().setSize(630, 300);
        vista.getjDlgBuscarCliente().setLocationRelativeTo(null);
        vista.getjDlgBuscarCliente().setTitle("Seleccionar cliente");

        cargarRegistroDeCliente();
        buscarCliente();
    }

    public void cargarRegistroDeCliente() {

        ModeloCliente modeloCliente = new ModeloCliente();

        vista.getTblCli().setRowHeight(25);
        DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTblCli().getModel();
        estructuraTabla.setRowCount(0);

        List<Cliente> cliente = modeloCliente.listaClientesTabla();

        Holder<Integer> i = new Holder<>(0);

        cliente.stream().forEach(c -> {

            estructuraTabla.addRow(new Object[8]);

            vista.getTblCli().setValueAt(c.getCliente_codigo(), i.value, 0);
            vista.getTblCli().setValueAt(c.getPer_cedula(), i.value, 1);
            vista.getTblCli().setValueAt(c.getPer_nombre(), i.value, 2);
            vista.getTblCli().setValueAt(c.getPer_apellido(), i.value, 3);
            vista.getTblCli().setValueAt(c.getCliente_tipomembresia(), i.value, 4);

            i.value++;
        });
    }

    public void cargarDatosClienteEnTXT() {
        int fila = vista.getTblCli().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            ModeloCliente modeloCliente = new ModeloCliente();
            List<Cliente> listap = modeloCliente.listaClientesTabla();

            listap.stream().forEach(c -> {

                if (c.getCliente_codigo() == Integer.parseInt(vista.getTblCli().getValueAt(fila, 0).toString())) {

                    vista.getTxtCodigoCliente().setText(String.valueOf(c.getCliente_codigo()));
                    vista.getTxtCedulaCli().setText(c.getPer_cedula());
                    vista.getTxtNombreCli().setText(c.getPer_nombre() + " " + c.getPer_apellido());
                }
            });

            vista.getjDlgBuscarCliente().dispose();
        }
    }

    public void buscarCliente() {

        KeyListener eventoTeclado = new KeyListener() {//Crear un objeto de tipo keyListener(Es una interface) por lo tanto se debe implementar sus metodos abstractos

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {

                //CODIGO PARA FILTRAR LOS DATOS DIRECTAMENTE DE LA TABLA. NO ELIMINAR. SI FUNCIONA. ES MUY IMPORTANTE
                TableRowSorter<DefaultTableModel> filtrar;

                DefaultTableModel tabla = (DefaultTableModel) vista.getTblCli().getModel();

                //vista.getTablaconduccion().setAutoCreateRowSorter(true);
                filtrar = new TableRowSorter<>(tabla);
                vista.getTblCli().setRowSorter(filtrar);

                try {

                    filtrar.setRowFilter(RowFilter.regexFilter(vista.getTxtBuscarCli().getText())); //Se pasa como parametro el campo de donde se va a obtener la informacion y el (3) es la columna con la cual va a buscar las coincidencias
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
            }
        };

        vista.getTxtBuscarCli().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    //Todo sobre el registro de instructores en el jDialog
    public void abrirjDialogInstructor() {
        vista.getjDlgBuscarInstructor().setVisible(true);
        vista.getjDlgBuscarInstructor().setSize(620, 314);
        vista.getjDlgBuscarInstructor().setLocationRelativeTo(null);
        vista.getjDlgBuscarInstructor().setTitle("Seleccionar instructor");

        cargarRegistroDeInstructor();
        buscarInstructor();
    }

    public void cargarRegistroDeInstructor() {

        ModeloInstructor modeloInstructor = new ModeloInstructor();

        vista.getTblIns().setRowHeight(25);
        DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTblIns().getModel();
        estructuraTabla.setRowCount(0);

        List<Instructor> cliente = modeloInstructor.listaInstructoresTabla();

        Holder<Integer> i = new Holder<>(0);

        cliente.stream().forEach(c -> {

            estructuraTabla.addRow(new Object[8]);

            vista.getTblIns().setValueAt(c.getIns_codigo(), i.value, 0);
            vista.getTblIns().setValueAt(c.getPer_cedula(), i.value, 1);
            vista.getTblIns().setValueAt(c.getPer_nombre(), i.value, 2);
            vista.getTblIns().setValueAt(c.getPer_apellido(), i.value, 3);
            vista.getTblIns().setValueAt(c.getIns_areatrabajo(), i.value, 4);
            vista.getTblIns().setValueAt(c.getIns_suedo(), i.value, 5);

            i.value++;
        });
    }

    public void cargarDatosInstructorEnTXT() {
        int fila = vista.getTblIns().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            ModeloInstructor modeloInstructor = new ModeloInstructor();
            List<Instructor> listap = modeloInstructor.listaInstructoresTabla();

            listap.stream().forEach(c -> {

                if (c.getIns_codigo() == Integer.parseInt(vista.getTblIns().getValueAt(fila, 0).toString())) {

                    vista.getTxtCodigoInstructor().setText(String.valueOf(c.getIns_codigo()));
                    vista.getTxtCedulaIns().setText(c.getPer_cedula());
                    vista.getTxtNombreIns().setText(c.getPer_nombre() + " " + c.getPer_apellido());
                    vista.getSpinnerSueldoIns().setValue(c.getIns_suedo());
                }
            });

            vista.getjDlgBuscarInstructor().dispose();
        }
    }

    public void buscarInstructor() {

        KeyListener eventoTeclado = new KeyListener() {//Crear un objeto de tipo keyListener(Es una interface) por lo tanto se debe implementar sus metodos abstractos

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {

                //CODIGO PARA FILTRAR LOS DATOS DIRECTAMENTE DE LA TABLA. NO ELIMINAR. SI FUNCIONA. ES MUY IMPORTANTE
                TableRowSorter<DefaultTableModel> filtrar;

                DefaultTableModel tabla = (DefaultTableModel) vista.getTblIns().getModel();

                //vista.getTablaconduccion().setAutoCreateRowSorter(true);
                filtrar = new TableRowSorter<>(tabla);
                vista.getTblIns().setRowSorter(filtrar);

                try {

                    filtrar.setRowFilter(RowFilter.regexFilter(vista.getTxtBuscarIns().getText())); //Se pasa como parametro el campo de donde se va a obtener la informacion y el (3) es la columna con la cual va a buscar las coincidencias
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
            }
        };

        vista.getTxtBuscarIns().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    //Todo sobre el registro de nutricionista en el jDialog
    public void abrirjDialogNutricionista() {
        vista.getjDlgBuscarNutricionista().setVisible(true);
        vista.getjDlgBuscarNutricionista().setSize(711, 350);
        vista.getjDlgBuscarNutricionista().setLocationRelativeTo(null);
        vista.getjDlgBuscarNutricionista().setTitle("Seleccionar nutricionista");

        cargarRegistroDeNutricionista();
        buscarNutricionista();
    }

    public void cargarRegistroDeNutricionista() {

        ModeloNutricionista modeloNutricionista = new ModeloNutricionista();

        vista.getTblIns().setRowHeight(25);
        DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTblNut().getModel();
        estructuraTabla.setRowCount(0);

        List<Nutricionista> nutricionista = modeloNutricionista.listaNutricionistaTabla();

        Holder<Integer> i = new Holder<>(0);

        nutricionista.stream().forEach(c -> {

            estructuraTabla.addRow(new Object[8]);

            vista.getTblNut().setValueAt(c.getNutri_codigo(), i.value, 0);
            vista.getTblNut().setValueAt(c.getPer_cedula(), i.value, 1);
            vista.getTblNut().setValueAt(c.getPer_nombre(), i.value, 2);
            vista.getTblNut().setValueAt(c.getPer_apellido(), i.value, 3);
            vista.getTblNut().setValueAt(c.getNutri_aniosExperiencia(), i.value, 4);
            vista.getTblNut().setValueAt(c.getNutri_salario(), i.value, 5);

            i.value++;
        });
    }

    public void cargarDatosNutricionistaEnTXT() {
        int fila = vista.getTblNut().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            ModeloNutricionista modeloNutricionista = new ModeloNutricionista();

            List<Nutricionista> listap = modeloNutricionista.listaNutricionistaTabla();

            listap.stream().forEach(c -> {

                if (c.getNutri_codigo() == Integer.parseInt(vista.getTblNut().getValueAt(fila, 0).toString())) {

                    vista.getTxtCodigoNutricionista().setText(String.valueOf(c.getNutri_codigo()));
                    vista.getTxtCedulaNut().setText(c.getPer_cedula());
                    vista.getTxtNombreNut().setText(c.getPer_nombre() + " " + c.getPer_apellido());
                    vista.getSpinnerSueldoNut().setValue(c.getNutri_salario());
                }
            });

            vista.getjDlgBuscarNutricionista().dispose();
        }
    }

    public void buscarNutricionista() {

        KeyListener eventoTeclado = new KeyListener() {//Crear un objeto de tipo keyListener(Es una interface) por lo tanto se debe implementar sus metodos abstractos

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {

                //CODIGO PARA FILTRAR LOS DATOS DIRECTAMENTE DE LA TABLA. NO ELIMINAR. SI FUNCIONA. ES MUY IMPORTANTE
                TableRowSorter<DefaultTableModel> filtrar;

                DefaultTableModel tabla = (DefaultTableModel) vista.getTblNut().getModel();

                //vista.getTablaconduccion().setAutoCreateRowSorter(true);
                filtrar = new TableRowSorter<>(tabla);
                vista.getTblNut().setRowSorter(filtrar);

                try {

                    filtrar.setRowFilter(RowFilter.regexFilter(vista.getTxtBuscarNut().getText())); //Se pasa como parametro el campo de donde se va a obtener la informacion y el (3) es la columna con la cual va a buscar las coincidencias
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
            }
        };

        vista.getTxtBuscarNut().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    //Todo sobre el registro de servicio en el jDialog
    public void abrirjDialogServicio() {
        vista.getjDlgBuscarServicio().setVisible(true);
        vista.getjDlgBuscarServicio().setSize(664, 330);
        vista.getjDlgBuscarServicio().setLocationRelativeTo(null);
        vista.getjDlgBuscarServicio().setTitle("Seleccionar servicio");

        cargarRegistroDeServicio();
        buscarServicio();
    }

    public void cargarRegistroDeServicio() {

        ModeloServicio modeloServicio = new ModeloServicio();

        vista.getTblIns().setRowHeight(25);
        DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTblSer().getModel();
        estructuraTabla.setRowCount(0);

        List<Servicio> servicio = modeloServicio.listaServiciosTabla();

        Holder<Integer> i = new Holder<>(0);

        servicio.stream().forEach(c -> {

            estructuraTabla.addRow(new Object[8]);

            vista.getTblSer().setValueAt(c.getSer_codigo(), i.value, 0);
            vista.getTblSer().setValueAt(c.getSer_nombre(), i.value, 1);
            vista.getTblSer().setValueAt(c.getSer_precio(), i.value, 2);

            i.value++;
        });
    }

    public void cargarDatosServicioEnTXT() {
        int fila = vista.getTblSer().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            ModeloServicio modeloServicio = new ModeloServicio();
            List<Servicio> listap = modeloServicio.listaServiciosTabla();

            listap.stream().forEach(c -> {

                if (c.getSer_codigo() == Integer.parseInt(vista.getTblSer().getValueAt(fila, 0).toString())) {

                    vista.getTxtCodigoServicio().setText(String.valueOf(c.getSer_codigo()));
                    vista.getTxtNombreSer().setText(c.getSer_nombre());
                    vista.getSpinnerCostoSer().setValue(c.getSer_precio());
                }
            });

            vista.getjDlgBuscarServicio().dispose();
        }
    }

    public void buscarServicio() {

        KeyListener eventoTeclado = new KeyListener() {//Crear un objeto de tipo keyListener(Es una interface) por lo tanto se debe implementar sus metodos abstractos

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {

                //CODIGO PARA FILTRAR LOS DATOS DIRECTAMENTE DE LA TABLA. NO ELIMINAR. SI FUNCIONA. ES MUY IMPORTANTE
                TableRowSorter<DefaultTableModel> filtrar;

                DefaultTableModel tabla = (DefaultTableModel) vista.getTblSer().getModel();

                //vista.getTablaconduccion().setAutoCreateRowSorter(true);
                filtrar = new TableRowSorter<>(tabla);
                vista.getTblSer().setRowSorter(filtrar);

                try {

                    filtrar.setRowFilter(RowFilter.regexFilter(vista.getTxtBuscarSer().getText())); //Se pasa como parametro el campo de donde se va a obtener la informacion y el (3) es la columna con la cual va a buscar las coincidencias
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
            }
        };

        vista.getTxtBuscarSer().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    public void calcularTotal() {
        double costoIns = Double.parseDouble(vista.getSpinnerMesesIns().getValue().toString()) * Double.parseDouble(vista.getSpinnerSueldoIns().getValue().toString());
        double costoNut = Double.parseDouble(vista.getSpinnerMesesNut().getValue().toString()) * Double.parseDouble(vista.getSpinnerSueldoNut().getValue().toString());
        double costoSer = Double.parseDouble(vista.getSpinnerMesesSer().getValue().toString()) * Double.parseDouble(vista.getSpinnerCostoSer().getValue().toString());

        double total = costoIns + costoNut + costoSer;

        try {
            vista.getTxtTotal().setText(String.valueOf(total));
        } catch (NumberFormatException e) {
            System.out.println("Error");
        }
    }
}
