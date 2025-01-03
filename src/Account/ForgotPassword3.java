package Account;

import Connection.DatabaseConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ForgotPassword3 extends javax.swing.JFrame {
    private String username;

    public ForgotPassword3(String username) {
        this.username = username;
        initComponents();
        reset_btn.setEnabled(false);
        setupPasswordFieldListener();
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(ForgotPassword3.this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new Resources.panel.PanelBorder();
        newpassword_field = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        reset_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        mover = new Resources.panel.PanelMover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(204, 204, 204));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newpassword_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(newpassword_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 290, -1));

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel1.setText("Enter new password");
        panelBorder1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        reset_btn.setBackground(new java.awt.Color(102, 102, 255));
        reset_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        reset_btn.setForeground(new java.awt.Color(255, 255, 255));
        reset_btn.setText("RESET PASSWORD");
        reset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(reset_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 170, 30));

        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-idle.png"))); // NOI18N
        exit_btn.setBorder(null);
        exit_btn.setBorderPainted(false);
        exit_btn.setContentAreaFilled(false);
        exit_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exit_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exit_btnMouseReleased(evt);
            }
        });
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 5, 30, 30));
        panelBorder1.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 20));

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 190));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_btnActionPerformed
        String newPassword = new String(newpassword_field.getPassword());
        
        try (Connection conn = DatabaseConnection.getConnection()) {
            String checkPasswordQuery = "SELECT password FROM tb_users WHERE username = ?";
            PreparedStatement checkPs = conn.prepareStatement(checkPasswordQuery);
            checkPs.setString(1, username);
            ResultSet rs = checkPs.executeQuery();
            
            if (rs.next()) {
            String currentPassword = rs.getString("password");
                if (newPassword.equals(currentPassword)) {
                    JOptionPane.showMessageDialog(this, "The new password cannot be the same as the old password.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "User not found. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String updateQuery = "UPDATE tb_users SET password = ? WHERE username = ?";
            PreparedStatement ps = conn.prepareStatement(updateQuery);
            ps.setString(1, newPassword);
            ps.setString(2, username);
            
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Password successfully reset!\nBack to login", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to reset password. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_reset_btnActionPerformed

    private void setupPasswordFieldListener() {
        javax.swing.event.DocumentListener listener = new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { toggleResetButton(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { toggleResetButton(); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { toggleResetButton(); }
        };

        newpassword_field.getDocument().addDocumentListener(listener);
    }

    private void toggleResetButton() {
        boolean enable = !newpassword_field.getText().isEmpty();
        reset_btn.setEnabled(enable);
    }    
    
    private void exit_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseEntered
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btnMouseEntered

    private void exit_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseExited
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-idle.png")));
    }//GEN-LAST:event_exit_btnMouseExited

    private void exit_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMousePressed
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-click.png")));
    }//GEN-LAST:event_exit_btnMousePressed

    private void exit_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseReleased
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btnMouseReleased

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        this.dispose();
    }//GEN-LAST:event_exit_btnActionPerformed
        
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ForgotPassword3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                java.awt.EventQueue.invokeLater(() -> {
                    new ForgotPassword3("user").setVisible(true);
                });
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit_btn;
    private javax.swing.JLabel jLabel1;
    private Resources.panel.PanelMover mover;
    private javax.swing.JPasswordField newpassword_field;
    private Resources.panel.PanelBorder panelBorder1;
    private javax.swing.JButton reset_btn;
    // End of variables declaration//GEN-END:variables
}
