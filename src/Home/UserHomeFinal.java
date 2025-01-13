package Home;

import Account.LoginForm;
import java.awt.Color;
import javax.swing.JOptionPane;

public class UserHomeFinal extends javax.swing.JFrame {

    public UserHomeFinal() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(UserHomeFinal.this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home_background = new Resources.components.PanelBorder();
        home_header_background = new Resources.components.PanelBorder();
        home_header = new Resources.components.PanelBorder();
        logout_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        profile_panel = new Resources.components.PanelBorder();
        jLabel7 = new javax.swing.JLabel();
        greetings = new javax.swing.JLabel();
        home_btn = new Resources.components.PanelBorder();
        home = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dashboard_btn = new Resources.components.PanelBorder();
        home1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        activity_btn = new Resources.components.PanelBorder();
        home2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        diet_btn = new Resources.components.PanelBorder();
        home3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        guide_btn = new Resources.components.PanelBorder();
        home4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mover = new Resources.components.PanelMover();
        home_body = new Resources.components.PanelBorder();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home_background.setBackground(new java.awt.Color(255, 255, 255));
        home_background.setLayout(new java.awt.BorderLayout());

        home_header_background.setBackground(new java.awt.Color(255, 255, 255));
        home_header_background.setPreferredSize(new java.awt.Dimension(1440, 80));
        home_header_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home_header.setBackground(new java.awt.Color(81, 199, 135));
        home_header.setPreferredSize(new java.awt.Dimension(1405, 80));
        home_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        home_header.add(logout_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1337, 14, -1, -1));

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
        home_header.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1374, 14, -1, -1));

        profile_panel.setBackground(new java.awt.Color(102, 102, 255));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/fts-small-icon.png"))); // NOI18N

        greetings.setFont(new java.awt.Font("Cascadia Mono", 1, 16)); // NOI18N
        greetings.setForeground(new java.awt.Color(255, 255, 255));
        greetings.setText("Hi, (name)");

        javax.swing.GroupLayout profile_panelLayout = new javax.swing.GroupLayout(profile_panel);
        profile_panel.setLayout(profile_panelLayout);
        profile_panelLayout.setHorizontalGroup(
            profile_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profile_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(182, Short.MAX_VALUE))
            .addGroup(profile_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profile_panelLayout.createSequentialGroup()
                    .addContainerGap(49, Short.MAX_VALUE)
                    .addComponent(greetings, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        profile_panelLayout.setVerticalGroup(
            profile_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profile_panelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(profile_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(profile_panelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(greetings, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        home_header.add(profile_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 60));

        home_btn.setBackground(new java.awt.Color(50, 158, 100));
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

        home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/home-icon.png"))); // NOI18N
        home_btn.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("  HOME");
        home_btn.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 120, 40));

        home_header.add(home_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 160, 40));

        dashboard_btn.setBackground(new java.awt.Color(50, 158, 100));
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
        dashboard_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/dashboard-icon.png"))); // NOI18N
        dashboard_btn.add(home1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("  DASHBOARD");
        dashboard_btn.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 120, 40));

        home_header.add(dashboard_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 160, 40));

        activity_btn.setBackground(new java.awt.Color(50, 158, 100));
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

        home2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/exercise-icon.png"))); // NOI18N
        activity_btn.add(home2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("EXERCISE");
        activity_btn.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 120, 40));

        home_header.add(activity_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 160, 40));

        diet_btn.setBackground(new java.awt.Color(50, 158, 100));
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

        home3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/diet-icon.png"))); // NOI18N
        diet_btn.add(home3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DIET");
        diet_btn.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 120, 40));

        home_header.add(diet_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 160, 40));

        guide_btn.setBackground(new java.awt.Color(50, 158, 100));
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

        home4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/guide-icon.png"))); // NOI18N
        guide_btn.add(home4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("GUIDE");
        guide_btn.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 120, 40));

        home_header.add(guide_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 160, 40));

        home_header_background.add(home_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1420, 60));
        home_header_background.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 20));

        home_background.add(home_header_background, java.awt.BorderLayout.PAGE_START);

        home_body.setBackground(new java.awt.Color(255, 255, 255));
        home_body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        home_background.add(home_body, java.awt.BorderLayout.CENTER);

        getContentPane().add(home_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 740));

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

    private void home_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_btnMouseClicked
        
    }//GEN-LAST:event_home_btnMouseClicked

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

    private void dashboard_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard_btnMouseClicked
        
    }//GEN-LAST:event_dashboard_btnMouseClicked

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

    private void activity_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activity_btnMouseClicked
        
    }//GEN-LAST:event_activity_btnMouseClicked

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

    private void diet_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diet_btnMouseClicked
        
    }//GEN-LAST:event_diet_btnMouseClicked

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

    private void guide_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guide_btnMouseClicked
        
    }//GEN-LAST:event_guide_btnMouseClicked

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
            java.util.logging.Logger.getLogger(UserHomeFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserHomeFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserHomeFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserHomeFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserHomeFinal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Resources.components.PanelBorder activity_btn;
    private Resources.components.PanelBorder dashboard_btn;
    private Resources.components.PanelBorder diet_btn;
    private javax.swing.JButton exit_btn;
    private javax.swing.JLabel greetings;
    private Resources.components.PanelBorder guide_btn;
    private javax.swing.JLabel home;
    private javax.swing.JLabel home1;
    private javax.swing.JLabel home2;
    private javax.swing.JLabel home3;
    private javax.swing.JLabel home4;
    private Resources.components.PanelBorder home_background;
    private Resources.components.PanelBorder home_body;
    private Resources.components.PanelBorder home_btn;
    private Resources.components.PanelBorder home_header;
    private Resources.components.PanelBorder home_header_background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton logout_btn;
    private Resources.components.PanelMover mover;
    private Resources.components.PanelBorder profile_panel;
    // End of variables declaration//GEN-END:variables
}
