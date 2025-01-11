package Resources.components;

import Home.AdminHome;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class EditInfoForm extends javax.swing.JFrame {

    private String originalFirstName;
    private String originalLastName;
    private String originalEmail;
    private String originalUsername;
    private int originalAge;
    private String originalSex;
    private float originalWeight;
    private float originalHeight;

    private AdminHome adminHome;

    public EditInfoForm(AdminHome adminHome, int userId, String firstName, String lastName, String email, String username, int age, String sex, float weight, float height) {
        this.adminHome = adminHome;
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(EditInfoForm.this);
        Image icon = new ImageIcon(this.getClass().getResource("/Resources/elements/fts-icon.png")).getImage();
        this.setIconImage(icon);
        ButtonGroup sexRdb = new ButtonGroup();
        sexRdb.add(male_rdb);
        sexRdb.add(female_rdb);

        originalFirstName = firstName;
        originalLastName = lastName;
        originalEmail = email;
        originalUsername = username;
        originalAge = age;
        originalSex = sex;
        originalWeight = weight;
        originalHeight = height;

        firstname_field.setText(firstName);
        lastname_field.setText(lastName);
        email_field.setText(email);
        username_field.setText(username);
        age_field.setText(String.valueOf(age));
        weight_field.setText(String.valueOf(weight));
        height_field.setText(String.valueOf(height));
        if ("Male".equalsIgnoreCase(sex)) {
            male_rdb.setSelected(true);
        } else if ("Female".equalsIgnoreCase(sex)) {
            female_rdb.setSelected(true);
        }

        update_btn.addActionListener(evt -> updateUserDetails(userId));
    }

    private void updateUserDetails(int userId) {
        String updatedFirstName = firstname_field.getText();
        String updatedLastName = lastname_field.getText();
        String updatedEmail = email_field.getText();
        String updatedUsername = username_field.getText();
        String updatedAge = age_field.getText();
        String updatedSex = male_rdb.isSelected() ? "Male" : (female_rdb.isSelected() ? "Female" : null);
        String updatedWeight = weight_field.getText();
        String updatedHeight = height_field.getText();

        //CHECK IF NOTHINGS CHANGES
        if (updatedFirstName.equals(originalFirstName)
                && updatedLastName.equals(originalLastName)
                && updatedEmail.equals(originalEmail)
                && updatedUsername.equals(originalUsername)
                && updatedSex.equals(originalSex)
                && updatedWeight.equals(String.valueOf(originalWeight))
                && updatedHeight.equals(String.valueOf(originalHeight))) {
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
        //CHECK IF WEIGHT AND HEIGHT ARE VALID
        try {
            float weight = Float.parseFloat(updatedWeight);
            if (weight <= 0 || weight > 300) {
                JOptionPane.showMessageDialog(this, "Weight must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Weight must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            float height = Float.parseFloat(updatedHeight);
            if (height <= 0 || height > 250) {
                JOptionPane.showMessageDialog(this, "Height must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Height must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //NO SQL INJECTION OR HTML TAGS
        if (updatedFirstName.contains("'") || updatedLastName.contains("'") || updatedEmail.contains("'") || updatedUsername.contains("'")) {
            JOptionPane.showMessageDialog(this, "Fields cannot contain HTML tags.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection conn = DatabaseConnection.getConnection();
            String updateQuery = "UPDATE tb_users SET first_name = ?, last_name = ?, email = ?, username = ?"
                    + ", sex = ?, weight = ?, height = ?  WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);

            stmt.setString(1, updatedFirstName);
            stmt.setString(2, updatedLastName);
            stmt.setString(3, updatedEmail);
            stmt.setString(4, updatedUsername);
            stmt.setString(5, updatedSex);
            stmt.setFloat(6, Float.parseFloat(updatedWeight));
            stmt.setFloat(7, Float.parseFloat(updatedHeight));
            stmt.setInt(8, userId);

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
        first_name = new javax.swing.JLabel();
        firstname_field = new javax.swing.JTextField();
        last_name = new javax.swing.JLabel();
        lastname_field = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        email_field = new javax.swing.JTextField();
        username = new javax.swing.JLabel();
        username_field = new javax.swing.JTextField();
        age = new javax.swing.JLabel();
        age_field = new javax.swing.JTextField();
        sex = new javax.swing.JLabel();
        female_rdb = new javax.swing.JRadioButton();
        male_rdb = new javax.swing.JRadioButton();
        weight = new javax.swing.JLabel();
        weight_field = new javax.swing.JTextField();
        age2 = new javax.swing.JLabel();
        height_field = new javax.swing.JTextField();
        update_btn = new javax.swing.JButton();
        mover = new Resources.components.PanelMover();

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
        panelBorder1.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 30, 30));

        first_name.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        first_name.setText("First Name:");
        panelBorder1.add(first_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, -1));
        panelBorder1.add(firstname_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 140, -1));

        last_name.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        last_name.setText("Last Name:");
        panelBorder1.add(last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 140, -1));
        panelBorder1.add(lastname_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 140, -1));

        email.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        email.setText("Email:");
        panelBorder1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));
        panelBorder1.add(email_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 290, -1));

        username.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        username.setText("Username:");
        panelBorder1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));
        panelBorder1.add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 290, -1));

        age.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        age.setText("Age:");
        panelBorder1.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));
        panelBorder1.add(age_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 140, -1));

        sex.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        sex.setText("Sex:");
        panelBorder1.add(sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 120, -1));

        female_rdb.setText("Female");
        panelBorder1.add(female_rdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        male_rdb.setText("Male");
        panelBorder1.add(male_rdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        weight.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        weight.setText("Weight:");
        panelBorder1.add(weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));
        panelBorder1.add(weight_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 140, -1));

        age2.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        age2.setText("Height:");
        panelBorder1.add(age2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, -1, -1));
        panelBorder1.add(height_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 140, -1));

        update_btn.setText("Update");
        panelBorder1.add(update_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, -1, -1));
        panelBorder1.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 20));

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 430));

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
            java.util.logging.Logger.getLogger(EditInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
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
                int age = 20;
                String sex = "Male";
                float weight = (float) 56.7;
                float height = (float) 177.4;
                new EditInfoForm(adminHome, userId, firstName, lastName, email, username, age, sex, weight, height).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel age;
    private javax.swing.JLabel age2;
    private javax.swing.JTextField age_field;
    private javax.swing.JLabel email;
    private javax.swing.JTextField email_field;
    private javax.swing.JButton exit_btn;
    private javax.swing.JRadioButton female_rdb;
    private javax.swing.JLabel first_name;
    private javax.swing.JTextField firstname_field;
    private javax.swing.JTextField height_field;
    private javax.swing.JLabel last_name;
    private javax.swing.JTextField lastname_field;
    private javax.swing.JRadioButton male_rdb;
    private Resources.components.PanelMover mover;
    private Resources.components.PanelBorder panelBorder1;
    private javax.swing.JLabel sex;
    private javax.swing.JButton update_btn;
    private javax.swing.JLabel username;
    private javax.swing.JTextField username_field;
    private javax.swing.JLabel weight;
    private javax.swing.JTextField weight_field;
    // End of variables declaration//GEN-END:variables

}
