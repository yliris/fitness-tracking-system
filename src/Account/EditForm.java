package Account;

import Connection.DatabaseConnection;
import Home.AdminHome;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EditForm extends javax.swing.JFrame {

    private String originalFirstName;
    private String originalLastName;
    private String originalEmail;
    private String originalUsername;

    private AdminHome adminHome;

    public EditForm(AdminHome adminHome, int userId, String firstName, String lastName, String email, String username) {
        this.adminHome = adminHome;
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(EditForm.this);

        originalFirstName = firstName;
        originalLastName = lastName;
        originalEmail = email;
        originalUsername = username;

        firstname_field.setText(firstName);
        lastname_field.setText(lastName);
        email_field.setText(email);
        username_field.setText(username);

        update_btn.addActionListener(evt -> updateUserDetails(userId));
    }

    private void updateUserDetails(int userId) {
        String updatedFirstName = firstname_field.getText();
        String updatedLastName = lastname_field.getText();
        String updatedEmail = email_field.getText();
        String updatedUsername = username_field.getText();

        //CHECK IF NOTHINGS CHANGES
        if (updatedFirstName.equals(originalFirstName)
                && updatedLastName.equals(originalLastName)
                && updatedEmail.equals(originalEmail)
                && updatedUsername.equals(originalUsername)) {
            int confirmExit = JOptionPane.showConfirmDialog(null,
                    "No changes were made. Exit the form?",
                    "Exit",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (confirmExit == JOptionPane.YES_OPTION) {
                dispose();
                return;
            } else {
                return;
            }
        }
        //CHECK IF FIRST AND LAST NAME HAS INVALID CHARACTERS
        if (!updatedFirstName.matches("^[a-zA-Z-]+$")) {
            JOptionPane.showMessageDialog(this, "First name must only contain letters, spaces, or hyphens.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!updatedLastName.matches("^[a-zA-Z-]+$")) {
            JOptionPane.showMessageDialog(this, "First name must only contain letters, spaces, or hyphens.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF FIRST AND LAST NAME EXISTS
        if (isNameExists(updatedFirstName, updatedLastName, userId)) {
            JOptionPane.showMessageDialog(this, "First and last name already exists.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF EMAIL IS INVALID
        if (!updatedEmail.endsWith("@gmail.com")) {
            JOptionPane.showMessageDialog(this, "Email is invalid.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //CHECK IF EMAIL ALREADY EXISTS
        if (isEmailExists(updatedEmail, userId)) {
            JOptionPane.showMessageDialog(this, "Email is already in use.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF USERNAME CONTAINS SPACE
        if (updatedUsername.contains(" ")) {
            JOptionPane.showMessageDialog(this, "Username cannot contain spaces.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF USERNAME IS 16 AND BELOW
        if (updatedUsername.length() > 16) {
            JOptionPane.showMessageDialog(this, "Usernames must be 1-16 characters long.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF USERNAME HAS INVALID CHARACTERS
        if (!updatedUsername.matches("^[a-zA-Z0-9._-]+$")) {
            JOptionPane.showMessageDialog(this, "Only periods, underscores, and dashes are allowed.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF USERNAME HAS ADMIN CREDENTIALS
        if (updatedUsername.equals("admin1") || updatedUsername.equals("admin2") || updatedUsername.equals("admin3") || updatedUsername.equals("admin4") || updatedUsername.equals("admin5")) {
            JOptionPane.showMessageDialog(this, "This username is already taken", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //NO SQL INJECTION OR HTML TAGS
        if (updatedFirstName.contains("'") || updatedLastName.contains("'") || updatedEmail.contains("'") || updatedUsername.contains("'")) {
            JOptionPane.showMessageDialog(this, "Fields cannot contain HTML tags.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection conn = DatabaseConnection.getConnection();
            String updateQuery = "UPDATE tb_users SET first_name = ?, last_name = ?, email = ?, username = ? WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);

            stmt.setString(1, updatedFirstName);
            stmt.setString(2, updatedLastName);
            stmt.setString(3, updatedEmail);
            stmt.setString(4, updatedUsername);
            stmt.setInt(5, userId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "User details updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                adminHome.refreshUserTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update user details.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error updating user details: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isEmailExists(String email, int userId) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT * FROM tb_users WHERE email = ? AND user_id != ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setInt(2, userId);

            ResultSet rs = stmt.executeQuery();
            boolean exists = rs.next();
            rs.close();
            stmt.close();
            conn.close();
            return exists;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private boolean isNameExists(String firstname, String lastname, int userId) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT * FROM tb_users WHERE first_name = ? AND last_name = ? AND user_id != ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, firstname);
            stmt.setString(2, lastname);
            stmt.setInt(3, userId);

            ResultSet rs = stmt.executeQuery();
            boolean exists = rs.next();
            rs.close();
            stmt.close();
            conn.close();
            return exists;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new Resources.components.PanelBorder();
        exit_btn = new javax.swing.JButton();
        mover = new Resources.components.PanelMover();
        email_field = new javax.swing.JTextField();
        username_field = new javax.swing.JTextField();
        lastname_field = new javax.swing.JTextField();
        firstname_field = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        update_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        panelBorder1.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 5, 30, 30));
        panelBorder1.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 20));
        panelBorder1.add(email_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 370, -1));
        panelBorder1.add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 370, -1));
        panelBorder1.add(lastname_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 180, -1));
        panelBorder1.add(firstname_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 180, -1));

        jLabel4.setText("email");
        panelBorder1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel1.setText("last name");
        panelBorder1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jLabel2.setText("username");
        panelBorder1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel3.setText("first name");
        panelBorder1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        update_btn.setText("Update");
        panelBorder1.add(update_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, -1));

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(EditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        AdminHome adminHome = new AdminHome();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int userId = 1;
                String firstName = "John";
                String lastName = "Doe";
                String email = "johndoe@example.com";
                String username = "johndoe123";
                new EditForm(adminHome, userId, firstName, lastName, email, username).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email_field;
    private javax.swing.JButton exit_btn;
    private javax.swing.JTextField firstname_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField lastname_field;
    private Resources.components.PanelMover mover;
    private Resources.components.PanelBorder panelBorder1;
    private javax.swing.JButton update_btn;
    private javax.swing.JTextField username_field;
    // End of variables declaration//GEN-END:variables

}
