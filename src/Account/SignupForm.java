package Account;

import Resources.components.DatabaseConnection;
import java.awt.*;
import java.sql.*;
import java.util.Arrays;
import java.util.logging.*;
import javax.swing.*;

public class SignupForm extends javax.swing.JFrame {

    public SignupForm() {
        initComponents();
        next_btn.setEnabled(false);
        signup_btn.setEnabled(false);
        setupNextButtonListener();
        setupSignupButtonListener();
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(SignupForm.this);
        Image icon = new ImageIcon(this.getClass().getResource("/Resources/elements/fts-icon.png")).getImage();
        this.setIconImage(icon);
        ButtonGroup sexRdb = new ButtonGroup();
        sexRdb.add(male_rdb);
        sexRdb.add(female_rdb);
    }

    private void setupNextButtonListener() {
        javax.swing.event.DocumentListener documentListener = new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                toggleNextButton();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                toggleNextButton();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                toggleNextButton();
            }
        };
        first_name_field.getDocument().addDocumentListener(documentListener);
        last_name_field.getDocument().addDocumentListener(documentListener);
        email_field.getDocument().addDocumentListener(documentListener);
        username_field.getDocument().addDocumentListener(documentListener);
        password_field.getDocument().addDocumentListener(documentListener);
        sec_question_field.getDocument().addDocumentListener(documentListener);
        sec_answer_field.getDocument().addDocumentListener(documentListener);
    }

    private void toggleNextButton() {
        String firstname = first_name_field.getText().trim();
        String lastname = last_name_field.getText().trim();
        String email = email_field.getText().trim();
        String username = username_field.getText().trim();
        String password = String.valueOf(password_field.getPassword()).trim();
        String secQuestion = sec_question_field.getText().trim();
        String secAnswer = sec_answer_field.getText().trim();
        next_btn.setEnabled(
                !firstname.isEmpty() && !lastname.isEmpty()
                && !email.isEmpty() && !username.isEmpty()
                && !password.isEmpty() && !secQuestion.isEmpty()
                && !secAnswer.isEmpty());
    }

    private void setupSignupButtonListener() {
        age_field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toggleSignupButton();
            }
        });
        weight_field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toggleSignupButton();
            }
        });
        height_field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toggleSignupButton();
            }
        });
        male_rdb.addActionListener(e -> toggleSignupButton());
        female_rdb.addActionListener(e -> toggleSignupButton());
    }

    private void toggleSignupButton() {
        boolean isValid = !age_field.getText().isEmpty()
                && !weight_field.getText().isEmpty()
                && !height_field.getText().isEmpty()
                && (male_rdb.isSelected() || female_rdb.isSelected());
        signup_btn.setEnabled(isValid);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        element = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        exit_btn = new javax.swing.JButton();
        mover = new Resources.components.PanelMover();
        header = new Resources.components.PanelBorder();
        create_account = new javax.swing.JLabel();
        create_panel = new javax.swing.JTabbedPane();
        step1_panel = new Resources.components.PanelBorder();
        password_check = new javax.swing.JToggleButton();
        first_name_label = new javax.swing.JLabel();
        first_name_field = new javax.swing.JTextField();
        last_name_label = new javax.swing.JLabel();
        last_name_field = new javax.swing.JTextField();
        email_label = new javax.swing.JLabel();
        email_field = new javax.swing.JTextField();
        username_label = new javax.swing.JLabel();
        username_field = new javax.swing.JTextField();
        password_label = new javax.swing.JLabel();
        password_field = new javax.swing.JPasswordField();
        validation_label = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        question_label = new javax.swing.JLabel();
        question_guide = new javax.swing.JLabel();
        sec_question_field = new javax.swing.JTextField();
        answer_label = new javax.swing.JLabel();
        answer_guide = new javax.swing.JLabel();
        sec_answer_field = new javax.swing.JTextField();
        next_btn = new javax.swing.JButton();
        step2_panel = new Resources.components.PanelBorder();
        panelBorder1 = new Resources.components.PanelBorder();
        age_label = new javax.swing.JLabel();
        age_field = new javax.swing.JTextField();
        sex_label = new javax.swing.JLabel();
        male_rdb = new javax.swing.JRadioButton();
        female_rdb = new javax.swing.JRadioButton();
        weight_label = new javax.swing.JLabel();
        weight_field = new javax.swing.JTextField();
        height_label = new javax.swing.JLabel();
        height_field = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        or = new javax.swing.JLabel();
        signup_btn = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        footer = new Resources.components.PanelBorder();
        signup_message = new javax.swing.JLabel();
        signin_btn = new javax.swing.JButton();
        background = new Resources.components.PanelBorder();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        element.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/signup-element.png"))); // NOI18N
        getContentPane().add(element, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Unlock Your Potential!");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 35, -1, -1));

        jLabel2.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Track Your Progress!");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 75, -1, -1));

        jLabel3.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Achieve Your Goals!");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 445, -1, -1));

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
        getContentPane().add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 5, 30, 30));
        getContentPane().add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 10));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        create_account.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        create_account.setText("Create Account");
        header.add(create_account, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 50));

        step1_panel.setBackground(new java.awt.Color(255, 255, 255));
        step1_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        step1_panel.add(password_check, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 205, 20, 20));

        first_name_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        first_name_label.setText("First Name");
        step1_panel.add(first_name_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 35, -1, -1));

        first_name_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        step1_panel.add(first_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 160, -1));

        last_name_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        last_name_label.setText("Last Name");
        step1_panel.add(last_name_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 35, -1, -1));

        last_name_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        step1_panel.add(last_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 160, -1));

        email_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        email_label.setText("Email");
        step1_panel.add(email_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 85, -1, -1));

        email_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        step1_panel.add(email_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 330, -1));

        username_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        username_label.setText("Username");
        step1_panel.add(username_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 135, -1, -1));

        username_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        step1_panel.add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 330, -1));

        password_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        password_label.setText("Password");
        step1_panel.add(password_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 185, -1, -1));

        password_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        step1_panel.add(password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 330, -1));

        validation_label.setFont(new java.awt.Font("Cascadia Mono", 0, 9)); // NOI18N
        validation_label.setForeground(new java.awt.Color(153, 153, 153));
        validation_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        validation_label.setText("Validation for Password Reset");
        step1_panel.add(validation_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 249, 150, -1));
        step1_panel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 253, 90, 10));
        step1_panel.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 253, 80, 10));

        question_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        question_label.setText("Your Question");
        step1_panel.add(question_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 275, -1, -1));

        question_guide.setFont(new java.awt.Font("Cascadia Mono", 0, 9)); // NOI18N
        question_guide.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        question_guide.setText("(write your own question for password reset)");
        step1_panel.add(question_guide, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, 10));

        sec_question_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        step1_panel.add(sec_question_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 330, -1));

        answer_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        answer_label.setText("Your Answer");
        step1_panel.add(answer_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 325, -1, -1));

        answer_guide.setFont(new java.awt.Font("Cascadia Mono", 0, 9)); // NOI18N
        answer_guide.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        answer_guide.setText("(make sure to remember your answer)");
        step1_panel.add(answer_guide, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 330, -1, 10));

        sec_answer_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        step1_panel.add(sec_answer_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 330, -1));

        next_btn.setBackground(new java.awt.Color(102, 102, 255));
        next_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        next_btn.setForeground(new java.awt.Color(255, 255, 255));
        next_btn.setText("NEXT");
        next_btn.setAlignmentY(0.0F);
        next_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_btnActionPerformed(evt);
            }
        });
        step1_panel.add(next_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 330, -1));

        create_panel.addTab("tab1", step1_panel);

        step2_panel.setBackground(new java.awt.Color(255, 255, 255));
        step2_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(204, 204, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        age_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        age_label.setText("Age");
        panelBorder1.add(age_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        age_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(age_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, -1));

        sex_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        sex_label.setText("Sex");
        panelBorder1.add(sex_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        male_rdb.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        male_rdb.setText("Male");
        panelBorder1.add(male_rdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        female_rdb.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        female_rdb.setText("Female");
        panelBorder1.add(female_rdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        weight_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        weight_label.setText("Weight (kg)");
        panelBorder1.add(weight_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        weight_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(weight_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 120, -1));

        height_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        height_label.setText("Height (cm)");
        panelBorder1.add(height_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        height_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(height_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 120, -1));

        step2_panel.add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 290, 140));

        jLabel4.setFont(new java.awt.Font("Cascadia Mono", 0, 9)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("For Health Tracking");
        step2_panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 35, 150, -1));

        jLabel5.setFont(new java.awt.Font("Cascadia Mono", 0, 9)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("- Having your age, sex, weight, and height is important in order");
        step2_panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 330, 20));

        jLabel7.setFont(new java.awt.Font("Cascadia Mono", 0, 9)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("an accurate and effective guidance for your health.");
        step2_panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 320, 20));

        jLabel6.setFont(new java.awt.Font("Cascadia Mono", 0, 9)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("to track, and manage your health and fitness goals to achieve");
        step2_panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 320, 10));
        step2_panel.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 90, 10));
        step2_panel.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 100, 10));
        step2_panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 140, 10));

        or.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        or.setForeground(new java.awt.Color(153, 153, 153));
        or.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        or.setText("Or");
        step2_panel.add(or, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 385, 20, -1));

        signup_btn.setBackground(new java.awt.Color(102, 102, 255));
        signup_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        signup_btn.setForeground(new java.awt.Color(255, 255, 255));
        signup_btn.setText("SIGN UP");
        signup_btn.setAlignmentY(0.0F);
        signup_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_btnActionPerformed(evt);
            }
        });
        step2_panel.add(signup_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 190, -1));

        back_btn.setBackground(new java.awt.Color(102, 102, 102));
        back_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        back_btn.setForeground(new java.awt.Color(255, 255, 255));
        back_btn.setText("GO BACK");
        back_btn.setAlignmentY(0.0F);
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        step2_panel.add(back_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 90, -1));
        step2_panel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 150, 10));

        create_panel.addTab("tab2", step2_panel);

        getContentPane().add(create_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 450));

        footer.setBackground(new java.awt.Color(255, 255, 255));
        footer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signup_message.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        signup_message.setText("Already have an account?");
        footer.add(signup_message, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        signin_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        signin_btn.setForeground(new java.awt.Color(10, 177, 52));
        signin_btn.setText("Sign in");
        signin_btn.setBorder(null);
        signin_btn.setBorderPainted(false);
        signin_btn.setContentAreaFilled(false);
        signin_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signin_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signin_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                signin_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                signin_btnMouseReleased(evt);
            }
        });
        signin_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signin_btnActionPerformed(evt);
            }
        });
        footer.add(signin_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 410, 40));

        background.setBackground(new java.awt.Color(153, 153, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 260, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        int confirmExit = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to quit?",
                "Quit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmExit == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_exit_btnActionPerformed

    private void exit_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseReleased
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btnMouseReleased

    private void exit_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMousePressed
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-click.png")));
    }//GEN-LAST:event_exit_btnMousePressed

    private void exit_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseExited
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-idle.png")));
    }//GEN-LAST:event_exit_btnMouseExited

    private void exit_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseEntered
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btnMouseEntered

    private void next_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_btnActionPerformed
        create_panel.setSelectedIndex(1);
    }//GEN-LAST:event_next_btnActionPerformed

    private void password_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_checkActionPerformed
        if (password_check.isSelected()) {
            password_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/eye-open.png")));
            password_field.setEchoChar((char) 0);
        } else {
            password_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/eye-close.png")));
            password_field.setEchoChar('*');
        }
    }//GEN-LAST:event_password_checkActionPerformed

    private void signup_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_btnActionPerformed
        String firstname = first_name_field.getText().trim();
        String lastname = last_name_field.getText().trim();
        String email = email_field.getText().trim();
        String username = username_field.getText().trim();
        String age = age_field.getText().trim();
        String sex = male_rdb.isSelected() ? "Male" : (female_rdb.isSelected() ? "Female" : null);
        String weight = weight_field.getText().trim();
        String height = height_field.getText().trim();
        String password = String.valueOf(password_field.getPassword()).trim();
        String sec_question = sec_question_field.getText().trim();
        String sec_answer = sec_answer_field.getText().trim();

        //CHECK IF REQUIRED FIELDS ARE FILLED
        if (firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || username.isEmpty()
                || age.isEmpty() || weight.isEmpty() || height.isEmpty() || password.isEmpty()
                || sec_question.isEmpty() || sec_answer.isEmpty() || sex == null) {
            JOptionPane.showMessageDialog(null, "All fields must be filled.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF FIRST AND LAST NAME HAS INVALID CHARACTERS
        if (!firstname.matches("^[a-zA-Z]+([- ][a-zA-Z]+)*$")) {
            JOptionPane.showMessageDialog(null, "First name must only contain letters, spaces, or hyphens.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!lastname.matches("^[a-zA-Z]+([- ][a-zA-Z]+)*$")) {
            JOptionPane.showMessageDialog(null, "Last name must only contain letters, spaces, or hyphens.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF EMAIL IS VALID
        if (!email.endsWith("@gmail.com")) {
            JOptionPane.showMessageDialog(null, "Email is invalid.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(null, "Invalid email address.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF USERNAME CONTAINS SPACE
        if (username.contains(" ")) {
            JOptionPane.showMessageDialog(null, "Usernames cannot contain spaces.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF USERNAME IS 16 AND BELOW
        if (username.length() > 16 || username.length() < 1) {
            JOptionPane.showMessageDialog(null, "Usernames must be 1-16 characters long.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF USERNAME HAS INVALID CHARACTERS
        if (!username.matches("^[a-zA-Z0-9._-]+$")) {
            JOptionPane.showMessageDialog(null, "Only periods, underscores, and dashes are allowed.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF USERNAME HAS ADMIN CREDENTIALS
        String[] reservedUsernames = {"admin1", "admin2", "admin3", "admin4", "admin5"};
        if (Arrays.asList(reservedUsernames).contains(username)) {
            JOptionPane.showMessageDialog(null, "This username is already taken", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF AGE IS A POSITIVE INTEGER
        if (!age.matches("^\\d+$") || Integer.parseInt(age) < 2 || Integer.parseInt(age) > 120) {
            JOptionPane.showMessageDialog(null, "Please provide an age between 2 and 120.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF WEIGHT AND HEIGHT ARE POSITIVE NUMBERS
        if (!weight.matches("^\\d+(\\.\\d+)?$") || Double.parseDouble(weight) <= 0) {
            JOptionPane.showMessageDialog(null, "Weight must be a positive number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!height.matches("^\\d+(\\.\\d+)?$") || Double.parseDouble(height) <= 0) {
            JOptionPane.showMessageDialog(null, "Height must be a positive number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF PASSWORD IS STRONG
        if (password.length() < 8) {
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK SECURITY QUESTION AND ANSWER LENGTH
        if (sec_question.length() < 5 || sec_answer.length() < 3) {
            JOptionPane.showMessageDialog(null, "Security question must be at least 5 characters long and answer must be at least 3 characters long.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //NO SQL INJECTION OR HTML TAGS
        if (username.matches(".*<.*>.*") || firstname.matches(".*<.*>.*") || lastname.matches(".*<.*>.*")) {
            JOptionPane.showMessageDialog(null, "Fields cannot contain HTML tags.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //CHECK IF AGE, WEIGHT, AND HEIGHT ARE POSITIVE NUMBERS
        int ageValue;
        float weightValue, heightValue;
        try {
            ageValue = Integer.parseInt(age);
            if (ageValue < 2 || ageValue > 120) {
                JOptionPane.showMessageDialog(null, "Please provide an age between 2 and 120.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Age must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            weightValue = Float.parseFloat(weight);
            heightValue = Float.parseFloat(height);
            if (weightValue <= 0 || heightValue <= 0) {
                JOptionPane.showMessageDialog(null, "Weight and height must be positive numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Weight and height must be valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String bmi;
        String classification = "";
        float heightInMeters = heightValue / 100;
        float bmiValue = weightValue / (heightInMeters * heightInMeters);
        bmi = String.format("%.1f", bmiValue) + " kg/m²";

        if (ageValue >= 20) {
            if (bmiValue < 18.5) {
                classification = "Underweight";
            } else if (bmiValue >= 18.5 && bmiValue <= 25) {
                classification = "Normal Weight";
            } else if (bmiValue >= 26 && bmiValue <= 30) {
                classification = "Overweight";
            } else if (bmiValue >= 31) {
                classification = "Obese";
            } else if (ageValue >= 2 && ageValue < 20) {
                if (bmiValue < 5) {
                    classification = "Underweight";
                } else if (bmiValue >= 5 && bmiValue < 85) {
                    classification = "Healthy Weight";
                } else if (bmiValue >= 85 && bmiValue < 95) {
                    classification = "Risk of Overweight";
                } else if (bmiValue >= 95) {
                    classification = "Overweight";
                }
            } else {
                classification = "Invalid age for BMI calculation";
            }
        }

        PreparedStatement ps;
        ResultSet rs;

        String checkNameQuery = "SELECT * FROM `tb_users` WHERE `first_name` = ? AND `last_name` = ?";
        String checkEmailQuery = "SELECT * FROM `tb_users` WHERE `email` = ?";
        String checkUsernameQuery = "SELECT * FROM `tb_users` WHERE `username` = ?";

        try {
            //CHECK FOR EXISTING FIRST AND LAST NAME
            ps = DatabaseConnection.getConnection().prepareStatement(checkNameQuery);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "First and last name already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //CHECK FOR EXISTING EMAIL
            ps = DatabaseConnection.getConnection().prepareStatement(checkEmailQuery);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Email is already in use.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //CHECK FOR EXISTING USERNAME
            ps = DatabaseConnection.getConnection().prepareStatement(checkUsernameQuery);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Username already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //INSERT NEW USER TO DATABASE
            String insertQuery = "INSERT INTO `tb_users`"
                    + "(`first_name`, `last_name`, `email`, `username`, `age`, `sex`, `weight`, `height`, `password`, `sec_question`, `sec_answer`, `bmi`, `classification`)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = DatabaseConnection.getConnection().prepareStatement(insertQuery);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, email);
            ps.setString(4, username);
            ps.setString(5, age);
            ps.setString(6, sex);
            ps.setString(7, weight);
            ps.setString(8, height);
            ps.setString(9, password);
            ps.setString(10, sec_question);
            ps.setString(11, sec_answer);
            ps.setString(12, bmi);
            ps.setString(13, classification);

            if (ps.executeUpdate() > 0) {
                first_name_field.setText("");
                last_name_field.setText("");
                email_field.setText("");
                username_field.setText("");
                age_field.setText("");
                if (male_rdb.isSelected()) {
                    male_rdb.setSelected(false);
                } else if (female_rdb.isSelected()) {
                    female_rdb.setSelected(false);
                }
                weight_field.setText("");
                height_field.setText("");
                password_field.setText("");
                sec_question_field.setText("");
                sec_answer_field.setText("");
                password_check.setSelected(false);
                password_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/eye-close.png")));
                password_field.setEchoChar('*');
                JOptionPane.showMessageDialog(this, "Account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                new LoginForm().setVisible(true);
                dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SignupForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_signup_btnActionPerformed

    private void signin_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signin_btnActionPerformed
        new LoginForm().setVisible(true);
        dispose();
    }//GEN-LAST:event_signin_btnActionPerformed

    private void signin_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signin_btnMouseEntered
        signin_btn.setForeground(new Color(6, 115, 33));
    }//GEN-LAST:event_signin_btnMouseEntered

    private void signin_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signin_btnMouseExited
        signin_btn.setForeground(new Color(10, 177, 52));
    }//GEN-LAST:event_signin_btnMouseExited

    private void signin_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signin_btnMousePressed
        signin_btn.setForeground(new Color(5, 96, 28));
    }//GEN-LAST:event_signin_btnMousePressed

    private void signin_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signin_btnMouseReleased
        signin_btn.setForeground(new Color(6, 115, 33));
    }//GEN-LAST:event_signin_btnMouseReleased

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        create_panel.setSelectedIndex(0);
    }//GEN-LAST:event_back_btnActionPerformed

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
            java.util.logging.Logger.getLogger(SignupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField age_field;
    private javax.swing.JLabel age_label;
    private javax.swing.JLabel answer_guide;
    private javax.swing.JLabel answer_label;
    private javax.swing.JButton back_btn;
    private Resources.components.PanelBorder background;
    private javax.swing.JLabel create_account;
    private javax.swing.JTabbedPane create_panel;
    private javax.swing.JLabel element;
    private javax.swing.JTextField email_field;
    private javax.swing.JLabel email_label;
    private javax.swing.JButton exit_btn;
    private javax.swing.JRadioButton female_rdb;
    private javax.swing.JTextField first_name_field;
    private javax.swing.JLabel first_name_label;
    private Resources.components.PanelBorder footer;
    private Resources.components.PanelBorder header;
    private javax.swing.JTextField height_field;
    private javax.swing.JLabel height_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField last_name_field;
    private javax.swing.JLabel last_name_label;
    private javax.swing.JRadioButton male_rdb;
    private Resources.components.PanelMover mover;
    private javax.swing.JButton next_btn;
    private javax.swing.JLabel or;
    private Resources.components.PanelBorder panelBorder1;
    private javax.swing.JToggleButton password_check;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JLabel password_label;
    private javax.swing.JLabel question_guide;
    private javax.swing.JLabel question_label;
    private javax.swing.JTextField sec_answer_field;
    private javax.swing.JTextField sec_question_field;
    private javax.swing.JLabel sex_label;
    private javax.swing.JButton signin_btn;
    private javax.swing.JButton signup_btn;
    private javax.swing.JLabel signup_message;
    private Resources.components.PanelBorder step1_panel;
    private Resources.components.PanelBorder step2_panel;
    private javax.swing.JTextField username_field;
    private javax.swing.JLabel username_label;
    private javax.swing.JLabel validation_label;
    private javax.swing.JTextField weight_field;
    private javax.swing.JLabel weight_label;
    // End of variables declaration//GEN-END:variables
}
