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
        mover = new Resources.components.PanelMover();
        home_body = new Resources.components.PanelBorder();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home_background.setBackground(new java.awt.Color(255, 255, 255));
        home_background.setLayout(new java.awt.BorderLayout());

        home_header_background.setBackground(new java.awt.Color(255, 255, 255));
        home_header_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home_header.setBackground(new java.awt.Color(81, 199, 135));
        home_header.setPreferredSize(new java.awt.Dimension(1405, 80));

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

        javax.swing.GroupLayout home_headerLayout = new javax.swing.GroupLayout(home_header);
        home_header.setLayout(home_headerLayout);
        home_headerLayout.setHorizontalGroup(
            home_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_headerLayout.createSequentialGroup()
                .addContainerGap(1335, Short.MAX_VALUE)
                .addComponent(logout_btn)
                .addGap(5, 5, 5)
                .addComponent(exit_btn)
                .addGap(16, 16, 16))
        );
        home_headerLayout.setVerticalGroup(
            home_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, home_headerLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(home_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logout_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exit_btn))
                .addGap(24, 24, 24))
        );

        home_header_background.add(home_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1420, -1));
        home_header_background.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 20));

        home_background.add(home_header_background, java.awt.BorderLayout.PAGE_START);

        home_body.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout home_bodyLayout = new javax.swing.GroupLayout(home_body);
        home_body.setLayout(home_bodyLayout);
        home_bodyLayout.setHorizontalGroup(
            home_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1440, Short.MAX_VALUE)
        );
        home_bodyLayout.setVerticalGroup(
            home_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

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
    private javax.swing.JButton exit_btn;
    private Resources.components.PanelBorder home_background;
    private Resources.components.PanelBorder home_body;
    private Resources.components.PanelBorder home_header;
    private Resources.components.PanelBorder home_header_background;
    private javax.swing.JButton logout_btn;
    private Resources.components.PanelMover mover;
    // End of variables declaration//GEN-END:variables
}
