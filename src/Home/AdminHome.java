package Home;

import Account.AdminEditForm;
import Account.LoginForm;
import Resources.components.*;
import java.sql.*;
import java.awt.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;
import Resources.components.UtilityMethods.DefaultFocus;
import static Resources.components.UtilityMethods.DefaultText2;
import static Resources.components.UtilityMethods.TransparentField2;

public class AdminHome extends javax.swing.JFrame {

    public AdminHome() {
        initComponents();
        TransparentField2(user_searchbar);
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(AdminHome.this);
        Image icon = new ImageIcon(this.getClass().getResource("/Resources/elements/fts-icon.png")).getImage();
        this.setIconImage(icon);
        loadDataToTable();
        updateTotalUsers();
        ButtonGroup sexRdb = new ButtonGroup();
        sexRdb.add(male_rdb);
        sexRdb.add(female_rdb);

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        user_table.getTableHeader().setDefaultRenderer(headerRenderer);

        JTableHeader header = user_table.getTableHeader();
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 30));
        header.setBackground(new Color(255, 255, 255));
        header.setForeground(new Color(51, 51, 51));

        centerTableData();

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                editUser(row);
            }

            @Override
            public void onDelete(int row) {
                deleteUser(row);
            }
        };
        user_table.getColumnModel().getColumn(11).setCellRenderer(new TableActionCellRender());
        user_table.getColumnModel().getColumn(11).setCellEditor(new TableActionCellEditor(event));

        add_btn.setEnabled(false);
        setupAddButtonListener();
    }

    public void loadDataToTable() {
        DefaultTableModel model = (DefaultTableModel) user_table.getModel();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String selectQuery = "SELECT user_id, first_name, last_name, email, username, age, sex, weight, height FROM tb_users";
            String updateQuery = "UPDATE tb_users SET bmi = ?, classification = ? WHERE user_id = ?";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            model.setRowCount(0);

            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String username = rs.getString("username");
                Integer getAge = rs.getObject("age", Integer.class);
                String age = String.valueOf(getAge);
                String sex = rs.getString("sex");
                Float getWeight = rs.getObject("weight", Float.class);
                Float getHeight = rs.getObject("height", Float.class);
                String weight = getWeight + " kg";
                String height = getHeight + " cm";
                String BMI = "N/A";
                String classification = "N/A";

                if (getWeight != null && getHeight != null) {
                    float meterHeight = getHeight / 100;
                    float bmiValue = getWeight / (meterHeight * meterHeight);
                    int calculateBMI = (int) bmiValue;
                    BMI = calculateBMI + " kg/m²";

                    if (getAge >= 20) {
                        if (bmiValue < 16) {
                            classification = "Severe Thinness";
                        } else if (bmiValue >= 16 && bmiValue < 17) {
                            classification = "Moderate Thinness";
                        } else if (bmiValue >= 17 && bmiValue < 18.5) {
                            classification = "Mild Thinness";
                        } else if (bmiValue >= 18.5 && bmiValue < 25) {
                            classification = "Normal";
                        } else if (bmiValue >= 25 && bmiValue < 30) {
                            classification = "Overweight";
                        } else if (bmiValue >= 30 && bmiValue < 35) {
                            classification = "Obese Class I";
                        } else if (bmiValue >= 35 && bmiValue < 40) {
                            classification = "Obese Class II";
                        } else if (bmiValue >= 40) {
                            classification = "Obese Class III";
                        }
                    } else if (getAge >= 2 && getAge < 20) {
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
                    
                    updateStmt.setString(1, BMI);
                    updateStmt.setString(2, classification);
                    updateStmt.setInt(3, userId);
                    updateStmt.executeUpdate();
                }

                model.addRow(new Object[]{userId, firstName, lastName, email, username, age, sex, weight, height, BMI, classification});
            }

            user_table.setBackground(new Color(255, 255, 255));

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void refreshUserTable() {
        loadDataToTable();
    }

    public void updateTotalUsers() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String totalUserQuery = "SELECT COUNT(*) FROM tb_users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(totalUserQuery);

            if (rs.next()) {
                int totalUsers = rs.getInt(1);
                total_users.setText("Total Users = " + totalUsers);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading total users: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteUser(int row) {
        int selectedRow = user_table.getSelectedRow();

        if (user_table.isEditing()) {
            user_table.getCellEditor().stopCellEditing();
        }

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "No row selected!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) user_table.getModel();

        if (selectedRow >= model.getRowCount()) {
            JOptionPane.showMessageDialog(this, "Invalid row selected!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int userID = (int) model.getValueAt(selectedRow, 0);

        int confirmDelete = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this user?",
                "Delete User",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmDelete == JOptionPane.YES_OPTION) {
            try {
                Connection conn = DatabaseConnection.getConnection();

                String deleteUserQuery = "DELETE FROM tb_users WHERE user_id = ?";
                PreparedStatement stmt = conn.prepareStatement(deleteUserQuery);
                stmt.setInt(1, userID);

                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    model.removeRow(selectedRow);

                    JOptionPane.showMessageDialog(this, "User deleted successfully!",
                            "Success", JOptionPane.INFORMATION_MESSAGE);

                    user_table.clearSelection();
                    user_table.revalidate();
                    user_table.repaint();

                    updateTotalUsers();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete user.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error deleting user: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void editUser(int row) {
        int selectedRow = user_table.getSelectedRow();

        if (user_table.isEditing()) {
            user_table.getCellEditor().stopCellEditing();
        }

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "No row selected!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) user_table.getModel();

        if (selectedRow >= model.getRowCount()) {
            JOptionPane.showMessageDialog(this, "Invalid row selected!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int editUserId = Integer.parseInt(model.getValueAt(row, 0).toString());
        String editFirstName = (String) model.getValueAt(row, 1);
        String editLastName = (String) model.getValueAt(row, 2);
        String editEmail = (String) model.getValueAt(row, 3);
        String editUsername = (String) model.getValueAt(row, 4);
        int editAge = Integer.parseInt(model.getValueAt(row, 5).toString());
        String editSex = (String) model.getValueAt(row, 6);
        String weightString = model.getValueAt(row, 7).toString().replaceAll("[^0-9.]", "");
        String heightString = model.getValueAt(row, 8).toString().replaceAll("[^0-9.]", "");
        float editWeight = Float.parseFloat(weightString);
        float editHeight = Float.parseFloat(heightString);

        String adminPassword = JOptionPane.showInputDialog(this, "Enter admin security password:");
        if (adminPassword.equals("admin123") || adminPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Correct Input! Proceeding...");
            AdminEditForm editForm = new AdminEditForm(this, editUserId, editFirstName, editLastName, editEmail, editUsername, editAge, editSex, editWeight, editHeight);
            editForm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect Password, Logging out!", "Invalid Admin Credentials", JOptionPane.WARNING_MESSAGE);
            new LoginForm().setVisible(true);
            dispose();
        }
    }

    private void centerTableData() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        for (int i = 0; i < user_table.getColumnCount() - 1; i++) {
            user_table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void setupAddButtonListener() {
        javax.swing.event.DocumentListener documentListener = new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                toggleAddButton();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                toggleAddButton();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                toggleAddButton();
            }
        };
        first_name_field.getDocument().addDocumentListener(documentListener);
        last_name_field.getDocument().addDocumentListener(documentListener);
        email_field.getDocument().addDocumentListener(documentListener);
        username_field.getDocument().addDocumentListener(documentListener);
        age_field.getDocument().addDocumentListener(documentListener);
        male_rdb.addActionListener(e -> toggleAddButton());
        female_rdb.addActionListener(e -> toggleAddButton());
        weight_field.getDocument().addDocumentListener(documentListener);
        height_field.getDocument().addDocumentListener(documentListener);
        password_field.getDocument().addDocumentListener(documentListener);
        sec_question_field.getDocument().addDocumentListener(documentListener);
        sec_answer_field.getDocument().addDocumentListener(documentListener);
    }

    private void toggleAddButton() {
        String firstname = first_name_field.getText().trim();
        String lastname = last_name_field.getText().trim();
        String email = email_field.getText().trim();
        String username = username_field.getText().trim();
        String age = age_field.getText();
        String weight = weight_field.getText();
        String height = height_field.getText();
        String password = String.valueOf(password_field.getPassword()).trim();
        String secQuestion = sec_question_field.getText().trim();
        String secAnswer = sec_answer_field.getText().trim();
        add_btn.setEnabled(!firstname.isEmpty() && !lastname.isEmpty()
                && !email.isEmpty() && !username.isEmpty()
                && !age.isEmpty() && !weight.isEmpty() && !height.isEmpty()
                && (male_rdb.isSelected() || female_rdb.isSelected())
                && !password.isEmpty() && !secQuestion.isEmpty()
                && !secAnswer.isEmpty());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        admin_background = new Resources.components.PanelBorder();
        greetings = new javax.swing.JLabel();
        exit_btn = new javax.swing.JButton();
        logout_btn = new javax.swing.JButton();
        admin_header = new Resources.components.PanelBorder();
        usertable_btn = new javax.swing.JButton();
        adduser_btn = new javax.swing.JButton();
        admin_panels = new javax.swing.JTabbedPane();
        user_table_panel = new Resources.components.PanelBorder();
        user_table_label = new javax.swing.JLabel();
        total_users = new javax.swing.JLabel();
        user_searchbar = new javax.swing.JTextField();
        search_user_icon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        user_table = new javax.swing.JTable();
        usertable_background = new javax.swing.JLabel();
        adduser_panel = new Resources.components.PanelBorder();
        panelBorder2 = new Resources.components.PanelBorder();
        password_check = new javax.swing.JToggleButton();
        first_name_label = new javax.swing.JLabel();
        first_name_field = new javax.swing.JTextField();
        last_name_label = new javax.swing.JLabel();
        last_name_field = new javax.swing.JTextField();
        email_label = new javax.swing.JLabel();
        email_field = new javax.swing.JTextField();
        username_label = new javax.swing.JLabel();
        username_field = new javax.swing.JTextField();
        age_label = new javax.swing.JLabel();
        age_field = new javax.swing.JTextField();
        sex_label = new javax.swing.JLabel();
        male_rdb = new javax.swing.JRadioButton();
        female_rdb = new javax.swing.JRadioButton();
        weight_label = new javax.swing.JLabel();
        weight_field = new javax.swing.JTextField();
        height_label = new javax.swing.JLabel();
        height_field = new javax.swing.JTextField();
        password_label = new javax.swing.JLabel();
        password_field = new javax.swing.JPasswordField();
        question_label = new javax.swing.JLabel();
        sec_question_field = new javax.swing.JTextField();
        answer_label = new javax.swing.JLabel();
        sec_answer_field = new javax.swing.JTextField();
        add_btn = new javax.swing.JButton();
        adduser_background = new javax.swing.JLabel();
        background = new Resources.components.PanelBorder();
        mover = new Resources.components.PanelMover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admin_background.setBackground(new java.awt.Color(255, 255, 255));
        admin_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        greetings.setFont(new java.awt.Font("Cascadia Mono", 1, 24)); // NOI18N
        greetings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/admin-icon.png"))); // NOI18N
        greetings.setText("Hello, Admin!");
        greetings.setIconTextGap(10);
        admin_background.add(greetings, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 50));

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
        admin_background.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 20, -1, -1));

        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-black-idle.png"))); // NOI18N
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
        admin_background.add(logout_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1165, 20, -1, -1));

        admin_header.setBackground(new java.awt.Color(255, 255, 255));
        admin_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usertable_btn.setBackground(new java.awt.Color(142, 142, 255));
        usertable_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        usertable_btn.setForeground(new java.awt.Color(255, 255, 255));
        usertable_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-table-icon.png"))); // NOI18N
        usertable_btn.setText("User Table");
        usertable_btn.setIconTextGap(15);
        usertable_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertable_btnActionPerformed(evt);
            }
        });
        admin_header.add(usertable_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 9, 150, 50));

        adduser_btn.setBackground(new java.awt.Color(142, 142, 255));
        adduser_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        adduser_btn.setForeground(new java.awt.Color(255, 255, 255));
        adduser_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-add-icon.png"))); // NOI18N
        adduser_btn.setText("Add User");
        adduser_btn.setIconTextGap(15);
        adduser_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adduser_btnActionPerformed(evt);
            }
        });
        admin_header.add(adduser_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 150, 50));

        admin_background.add(admin_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1230, 70));

        admin_panels.setBackground(new java.awt.Color(142, 142, 255));

        user_table_panel.setBackground(new java.awt.Color(142, 142, 255));
        user_table_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user_table_label.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        user_table_label.setForeground(new java.awt.Color(255, 255, 255));
        user_table_label.setText("User Information Table");
        user_table_panel.add(user_table_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 70, 180, 30));

        total_users.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        total_users.setForeground(new java.awt.Color(255, 255, 255));
        total_users.setText("Total Users =");
        user_table_panel.add(total_users, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1210, 40));

        user_searchbar.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_searchbar.setText("Search User");
        user_searchbar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                user_searchbarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                user_searchbarFocusLost(evt);
            }
        });
        user_searchbar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                user_searchbarKeyReleased(evt);
            }
        });
        user_table_panel.add(user_searchbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 70, 280, 30));

        search_user_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        search_user_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-search-icon.png"))); // NOI18N
        user_table_panel.add(search_user_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 70, 30, 30));

        user_table.setFont(new java.awt.Font("Cascadia Mono", 0, 9)); // NOI18N
        user_table.setForeground(new java.awt.Color(51, 51, 51));
        user_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "First Name", "Last Name", "Email", "Username", "Age", "Sex", "Weight", "Height", "BMI", "Classification", "Actions"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        user_table.setGridColor(new java.awt.Color(255, 255, 255));
        user_table.setRowHeight(40);
        user_table.setSelectionBackground(new java.awt.Color(137, 229, 137));
        user_table.setSelectionForeground(new java.awt.Color(255, 255, 255));
        user_table.setShowHorizontalLines(true);
        user_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(user_table);
        if (user_table.getColumnModel().getColumnCount() > 0) {
            user_table.getColumnModel().getColumn(0).setMinWidth(1);
            user_table.getColumnModel().getColumn(0).setPreferredWidth(1);
            user_table.getColumnModel().getColumn(1).setMinWidth(1);
            user_table.getColumnModel().getColumn(1).setPreferredWidth(50);
            user_table.getColumnModel().getColumn(2).setMinWidth(1);
            user_table.getColumnModel().getColumn(2).setPreferredWidth(30);
            user_table.getColumnModel().getColumn(3).setMinWidth(1);
            user_table.getColumnModel().getColumn(4).setMinWidth(1);
            user_table.getColumnModel().getColumn(4).setPreferredWidth(30);
            user_table.getColumnModel().getColumn(5).setMinWidth(1);
            user_table.getColumnModel().getColumn(5).setPreferredWidth(1);
            user_table.getColumnModel().getColumn(6).setMinWidth(1);
            user_table.getColumnModel().getColumn(6).setPreferredWidth(5);
            user_table.getColumnModel().getColumn(7).setMinWidth(1);
            user_table.getColumnModel().getColumn(7).setPreferredWidth(5);
            user_table.getColumnModel().getColumn(8).setMinWidth(1);
            user_table.getColumnModel().getColumn(8).setPreferredWidth(5);
            user_table.getColumnModel().getColumn(9).setMinWidth(1);
            user_table.getColumnModel().getColumn(9).setPreferredWidth(10);
            user_table.getColumnModel().getColumn(10).setMinWidth(1);
            user_table.getColumnModel().getColumn(10).setPreferredWidth(15);
            user_table.getColumnModel().getColumn(11).setMinWidth(5);
            user_table.getColumnModel().getColumn(11).setPreferredWidth(5);
        }

        user_table_panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1210, 420));

        usertable_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/admin-user-element.png"))); // NOI18N
        user_table_panel.add(usertable_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        admin_panels.addTab("tab1", user_table_panel);

        adduser_panel.setBackground(new java.awt.Color(142, 142, 255));
        adduser_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        panelBorder2.add(password_check, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 285, 20, 20));

        first_name_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        first_name_label.setText("First Name");
        panelBorder2.add(first_name_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, -1, -1));

        first_name_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder2.add(first_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 150, -1));

        last_name_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        last_name_label.setText("Last Name");
        panelBorder2.add(last_name_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 15, -1, -1));

        last_name_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder2.add(last_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 150, -1));

        email_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        email_label.setText("Email");
        panelBorder2.add(email_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, -1, -1));

        email_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder2.add(email_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 310, -1));

        username_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        username_label.setText("Username");
        panelBorder2.add(username_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        username_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder2.add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 310, -1));

        age_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        age_label.setText("Age");
        panelBorder2.add(age_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 165, -1, -1));

        age_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder2.add(age_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 150, -1));

        sex_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        sex_label.setText("Sex");
        panelBorder2.add(sex_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, -1, -1));

        male_rdb.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        male_rdb.setText("Male");
        panelBorder2.add(male_rdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));

        female_rdb.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        female_rdb.setText("Female");
        panelBorder2.add(female_rdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));

        weight_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        weight_label.setText("Weight (kg)");
        panelBorder2.add(weight_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 215, -1, -1));

        weight_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder2.add(weight_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 150, -1));

        height_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        height_label.setText("Height (cm)");
        panelBorder2.add(height_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 215, -1, -1));

        height_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder2.add(height_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 150, -1));

        password_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        password_label.setText("Password");
        panelBorder2.add(password_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 265, -1, -1));

        password_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder2.add(password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 310, -1));

        question_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        question_label.setText("Validation Question");
        panelBorder2.add(question_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 325, -1, -1));

        sec_question_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder2.add(sec_question_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 310, -1));

        answer_label.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        answer_label.setText("Validation Answer");
        panelBorder2.add(answer_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 375, -1, -1));

        sec_answer_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder2.add(sec_answer_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 310, -1));

        add_btn.setBackground(new java.awt.Color(102, 102, 255));
        add_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        add_btn.setForeground(new java.awt.Color(255, 255, 255));
        add_btn.setText("Add User");
        add_btn.setAlignmentY(0.0F);
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });
        panelBorder2.add(add_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 310, 30));

        adduser_panel.add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 350, 470));

        adduser_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/admin-user-element.png"))); // NOI18N
        adduser_panel.add(adduser_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        admin_panels.addTab("tab2", adduser_panel);

        admin_background.add(admin_panels, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1230, 560));

        background.setBackground(new java.awt.Color(142, 142, 255));

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1230, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        admin_background.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1230, 560));
        admin_background.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 20));

        getContentPane().add(admin_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 640));

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
        int confirmExit = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to quit?",
                "Quit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmExit == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_exit_btnActionPerformed

    private void logout_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMouseEntered
        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-black-hover.png")));
    }//GEN-LAST:event_logout_btnMouseEntered

    private void logout_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMouseExited
        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-black-idle.png")));
    }//GEN-LAST:event_logout_btnMouseExited

    private void logout_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMousePressed
        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-black-idle.png")));
    }//GEN-LAST:event_logout_btnMousePressed

    private void logout_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMouseReleased
        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/logout-black-hover.png")));
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

    private void usertable_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertable_btnActionPerformed
        admin_panels.setSelectedIndex(0);
    }//GEN-LAST:event_usertable_btnActionPerformed

    private void adduser_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adduser_btnActionPerformed
        admin_panels.setSelectedIndex(1);
    }//GEN-LAST:event_adduser_btnActionPerformed

    private void user_searchbarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_user_searchbarKeyReleased
        DefaultTableModel model = (DefaultTableModel) user_table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        user_table.setRowSorter(sorter);

        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + user_searchbar.getText()));
    }//GEN-LAST:event_user_searchbarKeyReleased

    private void user_searchbarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_searchbarFocusGained
        DefaultText2(user_searchbar, "Search User", DefaultFocus.GAINED);
    }//GEN-LAST:event_user_searchbarFocusGained

    private void user_searchbarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_searchbarFocusLost
        DefaultText2(user_searchbar, "Search User", DefaultFocus.LOST);
    }//GEN-LAST:event_user_searchbarFocusLost

    private void password_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_checkActionPerformed
        if (password_check.isSelected()) {
            password_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/eye-open.png")));
            password_field.setEchoChar((char) 0);
        } else {
            password_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/eye-close.png")));
            password_field.setEchoChar('*');
        }
    }//GEN-LAST:event_password_checkActionPerformed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        String firstname = first_name_field.getText().trim();
        String lastname = last_name_field.getText().trim();
        String email = email_field.getText().trim();
        String username = username_field.getText().trim();
        String age = age_field.getText();
        String sex = male_rdb.isSelected() ? "Male" : (female_rdb.isSelected() ? "Female" : null);
        String weight = weight_field.getText();
        String height = height_field.getText();
        String password = String.valueOf(password_field.getPassword()).trim();
        String sec_question = sec_question_field.getText().trim();
        String sec_answer = sec_answer_field.getText().trim();

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
        if (username.equals("admin1") || username.equals("admin2") || username.equals("admin3")
                || username.equals("admin4") || username.equals("admin5")) {
            JOptionPane.showMessageDialog(null, "This username is already taken", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //CHECK IF PASSWORD IS STRONG
        if (password.length() < 8) {
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //NO SQL INJECTION OR HTML TAGS
        if (username.matches(".*<.*>.*") || firstname.matches(".*<.*>.*") || lastname.matches(".*<.*>.*")) {
            JOptionPane.showMessageDialog(null, "Fields cannot contain HTML tags.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
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
                    + "(`first_name`, `last_name`, `email`, `username`, `age`, `sex`, `weight`, `height`, `password`, `sec_question`, `sec_answer`)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
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

            if (ps.executeUpdate() > 0) {
                loadDataToTable();
                updateTotalUsers();
                JOptionPane.showMessageDialog(null, "New user added!");
                new AdminHome().setVisible(true);
                dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_add_btnActionPerformed

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
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        UIDefaults ui = UIManager.getDefaults();
        ui.put("ScrollBarUI", ScrollBarWin11UI.class.getCanonicalName());
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JLabel adduser_background;
    private javax.swing.JButton adduser_btn;
    private Resources.components.PanelBorder adduser_panel;
    private Resources.components.PanelBorder admin_background;
    private Resources.components.PanelBorder admin_header;
    private javax.swing.JTabbedPane admin_panels;
    private javax.swing.JTextField age_field;
    private javax.swing.JLabel age_label;
    private javax.swing.JLabel answer_label;
    private Resources.components.PanelBorder background;
    private javax.swing.JTextField email_field;
    private javax.swing.JLabel email_label;
    private javax.swing.JButton exit_btn;
    private javax.swing.JRadioButton female_rdb;
    private javax.swing.JTextField first_name_field;
    private javax.swing.JLabel first_name_label;
    private javax.swing.JLabel greetings;
    private javax.swing.JTextField height_field;
    private javax.swing.JLabel height_label;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField last_name_field;
    private javax.swing.JLabel last_name_label;
    private javax.swing.JButton logout_btn;
    private javax.swing.JRadioButton male_rdb;
    private Resources.components.PanelMover mover;
    private Resources.components.PanelBorder panelBorder2;
    private javax.swing.JToggleButton password_check;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JLabel password_label;
    private javax.swing.JLabel question_label;
    private javax.swing.JLabel search_user_icon;
    private javax.swing.JTextField sec_answer_field;
    private javax.swing.JTextField sec_question_field;
    private javax.swing.JLabel sex_label;
    private javax.swing.JLabel total_users;
    private javax.swing.JTextField user_searchbar;
    private javax.swing.JTable user_table;
    private javax.swing.JLabel user_table_label;
    private Resources.components.PanelBorder user_table_panel;
    private javax.swing.JTextField username_field;
    private javax.swing.JLabel username_label;
    private javax.swing.JLabel usertable_background;
    private javax.swing.JButton usertable_btn;
    private javax.swing.JTextField weight_field;
    private javax.swing.JLabel weight_label;
    // End of variables declaration//GEN-END:variables
}
