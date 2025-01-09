package Home;

import Account.LoginForm;
import Connection.DatabaseConnection;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class UserHome extends javax.swing.JFrame {

    public UserHome() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(UserHome.this);
        Image icon = new ImageIcon(this.getClass().getResource("/Resources/elements/fts-icon.png")).getImage();
        this.setIconImage(icon);
    }

    private void deleteAccount(String username) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM tb_users WHERE username = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);

            int result = ps.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Account deleted successfully.");
                new LoginForm().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error: Could not delete the account.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home_background = new Resources.components.PanelBorder();
        header_panel = new Resources.components.PanelBorder();
        profile_btn = new Resources.components.PanelBorder();
        greetings = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        home_btn = new Resources.components.PanelBorder();
        home = new javax.swing.JLabel();
        dashboard_btn = new Resources.components.PanelBorder();
        dashboard = new javax.swing.JLabel();
        exercise_btn = new Resources.components.PanelBorder();
        exercise = new javax.swing.JLabel();
        diet_btn = new Resources.components.PanelBorder();
        diet = new javax.swing.JLabel();
        guide_btn = new Resources.components.PanelBorder();
        guide = new javax.swing.JLabel();
        logout_btn = new javax.swing.JButton();
        exit_btn1 = new javax.swing.JButton();
        body_panel = new javax.swing.JTabbedPane();
        profile_panel = new Resources.components.PanelBorder();
        profile_header = new Resources.components.PanelBorder();
        profile = new javax.swing.JLabel();
        profile_buttons = new Resources.components.PanelBorder();
        profile_edit_btn = new javax.swing.JButton();
        profile_security_btn = new javax.swing.JButton();
        profile_delete_btn = new javax.swing.JButton();
        profile_tabs = new javax.swing.JTabbedPane();
        view_profile = new Resources.components.PanelBorder();
        edit_profile_info = new Resources.components.PanelBorder();
        edit_profile_form = new Resources.components.PanelBorder();
        label1 = new javax.swing.JLabel();
        exit_btn2 = new javax.swing.JButton();
        profile_first_name = new javax.swing.JLabel();
        profile_first_name_field = new javax.swing.JTextField();
        profile_last_name = new javax.swing.JLabel();
        profile_last_name_field = new javax.swing.JTextField();
        profile_email = new javax.swing.JLabel();
        profile_email_field = new javax.swing.JTextField();
        profile_username = new javax.swing.JLabel();
        profile_username_field = new javax.swing.JTextField();
        profile_save_btn = new javax.swing.JButton();
        edit_profile_security = new Resources.components.PanelBorder();
        edit_security_form = new Resources.components.PanelBorder();
        exit_btn3 = new javax.swing.JButton();
        label2 = new javax.swing.JLabel();
        profile_password = new javax.swing.JLabel();
        profile_password_field = new javax.swing.JTextField();
        profile_sec_question = new javax.swing.JLabel();
        profile_question_field = new javax.swing.JTextField();
        profile_sec_answer = new javax.swing.JLabel();
        profile_answer_field = new javax.swing.JTextField();
        security_save_btn = new javax.swing.JButton();
        home_panel = new Resources.components.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        dashboard_panel = new Resources.components.PanelBorder();
        jLabel3 = new javax.swing.JLabel();
        exercise_panel = new Resources.components.PanelBorder();
        jLabel4 = new javax.swing.JLabel();
        diet_panel = new Resources.components.PanelBorder();
        jLabel5 = new javax.swing.JLabel();
        guide_panel = new Resources.components.PanelBorder();
        jLabel6 = new javax.swing.JLabel();
        mover = new Resources.components.PanelMover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home_background.setBackground(new java.awt.Color(255, 255, 255));
        home_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header_panel.setBackground(new java.awt.Color(81, 199, 135));

        profile_btn.setBackground(new java.awt.Color(102, 102, 255));
        profile_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profile_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profile_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profile_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                profile_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                profile_btnMouseReleased(evt);
            }
        });

        greetings.setFont(new java.awt.Font("Cascadia Mono", 1, 16)); // NOI18N
        greetings.setForeground(new java.awt.Color(255, 255, 255));
        greetings.setText("Hi, (name)");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/fts-small-icon.png"))); // NOI18N

        javax.swing.GroupLayout profile_btnLayout = new javax.swing.GroupLayout(profile_btn);
        profile_btn.setLayout(profile_btnLayout);
        profile_btnLayout.setHorizontalGroup(
            profile_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profile_btnLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(greetings, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        profile_btnLayout.setVerticalGroup(
            profile_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profile_btnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(profile_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(greetings, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        home_btn.setBackground(new java.awt.Color(50, 158, 100));
        home_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                home_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                home_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                home_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                home_btnMouseReleased(evt);
            }
        });
        home_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/home-icon.png"))); // NOI18N
        home_btn.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        dashboard_btn.setBackground(new java.awt.Color(50, 158, 100));
        dashboard_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboard_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboard_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboard_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dashboard_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dashboard_btnMouseReleased(evt);
            }
        });
        dashboard_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/dashboard-icon.png"))); // NOI18N
        dashboard_btn.add(dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        exercise_btn.setBackground(new java.awt.Color(50, 158, 100));
        exercise_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exercise_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exercise_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exercise_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exercise_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exercise_btnMouseReleased(evt);
            }
        });
        exercise_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exercise.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exercise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/exercise-icon.png"))); // NOI18N
        exercise_btn.add(exercise, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        diet_btn.setBackground(new java.awt.Color(50, 158, 100));
        diet_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diet_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                diet_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                diet_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                diet_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                diet_btnMouseReleased(evt);
            }
        });
        diet_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        diet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/diet-icon.png"))); // NOI18N
        diet_btn.add(diet, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        guide_btn.setBackground(new java.awt.Color(50, 158, 100));
        guide_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guide_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                guide_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                guide_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                guide_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                guide_btnMouseReleased(evt);
            }
        });
        guide_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        guide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/guide-icon.png"))); // NOI18N
        guide_btn.add(guide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-white-idle.png"))); // NOI18N
        logout_btn.setBorder(null);
        logout_btn.setBorderPainted(false);
        logout_btn.setContentAreaFilled(false);
        logout_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logout_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logout_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logout_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logout_btnMouseReleased(evt);
            }
        });
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });

        exit_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-idle.png"))); // NOI18N
        exit_btn1.setBorder(null);
        exit_btn1.setBorderPainted(false);
        exit_btn1.setContentAreaFilled(false);
        exit_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_btn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit_btn1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exit_btn1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exit_btn1MouseReleased(evt);
            }
        });
        exit_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout header_panelLayout = new javax.swing.GroupLayout(header_panel);
        header_panel.setLayout(header_panelLayout);
        header_panelLayout.setHorizontalGroup(
            header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panelLayout.createSequentialGroup()
                .addComponent(profile_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(home_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(dashboard_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(exercise_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(diet_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(guide_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logout_btn)
                .addGap(8, 8, 8)
                .addComponent(exit_btn1))
        );
        header_panelLayout.setVerticalGroup(
            header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profile_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(header_panelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logout_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exit_btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(home_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dashboard_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exercise_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(diet_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guide_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        home_background.add(header_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 960, 50));

        profile_panel.setBackground(new java.awt.Color(255, 255, 255));
        profile_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile_header.setBackground(new java.awt.Color(243, 243, 243));
        profile_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile.setBackground(new java.awt.Color(112, 112, 112));
        profile.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        profile.setForeground(new java.awt.Color(84, 84, 84));
        profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/profile-icon.png"))); // NOI18N
        profile.setText("PROFILE");
        profile.setIconTextGap(15);
        profile_header.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        profile_panel.add(profile_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 960, 40));

        profile_buttons.setBackground(new java.awt.Color(243, 243, 243));
        profile_buttons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile_edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-edit-idle-icon.png"))); // NOI18N
        profile_edit_btn.setBorder(null);
        profile_edit_btn.setBorderPainted(false);
        profile_edit_btn.setContentAreaFilled(false);
        profile_edit_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profile_edit_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profile_edit_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                profile_edit_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                profile_edit_btnMouseReleased(evt);
            }
        });
        profile_edit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile_edit_btnActionPerformed(evt);
            }
        });
        profile_buttons.add(profile_edit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-security-idle-icon.png"))); // NOI18N
        profile_security_btn.setBorder(null);
        profile_security_btn.setBorderPainted(false);
        profile_security_btn.setContentAreaFilled(false);
        profile_security_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profile_security_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profile_security_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                profile_security_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                profile_security_btnMouseReleased(evt);
            }
        });
        profile_security_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile_security_btnActionPerformed(evt);
            }
        });
        profile_buttons.add(profile_security_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 30, 30));

        profile_delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-delete-idle-icon.png"))); // NOI18N
        profile_delete_btn.setBorder(null);
        profile_delete_btn.setBorderPainted(false);
        profile_delete_btn.setContentAreaFilled(false);
        profile_delete_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profile_delete_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profile_delete_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                profile_delete_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                profile_delete_btnMouseReleased(evt);
            }
        });
        profile_delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile_delete_btnActionPerformed(evt);
            }
        });
        profile_buttons.add(profile_delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 30, 30));

        profile_panel.add(profile_buttons, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 420, 130, 50));

        view_profile.setBackground(new java.awt.Color(255, 255, 255));
        view_profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        profile_tabs.addTab("tab1", view_profile);

        edit_profile_info.setBackground(new java.awt.Color(255, 255, 255));
        edit_profile_info.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edit_profile_form.setBackground(new java.awt.Color(153, 153, 255));
        edit_profile_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setBackground(new java.awt.Color(112, 112, 112));
        label1.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Edit Personal Details");
        label1.setIconTextGap(15);
        edit_profile_form.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 250, 50));

        exit_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-idle.png"))); // NOI18N
        exit_btn2.setBorder(null);
        exit_btn2.setBorderPainted(false);
        exit_btn2.setContentAreaFilled(false);
        exit_btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_btn2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit_btn2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exit_btn2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exit_btn2MouseReleased(evt);
            }
        });
        exit_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btn2ActionPerformed(evt);
            }
        });
        edit_profile_form.add(exit_btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 5, -1, -1));

        profile_first_name.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        profile_first_name.setForeground(new java.awt.Color(255, 255, 255));
        profile_first_name.setText("First Name");
        edit_profile_form.add(profile_first_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 170, 20));

        profile_first_name_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        edit_profile_form.add(profile_first_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 170, -1));

        profile_last_name.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        profile_last_name.setForeground(new java.awt.Color(255, 255, 255));
        profile_last_name.setText("Last Name");
        edit_profile_form.add(profile_last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 170, 20));

        profile_last_name_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        edit_profile_form.add(profile_last_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 170, -1));

        profile_email.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        profile_email.setForeground(new java.awt.Color(255, 255, 255));
        profile_email.setText("Email");
        edit_profile_form.add(profile_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 350, 20));

        profile_email_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        edit_profile_form.add(profile_email_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 350, -1));

        profile_username.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        profile_username.setForeground(new java.awt.Color(255, 255, 255));
        profile_username.setText("Username");
        edit_profile_form.add(profile_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 350, 20));

        profile_username_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        edit_profile_form.add(profile_username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 350, -1));

        profile_save_btn.setBackground(new java.awt.Color(102, 102, 255));
        profile_save_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        profile_save_btn.setForeground(new java.awt.Color(255, 255, 255));
        profile_save_btn.setText("Save Changes");
        profile_save_btn.setAlignmentY(0.0F);
        profile_save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile_save_btnActionPerformed(evt);
            }
        });
        edit_profile_form.add(profile_save_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 350, 30));

        edit_profile_info.add(edit_profile_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 400, 290));

        profile_tabs.addTab("tab2", edit_profile_info);

        edit_profile_security.setBackground(new java.awt.Color(255, 255, 255));
        edit_profile_security.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edit_security_form.setBackground(new java.awt.Color(131, 215, 169));
        edit_security_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit_btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-idle.png"))); // NOI18N
        exit_btn3.setBorder(null);
        exit_btn3.setBorderPainted(false);
        exit_btn3.setContentAreaFilled(false);
        exit_btn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_btn3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit_btn3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exit_btn3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exit_btn3MouseReleased(evt);
            }
        });
        exit_btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btn3ActionPerformed(evt);
            }
        });
        edit_security_form.add(exit_btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 5, -1, -1));

        label2.setBackground(new java.awt.Color(112, 112, 112));
        label2.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("Edit Security Details");
        label2.setIconTextGap(15);
        edit_security_form.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 250, 50));

        profile_password.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        profile_password.setForeground(new java.awt.Color(255, 255, 255));
        profile_password.setText("Password");
        edit_security_form.add(profile_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 350, 20));

        profile_password_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        edit_security_form.add(profile_password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 350, -1));

        profile_sec_question.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        profile_sec_question.setForeground(new java.awt.Color(255, 255, 255));
        profile_sec_question.setText("Validation Question");
        edit_security_form.add(profile_sec_question, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 350, 20));

        profile_question_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        edit_security_form.add(profile_question_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 350, -1));

        profile_sec_answer.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        profile_sec_answer.setForeground(new java.awt.Color(255, 255, 255));
        profile_sec_answer.setText("Validation Answer");
        edit_security_form.add(profile_sec_answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 350, 20));

        profile_answer_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        edit_security_form.add(profile_answer_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 350, -1));

        security_save_btn.setBackground(new java.awt.Color(51, 198, 117));
        security_save_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        security_save_btn.setForeground(new java.awt.Color(255, 255, 255));
        security_save_btn.setText("Save Changes");
        security_save_btn.setAlignmentY(0.0F);
        security_save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                security_save_btnActionPerformed(evt);
            }
        });
        edit_security_form.add(security_save_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 350, 30));

        edit_profile_security.add(edit_security_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 400, 290));

        profile_tabs.addTab("tab3", edit_profile_security);

        profile_panel.add(profile_tabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 960, 460));

        body_panel.addTab("tab1", profile_panel);

        home_panel.setBackground(new java.awt.Color(153, 153, 153));
        home_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("home");
        home_panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        body_panel.addTab("tab2", home_panel);

        dashboard_panel.setBackground(new java.awt.Color(153, 153, 153));
        dashboard_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("dashboard");
        dashboard_panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        body_panel.addTab("tab3", dashboard_panel);

        exercise_panel.setBackground(new java.awt.Color(153, 153, 153));
        exercise_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("exercise");
        exercise_panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        body_panel.addTab("tab4", exercise_panel);

        diet_panel.setBackground(new java.awt.Color(153, 153, 153));
        diet_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("diet");
        diet_panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        body_panel.addTab("tab5", diet_panel);

        guide_panel.setBackground(new java.awt.Color(153, 153, 153));
        guide_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("guide");
        guide_panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        body_panel.addTab("tab6", guide_panel);

        home_background.add(body_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 960, 510));
        home_background.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 940, 20));

        getContentPane().add(home_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logout_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMouseEntered
        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-white-hover.png")));
    }//GEN-LAST:event_logout_btnMouseEntered

    private void logout_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMouseExited
        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-white-idle.png")));
    }//GEN-LAST:event_logout_btnMouseExited

    private void logout_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMousePressed
        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-white-click.png")));
    }//GEN-LAST:event_logout_btnMousePressed

    private void logout_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMouseReleased
        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-white-hover.png")));
    }//GEN-LAST:event_logout_btnMouseReleased

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        int confirmLogout = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to logout?",
                "Logout",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmLogout == JOptionPane.YES_OPTION) {
            dispose();
            new LoginForm().setVisible(true);
        }
    }//GEN-LAST:event_logout_btnActionPerformed

    private void profile_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_btnMouseEntered
        profile_btn.setBackground(new Color(122, 122, 255));
    }//GEN-LAST:event_profile_btnMouseEntered

    private void profile_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_btnMouseExited
        profile_btn.setBackground(new Color(102, 102, 255));
    }//GEN-LAST:event_profile_btnMouseExited

    private void profile_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_btnMousePressed
        profile_btn.setBackground(new Color(66, 66, 255));
    }//GEN-LAST:event_profile_btnMousePressed

    private void profile_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_btnMouseReleased
        profile_btn.setBackground(new Color(122, 122, 255));
    }//GEN-LAST:event_profile_btnMouseReleased

    private void profile_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_btnMouseClicked
        body_panel.setSelectedIndex(0);
    }//GEN-LAST:event_profile_btnMouseClicked

    private void home_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_btnMouseEntered
        home_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_home_btnMouseEntered

    private void home_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_btnMouseExited
        home_btn.setBackground(new Color(50, 158, 100));
    }//GEN-LAST:event_home_btnMouseExited

    private void home_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_btnMousePressed
        home_btn.setBackground(new Color(40, 127, 80));
    }//GEN-LAST:event_home_btnMousePressed

    private void home_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_btnMouseReleased
        home_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_home_btnMouseReleased

    private void home_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_btnMouseClicked
        body_panel.setSelectedIndex(1);
    }//GEN-LAST:event_home_btnMouseClicked

    private void dashboard_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard_btnMouseEntered
        dashboard_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_dashboard_btnMouseEntered

    private void dashboard_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard_btnMouseExited
        dashboard_btn.setBackground(new Color(50, 158, 100));
    }//GEN-LAST:event_dashboard_btnMouseExited

    private void dashboard_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard_btnMousePressed
        dashboard_btn.setBackground(new Color(66, 66, 255));
    }//GEN-LAST:event_dashboard_btnMousePressed

    private void dashboard_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard_btnMouseReleased
        dashboard_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_dashboard_btnMouseReleased

    private void dashboard_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard_btnMouseClicked
        body_panel.setSelectedIndex(2);
    }//GEN-LAST:event_dashboard_btnMouseClicked

    private void exercise_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exercise_btnMouseEntered
        exercise_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_exercise_btnMouseEntered

    private void exercise_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exercise_btnMouseExited
        exercise_btn.setBackground(new Color(50, 158, 100));
    }//GEN-LAST:event_exercise_btnMouseExited

    private void exercise_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exercise_btnMousePressed
        exercise_btn.setBackground(new Color(66, 66, 255));
    }//GEN-LAST:event_exercise_btnMousePressed

    private void exercise_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exercise_btnMouseReleased
        exercise_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_exercise_btnMouseReleased

    private void exercise_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exercise_btnMouseClicked
        body_panel.setSelectedIndex(3);
    }//GEN-LAST:event_exercise_btnMouseClicked

    private void diet_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diet_btnMouseEntered
        diet_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_diet_btnMouseEntered

    private void diet_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diet_btnMouseExited
        diet_btn.setBackground(new Color(50, 158, 100));
    }//GEN-LAST:event_diet_btnMouseExited

    private void diet_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diet_btnMousePressed
        diet_btn.setBackground(new Color(66, 66, 255));
    }//GEN-LAST:event_diet_btnMousePressed

    private void diet_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diet_btnMouseReleased
        diet_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_diet_btnMouseReleased

    private void diet_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diet_btnMouseClicked
        body_panel.setSelectedIndex(4);
    }//GEN-LAST:event_diet_btnMouseClicked

    private void guide_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guide_btnMouseEntered
        guide_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_guide_btnMouseEntered

    private void guide_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guide_btnMouseExited
        guide_btn.setBackground(new Color(50, 158, 100));
    }//GEN-LAST:event_guide_btnMouseExited

    private void guide_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guide_btnMousePressed
        guide_btn.setBackground(new Color(66, 66, 255));
    }//GEN-LAST:event_guide_btnMousePressed

    private void guide_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guide_btnMouseReleased
        guide_btn.setBackground(new Color(57, 182, 115));
    }//GEN-LAST:event_guide_btnMouseReleased

    private void guide_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guide_btnMouseClicked
        body_panel.setSelectedIndex(5);
    }//GEN-LAST:event_guide_btnMouseClicked

    private void exit_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btn1ActionPerformed
        int confirmExit = JOptionPane.showConfirmDialog(null,
            "Are you sure you want to quit?",
            "Quit",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);

        if (confirmExit == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_exit_btn1ActionPerformed

    private void exit_btn1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btn1MouseReleased
        exit_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btn1MouseReleased

    private void exit_btn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btn1MousePressed
        exit_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-click.png")));
    }//GEN-LAST:event_exit_btn1MousePressed

    private void exit_btn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btn1MouseExited
        exit_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-idle.png")));
    }//GEN-LAST:event_exit_btn1MouseExited

    private void exit_btn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btn1MouseEntered
        exit_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btn1MouseEntered

    private void profile_edit_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_edit_btnMouseEntered
        profile_edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-edit-hover-icon.png")));
    }//GEN-LAST:event_profile_edit_btnMouseEntered

    private void profile_edit_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_edit_btnMouseExited
        profile_edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-edit-idle-icon.png")));
    }//GEN-LAST:event_profile_edit_btnMouseExited

    private void profile_edit_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_edit_btnMousePressed
        profile_edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-edit-idle-icon.png")));
    }//GEN-LAST:event_profile_edit_btnMousePressed

    private void profile_edit_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_edit_btnMouseReleased
        profile_edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-edit-hover-icon.png")));
    }//GEN-LAST:event_profile_edit_btnMouseReleased

    private void profile_edit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_edit_btnActionPerformed
        profile_tabs.setSelectedIndex(1);
    }//GEN-LAST:event_profile_edit_btnActionPerformed

    private void profile_delete_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_delete_btnMouseEntered
        profile_delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-delete-hover-icon.png")));
    }//GEN-LAST:event_profile_delete_btnMouseEntered

    private void profile_delete_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_delete_btnMouseExited
        profile_delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-delete-idle-icon.png")));
    }//GEN-LAST:event_profile_delete_btnMouseExited

    private void profile_delete_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_delete_btnMousePressed
        profile_delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-delete-idle-icon.png")));
    }//GEN-LAST:event_profile_delete_btnMousePressed

    private void profile_delete_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_delete_btnMouseReleased
        profile_delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-delete-hover-icon.png")));
    }//GEN-LAST:event_profile_delete_btnMouseReleased

    private void profile_delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_delete_btnActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null,
            "Are you sure you want to delete your account?",
            "Account Deletion",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            
        }
    }//GEN-LAST:event_profile_delete_btnActionPerformed

    private void profile_security_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_security_btnMouseEntered
        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-security-idle-icon.png")));
    }//GEN-LAST:event_profile_security_btnMouseEntered

    private void profile_security_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_security_btnMouseExited
        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-security-idle-icon.png")));
    }//GEN-LAST:event_profile_security_btnMouseExited

    private void profile_security_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_security_btnMousePressed
        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-security-idle-icon.png")));
    }//GEN-LAST:event_profile_security_btnMousePressed

    private void profile_security_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_security_btnMouseReleased
        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-security-idle-icon.png")));
    }//GEN-LAST:event_profile_security_btnMouseReleased

    private void profile_security_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_security_btnActionPerformed
        profile_tabs.setSelectedIndex(2);
    }//GEN-LAST:event_profile_security_btnActionPerformed

    private void profile_save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_save_btnActionPerformed
//        String firstname = first_name_field.getText().trim();
//        String lastname = last_name_field.getText().trim();
//        String email = email_field.getText().trim();
//        String username = username_field.getText().trim();
//        String password = String.valueOf(password_field.getPassword()).trim();
//        String sec_question = sec_question_field.getText().trim();
//        String sec_answer = sec_answer_field.getText().trim();
//
//        //CHECK IF FIRST AND LAST NAME HAS INVALID CHARACTERS
//        if (!firstname.matches("^[a-zA-Z]+([- ][a-zA-Z]+)*$")) {
//            JOptionPane.showMessageDialog(null, "First name must only contain letters, spaces, or hyphens.", "Input Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        if (!lastname.matches("^[a-zA-Z]+([- ][a-zA-Z]+)*$")) {
//            JOptionPane.showMessageDialog(null, "Last name must only contain letters, spaces, or hyphens.", "Input Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        //CHECK IF EMAIL IS VALID
//        if (!email.endsWith("@gmail.com")) {
//            JOptionPane.showMessageDialog(null, "Email is invalid.", "Input Error", JOptionPane.ERROR_MESSAGE);
//        }
//        //CHECK IF USERNAME CONTAINS SPACE
//        if (username.contains(" ")) {
//            JOptionPane.showMessageDialog(null, "Usernames cannot contain spaces.", "Input Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        //CHECK IF USERNAME IS 16 AND BELOW
//        if (username.length() > 16 || username.length() < 1) {
//            JOptionPane.showMessageDialog(null, "Usernames must be 1-16 characters long.", "Input Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        //CHECK IF USERNAME HAS INVALID CHARACTERS
//        if (!username.matches("^[a-zA-Z0-9._-]+$")) {
//            JOptionPane.showMessageDialog(null, "Only periods, underscores, and dashes are allowed.", "Input Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        //CHECK IF USERNAME HAS ADMIN CREDENTIALS
//        if (username.equals("admin1") || username.equals("admin2") || username.equals("admin3")
//            || username.equals("admin4") || username.equals("admin5")) {
//            JOptionPane.showMessageDialog(null, "This username is already taken", "Input Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        //CHECK IF PASSWORD IS STRONG
//        if (password.length() < 8) {
//            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.", "Input Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        //NO SQL INJECTION OR HTML TAGS
//        if (username.matches(".*<.*>.*") || firstname.matches(".*<.*>.*") || lastname.matches(".*<.*>.*")) {
//            JOptionPane.showMessageDialog(null, "Fields cannot contain HTML tags.", "Input Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        PreparedStatement ps;
//        ResultSet rs;
//
//        String checkNameQuery = "SELECT * FROM `tb_users` WHERE `first_name` = ? AND `last_name` = ?";
//        String checkEmailQuery = "SELECT * FROM `tb_users` WHERE `email` = ?";
//        String checkUsernameQuery = "SELECT * FROM `tb_users` WHERE `username` = ?";
//
//        try {
//            //CHECK FOR EXISTING FIRST AND LAST NAME
//            ps = DatabaseConnection.getConnection().prepareStatement(checkNameQuery);
//            ps.setString(1, firstname);
//            ps.setString(2, lastname);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                JOptionPane.showMessageDialog(this, "First and last name already exists.", "Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            //CHECK FOR EXISTING EMAIL
//            ps = DatabaseConnection.getConnection().prepareStatement(checkEmailQuery);
//            ps.setString(1, email);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                JOptionPane.showMessageDialog(this, "Email is already in use.", "Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            //CHECK FOR EXISTING USERNAME
//            ps = DatabaseConnection.getConnection().prepareStatement(checkUsernameQuery);
//            ps.setString(1, username);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                JOptionPane.showMessageDialog(this, "Username already exists.", "Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//
//            //INSERT NEW USER TO DATABASE
//            String insertQuery = "INSERT INTO `tb_users`"
//            + "(`first_name`, `last_name`, `email`, `username`, `password`, `sec_question`, `sec_answer`)"
//            + "VALUES (?,?,?,?,?,?,?)";
//            ps = DatabaseConnection.getConnection().prepareStatement(insertQuery);
//            ps.setString(1, firstname);
//            ps.setString(2, lastname);
//            ps.setString(3, email);
//            ps.setString(4, username);
//            ps.setString(5, password);
//            ps.setString(6, sec_question);
//            ps.setString(7, sec_answer);
//
//            if (ps.executeUpdate() > 0) {
//                JOptionPane.showMessageDialog(null, "New user added!");
//                first_name_field.setText("");
//                last_name_field.setText("");
//                email_field.setText("");
//                username_field.setText("");
//                password_field.setText("");
//                sec_question_field.setText("");
//                sec_answer_field.setText("");
//                password_check.setSelected(false);
//                password_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/eye-close.png")));
//                password_field.setEchoChar('*');
//                loadDataToTable();
//                updateTotalUsers();
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_profile_save_btnActionPerformed

    private void exit_btn2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btn2MouseEntered
        exit_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btn2MouseEntered

    private void exit_btn2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btn2MouseExited
        exit_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-idle.png")));
    }//GEN-LAST:event_exit_btn2MouseExited

    private void exit_btn2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btn2MousePressed
        exit_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-click.png")));
    }//GEN-LAST:event_exit_btn2MousePressed

    private void exit_btn2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btn2MouseReleased
        exit_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btn2MouseReleased

    private void exit_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btn2ActionPerformed
        profile_tabs.setSelectedIndex(0);
    }//GEN-LAST:event_exit_btn2ActionPerformed

    private void exit_btn3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btn3MouseEntered
        exit_btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btn3MouseEntered

    private void exit_btn3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btn3MouseExited
        exit_btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-idle.png")));
    }//GEN-LAST:event_exit_btn3MouseExited

    private void exit_btn3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btn3MousePressed
        exit_btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-click.png")));
    }//GEN-LAST:event_exit_btn3MousePressed

    private void exit_btn3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btn3MouseReleased
        exit_btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btn3MouseReleased

    private void exit_btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btn3ActionPerformed
        profile_tabs.setSelectedIndex(0);
    }//GEN-LAST:event_exit_btn3ActionPerformed

    private void security_save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_security_save_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_security_save_btnActionPerformed

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
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane body_panel;
    private javax.swing.JLabel dashboard;
    private Resources.components.PanelBorder dashboard_btn;
    private Resources.components.PanelBorder dashboard_panel;
    private javax.swing.JLabel diet;
    private Resources.components.PanelBorder diet_btn;
    private Resources.components.PanelBorder diet_panel;
    private Resources.components.PanelBorder edit_profile_form;
    private Resources.components.PanelBorder edit_profile_info;
    private Resources.components.PanelBorder edit_profile_security;
    private Resources.components.PanelBorder edit_security_form;
    private javax.swing.JLabel exercise;
    private Resources.components.PanelBorder exercise_btn;
    private Resources.components.PanelBorder exercise_panel;
    private javax.swing.JButton exit_btn1;
    private javax.swing.JButton exit_btn2;
    private javax.swing.JButton exit_btn3;
    private javax.swing.JLabel greetings;
    private javax.swing.JLabel guide;
    private Resources.components.PanelBorder guide_btn;
    private Resources.components.PanelBorder guide_panel;
    private Resources.components.PanelBorder header_panel;
    private javax.swing.JLabel home;
    private Resources.components.PanelBorder home_background;
    private Resources.components.PanelBorder home_btn;
    private Resources.components.PanelBorder home_panel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JButton logout_btn;
    private Resources.components.PanelMover mover;
    private javax.swing.JLabel profile;
    private javax.swing.JTextField profile_answer_field;
    private Resources.components.PanelBorder profile_btn;
    private Resources.components.PanelBorder profile_buttons;
    private javax.swing.JButton profile_delete_btn;
    private javax.swing.JButton profile_edit_btn;
    private javax.swing.JLabel profile_email;
    private javax.swing.JTextField profile_email_field;
    private javax.swing.JLabel profile_first_name;
    private javax.swing.JTextField profile_first_name_field;
    private Resources.components.PanelBorder profile_header;
    private javax.swing.JLabel profile_last_name;
    private javax.swing.JTextField profile_last_name_field;
    private Resources.components.PanelBorder profile_panel;
    private javax.swing.JLabel profile_password;
    private javax.swing.JTextField profile_password_field;
    private javax.swing.JTextField profile_question_field;
    private javax.swing.JButton profile_save_btn;
    private javax.swing.JLabel profile_sec_answer;
    private javax.swing.JLabel profile_sec_question;
    private javax.swing.JButton profile_security_btn;
    private javax.swing.JTabbedPane profile_tabs;
    private javax.swing.JLabel profile_username;
    private javax.swing.JTextField profile_username_field;
    private javax.swing.JButton security_save_btn;
    private Resources.components.PanelBorder view_profile;
    // End of variables declaration//GEN-END:variables
}
