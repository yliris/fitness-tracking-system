package Content;

import java.awt.Color;
import Resources.components.DatabaseConnection;
import Account.DeleteForm;
import Account.UserEditForm;
import Resources.components.PasswordForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Home extends javax.swing.JPanel {

    private int userId;

    public Home(int userId) {
        initComponents();
        this.userId = userId;
        setBackground(new Color(0, 0, 0, 0));
        setProfileDetails();
    }

    private void setProfileDetails() {
        String userInfoQuery = "SELECT username, first_name, last_name, email, sex, bmi, classification, height FROM tb_users WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(userInfoQuery)) {
            stmt.setInt(1, this.userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String username = rs.getString("username");
                    String fname = rs.getString("first_name");
                    String lname = rs.getString("last_name");
                    String email = rs.getString("email");
                    String sex = rs.getString("sex");
                    String bmi = rs.getString("bmi");
                    String classification = rs.getString("classification");
                    float height = rs.getFloat("height");

                    username_profile.setText("-- " + username + " --");
                    name_profile.setText(fname + " " + lname);
                    email_profile.setText(email);
                    bmi_profile.setText("BMI: " + bmi + " / " + classification);

                    if (sex.equals("Male")) {
                        user_profile_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-male-icon.png")));
                    } else if (sex.equals("Female")) {
                        user_profile_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-female-icon.png")));
                    }

                    String motivationMessage = "";
                    switch (classification) {
                        case "Severe Thinness":
                            motivationMessage = "Your health matters! Seek professional advice to build strength and vitality.";
                            break;
                        case "Moderate Thinness":
                            motivationMessage = "You're on a journey. Focus on balanced nutrition and self-care!";
                            break;
                        case "Mild Thinness":
                            motivationMessage = "Every step counts! Add nutritious meals and stay positive.";
                            break;
                        case "Normal":
                            motivationMessage = "Great job maintaining a healthy weight! Keep up the good work.";
                            break;
                        case "Overweight":
                            motivationMessage = "You're capable of achieving your health goals. Take it one day at a time!";
                            break;
                        case "Obese Class I":
                            motivationMessage = "Small changes can lead to big results. Start your journey today!";
                            break;
                        case "Obese Class II":
                            motivationMessage = "Focus on steady progress. Your effort will lead to better health.";
                            break;
                        case "Obese Class III":
                            motivationMessage = "You're strong and capable. Professional guidance can help you succeed.";
                            break;
                        case "Underweight":
                            motivationMessage = "Your body deserves care! Nourish yourself with wholesome foods.";
                            break;
                        case "Healthy Weight":
                            motivationMessage = "Keep up the great work! Your healthy habits are paying off.";
                            break;
                        case "Risk of Overweight":
                            motivationMessage = "Stay active and mindful! You're on the right path to maintaining balance.";
                            break;
                        default:
                            motivationMessage = "Embrace your health journey with confidence and determination!";
                            break;
                    }
                    motivation_label.setText(motivationMessage);

                    bmi_result.setText(bmi);
                    classification_result.setText(classification);

                    double heightInMeters = height / 100.0;
                    double minWeight = 18.5 * heightInMeters * heightInMeters;
                    double maxWeight = 24.9 * heightInMeters * heightInMeters;
                    healthy_range.setText(String.format("%.1f", minWeight) + " - " + String.format("%.1f", maxWeight) + " kg/m²");

                    try {
                        String bmiCleaned = bmi.replaceAll("[^\\d.]", "");
                        double bmiDouble = Double.parseDouble(bmiCleaned);

                        double currentWeight = bmiDouble * heightInMeters * heightInMeters;
                        if (currentWeight < minWeight) {
                            weight_needs.setText("Gain " + String.format("%.2f", minWeight - currentWeight) + " kg to reach a healthy weight.");
                        } else if (currentWeight > maxWeight) {
                            weight_needs.setText("Lose " + String.format("%.2f", currentWeight - maxWeight) + " kg to reach a healthy weight.");
                        } else {
                            weight_needs.setText("Your weight is within the healthy range!");
                        }
                    } catch (NumberFormatException e) {
                        weight_needs.setText("Invalid BMI value. Please check your data.");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error loading user data: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateUserDetails(String username, String fullName, String email) {
        username_profile.setText("-- " + username + " --");
        name_profile.setText(fullName);
        email_profile.setText(email);
    }

    public void updateProfileIcon(String sex) {
        if (sex.equals("Male")) {
            user_profile_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-male-icon.png")));
        } else if (sex.equals("Female")) {
            user_profile_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-female-icon.png")));
        }
    }

    public void updateUserBMI(String BMI, String classification) {
        String bmi = BMI;
        String userClassification = classification;
        bmi_profile.setText("BMI: " + bmi + " / " + userClassification);

        String motivationMessage = "";
        switch (userClassification) {
            case "Severe Thinness":
                motivationMessage = "Your health matters! Seek professional advice to build strength and vitality.";
                break;
            case "Moderate Thinness":
                motivationMessage = "You're on a journey. Focus on balanced nutrition and self-care!";
                break;
            case "Mild Thinness":
                motivationMessage = "Every step counts! Add nutritious meals and stay positive.";
                break;
            case "Normal":
                motivationMessage = "Great job maintaining a healthy weight! Keep up the good work.";
                break;
            case "Overweight":
                motivationMessage = "You're capable of achieving your health goals. Take it one day at a time!";
                break;
            case "Obese Class I":
                motivationMessage = "Small changes can lead to big results. Start your journey today!";
                break;
            case "Obese Class II":
                motivationMessage = "Focus on steady progress. Your effort will lead to better health.";
                break;
            case "Obese Class III":
                motivationMessage = "You're strong and capable. Professional guidance can help you succeed.";
                break;
            case "Underweight":
                motivationMessage = "Your body deserves care! Nourish yourself with wholesome foods.";
                break;
            case "Healthy Weight":
                motivationMessage = "Keep up the great work! Your healthy habits are paying off.";
                break;
            case "Risk of Overweight":
                motivationMessage = "Stay active and mindful! You're on the right path to maintaining balance.";
                break;
            default:
                motivationMessage = "Embrace your health journey with confidence and determination!";
                break;
        }
        motivation_label.setText(motivationMessage);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home_background = new Resources.components.PanelBorder();
        profile_form = new Resources.components.PanelBorder();
        username_profile = new javax.swing.JLabel();
        name_profile = new javax.swing.JLabel();
        bmi_profile = new javax.swing.JLabel();
        email_profile = new javax.swing.JLabel();
        user_profile_icon = new javax.swing.JLabel();
        profile_background = new Resources.components.PanelBorder();
        profile_edit_btn = new javax.swing.JButton();
        profile_security_btn = new javax.swing.JButton();
        profile_delete_btn = new javax.swing.JButton();
        profile_label = new javax.swing.JLabel();
        motivation_panel = new Resources.components.PanelBorder();
        motivation_label = new javax.swing.JLabel();
        bmi_result_panel = new Resources.components.PanelBorder();
        label1 = new javax.swing.JLabel();
        bmi_result = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        classification_result = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        healthy_range = new javax.swing.JLabel();
        weight_needs = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home_background.setBackground(new java.awt.Color(142, 167, 233));
        home_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile_form.setBackground(new java.awt.Color(255, 255, 255));
        profile_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username_profile.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        username_profile.setForeground(new java.awt.Color(29, 22, 22));
        username_profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username_profile.setText("(username)");
        profile_form.add(username_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 340, 30));

        name_profile.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        name_profile.setForeground(new java.awt.Color(29, 22, 22));
        name_profile.setText("(name)");
        profile_form.add(name_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 340, 30));

        bmi_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        bmi_profile.setForeground(new java.awt.Color(29, 22, 22));
        bmi_profile.setText("(bmi / classification)");
        profile_form.add(bmi_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 340, 30));

        email_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        email_profile.setForeground(new java.awt.Color(29, 22, 22));
        email_profile.setText("(email)");
        profile_form.add(email_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 340, 30));

        user_profile_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user_profile_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-female-icon.png"))); // NOI18N
        profile_form.add(user_profile_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, -1));

        home_background.add(profile_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 520, 170));

        profile_background.setBackground(new java.awt.Color(114, 134, 211));
        profile_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile_edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-edit-idle.png"))); // NOI18N
        profile_edit_btn.setBorder(null);
        profile_edit_btn.setBorderPainted(false);
        profile_edit_btn.setContentAreaFilled(false);
        profile_edit_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profile_edit_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profile_edit_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                profile_edit_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                profile_edit_btnMouseReleased(evt);
            }
        });
        profile_edit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile_edit_btnActionPerformed(evt);
            }
        });
        profile_background.add(profile_edit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 30, 30));

        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-sec-idle.png"))); // NOI18N
        profile_security_btn.setBorder(null);
        profile_security_btn.setBorderPainted(false);
        profile_security_btn.setContentAreaFilled(false);
        profile_security_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profile_security_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profile_security_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                profile_security_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                profile_security_btnMouseReleased(evt);
            }
        });
        profile_security_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile_security_btnActionPerformed(evt);
            }
        });
        profile_background.add(profile_security_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 30, 30));

        profile_delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-delete-idle.png"))); // NOI18N
        profile_delete_btn.setBorder(null);
        profile_delete_btn.setBorderPainted(false);
        profile_delete_btn.setContentAreaFilled(false);
        profile_delete_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profile_delete_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profile_delete_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                profile_delete_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                profile_delete_btnMouseReleased(evt);
            }
        });
        profile_delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile_delete_btnActionPerformed(evt);
            }
        });
        profile_background.add(profile_delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 30, 30));

        profile_label.setBackground(new java.awt.Color(244, 237, 211));
        profile_label.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        profile_label.setForeground(new java.awt.Color(255, 242, 242));
        profile_label.setText("Profile Details");
        profile_background.add(profile_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 410, 30));

        home_background.add(profile_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 540, 190));

        motivation_panel.setBackground(new java.awt.Color(114, 134, 211));
        motivation_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        motivation_label.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        motivation_label.setForeground(new java.awt.Color(255, 242, 242));
        motivation_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        motivation_label.setText("(motivation message)");
        motivation_panel.add(motivation_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 40));

        home_background.add(motivation_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 640, 40));

        bmi_result_panel.setBackground(new java.awt.Color(255, 255, 255));
        bmi_result_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        label1.setForeground(new java.awt.Color(29, 22, 22));
        label1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label1.setText("Body Mass Index (BMI):");
        bmi_result_panel.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, 20));

        bmi_result.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        bmi_result.setForeground(new java.awt.Color(29, 22, 22));
        bmi_result.setText("(BMI)");
        bmi_result_panel.add(bmi_result, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 180, 20));

        label2.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        label2.setForeground(new java.awt.Color(29, 22, 22));
        label2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label2.setText("Classification:");
        bmi_result_panel.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 200, 20));

        classification_result.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        classification_result.setForeground(new java.awt.Color(29, 22, 22));
        classification_result.setText("(Classification)");
        bmi_result_panel.add(classification_result, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 180, 20));

        label3.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        label3.setForeground(new java.awt.Color(29, 22, 22));
        label3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label3.setText("Healthy BMI Range:");
        bmi_result_panel.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 200, 20));

        healthy_range.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        healthy_range.setForeground(new java.awt.Color(29, 22, 22));
        healthy_range.setText("(healthy BMI range)");
        bmi_result_panel.add(healthy_range, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 180, 20));

        weight_needs.setFont(new java.awt.Font("Cascadia Mono", 0, 13)); // NOI18N
        weight_needs.setForeground(new java.awt.Color(29, 22, 22));
        weight_needs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weight_needs.setText("(gain/lose needs)");
        bmi_result_panel.add(weight_needs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 390, 20));

        home_background.add(bmi_result_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 640, 170));

        add(home_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void profile_edit_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_edit_btnMouseEntered
        profile_edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-edit-hover.png")));
    }//GEN-LAST:event_profile_edit_btnMouseEntered

    private void profile_edit_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_edit_btnMouseExited
        profile_edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-edit-idle.png")));
    }//GEN-LAST:event_profile_edit_btnMouseExited

    private void profile_edit_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_edit_btnMousePressed
        profile_edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-edit-click.png")));
    }//GEN-LAST:event_profile_edit_btnMousePressed

    private void profile_edit_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_edit_btnMouseReleased
        profile_edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-edit-hover.png")));
    }//GEN-LAST:event_profile_edit_btnMouseReleased

    private void profile_edit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_edit_btnActionPerformed
        UserEditForm userEditForm = new UserEditForm(this, userId);
        userEditForm.setVisible(true);
    }//GEN-LAST:event_profile_edit_btnActionPerformed

    private void profile_security_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_security_btnMouseEntered
        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-sec-hover.png")));
    }//GEN-LAST:event_profile_security_btnMouseEntered

    private void profile_security_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_security_btnMouseExited
        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-sec-idle.png")));
    }//GEN-LAST:event_profile_security_btnMouseExited

    private void profile_security_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_security_btnMousePressed
        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-sec-click.png")));
    }//GEN-LAST:event_profile_security_btnMousePressed

    private void profile_security_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_security_btnMouseReleased
        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-sec-hover.png")));
    }//GEN-LAST:event_profile_security_btnMouseReleased

    private void profile_security_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_security_btnActionPerformed
        PasswordForm passwordForm = new PasswordForm(userId);
        passwordForm.setVisible(true);
    }//GEN-LAST:event_profile_security_btnActionPerformed

    private void profile_delete_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_delete_btnMouseEntered
        profile_delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-delete-hover.png")));
    }//GEN-LAST:event_profile_delete_btnMouseEntered

    private void profile_delete_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_delete_btnMouseExited
        profile_delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-delete-idle.png")));
    }//GEN-LAST:event_profile_delete_btnMouseExited

    private void profile_delete_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_delete_btnMousePressed
        profile_delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-delete-click.png")));
    }//GEN-LAST:event_profile_delete_btnMousePressed

    private void profile_delete_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_delete_btnMouseReleased
        profile_delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-delete-hover.png")));
    }//GEN-LAST:event_profile_delete_btnMouseReleased

    private void profile_delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_delete_btnActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account?",
                "Confirm Delete?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            DeleteForm deleteForm = new DeleteForm(userId);
            deleteForm.setVisible(true);
        }
    }//GEN-LAST:event_profile_delete_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bmi_profile;
    private javax.swing.JLabel bmi_result;
    private Resources.components.PanelBorder bmi_result_panel;
    private javax.swing.JLabel classification_result;
    private javax.swing.JLabel email_profile;
    private javax.swing.JLabel healthy_range;
    private Resources.components.PanelBorder home_background;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel motivation_label;
    private Resources.components.PanelBorder motivation_panel;
    private javax.swing.JLabel name_profile;
    private Resources.components.PanelBorder profile_background;
    private javax.swing.JButton profile_delete_btn;
    private javax.swing.JButton profile_edit_btn;
    private Resources.components.PanelBorder profile_form;
    private javax.swing.JLabel profile_label;
    private javax.swing.JButton profile_security_btn;
    private javax.swing.JLabel user_profile_icon;
    private javax.swing.JLabel username_profile;
    private javax.swing.JLabel weight_needs;
    // End of variables declaration//GEN-END:variables
}
