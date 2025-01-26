package Content;

import java.awt.Color;
import Resources.components.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Achievements extends javax.swing.JPanel {

    private int userId;

    public Achievements(int userId) {
        initComponents();
        this.userId = userId;
        setBackground(new Color(0, 0, 0, 0));
        loadAchievements();
        countAchievements();
    }

    public void loadAchievements() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql1 = "SELECT achievement_title, achievement_description FROM tb_achievements WHERE user_id = ? AND achievement_type = 'Exercise'";
            try (PreparedStatement stmt1 = conn.prepareStatement(sql1)) {
                stmt1.setInt(1, userId);
                ResultSet rs1 = stmt1.executeQuery();

                javax.swing.table.DefaultTableModel exerciseModel = new javax.swing.table.DefaultTableModel(
                        new Object[][]{},
                        new String[]{"Title", "Description"}
                );
                exeachievement_table.setModel(exerciseModel);

                while (rs1.next()) {
                    String title = rs1.getString("achievement_title");
                    String description = rs1.getString("achievement_description");
                    exerciseModel.addRow(new Object[]{title, description});
                }
            }

            String sql2 = "SELECT achievement_title, achievement_description FROM tb_achievements WHERE user_id = ? AND achievement_type = 'Diet'";
            try (PreparedStatement stmt2 = conn.prepareStatement(sql2)) {
                stmt2.setInt(1, userId);
                ResultSet rs2 = stmt2.executeQuery();

                javax.swing.table.DefaultTableModel dietModel = new javax.swing.table.DefaultTableModel(
                        new Object[][]{},
                        new String[]{"Title", "Description"}
                );
                dietachievement_table.setModel(dietModel);

                while (rs2.next()) {
                    String title = rs2.getString("achievement_title");
                    String description = rs2.getString("achievement_description");
                    dietModel.addRow(new Object[]{title, description});
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading achievements: " + ex.getMessage());
        }
    }

    public void countAchievements() {
        int exerciseCount = 0;
        int dietCount = 0;
        int totalAchievements = 22;
        int unlockedAchievements = 0;

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sqlExercise = "SELECT COUNT(*) AS count FROM tb_achievements WHERE user_id = ? AND achievement_type = 'Exercise'";
            try (PreparedStatement stmt1 = conn.prepareStatement(sqlExercise)) {
                stmt1.setInt(1, userId);
                ResultSet rs1 = stmt1.executeQuery();
                if (rs1.next()) {
                    exerciseCount = rs1.getInt("count");
                }
            }

            String sqlDiet = "SELECT COUNT(*) AS count FROM tb_achievements WHERE user_id = ? AND achievement_type = 'Diet'";
            try (PreparedStatement stmt2 = conn.prepareStatement(sqlDiet)) {
                stmt2.setInt(1, userId);
                ResultSet rs2 = stmt2.executeQuery();
                if (rs2.next()) {
                    dietCount = rs2.getInt("count");
                }
            }

            unlockedAchievements = exerciseCount + dietCount;

            exercises_total.setText("Total Completed: " + exerciseCount);
            diet_total.setText("Total Completed: " + dietCount);

            String overallProgress = unlockedAchievements + "/" + totalAchievements + " Achievements Unlocked";
            jLabel4.setText("ACCOMPLISHED ACHIEVEMENTS (" + overallProgress + ")");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error counting achievements: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        achievements_background = new Resources.components.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelBorder1 = new Resources.components.PanelBorder();
        scrollPaneWin111 = new Resources.components.ScrollPaneWin11();
        exeachievement_table = new javax.swing.JTable();
        panelBorder2 = new Resources.components.PanelBorder();
        scrollPaneWin112 = new Resources.components.ScrollPaneWin11();
        dietachievement_table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        exercises_total = new javax.swing.JLabel();
        diet_total = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        achievements_background.setBackground(new java.awt.Color(255, 255, 255));
        achievements_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Cascadia Mono", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("\"Every small step forward brings you closer to your goals. Keep pushing, stay consistent, and trust the process!\"");
        achievements_background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 1250, -1));

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("DIET");
        achievements_background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 60, 30));

        panelBorder1.setBackground(new java.awt.Color(142, 167, 233));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exeachievement_table.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        exeachievement_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        exeachievement_table.setGridColor(new java.awt.Color(234, 234, 234));
        exeachievement_table.setRowHeight(40);
        exeachievement_table.setSelectionBackground(new java.awt.Color(96, 220, 96));
        exeachievement_table.setSelectionForeground(new java.awt.Color(255, 255, 255));
        exeachievement_table.setShowHorizontalLines(true);
        scrollPaneWin111.setViewportView(exeachievement_table);
        if (exeachievement_table.getColumnModel().getColumnCount() > 0) {
            exeachievement_table.getColumnModel().getColumn(0).setMinWidth(20);
            exeachievement_table.getColumnModel().getColumn(0).setPreferredWidth(1);
            exeachievement_table.getColumnModel().getColumn(1).setMinWidth(130);
            exeachievement_table.getColumnModel().getColumn(1).setPreferredWidth(1);
        }

        panelBorder1.add(scrollPaneWin111, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 540, 320));

        achievements_background.add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 580, 360));

        panelBorder2.setBackground(new java.awt.Color(142, 167, 233));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dietachievement_table.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        dietachievement_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dietachievement_table.setGridColor(new java.awt.Color(234, 234, 234));
        dietachievement_table.setRowHeight(40);
        dietachievement_table.setSelectionBackground(new java.awt.Color(96, 220, 96));
        dietachievement_table.setSelectionForeground(new java.awt.Color(255, 255, 255));
        dietachievement_table.setShowHorizontalLines(true);
        scrollPaneWin112.setViewportView(dietachievement_table);
        if (dietachievement_table.getColumnModel().getColumnCount() > 0) {
            dietachievement_table.getColumnModel().getColumn(0).setMinWidth(20);
            dietachievement_table.getColumnModel().getColumn(0).setPreferredWidth(1);
            dietachievement_table.getColumnModel().getColumn(1).setMinWidth(130);
            dietachievement_table.getColumnModel().getColumn(1).setPreferredWidth(1);
        }

        panelBorder2.add(scrollPaneWin112, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 550, 320));

        achievements_background.add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 590, 360));

        jLabel4.setFont(new java.awt.Font("Cascadia Mono", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(114, 134, 211));
        jLabel4.setText("ACCOMPLISHED ACHIEVEMENTS");
        achievements_background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("EXERCISES");
        achievements_background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 110, 30));

        exercises_total.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        exercises_total.setForeground(new java.awt.Color(102, 102, 102));
        achievements_background.add(exercises_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 350, 30));

        diet_total.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        diet_total.setForeground(new java.awt.Color(102, 102, 102));
        achievements_background.add(diet_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, 350, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/achievements-element.png"))); // NOI18N
        achievements_background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        add(achievements_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 560));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Resources.components.PanelBorder achievements_background;
    private javax.swing.JLabel diet_total;
    private javax.swing.JTable dietachievement_table;
    private javax.swing.JTable exeachievement_table;
    private javax.swing.JLabel exercises_total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private Resources.components.PanelBorder panelBorder1;
    private Resources.components.PanelBorder panelBorder2;
    private Resources.components.ScrollPaneWin11 scrollPaneWin111;
    private Resources.components.ScrollPaneWin11 scrollPaneWin112;
    // End of variables declaration//GEN-END:variables
}
