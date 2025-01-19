package Content;

import Resources.components.DatabaseConnection;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Activity extends javax.swing.JPanel {

    private int userId;

    public Activity(int userId) {
        initComponents();
        this.userId = userId;
        setBackground(new Color(0, 0, 0, 0));

        loadActivities();
        setupActivityTable();
    }

    private void loadActivities() {
        String query = "SELECT day, activity_name, sets, reps, activity_status FROM tb_activity WHERE user_id = ?";

        try {
            java.sql.Connection con = DatabaseConnection.getConnection();
            java.sql.PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, userId);
            java.sql.ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) activity_table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String day = rs.getString("day");
                String activityName = rs.getString("activity_name");
                int sets = rs.getInt("sets");
                int reps = rs.getInt("reps");
                String status = rs.getString("activity_status");

                boolean isCompleted = status.equalsIgnoreCase("Complete");
                model.addRow(new Object[]{day, activityName, sets == 0 ? "None" : sets, reps == 0 ? "None" : reps, isCompleted});
            }
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error loading activities: " + e.getMessage());
        }
    }

    private void setupActivityTable() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4) {
                    return Boolean.class;
                }
                return String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4;
            }
        };

        activity_table.getModel().addTableModelListener(e -> {
            int row = e.getFirstRow();
            int column = e.getColumn();

            if (column == 4) {
                boolean isCompleted = (Boolean) activity_table.getValueAt(row, column);
                String day = (String) activity_table.getValueAt(row, 0);
                String activityName = (String) activity_table.getValueAt(row, 1);

                updateActivityStatus(day, activityName, isCompleted);
            }
        });
    }

    private void updateActivityStatus(String day, String activityName, boolean isCompleted) {
        String status = isCompleted ? "Complete" : "Incomplete";
        String query = "UPDATE tb_activity SET activity_status = ? WHERE user_id = ? AND day = ? AND activity_name = ?";

        try {
            java.sql.Connection con = DatabaseConnection.getConnection();
            java.sql.PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, status);
            pst.setInt(2, userId);
            pst.setString(3, day);
            pst.setString(4, activityName);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error updating activity status: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        activity_background = new Resources.components.PanelBorder();
        activity_table_panel = new Resources.components.PanelBorder();
        scrollPaneWin111 = new Resources.components.ScrollPaneWin11();
        activity_table = new javax.swing.JTable();
        activity_form_panel = new Resources.components.PanelBorder();
        label1 = new javax.swing.JLabel();
        actday_cbox = new javax.swing.JComboBox<>();
        label2 = new javax.swing.JLabel();
        actname_field = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        or = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        label3 = new javax.swing.JLabel();
        actsets_field = new javax.swing.JTextField();
        label4 = new javax.swing.JLabel();
        actreps_field = new javax.swing.JTextField();
        activity_form_buttons = new Resources.components.PanelBorder();
        actadd_btn = new javax.swing.JButton();
        actupd_btn = new javax.swing.JButton();
        actdel_btn = new javax.swing.JButton();
        activity_confirm_panel = new Resources.components.PanelBorder();
        actcomplete_btn = new javax.swing.JButton();

        activity_background.setBackground(new java.awt.Color(255, 255, 255));
        activity_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        activity_table_panel.setBackground(new java.awt.Color(153, 153, 255));
        activity_table_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollPaneWin111.setRowHeaderView(null);

        activity_table.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        activity_table.setForeground(new java.awt.Color(51, 51, 51));
        activity_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
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
        activity_table.setGridColor(new java.awt.Color(255, 255, 255));
        activity_table.setSelectionBackground(new java.awt.Color(137, 229, 137));
        activity_table.setSelectionForeground(new java.awt.Color(255, 255, 255));
        activity_table.setShowHorizontalLines(true);
        activity_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                activity_tableMouseClicked(evt);
            }
        });
        scrollPaneWin111.setViewportView(activity_table);

        activity_table_panel.add(scrollPaneWin111, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 660, 410));

        activity_background.add(activity_table_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 720, 470));

        activity_form_panel.setBackground(new java.awt.Color(95, 95, 215));
        activity_form_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Activity Day");
        activity_form_panel.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        actday_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        actday_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Choose a day--", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        activity_form_panel.add(actday_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 260, -1));

        label2.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("Activity Name");
        activity_form_panel.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        actname_field.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        activity_form_panel.add(actname_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 260, -1));
        activity_form_panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 185, 100, 10));

        or.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        or.setForeground(new java.awt.Color(193, 193, 193));
        or.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        or.setText("Optional");
        activity_form_panel.add(or, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 60, -1));
        activity_form_panel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 185, 100, 10));

        label3.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("Sets");
        activity_form_panel.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        actsets_field.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        activity_form_panel.add(actsets_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 120, -1));

        label4.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        label4.setForeground(new java.awt.Color(255, 255, 255));
        label4.setText("Reps");
        activity_form_panel.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, -1, -1));

        actreps_field.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        activity_form_panel.add(actreps_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 120, -1));

        activity_form_buttons.setBackground(new java.awt.Color(27, 27, 110));
        activity_form_buttons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        actadd_btn.setText("Add");
        actadd_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actadd_btnActionPerformed(evt);
            }
        });
        activity_form_buttons.add(actadd_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 220, -1));

        actupd_btn.setText("Update");
        actupd_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actupd_btnActionPerformed(evt);
            }
        });
        activity_form_buttons.add(actupd_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 45, 100, -1));

        actdel_btn.setText("Delete");
        actdel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actdel_btnActionPerformed(evt);
            }
        });
        activity_form_buttons.add(actdel_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 45, 100, -1));

        activity_form_panel.add(activity_form_buttons, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 260, 80));

        activity_background.add(activity_form_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 350, 370));

        activity_confirm_panel.setBackground(new java.awt.Color(38, 38, 155));
        activity_confirm_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        actcomplete_btn.setText("Mark as Complete");
        actcomplete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actcomplete_btnActionPerformed(evt);
            }
        });
        activity_confirm_panel.add(actcomplete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 170, 30));

        activity_background.add(activity_confirm_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 480, 210, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(activity_background, javax.swing.GroupLayout.PREFERRED_SIZE, 1250, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(activity_background, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void actadd_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actadd_btnActionPerformed
        String day = (String) actday_cbox.getSelectedItem();
        String activityName = actname_field.getText();
        String sets = actsets_field.getText().isEmpty() ? "None" : actsets_field.getText();
        String reps = actreps_field.getText().isEmpty() ? "None" : actreps_field.getText();

        //CHECK IF DAY IS INVALID
        if (day == null || day.equals("--Choose a day--")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a valid day.");
            return;
        }
        //CHECK IF ACTIVITY NAME IS EMPTY
        if (activityName.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter an activity name.");
            return;
        }
        //CHECK IF SETS AND REPS ARE INVALID
        try {
            if (!sets.equals("None")) {
                int setsValue = Integer.parseInt(sets);
                if (setsValue < 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Sets must be a positive integer or None.");
                    return;
                }
            }
            if (!reps.equals("None")) {
                int repsValue = Integer.parseInt(reps);
                if (repsValue < 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Reps must be a positive integer or None.");
                    return;
                }
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Sets and Reps must be integers or left blank for None.");
            return;
        }

        String insertActQuery = "INSERT INTO tb_activity (user_id, day, activity_name, sets, reps, activity_status) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            java.sql.Connection con = DatabaseConnection.getConnection();
            java.sql.PreparedStatement pst = con.prepareStatement(insertActQuery);
            pst.setInt(1, userId);
            pst.setString(2, day);
            pst.setString(3, activityName);
            pst.setInt(4, sets.equals("None") ? 0 : Integer.parseInt(sets));
            pst.setInt(5, reps.equals("None") ? 0 : Integer.parseInt(reps));
            pst.setString(6, "Incomplete");
            pst.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(this, "Activity added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error saving activity: " + e.getMessage());
            return;
        }

        DefaultTableModel model = (DefaultTableModel) activity_table.getModel();
        model.addRow(new Object[]{day, activityName, sets, reps, Boolean.FALSE});

        actday_cbox.setSelectedIndex(0);
        actname_field.setText("");
        actsets_field.setText("");
        actreps_field.setText("");
    }//GEN-LAST:event_actadd_btnActionPerformed

    private void actcomplete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actcomplete_btnActionPerformed
        DefaultTableModel model = (DefaultTableModel) activity_table.getModel();
        int rowCount = model.getRowCount();

        try {
            java.sql.Connection con = DatabaseConnection.getConnection();
            con.setAutoCommit(false);

            String updateQuery = "UPDATE tb_activity SET activity_status = ? WHERE user_id = ? AND day = ? AND activity_name = ?";
            java.sql.PreparedStatement pst = con.prepareStatement(updateQuery);

            for (int i = 0; i < rowCount; i++) {
                String day = (String) model.getValueAt(i, 0);
                String activityName = (String) model.getValueAt(i, 1);
                boolean isCompleted = (boolean) model.getValueAt(i, 4);

                pst.setString(1, isCompleted ? "Complete" : "Incomplete");
                pst.setInt(2, userId);
                pst.setString(3, day);
                pst.setString(4, activityName);
                pst.addBatch();
            }

            pst.executeBatch();
            con.commit();
            javax.swing.JOptionPane.showMessageDialog(this, "All activities for the week have been finalized!");

            model.setRowCount(0);
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error finalizing activities: " + e.getMessage());
        }
    }//GEN-LAST:event_actcomplete_btnActionPerformed

    private void actdel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actdel_btnActionPerformed

    }//GEN-LAST:event_actdel_btnActionPerformed

    private void actupd_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actupd_btnActionPerformed

    }//GEN-LAST:event_actupd_btnActionPerformed

    private void activity_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activity_tableMouseClicked
        int row = activity_table.getSelectedRow();
        int col = activity_table.getSelectedColumn();

        if (col == 4) {
            DefaultTableModel model = (DefaultTableModel) activity_table.getModel();
            boolean isChecked = (boolean) model.getValueAt(row, col);
            model.setValueAt(!isChecked, row, col);
        }
    }//GEN-LAST:event_activity_tableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actadd_btn;
    private javax.swing.JButton actcomplete_btn;
    private javax.swing.JComboBox<String> actday_cbox;
    private javax.swing.JButton actdel_btn;
    private Resources.components.PanelBorder activity_background;
    private Resources.components.PanelBorder activity_confirm_panel;
    private Resources.components.PanelBorder activity_form_buttons;
    private Resources.components.PanelBorder activity_form_panel;
    private javax.swing.JTable activity_table;
    private Resources.components.PanelBorder activity_table_panel;
    private javax.swing.JTextField actname_field;
    private javax.swing.JTextField actreps_field;
    private javax.swing.JTextField actsets_field;
    private javax.swing.JButton actupd_btn;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel or;
    private Resources.components.ScrollPaneWin11 scrollPaneWin111;
    // End of variables declaration//GEN-END:variables
}
