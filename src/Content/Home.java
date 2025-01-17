package Content;

import java.awt.Color;
import Resources.components.DatabaseConnection;
import Account.DeleteForm;
import Account.UserEditForm;
import Account.UserSecurityForm;
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
        String userInfoQuery = "SELECT username, first_name, last_name, email, sex FROM tb_users WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(userInfoQuery)) {
            stmt.setInt(1, this.userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String username = rs.getString("username");
                    String fname = rs.getString("first_name");
                    String lname = rs.getString("last_name");
                    String email = rs.getString("email");
                    String sex = rs.getString("sex");
                    username_profile.setText("-- " + username + " --");
                    name_profile.setText(fname + " " + lname);
                    email_profile.setText(email);

                    if (sex.equals("Male")) {
                        user_profile_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-male-icon.png")));
                    } else if (sex.equals("Female")) {
                        user_profile_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-female-icon.png")));
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home_background = new Resources.components.PanelBorder();
        home_panel = new Resources.components.PanelBorder();
        profile_form = new Resources.components.PanelBorder();
        name_profile = new javax.swing.JLabel();
        email_profile = new javax.swing.JLabel();
        username_profile = new javax.swing.JLabel();
        user_profile_icon = new javax.swing.JLabel();
        profile_background = new Resources.components.PanelBorder();
        profile_edit_btn = new javax.swing.JButton();
        profile_security_btn = new javax.swing.JButton();
        profile_delete_btn = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home_background.setBackground(new java.awt.Color(153, 153, 255));
        home_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home_panel.setBackground(new java.awt.Color(153, 153, 255));
        home_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile_form.setBackground(new java.awt.Color(255, 255, 255));
        profile_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name_profile.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        name_profile.setForeground(new java.awt.Color(51, 51, 51));
        name_profile.setText("(name)");
        profile_form.add(name_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 340, 30));

        email_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        email_profile.setForeground(new java.awt.Color(51, 51, 51));
        email_profile.setText("(email)");
        profile_form.add(email_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 340, 30));

        username_profile.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        username_profile.setForeground(new java.awt.Color(51, 51, 51));
        username_profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username_profile.setText("(username)");
        profile_form.add(username_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 340, 30));

        user_profile_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user_profile_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-female-icon.png"))); // NOI18N
        profile_form.add(user_profile_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, -1));

        home_panel.add(profile_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 520, 170));

        profile_background.setBackground(new java.awt.Color(153, 153, 153));
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

        label1.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Profile Details");
        profile_background.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 410, 30));

        home_panel.add(profile_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 540, 190));

        home_background.add(home_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
    private javax.swing.JLabel email_profile;
    private Resources.components.PanelBorder home_background;
    private Resources.components.PanelBorder home_panel;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel name_profile;
    private Resources.components.PanelBorder profile_background;
    private javax.swing.JButton profile_delete_btn;
    private javax.swing.JButton profile_edit_btn;
    private Resources.components.PanelBorder profile_form;
    private javax.swing.JButton profile_security_btn;
    private javax.swing.JLabel user_profile_icon;
    private javax.swing.JLabel username_profile;
    // End of variables declaration//GEN-END:variables
}
