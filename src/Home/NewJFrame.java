package Home;

import Account.LoginForm;
import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class NewJFrame extends javax.swing.JFrame {
    
    private int userId;

    public NewJFrame(int userId) {
        this.userId = userId;
        initComponents();
        loadUserData();
    }

    private void loadUserData() {
        String query = "SELECT first_name, last_name, email, username, age, weight, height FROM tb_users WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, this.userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                first_name.setText("First Name: " + rs.getString("first_name"));
                last_name.setText("Last Name: " + rs.getString("last_name"));
                email.setText("Email: " + rs.getString("email"));
                username.setText("Username: " + rs.getString("username"));

                int age = rs.getInt("age");
                float weight = rs.getFloat("weight");
                float height = rs.getFloat("height");

                if (age > 0) {
                    this.age.setText("Age: " + age);
                }
                if (weight > 0) {
                    this.weight.setText("Weight: " + weight);
                }
                if (height > 0) {
                    this.height.setText("Height: " + height);

                    float heightInMeters = height / 100;
                    float bmiValue = weight / (heightInMeters * heightInMeters);
                    this.bmi.setText("BMI: " + String.format("%.2f", bmiValue));
                }
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading user data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        age_field = new javax.swing.JTextField();
        weight_field = new javax.swing.JTextField();
        height_field = new javax.swing.JTextField();
        confirm_btn = new javax.swing.JButton();
        first_name = new javax.swing.JLabel();
        last_name = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        weight = new javax.swing.JLabel();
        height = new javax.swing.JLabel();
        bmi = new javax.swing.JLabel();
        profile_edit_btn = new javax.swing.JButton();
        profile_security_btn = new javax.swing.JButton();
        profile_delete_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        confirm_btn.setText("Confirm Button");
        confirm_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm_btnActionPerformed(evt);
            }
        });

        first_name.setText("first name");

        last_name.setText("last name");

        email.setText("email");

        username.setText("username");

        age.setText("age");

        weight.setText("weight");

        height.setText("height");

        bmi.setText("bmi");

        profile_edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-edit-idle-icon.png"))); // NOI18N
        profile_edit_btn.setBorder(null);
        profile_edit_btn.setBorderPainted(false);
        profile_edit_btn.setContentAreaFilled(false);
        profile_edit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile_edit_btnActionPerformed(evt);
            }
        });

        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-security-idle-icon.png"))); // NOI18N
        profile_security_btn.setBorder(null);
        profile_security_btn.setBorderPainted(false);
        profile_security_btn.setContentAreaFilled(false);
        profile_security_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile_security_btnActionPerformed(evt);
            }
        });

        profile_delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-delete-idle-icon.png"))); // NOI18N
        profile_delete_btn.setBorder(null);
        profile_delete_btn.setBorderPainted(false);
        profile_delete_btn.setContentAreaFilled(false);
        profile_delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile_delete_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(email)
                    .addComponent(last_name)
                    .addComponent(username)
                    .addComponent(age)
                    .addComponent(weight)
                    .addComponent(height)
                    .addComponent(bmi)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(first_name)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(age_field)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(weight_field, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(height_field, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addComponent(confirm_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                .addGap(140, 140, 140))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(profile_edit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(profile_security_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(profile_delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(first_name)
                .addGap(11, 11, 11)
                .addComponent(last_name)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(email))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(age_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(weight_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(height_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(age)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weight)
                    .addComponent(confirm_btn))
                .addGap(20, 20, 20)
                .addComponent(height)
                .addGap(14, 14, 14)
                .addComponent(bmi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profile_edit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profile_security_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profile_delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirm_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm_btnActionPerformed
        String ageText = age_field.getText();
        String weightText = weight_field.getText();
        String heightText = height_field.getText();

        if (ageText.isEmpty() || weightText.isEmpty() || heightText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int age = Integer.parseInt(ageText);
            float weight = Float.parseFloat(weightText);
            float height = Float.parseFloat(heightText);

            if (age <= 0 || weight <= 0 || height <= 0) {
                JOptionPane.showMessageDialog(this, "Age, weight, and height must be positive values.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            float heightInMeters = height / 100;
            float bmiValue = weight / (heightInMeters * heightInMeters);

            Connection conn = DatabaseConnection.getConnection();
            String updateQuery = "UPDATE tb_users SET age = ?, weight = ?, height = ? WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.setInt(1, age);
            stmt.setFloat(2, weight);
            stmt.setFloat(3, height);
            stmt.setInt(4, userId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Profile updated successfully!");

                this.age.setText("Age: " + age);
                this.weight.setText("Weight: " + weight);
                this.height.setText("Height: " + height);
                this.bmi.setText("BMI: " + String.format("%.2f", bmiValue));
            } else {
                JOptionPane.showMessageDialog(this, "Profile update failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            stmt.close();
            conn.close();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for age, weight, and height.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_confirm_btnActionPerformed

    private void profile_edit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_edit_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profile_edit_btnActionPerformed

    private void profile_security_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_security_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profile_security_btnActionPerformed

    private void profile_delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_delete_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profile_delete_btnActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        int userId = 1;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame(userId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel age;
    private javax.swing.JTextField age_field;
    private javax.swing.JLabel bmi;
    private javax.swing.JButton confirm_btn;
    private javax.swing.JLabel email;
    private javax.swing.JLabel first_name;
    private javax.swing.JLabel height;
    private javax.swing.JTextField height_field;
    private javax.swing.JLabel last_name;
    private javax.swing.JButton profile_delete_btn;
    private javax.swing.JButton profile_edit_btn;
    private javax.swing.JButton profile_security_btn;
    private javax.swing.JLabel username;
    private javax.swing.JLabel weight;
    private javax.swing.JTextField weight_field;
    // End of variables declaration//GEN-END:variables
}
