package Home;

import Account.LoginForm;
import Resources.components.DatabaseConnection;
import Resources.components.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class UserHome extends javax.swing.JFrame {

    private int userId;

    public UserHome(int userId) {
        this.userId = userId;
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(UserHome.this);
        Image icon = new ImageIcon(this.getClass().getResource("/Resources/elements/fts-icon.png")).getImage();
        this.setIconImage(icon);
        body_panel.setSelectedIndex(1);

        loadUserData();
        setGreetings();
    }
    
    private void setGreetings() {
        greetings.setText("Hi, " + username_profile.getText() + "!");
    }

    private void loadUserData() {
        String query = "SELECT first_name, last_name, email, username, age, weight, height FROM tb_users WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, this.userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                first_name_profile.setText(rs.getString("first_name"));
                last_name_profile.setText(rs.getString("last_name"));
                email_profile.setText(rs.getString("email"));
                username_profile.setText(rs.getString("username"));

                int age = rs.getInt("age");
                float weight = rs.getFloat("weight");
                float height = rs.getFloat("height");

                if (age > 0) {
                    this.age_profile.setText(age + " year's old");
                }
                if (weight > 0) {
                    this.weight_profile.setText(weight + " kg");
                }
                if (height > 0) {
                    this.height_profile.setText(height + " cm");

                    float heightInMeters = height / 100;
                    float bmiValue = weight / (heightInMeters * heightInMeters);
                    this.bmi_profile.setText(String.format("%.2f", bmiValue));
                }
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading user data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        view_profile_background = new javax.swing.JPanel();
        first_name_label = new javax.swing.JLabel();
        first_name_profile = new javax.swing.JLabel();
        last_name_label = new javax.swing.JLabel();
        last_name_profile = new javax.swing.JLabel();
        email_label = new javax.swing.JLabel();
        email_profile = new javax.swing.JLabel();
        username_label = new javax.swing.JLabel();
        username_profile = new javax.swing.JLabel();
        age_label = new javax.swing.JLabel();
        age_profile = new javax.swing.JLabel();
        weight_label = new javax.swing.JLabel();
        weight_profile = new javax.swing.JLabel();
        height_label = new javax.swing.JLabel();
        height_profile = new javax.swing.JLabel();
        bmi_label = new javax.swing.JLabel();
        bmi_profile = new javax.swing.JLabel();
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
        password_check = new javax.swing.JToggleButton();
        exit_btn3 = new javax.swing.JButton();
        label2 = new javax.swing.JLabel();
        profile_password = new javax.swing.JLabel();
        profile_sec_question = new javax.swing.JLabel();
        profile_question_field = new javax.swing.JTextField();
        profile_sec_answer = new javax.swing.JLabel();
        profile_answer_field = new javax.swing.JTextField();
        security_save_btn = new javax.swing.JButton();
        profile_password_field = new javax.swing.JPasswordField();
        home_panel = new Resources.components.PanelBorder();
        age_field = new javax.swing.JTextField();
        weight_field = new javax.swing.JTextField();
        height_field = new javax.swing.JTextField();
        confirm_btn = new javax.swing.JButton();
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

        view_profile_background.setBackground(new java.awt.Color(255, 255, 255));
        view_profile_background.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));
        view_profile_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        first_name_label.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        first_name_label.setText("First Name:");
        view_profile_background.add(first_name_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        first_name_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        first_name_profile.setText("N/A");
        view_profile_background.add(first_name_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 150, 30));

        last_name_label.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        last_name_label.setText("Last Name:");
        view_profile_background.add(last_name_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, 30));

        last_name_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        last_name_profile.setText("N/A");
        view_profile_background.add(last_name_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 150, 30));

        email_label.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        email_label.setText("Email:");
        view_profile_background.add(email_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 30));

        email_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        email_profile.setText("N/A");
        view_profile_background.add(email_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 350, 30));

        username_label.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        username_label.setText("Username:");
        view_profile_background.add(username_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 30));

        username_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        username_profile.setText("N/A");
        view_profile_background.add(username_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 330, 30));

        age_label.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        age_label.setText("Age:");
        view_profile_background.add(age_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, 30));

        age_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        age_profile.setText("N/A");
        view_profile_background.add(age_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 340, 30));

        weight_label.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        weight_label.setText("Weight:");
        view_profile_background.add(weight_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 30));

        weight_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        weight_profile.setText("N/A");
        view_profile_background.add(weight_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 350, 30));

        height_label.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        height_label.setText("Height:");
        view_profile_background.add(height_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 30));

        height_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        height_profile.setText("N/A");
        view_profile_background.add(height_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 350, 30));

        bmi_label.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        bmi_label.setText("BMI:");
        view_profile_background.add(bmi_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 30));

        bmi_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        bmi_profile.setText("N/A");
        view_profile_background.add(bmi_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 390, 30));

        view_profile.add(view_profile_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 430));

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

        password_check.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        password_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/eye-close.png"))); // NOI18N
        password_check.setAlignmentY(0.0F);
        password_check.setBorder(null);
        password_check.setBorderPainted(false);
        password_check.setContentAreaFilled(false);
        password_check.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        password_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_checkActionPerformed(evt);
            }
        });
        edit_security_form.add(password_check, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 95, 20, 20));

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

        security_save_btn.setBackground(new java.awt.Color(39, 154, 91));
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

        profile_password_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        edit_security_form.add(profile_password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 350, -1));

        edit_profile_security.add(edit_security_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 400, 290));

        profile_tabs.addTab("tab3", edit_profile_security);

        profile_panel.add(profile_tabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 960, 460));

        body_panel.addTab("tab1", profile_panel);

        home_panel.setBackground(new java.awt.Color(153, 153, 153));
        home_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        home_panel.add(age_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 130, -1));
        home_panel.add(weight_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 130, -1));
        home_panel.add(height_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 130, -1));

        confirm_btn.setText("Confirm Button");
        confirm_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm_btnActionPerformed(evt);
            }
        });
        home_panel.add(confirm_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 130, -1));

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
            try (Connection conn = DatabaseConnection.getConnection()) {
                String query = "DELETE FROM tb_users WHERE user_id = ?";

                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setInt(1, this.userId);

                    int rowsDeleted = stmt.executeUpdate();

                    if (rowsDeleted > 0) {
                        JOptionPane.showMessageDialog(this, "Account deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        new LoginForm().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Error deleting account. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error deleting account: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error connecting to the database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_profile_delete_btnActionPerformed

    private void profile_security_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_security_btnMouseEntered
        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-security-hover-icon.png")));
    }//GEN-LAST:event_profile_security_btnMouseEntered

    private void profile_security_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_security_btnMouseExited
        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-security-idle-icon.png")));
    }//GEN-LAST:event_profile_security_btnMouseExited

    private void profile_security_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_security_btnMousePressed
        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-security-idle-icon.png")));
    }//GEN-LAST:event_profile_security_btnMousePressed

    private void profile_security_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_security_btnMouseReleased
        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-security-hover-icon.png")));
    }//GEN-LAST:event_profile_security_btnMouseReleased

    private void profile_security_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_security_btnActionPerformed
        String enteredPassword = JOptionPane.showInputDialog(this, "Please enter your password to access security settings:");

        if (enteredPassword != null && !enteredPassword.trim().isEmpty()) {
            try (Connection conn = DatabaseConnection.getConnection()) {
                String query = "SELECT password FROM tb_users WHERE user_id = ?";

                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setInt(1, this.userId);

                    try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                            String storedPassword = rs.getString("password");

                            if (enteredPassword.equals(storedPassword)) {
                                profile_tabs.setSelectedIndex(2);
                            } else {
                                JOptionPane.showMessageDialog(this, "Incorrect password. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "User not found. Please log in again.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error checking password: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error connecting to the database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Password cannot be empty. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_profile_security_btnActionPerformed

    private void profile_save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_save_btnActionPerformed
        String firstName = profile_first_name_field.getText().trim();
        String lastName = profile_last_name_field.getText().trim();
        String email = profile_email_field.getText().trim();
        String username = profile_username_field.getText().trim();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "UPDATE tb_users SET first_name = ?, last_name = ?, email = ?, username = ? WHERE user_id = ?";

            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, firstName);
                stmt.setString(2, lastName);
                stmt.setString(3, email);
                stmt.setString(4, username);
                stmt.setInt(5, this.userId);

                int rowsUpdated = stmt.executeUpdate();

                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Profile updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    first_name_profile.setText("" + firstName);
                    last_name_profile.setText("" + lastName);
                    email_profile.setText("" + email);
                    username_profile.setText("" + username);
                    profile_first_name_field.setText("");
                    profile_last_name_field.setText("");
                    profile_email_field.setText("");
                    profile_username_field.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "No changes made or user not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error updating profile: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error connecting to the database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        String newPassword = new String(profile_password_field.getPassword());
        String securityQuestion = profile_question_field.getText();
        String securityAnswer = profile_answer_field.getText();

        if (newPassword.isEmpty() || securityQuestion.isEmpty() || securityAnswer.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String currentPassword = JOptionPane.showInputDialog(this, "Please enter your current password:");

        if (currentPassword != null && !currentPassword.trim().isEmpty()) {
            try (Connection conn = DatabaseConnection.getConnection()) {
                String query = "SELECT password, sec_question, sec_answer FROM tb_users WHERE user_id = ?";

                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setInt(1, this.userId);

                    try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                            String storedPassword = rs.getString("password");
                            String storedQuestion = rs.getString("sec_question");
                            String storedAnswer = rs.getString("sec_answer");

                            if (currentPassword.equals(storedPassword)) {
                                String updateQuery = "UPDATE tb_users SET password = ?, sec_question = ?, sec_answer = ? WHERE user_id = ?";

                                try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                                    updateStmt.setString(1, newPassword);
                                    updateStmt.setString(2, securityQuestion);
                                    updateStmt.setString(3, securityAnswer);
                                    updateStmt.setInt(4, this.userId);

                                    int rowsAffected = updateStmt.executeUpdate();

                                    if (rowsAffected > 0) {
                                        JOptionPane.showMessageDialog(this, "Your password and security settings have been updated successfully.");
                                        // Optionally, reset fields
                                        profile_password_field.setText("");
                                        profile_question_field.setText("");
                                        profile_answer_field.setText("");
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Error updating your password. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Incorrect current password. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "User not found. Please log in again.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error checking current password: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error connecting to the database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Current password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_security_save_btnActionPerformed

    private void confirm_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm_btnActionPerformed
        String ageText = age_field.getText();
        String weightText = weight_field.getText();
        String heightText = height_field.getText();

        if (ageText.isEmpty() || weightText.isEmpty() || heightText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int age = Integer.parseInt(ageText);
            float weight = Float.parseFloat(weightText);
            float height = Float.parseFloat(heightText);

            if (age <= 0 || weight <= 0 || height <= 0) {
                JOptionPane.showMessageDialog(this, "Age, weight, and height must be positive values.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int heightInMeters = (int) height / 100;
            int bmiValue = (int) weight / (heightInMeters * heightInMeters);

            Connection conn = DatabaseConnection.getConnection();
            String updateQuery = "UPDATE tb_users SET age = ?, weight = ?, height = ? WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.setInt(1, age);
            stmt.setFloat(2, weight);
            stmt.setFloat(3, height);
            stmt.setInt(4, userId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Profile updated successfully!");
                age_profile.setText(age + " year's old");
                weight_profile.setText(weight + " kg");
                height_profile.setText(height + " cm");
                this.bmi_profile.setText(String.format(bmiValue + " kg/m²"));
            } else {
                JOptionPane.showMessageDialog(this, "Profile update failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            stmt.close();
            conn.close();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for age, weight, and height.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_confirm_btnActionPerformed

    private void password_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_checkActionPerformed
        if (password_check.isSelected()) {
            password_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/eye-open.png")));
            profile_password_field.setEchoChar((char) 0);
        } else {
            password_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/eye-close.png")));
            profile_password_field.setEchoChar('*');
        }
    }//GEN-LAST:event_password_checkActionPerformed

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

        UIDefaults ui = UIManager.getDefaults();
        ui.put("ScrollBarUI", ScrollBarWin11UI.class.getCanonicalName());
        int userId = 1;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserHome(userId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField age_field;
    private javax.swing.JLabel age_label;
    private javax.swing.JLabel age_profile;
    private javax.swing.JLabel bmi_label;
    private javax.swing.JLabel bmi_profile;
    private javax.swing.JTabbedPane body_panel;
    private javax.swing.JButton confirm_btn;
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
    private javax.swing.JLabel email_label;
    private javax.swing.JLabel email_profile;
    private javax.swing.JLabel exercise;
    private Resources.components.PanelBorder exercise_btn;
    private Resources.components.PanelBorder exercise_panel;
    private javax.swing.JButton exit_btn1;
    private javax.swing.JButton exit_btn2;
    private javax.swing.JButton exit_btn3;
    private javax.swing.JLabel first_name_label;
    private javax.swing.JLabel first_name_profile;
    private javax.swing.JLabel greetings;
    private javax.swing.JLabel guide;
    private Resources.components.PanelBorder guide_btn;
    private Resources.components.PanelBorder guide_panel;
    private Resources.components.PanelBorder header_panel;
    private javax.swing.JTextField height_field;
    private javax.swing.JLabel height_label;
    private javax.swing.JLabel height_profile;
    private javax.swing.JLabel home;
    private Resources.components.PanelBorder home_background;
    private Resources.components.PanelBorder home_btn;
    private Resources.components.PanelBorder home_panel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel last_name_label;
    private javax.swing.JLabel last_name_profile;
    private javax.swing.JButton logout_btn;
    private Resources.components.PanelMover mover;
    private javax.swing.JToggleButton password_check;
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
    private javax.swing.JPasswordField profile_password_field;
    private javax.swing.JTextField profile_question_field;
    private javax.swing.JButton profile_save_btn;
    private javax.swing.JLabel profile_sec_answer;
    private javax.swing.JLabel profile_sec_question;
    private javax.swing.JButton profile_security_btn;
    private javax.swing.JTabbedPane profile_tabs;
    private javax.swing.JLabel profile_username;
    private javax.swing.JTextField profile_username_field;
    private javax.swing.JButton security_save_btn;
    private javax.swing.JLabel username_label;
    private javax.swing.JLabel username_profile;
    private Resources.components.PanelBorder view_profile;
    private javax.swing.JPanel view_profile_background;
    private javax.swing.JTextField weight_field;
    private javax.swing.JLabel weight_label;
    private javax.swing.JLabel weight_profile;
    // End of variables declaration//GEN-END:variables
}
