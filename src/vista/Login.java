package vista;

import controlador.ControladorLogin;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author miche
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        btnregistrar = new javax.swing.JButton();
        lbmostrar = new javax.swing.JLabel();
        btniniciar = new javax.swing.JButton();
        lbocultar = new javax.swing.JLabel();
        txtcontra = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(190, 227, 227));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Contraseña:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Usuario:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 186, 30));

        btnregistrar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnregistrar.setText("Registrar");
        jPanel1.add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, -1, -1));

        lbmostrar.setBackground(new java.awt.Color(255, 204, 51));
        lbmostrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbmostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ojo-rojo.png"))); // NOI18N
        jPanel1.add(lbmostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 30, 30));

        btniniciar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btniniciar.setText("Iniciar");
        jPanel1.add(btniniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, -1));

        lbocultar.setBackground(new java.awt.Color(255, 0, 0));
        lbocultar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbocultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/visible.png"))); // NOI18N
        jPanel1.add(lbocultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 30, 30));
        jPanel1.add(txtcontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 190, 30));

        jPanel2.setBackground(new java.awt.Color(218, 238, 218));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hat.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 70, 70));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setText("Gimnasio ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setText("One");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel6.setText("Piece");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 250, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtniniciar() {
        return btniniciar;
    }

    public void setBtniniciar(JButton btniniciar) {
        this.btniniciar = btniniciar;
    }

    public JButton getBtnregistrar() {
        return btnregistrar;
    }

    public void setBtnregistrar(JButton btnregistrar) {
        this.btnregistrar = btnregistrar;
    }

    public JPasswordField getTxtcontra() {
        return txtcontra;
    }

    public void setTxtcontra(JPasswordField txtcontra) {
        this.txtcontra = txtcontra;
    }

    public JTextField getTxtusuario() {
        return txtusuario;
    }

    public void setTxtusuario(JTextField txtusuario) {
        this.txtusuario = txtusuario;
    }

    public JLabel getLbmostrar() {
        return lbmostrar;
    }

    public void setLbmostrar(JLabel lbmostrar) {
        this.lbmostrar = lbmostrar;
    }

    public JLabel getLbocultar() {
        return lbocultar;
    }

    public void setLbocultar(JLabel lbocultar) {
        this.lbocultar = lbocultar;
    }
    
    

    
    
    
    public static void main(String args[]) {
        
        
        Login vistaLogin = new Login();
        ControladorLogin control = new ControladorLogin(vistaLogin);
        control.iniciarControl();
        
    }
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btniniciar;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbmostrar;
    private javax.swing.JLabel lbocultar;
    private javax.swing.JPasswordField txtcontra;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
