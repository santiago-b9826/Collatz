package collatz;

/**
 *
 * @author Santiago Bedoya Betancur.
 */
import java.awt.Desktop;
import static java.awt.Desktop.getDesktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pantallaP extends javax.swing.JFrame {

    ArrayList<String> palabras;

    public pantallaP() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAltura = new javax.swing.JLabel();
        txtfAltura = new javax.swing.JTextField();
        txtfInicio = new javax.swing.JTextField();
        lblInicio = new javax.swing.JLabel();
        btnVisualizarG = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAltura.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAltura.setForeground(new java.awt.Color(255, 255, 255));
        lblAltura.setText("Altura:");
        getContentPane().add(lblAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 60, -1));
        getContentPane().add(txtfAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 90, -1));
        getContentPane().add(txtfInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 90, -1));

        lblInicio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblInicio.setForeground(new java.awt.Color(255, 255, 255));
        lblInicio.setText("Inicio:");
        getContentPane().add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 70, -1));

        btnVisualizarG.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnVisualizarG.setText("Visualizar Grafo");
        btnVisualizarG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarGActionPerformed(evt);
            }
        });
        getContentPane().add(btnVisualizarG, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 170, 30));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/collatz/earth.PNG"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVisualizarGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarGActionPerformed
        dibuje(Integer.parseInt(txtfInicio.getText()), Integer.parseInt(txtfAltura.getText()));
    }//GEN-LAST:event_btnVisualizarGActionPerformed

    public void dibuje(int n, int altura) {
        String nombre = "ward.txt";
        Collatz c = new Collatz();
        Arbol a = c.CollatzI(n, altura);
        a.resetArchivo(nombre);
        a.escribirArchivo(nombre, a.getRaiz());
        a.dibujar();
        String fileLocal = "src\\grafito.jpg";
        File path = new File(fileLocal);
        Desktop g = getDesktop();
        try {
            g.open(path);
        } catch (IOException ex) {
            Logger.getLogger(pantallaP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        pantallaP p = new pantallaP();
        p.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVisualizarG;
    private javax.swing.JLabel lblAltura;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JTextField txtfAltura;
    private javax.swing.JTextField txtfInicio;
    // End of variables declaration//GEN-END:variables
}
