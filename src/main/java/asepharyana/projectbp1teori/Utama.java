/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package asepharyana.projectbp1teori;

import asepharyana.layout.login.Login;
import asepharyana.layout.login.Register;

/**
 *
 * @author asephs
 */
public class Utama extends javax.swing.JFrame {

    /**
     * Creates new form Utama
     */
    public Utama() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Konten = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        MenuBarUtama = new javax.swing.JMenuBar();
        HomeMenu = new javax.swing.JMenu();
        AboutMenu = new javax.swing.JMenu();
        LoginMenu = new javax.swing.JMenu();
        RegisterMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Konten.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Selamat datang di Uploader Gambar");

        javax.swing.GroupLayout KontenLayout = new javax.swing.GroupLayout(Konten);
        Konten.setLayout(KontenLayout);
        KontenLayout.setHorizontalGroup(
            KontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KontenLayout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(jLabel1)
                .addContainerGap(299, Short.MAX_VALUE))
        );
        KontenLayout.setVerticalGroup(
            KontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KontenLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel1)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        HomeMenu.setText("Home");
        HomeMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeMenuMouseClicked(evt);
            }
        });
        MenuBarUtama.add(HomeMenu);

        AboutMenu.setText("About");
        AboutMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AboutMenuMouseClicked(evt);
            }
        });
        MenuBarUtama.add(AboutMenu);

        LoginMenu.setText("Login");
        LoginMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginMenuMouseClicked(evt);
            }
        });
        MenuBarUtama.add(LoginMenu);

        RegisterMenu.setText("Register");
        RegisterMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegisterMenuMouseClicked(evt);
            }
        });
        MenuBarUtama.add(RegisterMenu);

        setJMenuBar(MenuBarUtama);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Konten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Konten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginMenuMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_LoginMenuMouseClicked
        Login login = new Login(this);
        Konten.removeAll();
        Konten.add(login.getContentPane(), java.awt.BorderLayout.CENTER);
        Konten.revalidate();
        Konten.repaint();
    }// GEN-LAST:event_LoginMenuMouseClicked

    private void AboutMenuMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_AboutMenuMouseClicked
        About About = new About();
        Konten.removeAll();
        Konten.add(About.getContentPane(), java.awt.BorderLayout.CENTER);
        Konten.revalidate();
        Konten.repaint();
    }// GEN-LAST:event_AboutMenuMouseClicked

    private void HomeMenuMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_HomeMenuMouseClicked
        // Mengembalikan Konten ke default
        Konten.removeAll();
        Konten.add(jLabel1);
        Konten.revalidate();
        Konten.repaint();
    }// GEN-LAST:event_HomeMenuMouseClicked

    private void RegisterMenuMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_RegisterMenuMouseClicked
        Register register = new Register(this);
        Konten.removeAll();
        Konten.add(register.getContentPane(), java.awt.BorderLayout.CENTER);
        Konten.revalidate();
        Konten.repaint();

    }// GEN-LAST:event_RegisterMenuMouseClicked

    public void setKontenLogin() {
        Login login = new Login(this);
        Konten.removeAll();
        Konten.add(login.getContentPane(), java.awt.BorderLayout.CENTER);
        Konten.revalidate();
        Konten.repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AboutMenu;
    private javax.swing.JMenu HomeMenu;
    private javax.swing.JPanel Konten;
    private javax.swing.JMenu LoginMenu;
    private javax.swing.JMenuBar MenuBarUtama;
    private javax.swing.JMenu RegisterMenu;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
