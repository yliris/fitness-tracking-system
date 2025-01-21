package Resources.components;

import Content.Home;
import Home.UserHome;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;

public class ExerciseHistory extends javax.swing.JFrame {

    private int userId;

    public ExerciseHistory(int userId) {
        initComponents();
        this.userId = userId;
        setBackground(new Color(0, 0, 0, 0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exehistory_background = new Resources.components.PanelBorder();
        scrollPaneWin111 = new Resources.components.ScrollPaneWin11();
        exehistory_table = new javax.swing.JTable();
        exit_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exehistory_background.setBackground(new java.awt.Color(142, 167, 233));
        exehistory_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exehistory_table.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        exehistory_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Day", "Type", "Name", "Duration", "Sets", "Reps", "Status", "Completed at"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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

        exehistory_background.add(scrollPaneWin111, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 1150, 440));

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
        exehistory_background.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1215, 5, -1, -1));

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Your Exercise History");
        exehistory_background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, 50));

        getContentPane().add(exehistory_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 560));

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
        this.dispose();
        UserHome home = new UserHome(userId);
        home.setVisible(true);
        home.showPanel("Activity");
    }//GEN-LAST:event_exit_btnActionPerformed

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

        int userId = 1;

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExerciseHistory(userId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Resources.components.PanelBorder exehistory_background;
    private javax.swing.JTable exehistory_table;
    private javax.swing.JButton exit_btn;
    private javax.swing.JLabel jLabel1;
    private Resources.components.ScrollPaneWin11 scrollPaneWin111;
    // End of variables declaration//GEN-END:variables
}
