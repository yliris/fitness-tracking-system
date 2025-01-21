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
import java.util.*;
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
        String userInfoQuery = "SELECT username, first_name, last_name, email, sex, bmi, classification, weight, height FROM tb_users WHERE user_id = ?";

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
                    float weight = rs.getFloat("weight");
                    float height = rs.getFloat("height");

                    username_profile.setText("-- " + username + " --");
                    name_profile.setText(fname + " " + lname);
                    email_profile.setText(email);
                    weight_profile.setText(String.format("Weight: %.1f kg", weight));
                    height_profile.setText(String.format("Height: %.1f cm", height));
                    bmi_profile.setText("BMI: " + bmi);
                    classification_profile.setText("Classification: " + classification);

                    if (sex.equals("Male")) {
                        user_profile_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-male-icon.png")));
                    } else if (sex.equals("Female")) {
                        user_profile_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-female-icon.png")));
                    }

                    Map<String, List<String>> motivationMessages = new HashMap<>();
                    motivationMessages.put("Underweight", Arrays.asList(
                            "Your body deserves care! Nourish yourself with wholesome foods.",
                            "Every small step matters. Stay positive and add healthy meals to your day.",
                            "Focus on building strength and vitality through balanced nutrition."
                    ));
                    motivationMessages.put("Normal Weight", Arrays.asList(
                            "Great job maintaining a healthy weight! Keep up the good work.",
                            "Your healthy habits are paying off! Stay consistent and enjoy the results.",
                            "You're doing amazing! Celebrate your commitment to wellness."
                    ));
                    motivationMessages.put("Overweight", Arrays.asList(
                            "You're capable of achieving your health goals. Take it one day at a time!",
                            "Small steps lead to big changes. Focus on progress, not perfection.",
                            "Stay active and make mindful choices. You’re on the right path!"
                    ));
                    motivationMessages.put("Obese", Arrays.asList(
                            "You're strong and capable. Start with small, sustainable changes.",
                            "Focus on steady progress. Your effort will lead to better health.",
                            "Seek support and stay determined. Every day is a new opportunity!"
                    ));

                    List<String> messages = motivationMessages.getOrDefault(classification,
                            Collections.singletonList("Embrace your health journey with confidence and determination!"));
                    String motivationMessage = messages.get(new Random().nextInt(messages.size()));

                    motivation_label.setText(motivationMessage);

                    bmi_result.setText(bmi);
                    classification_result.setText(classification);

                    float heightInMeters = (float) (height / 100.0);
                    float minBMI = 18.5f;
                    float maxBMI = 24.9f;
                    healthy_range.setText(String.format("%.1f", minBMI) + " - " + String.format("%.1f kg", maxBMI));

                    try {
                        String bmiCleaned = bmi.replaceAll("[^\\d.]", "");
                        float bmiValue = Float.parseFloat(bmiCleaned);

                        float currentWeight = bmiValue * heightInMeters * heightInMeters;

                        float minWeight = minBMI * heightInMeters * heightInMeters;
                        float maxWeight = maxBMI * heightInMeters * heightInMeters;

                        if (currentWeight < minWeight) {
                            float weightToGain = minWeight - currentWeight;
                            weight_needs.setText("Gain " + String.format("%.2f", weightToGain) + " kg to reach a healthy weight.");
                        } else if (currentWeight > maxWeight) {
                            float weightToLose = currentWeight - maxWeight;
                            weight_needs.setText("Lose " + String.format("%.2f", weightToLose) + " kg to reach a healthy weight.");
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

    public void updateUserBMI(String BMI, String classification, String healthyRange, String weightNeeds) {
        String bmi = BMI;
        String userClassification = classification;
        bmi_profile.setText("BMI: " + bmi);
        classification_profile.setText("Classification: " + userClassification);
        bmi_result.setText(bmi);
        classification_result.setText(userClassification);

        Map<String, List<String>> motivationMessages = new HashMap<>();
        motivationMessages.put("Underweight", Arrays.asList(
                "Your body deserves care! Nourish yourself with wholesome foods.",
                "Every small step matters. Stay positive and add healthy meals to your day.",
                "Focus on building strength and vitality through balanced nutrition."
        ));
        motivationMessages.put("Normal Weight", Arrays.asList(
                "Great job maintaining a healthy weight! Keep up the good work.",
                "Your healthy habits are paying off! Stay consistent and enjoy the results.",
                "You're doing amazing! Celebrate your commitment to wellness."
        ));
        motivationMessages.put("Overweight", Arrays.asList(
                "You're capable of achieving your health goals. Take it one day at a time!",
                "Small steps lead to big changes. Focus on progress, not perfection.",
                "Stay active and make mindful choices. You’re on the right path!"
        ));
        motivationMessages.put("Obese", Arrays.asList(
                "You're strong and capable. Start with small, sustainable changes.",
                "Focus on steady progress. Your effort will lead to better health.",
                "Seek support and stay determined. Every day is a new opportunity!"
        ));

        List<String> messages = motivationMessages.getOrDefault(classification,
                Collections.singletonList("Embrace your health journey with confidence and determination!"));
        String motivationMessage = messages.get(new Random().nextInt(messages.size()));

        motivation_label.setText(motivationMessage);
        
        healthy_range.setText(healthyRange);
        weight_needs.setText(weightNeeds);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home_background = new Resources.components.PanelBorder();
        profile_panel = new javax.swing.JPanel();
        user_profile_icon = new javax.swing.JLabel();
        name_profile = new javax.swing.JLabel();
        username_profile = new javax.swing.JLabel();
        email_profile = new javax.swing.JLabel();
        height_profile = new javax.swing.JLabel();
        weight_profile = new javax.swing.JLabel();
        bmi_profile = new javax.swing.JLabel();
        classification_profile = new javax.swing.JLabel();
        profile_background = new Resources.components.PanelBorder();
        profile_edit_btn = new javax.swing.JButton();
        profile_security_btn = new javax.swing.JButton();
        profile_delete_btn = new javax.swing.JButton();
        profile_label = new javax.swing.JLabel();
        motivation_panel = new Resources.components.PanelBorder();
        motivation_label = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        update_bmi_btn = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        bmi_result = new javax.swing.JLabel();
        classification_result = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        healthy_range = new javax.swing.JLabel();
        weight_needs = new javax.swing.JLabel();
        panelBorder1 = new Resources.components.PanelBorder();
        panelBorder2 = new Resources.components.PanelBorder();
        panelBorder5 = new Resources.components.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        panelBorder7 = new Resources.components.PanelBorder();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home_background.setBackground(new java.awt.Color(255, 255, 255));
        home_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile_panel.setBackground(new java.awt.Color(255, 255, 255));
        profile_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        profile_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user_profile_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user_profile_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-female-icon.png"))); // NOI18N
        profile_panel.add(user_profile_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, -1));

        name_profile.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        name_profile.setForeground(new java.awt.Color(29, 22, 22));
        name_profile.setText("(name)");
        profile_panel.add(name_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 340, 30));

        username_profile.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        username_profile.setForeground(new java.awt.Color(29, 22, 22));
        username_profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username_profile.setText("(username)");
        profile_panel.add(username_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 340, 30));

        email_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        email_profile.setForeground(new java.awt.Color(29, 22, 22));
        email_profile.setText("(email)");
        profile_panel.add(email_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 340, 30));

        height_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        height_profile.setForeground(new java.awt.Color(29, 22, 22));
        height_profile.setText("(height)");
        profile_panel.add(height_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 210, 30));

        weight_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        weight_profile.setForeground(new java.awt.Color(29, 22, 22));
        weight_profile.setText("(weight)");
        profile_panel.add(weight_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 130, 30));

        bmi_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        bmi_profile.setForeground(new java.awt.Color(29, 22, 22));
        bmi_profile.setText("(bmi)");
        profile_panel.add(bmi_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 130, 30));

        classification_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        classification_profile.setForeground(new java.awt.Color(29, 22, 22));
        classification_profile.setText("(classification)");
        profile_panel.add(classification_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 210, 30));

        home_background.add(profile_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 520, 170));

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        update_bmi_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/update-idle.png"))); // NOI18N
        update_bmi_btn.setBorder(null);
        update_bmi_btn.setBorderPainted(false);
        update_bmi_btn.setContentAreaFilled(false);
        update_bmi_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                update_bmi_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                update_bmi_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                update_bmi_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                update_bmi_btnMouseReleased(evt);
            }
        });
        update_bmi_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_bmi_btnActionPerformed(evt);
            }
        });
        jPanel1.add(update_bmi_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 30, -1, 20));

        label1.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        label1.setForeground(new java.awt.Color(29, 22, 22));
        label1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label1.setText("Body Mass Index (BMI):");
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 200, 20));

        label2.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        label2.setForeground(new java.awt.Color(29, 22, 22));
        label2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label2.setText("Classification:");
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 200, 20));

        bmi_result.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        bmi_result.setForeground(new java.awt.Color(29, 22, 22));
        bmi_result.setText("(BMI)");
        jPanel1.add(bmi_result, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 180, 20));

        classification_result.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        classification_result.setForeground(new java.awt.Color(29, 22, 22));
        classification_result.setText("(Classification)");
        jPanel1.add(classification_result, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 180, 20));

        label3.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        label3.setForeground(new java.awt.Color(29, 22, 22));
        label3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label3.setText("Healthy BMI Range:");
        jPanel1.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 20));

        healthy_range.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        healthy_range.setForeground(new java.awt.Color(29, 22, 22));
        healthy_range.setText("(healthy BMI range)");
        jPanel1.add(healthy_range, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 180, 20));

        weight_needs.setFont(new java.awt.Font("Cascadia Mono", 0, 13)); // NOI18N
        weight_needs.setForeground(new java.awt.Color(29, 22, 22));
        weight_needs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weight_needs.setText("(gain/lose needs)");
        jPanel1.add(weight_needs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 390, 20));

        panelBorder1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        jPanel1.add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        home_background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 640, 170));

        panelBorder2.setBackground(new java.awt.Color(204, 204, 255));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        home_background.add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 120, 110));

        panelBorder5.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setText("pie chart, most workout type done");

        javax.swing.GroupLayout panelBorder5Layout = new javax.swing.GroupLayout(panelBorder5);
        panelBorder5.setLayout(panelBorder5Layout);
        panelBorder5Layout.setHorizontalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder5Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(51, 51, 51))
        );
        panelBorder5Layout.setVerticalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        home_background.add(panelBorder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 240, 300, 300));

        panelBorder7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("total completed meals");
        panelBorder7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        home_background.add(panelBorder7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 190, 110));

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

    private void update_bmi_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_bmi_btnActionPerformed
        
    }//GEN-LAST:event_update_bmi_btnActionPerformed

    private void update_bmi_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_bmi_btnMouseEntered
        update_bmi_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/update-hover.png")));
    }//GEN-LAST:event_update_bmi_btnMouseEntered

    private void update_bmi_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_bmi_btnMouseExited
        update_bmi_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/update-idle.png")));
    }//GEN-LAST:event_update_bmi_btnMouseExited

    private void update_bmi_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_bmi_btnMousePressed
        update_bmi_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/update-idle.png")));
    }//GEN-LAST:event_update_bmi_btnMousePressed

    private void update_bmi_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_bmi_btnMouseReleased
        update_bmi_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/update-hover.png")));
    }//GEN-LAST:event_update_bmi_btnMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bmi_profile;
    private javax.swing.JLabel bmi_result;
    private javax.swing.JLabel classification_profile;
    private javax.swing.JLabel classification_result;
    private javax.swing.JLabel email_profile;
    private javax.swing.JLabel healthy_range;
    private javax.swing.JLabel height_profile;
    private Resources.components.PanelBorder home_background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel motivation_label;
    private Resources.components.PanelBorder motivation_panel;
    private javax.swing.JLabel name_profile;
    private Resources.components.PanelBorder panelBorder1;
    private Resources.components.PanelBorder panelBorder2;
    private Resources.components.PanelBorder panelBorder5;
    private Resources.components.PanelBorder panelBorder7;
    private Resources.components.PanelBorder profile_background;
    private javax.swing.JButton profile_delete_btn;
    private javax.swing.JButton profile_edit_btn;
    private javax.swing.JLabel profile_label;
    private javax.swing.JPanel profile_panel;
    private javax.swing.JButton profile_security_btn;
    private javax.swing.JButton update_bmi_btn;
    private javax.swing.JLabel user_profile_icon;
    private javax.swing.JLabel username_profile;
    private javax.swing.JLabel weight_needs;
    private javax.swing.JLabel weight_profile;
    // End of variables declaration//GEN-END:variables
}
