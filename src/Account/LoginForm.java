package Account;

import Connection.DatabaseConnection;
import Home.AdminHome;
import Home.UserHome;
import java.awt.Color;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LoginForm extends javax.swing.JFrame {

    public LoginForm() {
        initComponents();
        user_login_btn.setEnabled(false);
        setupLoginButtonListener();
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(LoginForm.this);
        Image icon = new ImageIcon(this.getClass().getResource("/Resources/elements/fts-icon.png")).getImage();
        this.setIconImage(icon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        element = new javax.swing.JLabel();
        message = new javax.swing.JLabel();
        panelBorder1 = new Resources.panel.PanelBorder();
        username_field = new javax.swing.JTextField();
        password_field = new javax.swing.JPasswordField();
        login_message = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        signup_message = new javax.swing.JLabel();
        or = new javax.swing.JLabel();
        admin_message = new javax.swing.JLabel();
        forgot_pass_btn = new javax.swing.JButton();
        user_login_btn = new javax.swing.JButton();
        signup_btn = new javax.swing.JButton();
        admin_login_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        panelBorder2 = new Resources.panel.PanelBorder();
        mover = new Resources.panel.PanelMover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        element.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/login-element.png"))); // NOI18N
        getContentPane().add(element, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 280, -1));

        message.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        message.setForeground(new java.awt.Color(255, 255, 255));
        message.setText("Welcome Back!");
        getContentPane().add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 300, -1));

        password_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 300, -1));

        login_message.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        login_message.setText("Login to your Account");
        panelBorder1.add(login_message, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        username.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        username.setText("Username");
        panelBorder1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 125, -1, -1));

        password.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        password.setText("Password");
        panelBorder1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 185, -1, -1));

        signup_message.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        signup_message.setText("Don't have an account?");
        panelBorder1.add(signup_message, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        or.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        or.setForeground(new java.awt.Color(153, 153, 153));
        or.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        or.setText("Or");
        panelBorder1.add(or, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 386, 20, -1));

        admin_message.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        admin_message.setText("Sign in as");
        panelBorder1.add(admin_message, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 435, -1, -1));

        forgot_pass_btn.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        forgot_pass_btn.setText("Forgot Password?");
        forgot_pass_btn.setBorder(null);
        forgot_pass_btn.setBorderPainted(false);
        forgot_pass_btn.setContentAreaFilled(false);
        forgot_pass_btn.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        forgot_pass_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forgot_pass_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgot_pass_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                forgot_pass_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                forgot_pass_btnMouseReleased(evt);
            }
        });
        forgot_pass_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgot_pass_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(forgot_pass_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 100, 20));

        user_login_btn.setBackground(new java.awt.Color(102, 102, 255));
        user_login_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        user_login_btn.setForeground(new java.awt.Color(255, 255, 255));
        user_login_btn.setText("SIGN IN");
        user_login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_login_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(user_login_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 300, -1));

        signup_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        signup_btn.setForeground(new java.awt.Color(10, 177, 52));
        signup_btn.setText("Sign Up");
        signup_btn.setBorder(null);
        signup_btn.setBorderPainted(false);
        signup_btn.setContentAreaFilled(false);
        signup_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signup_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signup_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                signup_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                signup_btnMouseReleased(evt);
            }
        });
        signup_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(signup_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, -1, -1));

        admin_login_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        admin_login_btn.setForeground(new java.awt.Color(91, 91, 255));
        admin_login_btn.setText("Admin");
        admin_login_btn.setBorder(null);
        admin_login_btn.setBorderPainted(false);
        admin_login_btn.setContentAreaFilled(false);
        admin_login_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                admin_login_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                admin_login_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                admin_login_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                admin_login_btnMouseReleased(evt);
            }
        });
        admin_login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_login_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(admin_login_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 435, -1, -1));

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
        panelBorder1.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 5, 30, 30));
        panelBorder1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 140, 10));
        panelBorder1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 140, 10));

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 420, 480));

        panelBorder2.setBackground(new java.awt.Color(153, 153, 255));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 480));
        getContentPane().add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 20));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void forgot_pass_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgot_pass_btnActionPerformed
        new ForgotPassword1().setVisible(true);
    }//GEN-LAST:event_forgot_pass_btnActionPerformed

    private void signup_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_btnActionPerformed
        new SignupForm().setVisible(true);
        dispose();
    }//GEN-LAST:event_signup_btnActionPerformed

    private void user_login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_login_btnActionPerformed
        PreparedStatement ps;
        ResultSet rs;

        String username = username_field.getText().trim();
        String password = String.valueOf(password_field.getPassword()).trim();

        String loginQuery = "SELECT * FROM `tb_users` WHERE `username` =? AND `password` =?";

        try {
            ps = DatabaseConnection.getConnection().prepareStatement(loginQuery);
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();
            if(rs.next()) {
                JOptionPane.showMessageDialog(null, "Login Success!");
                dispose();
                new UserHome().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password.");
                username_field.setText("");
                password_field.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_user_login_btnActionPerformed
    
    //IF FIELDS ARE EMPTY, THEN LOGIN BUTTON IS DISABLED AND VICE VERSA
    private void setupLoginButtonListener() {
        javax.swing.event.DocumentListener documentListener = new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { toggleLoginButton(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { toggleLoginButton(); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { toggleLoginButton(); }
        };
        username_field.getDocument().addDocumentListener(documentListener);
        password_field.getDocument().addDocumentListener(documentListener);
    }
    
    private void toggleLoginButton() {
        String username = username_field.getText().trim();
        String password = String.valueOf(password_field.getPassword()).trim();
        user_login_btn.setEnabled(!username.isEmpty() && !password.isEmpty());
    }
    
    private void signup_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signup_btnMouseEntered
        signup_btn.setForeground(new Color(6,115,33));
    }//GEN-LAST:event_signup_btnMouseEntered

    private void signup_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signup_btnMouseExited
        signup_btn.setForeground(new Color(10,177,52));
    }//GEN-LAST:event_signup_btnMouseExited

    private void signup_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signup_btnMousePressed
        signup_btn.setForeground(new Color(5,96,28));
    }//GEN-LAST:event_signup_btnMousePressed

    private void signup_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signup_btnMouseReleased
        signup_btn.setForeground(new Color(6,115,33));
    }//GEN-LAST:event_signup_btnMouseReleased

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        dispose();
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

    private void admin_login_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_login_btnMouseEntered
        admin_login_btn.setForeground(new Color(45,45,255));
    }//GEN-LAST:event_admin_login_btnMouseEntered

    private void admin_login_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_login_btnMouseExited
        admin_login_btn.setForeground(new Color(91,91,255));
    }//GEN-LAST:event_admin_login_btnMouseExited

    private void admin_login_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_login_btnMousePressed
        admin_login_btn.setForeground(new Color(0, 0, 198));
    }//GEN-LAST:event_admin_login_btnMousePressed

    private void admin_login_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_login_btnMouseReleased
        admin_login_btn.setForeground(new Color(45,45,255));
    }//GEN-LAST:event_admin_login_btnMouseReleased

    private void forgot_pass_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgot_pass_btnMouseEntered
        forgot_pass_btn.setForeground(new Color(102,102,102));
    }//GEN-LAST:event_forgot_pass_btnMouseEntered

    private void forgot_pass_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgot_pass_btnMouseExited
        forgot_pass_btn.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_forgot_pass_btnMouseExited

    private void forgot_pass_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgot_pass_btnMousePressed
        forgot_pass_btn.setForeground(new Color(51,51,51));
    }//GEN-LAST:event_forgot_pass_btnMousePressed

    private void forgot_pass_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgot_pass_btnMouseReleased
        forgot_pass_btn.setForeground(new Color(102,102,102));
    }//GEN-LAST:event_forgot_pass_btnMouseReleased

    private void admin_login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_login_btnActionPerformed
        String user = username_field.getText().trim();
        String password = String.valueOf(password_field.getPassword()).trim();

        if ("admin".equalsIgnoreCase(user) && "admin123".equals(password)) {
            JOptionPane.showMessageDialog(null, "Admin Login Success!");
            dispose();
            new AdminHome().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid admin credentials.");
        }
    }//GEN-LAST:event_admin_login_btnActionPerformed
    
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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton admin_login_btn;
    private javax.swing.JLabel admin_message;
    private javax.swing.JLabel element;
    private javax.swing.JButton exit_btn;
    private javax.swing.JButton forgot_pass_btn;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel login_message;
    private javax.swing.JLabel message;
    private Resources.panel.PanelMover mover;
    private javax.swing.JLabel or;
    private Resources.panel.PanelBorder panelBorder1;
    private Resources.panel.PanelBorder panelBorder2;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JButton signup_btn;
    private javax.swing.JLabel signup_message;
    private javax.swing.JButton user_login_btn;
    private javax.swing.JLabel username;
    private javax.swing.JTextField username_field;
    // End of variables declaration//GEN-END:variables
}
