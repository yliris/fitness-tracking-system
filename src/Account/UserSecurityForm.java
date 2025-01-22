package Account;

import Resources.components.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Window;
import javax.swing.JOptionPane;

public class UserSecurityForm extends javax.swing.JFrame {

    private int userId;
    private String originalPassword;
    private String originalQuestion;
    private String originalAnswer;

    public UserSecurityForm(int userId) {
        initComponents();
        this.userId = userId;
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(UserSecurityForm.this);
        populateSecurityDetails(userId);
    }

    private void populateSecurityDetails(int userId) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT sec_question, sec_answer FROM tb_users WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                originalQuestion = rs.getString("sec_question");
                originalAnswer = rs.getString("sec_answer");

                profile_question_field.setText(originalQuestion);
                profile_answer_field.setText(originalAnswer);
            } else {
                JOptionPane.showMessageDialog(this, "No security details found for this user.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while retrieving security details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new Resources.components.PanelBorder();
        label2 = new javax.swing.JLabel();
        password_check = new javax.swing.JToggleButton();
        profile_password = new javax.swing.JLabel();
        profile_password_field = new javax.swing.JPasswordField();
        profile_sec_question = new javax.swing.JLabel();
        profile_question_field = new javax.swing.JTextField();
        profile_sec_answer = new javax.swing.JLabel();
        profile_answer_field = new javax.swing.JTextField();
        security_save_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        security_element = new javax.swing.JLabel();
        mover = new Resources.components.PanelMover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(224, 255, 224));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label2.setBackground(new java.awt.Color(112, 112, 112));
        label2.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        label2.setText("Edit Security Details");
        label2.setIconTextGap(15);
        panelBorder1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 50));

        password_check.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        password_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/eye-close.png"))); // NOI18N
        password_check.setAlignmentY(0.0F);
        password_check.setBorder(null);
        password_check.setBorderPainted(false);
        password_check.setContentAreaFilled(false);
        password_check.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        password_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_checkActionPerformed(evt);
            }
        });
        panelBorder1.add(password_check, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 105, 20, 20));

        profile_password.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        profile_password.setText("Enter New Password:");
        panelBorder1.add(profile_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 350, 20));

        profile_password_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(profile_password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 350, -1));

        profile_sec_question.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        profile_sec_question.setText("Enter New Validation Question:");
        panelBorder1.add(profile_sec_question, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 350, 20));

        profile_question_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(profile_question_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 350, -1));

        profile_sec_answer.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        profile_sec_answer.setText("Enter New Validation Answer:");
        panelBorder1.add(profile_sec_answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 350, 20));

        profile_answer_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(profile_answer_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 350, -1));

        security_save_btn.setBackground(new java.awt.Color(39, 154, 91));
        security_save_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        security_save_btn.setForeground(new java.awt.Color(255, 255, 255));
        security_save_btn.setText("Save Changes");
        security_save_btn.setAlignmentY(0.0F);
        security_save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                security_save_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(security_save_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 350, 30));

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
        panelBorder1.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 5, -1, -1));

        security_element.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-security-element.png"))); // NOI18N
        panelBorder1.add(security_element, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        panelBorder1.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 10));

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 320));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void password_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_checkActionPerformed
        if (password_check.isSelected()) {
            password_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/eye-open.png")));
            profile_password_field.setEchoChar((char) 0);
        } else {
            password_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/eye-close.png")));
            profile_password_field.setEchoChar('*');
        }
    }//GEN-LAST:event_password_checkActionPerformed

    private void security_save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_security_save_btnActionPerformed
        String newPassword = new String(profile_password_field.getPassword()).trim();
        String newQuestion = profile_question_field.getText().trim();
        String newAnswer = profile_answer_field.getText().trim();

        //CHECK IF FIELDS ARE EMPTY
        if (newPassword.isEmpty() || newQuestion.isEmpty() || newAnswer.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF NO CHANGES WERE MADE
        if (newPassword.equals(originalPassword) && newQuestion.equals(originalQuestion) && newAnswer.equals(originalAnswer)) {
            int confirmExit = JOptionPane.showConfirmDialog(this, "No changes were made. Exit the form?", null, JOptionPane.YES_NO_OPTION);
            if (confirmExit == JOptionPane.YES_OPTION) {
                dispose();
            }
            return;
        }
        //CHECK IF PASSWORD LENGTH IS VALID
        if (newPassword.length() < 8) {
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF QUESTION AND ANSWER LENGTH IS VALID
        if (newQuestion.length() < 5 || newAnswer.length() < 3) {
            JOptionPane.showMessageDialog(null, "Security question must be at least 5 characters long and answer must be at least 3 characters long.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection conn = DatabaseConnection.getConnection();

            String updateQuery = "UPDATE tb_users SET password = ?, sec_question = ?, sec_answer = ? WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(updateQuery);

            pstmt.setString(1, newPassword);
            pstmt.setString(2, newQuestion);
            pstmt.setString(3, newAnswer);
            pstmt.setInt(4, userId);

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Security details updated successfully. Logging out.", "Success", JOptionPane.INFORMATION_MESSAGE);
                Window[] windows = Window.getWindows();
                for (Window window : windows) {
                    window.dispose();
                }
                new LoginForm().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update security details. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while updating security details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_security_save_btnActionPerformed

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
        int confirmExit = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to cancel editing?",
                "Cancel",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmExit == JOptionPane.YES_OPTION) {
            dispose();
        }
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
            java.util.logging.Logger.getLogger(UserSecurityForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserSecurityForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserSecurityForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserSecurityForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        int userId = 1;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserSecurityForm(userId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit_btn;
    private javax.swing.JLabel label2;
    private Resources.components.PanelMover mover;
    private Resources.components.PanelBorder panelBorder1;
    private javax.swing.JToggleButton password_check;
    private javax.swing.JTextField profile_answer_field;
    private javax.swing.JLabel profile_password;
    private javax.swing.JPasswordField profile_password_field;
    private javax.swing.JTextField profile_question_field;
    private javax.swing.JLabel profile_sec_answer;
    private javax.swing.JLabel profile_sec_question;
    private javax.swing.JLabel security_element;
    private javax.swing.JButton security_save_btn;
    // End of variables declaration//GEN-END:variables
}
