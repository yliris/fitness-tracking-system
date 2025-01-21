package Content;

import Resources.components.DatabaseConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class Activity extends javax.swing.JPanel {

    private int userId;

    public Activity(int userId) {
        initComponents();
        this.userId = userId;
        setBackground(new Color(0, 0, 0, 0));
        type_cbox.addActionListener(evt -> updateExerciseNames());
        populateExerciseTable();
    }

    private void updateExerciseNames() {
        String selectedType = (String) type_cbox.getSelectedItem();
        name_cbox.removeAllItems();
        name_cbox.addItem("--Choose the exercise--");

        switch (selectedType) {
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

        String selectQuery = "SELECT day, type, exercise, duration, sets, reps FROM tb_incomplete_exercises WHERE user_id = ?";

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

                    sets = (sets == 0) ? -1 : sets;
                    reps = (reps == 0) ? -1 : reps;

                    model.addRow(new Object[]{
                        day, type, exercise,
                        duration, sets == -1 ? "None" : sets, reps == -1 ? "None" : reps
                    });
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error while loading exercises: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        exedel_btn = new javax.swing.JButton();
        exeguide_btn = new Resources.components.PanelBorder();
        guide_icon = new javax.swing.JLabel();
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
                "Day", "Type", "Name", "Duration", "Sets", "Reps", "Completed"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        exercise_table.setGridColor(new java.awt.Color(255, 255, 255));
        exercise_table.setRowHeight(30);
        exercise_table.setSelectionBackground(new java.awt.Color(137, 229, 137));
        exercise_table.setSelectionForeground(new java.awt.Color(255, 255, 255));
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
        day_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        day_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Choose the day--", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        activity_form_panel.add(day_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 300, -1));

        label2.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("Exercise Type");
        activity_form_panel.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        type_cbox.setBackground(new java.awt.Color(204, 204, 204));
        type_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        type_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Choose exercise type--", "Cardiovascular (Aerobic) Exercise", "Strength (Resistance) Training", "Flexibility Exercise", "Balance Exercise", "High-Intensity Interval Training (HIIT)", "Functional Fitness Training", "Mind-Body Exercises", "Sports and Recreational Activities" }));
        activity_form_panel.add(type_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 300, 20));

        label3.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("Exercise Name");
        activity_form_panel.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        name_cbox.setBackground(new java.awt.Color(204, 204, 204));
        name_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        name_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Choose the exercise--", " " }));
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
        duration_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Hour", "Minute", "Second", " " }));
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
        activity_form_buttons.add(exeupd_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 120, 30));

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
        activity_form_buttons.add(exedel_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 120, 30));

        activity_form_panel.add(activity_form_buttons, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 300, 110));

        activity_background.add(activity_form_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 350, 460));

        exeguide_btn.setBackground(new java.awt.Color(58, 139, 89));
        exeguide_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exeguide_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exeguide_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exeguide_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exeguide_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exeguide_btnMouseReleased(evt);
            }
        });
        exeguide_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        guide_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guide_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/guide-icon.png"))); // NOI18N
        exeguide_btn.add(guide_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        activity_background.add(exeguide_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 40, 40));

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
        exehistory_btn.add(history_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        activity_background.add(exehistory_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 510, 100, 40));

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
        complete_label.setText("Mark as Complete");
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
            model.addRow(new Object[]{day, type, exercise, durationStr, sets == -1 ? "None" : sets, reps == -1 ? "None" : reps});

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
            day_cbox.setSelectedIndex(0);
            type_cbox.setSelectedIndex(0);
            name_cbox.setSelectedIndex(0);
            duration_cbox.setSelectedIndex(0);
            duration_field.setValue(0);
            sets_field.setValue(0);
            reps_field.setValue(0);
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

    }//GEN-LAST:event_exeupd_btnActionPerformed

    private void exedel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exedel_btnActionPerformed
        int selectedRow = exercise_table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this exercise?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
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
                    day_cbox.setSelectedIndex(0);
                    type_cbox.setSelectedIndex(0);
                    name_cbox.setSelectedIndex(0);
                    duration_cbox.setSelectedIndex(0);
                    duration_field.setValue(0);
                    sets_field.setValue(0);
                    reps_field.setValue(0);
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

    private void execomplete_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_execomplete_btnMouseClicked
        
    }//GEN-LAST:event_execomplete_btnMouseClicked

    private void exehistory_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exehistory_btnMouseClicked
        
    }//GEN-LAST:event_exehistory_btnMouseClicked

    private void exeguide_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exeguide_btnMouseClicked
        
    }//GEN-LAST:event_exeguide_btnMouseClicked

    private void execomplete_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_execomplete_btnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_execomplete_btnMouseEntered

    private void execomplete_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_execomplete_btnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_execomplete_btnMouseExited

    private void execomplete_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_execomplete_btnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_execomplete_btnMousePressed

    private void execomplete_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_execomplete_btnMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_execomplete_btnMouseReleased

    private void exehistory_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exehistory_btnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_exehistory_btnMouseEntered

    private void exehistory_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exehistory_btnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_exehistory_btnMouseExited

    private void exehistory_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exehistory_btnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_exehistory_btnMousePressed

    private void exehistory_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exehistory_btnMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_exehistory_btnMouseReleased

    private void exeguide_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exeguide_btnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_exeguide_btnMouseEntered

    private void exeguide_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exeguide_btnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_exeguide_btnMouseExited

    private void exeguide_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exeguide_btnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_exeguide_btnMousePressed

    private void exeguide_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exeguide_btnMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_exeguide_btnMouseReleased


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
    private Resources.components.PanelBorder execomplete_btn;
    private javax.swing.JButton exedel_btn;
    private Resources.components.PanelBorder exeguide_btn;
    private Resources.components.PanelBorder exehistory_btn;
    private javax.swing.JLabel exercise_element;
    private javax.swing.JTable exercise_table;
    private javax.swing.JButton exeupd_btn;
    private javax.swing.JLabel guide_icon;
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
