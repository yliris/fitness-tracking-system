package Home;

import Account.LoginForm;
import Content.Exercise;
import Content.Diet;
import Content.Guide;
import Content.Achievements;
import Content.Home;
import Resources.components.DatabaseConnection;
import Resources.components.ScrollBarWin11UI;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

public class UserHome extends javax.swing.JFrame {

    private int userId;

    private Home home;
    private Exercise activity;
    private Diet diet;
    private Achievements achievements;
    private Guide guide;

    public UserHome(int userId) {
        initComponents();
        this.userId = userId;
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(UserHome.this);
        Image icon = new ImageIcon(this.getClass().getResource("/Resources/elements/fts-icon.png")).getImage();
        this.setIconImage(icon);
        home = new Home(this.userId);
        activity = new Exercise(this.userId, home);
        diet = new Diet(this.userId, home);
        achievements = new Achievements();
        guide = new Guide();
        body.add(home, "Home");
        body.add(activity, "Activity");
        body.add(diet, "Diet");
        body.add(achievements, "Achievements");
        body.add(guide, "Guide");
        CardLayout cardLayout = (CardLayout) body.getLayout();
        cardLayout.show(body, "Home");
        setGreetings();
    }

    private void setGreetings() {
        String usernameQuery = "SELECT username FROM tb_users WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(usernameQuery)) {

            stmt.setInt(1, this.userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    greetings.setText("Hi, " + rs.getString("username"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error loading user data: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showPanel(String panelName) {
        CardLayout cardLayout = (CardLayout) body.getLayout();
        cardLayout.show(body, panelName);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user_background = new Resources.components.PanelBorder();
        header_background = new Resources.components.PanelBorder();
        header_panel = new Resources.components.PanelBorder();
        profile_btn = new Resources.components.PanelBorder();
        fits_icon = new javax.swing.JLabel();
        greetings = new javax.swing.JLabel();
        home_btn = new Resources.components.PanelBorder();
        home_icon = new javax.swing.JLabel();
        home_label = new javax.swing.JLabel();
        activity_btn = new Resources.components.PanelBorder();
        activity_icon = new javax.swing.JLabel();
        exercise_label = new javax.swing.JLabel();
        diet_btn = new Resources.components.PanelBorder();
        diet_icon = new javax.swing.JLabel();
        diet_label = new javax.swing.JLabel();
        guide_btn = new Resources.components.PanelBorder();
        diet_icon1 = new javax.swing.JLabel();
        guide_label = new javax.swing.JLabel();
        achievements_btn = new Resources.components.PanelBorder();
        achievements_label = new javax.swing.JLabel();
        achievements_icon = new javax.swing.JLabel();
        exit_panel = new Resources.components.PanelBorder();
        logout_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        mover = new Resources.components.PanelMover();
        body = new javax.swing.JLayeredPane();
        body_background = new Resources.components.PanelBorder();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        user_background.setBackground(new java.awt.Color(114, 134, 211));
        user_background.setLayout(new java.awt.BorderLayout());

        header_background.setBackground(new java.awt.Color(114, 134, 211));
        header_background.setPreferredSize(new java.awt.Dimension(1250, 80));
        header_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header_panel.setBackground(new java.awt.Color(255, 255, 255));
        header_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile_btn.setBackground(new java.awt.Color(114, 134, 211));
        profile_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fits_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fits_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/fts-small-icon.png"))); // NOI18N
        profile_btn.add(fits_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 70));

        greetings.setFont(new java.awt.Font("Cascadia Mono", 1, 16)); // NOI18N
        greetings.setForeground(new java.awt.Color(255, 242, 242));
        greetings.setText("Hi, (name)");
        profile_btn.add(greetings, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 186, 70));

        header_panel.add(profile_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 260, 80));

        home_btn.setBackground(new java.awt.Color(142, 167, 233));
        home_btn.setPreferredSize(new java.awt.Dimension(40, 48));
        home_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                home_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                home_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                home_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                home_btnMouseReleased(evt);
            }
        });
        home_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/home-icon.png"))); // NOI18N
        home_btn.add(home_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 50));

        home_label.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        home_label.setForeground(new java.awt.Color(255, 255, 255));
        home_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home_label.setText("HOME");
        home_label.setIconTextGap(10);
        home_btn.add(home_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 50));

        header_panel.add(home_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 160, 50));

        activity_btn.setBackground(new java.awt.Color(142, 167, 233));
        activity_btn.setPreferredSize(new java.awt.Dimension(40, 48));
        activity_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                activity_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                activity_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                activity_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                activity_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                activity_btnMouseReleased(evt);
            }
        });
        activity_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        activity_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        activity_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/exercise-icon.png"))); // NOI18N
        activity_btn.add(activity_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 50));

        exercise_label.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        exercise_label.setForeground(new java.awt.Color(255, 255, 255));
        exercise_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exercise_label.setText("EXERCISE");
        exercise_label.setIconTextGap(10);
        activity_btn.add(exercise_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 50));

        header_panel.add(activity_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 160, 50));

        diet_btn.setBackground(new java.awt.Color(142, 167, 233));
        diet_btn.setPreferredSize(new java.awt.Dimension(40, 48));
        diet_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diet_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                diet_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                diet_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                diet_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                diet_btnMouseReleased(evt);
            }
        });
        diet_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        diet_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diet_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/diet-icon.png"))); // NOI18N
        diet_btn.add(diet_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 50));

        diet_label.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        diet_label.setForeground(new java.awt.Color(255, 255, 255));
        diet_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diet_label.setText("DIET");
        diet_label.setIconTextGap(10);
        diet_btn.add(diet_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 50));

        header_panel.add(diet_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 160, 50));

        guide_btn.setBackground(new java.awt.Color(142, 167, 233));
        guide_btn.setPreferredSize(new java.awt.Dimension(40, 48));
        guide_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guide_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                guide_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                guide_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                guide_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                guide_btnMouseReleased(evt);
            }
        });
        guide_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        diet_icon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diet_icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/guide-icon.png"))); // NOI18N
        guide_btn.add(diet_icon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 50));

        guide_label.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        guide_label.setForeground(new java.awt.Color(255, 255, 255));
        guide_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guide_label.setText("GUIDE");
        guide_label.setIconTextGap(10);
        guide_btn.add(guide_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 50));

        header_panel.add(guide_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 160, 50));

        achievements_btn.setBackground(new java.awt.Color(142, 167, 233));
        achievements_btn.setPreferredSize(new java.awt.Dimension(40, 48));
        achievements_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                achievements_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                achievements_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                achievements_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                achievements_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                achievements_btnMouseReleased(evt);
            }
        });
        achievements_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        achievements_label.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        achievements_label.setForeground(new java.awt.Color(255, 255, 255));
        achievements_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        achievements_label.setText("ACHIEVEMENTS");
        achievements_label.setIconTextGap(10);
        achievements_btn.add(achievements_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 50));

        achievements_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        achievements_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/achievements-icon.png"))); // NOI18N
        achievements_btn.add(achievements_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 50));

        header_panel.add(achievements_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 160, 50));

        exit_panel.setBackground(new java.awt.Color(114, 134, 211));
        exit_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-white-idle.png"))); // NOI18N
        logout_btn.setBorder(null);
        logout_btn.setBorderPainted(false);
        logout_btn.setContentAreaFilled(false);
        logout_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logout_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logout_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logout_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logout_btnMouseReleased(evt);
            }
        });
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });
        exit_panel.add(logout_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

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
        exit_panel.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        header_panel.add(exit_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, -10, 120, 80));

        header_background.add(header_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 6, 1240, 68));
        header_background.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 6));

        user_background.add(header_background, java.awt.BorderLayout.PAGE_START);

        body.setLayout(new java.awt.CardLayout());

        body_background.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout body_backgroundLayout = new javax.swing.GroupLayout(body_background);
        body_background.setLayout(body_backgroundLayout);
        body_backgroundLayout.setHorizontalGroup(
            body_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1250, Short.MAX_VALUE)
        );
        body_backgroundLayout.setVerticalGroup(
            body_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        body.add(body_background, "card2");

        user_background.add(body, java.awt.BorderLayout.CENTER);

        getContentPane().add(user_background, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logout_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMouseEntered
        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-white-hover.png")));
    }//GEN-LAST:event_logout_btnMouseEntered

    private void logout_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMouseExited
        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-white-idle.png")));
    }//GEN-LAST:event_logout_btnMouseExited

    private void logout_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMousePressed
        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-white-click.png")));
    }//GEN-LAST:event_logout_btnMousePressed

    private void logout_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMouseReleased
        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-white-hover.png")));
    }//GEN-LAST:event_logout_btnMouseReleased

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        int confirmLogout = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to logout?",
                "Logout",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmLogout == JOptionPane.YES_OPTION) {
            dispose();
            new LoginForm().setVisible(true);
        }
    }//GEN-LAST:event_logout_btnActionPerformed

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
                "Are you sure you want to quit?",
                "Quit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmExit == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_exit_btnActionPerformed

    private void home_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_btnMouseEntered
        home_btn.setBackground(new Color(114, 134, 211));
    }//GEN-LAST:event_home_btnMouseEntered

    private void home_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_btnMouseExited
        home_btn.setBackground(new Color(142, 167, 233));
    }//GEN-LAST:event_home_btnMouseExited

    private void home_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_btnMousePressed
        home_btn.setBackground(new Color(58, 84, 186));
    }//GEN-LAST:event_home_btnMousePressed

    private void home_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_btnMouseReleased
        home_btn.setBackground(new Color(114, 134, 211));
    }//GEN-LAST:event_home_btnMouseReleased

    private void home_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_btnMouseClicked
        CardLayout cardLayout = (CardLayout) body.getLayout();
        cardLayout.show(body, "Home");
    }//GEN-LAST:event_home_btnMouseClicked

    private void activity_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activity_btnMouseEntered
        activity_btn.setBackground(new Color(114, 134, 211));
    }//GEN-LAST:event_activity_btnMouseEntered

    private void activity_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activity_btnMouseExited
        activity_btn.setBackground(new Color(142, 167, 233));
    }//GEN-LAST:event_activity_btnMouseExited

    private void activity_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activity_btnMousePressed
        activity_btn.setBackground(new Color(58, 84, 186));
    }//GEN-LAST:event_activity_btnMousePressed

    private void activity_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activity_btnMouseReleased
        activity_btn.setBackground(new Color(114, 134, 211));
    }//GEN-LAST:event_activity_btnMouseReleased

    private void activity_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activity_btnMouseClicked
        CardLayout cardLayout = (CardLayout) body.getLayout();
        cardLayout.show(body, "Activity");
    }//GEN-LAST:event_activity_btnMouseClicked

    private void diet_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diet_btnMouseEntered
        diet_btn.setBackground(new Color(114, 134, 211));
    }//GEN-LAST:event_diet_btnMouseEntered

    private void diet_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diet_btnMouseExited
        diet_btn.setBackground(new Color(142, 167, 233));
    }//GEN-LAST:event_diet_btnMouseExited

    private void diet_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diet_btnMousePressed
        diet_btn.setBackground(new Color(58, 84, 186));
    }//GEN-LAST:event_diet_btnMousePressed

    private void diet_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diet_btnMouseReleased
        diet_btn.setBackground(new Color(114, 134, 211));
    }//GEN-LAST:event_diet_btnMouseReleased

    private void diet_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diet_btnMouseClicked
        CardLayout cardLayout = (CardLayout) body.getLayout();
        cardLayout.show(body, "Diet");
    }//GEN-LAST:event_diet_btnMouseClicked

    private void guide_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guide_btnMouseEntered
        guide_btn.setBackground(new Color(114, 134, 211));
    }//GEN-LAST:event_guide_btnMouseEntered

    private void guide_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guide_btnMouseExited
        guide_btn.setBackground(new Color(142, 167, 233));
    }//GEN-LAST:event_guide_btnMouseExited

    private void guide_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guide_btnMousePressed
        guide_btn.setBackground(new Color(58, 84, 186));
    }//GEN-LAST:event_guide_btnMousePressed

    private void guide_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guide_btnMouseReleased
        guide_btn.setBackground(new Color(114, 134, 211));
    }//GEN-LAST:event_guide_btnMouseReleased

    private void guide_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guide_btnMouseClicked
        CardLayout cardLayout = (CardLayout) body.getLayout();
        cardLayout.show(body, "Guide");
    }//GEN-LAST:event_guide_btnMouseClicked

    private void achievements_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_achievements_btnMouseEntered
        achievements_btn.setBackground(new Color(114, 134, 211));
    }//GEN-LAST:event_achievements_btnMouseEntered

    private void achievements_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_achievements_btnMouseExited
        achievements_btn.setBackground(new Color(142, 167, 233));
    }//GEN-LAST:event_achievements_btnMouseExited

    private void achievements_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_achievements_btnMousePressed
        achievements_btn.setBackground(new Color(58, 84, 186));
    }//GEN-LAST:event_achievements_btnMousePressed

    private void achievements_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_achievements_btnMouseReleased
        achievements_btn.setBackground(new Color(114, 134, 211));
    }//GEN-LAST:event_achievements_btnMouseReleased

    private void achievements_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_achievements_btnMouseClicked
        CardLayout cardLayout = (CardLayout) body.getLayout();
        cardLayout.show(body, "Achievements");
    }//GEN-LAST:event_achievements_btnMouseClicked

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
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        UIDefaults ui = UIManager.getDefaults();
        ui.put("ScrollBarUI", ScrollBarWin11UI.class.getCanonicalName());
        int id = 1;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserHome(id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Resources.components.PanelBorder achievements_btn;
    private javax.swing.JLabel achievements_icon;
    private javax.swing.JLabel achievements_label;
    private Resources.components.PanelBorder activity_btn;
    private javax.swing.JLabel activity_icon;
    private javax.swing.JLayeredPane body;
    private Resources.components.PanelBorder body_background;
    private Resources.components.PanelBorder diet_btn;
    private javax.swing.JLabel diet_icon;
    private javax.swing.JLabel diet_icon1;
    private javax.swing.JLabel diet_label;
    private javax.swing.JLabel exercise_label;
    private javax.swing.JButton exit_btn;
    private Resources.components.PanelBorder exit_panel;
    private javax.swing.JLabel fits_icon;
    private javax.swing.JLabel greetings;
    private Resources.components.PanelBorder guide_btn;
    private javax.swing.JLabel guide_label;
    private Resources.components.PanelBorder header_background;
    private Resources.components.PanelBorder header_panel;
    private Resources.components.PanelBorder home_btn;
    private javax.swing.JLabel home_icon;
    private javax.swing.JLabel home_label;
    private javax.swing.JButton logout_btn;
    private Resources.components.PanelMover mover;
    private Resources.components.PanelBorder profile_btn;
    private Resources.components.PanelBorder user_background;
    // End of variables declaration//GEN-END:variables
}
