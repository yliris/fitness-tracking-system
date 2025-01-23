
package Resources.components;

import Content.Home;
import Home.UserHome;
import static Resources.components.UtilityMethods.DefaultText2;
import static Resources.components.UtilityMethods.TransparentField2;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class ExerciseHistory extends javax.swing.JFrame {

    private int userId;
    private Home home;

    public ExerciseHistory(int userId, Home home) {
        initComponents();
        this.userId = userId;
        this.home = home;
        setBackground(new Color(0, 0, 0, 0));
        TransparentField2(exehistory_search);
        mover.initMoving(ExerciseHistory.this);
        Image icon = new ImageIcon(this.getClass().getResource("/Resources/elements/fts-icon.png")).getImage();
        this.setIconImage(icon);

        populateExercisesHistoryTable();

        exehistory_table.setBackground(Color.WHITE);

        JTableHeader header = exehistory_table.getTableHeader();
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 30));
        header.setFont(new Font("Cascadia Mono", Font.BOLD, 11));

        centerTableData();

        TableActionEvent2 event = new TableActionEvent2() {
            @Override
            public void onDelete(int row) {
                deleteUser(row);
            }
        };
        exehistory_table.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender2());
        exehistory_table.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor2(event));
    }

    private void populateExercisesHistoryTable() {
        DefaultTableModel model = (DefaultTableModel) exehistory_table.getModel();
        model.setRowCount(0);

        String query = "SELECT day, type, exercise, duration, sets, reps, completed FROM tb_completed_exercises WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String day = rs.getString("day");
                    String type = rs.getString("type");
                    String exercise = rs.getString("exercise");
                    String duration = rs.getString("duration") != null ? rs.getString("duration") : "None";
                    int sets = rs.getInt("sets");
                    int reps = rs.getInt("reps");
                    int completed = rs.getInt("completed");

                    String status = (completed == 1) ? "Completed" : "Incomplete";

                    model.addRow(new Object[]{
                        day, type, exercise, duration,
                        sets == 0 ? "None" : sets,
                        reps == 0 ? "None" : reps,
                        status
                    });
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error while loading completed exercises: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void loadExerciseHistory() {
        populateExercisesHistoryTable();
    }

    private void deleteUser(int row) {
        int selectedRow = exehistory_table.getSelectedRow();

        if (exehistory_table.isEditing()) {
            exehistory_table.getCellEditor().stopCellEditing();
        }

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "No row selected!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) exehistory_table.getModel();

        if (selectedRow >= model.getRowCount()) {
            JOptionPane.showMessageDialog(this, "Invalid row selected!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String day = (String) exehistory_table.getValueAt(selectedRow, 0);
        String type = (String) exehistory_table.getValueAt(selectedRow, 1);
        String exercise = (String) exehistory_table.getValueAt(selectedRow, 2);

        int confirmDelete = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this exercise?",
                "Delete Exercise",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmDelete == JOptionPane.YES_OPTION) {
            try {
                Connection conn = DatabaseConnection.getConnection();

                String deleteUserQuery = "DELETE FROM tb_completed_exercises WHERE user_id = ? AND day = ? AND type = ? AND exercise = ?";
                PreparedStatement stmt = conn.prepareStatement(deleteUserQuery);
                stmt.setInt(1, userId);
                stmt.setString(2, day);
                stmt.setString(3, type);
                stmt.setString(4, exercise);

                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    model.removeRow(selectedRow);

                    JOptionPane.showMessageDialog(this, "Exercise deleted successfully!",
                            "Success", JOptionPane.INFORMATION_MESSAGE);

                    exehistory_table.clearSelection();
                    exehistory_table.revalidate();
                    exehistory_table.repaint();

                    home.updateExerciseCount();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete exercise.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error deleting exercise: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void centerTableData() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        for (int i = 0; i < exehistory_table.getColumnCount() - 1; i++) {
            exehistory_table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exehistory_background = new Resources.components.PanelBorder();
        scrollPaneWin111 = new Resources.components.ScrollPaneWin11();
        exehistory_table = new javax.swing.JTable();
        exit_btn = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        exehistory_delete_btn = new Resources.components.PanelBorder();
        jLabel5 = new javax.swing.JLabel();
        panelBorder1 = new Resources.components.PanelBorder();
        exehistory_search = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        exeday_cbox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        exetype_cbox = new javax.swing.JComboBox<>();
        mover = new Resources.components.PanelMover();
        jLabel4 = new javax.swing.JLabel();
        exehistory_element = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exehistory_background.setBackground(new java.awt.Color(142, 167, 233));
        exehistory_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exehistory_table.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        exehistory_table.setForeground(new java.awt.Color(51, 51, 51));
        exehistory_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Day", "Type", "Name", "Duration", "Sets", "Reps", "Status", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        exehistory_table.setGridColor(new java.awt.Color(234, 234, 234));
        exehistory_table.setRowHeight(40);
        exehistory_table.setSelectionBackground(new java.awt.Color(137, 229, 137));
        exehistory_table.setSelectionForeground(new java.awt.Color(255, 255, 255));
        exehistory_table.setShowHorizontalLines(true);
        exehistory_table.getTableHeader().setReorderingAllowed(false);
        scrollPaneWin111.setViewportView(exehistory_table);
        if (exehistory_table.getColumnModel().getColumnCount() > 0) {
            exehistory_table.getColumnModel().getColumn(0).setMinWidth(1);
            exehistory_table.getColumnModel().getColumn(0).setPreferredWidth(5);
            exehistory_table.getColumnModel().getColumn(1).setMinWidth(1);
            exehistory_table.getColumnModel().getColumn(1).setPreferredWidth(80);
            exehistory_table.getColumnModel().getColumn(2).setMinWidth(1);
            exehistory_table.getColumnModel().getColumn(2).setPreferredWidth(50);
            exehistory_table.getColumnModel().getColumn(3).setMinWidth(1);
            exehistory_table.getColumnModel().getColumn(3).setPreferredWidth(10);
            exehistory_table.getColumnModel().getColumn(4).setMinWidth(1);
            exehistory_table.getColumnModel().getColumn(4).setPreferredWidth(2);
            exehistory_table.getColumnModel().getColumn(5).setMinWidth(1);
            exehistory_table.getColumnModel().getColumn(5).setPreferredWidth(2);
            exehistory_table.getColumnModel().getColumn(6).setMinWidth(1);
            exehistory_table.getColumnModel().getColumn(6).setPreferredWidth(5);
            exehistory_table.getColumnModel().getColumn(7).setMinWidth(1);
            exehistory_table.getColumnModel().getColumn(7).setPreferredWidth(20);
        }

        exehistory_background.add(scrollPaneWin111, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 1180, 500));

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
        exehistory_background.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, -1, -1));

        back_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/back-idle.png"))); // NOI18N
        back_btn.setBorder(null);
        back_btn.setBorderPainted(false);
        back_btn.setContentAreaFilled(false);
        back_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                back_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                back_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                back_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                back_btnMouseReleased(evt);
            }
        });
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        exehistory_background.add(back_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1175, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Your Exercise History");
        exehistory_background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 330, 50));

        exehistory_delete_btn.setBackground(new java.awt.Color(235, 76, 76));
        exehistory_delete_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exehistory_delete_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exehistory_delete_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exehistory_delete_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exehistory_delete_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exehistory_delete_btnMouseReleased(evt);
            }
        });
        exehistory_delete_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/history-delete-icon.png"))); // NOI18N
        exehistory_delete_btn.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 30));

        exehistory_background.add(exehistory_delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 40, 30));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exehistory_search.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        exehistory_search.setForeground(new java.awt.Color(102, 102, 102));
        exehistory_search.setText("Search");
        exehistory_search.setBorder(null);
        exehistory_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                exehistory_searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                exehistory_searchFocusLost(evt);
            }
        });
        exehistory_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                exehistory_searchKeyReleased(evt);
            }
        });
        panelBorder1.add(exehistory_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 220, 30));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/search-icon-1.png"))); // NOI18N
        panelBorder1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        exehistory_background.add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 70, 260, 30));

        exeday_cbox.setBackground(new java.awt.Color(204, 204, 204));
        exeday_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        exeday_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Day --", "All", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        exeday_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exeday_cboxActionPerformed(evt);
            }
        });
        exehistory_background.add(exeday_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 120, 30));

        jLabel3.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/change-icon.png"))); // NOI18N
        jLabel3.setText(":");
        exehistory_background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, -1, 30));

        exetype_cbox.setBackground(new java.awt.Color(204, 204, 204));
        exetype_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        exetype_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Choose exercise type--", "All", "Cardiovascular (Aerobic) Exercise", "Strength (Resistance) Training", "Flexibility Exercise", "Balance Exercise", "High-Intensity Interval Training (HIIT)", "Functional Fitness Training", "Mind-Body Exercises", "Sports and Recreational Activities" }));
        exetype_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exetype_cboxActionPerformed(evt);
            }
        });
        exehistory_background.add(exetype_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 300, 30));
        exehistory_background.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 10));

        jLabel4.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/filter-icon.png"))); // NOI18N
        jLabel4.setText(":");
        exehistory_background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 30));

        exehistory_element.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/exehistory-element.png"))); // NOI18N
        exehistory_background.add(exehistory_element, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(exehistory_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 640));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void back_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_btnMouseEntered
        back_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/back-hover.png")));
    }//GEN-LAST:event_back_btnMouseEntered

    private void back_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_btnMouseExited
        back_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/back-idle.png")));
    }//GEN-LAST:event_back_btnMouseExited

    private void back_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_btnMousePressed
        back_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/back-click.png")));
    }//GEN-LAST:event_back_btnMousePressed

    private void back_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_btnMouseReleased
        back_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/back-hover.png")));
    }//GEN-LAST:event_back_btnMouseReleased

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        this.dispose();
        UserHome home = new UserHome(userId);
        home.setVisible(true);
        home.showPanel("Activity");
    }//GEN-LAST:event_back_btnActionPerformed

    private void exit_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseEntered
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btnMouseEntered

    private void exit_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseExited
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btnMouseExited

    private void exit_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMousePressed
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
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

    private void exehistory_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_exehistory_searchKeyReleased
        DefaultTableModel model = (DefaultTableModel) exehistory_table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        exehistory_table.setRowSorter(sorter);

        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + exehistory_search.getText()));
    }//GEN-LAST:event_exehistory_searchKeyReleased

    private void exehistory_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_exehistory_searchFocusGained
        DefaultText2(exehistory_search, "Search", UtilityMethods.DefaultFocus.GAINED);
    }//GEN-LAST:event_exehistory_searchFocusGained

    private void exehistory_searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_exehistory_searchFocusLost
        DefaultText2(exehistory_search, "Search", UtilityMethods.DefaultFocus.LOST);
    }//GEN-LAST:event_exehistory_searchFocusLost

    private void applyFilter() {
        String selectedDay = exeday_cbox.getSelectedItem().toString();
        String selectedType = exetype_cbox.getSelectedItem().toString();

        DefaultTableModel model = (DefaultTableModel) exehistory_table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        exehistory_table.setRowSorter(sorter);

        List<RowFilter<Object, Object>> filters = new ArrayList<>();

        if (!selectedDay.equals("All") && !selectedDay.equals("-- Day --")) {
            filters.add(RowFilter.regexFilter(Pattern.quote(selectedDay), 0));
        }

        if (!selectedType.equals("All") && !selectedType.equals("--Choose exercise type--")) {
            filters.add(RowFilter.regexFilter(Pattern.quote(selectedType), 1));
        }

        if (!filters.isEmpty()) {
            RowFilter<Object, Object> combinedFilter = RowFilter.andFilter(filters);
            sorter.setRowFilter(combinedFilter);
        } else {
            sorter.setRowFilter(null);
        }
    }

    private void exeday_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exeday_cboxActionPerformed
        applyFilter();
    }//GEN-LAST:event_exeday_cboxActionPerformed

    private void exetype_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exetype_cboxActionPerformed
        applyFilter();
    }//GEN-LAST:event_exetype_cboxActionPerformed

    private void exehistory_delete_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exehistory_delete_btnMouseEntered
        exehistory_delete_btn.setBackground(new Color(238, 108, 108));
    }//GEN-LAST:event_exehistory_delete_btnMouseEntered

    private void exehistory_delete_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exehistory_delete_btnMouseExited
        exehistory_delete_btn.setBackground(new Color(235, 76, 76));
    }//GEN-LAST:event_exehistory_delete_btnMouseExited

    private void exehistory_delete_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exehistory_delete_btnMousePressed
        exehistory_delete_btn.setBackground(new Color(224, 25, 25));
    }//GEN-LAST:event_exehistory_delete_btnMousePressed

    private void exehistory_delete_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exehistory_delete_btnMouseReleased
        exehistory_delete_btn.setBackground(new Color(238, 108, 108));
    }//GEN-LAST:event_exehistory_delete_btnMouseReleased

    private void exehistory_delete_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exehistory_delete_btnMouseClicked
        int confirmDelete = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to remove all completed exercises?",
                "Remove All Completed Exercises",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmDelete == JOptionPane.YES_OPTION) {
            try {
                Connection conn = DatabaseConnection.getConnection();

                String deleteQuery = "DELETE FROM tb_completed_exercises";

                PreparedStatement stmt = conn.prepareStatement(deleteQuery);
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this,
                            "All completed exercises have been successfully deleted!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                    loadExerciseHistory();
                } else {
                    JOptionPane.showMessageDialog(this,
                            "No completed exercises to delete.",
                            "Information",
                            JOptionPane.INFORMATION_MESSAGE);
                }

                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,
                        "Error deleting completed exercises: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Deletion canceled.",
                    "Canceled",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_exehistory_delete_btnMouseClicked

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
        java.util.logging.Logger.getLogger(ExerciseHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(ExerciseHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(ExerciseHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(ExerciseHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    UIDefaults ui = UIManager.getDefaults();
    ui.put("ScrollBarUI", ScrollBarWin11UI.class.getCanonicalName());
    int userId = 1;
    Home home = new Home(userId);
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new ExerciseHistory(userId, home).setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JComboBox<String> exeday_cbox;
    private Resources.components.PanelBorder exehistory_background;
    private Resources.components.PanelBorder exehistory_delete_btn;
    private javax.swing.JLabel exehistory_element;
    private javax.swing.JTextField exehistory_search;
    private javax.swing.JTable exehistory_table;
    private javax.swing.JComboBox<String> exetype_cbox;
    private javax.swing.JButton exit_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private Resources.components.PanelMover mover;
    private Resources.components.PanelBorder panelBorder1;
    private Resources.components.ScrollPaneWin11 scrollPaneWin111;
    // End of variables declaration//GEN-END:variables
}
