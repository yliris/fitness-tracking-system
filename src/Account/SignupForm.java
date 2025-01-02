package Account;

import Connection.DatabaseConnection;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SignupForm extends javax.swing.JFrame {

    public SignupForm() {
        initComponents();
        signup_btn.setEnabled(false);
        setupSignupButtonListener();
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(SignupForm.this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new Resources.panel.PanelBorder();
        signup_btn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sec_question_field = new javax.swing.JTextField();
        last_name_field = new javax.swing.JTextField();
        password_field = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        first_name_field = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        email_field = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        sec_answer_field = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        username_field = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        panelBorder2 = new Resources.panel.PanelBorder();
        exit_btn = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        mover = new Resources.panel.PanelMover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signup_btn.setText("Sign up");
        signup_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(signup_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 350, -1));

        jLabel7.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel7.setText("Your Answer");
        panelBorder1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 345, -1, -1));

        jLabel6.setFont(new java.awt.Font("Consolas", 0, 9)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("(make sure to remember your answer)");
        panelBorder1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 347, -1, 10));

        sec_question_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(sec_question_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 350, -1));

        last_name_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(last_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 170, -1));

        password_field.setEchoChar('\u0000');
        panelBorder1.add(password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 350, -1));

        jLabel5.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel5.setText("Password");
        panelBorder1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 205, -1, -1));

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel2.setText("First Name");
        panelBorder1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 155, -1, -1));

        first_name_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(first_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 170, -1));

        jLabel9.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel9.setText("Last Name");
        panelBorder1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 155, -1, -1));

        email_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(email_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 350, -1));

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel3.setText("CvSU Email");
        panelBorder1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 55, -1, -1));

        sec_answer_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(sec_answer_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 350, -1));

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel4.setText("Create Account");
        panelBorder1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel8.setText("Your Question");
        panelBorder1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 295, -1, -1));

        jLabel10.setFont(new java.awt.Font("Consolas", 0, 9)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("(write your own question for password reset)");
        panelBorder1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 297, -1, 10));

        jLabel11.setFont(new java.awt.Font("Consolas", 0, 9)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Validation for password reset");
        panelBorder1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 268, 150, -1));
        panelBorder1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 100, 10));
        panelBorder1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 100, 10));

        username_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 350, -1));

        jLabel12.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel12.setText("Username");
        panelBorder1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 105, -1, -1));

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 460));

        panelBorder2.setBackground(new java.awt.Color(10, 177, 52));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        panelBorder2.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 5, 30, 30));

        back_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/back-idle.png"))); // NOI18N
        back_btn.setBorder(null);
        back_btn.setBorderPainted(false);
        back_btn.setContentAreaFilled(false);
        back_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                back_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                back_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                back_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                back_btnMouseReleased(evt);
            }
        });
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        panelBorder2.add(back_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 5, -1, -1));

        jLabel1.setText("element");
        panelBorder2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel13.setText("logo");
        panelBorder2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, -1, -1));

        getContentPane().add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 220, 460));
        getContentPane().add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 20));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signup_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_btnActionPerformed
        String email = email_field.getText().trim();
        String username = username_field.getText().trim();
        String firstname = first_name_field.getText().trim();
        String lastname = last_name_field.getText().trim();
        String password = String.valueOf(password_field.getPassword()).trim();
        String sec_question = sec_question_field.getText().trim();
        String sec_answer = sec_answer_field.getText().trim();

        //CHECK IF ALL FIELDS ARE EMPTY
        if (email.isEmpty() && firstname.isEmpty() && lastname.isEmpty() && username.isEmpty() &&
                password.isEmpty() && sec_question.isEmpty() && sec_answer.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are empty. Please fill in the form.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF SOME FIELDS ARE EMPTY
        if (email.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || username.isEmpty() ||
                password.isEmpty() || sec_question.isEmpty() || sec_answer.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please complete all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF EMAIL IS @CVSU.EDU.PH
        if(!email.endsWith("@cvsu.edu.ph")){
            JOptionPane.showMessageDialog(this, "Email is invalid. Make sure that it is a CvSU email.", "Invalid Email", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        PreparedStatement ps;
        ResultSet rs;
        
        String checkEmailQuery = "SELECT * FROM `tb_users` WHERE `cvsu_email` = ?";
        String checkUsernameQuery = "SELECT * FROM `tb_users` WHERE `username` = ?";
        String checkNameQuery = "SELECT * FROM `tb_users` WHERE `first_name` = ? AND `last_name` = ?";
        
        try {
            //CHECK FOR EXISTING EMAIL
            ps = DatabaseConnection.getConnection().prepareStatement(checkEmailQuery);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(this, "Email already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //CHECK FOR EXISTING USERNAME
            ps = DatabaseConnection.getConnection().prepareStatement(checkUsernameQuery);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Username already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //CHECK FOR EXISTING FIRST AND LAST NAME
            ps = DatabaseConnection.getConnection().prepareStatement(checkNameQuery);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "First and last name already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //INSERT NEW USER TO DATABASE
            String insertQuery = "INSERT INTO `tb_users`(`cvsu_email`, `username`, `first_name`, `last_name`, `password`, `sec_question`, `sec_answer`)"
                    + "VALUES (?,?,?,?,?,?,?)";
            ps = DatabaseConnection.getConnection().prepareStatement(insertQuery);
            ps.setString(1, email);
            ps.setString(2, username);
            ps.setString(3, firstname);
            ps.setString(4, lastname);
            ps.setString(5, password);
            ps.setString(6, sec_question);
            ps.setString(7, sec_answer);
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "New user added!");
                email_field.setText("");
                username_field.setText("");
                first_name_field.setText("");
                last_name_field.setText("");
                password_field.setText("");
                sec_question_field.setText("");
                sec_answer_field.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SignupForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_signup_btnActionPerformed

    private void setupSignupButtonListener() {
        javax.swing.event.DocumentListener documentListener = new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { toggleLoginButton(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { toggleLoginButton(); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { toggleLoginButton(); }
        };
        email_field.getDocument().addDocumentListener(documentListener);
        username_field.getDocument().addDocumentListener(documentListener);
        first_name_field.getDocument().addDocumentListener(documentListener);
        last_name_field.getDocument().addDocumentListener(documentListener);
        password_field.getDocument().addDocumentListener(documentListener);
        sec_question_field.getDocument().addDocumentListener(documentListener);
        sec_answer_field.getDocument().addDocumentListener(documentListener);
    }
    
    private void toggleLoginButton() {
        String email = email_field.getText().trim();
        String username = username_field.getText().trim();
        String firstname = first_name_field.getText().trim();
        String lastname = last_name_field.getText().trim();
        String password = String.valueOf(password_field.getPassword()).trim();
        String secQuestion = sec_question_field.getText().trim();
        String secAnswer = sec_answer_field.getText().trim();
        signup_btn.setEnabled(
            !email.isEmpty() && !username.isEmpty() &&
            !firstname.isEmpty() && !lastname.isEmpty() &&
            !password.isEmpty() && !secQuestion.isEmpty() &&
            !secAnswer.isEmpty());
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
        dispose();
    }//GEN-LAST:event_exit_btnActionPerformed

    private void back_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_btnMouseEntered
        back_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/back-hover.png")));
    }//GEN-LAST:event_back_btnMouseEntered

    private void back_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_btnMouseExited
        back_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/back-idle.png")));
    }//GEN-LAST:event_back_btnMouseExited

    private void back_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_btnMousePressed
        back_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/back-click.png")));
    }//GEN-LAST:event_back_btnMousePressed

    private void back_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_btnMouseReleased
        back_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/back-hover.png")));
    }//GEN-LAST:event_back_btnMouseReleased

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        new LoginForm().setVisible(true);
        dispose();
    }//GEN-LAST:event_back_btnActionPerformed
    
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
            java.util.logging.Logger.getLogger(SignupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JTextField email_field;
    private javax.swing.JButton exit_btn;
    private javax.swing.JTextField first_name_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField last_name_field;
    private Resources.panel.PanelMover mover;
    private Resources.panel.PanelBorder panelBorder1;
    private Resources.panel.PanelBorder panelBorder2;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JTextField sec_answer_field;
    private javax.swing.JTextField sec_question_field;
    private javax.swing.JButton signup_btn;
    private javax.swing.JTextField username_field;
    // End of variables declaration//GEN-END:variables
}
