package Content;

import Resources.components.Food1;
import Resources.components.Food10;
import Resources.components.Food2;
import Resources.components.Food3;
import Resources.components.Food4;
import Resources.components.Food5;
import Resources.components.Food6;
import Resources.components.Food7;
import Resources.components.Food8;
import Resources.components.Food9;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Food extends javax.swing.JFrame {

    public Food() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(Food.this);
        Image icon = new ImageIcon(this.getClass().getResource("/Resources/elements/fts-icon.png")).getImage();
        this.setIconImage(icon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new Resources.components.PanelBorder();
        panelBorder2 = new Resources.components.PanelBorder();
        scrollPaneWin111 = new Resources.components.ScrollPaneWin11();
        jPanel1 = new javax.swing.JPanel();
        panelBorder14 = new Resources.components.PanelBorder();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        panelBorder13 = new Resources.components.PanelBorder();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        panelBorder12 = new Resources.components.PanelBorder();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        panelBorder11 = new Resources.components.PanelBorder();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        panelBorder10 = new Resources.components.PanelBorder();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        panelBorder8 = new Resources.components.PanelBorder();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        panelBorder7 = new Resources.components.PanelBorder();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        panelBorder9 = new Resources.components.PanelBorder();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        panelBorder6 = new Resources.components.PanelBorder();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        panelBorder3 = new Resources.components.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        mover = new Resources.components.PanelMover();
        exit_btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(204, 204, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder14.setBackground(new java.awt.Color(142, 167, 233));
        panelBorder14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/foods/chickpea spinach curry.png"))); // NOI18N
        panelBorder14.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel36.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("A comforting, plant-based curry.");
        panelBorder14.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 300, -1));

        jLabel37.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Chickpea Spinach Curry");
        panelBorder14.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 300, -1));

        jButton10.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("View more...");
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton10MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton10MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton10MouseReleased(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        panelBorder14.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jPanel1.add(panelBorder14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 610, -1, 120));

        panelBorder13.setBackground(new java.awt.Color(142, 167, 233));
        panelBorder13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/foods/turkey lettuce wraps.png"))); // NOI18N
        panelBorder13.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel33.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("A low-carb, flavorful wrap option.");
        panelBorder13.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 300, -1));

        jLabel34.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Turkey Lettuce Wraps");
        panelBorder13.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 300, -1));

        jButton8.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("View more...");
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton8MouseReleased(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        panelBorder13.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jPanel1.add(panelBorder13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, -1, 120));

        panelBorder12.setBackground(new java.awt.Color(142, 167, 233));
        panelBorder12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/foods/oven-baked cod with asparagus.png"))); // NOI18N
        panelBorder12.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel30.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("A light yet flavorful fish meal.");
        panelBorder12.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 300, -1));

        jLabel31.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Oven-Baked Cod with Asparagus");
        panelBorder12.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 300, -1));

        jButton9.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("View more...");
        jButton9.setBorder(null);
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton9MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton9MouseReleased(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        panelBorder12.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jPanel1.add(panelBorder12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, -1, 120));

        panelBorder11.setBackground(new java.awt.Color(142, 167, 233));
        panelBorder11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/foods/tuna-stuffed bell peppers.png"))); // NOI18N
        panelBorder11.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel27.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("A protein-rich meal with vibrant colors.");
        panelBorder11.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 300, -1));

        jLabel28.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Tuna-Stuffed Bell Peppers");
        panelBorder11.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 300, -1));

        jButton7.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("View more...");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton7MouseReleased(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        panelBorder11.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jPanel1.add(panelBorder11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, 120));

        panelBorder10.setBackground(new java.awt.Color(142, 167, 233));
        panelBorder10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/foods/lentil soup.png"))); // NOI18N
        panelBorder10.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel24.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("A warm meal with protein and fiber.");
        panelBorder10.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 300, -1));

        jLabel25.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Lentil Soup");
        panelBorder10.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 300, -1));

        jButton5.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("View more...");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton5MouseReleased(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panelBorder10.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jPanel1.add(panelBorder10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, -1, 120));

        panelBorder8.setBackground(new java.awt.Color(142, 167, 233));
        panelBorder8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/foods/quinoa veggie bowl.png"))); // NOI18N
        panelBorder8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel18.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("A hearty, plant-based meal with nutrients.");
        panelBorder8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 300, -1));

        jLabel19.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Quinoa Veggie Bowl");
        panelBorder8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 300, -1));

        jButton6.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("View more...");
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton6MouseReleased(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        panelBorder8.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jPanel1.add(panelBorder8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, 120));

        panelBorder7.setBackground(new java.awt.Color(142, 167, 233));
        panelBorder7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/foods/greek yogurt parfait.png"))); // NOI18N
        panelBorder7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel15.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("A creamy, protein-packed breakfast or snack.");
        panelBorder7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 300, -1));

        jLabel16.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Greek Yogurt Parfait");
        panelBorder7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 300, -1));

        jButton3.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("View more...");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelBorder7.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jPanel1.add(panelBorder7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 120));

        panelBorder9.setBackground(new java.awt.Color(142, 167, 233));
        panelBorder9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/foods/cabbage stir-fry with tofu.png"))); // NOI18N
        panelBorder9.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel21.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("A vegan, high-fiber stir-fry.");
        panelBorder9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 300, -1));

        jLabel22.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Cabbage Stir-Fry with Tofu");
        panelBorder9.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 300, -1));

        jButton1.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("View more...");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelBorder9.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jPanel1.add(panelBorder9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, -1, 120));

        panelBorder6.setBackground(new java.awt.Color(142, 167, 233));
        panelBorder6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/foods/egg white veggie scramble.png"))); // NOI18N
        panelBorder6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel12.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("A low-fat, protein-rich breakfast option.");
        panelBorder6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 300, -1));

        jLabel13.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Egg White Veggie Scramble");
        panelBorder6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 300, -1));

        jButton4.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("View more...");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton4MouseReleased(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panelBorder6.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jPanel1.add(panelBorder6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, 120));

        panelBorder3.setBackground(new java.awt.Color(142, 167, 233));
        panelBorder3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/foods/grilled chicken salad.jpg"))); // NOI18N
        panelBorder3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("A light and protein-packed salad with greens.");
        panelBorder3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 300, -1));

        jLabel4.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Grilled Chicken Salad");
        panelBorder3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 300, -1));

        jButton2.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("View more...");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelBorder3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jPanel1.add(panelBorder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 120));

        scrollPaneWin111.setViewportView(jPanel1);

        panelBorder2.add(scrollPaneWin111, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 920, 410));
        panelBorder2.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 10));

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
        panelBorder2.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(114, 134, 211));
        jLabel5.setText("Food Recommendations!");
        panelBorder2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, -1, 30));

        panelBorder1.add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, 920, 465));

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 470));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        jButton1.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        jButton1.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        jButton2.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        jButton2.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        jButton2.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        jButton2.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton2MouseReleased

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jButton3.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        jButton3.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        jButton3.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton3MousePressed

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
        jButton3.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton3MouseReleased

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        jButton4.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jButton4.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        jButton4.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton4MousePressed

    private void jButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseReleased
        jButton4.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton4MouseReleased

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        jButton5.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        jButton5.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton5MouseExited

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
        jButton5.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton5MousePressed

    private void jButton5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseReleased
        jButton5.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton5MouseReleased

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        jButton6.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        jButton6.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton6MouseExited

    private void jButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MousePressed
        jButton6.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton6MousePressed

    private void jButton6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseReleased
        jButton6.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton6MouseReleased

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        jButton7.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        jButton7.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MousePressed
        jButton7.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton7MousePressed

    private void jButton7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseReleased
        jButton7.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton7MouseReleased

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
        jButton8.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton8MouseEntered

    private void jButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseExited
        jButton8.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton8MouseExited

    private void jButton8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MousePressed
        jButton8.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton8MousePressed

    private void jButton8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseReleased
        jButton8.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton8MouseReleased

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
        jButton9.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseExited
        jButton9.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton9MouseExited

    private void jButton9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MousePressed
        jButton9.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton9MousePressed

    private void jButton9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseReleased
        jButton9.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton9MouseReleased

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
        jButton10.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton10MouseEntered

    private void jButton10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseExited
        jButton10.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton10MouseExited

    private void jButton10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MousePressed
        jButton10.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton10MousePressed

    private void jButton10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseReleased
        jButton10.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton10MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Food1().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Food2().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new Food3().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Food4().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new Food5().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new Food6().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new Food7().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        new Food8().setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        new Food9().setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        new Food10().setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(Food.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Food.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Food.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Food.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Food().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit_btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private Resources.components.PanelMover mover;
    private Resources.components.PanelBorder panelBorder1;
    private Resources.components.PanelBorder panelBorder10;
    private Resources.components.PanelBorder panelBorder11;
    private Resources.components.PanelBorder panelBorder12;
    private Resources.components.PanelBorder panelBorder13;
    private Resources.components.PanelBorder panelBorder14;
    private Resources.components.PanelBorder panelBorder2;
    private Resources.components.PanelBorder panelBorder3;
    private Resources.components.PanelBorder panelBorder6;
    private Resources.components.PanelBorder panelBorder7;
    private Resources.components.PanelBorder panelBorder8;
    private Resources.components.PanelBorder panelBorder9;
    private Resources.components.ScrollPaneWin11 scrollPaneWin111;
    // End of variables declaration//GEN-END:variables
}
