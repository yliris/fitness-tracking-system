package Account;

import Connection.DatabaseConnection;
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back_btn = new javax.swing.JButton();
        question_label = new javax.swing.JLabel();
        sec_answer_field = new javax.swing.JTextField();
        proceed_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        back_btn.setText("back to login");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        question_label.setText("Validation question:");

        proceed_btn.setText("Proceed");
        proceed_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceed_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(sec_answer_field)
                .addGap(43, 43, 43))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(question_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back_btn)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(proceed_btn)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(question_label)
                .addGap(18, 18, 18)
                .addComponent(sec_answer_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(proceed_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
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

    private void proceed_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceed_btnActionPerformed
        String answer = sec_answer_field.getText().trim();

        if (answer.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please provide an answer.");
            return;
        }
        
        String query = "SELECT * FROM `tb_users` WHERE `username` = ? AND `security_answer` = ?";
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, answer);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Answer correct! Proceeding...");
                    new ForgotPassword3(username).setVisible(true);
                    dispose();
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
        String query = "SELECT `security_question` FROM `tb_users` WHERE `username` = ?";
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    question_label.setText("Validation question: " + rs.getString("security_question"));
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
        sec_answer_field.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { toggleProceedButton(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { toggleProceedButton(); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { toggleProceedButton(); }
        });
    }

    private void toggleProceedButton() {
        String answer = sec_answer_field.getText().trim();
        proceed_btn.setEnabled(!answer.isEmpty());
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
            public void run() {
                java.awt.EventQueue.invokeLater(() -> {
                    new ForgotPassword2("example_username").setVisible(true);
                });
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JButton proceed_btn;
    private javax.swing.JLabel question_label;
    private javax.swing.JTextField sec_answer_field;
    // End of variables declaration//GEN-END:variables
}
