package Home;

import Account.LoginForm;
import Content.Activity;
import Content.Dashboard;
import Content.Diet;
import Content.Guide;
import Content.Home;
import Resources.components.DatabaseConnection;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class UserHome extends javax.swing.JFrame {

    private int userId;

    private Home home;
    private Dashboard dashboard;
    private Activity activity;
    private Diet diet;
    private Guide guide;

    public UserHome(int userId) {
        initComponents();
        this.userId = userId;
        setBackground(new Color(0, 0, 0, 0));
        Image icon = new ImageIcon(this.getClass().getResource("/Resources/elements/fts-icon.png")).getImage();
        this.setIconImage(icon);
        home = new Home(this.userId);
        dashboard = new Dashboard();
        activity = new Activity();
        diet = new Diet();
        guide = new Guide();
        body.add(home, "Home");
        body.add(dashboard, "Dashboard");
        body.add(activity, "Activity");
        body.add(diet, "Diet");
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
        dashboard_btn = new Resources.components.PanelBorder();
        dashboard_icon = new javax.swing.JLabel();
        activity_btn = new Resources.components.PanelBorder();
        activity_icon = new javax.swing.JLabel();
        diet_btn = new Resources.components.PanelBorder();
        diet_icon = new javax.swing.JLabel();
        guide_btn = new Resources.components.PanelBorder();
        diet_icon1 = new javax.swing.JLabel();
        other_btn = new Resources.components.PanelBorder();
        logout_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        body = new javax.swing.JLayeredPane();
        body_background = new Resources.components.PanelBorder();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        user_background.setBackground(new java.awt.Color(255, 255, 255));
        user_background.setLayout(new java.awt.BorderLayout());

        header_background.setBackground(new java.awt.Color(255, 255, 255));
        header_background.setPreferredSize(new java.awt.Dimension(1250, 80));

        header_panel.setBackground(new java.awt.Color(81, 199, 135));
        header_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile_btn.setBackground(new java.awt.Color(102, 102, 255));

        fits_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fits_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/fts-small-icon.png"))); // NOI18N

        greetings.setFont(new java.awt.Font("Cascadia Mono", 1, 16)); // NOI18N
        greetings.setForeground(new java.awt.Color(255, 255, 255));
        greetings.setText("Hi, (name)");

        javax.swing.GroupLayout profile_btnLayout = new javax.swing.GroupLayout(profile_btn);
        profile_btn.setLayout(profile_btnLayout);
        profile_btnLayout.setHorizontalGroup(
            profile_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profile_btnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fits_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(greetings, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        profile_btnLayout.setVerticalGroup(
            profile_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profile_btnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profile_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(greetings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fits_icon, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addContainerGap())
        );

        header_panel.add(profile_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 70));

        home_btn.setBackground(new java.awt.Color(50, 158, 100));
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

        home_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/home-icon.png"))); // NOI18N

        javax.swing.GroupLayout home_btnLayout = new javax.swing.GroupLayout(home_btn);
        home_btn.setLayout(home_btnLayout);
        home_btnLayout.setHorizontalGroup(
            home_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(home_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        home_btnLayout.setVerticalGroup(
            home_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(home_icon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        header_panel.add(home_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 140, 50));

        dashboard_btn.setBackground(new java.awt.Color(50, 158, 100));
        dashboard_btn.setPreferredSize(new java.awt.Dimension(40, 48));
        dashboard_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboard_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboard_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboard_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dashboard_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dashboard_btnMouseReleased(evt);
            }
        });

        dashboard_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/dashboard-icon.png"))); // NOI18N

        javax.swing.GroupLayout dashboard_btnLayout = new javax.swing.GroupLayout(dashboard_btn);
        dashboard_btn.setLayout(dashboard_btnLayout);
        dashboard_btnLayout.setHorizontalGroup(
            dashboard_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dashboard_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dashboard_btnLayout.setVerticalGroup(
            dashboard_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dashboard_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        header_panel.add(dashboard_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 140, 50));

        activity_btn.setBackground(new java.awt.Color(50, 158, 100));
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

        activity_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        activity_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/exercise-icon.png"))); // NOI18N

        javax.swing.GroupLayout activity_btnLayout = new javax.swing.GroupLayout(activity_btn);
        activity_btn.setLayout(activity_btnLayout);
        activity_btnLayout.setHorizontalGroup(
            activity_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(activity_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        activity_btnLayout.setVerticalGroup(
            activity_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(activity_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        header_panel.add(activity_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 140, 50));

        diet_btn.setBackground(new java.awt.Color(50, 158, 100));
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

        diet_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diet_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/diet-icon.png"))); // NOI18N

        javax.swing.GroupLayout diet_btnLayout = new javax.swing.GroupLayout(diet_btn);
        diet_btn.setLayout(diet_btnLayout);
        diet_btnLayout.setHorizontalGroup(
            diet_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(diet_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        diet_btnLayout.setVerticalGroup(
            diet_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(diet_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        header_panel.add(diet_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 140, 50));

        guide_btn.setBackground(new java.awt.Color(50, 158, 100));
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

        diet_icon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diet_icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/guide-icon.png"))); // NOI18N

        javax.swing.GroupLayout guide_btnLayout = new javax.swing.GroupLayout(guide_btn);
        guide_btn.setLayout(guide_btnLayout);
        guide_btnLayout.setHorizontalGroup(
            guide_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(diet_icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        guide_btnLayout.setVerticalGroup(
            guide_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(diet_icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        header_panel.add(guide_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 140, 50));

        other_btn.setBackground(new java.awt.Color(50, 158, 100));
        other_btn.setPreferredSize(new java.awt.Dimension(40, 48));
        other_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                other_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                other_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                other_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                other_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                other_btnMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout other_btnLayout = new javax.swing.GroupLayout(other_btn);
        other_btn.setLayout(other_btnLayout);
        other_btnLayout.setHorizontalGroup(
            other_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        other_btnLayout.setVerticalGroup(
            other_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        header_panel.add(other_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, 140, 50));

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
        header_panel.add(logout_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 20, -1, -1));

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
        header_panel.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1195, 20, -1, -1));

        javax.swing.GroupLayout header_backgroundLayout = new javax.swing.GroupLayout(header_background);
        header_background.setLayout(header_backgroundLayout);
        header_backgroundLayout.setHorizontalGroup(
            header_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE)
                .addContainerGap())
        );
        header_backgroundLayout.setVerticalGroup(
            header_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

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
        home_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_home_btnMouseEntered

    private void home_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_btnMouseExited
        home_btn.setBackground(new Color(50, 158, 100));
    }//GEN-LAST:event_home_btnMouseExited

    private void home_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_btnMousePressed
        home_btn.setBackground(new Color(40, 127, 80));
    }//GEN-LAST:event_home_btnMousePressed

    private void home_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_btnMouseReleased
        home_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_home_btnMouseReleased

    private void home_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_btnMouseClicked
        CardLayout cardLayout = (CardLayout) body.getLayout();
        cardLayout.show(body, "Home");
    }//GEN-LAST:event_home_btnMouseClicked

    private void dashboard_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard_btnMouseEntered
        dashboard_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_dashboard_btnMouseEntered

    private void dashboard_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard_btnMouseExited
        dashboard_btn.setBackground(new Color(50, 158, 100));
    }//GEN-LAST:event_dashboard_btnMouseExited

    private void dashboard_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard_btnMousePressed
        dashboard_btn.setBackground(new Color(40, 127, 80));
    }//GEN-LAST:event_dashboard_btnMousePressed

    private void dashboard_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard_btnMouseReleased
        dashboard_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_dashboard_btnMouseReleased

    private void dashboard_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard_btnMouseClicked
        CardLayout cardLayout = (CardLayout) body.getLayout();
        cardLayout.show(body, "Dashboard");
    }//GEN-LAST:event_dashboard_btnMouseClicked

    private void activity_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activity_btnMouseEntered
        activity_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_activity_btnMouseEntered

    private void activity_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activity_btnMouseExited
        activity_btn.setBackground(new Color(50, 158, 100));
    }//GEN-LAST:event_activity_btnMouseExited

    private void activity_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activity_btnMousePressed
        activity_btn.setBackground(new Color(40, 127, 80));
    }//GEN-LAST:event_activity_btnMousePressed

    private void activity_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activity_btnMouseReleased
        activity_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_activity_btnMouseReleased

    private void activity_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activity_btnMouseClicked
        CardLayout cardLayout = (CardLayout) body.getLayout();
        cardLayout.show(body, "Activity");
    }//GEN-LAST:event_activity_btnMouseClicked

    private void diet_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diet_btnMouseEntered
        diet_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_diet_btnMouseEntered

    private void diet_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diet_btnMouseExited
        diet_btn.setBackground(new Color(50, 158, 100));
    }//GEN-LAST:event_diet_btnMouseExited

    private void diet_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diet_btnMousePressed
        diet_btn.setBackground(new Color(40, 127, 80));
    }//GEN-LAST:event_diet_btnMousePressed

    private void diet_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diet_btnMouseReleased
        diet_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_diet_btnMouseReleased

    private void diet_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diet_btnMouseClicked
        CardLayout cardLayout = (CardLayout) body.getLayout();
        cardLayout.show(body, "Diet");
    }//GEN-LAST:event_diet_btnMouseClicked

    private void guide_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guide_btnMouseEntered
        guide_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_guide_btnMouseEntered

    private void guide_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guide_btnMouseExited
        guide_btn.setBackground(new Color(50, 158, 100));
    }//GEN-LAST:event_guide_btnMouseExited

    private void guide_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guide_btnMousePressed
        guide_btn.setBackground(new Color(40, 127, 80));
    }//GEN-LAST:event_guide_btnMousePressed

    private void guide_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guide_btnMouseReleased
        guide_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_guide_btnMouseReleased

    private void guide_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guide_btnMouseClicked
        CardLayout cardLayout = (CardLayout) body.getLayout();
        cardLayout.show(body, "Guide");
    }//GEN-LAST:event_guide_btnMouseClicked

    private void other_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_other_btnMouseEntered
        other_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_other_btnMouseEntered

    private void other_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_other_btnMouseExited
        other_btn.setBackground(new Color(50, 158, 100));
    }//GEN-LAST:event_other_btnMouseExited

    private void other_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_other_btnMousePressed
        other_btn.setBackground(new Color(40, 127, 80));
    }//GEN-LAST:event_other_btnMousePressed

    private void other_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_other_btnMouseReleased
        other_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_other_btnMouseReleased

    private void other_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_other_btnMouseClicked

    }//GEN-LAST:event_other_btnMouseClicked

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

        int id = 1;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserHome(id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Resources.components.PanelBorder activity_btn;
    private javax.swing.JLabel activity_icon;
    private javax.swing.JLayeredPane body;
    private Resources.components.PanelBorder body_background;
    private Resources.components.PanelBorder dashboard_btn;
    private javax.swing.JLabel dashboard_icon;
    private Resources.components.PanelBorder diet_btn;
    private javax.swing.JLabel diet_icon;
    private javax.swing.JLabel diet_icon1;
    private javax.swing.JButton exit_btn;
    private javax.swing.JLabel fits_icon;
    private javax.swing.JLabel greetings;
    private Resources.components.PanelBorder guide_btn;
    private Resources.components.PanelBorder header_background;
    private Resources.components.PanelBorder header_panel;
    private Resources.components.PanelBorder home_btn;
    private javax.swing.JLabel home_icon;
    private javax.swing.JButton logout_btn;
    private Resources.components.PanelBorder other_btn;
    private Resources.components.PanelBorder profile_btn;
    private Resources.components.PanelBorder user_background;
    // End of variables declaration//GEN-END:variables
}
