package Account;

import Connection.DatabaseConnection;
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back_btn = new javax.swing.JButton();
        new_password_field = new javax.swing.JPasswordField();
        re_new_password_field = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        reset_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        back_btn.setText("back to login");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        jLabel1.setText("enter new password");

        jLabel2.setText("retype new password");

        reset_btn.setText("reset password");
        reset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 295, Short.MAX_VALUE)
                        .addComponent(back_btn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(new_password_field)
                                .addComponent(re_new_password_field, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(reset_btn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(new_password_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(re_new_password_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reset_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(back_btn)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        new LoginForm().setVisible(true);
        dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void reset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_btnActionPerformed
        String newPassword = new String(new_password_field.getPassword());
        String reNewPassword = new String(re_new_password_field.getPassword());
        
        if (!newPassword.equals(reNewPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
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
                new LoginForm().setVisible(true);
                dispose();
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

        new_password_field.getDocument().addDocumentListener(listener);
        re_new_password_field.getDocument().addDocumentListener(listener);
    }

    private void toggleResetButton() {
        boolean enable = !new_password_field.getText().isEmpty() && !re_new_password_field.getText().isEmpty();
        reset_btn.setEnabled(enable);
    }
    
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
            public void run() {
                java.awt.EventQueue.invokeLater(() -> {
                    new ForgotPassword3("test_user").setVisible(true);
                });
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField new_password_field;
    private javax.swing.JPasswordField re_new_password_field;
    private javax.swing.JButton reset_btn;
    // End of variables declaration//GEN-END:variables
}
