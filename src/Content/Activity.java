package Content;

import Resources.components.DatabaseConnection;
import Resources.components.UtilityMethods;
import static Resources.components.UtilityMethods.DefaultText2;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static Resources.components.UtilityMethods.TransparentField2;

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
        label5 = new javax.swing.JLabel();
        duration_cbox = new javax.swing.JComboBox<>();
        name_cbox = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        or = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        label6 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        activity_form_buttons = new Resources.components.PanelBorder();
        exeadd_btn = new javax.swing.JButton();
        exeupd_btn = new javax.swing.JButton();
        exedel_btn = new javax.swing.JButton();
        duration_field = new javax.swing.JSpinner();
        reps_field = new javax.swing.JSpinner();
        sets_field = new javax.swing.JSpinner();
        label7 = new javax.swing.JLabel();
        history_btn = new javax.swing.JButton();
        execomplete_btn = new javax.swing.JButton();
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

        label5.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        label5.setForeground(new java.awt.Color(255, 255, 255));
        label5.setText("Exercise Name");
        activity_form_panel.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        duration_cbox.setBackground(new java.awt.Color(204, 204, 204));
        duration_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        duration_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Time--", "None", "Hour", "Minute", "Second", " " }));
        activity_form_panel.add(duration_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 140, -1));

        name_cbox.setBackground(new java.awt.Color(204, 204, 204));
        name_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        name_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Choose the exercise--", " " }));
        activity_form_panel.add(name_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 300, -1));
        activity_form_panel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 120, 10));

        or.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        or.setForeground(new java.awt.Color(193, 193, 193));
        or.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        or.setText("Optional");
        activity_form_panel.add(or, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 195, 60, -1));
        activity_form_panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 120, 10));

        label6.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        label6.setForeground(new java.awt.Color(255, 255, 255));
        label6.setText("Time");
        activity_form_panel.add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));

        label3.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("Sets");
        activity_form_panel.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        label4.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        label4.setForeground(new java.awt.Color(255, 255, 255));
        label4.setText("Reps");
        activity_form_panel.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, -1, -1));

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

        activity_form_panel.add(activity_form_buttons, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 300, 110));

        duration_field.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        duration_field.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        activity_form_panel.add(duration_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 140, -1));

        reps_field.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        reps_field.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        activity_form_panel.add(reps_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 140, -1));

        sets_field.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        sets_field.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        activity_form_panel.add(sets_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 140, -1));

        label7.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        label7.setForeground(new java.awt.Color(255, 255, 255));
        label7.setText("Duration");
        activity_form_panel.add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        activity_background.add(activity_form_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 350, 440));

        history_btn.setBackground(new java.awt.Color(102, 102, 102));
        history_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 16)); // NOI18N
        history_btn.setForeground(new java.awt.Color(255, 255, 255));
        history_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/history-icon.png"))); // NOI18N
        history_btn.setText("History");
        history_btn.setIconTextGap(15);
        history_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                history_btnActionPerformed(evt);
            }
        });
        activity_background.add(history_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, -1, 40));

        execomplete_btn.setBackground(new java.awt.Color(72, 98, 197));
        execomplete_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        execomplete_btn.setForeground(new java.awt.Color(255, 255, 255));
        execomplete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/complete-icon.png"))); // NOI18N
        execomplete_btn.setText("Mark as Complete");
        execomplete_btn.setIconTextGap(15);
        execomplete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                execomplete_btnActionPerformed(evt);
            }
        });
        activity_background.add(execomplete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 510, 190, 40));

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
                && exercise.equals("--Choose the exercise--")
                && durationUnit.equals("--Time--")) {
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
        if (durationUnit.equals("--Time--")) {
            JOptionPane.showMessageDialog(this, "Please select a valid duration unit.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF DURATION IS EMPTY OR NOT
        String durationStr;
        if (duration == 0) {
            durationStr = "None";
        } else {
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
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error while adding exercise: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_exeadd_btnActionPerformed

    private void exeupd_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exeupd_btnActionPerformed

    }//GEN-LAST:event_exeupd_btnActionPerformed

    private void exedel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exedel_btnActionPerformed

    }//GEN-LAST:event_exedel_btnActionPerformed

    private void execomplete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_execomplete_btnActionPerformed

    }//GEN-LAST:event_execomplete_btnActionPerformed

    private void history_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_history_btnActionPerformed

    }//GEN-LAST:event_history_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Resources.components.PanelBorder activity_background;
    private Resources.components.PanelBorder activity_form_buttons;
    private Resources.components.PanelBorder activity_form_panel;
    private Resources.components.PanelBorder activity_table_panel;
    private javax.swing.JComboBox<String> day_cbox;
    private javax.swing.JComboBox<String> duration_cbox;
    private javax.swing.JSpinner duration_field;
    private javax.swing.JButton exeadd_btn;
    private javax.swing.JButton execomplete_btn;
    private javax.swing.JButton exedel_btn;
    private javax.swing.JLabel exercise_element;
    private javax.swing.JTable exercise_table;
    private javax.swing.JButton exeupd_btn;
    private javax.swing.JButton history_btn;
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
    private javax.swing.JLabel or;
    private javax.swing.JSpinner reps_field;
    private Resources.components.ScrollPaneWin11 scrollPaneWin111;
    private javax.swing.JSpinner sets_field;
    private javax.swing.JComboBox<String> type_cbox;
    // End of variables declaration//GEN-END:variables
}
