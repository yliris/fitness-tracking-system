package Account;

import Content.Home;
import Resources.components.DatabaseConnection;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Arrays;

public class UserEditForm extends javax.swing.JFrame {

    private Home home;
    private int userId;
    private String originalFirstname, originalLastname, originalEmail, originalUsername;
    private int originalAge;
    private String originalSex;
    private float originalWeight, originalHeight;

    public UserEditForm(Home home, int userId) {
        initComponents();
        this.home = home;
        this.userId = userId;
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(UserEditForm.this);
        Image icon = new ImageIcon(this.getClass().getResource("/Resources/elements/fts-icon.png")).getImage();
        this.setIconImage(icon);
        ButtonGroup sexRdb = new ButtonGroup();
        sexRdb.add(male_rdb);
        sexRdb.add(female_rdb);
        populateUserDetails(userId);
    }

    private void populateUserDetails(int userId) {
        String query = "SELECT * FROM tb_users WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    originalFirstname = rs.getString("first_name");
                    originalLastname = rs.getString("last_name");
                    originalEmail = rs.getString("email");
                    originalUsername = rs.getString("username");
                    originalAge = rs.getInt("age");
                    originalSex = rs.getString("sex");
                    originalWeight = rs.getFloat("weight");
                    originalHeight = rs.getFloat("height");

                    firstname_field.setText(originalFirstname);
                    lastname_field.setText(originalLastname);
                    email_field.setText(originalEmail);
                    username_field.setText(originalUsername);
                    age_field.setText(String.valueOf(originalAge));

                    if ("Male".equalsIgnoreCase(originalSex)) {
                        male_rdb.setSelected(true);
                    } else {
                        female_rdb.setSelected(true);
                    }

                    weight_field.setText(String.valueOf(originalWeight));
                    height_field.setText(String.valueOf(originalHeight));
                } else {
                    JOptionPane.showMessageDialog(this, "No user found with ID: " + userId, "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while fetching user details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        edit_background.setBackground(new java.awt.Color(234, 234, 255));
        edit_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        label1.setText("Edit Your Info");
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
        update_btn.setText("SAVE CHANGES");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });
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
        dispose();
    }//GEN-LAST:event_exit_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        String firstname = firstname_field.getText().trim();
        String lastname = lastname_field.getText().trim();
        String email = email_field.getText().trim();
        String username = username_field.getText().trim();
        String ageText = age_field.getText().trim();
        String sex = male_rdb.isSelected() ? "Male" : "Female";
        String weightText = weight_field.getText().trim();
        String heightText = height_field.getText().trim();

        //CHECK IF NO CHANGES WERE MADE
        if (firstname.equals(originalFirstname) && lastname.equals(originalLastname) && email.equals(originalEmail)
                && username.equals(originalUsername) && Integer.parseInt(ageText) == originalAge
                && sex.equals(originalSex) && Float.parseFloat(weightText) == originalWeight
                && Float.parseFloat(heightText) == originalHeight) {

            int confirmExit = JOptionPane.showConfirmDialog(this, "No changes were made. Do you want to exit the form?", null, JOptionPane.YES_NO_OPTION);
            if (confirmExit == JOptionPane.YES_OPTION) {
                dispose();
            }
            return;
        }
        //CHECK IF FIELDS ARE EMPTY
        if (firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || username.isEmpty()
                || ageText.isEmpty() || weightText.isEmpty() || heightText.isEmpty() || sex == null) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
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
            return;
        }
        if (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(null, "Invalid email address.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
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
        String[] reservedUsernames = {"admin1", "admin2", "admin3", "admin4", "admin5"};
        if (Arrays.asList(reservedUsernames).contains(username)) {
            JOptionPane.showMessageDialog(null, "This username is already taken", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF AGE IS VALID
        int age = 0;
        try {
            age = Integer.parseInt(ageText);
            if (age <= 0) {
                JOptionPane.showMessageDialog(this, "Age must be a positive number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for age.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF WEIGHT AND HEIGHT ARE VALID
        float weight = 0;
        try {
            weight = Float.parseFloat(weightText);
            if (weight <= 0) {
                JOptionPane.showMessageDialog(this, "Weight must be a positive number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for weight.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        float height = 0;
        try {
            height = Float.parseFloat(heightText);
            if (height <= 0) {
                JOptionPane.showMessageDialog(this, "Height must be a positive number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for height.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //NO SQL INJECTION OR HTML TAGS
        if (username.matches(".*<.*>.*") || firstname.matches(".*<.*>.*") || lastname.matches(".*<.*>.*")) {
            JOptionPane.showMessageDialog(null, "Fields cannot contain HTML tags.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String BMI = "";
        String classification = "";
        String healthyRange = "";
        String weightNeeds = "";
        if (weight > 0 && height > 0) {
            float meterHeight = height / 100;
            float bmiValue = weight / (meterHeight * meterHeight);
            BMI = String.format("%.1f", bmiValue) + " kg/m²";

            if (age >= 20) {
                if (bmiValue < 18.5) {
                    classification = "Underweight";
                } else if (bmiValue >= 18.5 && bmiValue <= 24.9) {
                    classification = "Normal Weight";
                } else if (bmiValue >= 25 && bmiValue <= 29.9) {
                    classification = "Overweight";
                } else if (bmiValue >= 30) {
                    classification = "Obese";
                } else {
                    classification = "BMI out of valid range";
                }
            } else if (age >= 2 && age < 20) {
                if (bmiValue < 5) {
                    classification = "Underweight";
                } else if (bmiValue >= 5 && bmiValue < 85) {
                    classification = "Healthy Weight";
                } else if (bmiValue >= 85 && bmiValue < 95) {
                    classification = "Risk of Overweight";
                } else if (bmiValue >= 95) {
                    classification = "Overweight";
                } else {
                    classification = "BMI out of valid range";
                }
            } else {
                classification = "Invalid age for BMI calculation";
            }

            float minBMI = 18.5f;
            float maxBMI = 24.9f;
            healthyRange = String.format("%.1f", minBMI * meterHeight * meterHeight) + " - "
                    + String.format("%.1f", maxBMI * meterHeight * meterHeight) + " kg";

            if (bmiValue < minBMI) {
                float weightToGain = minBMI * meterHeight * meterHeight - weight;
                weightNeeds = "Recommendation: Gain " + String.format("%.2f", weightToGain) + " kg to reach a healthy weight.";
            } else if (bmiValue > maxBMI) {
                float weightToLose = weight - maxBMI * meterHeight * meterHeight;
                weightNeeds = "Recommendation: Lose " + String.format("%.2f", weightToLose) + " kg to reach a healthy weight.";
            } else {
                weightNeeds = "Your weight is within the healthy range!";
            }
        } else {
            classification = "Invalid weight or height values.";
            weightNeeds = "Cannot calculate recommendations.";
        }

        PreparedStatement ps;
        ResultSet rs;
        String checkNameQuery = "SELECT * FROM tb_users WHERE first_name = ? AND last_name = ?";
        String checkEmailQuery = "SELECT * FROM tb_users WHERE email = ?";
        String checkUsernameQuery = "SELECT * FROM tb_users WHERE username = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            String updateQuery = "UPDATE tb_users SET first_name = ?, last_name = ?, email = ?, username = ?, age = ?, sex = ?, weight = ?, height = ?, bmi = ?, classification = ? WHERE user_id = ?";
            ps = conn.prepareStatement(updateQuery);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, email);
            ps.setString(4, username);
            ps.setInt(5, age);
            ps.setString(6, sex);
            ps.setFloat(7, weight);
            ps.setFloat(8, height);
            ps.setString(9, BMI);
            ps.setString(10, classification);
            ps.setInt(11, userId);

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "User details updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                String fullName = firstname + " " + lastname;
                home.updateUserDetails(username, fullName, email, weight, height);
                home.updateProfileIcon(sex);
                home.updateUserBMI(BMI, classification, healthyRange, weightNeeds);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Update failed. User not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while updating user details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_update_btnActionPerformed

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
            java.util.logging.Logger.getLogger(UserEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        int userId = 1;
        Home home = new Home(userId);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserEditForm(home, userId).setVisible(true);
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
