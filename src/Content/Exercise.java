package Content;

import Resources.components.AchievementFrame;
import Resources.components.DatabaseConnection;
import Resources.components.ExerciseHistory;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.JTableHeader;

public class Exercise extends javax.swing.JPanel {

    private int userId;
    private Home home;

    public Exercise(int userId, Home home) {
        initComponents();
        this.userId = userId;
        this.home = home;
        setBackground(new Color(0, 0, 0, 0));
        type_cbox.addActionListener(evt -> updateExerciseNames());
        populateExerciseTable();
        exercise_table.getColumnModel().getColumn(6).setCellRenderer(exercise_table.getDefaultRenderer(Boolean.class));
        exercise_table.getColumnModel().getColumn(6).setCellEditor(exercise_table.getDefaultEditor(Boolean.class));
        addModelListener();

        exercise_table.setBackground(Color.WHITE);

        JTableHeader header = exercise_table.getTableHeader();
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 30));
        header.setFont(new Font("Cascadia Mono", Font.BOLD, 11));

        centerTableData();
    }

    private void updateExerciseNames() {
        String selectedType = (String) type_cbox.getSelectedItem();
        name_cbox.removeAllItems();
        name_cbox.addItem("--Choose the exercise--");

        switch (selectedType) {
            case "Rest":
                name_cbox.addItem("None");
                break;
            case "Cardiovascular (Aerobic) Exercise":
                name_cbox.addItem("Running");
                name_cbox.addItem("Cycling");
                name_cbox.addItem("Swimming");
                name_cbox.addItem("Dancing");
                break;
            case "Strength (Resistance) Training":
                name_cbox.addItem("Push Ups");
                name_cbox.addItem("Pull Ups");
                name_cbox.addItem("Bench Press");
                name_cbox.addItem("Deadlift");
                name_cbox.addItem("Plank");
                name_cbox.addItem("Squats");
                break;
            case "Flexibility Exercise":
                name_cbox.addItem("Yoga");
                name_cbox.addItem("Pilates");
                name_cbox.addItem("Static Stretching");
                break;
            case "Balance Exercise":
                name_cbox.addItem("Tai Chi");
                name_cbox.addItem("Single-leg Stand");
                name_cbox.addItem("Heel-to-Toe Walk");
                name_cbox.addItem("Yoga tree pose");
                break;
            case "High-Intensity Interval Training (HIIT)":
                name_cbox.addItem("Sprint Intervals");
                name_cbox.addItem("Burpees");
                name_cbox.addItem("Mountain Climbers");
                name_cbox.addItem("Box Jumps");
                name_cbox.addItem("High Knees");
                break;
            case "Functional Fitness Training":
                name_cbox.addItem("Kettlebell Swings");
                name_cbox.addItem("Medicine Ball Throws");
                name_cbox.addItem("Lunges with Dumbbells");
                break;
            case "Mind-Body Exercises":
                name_cbox.addItem("Breathing Meditation");
                name_cbox.addItem("Sun salutations");
                name_cbox.addItem("Warrior series");
                name_cbox.addItem("Pilates roll-ups");
                break;
            case "Sports and Recreational Activities":
                name_cbox.addItem("Basketball");
                name_cbox.addItem("Soccer");
                name_cbox.addItem("Tennis");
                name_cbox.addItem("Volleyball");
                name_cbox.addItem("Badminton");
                name_cbox.addItem("Rock Climbing");
                name_cbox.addItem("Surfing");
                break;
            default:
                break;
        }
    }

    private void populateExerciseTable() {
        DefaultTableModel model = (DefaultTableModel) exercise_table.getModel();
        model.setRowCount(0);
        model.setColumnCount(7);
        model.setColumnIdentifiers(new Object[]{"Day", "Type", "Exercise", "Duration", "Sets", "Reps", "Status"});

        String selectQuery = "SELECT day, type, exercise, duration, sets, reps, completed FROM tb_incomplete_exercises WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(selectQuery)) {
            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String day = rs.getString("day");
                    String type = rs.getString("type");
                    String exercise = rs.getString("exercise");
                    String duration = rs.getString("duration") != null ? rs.getString("duration") : "None";
                    int sets = rs.getInt("sets");
                    int reps = rs.getInt("reps");
                    boolean completed = rs.getBoolean("completed");

                    sets = (sets == 0) ? -1 : sets;
                    reps = (reps == 0) ? -1 : reps;

                    model.addRow(new Object[]{
                        day, type, exercise, duration, sets == -1 ? "None" : sets, reps == -1 ? "None" : reps, completed});
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error while loading exercises: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearInputFields() {
        day_cbox.setSelectedIndex(0);
        type_cbox.setSelectedIndex(0);
        name_cbox.setSelectedIndex(0);
        duration_field.setValue(0);
        duration_cbox.setSelectedIndex(0);
        sets_field.setValue(0);
        reps_field.setValue(0);
    }

    private void centerTableData() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        for (int i = 0; i < exercise_table.getColumnCount() - 1; i++) {
            exercise_table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        activity_background = new Resources.components.PanelBorder();
        activity_table_panel = new Resources.components.PanelBorder();
        scrollPaneWin111 = new Resources.components.ScrollPaneWin11();
        exercise_table = new javax.swing.JTable();
        activity_form_panel = new Resources.components.PanelBorder();
        label1 = new javax.swing.JLabel();
        day_cbox = new javax.swing.JComboBox<>();
        label2 = new javax.swing.JLabel();
        type_cbox = new javax.swing.JComboBox<>();
        label3 = new javax.swing.JLabel();
        name_cbox = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        optional = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        label4 = new javax.swing.JLabel();
        duration_field = new javax.swing.JSpinner();
        label5 = new javax.swing.JLabel();
        duration_cbox = new javax.swing.JComboBox<>();
        label6 = new javax.swing.JLabel();
        sets_field = new javax.swing.JSpinner();
        label7 = new javax.swing.JLabel();
        reps_field = new javax.swing.JSpinner();
        activity_form_buttons = new Resources.components.PanelBorder();
        exeadd_btn = new javax.swing.JButton();
        exeupd_btn = new javax.swing.JButton();
        execlear_btn = new javax.swing.JButton();
        exedel_btn = new javax.swing.JButton();
        exehistory_btn = new Resources.components.PanelBorder();
        history_icon = new javax.swing.JLabel();
        history_label = new javax.swing.JLabel();
        execomplete_btn = new Resources.components.PanelBorder();
        complete_icon = new javax.swing.JLabel();
        complete_label = new javax.swing.JLabel();
        exercise_element = new javax.swing.JLabel();

        activity_background.setBackground(new java.awt.Color(255, 255, 255));
        activity_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        activity_table_panel.setBackground(new java.awt.Color(142, 167, 233));
        activity_table_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollPaneWin111.setRowHeaderView(null);

        exercise_table.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        exercise_table.setForeground(new java.awt.Color(51, 51, 51));
        exercise_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Day", "Type", "Name", "Duration", "Sets", "Reps", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        exercise_table.setGridColor(new java.awt.Color(234, 234, 234));
        exercise_table.setRowHeight(30);
        exercise_table.setSelectionBackground(new java.awt.Color(96, 220, 96));
        exercise_table.setSelectionForeground(new java.awt.Color(255, 255, 255));
        exercise_table.setShowGrid(false);
        exercise_table.setShowHorizontalLines(true);
        exercise_table.getTableHeader().setReorderingAllowed(false);
        exercise_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exercise_tableMouseClicked(evt);
            }
        });
        scrollPaneWin111.setViewportView(exercise_table);
        if (exercise_table.getColumnModel().getColumnCount() > 0) {
            exercise_table.getColumnModel().getColumn(0).setMinWidth(1);
            exercise_table.getColumnModel().getColumn(0).setPreferredWidth(20);
            exercise_table.getColumnModel().getColumn(1).setMinWidth(1);
            exercise_table.getColumnModel().getColumn(1).setPreferredWidth(110);
            exercise_table.getColumnModel().getColumn(2).setMinWidth(1);
            exercise_table.getColumnModel().getColumn(2).setPreferredWidth(40);
            exercise_table.getColumnModel().getColumn(3).setMinWidth(1);
            exercise_table.getColumnModel().getColumn(3).setPreferredWidth(15);
            exercise_table.getColumnModel().getColumn(4).setMinWidth(1);
            exercise_table.getColumnModel().getColumn(4).setPreferredWidth(1);
            exercise_table.getColumnModel().getColumn(5).setMinWidth(1);
            exercise_table.getColumnModel().getColumn(5).setPreferredWidth(1);
            exercise_table.getColumnModel().getColumn(6).setMinWidth(1);
            exercise_table.getColumnModel().getColumn(6).setPreferredWidth(5);
        }

        activity_table_panel.add(scrollPaneWin111, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 790, 420));

        activity_background.add(activity_table_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 850, 480));

        activity_form_panel.setBackground(new java.awt.Color(114, 134, 211));
        activity_form_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Exercise Day");
        activity_form_panel.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        day_cbox.setBackground(new java.awt.Color(204, 204, 204));
        day_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        day_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Choose the day--", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        activity_form_panel.add(day_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 300, -1));

        label2.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("Exercise Type");
        activity_form_panel.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        type_cbox.setBackground(new java.awt.Color(204, 204, 204));
        type_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        type_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Choose exercise type--", "Cardiovascular (Aerobic) Exercise", "Strength (Resistance) Training", "Flexibility Exercise", "Balance Exercise", "High-Intensity Interval Training (HIIT)", "Functional Fitness Training", "Mind-Body Exercises", "Sports and Recreational Activities", "Rest" }));
        activity_form_panel.add(type_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 300, 20));

        label3.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("Exercise Name");
        activity_form_panel.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        name_cbox.setBackground(new java.awt.Color(204, 204, 204));
        name_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        name_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Choose the exercise--" }));
        activity_form_panel.add(name_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 300, -1));
        activity_form_panel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 120, 10));

        optional.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        optional.setForeground(new java.awt.Color(193, 193, 193));
        optional.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        optional.setText("Optional");
        activity_form_panel.add(optional, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 195, 60, -1));
        activity_form_panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 120, 10));

        label4.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        label4.setForeground(new java.awt.Color(255, 255, 255));
        label4.setText("Duration");
        activity_form_panel.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        duration_field.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        duration_field.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        activity_form_panel.add(duration_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 140, -1));

        label5.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        label5.setForeground(new java.awt.Color(255, 255, 255));
        label5.setText("Time");
        activity_form_panel.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));

        duration_cbox.setBackground(new java.awt.Color(204, 204, 204));
        duration_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        duration_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Hour", "Minute", "Second" }));
        activity_form_panel.add(duration_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 140, -1));

        label6.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        label6.setForeground(new java.awt.Color(255, 255, 255));
        label6.setText("Sets");
        activity_form_panel.add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        sets_field.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        sets_field.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        activity_form_panel.add(sets_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 140, -1));

        label7.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        label7.setForeground(new java.awt.Color(255, 255, 255));
        label7.setText("Reps");
        activity_form_panel.add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, -1, -1));

        reps_field.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        reps_field.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        activity_form_panel.add(reps_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 140, -1));

        activity_form_buttons.setBackground(new java.awt.Color(68, 94, 196));
        activity_form_buttons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exeadd_btn.setBackground(new java.awt.Color(50, 128, 80));
        exeadd_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        exeadd_btn.setForeground(new java.awt.Color(255, 255, 255));
        exeadd_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/add-icon.png"))); // NOI18N
        exeadd_btn.setText("ADD");
        exeadd_btn.setIconTextGap(10);
        exeadd_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exeadd_btnActionPerformed(evt);
            }
        });
        activity_form_buttons.add(exeadd_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 260, 30));

        exeupd_btn.setBackground(new java.awt.Color(145, 145, 23));
        exeupd_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        exeupd_btn.setForeground(new java.awt.Color(255, 255, 255));
        exeupd_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/update-icon.png"))); // NOI18N
        exeupd_btn.setText("UPDATE");
        exeupd_btn.setIconTextGap(10);
        exeupd_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exeupd_btnActionPerformed(evt);
            }
        });
        activity_form_buttons.add(exeupd_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 260, 30));

        execlear_btn.setBackground(new java.awt.Color(51, 51, 51));
        execlear_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        execlear_btn.setForeground(new java.awt.Color(255, 255, 255));
        execlear_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/clear-icon.png"))); // NOI18N
        execlear_btn.setText("CLEAR");
        execlear_btn.setIconTextGap(10);
        execlear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                execlear_btnActionPerformed(evt);
            }
        });
        activity_form_buttons.add(execlear_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 120, 30));

        exedel_btn.setBackground(new java.awt.Color(173, 20, 20));
        exedel_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        exedel_btn.setForeground(new java.awt.Color(255, 255, 255));
        exedel_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/delete-icon.png"))); // NOI18N
        exedel_btn.setText("DELETE");
        exedel_btn.setIconTextGap(10);
        exedel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exedel_btnActionPerformed(evt);
            }
        });
        activity_form_buttons.add(exedel_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, 30));

        activity_form_panel.add(activity_form_buttons, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 300, 120));

        activity_background.add(activity_form_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 350, 460));

        exehistory_btn.setBackground(new java.awt.Color(89, 89, 89));
        exehistory_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exehistory_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exehistory_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exehistory_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exehistory_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exehistory_btnMouseReleased(evt);
            }
        });
        exehistory_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        history_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        history_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/history-icon.png"))); // NOI18N
        exehistory_btn.add(history_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        history_label.setFont(new java.awt.Font("Cascadia Mono", 1, 11)); // NOI18N
        history_label.setForeground(new java.awt.Color(255, 255, 255));
        history_label.setText("History");
        exehistory_btn.add(history_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 70, 40));

        activity_background.add(exehistory_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 110, 40));

        execomplete_btn.setBackground(new java.awt.Color(68, 94, 196));
        execomplete_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                execomplete_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                execomplete_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                execomplete_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                execomplete_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                execomplete_btnMouseReleased(evt);
            }
        });
        execomplete_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        complete_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        complete_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/complete-icon.png"))); // NOI18N
        execomplete_btn.add(complete_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        complete_label.setFont(new java.awt.Font("Cascadia Mono", 1, 11)); // NOI18N
        complete_label.setForeground(new java.awt.Color(255, 255, 255));
        complete_label.setText("Mark as Done");
        execomplete_btn.add(complete_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 120, 40));

        activity_background.add(execomplete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 510, 170, 40));

        exercise_element.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/exercise-element.png"))); // NOI18N
        activity_background.add(exercise_element, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void exeadd_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exeadd_btnActionPerformed
        String day = (String) day_cbox.getSelectedItem();
        String type = (String) type_cbox.getSelectedItem();
        String exercise = (String) name_cbox.getSelectedItem();
        int duration = (int) duration_field.getValue();
        String durationUnit = (String) duration_cbox.getSelectedItem();
        int sets = (int) sets_field.getValue();
        int reps = (int) reps_field.getValue();

        //CHECK IF ALL ITEMS ARE INVALID
        if (day.equals("--Choose the day--")
                && type.equals("--Choose exercise type--")
                && exercise.equals("--Choose the exercise--")) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF EACH ITEMS ARE INVALID
        if (day.equals("--Choose the day--")) {
            JOptionPane.showMessageDialog(this, "Please choose a day.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (type.equals("--Choose exercise type--")) {
            JOptionPane.showMessageDialog(this, "Please choose an exercise type.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (exercise.equals("--Choose the exercise--")) {
            JOptionPane.showMessageDialog(this, "Please choose an exercise.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF DURATION IS EMPTY OR NOT
        String durationStr;
        if (duration == 0) {
            durationStr = "None";
        } else {
            if (durationUnit.equals("None")) {
                JOptionPane.showMessageDialog(this, "Please select a valid time unit.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (duration == 1) {
                durationStr = duration + " " + durationUnit;
            } else {
                durationStr = duration + " " + durationUnit + "s";
            }
        }
        //CHECK IF SETS AND REPS ARE EMPTY
        if (sets == 0) {
            sets = -1;
        }
        if (reps == 0) {
            reps = -1;
        }

        try {
            DefaultTableModel model = (DefaultTableModel) exercise_table.getModel();

            //CHECK IF THERE'S A DUPLICATE EXERCISE
            for (int i = 0; i < model.getRowCount(); i++) {
                String existingDay = (String) model.getValueAt(i, 0);
                String existingType = (String) model.getValueAt(i, 1);
                String existingExercise = (String) model.getValueAt(i, 2);

                if (day.equals(existingDay) && type.equals(existingType) && exercise.equals(existingExercise)) {
                    JOptionPane.showMessageDialog(this, "This exercise already exists for the selected day and type.", "Duplicate Entry", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            boolean completed = false;
            model.addRow(new Object[]{
                day, type, exercise, durationStr,
                sets == -1 ? "None" : sets,
                reps == -1 ? "None" : reps,
                false
            });

            sortTableByDay(model);

            String insertExerciseQuery = "INSERT INTO tb_incomplete_exercises (user_id, day, type, exercise, duration, sets, reps) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(insertExerciseQuery)) {
                stmt.setInt(1, userId);
                stmt.setString(2, day);
                stmt.setString(3, type);
                stmt.setString(4, exercise);
                stmt.setString(5, durationStr.equals("None") ? null : durationStr);
                stmt.setObject(6, sets == -1 ? null : sets);
                stmt.setObject(7, reps == -1 ? null : reps);
                stmt.executeUpdate();
            }
            JOptionPane.showMessageDialog(this, "Exercise added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            home.updateExerciseCount();
            clearInputFields();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error while adding exercise: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_exeadd_btnActionPerformed

    private void sortTableByDay(DefaultTableModel model) {
        List<String> daysOrder = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

        List<Object[]> rows = new ArrayList<>();
        for (int i = 0; i < model.getRowCount(); i++) {
            Object[] row = new Object[model.getColumnCount()];
            for (int j = 0; j < model.getColumnCount(); j++) {
                row[j] = model.getValueAt(i, j);
            }
            rows.add(row);
        }

        rows.sort(Comparator.comparing(row -> daysOrder.indexOf(row[0].toString())));

        model.setRowCount(0);
        for (Object[] row : rows) {
            model.addRow(row);
        }
    }

    private void exeupd_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exeupd_btnActionPerformed
        int selectedRow = exercise_table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String day = (String) day_cbox.getSelectedItem();
        String type = (String) type_cbox.getSelectedItem();
        String exercise = (String) name_cbox.getSelectedItem();
        int duration = (int) duration_field.getValue();
        String durationUnit = (String) duration_cbox.getSelectedItem();
        int sets = (int) sets_field.getValue();
        int reps = (int) reps_field.getValue();

        //CHECK IF ALL ITEMS ARE INVALID
        if (day.equals("--Choose the day--")
                && type.equals("--Choose exercise type--")
                && exercise.equals("--Choose the exercise--")) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF EACH ITEMS ARE INVALID
        if (day.equals("--Choose the day--")) {
            JOptionPane.showMessageDialog(this, "Please choose a day.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (type.equals("--Choose exercise type--")) {
            JOptionPane.showMessageDialog(this, "Please choose an exercise type.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (exercise.equals("--Choose the exercise--")) {
            JOptionPane.showMessageDialog(this, "Please choose an exercise.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF DURATION IS EMPTY OR NOT
        String durationStr;
        if (duration == 0) {
            durationStr = "None";
        } else {
            if (durationUnit.equals("None")) {
                JOptionPane.showMessageDialog(this, "Please select a valid time unit.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            durationStr = duration == 1 ? duration + " " + durationUnit : duration + " " + durationUnit + "s";
        }
        //CHECK IF SETS AND REPS ARE EMPTY
        sets = (sets == 0) ? -1 : sets;
        reps = (reps == 0) ? -1 : reps;
        //CHECK IF NO CHANGES WERE MADE
        String oldDay = exercise_table.getValueAt(selectedRow, 0).toString();
        String oldType = exercise_table.getValueAt(selectedRow, 1).toString();
        String oldExercise = exercise_table.getValueAt(selectedRow, 2).toString();
        String oldDurationStr = exercise_table.getValueAt(selectedRow, 3).toString();
        String oldSetsStr = exercise_table.getValueAt(selectedRow, 4).toString();
        String oldRepsStr = exercise_table.getValueAt(selectedRow, 5).toString();
        if (day.equals(oldDay) && type.equals(oldType) && exercise.equals(oldExercise)
                && durationStr.equals(oldDurationStr)
                && (sets == -1 ? "None" : String.valueOf(sets)).equals(oldSetsStr)
                && (reps == -1 ? "None" : String.valueOf(reps)).equals(oldRepsStr)) {
            JOptionPane.showMessageDialog(this, "No changes were made.", "No Changes", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            String updateQuery = "UPDATE tb_incomplete_exercises SET day = ?, type = ?, exercise = ?, duration = ?, sets = ?, reps = ? "
                    + "WHERE user_id = ? AND day = ? AND type = ? AND exercise = ?";

            try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(updateQuery)) {
                stmt.setString(1, day);
                stmt.setString(2, type);
                stmt.setString(3, exercise);
                stmt.setString(4, durationStr.equals("None") ? null : durationStr);
                stmt.setObject(5, sets == -1 ? null : sets);
                stmt.setObject(6, reps == -1 ? null : reps);
                stmt.setInt(7, userId);
                stmt.setString(8, oldDay);
                stmt.setString(9, oldType);
                stmt.setString(10, oldExercise);

                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    DefaultTableModel model = (DefaultTableModel) exercise_table.getModel();

                    model.setValueAt(day, selectedRow, 0);
                    model.setValueAt(type, selectedRow, 1);
                    model.setValueAt(exercise, selectedRow, 2);
                    model.setValueAt(durationStr, selectedRow, 3);
                    model.setValueAt(sets == -1 ? "None" : sets, selectedRow, 4);
                    model.setValueAt(reps == -1 ? "None" : reps, selectedRow, 5);

                    JOptionPane.showMessageDialog(this, "Exercise updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    clearInputFields();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error while updating exercise: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_exeupd_btnActionPerformed

    private void exedel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exedel_btnActionPerformed
        int selectedRow = exercise_table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this exercise?", "Confirm Remove", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            String day = (String) exercise_table.getValueAt(selectedRow, 0);
            String type = (String) exercise_table.getValueAt(selectedRow, 1);
            String exercise = (String) exercise_table.getValueAt(selectedRow, 2);

            String deleteQuery = "DELETE FROM tb_incomplete_exercises WHERE user_id = ? AND day = ? AND type = ? AND exercise = ?";

            try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
                stmt.setInt(1, userId);
                stmt.setString(2, day);
                stmt.setString(3, type);
                stmt.setString(4, exercise);
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    DefaultTableModel model = (DefaultTableModel) exercise_table.getModel();
                    model.removeRow(selectedRow);

                    JOptionPane.showMessageDialog(this, "Exercise deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    home.updateExerciseCount();
                    clearInputFields();
                } else {
                    JOptionPane.showMessageDialog(this, "No matching record found in the database.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error while deleting exercise: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_exedel_btnActionPerformed

    private void exercise_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exercise_tableMouseClicked
        int selectedRow = exercise_table.getSelectedRow();
        int selectedColumn = exercise_table.getSelectedColumn();

        if (selectedColumn == 6) {
            return;
        }

        if (selectedRow >= 0) {
            String day = exercise_table.getValueAt(selectedRow, 0).toString();
            String type = exercise_table.getValueAt(selectedRow, 1).toString();
            String exercise = exercise_table.getValueAt(selectedRow, 2).toString();
            String durationStr = exercise_table.getValueAt(selectedRow, 3).toString();
            String setsStr = exercise_table.getValueAt(selectedRow, 4).toString();
            String repsStr = exercise_table.getValueAt(selectedRow, 5).toString();

            day_cbox.setSelectedItem(day);
            type_cbox.setSelectedItem(type);
            name_cbox.setSelectedItem(exercise);

            if (!durationStr.equals("None")) {
                String[] durationParts = durationStr.split(" ");
                int durationValue = Integer.parseInt(durationParts[0]);
                String durationUnit = durationParts[1].replace("s", "");

                duration_field.setValue(durationValue);
                duration_cbox.setSelectedItem(durationUnit);
            } else {
                duration_field.setValue(0);
                duration_cbox.setSelectedItem("None");
            }

            sets_field.setValue(setsStr.equals("None") ? 0 : Integer.parseInt(setsStr));
            reps_field.setValue(repsStr.equals("None") ? 0 : Integer.parseInt(repsStr));
        }
    }//GEN-LAST:event_exercise_tableMouseClicked

    private void addModelListener() {
        DefaultTableModel model = (DefaultTableModel) exercise_table.getModel();

        model.addTableModelListener(e -> {
            int row = e.getFirstRow();
            int column = e.getColumn();

            // Check if the "Status" column was edited
            if (column == 6) { // Status column index
                Boolean status = (Boolean) model.getValueAt(row, column);
                String exercise = (String) model.getValueAt(row, 2); // Exercise name
                String day = (String) model.getValueAt(row, 0); // Day for specificity

                String updateStatusQuery = "UPDATE tb_incomplete_exercises SET completed = ? WHERE user_id = ? AND exercise = ? AND day = ?";

                try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(updateStatusQuery)) {
                    stmt.setBoolean(1, status);
                    stmt.setInt(2, userId);
                    stmt.setString(3, exercise);
                    stmt.setString(4, day);
                    stmt.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error updating exercise status: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void execomplete_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_execomplete_btnMouseClicked
        DefaultTableModel model = (DefaultTableModel) exercise_table.getModel();
        int rowCount = model.getRowCount();

        if (rowCount == 0) {
            JOptionPane.showMessageDialog(this, "There are no exercises to mark as done.", "No Exercises", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        boolean hasUnchecked = false;

        for (int i = 0; i < rowCount; i++) {
            Boolean isChecked = (Boolean) model.getValueAt(i, 6);
            if (isChecked == null || !isChecked) {
                hasUnchecked = true;
                break;
            }
        }

        int confirmResult;
        if (hasUnchecked) {
            confirmResult = JOptionPane.showConfirmDialog(
                    this,
                    "There are still incomplete exercises. Are you sure you want to mark them as done?",
                    "Confirm Completion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
        } else {
            confirmResult = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to mark all exercises as done?",
                    "Confirm Completion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
        }
        if (confirmResult == JOptionPane.NO_OPTION) {
            return;
        }

        try (Connection conn = DatabaseConnection.getConnection()) {
            String insertQuery = "INSERT INTO tb_completed_exercises (user_id, day, type, exercise, duration, sets, reps, completed) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            String deleteQuery = "DELETE FROM tb_incomplete_exercises WHERE user_id = ? AND day = ? AND type = ? AND exercise = ?";

            try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery); PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery)) {

                for (int i = 0; i < rowCount; i++) {
                    String day = model.getValueAt(i, 0).toString();
                    String type = model.getValueAt(i, 1).toString();
                    String exercise = model.getValueAt(i, 2).toString();
                    String duration = model.getValueAt(i, 3).toString();
                    String setsStr = model.getValueAt(i, 4).toString();
                    String repsStr = model.getValueAt(i, 5).toString();
                    Boolean isChecked = (Boolean) model.getValueAt(i, 6);

                    int sets = setsStr.equals("None") ? 0 : Integer.parseInt(setsStr);
                    int reps = repsStr.equals("None") ? 0 : Integer.parseInt(repsStr);

                    insertStmt.setInt(1, userId);
                    insertStmt.setString(2, day);
                    insertStmt.setString(3, type);
                    insertStmt.setString(4, exercise);
                    insertStmt.setString(5, duration.equals("None") ? null : duration);
                    insertStmt.setObject(6, sets == 0 ? null : sets);
                    insertStmt.setObject(7, reps == 0 ? null : reps);
                    insertStmt.setBoolean(8, isChecked != null && isChecked);
                    insertStmt.addBatch();

                    deleteStmt.setInt(1, userId);
                    deleteStmt.setString(2, day);
                    deleteStmt.setString(3, type);
                    deleteStmt.setString(4, exercise);
                    deleteStmt.addBatch();
                }

                insertStmt.executeBatch();
                deleteStmt.executeBatch();
            }
            JOptionPane.showMessageDialog(this, "All added exercises have been marked as done.", "Success", JOptionPane.INFORMATION_MESSAGE);
            model.setRowCount(0);
            ExerciseHistory exerciseHistory = new ExerciseHistory(userId, home);
            exerciseHistory.setVisible(true);
            Window window = SwingUtilities.windowForComponent(this);
            if (window != null) {
                window.dispose();
            }
            AchievementFrame achievementFrame = new AchievementFrame(userId);
            int completedCount = achievementFrame.countCompletedExercise();
            achievementFrame.checkExerciseAchievements(completedCount);
            Achievements achievement = new Achievements(userId);
            achievement.loadAchievements();
            achievement.countAchievements();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error while marking exercises as done: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_execomplete_btnMouseClicked

    private void exehistory_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exehistory_btnMouseClicked
        java.awt.Window parentFrame = SwingUtilities.getWindowAncestor(this);
        if (parentFrame != null) {
            parentFrame.dispose();
        }
        ExerciseHistory exerciseHistory = new ExerciseHistory(userId, home);
        exerciseHistory.setVisible(true);
    }//GEN-LAST:event_exehistory_btnMouseClicked

    private void execomplete_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_execomplete_btnMouseEntered
        execomplete_btn.setBackground(new Color(111, 131, 209));
    }//GEN-LAST:event_execomplete_btnMouseEntered

    private void execomplete_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_execomplete_btnMouseExited
        execomplete_btn.setBackground(new Color(68, 94, 196));
    }//GEN-LAST:event_execomplete_btnMouseExited

    private void execomplete_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_execomplete_btnMousePressed
        execomplete_btn.setBackground(new Color(68, 94, 196));
    }//GEN-LAST:event_execomplete_btnMousePressed

    private void execomplete_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_execomplete_btnMouseReleased
        execomplete_btn.setBackground(new Color(111, 131, 209));
    }//GEN-LAST:event_execomplete_btnMouseReleased

    private void exehistory_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exehistory_btnMouseEntered
        exehistory_btn.setBackground(new Color(127, 127, 127));
    }//GEN-LAST:event_exehistory_btnMouseEntered

    private void exehistory_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exehistory_btnMouseExited
        exehistory_btn.setBackground(new Color(89, 89, 89));
    }//GEN-LAST:event_exehistory_btnMouseExited

    private void exehistory_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exehistory_btnMousePressed
        exehistory_btn.setBackground(new Color(89, 89, 89));
    }//GEN-LAST:event_exehistory_btnMousePressed

    private void exehistory_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exehistory_btnMouseReleased
        exehistory_btn.setBackground(new Color(127, 127, 127));
    }//GEN-LAST:event_exehistory_btnMouseReleased

    private void execlear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_execlear_btnActionPerformed
        clearInputFields();
        exercise_table.clearSelection();
    }//GEN-LAST:event_execlear_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Resources.components.PanelBorder activity_background;
    private Resources.components.PanelBorder activity_form_buttons;
    private Resources.components.PanelBorder activity_form_panel;
    private Resources.components.PanelBorder activity_table_panel;
    private javax.swing.JLabel complete_icon;
    private javax.swing.JLabel complete_label;
    private javax.swing.JComboBox<String> day_cbox;
    private javax.swing.JComboBox<String> duration_cbox;
    private javax.swing.JSpinner duration_field;
    private javax.swing.JButton exeadd_btn;
    private javax.swing.JButton execlear_btn;
    private Resources.components.PanelBorder execomplete_btn;
    private javax.swing.JButton exedel_btn;
    private Resources.components.PanelBorder exehistory_btn;
    private javax.swing.JLabel exercise_element;
    private javax.swing.JTable exercise_table;
    private javax.swing.JButton exeupd_btn;
    private javax.swing.JLabel history_icon;
    private javax.swing.JLabel history_label;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JComboBox<String> name_cbox;
    private javax.swing.JLabel optional;
    private javax.swing.JSpinner reps_field;
    private Resources.components.ScrollPaneWin11 scrollPaneWin111;
    private javax.swing.JSpinner sets_field;
    private javax.swing.JComboBox<String> type_cbox;
    // End of variables declaration//GEN-END:variables
}
