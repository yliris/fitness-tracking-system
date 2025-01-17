package Content;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class Activity extends javax.swing.JPanel {

    public Activity() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        activity_table.getTableHeader().setDefaultRenderer(headerRenderer);
        
        JTableHeader header = activity_table.getTableHeader();
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 30));
        header.setBackground(new Color(255, 255, 255));
        header.setForeground(new Color(51, 51, 51));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        activity_background = new Resources.components.PanelBorder();
        activity_table_panel = new Resources.components.PanelBorder();
        scrollPaneWin111 = new Resources.components.ScrollPaneWin11();
        activity_table = new javax.swing.JTable();
        activity_form_panel = new Resources.components.PanelBorder();
        activity_confirm_panel = new Resources.components.PanelBorder();

        activity_background.setBackground(new java.awt.Color(255, 255, 255));
        activity_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        activity_table_panel.setBackground(new java.awt.Color(153, 153, 255));
        activity_table_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollPaneWin111.setRowHeaderView(null);

        activity_table.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        activity_table.setForeground(new java.awt.Color(51, 51, 51));
        activity_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Day", "Activity", "Sets", "Reps", "Completed"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        activity_table.setGridColor(new java.awt.Color(255, 255, 255));
        activity_table.setSelectionBackground(new java.awt.Color(137, 229, 137));
        activity_table.setSelectionForeground(new java.awt.Color(255, 255, 255));
        activity_table.setShowHorizontalLines(true);
        scrollPaneWin111.setViewportView(activity_table);

        activity_table_panel.add(scrollPaneWin111, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 660, 410));

        activity_background.add(activity_table_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 720, 470));

        activity_form_panel.setBackground(new java.awt.Color(95, 95, 215));
        activity_form_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        activity_background.add(activity_form_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 350, 440));

        activity_confirm_panel.setBackground(new java.awt.Color(102, 102, 102));
        activity_confirm_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        activity_background.add(activity_confirm_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 480, 170, 60));

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Resources.components.PanelBorder activity_background;
    private Resources.components.PanelBorder activity_confirm_panel;
    private Resources.components.PanelBorder activity_form_panel;
    private javax.swing.JTable activity_table;
    private Resources.components.PanelBorder activity_table_panel;
    private Resources.components.ScrollPaneWin11 scrollPaneWin111;
    // End of variables declaration//GEN-END:variables
}
