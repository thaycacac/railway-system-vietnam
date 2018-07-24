/**
 *
 * @author Thaycacac
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbFloyd = new javax.swing.JLabel();
        jlbFrom = new javax.swing.JLabel();
        jlbTo = new javax.swing.JLabel();
        tfTo = new javax.swing.JTextField();
        jlbWeight = new javax.swing.JLabel();
        tfFrom1 = new javax.swing.JTextField();
        tfWeight = new javax.swing.JTextField();
        jlbFloyd1 = new javax.swing.JLabel();
        tfFrom2 = new javax.swing.JTextField();
        tfTo1 = new javax.swing.JTextField();
        jlbTo1 = new javax.swing.JLabel();
        jlbFrom1 = new javax.swing.JLabel();
        btnFind = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jlbFloyd.setForeground(new java.awt.Color(0, 0, 255));
        jlbFloyd.setText("ADD EDGE");

        jlbFrom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbFrom.setText("From");

        jlbTo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbTo.setText("To");

        jlbWeight.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbWeight.setText("Weight");

        jlbFloyd1.setForeground(new java.awt.Color(0, 0, 255));
        jlbFloyd1.setText("FLOYD ALGORITHM");

        jlbTo1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbTo1.setText("To");

        jlbFrom1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbFrom1.setText("From");

        btnFind.setForeground(new java.awt.Color(51, 0, 255));
        btnFind.setText("FIND");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlbFrom)
                        .addGap(18, 18, 18)
                        .addComponent(tfFrom1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlbWeight)
                        .addGap(6, 6, 6)
                        .addComponent(tfWeight))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlbTo)
                        .addGap(34, 34, 34)
                        .addComponent(tfTo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlbFrom1)
                        .addGap(18, 18, 18)
                        .addComponent(tfFrom2, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlbTo1)
                        .addGap(34, 34, 34)
                        .addComponent(tfTo1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbFloyd1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlbFloyd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnFind, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jlbFloyd)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbFrom)
                    .addComponent(tfFrom1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTo)
                    .addComponent(tfTo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbWeight)
                    .addComponent(tfWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jlbFloyd1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbFrom1)
                    .addComponent(tfFrom2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTo1)
                    .addComponent(tfTo1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnFind)
                .addContainerGap(371, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFind;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlbFloyd;
    private javax.swing.JLabel jlbFloyd1;
    private javax.swing.JLabel jlbFrom;
    private javax.swing.JLabel jlbFrom1;
    private javax.swing.JLabel jlbTo;
    private javax.swing.JLabel jlbTo1;
    private javax.swing.JLabel jlbWeight;
    private javax.swing.JTextField tfFrom1;
    private javax.swing.JTextField tfFrom2;
    private javax.swing.JTextField tfTo;
    private javax.swing.JTextField tfTo1;
    private javax.swing.JTextField tfWeight;
    // End of variables declaration//GEN-END:variables
}
