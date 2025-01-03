package Account;

import Connection.DatabaseConnection;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ForgotPassword2 extends javax.swing.JFrame {
    private String username;

    public ForgotPassword2(String username) {
        this.username = username;
        initComponents();
        setupAnswerFieldListener();
        proceed_btn.setEnabled(false);
        loadSecurityQuestion();
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(ForgotPassword2.this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new Resources.panel.PanelBorder();
        answer1 = new javax.swing.JLabel();
        answer = new javax.swing.JLabel();
        back_btn = new javax.swing.JButton();
        secanswer_field = new javax.swing.JTextField();
        proceed_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        question = new javax.swing.JLabel();
        mover = new Resources.panel.PanelMover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(204, 204, 204));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        answer1.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        answer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        answer1.setText("Note: Your answer must be the same format as the one you created during the signup process.");
        panelBorder1.add(answer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 580, 20));

        answer.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        answer.setText("Answer:");
        panelBorder1.add(answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 60, 20));

        back_btn.setText("back to login");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(back_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 271, -1, -1));

        secanswer_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(secanswer_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 330, -1));

        proceed_btn.setBackground(new java.awt.Color(102, 102, 255));
        proceed_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        proceed_btn.setForeground(new java.awt.Color(255, 255, 255));
        proceed_btn.setText("PROCEED");
        proceed_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceed_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(proceed_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 120, -1));

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
        panelBorder1.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 5, 30, 30));

        question.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        question.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        question.setText("Validation Question:");
        panelBorder1.add(question, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 600, -1));
        panelBorder1.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 20));

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 200));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        this.dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void proceed_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceed_btnActionPerformed
        String answer = secanswer_field.getText().trim();
        
        String checkAnswerQuery = "SELECT * FROM `tb_users` WHERE `username` = ? AND `sec_answer` = ?";
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(checkAnswerQuery)) {
            ps.setString(1, username);
            ps.setString(2, answer);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Answer correct! Proceeding...");
                    new ForgotPassword3(username).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Incorrect answer. Please try again.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForgotPassword2.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "An error occurred while validating the answer.");
        }
    }//GEN-LAST:event_proceed_btnActionPerformed

    private void loadSecurityQuestion() {
        String query = "SELECT `sec_question` FROM `tb_users` WHERE `username` = ?";
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    question.setText("Validation question: " + rs.getString("sec_question"));
                } else {
                    JOptionPane.showMessageDialog(this, "No security question found for the user.");
                    dispose();
                    new LoginForm().setVisible(true);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForgotPassword2.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "An error occurred while loading the security question.");
        }
    }

    private void setupAnswerFieldListener() {
        secanswer_field.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { toggleProceedButton(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { toggleProceedButton(); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { toggleProceedButton(); }
        });
    }

    private void toggleProceedButton() {
        String answer = secanswer_field.getText().trim();
        proceed_btn.setEnabled(!answer.isEmpty());
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
            java.util.logging.Logger.getLogger(ForgotPassword2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                java.awt.EventQueue.invokeLater(() -> {
                    new ForgotPassword2("user").setVisible(true);
                });
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel answer;
    private javax.swing.JLabel answer1;
    private javax.swing.JButton back_btn;
    private javax.swing.JButton exit_btn;
    private Resources.panel.PanelMover mover;
    private Resources.panel.PanelBorder panelBorder1;
    private javax.swing.JButton proceed_btn;
    private javax.swing.JLabel question;
    private javax.swing.JTextField secanswer_field;
    // End of variables declaration//GEN-END:variables
}
