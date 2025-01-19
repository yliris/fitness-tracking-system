package Content;

import java.awt.Color;

public class Guide extends javax.swing.JPanel {

    public Guide() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        guide_background = new Resources.components.PanelBorder();

        guide_background.setBackground(new java.awt.Color(255, 255, 255));
        guide_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(guide_background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(guide_background, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Resources.components.PanelBorder guide_background;
    // End of variables declaration//GEN-END:variables
}
