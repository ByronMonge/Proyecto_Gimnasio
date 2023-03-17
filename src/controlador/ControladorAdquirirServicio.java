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
import modelo.ModeloAdquirirServicio;
import modelo.ModeloCliente;
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
        vista.getBtnCrear().addActionListener(l -> abrirjDialogAdquirirServicio());
        vista.getBtnBuscarCli().addActionListener(l -> abrirjDialogCliente());
        vista.getBtnCargarCli().addActionListener(l -> cargarDatosClienteEnTXT());
    }

    public void abrirjDialogAdquirirServicio() {
        vista.getjDlgAdquirirServicio().setVisible(true);
        vista.getjDlgAdquirirServicio().setSize(885, 638);
        vista.getjDlgAdquirirServicio().setLocationRelativeTo(null);
        vista.getjDlgAdquirirServicio().setTitle("Seleccionar curso");

        //Quito la visibilidad del txt del codigo del curso
        vista.getTxtCodigoCliente().setVisible(false);
        cargarRegistroDeCliente();
        //buscarCurso();
    }

    //Todo sobre el registro de cursos en el jDialog
    public void abrirjDialogCliente() {
        vista.getjDlgBuscarCliente().setVisible(true);
        vista.getjDlgBuscarCliente().setSize(630, 300);
        vista.getjDlgBuscarCliente().setLocationRelativeTo(null);
        vista.getjDlgBuscarCliente().setTitle("Seleccionar curso");

        //Quito la visibilidad del txt del codigo del curso
        // vista.getTxtCodigoCurso().setVisible(false);
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
}
