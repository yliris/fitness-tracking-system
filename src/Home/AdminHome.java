package Home;

import Account.LoginForm;
import Connection.DatabaseConnection;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AdminHome extends javax.swing.JFrame {

    public AdminHome() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(AdminHome.this);
        user_table.getTableHeader().setFont(new Font("Cascadia Mono", Font.BOLD, 12));
        user_table.getTableHeader().setOpaque(false);
        user_table.getTableHeader().setBackground(new Color(153,153,153));
        user_table.getTableHeader().setForeground(new Color(255,255,255));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new Resources.components.PanelBorder();
        greetings = new javax.swing.JLabel();
        exit_btn = new javax.swing.JButton();
        panelBorder2 = new Resources.components.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        user_table = new javax.swing.JTable();
        search_field = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        logout_btn = new javax.swing.JButton();
        mover = new Resources.components.PanelMover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        greetings.setFont(new java.awt.Font("Cascadia Mono", 1, 24)); // NOI18N
        greetings.setText("Hello, Admin!");
        panelBorder1.add(greetings, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

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
        panelBorder1.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 5, 30, 30));

        panelBorder2.setBackground(new java.awt.Color(153, 153, 255));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user_table.setBackground(new java.awt.Color(102, 102, 102));
        user_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Username", "First Name", "Last Name", "Weight", "Height", "BMI"
            }
        ));
        user_table.setFocusable(false);
        user_table.setGridColor(new java.awt.Color(51, 51, 51));
        user_table.setRowHeight(25);
        user_table.setSelectionBackground(new java.awt.Color(153, 153, 153));
        user_table.setSelectionForeground(new java.awt.Color(238, 144, 144));
        user_table.setShowGrid(false);
        user_table.setShowHorizontalLines(true);
        user_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(user_table);

        panelBorder2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 940, 310));
        panelBorder2.add(search_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 270, -1));

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User Information Table");
        panelBorder2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 20));

        panelBorder1.add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 960, 360));

        logout_btn.setText("logout");
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
        panelBorder1.add(logout_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, -1, -1));
        panelBorder1.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 20));

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 540));

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

    private void logout_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMouseEntered
        
    }//GEN-LAST:event_logout_btnMouseEntered

    private void logout_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMouseExited
        
    }//GEN-LAST:event_logout_btnMouseExited

    private void logout_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMousePressed
        
    }//GEN-LAST:event_logout_btnMousePressed

    private void logout_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMouseReleased
        
    }//GEN-LAST:event_logout_btnMouseReleased

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        
    }//GEN-LAST:event_logout_btnActionPerformed
    
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
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit_btn;
    private javax.swing.JLabel greetings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout_btn;
    private Resources.components.PanelMover mover;
    private Resources.components.PanelBorder panelBorder1;
    private Resources.components.PanelBorder panelBorder2;
    private javax.swing.JTextField search_field;
    private javax.swing.JTable user_table;
    // End of variables declaration//GEN-END:variables
}
