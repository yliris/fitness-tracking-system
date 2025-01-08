package Home;

import Account.LoginForm;
import Connection.DatabaseConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UserHomeTest extends javax.swing.JFrame {

    private int userID;

    public UserHomeTest(int userID) {
        this.userID = userID;
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(UserHomeTest.this);
        loadTableData();
        initializeTableModel();
    }

    private void initializeTableModel() {
        activity_table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Day", "Activity", "Sets", "Reps", "Completed"}
        ) {
            Class[] types = new Class[]{
                String.class, String.class, String.class, String.class, Boolean.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user_panel = new Resources.components.PanelBorder();
        mover = new Resources.components.PanelMover();
        navigation_panel = new Resources.components.PanelBorder();
        home_btn = new javax.swing.JButton();
        activity_btn = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        header_panel = new Resources.components.PanelBorder();
        exit_btn = new javax.swing.JButton();
        body_panel = new javax.swing.JTabbedPane();
        home_panel = new javax.swing.JPanel();
        activity_panel = new javax.swing.JPanel();
        day_cbox = new javax.swing.JComboBox<>();
        actname_field = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        actsets_field = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        actreps_field = new javax.swing.JTextField();
        activity_delete_btn = new javax.swing.JButton();
        activity_add_btn = new javax.swing.JButton();
        activity_update_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        activity_table = new javax.swing.JTable();
        activity_complete_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user_panel.setBackground(new java.awt.Color(255, 255, 255));
        user_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        user_panel.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 20));

        navigation_panel.setBackground(new java.awt.Color(51, 51, 51));
        navigation_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home_btn.setText("home");
        home_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_btnActionPerformed(evt);
            }
        });
        navigation_panel.add(home_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        activity_btn.setText("activity");
        activity_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activity_btnActionPerformed(evt);
            }
        });
        navigation_panel.add(activity_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        logout.setText("logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        navigation_panel.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        user_panel.add(navigation_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 720));

        header_panel.setBackground(new java.awt.Color(153, 153, 153));
        header_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        header_panel.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 10, -1, -1));

        user_panel.add(header_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 50));

        home_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        body_panel.addTab("tab1", home_panel);

        activity_panel.setBackground(new java.awt.Color(204, 204, 255));
        activity_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        day_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select Day--", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        activity_panel.add(day_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, -1));
        activity_panel.add(actname_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 170, -1));

        jLabel1.setText("act name");
        activity_panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel2.setText("sets");
        activity_panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));
        activity_panel.add(actsets_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 170, -1));

        jLabel3.setText("reps");
        activity_panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        activity_panel.add(actreps_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 170, -1));

        activity_delete_btn.setText("delete");
        activity_delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activity_delete_btnActionPerformed(evt);
            }
        });
        activity_panel.add(activity_delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        activity_add_btn.setText("add");
        activity_add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activity_add_btnActionPerformed(evt);
            }
        });
        activity_panel.add(activity_add_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        activity_update_btn.setText("update");
        activity_update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activity_update_btnActionPerformed(evt);
            }
        });
        activity_panel.add(activity_update_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        activity_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Day", "Activity", "Sets", "Reps", "Completed"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(activity_table);

        activity_panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 830, -1));

        activity_complete_btn.setText("Complete");
        activity_complete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activity_complete_btnActionPerformed(evt);
            }
        });
        activity_panel.add(activity_complete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 480, -1, -1));

        body_panel.addTab("tab2", activity_panel);

        user_panel.add(body_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 1090, 720));

        getContentPane().add(user_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loadTableData() {
        DefaultTableModel model = (DefaultTableModel) activity_table.getModel();
        model.setRowCount(0);

        String query = "SELECT * FROM tb_activity WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(query)) {

            pst.setInt(1, this.userID);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[rs.getMetaData().getColumnCount()];
                for (int i = 0; i < row.length; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearTableData() {
        DefaultTableModel model = (DefaultTableModel) activity_table.getModel();
        model.setRowCount(0);
    }
    
    private void logout() {
        clearTableData();
        dispose();
        new LoginForm().setVisible(true);
    }

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

    private void exit_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseReleased
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btnMouseReleased

    private void exit_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMousePressed
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-click.png")));
    }//GEN-LAST:event_exit_btnMousePressed

    private void exit_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseExited
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-idle.png")));
    }//GEN-LAST:event_exit_btnMouseExited

    private void exit_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseEntered
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btnMouseEntered

    private void home_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_btnActionPerformed
        body_panel.setSelectedIndex(0);
    }//GEN-LAST:event_home_btnActionPerformed

    private void activity_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activity_btnActionPerformed
        body_panel.setSelectedIndex(1);
    }//GEN-LAST:event_activity_btnActionPerformed

    private void activity_add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activity_add_btnActionPerformed
        String day = day_cbox.getSelectedItem().toString();
        String activityName = actname_field.getText().trim();
        String sets = actsets_field.getText().trim();
        String reps = actreps_field.getText().trim();
        String status = "Incomplete";

        //CHECK IF CHECKBOX HAS INVALID SELECTION
        if (day.equals("--Select Day--")) {
            JOptionPane.showMessageDialog(this, "Please select a day.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF ACTIVITY NAME IS EMPTY
        if (activityName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Activity Name cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String insertQuery = "INSERT INTO tb_activity"
                + "(user_id, day, activity_name, sets, reps, status)"
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(insertQuery)) {
            pst.setInt(1, userID);
            pst.setString(2, day);
            pst.setString(3, activityName);
            pst.setString(4, sets.isEmpty() ? null : sets);
            pst.setString(5, reps.isEmpty() ? null : reps);
            pst.setString(6, status);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Activity added successfully.");
                loadTableData();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add activity.", "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_activity_add_btnActionPerformed

    private void activity_update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activity_update_btnActionPerformed

    }//GEN-LAST:event_activity_update_btnActionPerformed

    private void activity_delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activity_delete_btnActionPerformed

    }//GEN-LAST:event_activity_delete_btnActionPerformed

    private void activity_complete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activity_complete_btnActionPerformed

    }//GEN-LAST:event_activity_complete_btnActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        logout();
    }//GEN-LAST:event_logoutActionPerformed

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
            java.util.logging.Logger.getLogger(UserHomeTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserHomeTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserHomeTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserHomeTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        int userID = 1;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserHomeTest(userID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton activity_add_btn;
    private javax.swing.JButton activity_btn;
    private javax.swing.JButton activity_complete_btn;
    private javax.swing.JButton activity_delete_btn;
    private javax.swing.JPanel activity_panel;
    private javax.swing.JTable activity_table;
    private javax.swing.JButton activity_update_btn;
    private javax.swing.JTextField actname_field;
    private javax.swing.JTextField actreps_field;
    private javax.swing.JTextField actsets_field;
    private javax.swing.JTabbedPane body_panel;
    private javax.swing.JComboBox<String> day_cbox;
    private javax.swing.JButton exit_btn;
    private Resources.components.PanelBorder header_panel;
    private javax.swing.JButton home_btn;
    private javax.swing.JPanel home_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout;
    private Resources.components.PanelMover mover;
    private Resources.components.PanelBorder navigation_panel;
    private Resources.components.PanelBorder user_panel;
    // End of variables declaration//GEN-END:variables
}
