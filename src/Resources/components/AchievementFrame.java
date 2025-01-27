package Resources.components;

import Account.*;
import Resources.components.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Arrays;

public class AchievementFrame extends javax.swing.JFrame {

    private int userId;

    public AchievementFrame(int userId) {
        initComponents();
        this.userId = userId;
        setBackground(new Color(0, 0, 0, 0));
        Image icon = new ImageIcon(this.getClass().getResource("/Resources/elements/fts-icon.png")).getImage();
        this.setIconImage(icon);
    }

    public int countCompletedExercise() {
        int count = 0;
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT COUNT(*) FROM tb_completed_exercises WHERE user_id = ? AND completed = 1";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void checkExerciseAchievements(int completedCount) {
        AchievementClass[] exerciseAchievements = {
            new AchievementClass("\"First Step!\"", "You completed your first five exercises! Keep going!", 5),
            new AchievementClass("\"Building Momentum!\"", "You’ve completed 10 exercises! Keep pushing yourself!", 20),
            new AchievementClass("\"Fitness Fanatic!\"", "20 exercises done! You’re making great progress!", 40),
            new AchievementClass("\"Energized Achiever!\"", "30 exercises completed! You’re unstoppable!", 60),
            new AchievementClass("\"Strength Pioneer!\"", "40 exercises done! Amazing commitment!", 80),
            new AchievementClass("\"Half-Century Strong!\"", "50 exercises completed! You’re a fitness pro!", 100),
            new AchievementClass("\"Trailblazer!\"", "60 exercises done! Keep leading the way!", 120),
            new AchievementClass("\"Relentless Warrior!\"", "70 exercises completed! Outstanding perseverance!", 140),
            new AchievementClass("\"Power Performer!\"", "80 exercises! Only 20 more to 100! Keep at it!", 160),
            new AchievementClass("\"Excellence Embodied!\"", "90 exercises completed! One more push to 100!", 180),
            new AchievementClass("\"Ultimate Legend!\"", "100 exercises done! You’re a true fitness legend!", 200)
        };

        for (AchievementClass achievement : exerciseAchievements) {
            if (completedCount >= achievement.getMilestone() && !isAchievementSaved(achievement.getTitle(), "Exercise")) {
                showAchievementPopup(achievement);
                saveAchievement(achievement, "Exercise");
                break;
            }
        }
    }

    public int countCompletedMeals() {
        int count = 0;
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT COUNT(*) FROM tb_completed_meals WHERE user_id = ? AND completed = 1";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void checkMealAchievements(int completedCount) {
        AchievementClass[] mealAchievements = {
            new AchievementClass("\"Fueling Up!\"", "You completed your first five meals! Keep going!", 5),
            new AchievementClass("\"Nourishment Master!\"", "You’ve completed 10 meals! Stay consistent!", 20),
            new AchievementClass("\"Healthy Habits!\"", "20 meals completed! Amazing dedication!", 40),
            new AchievementClass("\"Energy Enthusiast!\"", "30 meals done! You’re on the right track!", 60),
            new AchievementClass("\"Balanced Pro!\"", "40 meals completed! Excellent progress!", 80),
            new AchievementClass("\"Nutrition Expert!\"", "50 meals logged! You’re becoming a pro!", 100),
            new AchievementClass("\"Sustenance Champion!\"", "60 meals tracked! Incredible work!", 120),
            new AchievementClass("\"Calorie Commander!\"", "70 meals completed! Keep the streak alive!", 140),
            new AchievementClass("\"Macro Master!\"", "80 meals finished! 20 more to 100!", 160),
            new AchievementClass("\"Meal Time Hero!\"", "90 meals logged! Almost at the top!", 180),
            new AchievementClass("\"Ultimate Foodie!\"", "100 meals completed! You’re unstoppable!", 200)
        };

        for (AchievementClass achievement : mealAchievements) {
            if (completedCount >= achievement.getMilestone() && !isAchievementSaved(achievement.getTitle(), "Diet")) {
                showAchievementPopup(achievement);
                saveAchievement(achievement, "Diet");
                break;
            }
        }
    }

    private void showAchievementPopup(AchievementClass achievement) {
        achievement_title.setText(achievement.getTitle());
        achievement_description.setText(achievement.getDescription());
        this.setVisible(true);
    }

    private void saveAchievement(AchievementClass achievement, String type) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO tb_achievements (user_id, achievement_title, achievement_description, achievement_type, date_achieved) VALUES (?, ?, ?, ?, NOW())";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            stmt.setString(2, achievement.getTitle());
            stmt.setString(3, achievement.getDescription());
            stmt.setString(4, type);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean isAchievementSaved(String title, String type) {
        boolean exists = false;
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT COUNT(*) FROM tb_achievements WHERE user_id = ? AND achievement_title = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            stmt.setString(2, title);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                exists = rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        achievement_title = new javax.swing.JLabel();
        achievement_description = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 520, 290));

        achievement_title.setFont(new java.awt.Font("Cascadia Mono", 3, 24)); // NOI18N
        achievement_title.setForeground(new java.awt.Color(76, 101, 199));
        achievement_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        achievement_title.setText("\"Title\"");
        getContentPane().add(achievement_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 500, 30));

        achievement_description.setFont(new java.awt.Font("Cascadia Mono", 2, 14)); // NOI18N
        achievement_description.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        achievement_description.setText("\"Description\"");
        getContentPane().add(achievement_description, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 500, -1));

        jLabel4.setFont(new java.awt.Font("Cascadia Mono", 1, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Achievement Accomplished!");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 500, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/achievement-element.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 470));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        dispose();
    }//GEN-LAST:event_jPanel1MouseClicked

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
            java.util.logging.Logger.getLogger(AchievementFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AchievementFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AchievementFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AchievementFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int userId = 1;
                new AchievementFrame(userId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel achievement_description;
    private javax.swing.JLabel achievement_title;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
