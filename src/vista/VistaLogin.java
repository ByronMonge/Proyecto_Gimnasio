package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VistaLogin extends javax.swing.JInternalFrame {

    public VistaLogin() {
        initComponents();
    }

    public JButton getBtniniciar() {
        return btniniciar;
    }

    public void setBtniniciar(JButton btniniciar) {
        this.btniniciar = btniniciar;
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

    public JPasswordField getTxtcontrasenia() {
        return txtcontrasenia;
    }

    public void setTxtcontrasenia(JPasswordField txtcontrasenia) {
        this.txtcontrasenia = txtcontrasenia;
    }

    public JTextField getTxtusuario() {
        return txtusuario;
    }

    public void setTxtusuario(JTextField txtusuario) {
        this.txtusuario = txtusuario;
    }

    /*
    CREATE TABLE "adquirirservicio" (
	adq_codigo serial PRIMARY KEY not null,
	adq_codcli int,
	adq_codins int,
	adq_codnut int,
	adq_codser int,
	adq_fechainicio date,
	adq_mesesins int,
	adq_mesesnut int,
	adq_mesesser int,
	adq_costototal double precision,
    adq_estado character varying(1),
	
	FOREIGN KEY(adq_codcli) REFERENCES "cliente" ("cli_codigo") ON UPDATE NO ACTION ON DELETE NO ACTION,
	FOREIGN KEY(adq_codins) REFERENCES "instructor" ("ins_codigo") ON UPDATE NO ACTION ON DELETE NO ACTION,
	FOREIGN KEY(adq_codnut) REFERENCES "nutricionista" ("nut_codigo") ON UPDATE NO ACTION ON DELETE NO ACTION,
	FOREIGN KEY(adq_codser) REFERENCES "servicio" ("ser_codigo") ON UPDATE NO ACTION ON DELETE NO ACTION
);
    
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtcontrasenia = new javax.swing.JPasswordField();
        lbmostrar = new javax.swing.JLabel();
        btniniciar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbocultar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Usuario:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 186, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Contraseña:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));
        jPanel1.add(txtcontrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 190, 30));

        lbmostrar.setBackground(new java.awt.Color(255, 204, 51));
        lbmostrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbmostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ojo-rojo.png"))); // NOI18N
        jPanel1.add(lbmostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 30, 30));

        btniniciar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btniniciar.setText("Iniciar");
        jPanel1.add(btniniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hat.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 70, 70));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setText("Gimnasio ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setText("One");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel6.setText("Piece");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, -1, -1));

        lbocultar.setBackground(new java.awt.Color(255, 0, 0));
        lbocultar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbocultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/visible.png"))); // NOI18N
        jPanel1.add(lbocultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 30, 30));

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btniniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbmostrar;
    private javax.swing.JLabel lbocultar;
    private javax.swing.JPasswordField txtcontrasenia;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
