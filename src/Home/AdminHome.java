package Home;

import Account.LoginForm;
import Account.EditForm;
import Connection.DatabaseConnection;
import Resources.components.TableActionCellEditor;
import Resources.components.TableActionCellRender;
import Resources.components.TableActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class AdminHome extends javax.swing.JFrame {

    public AdminHome() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(AdminHome.this);
        loadDataToTable();
        updateTotalUsers();
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row: " + row);
            }

            @Override
            public void onDelete(int row) {
                deleteUser(row);
            }
        };
        user_table.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
        user_table.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event));
    }

    private void loadDataToTable() {
        DefaultTableModel model = (DefaultTableModel) user_table.getModel();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT user_id, first_name, last_name, username, weight, height FROM tb_users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            model.setRowCount(0);

            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String username = rs.getString("username");

                float getWeight = rs.getFloat("weight");
                float getHeight = rs.getFloat("height");

                String weight = getWeight + " kg";
                String height = getHeight + " cm";

                float meterHeight = getHeight / 100;
                int calculateBMI = (int) (getWeight / (meterHeight * meterHeight));
                String BMI = calculateBMI + " kg/m²";

                model.addRow(new Object[]{userId, firstName, lastName, username, weight, height, BMI});
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTotalUsers() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String totalUserQuery = "SELECT COUNT(*) FROM tb_users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(totalUserQuery);

            if (rs.next()) {
                int totalUsers = rs.getInt(1);
                total_users.setText("Total Users = " + totalUsers);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading total users: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteUser(int row) {
        int selectedRow = user_table.getSelectedRow();

        if (user_table.isEditing()) {
            user_table.getCellEditor().stopCellEditing();
        }

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "No row selected!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) user_table.getModel();

        if (selectedRow >= model.getRowCount()) {
            JOptionPane.showMessageDialog(this, "Invalid row selected!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int userID = (int) model.getValueAt(selectedRow, 0);

        int confirmDelete = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this user?",
                "Delete User",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmDelete == JOptionPane.YES_OPTION) {
            try {
                Connection conn = DatabaseConnection.getConnection();

                String deleteUserQuery = "DELETE FROM tb_users WHERE user_id = ?";
                PreparedStatement stmt = conn.prepareStatement(deleteUserQuery);
                stmt.setInt(1, userID);

                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    model.removeRow(selectedRow);

                    JOptionPane.showMessageDialog(this, "User deleted successfully!",
                            "Success", JOptionPane.INFORMATION_MESSAGE);

                    user_table.clearSelection();
                    user_table.revalidate();
                    user_table.repaint();

                    updateTotalUsers();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete user.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error deleting user: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void editUser(int row) {
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new Resources.components.PanelBorder();
        greetings = new javax.swing.JLabel();
        exit_btn = new javax.swing.JButton();
        logout_btn = new javax.swing.JButton();
        admin_header = new Resources.components.PanelBorder();
        usertable_btn = new javax.swing.JButton();
        adduser_btn = new javax.swing.JButton();
        admin_panels = new javax.swing.JTabbedPane();
        user_table_panel = new Resources.components.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        user_table = new javax.swing.JTable();
        total_users = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        adduser_panel = new Resources.components.PanelBorder();
        background = new Resources.components.PanelBorder();
        mover = new Resources.components.PanelMover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        greetings.setFont(new java.awt.Font("Cascadia Mono", 1, 24)); // NOI18N
        greetings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/admin-icon.png"))); // NOI18N
        greetings.setText("Hello, Admin!");
        greetings.setIconTextGap(10);
        panelBorder1.add(greetings, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 50));

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
        panelBorder1.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 20, -1, -1));

        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-idle.png"))); // NOI18N
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
        panelBorder1.add(logout_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1195, 20, -1, -1));

        admin_header.setBackground(new java.awt.Color(153, 153, 153));
        admin_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usertable_btn.setText("User Table");
        usertable_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertable_btnActionPerformed(evt);
            }
        });
        admin_header.add(usertable_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        adduser_btn.setText("Add User");
        adduser_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adduser_btnActionPerformed(evt);
            }
        });
        admin_header.add(adduser_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 90, -1));

        panelBorder1.add(admin_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1260, 40));

        user_table_panel.setBackground(new java.awt.Color(153, 153, 153));
        user_table_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Information Table");
        user_table_panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 60, 180, 30));

        user_table.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "First Name", "Last Name", "Username", "Weight", "Height", "BMI", "Actions"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        user_table.setRowHeight(40);
        user_table.setSelectionBackground(new java.awt.Color(153, 153, 255));
        user_table.setShowHorizontalLines(true);
        user_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(user_table);

        user_table_panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1240, 510));

        total_users.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        total_users.setForeground(new java.awt.Color(255, 255, 255));
        total_users.setText("Total Users =");
        user_table_panel.add(total_users, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1240, 50));
        user_table_panel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 60, 280, 30));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/search-icon.png"))); // NOI18N
        user_table_panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 60, 30, 30));

        admin_panels.addTab("tab1", user_table_panel);

        adduser_panel.setBackground(new java.awt.Color(153, 153, 153));
        adduser_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        admin_panels.addTab("tab2", adduser_panel);

        panelBorder1.add(admin_panels, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1260, 640));

        background.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1260, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        panelBorder1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1260, 640));
        panelBorder1.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 20));

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

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
        int confirmExit = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to quit?",
                "Quit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmExit == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_exit_btnActionPerformed

    private void logout_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMouseEntered
        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-hover.png")));
    }//GEN-LAST:event_logout_btnMouseEntered

    private void logout_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMouseExited
        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-idle.png")));
    }//GEN-LAST:event_logout_btnMouseExited

    private void logout_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMousePressed
        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-idle.png")));
    }//GEN-LAST:event_logout_btnMousePressed

    private void logout_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMouseReleased
        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-hover.png")));
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

    private void usertable_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertable_btnActionPerformed
        admin_panels.setSelectedIndex(0);
    }//GEN-LAST:event_usertable_btnActionPerformed

    private void adduser_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adduser_btnActionPerformed
        admin_panels.setSelectedIndex(1);
    }//GEN-LAST:event_adduser_btnActionPerformed

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
    private javax.swing.JButton adduser_btn;
    private Resources.components.PanelBorder adduser_panel;
    private Resources.components.PanelBorder admin_header;
    private javax.swing.JTabbedPane admin_panels;
    private Resources.components.PanelBorder background;
    private javax.swing.JButton exit_btn;
    private javax.swing.JLabel greetings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton logout_btn;
    private Resources.components.PanelMover mover;
    private Resources.components.PanelBorder panelBorder1;
    private javax.swing.JLabel total_users;
    private javax.swing.JTable user_table;
    private Resources.components.PanelBorder user_table_panel;
    private javax.swing.JButton usertable_btn;
    // End of variables declaration//GEN-END:variables
}
