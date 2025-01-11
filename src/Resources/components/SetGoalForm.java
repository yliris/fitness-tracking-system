package Resources.components;

import Home.AdminHome;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class SetGoalForm extends javax.swing.JFrame {

    private javax.swing.JLabel bmi_label;

    public SetGoalForm() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(SetGoalForm.this);
        Image icon = new ImageIcon(this.getClass().getResource("/Resources/elements/fts-icon.png")).getImage();
        this.setIconImage(icon);
        initListeners();
    }

    private void initListeners() {
        age_field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toggleConfirmButton();
            }
        });
        weight_field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toggleConfirmButton();
            }
        });
        height_field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toggleConfirmButton();
            }
        });
        male_rdb.addActionListener(e -> toggleConfirmButton());
        female_rdb.addActionListener(e -> toggleConfirmButton());

        confirm_btn.addActionListener(e -> updateBmiAndEnableSignup());
    }

    private void toggleConfirmButton() {
        boolean isValid = !age_field.getText().isEmpty()
                && !weight_field.getText().isEmpty()
                && !height_field.getText().isEmpty()
                && (male_rdb.isSelected() || female_rdb.isSelected());
        confirm_btn.setEnabled(isValid);
    }

    private void updateBmiAndEnableSignup() {
        try {
            float weight = Float.parseFloat(weight_field.getText());
            float height = Float.parseFloat(height_field.getText()) / 100;
            if (weight > 0 && height > 0) {
                float bmiValue = weight / (height * height);
                bmi.setText(String.format("BMI: %.2f", bmiValue)); // Reference bmi, not bmi_label
                signup_btn.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid weight or height values.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for weight and height.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new Resources.components.PanelBorder();
        exit_btn = new javax.swing.JButton();
        age = new javax.swing.JLabel();
        age_field = new javax.swing.JTextField();
        sex = new javax.swing.JLabel();
        female_rdb = new javax.swing.JRadioButton();
        male_rdb = new javax.swing.JRadioButton();
        weight = new javax.swing.JLabel();
        weight_field = new javax.swing.JTextField();
        height = new javax.swing.JLabel();
        height_field = new javax.swing.JTextField();
        bmi = new javax.swing.JLabel();
        confirm_btn = new javax.swing.JButton();
        signup_btn = new javax.swing.JButton();
        mover = new Resources.components.PanelMover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        panelBorder1.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 30, 30));

        age.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        age.setText("Age:");
        panelBorder1.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 140, -1));
        panelBorder1.add(age_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 140, -1));

        sex.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        sex.setText("Sex:");
        panelBorder1.add(sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, -1));

        female_rdb.setText("Female");
        panelBorder1.add(female_rdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        male_rdb.setText("Male");
        panelBorder1.add(male_rdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        weight.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        weight.setText("Weight:");
        panelBorder1.add(weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));
        panelBorder1.add(weight_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 290, -1));

        height.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        height.setText("Height:");
        panelBorder1.add(height, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));
        panelBorder1.add(height_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 290, -1));

        bmi.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        bmi.setText("BMI:");
        panelBorder1.add(bmi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 290, 20));

        confirm_btn.setText("Confirm");
        confirm_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(confirm_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        signup_btn.setText("Sign up");
        signup_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(signup_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, -1, -1));
        panelBorder1.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 20));

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 430));

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

    private void confirm_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm_btnActionPerformed
        updateBmiAndEnableSignup();
    }//GEN-LAST:event_confirm_btnActionPerformed

    private void signup_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_btnActionPerformed
        String ageText = age_field.getText();
        String sex = male_rdb.isSelected() ? "Male" : (female_rdb.isSelected() ? "Female" : null);
        String weightText = weight_field.getText();
        String heightText = height_field.getText();

        if (ageText.isEmpty() || sex == null || weightText.isEmpty() || heightText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float weight, height;
        try {
            weight = Float.parseFloat(weightText);
            height = Float.parseFloat(heightText);

            if (weight <= 0 || weight > 300) {
                JOptionPane.showMessageDialog(this, "Weight must be a valid number between 1 and 300.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (height <= 0 || height > 250) {
                JOptionPane.showMessageDialog(this, "Height must be a valid number between 1 and 250.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Weight and height must be valid numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection conn = DatabaseConnection.getConnection();

            String insertQuery = "INSERT INTO tb_users (age, sex, weight, height) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insertQuery);

            stmt.setInt(1, Integer.parseInt(ageText));
            stmt.setString(2, sex);
            stmt.setFloat(3, weight);
            stmt.setFloat(4, height);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Signup successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save data.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            stmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_signup_btnActionPerformed

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
            java.util.logging.Logger.getLogger(SetGoalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SetGoalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SetGoalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SetGoalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SetGoalForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel age;
    private javax.swing.JTextField age_field;
    private javax.swing.JLabel bmi;
    private javax.swing.JButton confirm_btn;
    private javax.swing.JButton exit_btn;
    private javax.swing.JRadioButton female_rdb;
    private javax.swing.JLabel height;
    private javax.swing.JTextField height_field;
    private javax.swing.JRadioButton male_rdb;
    private Resources.components.PanelMover mover;
    private Resources.components.PanelBorder panelBorder1;
    private javax.swing.JLabel sex;
    private javax.swing.JButton signup_btn;
    private javax.swing.JLabel weight;
    private javax.swing.JTextField weight_field;
    // End of variables declaration//GEN-END:variables

}
