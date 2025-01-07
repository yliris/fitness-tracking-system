package Account;

import Connection.DatabaseConnection;
import java.awt.Color;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class SignupForm extends javax.swing.JFrame {

    public SignupForm() {
        initComponents();
        signup_btn.setEnabled(false);
        setupSignupButtonListener();
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(SignupForm.this);
        Image icon = new ImageIcon(this.getClass().getResource("/Resources/elements/fts-icon.png")).getImage();
        this.setIconImage(icon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        element = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelBorder1 = new Resources.components.PanelBorder();
        password_check = new javax.swing.JToggleButton();
        first_name_field = new javax.swing.JTextField();
        last_name_field = new javax.swing.JTextField();
        email_field = new javax.swing.JTextField();
        username_field = new javax.swing.JTextField();
        password_field = new javax.swing.JPasswordField();
        sec_question_field = new javax.swing.JTextField();
        sec_answer_field = new javax.swing.JTextField();
        create_account = new javax.swing.JLabel();
        first_name = new javax.swing.JLabel();
        last_name = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        question = new javax.swing.JLabel();
        question_guide = new javax.swing.JLabel();
        answer = new javax.swing.JLabel();
        answer_guide = new javax.swing.JLabel();
        validation = new javax.swing.JLabel();
        signup_btn = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        panelBorder2 = new Resources.components.PanelBorder();
        back_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        mover = new Resources.components.PanelMover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        element.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/signup-element.png"))); // NOI18N
        getContentPane().add(element, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Unlock Your Potential!");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 35, -1, -1));

        jLabel2.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Track Your Progress!");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 75, -1, -1));

        jLabel3.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Achieve Your Goals!");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 445, -1, -1));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        panelBorder1.add(password_check, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 234, 20, 20));

        first_name_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(first_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 160, -1));

        last_name_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(last_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 160, -1));

        email_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(email_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 330, -1));

        username_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 330, -1));

        password_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 330, -1));

        sec_question_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(sec_question_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 330, -1));

        sec_answer_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(sec_answer_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 330, -1));

        create_account.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        create_account.setText("Create Account");
        panelBorder1.add(create_account, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        first_name.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        first_name.setText("First Name");
        panelBorder1.add(first_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, -1, -1));

        last_name.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        last_name.setText("Last Name");
        panelBorder1.add(last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 65, -1, -1));

        email.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        email.setText("Email");
        panelBorder1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 115, -1, -1));

        username.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        username.setText("Username");
        panelBorder1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 165, -1, -1));

        password.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        password.setText("Password");
        panelBorder1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 215, -1, -1));

        question.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        question.setText("Your Question");
        panelBorder1.add(question, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 305, -1, -1));

        question_guide.setFont(new java.awt.Font("Cascadia Mono", 0, 9)); // NOI18N
        question_guide.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        question_guide.setText("(write your own question for password reset)");
        panelBorder1.add(question_guide, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, -1, 10));

        answer.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        answer.setText("Your Answer");
        panelBorder1.add(answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 355, -1, -1));

        answer_guide.setFont(new java.awt.Font("Cascadia Mono", 0, 9)); // NOI18N
        answer_guide.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        answer_guide.setText("(make sure to remember your answer)");
        panelBorder1.add(answer_guide, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 360, -1, 10));

        validation.setFont(new java.awt.Font("Cascadia Mono", 0, 9)); // NOI18N
        validation.setForeground(new java.awt.Color(153, 153, 153));
        validation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        validation.setText("Validation for Password Reset");
        panelBorder1.add(validation, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 279, 150, -1));

        signup_btn.setBackground(new java.awt.Color(102, 102, 255));
        signup_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        signup_btn.setForeground(new java.awt.Color(255, 255, 255));
        signup_btn.setText("SIGN UP");
        signup_btn.setAlignmentY(0.0F);
        signup_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(signup_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 330, -1));
        panelBorder1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 283, 90, 10));
        panelBorder1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 283, 80, 10));

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 480));

        panelBorder2.setBackground(new java.awt.Color(153, 153, 255));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        panelBorder2.add(back_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 5, -1, -1));

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
        panelBorder2.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 5, 30, 30));

        getContentPane().add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 260, 480));
        getContentPane().add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 20));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        new LoginForm().setVisible(true);
        dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void back_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_btnMouseReleased
        back_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/back-hover.png")));
    }//GEN-LAST:event_back_btnMouseReleased

    private void back_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_btnMousePressed
        back_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/back-click.png")));
    }//GEN-LAST:event_back_btnMousePressed

    private void back_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_btnMouseExited
        back_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/back-idle.png")));
    }//GEN-LAST:event_back_btnMouseExited

    private void back_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_btnMouseEntered
        back_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/back-hover.png")));
    }//GEN-LAST:event_back_btnMouseEntered

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        int confirmExit = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to quit?",
                "Quit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmExit == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_exit_btnActionPerformed

    private void exit_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseReleased
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btnMouseReleased

    private void exit_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMousePressed
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-click.png")));
    }//GEN-LAST:event_exit_btnMousePressed

    private void exit_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseExited
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-idle.png")));
    }//GEN-LAST:event_exit_btnMouseExited

    private void exit_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseEntered
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btnMouseEntered

    private void signup_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_btnActionPerformed
        String firstname = first_name_field.getText().trim();
        String lastname = last_name_field.getText().trim();
        String email = email_field.getText().trim();
        String username = username_field.getText().trim();
        String password = String.valueOf(password_field.getPassword()).trim();
        String sec_question = sec_question_field.getText().trim();
        String sec_answer = sec_answer_field.getText().trim();

        //CHECK IF FIRST AND LAST NAME HAS INVALID CHARACTERS
        if (!firstname.matches("^[a-zA-Z]+([- ][a-zA-Z]+)*$")) {
            JOptionPane.showMessageDialog(null, "First name must only contain letters, spaces, or hyphens.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!lastname.matches("^[a-zA-Z]+([- ][a-zA-Z]+)*$")) {
            JOptionPane.showMessageDialog(null, "Last name must only contain letters, spaces, or hyphens.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF EMAIL IS VALID
        if (!email.endsWith("@gmail.com")) {
            JOptionPane.showMessageDialog(null, "Email is invalid.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        //CHECK IF USERNAME CONTAINS SPACE
        if (username.contains(" ")) {
            JOptionPane.showMessageDialog(null, "Usernames cannot contain spaces.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF USERNAME IS 16 AND BELOW
        if (username.length() > 16 || username.length() < 1) {
            JOptionPane.showMessageDialog(null, "Usernames must be 1-16 characters long.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF USERNAME HAS INVALID CHARACTERS
        if (!username.matches("^[a-zA-Z0-9._-]+$")) {
            JOptionPane.showMessageDialog(null, "Only periods, underscores, and dashes are allowed.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF USERNAME HAS ADMIN CREDENTIALS
        if (username.equals("admin1") || username.equals("admin2") || username.equals("admin3") ||
            username.equals("admin4") || username.equals("admin5")) {
            JOptionPane.showMessageDialog(null, "This username is already taken", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF PASSWORD IS STRONG
        if (password.length() < 8) {
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //NO SQL INJECTION OR HTML TAGS
        if (username.matches(".*<.*>.*") || firstname.matches(".*<.*>.*") || lastname.matches(".*<.*>.*")) {
            JOptionPane.showMessageDialog(null, "Fields cannot contain HTML tags.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PreparedStatement ps;
        ResultSet rs;

        String checkNameQuery = "SELECT * FROM `tb_users` WHERE `first_name` = ? AND `last_name` = ?";
        String checkEmailQuery = "SELECT * FROM `tb_users` WHERE `email` = ?";
        String checkUsernameQuery = "SELECT * FROM `tb_users` WHERE `username` = ?";

        try {
            //CHECK FOR EXISTING FIRST AND LAST NAME
            ps = DatabaseConnection.getConnection().prepareStatement(checkNameQuery);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "First and last name already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //CHECK FOR EXISTING EMAIL
            ps = DatabaseConnection.getConnection().prepareStatement(checkEmailQuery);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Email is already in use.", "Error", JOptionPane.ERROR_MESSAGE);
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

            //INSERT NEW USER TO DATABASE
            String insertQuery = "INSERT INTO `tb_users`"
                    + "(`first_name`, `last_name`, `email`, `username`, `password`, `sec_question`, `sec_answer`)"
                    + "VALUES (?,?,?,?,?,?,?)";
            ps = DatabaseConnection.getConnection().prepareStatement(insertQuery);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, email);
            ps.setString(4, username);
            ps.setString(5, password);
            ps.setString(6, sec_question);
            ps.setString(7, sec_answer);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "New user added!");
                first_name_field.setText("");
                last_name_field.setText("");
                email_field.setText("");
                username_field.setText("");
                password_field.setText("");
                sec_question_field.setText("");
                sec_answer_field.setText("");
                password_check.setSelected(false);
                password_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/eye-close.png")));
                password_field.setEchoChar('*');
            }
        } catch (SQLException ex) {
            Logger.getLogger(SignupForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_signup_btnActionPerformed

    private void password_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_checkActionPerformed
        if (password_check.isSelected()) {
            password_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/eye-open.png")));
            password_field.setEchoChar((char) 0);
        } else {
            password_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/eye-close.png")));
            password_field.setEchoChar('*');
        }
    }//GEN-LAST:event_password_checkActionPerformed

    private void setupSignupButtonListener() {
        javax.swing.event.DocumentListener documentListener = new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                toggleLoginButton();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                toggleLoginButton();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                toggleLoginButton();
            }
        };
        first_name_field.getDocument().addDocumentListener(documentListener);
        last_name_field.getDocument().addDocumentListener(documentListener);
        email_field.getDocument().addDocumentListener(documentListener);
        username_field.getDocument().addDocumentListener(documentListener);
        password_field.getDocument().addDocumentListener(documentListener);
        sec_question_field.getDocument().addDocumentListener(documentListener);
        sec_answer_field.getDocument().addDocumentListener(documentListener);
    }

    private void toggleLoginButton() {
        String firstname = first_name_field.getText().trim();
        String lastname = last_name_field.getText().trim();
        String email = email_field.getText().trim();
        String username = username_field.getText().trim();
        String password = String.valueOf(password_field.getPassword()).trim();
        String secQuestion = sec_question_field.getText().trim();
        String secAnswer = sec_answer_field.getText().trim();
        signup_btn.setEnabled(
                !firstname.isEmpty() && !lastname.isEmpty() &&
                !email.isEmpty() && !username.isEmpty() &&
                !password.isEmpty() && !secQuestion.isEmpty() &&
                !secAnswer.isEmpty());
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
    private javax.swing.JLabel answer;
    private javax.swing.JLabel answer_guide;
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel create_account;
    private javax.swing.JLabel element;
    private javax.swing.JLabel email;
    private javax.swing.JTextField email_field;
    private javax.swing.JButton exit_btn;
    private javax.swing.JLabel first_name;
    private javax.swing.JTextField first_name_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel last_name;
    private javax.swing.JTextField last_name_field;
    private Resources.components.PanelMover mover;
    private Resources.components.PanelBorder panelBorder1;
    private Resources.components.PanelBorder panelBorder2;
    private javax.swing.JLabel password;
    private javax.swing.JToggleButton password_check;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JLabel question;
    private javax.swing.JLabel question_guide;
    private javax.swing.JTextField sec_answer_field;
    private javax.swing.JTextField sec_question_field;
    private javax.swing.JButton signup_btn;
    private javax.swing.JLabel username;
    private javax.swing.JTextField username_field;
    private javax.swing.JLabel validation;
    // End of variables declaration//GEN-END:variables
}
