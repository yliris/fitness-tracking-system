package Resources.components;

import Content.Home;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoalForm extends javax.swing.JFrame {

    private int userId;
    private Home home;

    public GoalForm(int userId, Home home) {
        initComponents();
        this.userId = userId;
        this.home = home;
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(GoalForm.this);
        Image icon = new ImageIcon(this.getClass().getResource("/Resources/elements/fts-icon.png")).getImage();
        this.setIconImage(icon);
        ButtonGroup goalGroup = new ButtonGroup();
        goalGroup.add(gain_rdb);
        goalGroup.add(lose_rdb);
        goalGroup.add(maintain_rdb);
        setgoal_btn.setEnabled(false);
        addRadioButtonListeners();
        fetchRecommendation();
        loadUserGoal();
    }

    private void addRadioButtonListeners() {
        ActionListener enableButtonListener = e -> setgoal_btn.setEnabled(true);
        gain_rdb.addActionListener(enableButtonListener);
        lose_rdb.addActionListener(enableButtonListener);
        maintain_rdb.addActionListener(enableButtonListener);
    }

    private void fetchRecommendation() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT classification FROM tb_users WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String classification = rs.getString("classification");
                String recommendation = "Recommendation: ";

                switch (classification) {
                    case "Underweight":
                        recommendation += "Gain Weight";
                        break;
                    case "Normal Weight":
                        recommendation += "Maintain Weight";
                        break;
                    case "Overweight":
                    case "Obese":
                        recommendation += "Lose Weight";
                        break;
                    default:
                        recommendation += "Consult a specialist";
                }

                recommendation_label.setText(recommendation);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error fetching recommendation: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadUserGoal() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT goal FROM tb_users WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String goal = rs.getString("goal");
                if (goal != null) {
                    label1.setText("Change your goal:");
                    switch (goal) {
                        case "Gain Weight":
                            gain_rdb.setSelected(true);
                            break;
                        case "Lose Weight":
                            lose_rdb.setSelected(true);
                            break;
                        case "Maintain Weight":
                            maintain_rdb.setSelected(true);
                            break;
                    }
                } else {
                    label1.setText("Set your goal:");
                }
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        edit_background = new Resources.components.PanelBorder();
        recommendation_label = new javax.swing.JLabel();
        setgoal_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        mover = new Resources.components.PanelMover();
        label1 = new javax.swing.JLabel();
        maintain_rdb = new javax.swing.JRadioButton();
        gain_rdb = new javax.swing.JRadioButton();
        lose_rdb = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edit_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recommendation_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        recommendation_label.setText("Recommended:");
        edit_background.add(recommendation_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 340, -1));

        setgoal_btn.setBackground(new java.awt.Color(102, 102, 255));
        setgoal_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        setgoal_btn.setForeground(new java.awt.Color(255, 255, 255));
        setgoal_btn.setText("SET GOAL");
        setgoal_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setgoal_btnActionPerformed(evt);
            }
        });
        edit_background.add(setgoal_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 350, -1));

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
        edit_background.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 5, 30, 30));
        edit_background.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 10));

        label1.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        label1.setText("Set Your Goal:");
        edit_background.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 320, -1));

        maintain_rdb.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        maintain_rdb.setText("Maintain Weight");
        edit_background.add(maintain_rdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        gain_rdb.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        gain_rdb.setText("Gain Weight");
        edit_background.add(gain_rdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        lose_rdb.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        lose_rdb.setText("Lose Weight");
        edit_background.add(lose_rdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        getContentPane().add(edit_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 160));

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
        dispose();
    }//GEN-LAST:event_exit_btnActionPerformed

    private void setgoal_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setgoal_btnActionPerformed
        String selectedGoal = null;

        if (gain_rdb.isSelected()) {
            selectedGoal = "Gain Weight";
        } else if (lose_rdb.isSelected()) {
            selectedGoal = "Lose Weight";
        } else if (maintain_rdb.isSelected()) {
            selectedGoal = "Maintain Weight";
        }

        if (selectedGoal == null) {
            JOptionPane.showMessageDialog(this, "Please select a goal.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmation = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to set your goal to \"" + selectedGoal + "\"?",
                "Confirm Goal",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmation != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            Connection conn = DatabaseConnection.getConnection();
            String updateQuery = "UPDATE tb_users SET goal = ? WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1, selectedGoal);
            pstmt.setInt(2, userId);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Goal set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                label1.setText("Change Your Goal:");
                home.exerciseResult();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to set goal. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            pstmt.close();
            conn.close();

            dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_setgoal_btnActionPerformed

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
            java.util.logging.Logger.getLogger(GoalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GoalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GoalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GoalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int userId = 1;
                Home home = new Home(userId);
                new GoalForm(userId, home).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Resources.components.PanelBorder edit_background;
    private javax.swing.JButton exit_btn;
    private javax.swing.JRadioButton gain_rdb;
    private javax.swing.JLabel label1;
    private javax.swing.JRadioButton lose_rdb;
    private javax.swing.JRadioButton maintain_rdb;
    private Resources.components.PanelMover mover;
    private javax.swing.JLabel recommendation_label;
    private javax.swing.JButton setgoal_btn;
    // End of variables declaration//GEN-END:variables

}
