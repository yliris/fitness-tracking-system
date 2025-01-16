package Content;

import java.awt.Color;

public class Profile extends javax.swing.JPanel {

    public Profile() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profile_background = new Resources.components.PanelBorder();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);

        profile_background.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("PROFILE");

        javax.swing.GroupLayout profile_backgroundLayout = new javax.swing.GroupLayout(profile_background);
        profile_background.setLayout(profile_backgroundLayout);
        profile_backgroundLayout.setHorizontalGroup(
            profile_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profile_backgroundLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(1174, Short.MAX_VALUE))
        );
        profile_backgroundLayout.setVerticalGroup(
            profile_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profile_backgroundLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(516, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profile_background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profile_background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private Resources.components.PanelBorder profile_background;
    // End of variables declaration//GEN-END:variables
}
