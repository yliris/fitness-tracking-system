package Home;

import Account.LoginForm;
import Account.EditForm;
import Connection.DatabaseConnection;
import Resources.components.TableActionCellEditor;
import Resources.components.TableActionCellRender;
import Resources.components.TableActionEvent;
import Resources.components.UtilityMethods.DefaultFocus;
import static Resources.components.UtilityMethods.DefaultText2;
import static Resources.components.UtilityMethods.TransparentField2;
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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class AdminHome extends javax.swing.JFrame {

    public AdminHome() {
        initComponents();
        TransparentField2(user_searchbar);
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(AdminHome.this);
        loadDataToTable();
        updateTotalUsers();

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        user_table.getTableHeader().setDefaultRenderer(headerRenderer);

        JTableHeader header = user_table.getTableHeader();
        header.setBackground(new Color(255, 255, 255));
        header.setForeground(new Color(51, 51, 51));

        centerTableData();

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                editUser(row);
            }

            @Override
            public void onDelete(int row) {
                deleteUser(row);
            }
        };
        user_table.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRender());
        user_table.getColumnModel().getColumn(8).setCellEditor(new TableActionCellEditor(event));
    }

    private void loadDataToTable() {
        DefaultTableModel model = (DefaultTableModel) user_table.getModel();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT user_id, first_name, last_name, email, username, weight, height FROM tb_users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            model.setRowCount(0);

            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String username = rs.getString("username");

                Float getWeight = rs.getObject("weight", Float.class);
                Float getHeight = rs.getObject("height", Float.class);

                String weight = (getWeight != null) ? getWeight + " kg" : "N/A";
                String height = (getHeight != null) ? getHeight + " cm" : "N/A";

                String BMI = "N/A";
                if (getWeight != null && getHeight != null) {
                    float meterHeight = getHeight / 100;
                    int calculateBMI = (int) (getWeight / (meterHeight * meterHeight));
                    BMI = calculateBMI + " kg/m²";
                }

                model.addRow(new Object[]{userId, firstName, lastName, email, username, weight, height, BMI});
            }

            user_table.setBackground(new Color(255, 255, 255));

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void refreshUserTable() {
        loadDataToTable();
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
        if (user_table.isEditing()) {
            user_table.getCellEditor().stopCellEditing();
        }

        DefaultTableModel model = (DefaultTableModel) user_table.getModel();

        if (row < 0 || row >= model.getRowCount()) {
            JOptionPane.showMessageDialog(this, "Invalid row selected!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int userId = (int) model.getValueAt(row, 0);
        String firstName = (String) model.getValueAt(row, 1);
        String lastName = (String) model.getValueAt(row, 2);
        String email = (String) model.getValueAt(row, 3);
        String username = (String) model.getValueAt(row, 4);
        String weight = (String) model.getValueAt(row, 5);
        String height = (String) model.getValueAt(row, 6);

        EditForm editForm = new EditForm(this, userId, firstName, lastName, email, username);
        editForm.setVisible(true);
    }

    private void centerTableData() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        for (int i = 0; i < user_table.getColumnCount() - 1; i++) {
            user_table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
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
        user_searchbar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        adduser_panel = new Resources.components.PanelBorder();
        password_check = new javax.swing.JToggleButton();
        first_name_field = new javax.swing.JTextField();
        last_name_field = new javax.swing.JTextField();
        email_field = new javax.swing.JTextField();
        username_field = new javax.swing.JTextField();
        password_field = new javax.swing.JPasswordField();
        sec_question_field = new javax.swing.JTextField();
        sec_answer_field = new javax.swing.JTextField();
        add_btn = new javax.swing.JButton();
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
        panelBorder1.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, -1, -1));

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
        panelBorder1.add(logout_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(905, 20, -1, -1));

        admin_header.setBackground(new java.awt.Color(142, 142, 255));
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

        panelBorder1.add(admin_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 960, 40));

        admin_panels.setBackground(new java.awt.Color(142, 142, 255));

        user_table_panel.setBackground(new java.awt.Color(142, 142, 255));
        user_table_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Information Table");
        user_table_panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 60, 180, 30));

        user_table.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        user_table.setForeground(new java.awt.Color(51, 51, 51));
        user_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "First Name", "Last Name", "Email", "Username", "Weight", "Height", "BMI", "Actions"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        user_table.setGridColor(new java.awt.Color(255, 255, 255));
        user_table.setRowHeight(40);
        user_table.setSelectionBackground(new java.awt.Color(137, 229, 137));
        user_table.setSelectionForeground(new java.awt.Color(255, 255, 255));
        user_table.setShowHorizontalLines(true);
        user_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(user_table);
        if (user_table.getColumnModel().getColumnCount() > 0) {
            user_table.getColumnModel().getColumn(0).setMinWidth(1);
            user_table.getColumnModel().getColumn(0).setPreferredWidth(3);
            user_table.getColumnModel().getColumn(1).setMinWidth(1);
            user_table.getColumnModel().getColumn(1).setPreferredWidth(60);
            user_table.getColumnModel().getColumn(2).setMinWidth(1);
            user_table.getColumnModel().getColumn(2).setPreferredWidth(40);
            user_table.getColumnModel().getColumn(3).setMinWidth(1);
            user_table.getColumnModel().getColumn(4).setMinWidth(1);
            user_table.getColumnModel().getColumn(4).setPreferredWidth(40);
            user_table.getColumnModel().getColumn(5).setMinWidth(1);
            user_table.getColumnModel().getColumn(5).setPreferredWidth(15);
            user_table.getColumnModel().getColumn(6).setMinWidth(1);
            user_table.getColumnModel().getColumn(6).setPreferredWidth(15);
            user_table.getColumnModel().getColumn(7).setMinWidth(1);
            user_table.getColumnModel().getColumn(7).setPreferredWidth(15);
            user_table.getColumnModel().getColumn(8).setMinWidth(10);
            user_table.getColumnModel().getColumn(8).setPreferredWidth(10);
        }

        user_table_panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 940, 330));

        total_users.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        total_users.setForeground(new java.awt.Color(255, 255, 255));
        total_users.setText("Total Users =");
        user_table_panel.add(total_users, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 940, 50));

        user_searchbar.setText("Search User");
        user_searchbar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                user_searchbarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                user_searchbarFocusLost(evt);
            }
        });
        user_searchbar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                user_searchbarKeyReleased(evt);
            }
        });
        user_table_panel.add(user_searchbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 280, 30));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/search-icon.png"))); // NOI18N
        user_table_panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 30, 30));

        admin_panels.addTab("tab1", user_table_panel);

        adduser_panel.setBackground(new java.awt.Color(142, 142, 255));
        adduser_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        password_check.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        password_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/eye-close.png"))); // NOI18N
        password_check.setAlignmentY(0.0F);
        password_check.setBorder(null);
        password_check.setBorderPainted(false);
        password_check.setContentAreaFilled(false);
        password_check.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        password_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_checkActionPerformed(evt);
            }
        });
        adduser_panel.add(password_check, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 234, 20, 20));

        first_name_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        adduser_panel.add(first_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 160, -1));

        last_name_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        adduser_panel.add(last_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 160, -1));

        email_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        adduser_panel.add(email_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 330, -1));

        username_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        adduser_panel.add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 330, -1));

        password_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        adduser_panel.add(password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 330, -1));

        sec_question_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        adduser_panel.add(sec_question_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 330, -1));

        sec_answer_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        adduser_panel.add(sec_answer_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 330, -1));

        add_btn.setBackground(new java.awt.Color(102, 102, 255));
        add_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        add_btn.setForeground(new java.awt.Color(255, 255, 255));
        add_btn.setText("SIGN UP");
        add_btn.setAlignmentY(0.0F);
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });
        adduser_panel.add(add_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 330, 110));

        admin_panels.addTab("tab2", adduser_panel);

        panelBorder1.add(admin_panels, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 960, 460));

        background.setBackground(new java.awt.Color(142, 142, 255));

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        panelBorder1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 960, 460));
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

    private void user_searchbarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_user_searchbarKeyReleased
        DefaultTableModel model = (DefaultTableModel) user_table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        user_table.setRowSorter(sorter);

        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + user_searchbar.getText()));
    }//GEN-LAST:event_user_searchbarKeyReleased

    private void user_searchbarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_searchbarFocusGained
        DefaultText2(user_searchbar, "Search User", DefaultFocus.GAINED);
    }//GEN-LAST:event_user_searchbarFocusGained

    private void user_searchbarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_searchbarFocusLost
        DefaultText2(user_searchbar, "Search User", DefaultFocus.LOST);
    }//GEN-LAST:event_user_searchbarFocusLost

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        String firstname = first_name_field.getText().trim();
        String lastname = last_name_field.getText().trim();
        String email = email_field.getText().trim();
        String username = username_field.getText().trim();
        String password = String.valueOf(password_field.getPassword()).trim();
        String sec_question = sec_question_field.getText().trim();
        String sec_answer = sec_answer_field.getText().trim();

        //CHECK IF FIRST AND LAST NAME HAS INVALID CHARACTERS
        if (!firstname.matches("^[a-zA-Z]+([- ][a-zA-Z]+)*$")) {
            JOptionPane.showMessageDialog(null, "First name must only contain letters, spaces, or hyphens.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!lastname.matches("^[a-zA-Z]+([- ][a-zA-Z]+)*$")) {
            JOptionPane.showMessageDialog(null, "Last name must only contain letters, spaces, or hyphens.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF EMAIL IS VALID
        if (!email.endsWith("@gmail.com")) {
            JOptionPane.showMessageDialog(null, "Email is invalid.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        //CHECK IF USERNAME CONTAINS SPACE
        if (username.contains(" ")) {
            JOptionPane.showMessageDialog(null, "Usernames cannot contain spaces.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF USERNAME IS 16 AND BELOW
        if (username.length() > 16 || username.length() < 1) {
            JOptionPane.showMessageDialog(null, "Usernames must be 1-16 characters long.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF USERNAME HAS INVALID CHARACTERS
        if (!username.matches("^[a-zA-Z0-9._-]+$")) {
            JOptionPane.showMessageDialog(null, "Only periods, underscores, and dashes are allowed.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF USERNAME HAS ADMIN CREDENTIALS
        if (username.equals("admin1") || username.equals("admin2") || username.equals("admin3")
                || username.equals("admin4") || username.equals("admin5")) {
            JOptionPane.showMessageDialog(null, "This username is already taken", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF PASSWORD IS STRONG
        if (password.length() < 8) {
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //NO SQL INJECTION OR HTML TAGS
        if (username.matches(".*<.*>.*") || firstname.matches(".*<.*>.*") || lastname.matches(".*<.*>.*")) {
            JOptionPane.showMessageDialog(null, "Fields cannot contain HTML tags.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PreparedStatement ps;
        ResultSet rs;

        String checkNameQuery = "SELECT * FROM `tb_users` WHERE `first_name` = ? AND `last_name` = ?";
        String checkEmailQuery = "SELECT * FROM `tb_users` WHERE `email` = ?";
        String checkUsernameQuery = "SELECT * FROM `tb_users` WHERE `username` = ?";

        try {
            //CHECK FOR EXISTING FIRST AND LAST NAME
            ps = DatabaseConnection.getConnection().prepareStatement(checkNameQuery);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "First and last name already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //CHECK FOR EXISTING EMAIL
            ps = DatabaseConnection.getConnection().prepareStatement(checkEmailQuery);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Email is already in use.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //CHECK FOR EXISTING USERNAME
            ps = DatabaseConnection.getConnection().prepareStatement(checkUsernameQuery);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Username already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //INSERT NEW USER TO DATABASE
            String insertQuery = "INSERT INTO `tb_users`"
                    + "(`first_name`, `last_name`, `email`, `username`, `password`, `sec_question`, `sec_answer`)"
                    + "VALUES (?,?,?,?,?,?,?)";
            ps = DatabaseConnection.getConnection().prepareStatement(insertQuery);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, email);
            ps.setString(4, username);
            ps.setString(5, password);
            ps.setString(6, sec_question);
            ps.setString(7, sec_answer);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "New user added!");
                first_name_field.setText("");
                last_name_field.setText("");
                email_field.setText("");
                username_field.setText("");
                password_field.setText("");
                sec_question_field.setText("");
                sec_answer_field.setText("");
                password_check.setSelected(false);
                password_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/eye-close.png")));
                password_field.setEchoChar('*');
                loadDataToTable();
                updateTotalUsers();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_add_btnActionPerformed

    private void password_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_checkActionPerformed
        if (password_check.isSelected()) {
            password_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/eye-open.png")));
            password_field.setEchoChar((char) 0);
        } else {
            password_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/eye-close.png")));
            password_field.setEchoChar('*');
        }
    }//GEN-LAST:event_password_checkActionPerformed

//    public void refreshUserTable() {
//        DefaultTableModel model = (DefaultTableModel) user_table.getModel();
//        model.setRowCount(0);
//
//        try {
//            Connection conn = DatabaseConnection.getConnection();
//            String query = "SELECT * FROM tb_users";
//            PreparedStatement stmt = conn.prepareStatement(query);
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                // Retrieve the data from the database and add it to the table
//                int userId = rs.getInt("user_id");
//                String firstName = rs.getString("first_name");
//                String lastName = rs.getString("last_name");
//                String email = rs.getString("email");
//                String username = rs.getString("username");
//                String password = rs.getString("password");
//                String secQuestion = rs.getString("sec_question");
//                String secAnswer = rs.getString("sec_answer");
//
//                model.addRow(new Object[]{userId, firstName, lastName, email, username, password, secQuestion, secAnswer});
//            }
//
//            rs.close();
//            stmt.close();
//            conn.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

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
    private javax.swing.JButton add_btn;
    private javax.swing.JButton adduser_btn;
    private Resources.components.PanelBorder adduser_panel;
    private Resources.components.PanelBorder admin_header;
    private javax.swing.JTabbedPane admin_panels;
    private Resources.components.PanelBorder background;
    private javax.swing.JTextField email_field;
    private javax.swing.JButton exit_btn;
    private javax.swing.JTextField first_name_field;
    private javax.swing.JLabel greetings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField last_name_field;
    private javax.swing.JButton logout_btn;
    private Resources.components.PanelMover mover;
    private Resources.components.PanelBorder panelBorder1;
    private javax.swing.JToggleButton password_check;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JTextField sec_answer_field;
    private javax.swing.JTextField sec_question_field;
    private javax.swing.JLabel total_users;
    private javax.swing.JTextField user_searchbar;
    private javax.swing.JTable user_table;
    private Resources.components.PanelBorder user_table_panel;
    private javax.swing.JTextField username_field;
    private javax.swing.JButton usertable_btn;
    // End of variables declaration//GEN-END:variables
}
