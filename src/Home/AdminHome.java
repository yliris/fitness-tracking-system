package Home;

import Account.LoginForm;
import Connection.DatabaseConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminHome extends javax.swing.JFrame {

    public AdminHome() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(AdminHome.this);
        loadUserDataToTable();
        loadTotalUsers();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new Resources.components.PanelBorder();
        greetings = new javax.swing.JLabel();
        exit_btn = new javax.swing.JButton();
        logout_btn = new javax.swing.JButton();
        panelBorder2 = new Resources.components.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        user_table = new javax.swing.JTable();
        total_users = new javax.swing.JLabel();
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
        panelBorder1.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 5, -1, -1));

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
        panelBorder1.add(logout_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 5, -1, -1));

        panelBorder2.setBackground(new java.awt.Color(153, 153, 255));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Information Table");
        panelBorder2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 60, 180, 30));

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
        user_table.setSelectionBackground(new java.awt.Color(45, 153, 69));
        user_table.setShowHorizontalLines(true);
        user_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(user_table);

        panelBorder2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 90, 940, 360));

        total_users.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        total_users.setForeground(new java.awt.Color(255, 255, 255));
        total_users.setText("Total Users =");
        panelBorder2.add(total_users, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 940, 50));

        panelBorder1.add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 960, 460));
        panelBorder1.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 20));

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void loadUserDataToTable() {
        DefaultTableModel model = (DefaultTableModel) user_table.getModel();
        model.setRowCount(0);

        String userDataQuery = "SELECT user_id, first_name, last_name, username, weight, height FROM tb_users";

        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM tb_users")) {

            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String username = rs.getString("username");

                float getWeight = rs.getFloat("weight");
                float getHeight = rs.getFloat("height");
                String weight = getWeight + " kg";
                String height = getHeight + " cm";

                float meterheight = getHeight / 100;
                int calculateBMI = (int) (getWeight / (meterheight * meterheight));
                String BMI = calculateBMI + " kg/m²";

                model.addRow(new Object[]{userId, firstName, lastName, username, weight, height, BMI, "Actions"});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
        }
    }

    public class NonEditableTableModel extends DefaultTableModel {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }
    
    private void loadTotalUsers() {
        String countUserQuery = "SELECT COUNT(*) AS total FROM tb_users";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(countUserQuery)) {
            if(rs.next()) {
                int total = rs.getInt("total");
                total_users.setText("Total Users = " + total);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving total users: " + e.getMessage());
        }
    }

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
    private javax.swing.JLabel total_users;
    private javax.swing.JTable user_table;
    // End of variables declaration//GEN-END:variables
}
