package Content;

import java.awt.Color;

public class Achievements extends javax.swing.JPanel {

    public Achievements() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        achievements_background = new Resources.components.PanelBorder();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        achievements_background.setBackground(new java.awt.Color(255, 255, 255));
        achievements_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(achievements_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 560));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Resources.components.PanelBorder achievements_background;
    // End of variables declaration//GEN-END:variables
}
