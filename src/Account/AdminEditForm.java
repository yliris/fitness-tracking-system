package Account;

import Home.AdminHome;
import Resources.components.DatabaseConnection;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AdminEditForm extends javax.swing.JFrame {

    private String originalFirstName;
    private String originalLastName;
    private String originalEmail;
    private String originalUsername;
    private int originalAge;
    private String originalSex;
    private float originalWeight;
    private float originalHeight;

    private AdminHome adminHome;

    public AdminEditForm(AdminHome adminHome, int editUserId, String editFirstName, String editLastName, String editEmail, String editUsername, int editAge, String editSex, float editWeight, float editHeight) {
        initComponents();
        this.adminHome = adminHome;
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(AdminEditForm.this);
        Image icon = new ImageIcon(this.getClass().getResource("/Resources/elements/fts-icon.png")).getImage();
        this.setIconImage(icon);
        ButtonGroup sexRdb = new ButtonGroup();
        sexRdb.add(male_rdb);
        sexRdb.add(female_rdb);

        originalFirstName = editFirstName;
        originalLastName = editLastName;
        originalEmail = editEmail;
        originalUsername = editUsername;
        originalAge = editAge;
        originalSex = editSex;
        originalWeight = editWeight;
        originalHeight = editHeight;

        firstname_field.setText(editFirstName);
        lastname_field.setText(editLastName);
        email_field.setText(editEmail);
        username_field.setText(editUsername);
        age_field.setText(String.valueOf(editAge));
        weight_field.setText(String.valueOf(editWeight));
        height_field.setText(String.valueOf(editHeight));
        if ("Male".equalsIgnoreCase(editSex)) {
            male_rdb.setSelected(true);
        } else if ("Female".equalsIgnoreCase(editSex)) {
            female_rdb.setSelected(true);
        }

        update_btn.addActionListener(evt -> updateUserDetails(editUserId));
    }

    private void updateUserDetails(int userId) {
        String updatedFirstName = firstname_field.getText();
        String updatedLastName = lastname_field.getText();
        String updatedEmail = email_field.getText();
        String updatedUsername = username_field.getText();
        String updatedAge = age_field.getText();
        String updatedSex = male_rdb.isSelected() ? "Male" : (female_rdb.isSelected() ? "Female" : null);
        String updatedWeight = weight_field.getText().replaceAll("[^0-9.]", "");
        String updatedHeight = height_field.getText().replaceAll("[^0-9.]", "");

        //CHECK IF NOTHING CHANGES
        boolean noChanges = true;
        noChanges &= updatedFirstName.trim().equals(originalFirstName.trim());
        noChanges &= updatedLastName.trim().equals(originalLastName.trim());
        noChanges &= updatedEmail.trim().equals(originalEmail.trim());
        noChanges &= updatedUsername.trim().equals(originalUsername.trim());
        noChanges &= (Integer.parseInt(updatedAge) == originalAge);
        noChanges &= updatedSex.trim().equals(originalSex.trim());
        noChanges &= (Float.parseFloat(updatedWeight) == originalWeight);
        noChanges &= (Float.parseFloat(updatedHeight) == originalHeight);
        if (noChanges) {
            int confirmExit = JOptionPane.showConfirmDialog(this, "No changes were made. Do you want to exit the form?", "", JOptionPane.YES_NO_OPTION);
            if (confirmExit == JOptionPane.YES_OPTION) {
                dispose();
                return;
            } else if (confirmExit == JOptionPane.NO_OPTION) {
                return;
            }
        }

        //CHECK IF ALL FIEDS ARE EMPTY
        if (updatedFirstName.trim().isEmpty() && updatedLastName.trim().isEmpty() && updatedEmail.trim().isEmpty()
                && updatedUsername.trim().isEmpty() && updatedAge.trim().isEmpty() && updatedWeight.trim().isEmpty()
                || updatedHeight.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled in.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF SOME FIELDS ARE EMPTY
        if (updatedFirstName.trim().isEmpty() || updatedLastName.trim().isEmpty() || updatedEmail.trim().isEmpty()
                || updatedUsername.trim().isEmpty() || updatedAge.trim().isEmpty() || updatedWeight.trim().isEmpty()
                || updatedHeight.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled in.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
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
        if (!updatedEmail.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(null, "Invalid email address.", "Input Error", JOptionPane.ERROR_MESSAGE);
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
        if (updatedUsername.length() < 1 && updatedUsername.length() > 16) {
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
        //CHECK IF AGE IS A VALID NUMBER
        try {
            int ageValue = Integer.parseInt(updatedAge);
            if (ageValue < 2 || ageValue > 120) {
                JOptionPane.showMessageDialog(this, "Please provide an age between 2 and 120.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF SEX IS SELECTED
        if (!male_rdb.isSelected() && !female_rdb.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select a gender.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF WEIGHT AND HEIGHT CONTAINS INVALID CHARACTERS
        if (!updatedWeight.matches("^[0-9.]+$")) {
            JOptionPane.showMessageDialog(this, "Weight must be a valid numeric value.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!updatedHeight.matches("^[0-9.]+$")) {
            JOptionPane.showMessageDialog(this, "Height must be a valid numeric value.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float weight;
        float height;
        try {
            weight = Float.parseFloat(updatedWeight);
            height = Float.parseFloat(updatedHeight) / 100;
            if (weight <= 0 || weight > 300 || height <= 0 || height > 2.5) {
                JOptionPane.showMessageDialog(this, "Invalid weight or height values.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Weight and height must be valid numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float bmi = weight / (height * height);
        String classification;

        int age = Integer.parseInt(updatedAge);
        if (age >= 20) {
            if (bmi < 18.5) {
                classification = "Underweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                classification = "Normal Weight";
            } else if (bmi >= 25 && bmi < 30) {
                classification = "Overweight";
            } else {
                classification = "Obese";
            }
        } else if (age >= 2 && age < 20) {
            if (bmi < 5) {
                classification = "Underweight";
            } else if (bmi >= 5 && bmi < 85) {
                classification = "Healthy Weight";
            } else if (bmi >= 85 && bmi < 95) {
                classification = "Risk of Overweight";
            } else {
                classification = "Overweight";
            }
        } else {
            classification = "N/A";
        }

        try {
            Connection conn = DatabaseConnection.getConnection();
            String updateQuery = "UPDATE tb_users SET first_name = ?, last_name = ?, email = ?, username = ?"
                    + ", age = ?, sex = ?, weight = ?, height = ?, bmi = ?, classification = ?  WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);

            stmt.setString(1, updatedFirstName);
            stmt.setString(2, updatedLastName);
            stmt.setString(3, updatedEmail);
            stmt.setString(4, updatedUsername);
            stmt.setInt(5, Integer.parseInt(updatedAge));
            stmt.setString(6, updatedSex);
            stmt.setFloat(7, weight);
            stmt.setFloat(8, height * 100);
            stmt.setFloat(9, bmi);
            stmt.setString(10, classification);
            stmt.setInt(11, userId);

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

        edit_background = new Resources.components.PanelBorder();
        label1 = new javax.swing.JLabel();
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
        exit_btn = new javax.swing.JButton();
        form_background = new javax.swing.JLabel();
        mover = new Resources.components.PanelMover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edit_background.setBackground(new java.awt.Color(255, 255, 255));
        edit_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        label1.setText("Edit User Info");
        edit_background.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 270, 50));

        first_name.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        first_name.setText("First Name:");
        edit_background.add(first_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, 140, -1));

        firstname_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        edit_background.add(firstname_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 140, -1));

        last_name.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        last_name.setText("Last Name:");
        edit_background.add(last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 65, 140, -1));

        lastname_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        edit_background.add(lastname_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 140, -1));

        email.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        email.setText("Email:");
        edit_background.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        email_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        edit_background.add(email_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 290, -1));

        username.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        username.setText("Username:");
        edit_background.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        username_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        edit_background.add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 290, -1));

        age.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        age.setText("Age:");
        edit_background.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        age_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        edit_background.add(age_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 140, -1));

        sex.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        sex.setText("Sex:");
        edit_background.add(sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 130, -1));

        female_rdb.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        female_rdb.setText("Female");
        edit_background.add(female_rdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, -1));

        male_rdb.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        male_rdb.setText("Male");
        edit_background.add(male_rdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, -1, -1));

        weight.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        weight.setText("Weight:");
        edit_background.add(weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        weight_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        edit_background.add(weight_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 140, -1));

        age2.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        age2.setText("Height:");
        edit_background.add(age2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, -1, -1));

        height_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        edit_background.add(height_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 130, -1));

        update_btn.setBackground(new java.awt.Color(102, 102, 255));
        update_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        update_btn.setForeground(new java.awt.Color(255, 255, 255));
        update_btn.setText("UPDATE");
        edit_background.add(update_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 290, -1));

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
        edit_background.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 5, 30, 30));

        form_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/admin-edit-element.png"))); // NOI18N
        edit_background.add(form_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 430));
        edit_background.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 10));

        getContentPane().add(edit_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 430));

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
            java.util.logging.Logger.getLogger(AdminEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        AdminHome adminHome = new AdminHome();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int editUserId = 1;
                String editFirstName = "John";
                String editLastName = "Doe";
                String editEmail = "johndoe@example.com";
                String editUsername = "johndoe123";
                int editAge = 1;
                String editSex = "Male";
                float editWeight = (float) 56.7;
                float editHeight = (float) 177.4;
                new AdminEditForm(adminHome, editUserId, editFirstName, editLastName, editEmail, editUsername, editAge, editSex, editWeight, editHeight).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel age;
    private javax.swing.JLabel age2;
    private javax.swing.JTextField age_field;
    private Resources.components.PanelBorder edit_background;
    private javax.swing.JLabel email;
    private javax.swing.JTextField email_field;
    private javax.swing.JButton exit_btn;
    private javax.swing.JRadioButton female_rdb;
    private javax.swing.JLabel first_name;
    private javax.swing.JTextField firstname_field;
    private javax.swing.JLabel form_background;
    private javax.swing.JTextField height_field;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel last_name;
    private javax.swing.JTextField lastname_field;
    private javax.swing.JRadioButton male_rdb;
    private Resources.components.PanelMover mover;
    private javax.swing.JLabel sex;
    private javax.swing.JButton update_btn;
    private javax.swing.JLabel username;
    private javax.swing.JTextField username_field;
    private javax.swing.JLabel weight;
    private javax.swing.JTextField weight_field;
    // End of variables declaration//GEN-END:variables

}
