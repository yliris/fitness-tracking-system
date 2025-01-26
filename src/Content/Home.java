package Content;

import java.awt.Color;
import Resources.components.DatabaseConnection;
import Account.DeleteForm;
import Account.UserEditForm;
import Resources.components.GoalForm;
import Resources.components.ModelPieChart;
import Resources.components.PasswordForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.JOptionPane;

public class Home extends javax.swing.JPanel {

    private int userId;

    public Home(int userId) {
        initComponents();
        this.userId = userId;
        setBackground(new Color(0, 0, 0, 0));
        setProfileDetails();
        updateExerciseCount();
        updateMealCount();
        exerciseResult();
        mealResult();
        populateWeeks();
        weeks_cbox.addActionListener(e -> showData());
    }

    private void setProfileDetails() {
        String userInfoQuery = "SELECT username, first_name, last_name, email, sex, bmi, classification, weight, height FROM tb_users WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(userInfoQuery)) {
            stmt.setInt(1, this.userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String username = rs.getString("username");
                    String fname = rs.getString("first_name");
                    String lname = rs.getString("last_name");
                    String email = rs.getString("email");
                    String sex = rs.getString("sex");
                    String bmi = rs.getString("bmi");
                    String classification = rs.getString("classification");
                    float weight = rs.getFloat("weight");
                    float height = rs.getFloat("height");

                    username_profile.setText("-- " + username + " --");
                    name_profile.setText(fname + " " + lname);
                    email_profile.setText(email);
                    weight_profile.setText(String.format("Weight: %.1f kg", weight));
                    height_profile.setText(String.format("Height: %.1f cm", height));
                    bmi_profile.setText("BMI: " + bmi);
                    classification_profile.setText("Classification: " + classification);

                    if (sex.equals("Male")) {
                        user_profile_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-male-icon.png")));
                    } else if (sex.equals("Female")) {
                        user_profile_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-female-icon.png")));
                    }

                    Map<String, List<String>> motivationMessages = new HashMap<>();
                    motivationMessages.put("Underweight", Arrays.asList(
                            "Your body deserves care! Nourish yourself with wholesome foods.",
                            "Every small step matters. Stay positive and add healthy meals to your day.",
                            "Focus on building strength and vitality through balanced nutrition."
                    ));
                    motivationMessages.put("Normal Weight", Arrays.asList(
                            "Great job maintaining a healthy weight! Keep up the good work.",
                            "Your healthy habits are paying off! Stay consistent and enjoy the results.",
                            "You're doing amazing! Celebrate your commitment to wellness."
                    ));
                    motivationMessages.put("Overweight", Arrays.asList(
                            "You're capable of achieving your health goals. Take it one day at a time!",
                            "Small steps lead to big changes. Focus on progress, not perfection.",
                            "Stay active and make mindful choices. You’re on the right path!"
                    ));
                    motivationMessages.put("Obese", Arrays.asList(
                            "You're strong and capable. Start with small, sustainable changes.",
                            "Focus on steady progress. Your effort will lead to better health.",
                            "Seek support and stay determined. Every day is a new opportunity!"
                    ));

                    List<String> messages = motivationMessages.getOrDefault(classification,
                            Collections.singletonList("Embrace your health journey with confidence and determination!"));
                    String motivationMessage = messages.get(new Random().nextInt(messages.size()));

                    motivation_label.setText(motivationMessage);

                    bmi_result.setText(String.format(bmi));
                    classification_result.setText(classification);

                    float heightInMeters = (float) (height / 100.0);
                    float minBMI = 18.5f;
                    float maxBMI = 24.9f;
                    float minimumWeight = minBMI * heightInMeters * heightInMeters;
                    float maximumWeight = maxBMI * heightInMeters * heightInMeters;

                    healthy_range.setText(String.format("%.1f kg", minimumWeight) + " - " + String.format("%.1f kg", maximumWeight));

                    try {
                        String bmiCleaned = bmi.replaceAll("[^\\d.]", "");
                        float bmiValue = Float.parseFloat(bmiCleaned);

                        float currentWeight = bmiValue * heightInMeters * heightInMeters;

                        float minWeight = minBMI * heightInMeters * heightInMeters;
                        float maxWeight = maxBMI * heightInMeters * heightInMeters;

                        if (currentWeight < minWeight) {
                            float weightToGain = minWeight - currentWeight;
                            weight_needs.setText("Recommendation: Gain " + String.format("%.1f", weightToGain) + " kg to reach a healthy weight.");
                        } else if (currentWeight > maxWeight) {
                            float weightToLose = currentWeight - maxWeight;
                            weight_needs.setText("Recommendation: Lose " + String.format("%.1f", weightToLose) + " kg to reach a healthy weight.");
                        } else {
                            weight_needs.setText("Your weight is within the healthy range!");
                        }
                    } catch (NumberFormatException e) {
                        weight_needs.setText("Invalid BMI value. Please check your data.");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error loading user data: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateUserDetails(String username, String fullName, String email, float weight, float height) {
        username_profile.setText("-- " + username + " --");
        name_profile.setText(fullName);
        email_profile.setText(email);
        weight_profile.setText(String.format("Weight: " + weight) + " kg");
        height_profile.setText(String.format("Height: " + height) + " cm");
    }

    public void updateProfileIcon(String sex) {
        if (sex.equals("Male")) {
            user_profile_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-male-icon.png")));
        } else if (sex.equals("Female")) {
            user_profile_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-female-icon.png")));
        }
    }

    public void updateUserBMI(String BMI, String classification, String healthyRange, String weightNeeds) {
        String bmi = BMI;
        String userClassification = classification;
        bmi_profile.setText("BMI: " + bmi);
        classification_profile.setText("Classification: " + userClassification);
        bmi_result.setText(bmi);
        classification_result.setText(userClassification);

        Map<String, List<String>> motivationMessages = new HashMap<>();
        motivationMessages.put("Underweight", Arrays.asList(
                "Your body deserves care! Nourish yourself with wholesome foods.",
                "Every small step matters. Stay positive and add healthy meals to your day.",
                "Focus on building strength and vitality through balanced nutrition."
        ));
        motivationMessages.put("Normal Weight", Arrays.asList(
                "Great job maintaining a healthy weight! Keep up the good work.",
                "Your healthy habits are paying off! Stay consistent and enjoy the results.",
                "You're doing amazing! Celebrate your commitment to wellness."
        ));
        motivationMessages.put("Overweight", Arrays.asList(
                "You're capable of achieving your health goals. Take it one day at a time!",
                "Small steps lead to big changes. Focus on progress, not perfection.",
                "Stay active and make mindful choices. You’re on the right path!"
        ));
        motivationMessages.put("Obese", Arrays.asList(
                "You're strong and capable. Start with small, sustainable changes.",
                "Focus on steady progress. Your effort will lead to better health.",
                "Seek support and stay determined. Every day is a new opportunity!"
        ));

        List<String> messages = motivationMessages.getOrDefault(classification,
                Collections.singletonList("Embrace your health journey with confidence and determination!"));
        String motivationMessage = messages.get(new Random().nextInt(messages.size()));

        motivation_label.setText(motivationMessage);

        healthy_range.setText(healthyRange);

        weight_needs.setText(weightNeeds);
    }

    public void updateExerciseCount() {
        String incompleteCountQuery = "SELECT COUNT(*) FROM tb_incomplete_exercises WHERE user_id = ? AND completed = 0 "
                + "UNION "
                + "SELECT COUNT(*) FROM tb_completed_exercises WHERE user_id = ? AND completed = 0";
        String completedCountQuery = "SELECT COUNT(*) FROM tb_incomplete_exercises WHERE user_id = ? AND completed = 1 "
                + "UNION "
                + "SELECT COUNT(*) FROM tb_completed_exercises WHERE user_id = ? AND completed = 1";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmtIncomplete = conn.prepareStatement(incompleteCountQuery); PreparedStatement stmtCompleted = conn.prepareStatement(completedCountQuery)) {

            stmtIncomplete.setInt(1, userId);
            stmtIncomplete.setInt(2, userId);
            stmtCompleted.setInt(1, userId);
            stmtCompleted.setInt(2, userId);

            ResultSet rsIncomplete = stmtIncomplete.executeQuery();
            int incompleteCount = 0;
            while (rsIncomplete.next()) {
                incompleteCount += rsIncomplete.getInt(1);
            }

            ResultSet rsCompleted = stmtCompleted.executeQuery();
            int completedCount = 0;
            while (rsCompleted.next()) {
                completedCount += rsCompleted.getInt(1);
            }

            exeincomplete_label.setText(String.valueOf(incompleteCount));
            execompleted_label.setText(String.valueOf(completedCount));
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching exercise counts: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateMealCount() {
        String incompleteCountQuery = "SELECT COUNT(*) FROM tb_incomplete_meals WHERE user_id = ? AND completed = 0 "
                + "UNION "
                + "SELECT COUNT(*) FROM tb_completed_meals WHERE user_id = ? AND completed = 0";
        String completedCountQuery = "SELECT COUNT(*) FROM tb_incomplete_meals WHERE user_id = ? AND completed = 1 "
                + "UNION "
                + "SELECT COUNT(*) FROM tb_completed_meals WHERE user_id = ? AND completed = 1";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmtIncomplete = conn.prepareStatement(incompleteCountQuery); PreparedStatement stmtCompleted = conn.prepareStatement(completedCountQuery)) {

            stmtIncomplete.setInt(1, userId);
            stmtIncomplete.setInt(2, userId);
            stmtCompleted.setInt(1, userId);
            stmtCompleted.setInt(2, userId);

            ResultSet rsIncomplete = stmtIncomplete.executeQuery();
            int incompleteCount = 0;
            while (rsIncomplete.next()) {
                incompleteCount += rsIncomplete.getInt(1);
            }

            ResultSet rsCompleted = stmtCompleted.executeQuery();
            int completedCount = 0;
            while (rsCompleted.next()) {
                completedCount += rsCompleted.getInt(1);
            }

            mealincomplete_label.setText(String.valueOf(incompleteCount));
            mealcompleted_label.setText(String.valueOf(completedCount));
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching diet counts: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void exerciseResult() {
        String userQuery = "SELECT bmi, goal FROM tb_users WHERE user_id = ?";
        String bmiStr = "";
        String goal = "";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(userQuery)) {
            stmt.setInt(1, userId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                bmiStr = rs.getString("bmi");
                goal = rs.getString("goal");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

        float bmi = Float.parseFloat(bmiStr.split(" ")[0]);
        String exercise_label = "";
        String exerecommendation1 = "";
        String exerecommendation2 = "";
        String exerecommendation3 = "";
        String exemotivation = "";
        if (goal == null || goal.isEmpty()) {
            exercise_label = "Welcome, You should set a goal first!";
            exerecommendation1 = "";
            exerecommendation2 = "";
            exerecommendation3 = "";
            exemotivation = "Start your fitness journey with us for a healthier you!";
        } else if (goal.equals("Gain Weight")) {
            exercise_label = "Recommended exercises:";
            if (bmi < 18.5) {
                exerecommendation1 = "Strength (Resistance) Training, High-Intensity Interval Training (HIIT),";
                exerecommendation2 = "Functional Fitness Training, and Sports and Recreational Activities.";
                exerecommendation3 = "Exercise at least 4-5 times a week to build muscle and boost metabolism.";
                exemotivation = "Every rep builds your strength—stay consistent and stay focused!";
            } else if (bmi < 25) {
                exerecommendation1 = "Strength (Resistance) Training, Cardiovascular (Aerobic) Exercise,";
                exerecommendation2 = "Functional Fitness Training, and Flexibility Exercise.";
                exerecommendation3 = "Exercise at least 3-4 times a week to balance muscle growth and fitness.";
                exemotivation = "Your strength is your power—build balance and keep progressing!";
            } else if (bmi < 30) {
                exerecommendation1 = "Strength (Resistance) Training, Functional Fitness Training,";
                exerecommendation2 = "Mind-Body Exercises, and Balance Exercise.";
                exerecommendation3 = "Exercise at least 3-4 times a week to maintain strength and improve mobility.";
                exemotivation = "Keep moving forward—strength and mobility are the key to wellness!";
            } else {
                exerecommendation1 = "Strength (Resistance) Training, Low-Impact Aerobic Exercise,";
                exerecommendation2 = "Functional Fitness Training, and Balance Exercise.";
                exerecommendation3 = "Exercise at least 3-4 times a week to improve mobility and prevent injury.";
                exemotivation = "Small steps make a big difference—focus on building strength and stability!";
            }
        } else if (goal.equals("Lose Weight")) {
            exercise_label = "Recommended exercises:";
            if (bmi < 18.5) {
                exerecommendation1 = "Strength (Resistance) Training, Functional Fitness Training,";
                exerecommendation2 = "Mind-Body Exercises, and Flexibility Exercise.";
                exerecommendation3 = "Exercise at least 3-4 times a week to prevent further weight loss and stay active.";
                exemotivation = "Stay strong—find balance and keep yourself energized every step of the way!";
            } else if (bmi < 25) {
                exerecommendation1 = "High-Intensity Interval Training (HIIT), Cardiovascular (Aerobic) Exercise,";
                exerecommendation2 = "Sports and Recreational Activities, and Flexibility Exercise.";
                exerecommendation3 = "Exercise at least 4-5 times a week to maximize fat burning and improve fitness.";
                exemotivation = "Push your limits—burn calories, stay active, and achieve your goals!";
            } else if (bmi < 30) {
                exerecommendation1 = "High-Intensity Interval Training (HIIT), Strength (Resistance) Training,";
                exerecommendation2 = "Cardiovascular (Aerobic) Exercise, and Functional Fitness Training.";
                exerecommendation3 = "Exercise at least 4-6 times a week for optimal fat burning and muscle retention.";
                exemotivation = "Stay disciplined—every workout brings you closer to your ideal weight!";
            } else {
                exerecommendation1 = "Low-Impact Cardio (e.g., walking, swimming), Strength Training,";
                exerecommendation2 = "Functional Fitness Training, and Flexibility Exercises.";
                exerecommendation3 = "Exercise at least 4 times a week to support weight loss and improve mobility.";
                exemotivation = "Take it step by step—consistency leads to remarkable progress!";
            }
        } else if (goal.equals("Maintain Weight")) {
            exercise_label = "Recommended exercises:";
            if (bmi < 18.5) {
                exerecommendation1 = "Strength (Resistance) Training, Functional Fitness Training,";
                exerecommendation2 = "Mind-Body Exercises, and Flexibility Exercise.";
                exerecommendation3 = "Exercise at least 3 times a week to maintain muscle and mobility.";
                exemotivation = "Consistency is key—stay active and maintain your strength for life!";
            } else if (bmi < 25) {
                exerecommendation1 = "Cardiovascular (Aerobic) Exercise, Sports and Recreational Activities,";
                exerecommendation2 = "Flexibility Exercise, and Balance Exercise.";
                exerecommendation3 = "Exercise at least 3-4 times a week to stay active and maintain balance.";
                exemotivation = "Stay active, stay balanced—your health is your greatest asset!";
            } else if (bmi < 30) {
                exerecommendation1 = "Cardiovascular (Aerobic) Exercise, Flexibility Exercise,";
                exerecommendation2 = "Mind-Body Exercises, and Balance Exercise.";
                exerecommendation3 = "Exercise at least 3-4 times a week to improve mobility and overall wellness.";
                exemotivation = "Wellness starts with you—improve mobility and live your best life!";
            } else {
                exerecommendation1 = "Low-Impact Cardio, Functional Fitness Training,";
                exerecommendation2 = "Flexibility Exercises, and Balance Exercises.";
                exerecommendation3 = "Exercise at least 3 times a week to enhance mobility and maintain overall health.";
                exemotivation = "Every step towards movement is a step towards a better you!";
            }
        }

        label_exercise.setText(exercise_label);
        exercise_recommendation1.setText(exerecommendation1);
        exercise_recommendation2.setText(exerecommendation2);
        exercise_recommendation.setText(exerecommendation3);
        motivation_exercise.setText(exemotivation);
    }

    public void mealResult() {
        String userQuery = "SELECT bmi, goal FROM tb_users WHERE user_id = ?";
        String bmiStr = "";
        String goal = "";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(userQuery)) {
            stmt.setInt(1, userId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                bmiStr = rs.getString("bmi");
                goal = rs.getString("goal");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

        float bmi = Float.parseFloat(bmiStr.split(" ")[0]);
        String diet_label = "";
        String dietrecommendation1 = "";
        String dietrecommendation2 = "";
        String dietrecommendation3 = "";

        if (goal == null || goal.isEmpty()) {
            diet_label = "";
            dietrecommendation1 = "";
            dietrecommendation2 = "";
            dietrecommendation3 = "";
        } else if (goal.equals("Gain Weight")) {
            diet_label = "Recommended Diet:";
            if (bmi < 18.5) {
                dietrecommendation1 = "Calories: 2,300–3,000, Protein: 70–120 g, Carbs: 300–400 g, Fat: 70–100 g.";
                dietrecommendation3 = "Include calorie-dense foods like nuts, dairy, lean meats, and whole grains.";
                dietrecommendation2 = "Calories: 16,100–21,000, Protein: 490–840 g, Carbs: 2,100–2,800 g, Fat: 490–700 g.";
            } else if (bmi < 25) {
                dietrecommendation1 = "Calories: 2,500–3,200, Protein: 80–130 g, Carbs: 350–450 g, Fat: 80–110 g.";
                dietrecommendation3 = "Add protein shakes, whole grains, and healthy oils to your meals.";
                dietrecommendation2 = "Calories: 17,500–22,400, Protein: 560–910 g, Carbs: 2,450–3,150 g, Fat: 560–770 g.";
            } else if (bmi < 30) {
                dietrecommendation1 = "Calories: 2,200–2,800, Protein: 90–140 g, Carbs: 250–350 g, Fat: 70–90 g.";
                dietrecommendation3 = "Focus on nutrient-dense foods and moderate portion sizes.";
                dietrecommendation2 = "Calories: 15,400–19,600, Protein: 630–980 g, Carbs: 1,750–2,450 g, Fat: 490–630 g.";
            } else {
                dietrecommendation1 = "Calories: 2,000–2,500, Protein: 100–150 g, Carbs: 200–300 g, Fat: 60–80 g.";
                dietrecommendation3 = "Prioritize lean proteins, low-glycemic carbs, and healthy fats.";
                dietrecommendation2 = "Calories: 14,000–17,500, Protein: 700–1,050 g, Carbs: 1,400–2,100 g, Fat: 420–560 g.";
            }
        } else if (goal.equals("Lose Weight")) {
            diet_label = "Recommended Diet:";
            if (bmi < 18.5) {
                dietrecommendation1 = "Calories: 1,600–2,000, Protein: 60–90 g, Carbs: 200–250 g, Fat: 50–70 g.";
                dietrecommendation3 = "Focus on nutrient-rich foods like eggs, dairy, and nuts.";
                dietrecommendation2 = "Calories: 11,200–14,000, Protein: 420–630 g, Carbs: 1,400–1,750 g, Fat: 350–490 g.";
            } else if (bmi < 25) {
                dietrecommendation1 = "Calories: 1,500–2,000, Protein: 80–100 g, Carbs: 150–200 g, Fat: 50–60 g.";
                dietrecommendation3 = "Incorporate high-fiber and low-calorie foods into your diet.";
                dietrecommendation2 = "Calories: 10,500–14,000, Protein: 560–700 g, Carbs: 1,050–1,400 g, Fat: 350–420 g.";
            } else if (bmi < 30) {
                dietrecommendation1 = "Daily: Calories: 1,200–1,800, Protein: 90–110 g, Carbs: 100–150 g, Fat: 40–60 g.";
                dietrecommendation3 = "Limit processed foods and sugary drinks; focus on whole foods.";
                dietrecommendation2 = "Weekly: Calories: 8,400–12,600, Protein: 630–770 g, Carbs: 700–1,050 g, Fat: 280–420 g.";
            } else {
                dietrecommendation1 = "Calories: 1,200–1,600, Protein: 100–120 g, Carbs: 100–130 g, Fat: 30–50 g.";
                dietrecommendation3 = "Eat low-carb, high-protein meals with lots of vegetables.";
                dietrecommendation2 = "Calories: 8,400–11,200, Protein: 700–840 g, Carbs: 700–910 g, Fat: 210–350 g.";
            }
        } else if (goal.equals("Maintain Weight")) {
            diet_label = "Recommended Diet:";
            if (bmi < 18.5) {
                dietrecommendation1 = "Calories: 2,000–2,300, Protein: 60–100 g, Carbs: 250–300 g, Fat: 60–80 g.";
                dietrecommendation3 = "Eat nutrient-dense meals with a focus on healthy fats and carbs.";
                dietrecommendation2 = "Calories: 14,000–16,100, Protein: 420–700 g, Carbs: 1,750–2,100 g, Fat: 420–560 g.";
            } else if (bmi < 25) {
                dietrecommendation1 = "Calories: 2,000–2,500, Protein: 70–110 g, Carbs: 250–350 g, Fat: 60–90 g.";
                dietrecommendation3 = "Focus on balance: lean protein, whole grains, and vegetables.";
                dietrecommendation2 = "Calories: 14,000–17,500, Protein: 490–770 g, Carbs: 1,750–2,450 g, Fat: 420–630 g.";
            } else if (bmi < 30) {
                dietrecommendation1 = "Calories: 1,800–2,300, Protein: 80–120 g, Carbs: 200–300 g, Fat: 50–80 g.";
                dietrecommendation3 = "Include moderate portions of lean proteins and low-glycemic carbs.";
                dietrecommendation2 = "Calories: 12,600–16,100, Protein: 560–840 g, Carbs: 1,400–2,100 g, Fat: 350–560 g.";
            } else {
                dietrecommendation1 = "Calories: 1,600–2,200, Protein: 90–130 g, Carbs: 150–250 g, Fat: 40–70 g.";
                dietrecommendation3 = "Focus on whole foods, avoiding excess fats and sugars.";
                dietrecommendation2 = "Calories: 11,200–15,400, Protein: 630–910 g, Carbs: 1,050–1,750 g, Fat: 280–490 g.";
            }
        }

        label_diet.setText(diet_label);
        meal_recommendation1.setText(dietrecommendation1);
        meal_recommendation2.setText(dietrecommendation2);
        meal_recommendation.setText(dietrecommendation3);
    }

    private void populateWeeks() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = LocalDate.of(2024, 12, 1);

        ArrayList<String> weeklyRanges = new ArrayList<>();

        while (startDate.isBefore(endDate)) {
            LocalDate weekEnd = startDate.plusDays(6);
            if (weekEnd.isAfter(endDate)) {
                weekEnd = endDate;
            }
            String range = startDate.format(formatter) + " to " + weekEnd.format(formatter);
            weeklyRanges.add(range);
            startDate = startDate.plusWeeks(1);
        }

        for (String range : weeklyRanges) {
            weeks_cbox.addItem(range);
        }
    }

    private void showData() {
        pieChart1.clearData();

        String selectedWeek = (String) weeks_cbox.getSelectedItem();

        if (selectedWeek != null) {
            double calories = Math.random() * 15000 + 3500;
            double protein = Math.random() * 400 + 600;
            double carbohydrates = Math.random() * 1500 + 1000;
            double fat = Math.random() * 400 + 200;

            pieChart1.addData(new ModelPieChart("Calories", calories, new Color(83, 87, 166)));
            pieChart1.addData(new ModelPieChart("Protein", protein, new Color(126, 148, 191)));
            pieChart1.addData(new ModelPieChart("Carbs", carbohydrates, new Color(167, 203, 217)));
            pieChart1.addData(new ModelPieChart("Fat", fat, new Color(216,225,229)));
        }
        pieChart1.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home_background = new Resources.components.PanelBorder();
        profile_panel = new javax.swing.JPanel();
        user_profile_icon = new javax.swing.JLabel();
        name_profile = new javax.swing.JLabel();
        username_profile = new javax.swing.JLabel();
        email_profile = new javax.swing.JLabel();
        height_profile = new javax.swing.JLabel();
        weight_profile = new javax.swing.JLabel();
        bmi_profile = new javax.swing.JLabel();
        classification_profile = new javax.swing.JLabel();
        profile_background = new Resources.components.PanelBorder();
        profile_edit_btn = new javax.swing.JButton();
        goal_btn = new javax.swing.JButton();
        profile_security_btn = new javax.swing.JButton();
        profile_delete_btn = new javax.swing.JButton();
        profile_label = new javax.swing.JLabel();
        motivation_panel = new Resources.components.PanelBorder();
        motivation_label = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        bmi_result = new javax.swing.JLabel();
        classification_result = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        healthy_range = new javax.swing.JLabel();
        weight_needs = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        complete_exercise_panel = new Resources.components.PanelBorder();
        complete_exercise_icon = new javax.swing.JLabel();
        exe_label2 = new javax.swing.JLabel();
        execompleted_label = new javax.swing.JLabel();
        exe_label3 = new javax.swing.JLabel();
        complete_meal_panel = new Resources.components.PanelBorder();
        exeincomplete_label = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        complete_note_panel = new Resources.components.PanelBorder();
        exercise_recommendation1 = new javax.swing.JLabel();
        exercise_recommendation = new javax.swing.JLabel();
        exercise_recommendation2 = new javax.swing.JLabel();
        label_exercise = new javax.swing.JLabel();
        incomplete_exercise_panel = new Resources.components.PanelBorder();
        meal_label1 = new javax.swing.JLabel();
        meal_label2 = new javax.swing.JLabel();
        mealcompleted_label = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        incomplete_meal_panel = new Resources.components.PanelBorder();
        mealincomplete_label = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        incomplete_note_panel = new Resources.components.PanelBorder();
        label_diet = new javax.swing.JLabel();
        meal_recommendation1 = new javax.swing.JLabel();
        meal_recommendation2 = new javax.swing.JLabel();
        label_diet1 = new javax.swing.JLabel();
        label_diet2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        meal_recommendation = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        motivation_exercise = new javax.swing.JLabel();
        piechart_panel = new Resources.components.PanelBorder();
        weeks_cbox = new javax.swing.JComboBox<>();
        pieChart1 = new Resources.components.PieChart();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home_background.setBackground(new java.awt.Color(255, 255, 255));
        home_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile_panel.setBackground(new java.awt.Color(255, 255, 255));
        profile_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        profile_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user_profile_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user_profile_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/user-female-icon.png"))); // NOI18N
        profile_panel.add(user_profile_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        name_profile.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        name_profile.setForeground(new java.awt.Color(29, 22, 22));
        name_profile.setText("(name)");
        profile_panel.add(name_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 340, -1));

        username_profile.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        username_profile.setForeground(new java.awt.Color(29, 22, 22));
        username_profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username_profile.setText("(username)");
        profile_panel.add(username_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 340, 20));

        email_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        email_profile.setForeground(new java.awt.Color(29, 22, 22));
        email_profile.setText("(email)");
        profile_panel.add(email_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 340, 20));

        height_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        height_profile.setForeground(new java.awt.Color(29, 22, 22));
        height_profile.setText("(height)");
        profile_panel.add(height_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 210, 20));

        weight_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        weight_profile.setForeground(new java.awt.Color(29, 22, 22));
        weight_profile.setText("(weight)");
        profile_panel.add(weight_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 130, 20));

        bmi_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        bmi_profile.setForeground(new java.awt.Color(29, 22, 22));
        bmi_profile.setText("(bmi)");
        profile_panel.add(bmi_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 130, 20));

        classification_profile.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        classification_profile.setForeground(new java.awt.Color(29, 22, 22));
        classification_profile.setText("(classification)");
        profile_panel.add(classification_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 210, 20));

        home_background.add(profile_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 520, 150));

        profile_background.setBackground(new java.awt.Color(114, 134, 211));
        profile_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile_edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-edit-idle.png"))); // NOI18N
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
        profile_background.add(profile_edit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 30, 30));

        goal_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/goal-idle.png"))); // NOI18N
        goal_btn.setBorder(null);
        goal_btn.setBorderPainted(false);
        goal_btn.setContentAreaFilled(false);
        goal_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                goal_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                goal_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                goal_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                goal_btnMouseReleased(evt);
            }
        });
        goal_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goal_btnActionPerformed(evt);
            }
        });
        profile_background.add(goal_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 30, 30));

        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-sec-idle.png"))); // NOI18N
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
        profile_background.add(profile_security_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 30, 30));

        profile_delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-delete-idle.png"))); // NOI18N
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
        profile_background.add(profile_delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 30, 30));

        profile_label.setBackground(new java.awt.Color(244, 237, 211));
        profile_label.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        profile_label.setForeground(new java.awt.Color(255, 242, 242));
        profile_label.setText("Profile Details");
        profile_background.add(profile_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 410, 30));

        home_background.add(profile_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 540, 170));

        motivation_panel.setBackground(new java.awt.Color(114, 134, 211));
        motivation_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        motivation_label.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        motivation_label.setForeground(new java.awt.Color(255, 242, 242));
        motivation_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        motivation_label.setText("(motivation message)");
        motivation_panel.add(motivation_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 30));

        home_background.add(motivation_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 640, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        label1.setForeground(new java.awt.Color(29, 22, 22));
        label1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label1.setText("Body Mass Index (BMI):");
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 170, 20));

        label2.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        label2.setForeground(new java.awt.Color(29, 22, 22));
        label2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label2.setText("Classification:");
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 170, 20));

        bmi_result.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        bmi_result.setForeground(new java.awt.Color(29, 22, 22));
        bmi_result.setText("(BMI)");
        jPanel1.add(bmi_result, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 170, 20));

        classification_result.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        classification_result.setForeground(new java.awt.Color(29, 22, 22));
        classification_result.setText("(classification)");
        jPanel1.add(classification_result, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 170, 20));

        label3.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        label3.setForeground(new java.awt.Color(29, 22, 22));
        label3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label3.setText("Healthy Weight Range:");
        jPanel1.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 170, 20));

        healthy_range.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        healthy_range.setForeground(new java.awt.Color(29, 22, 22));
        healthy_range.setText("(healthy weight range)");
        jPanel1.add(healthy_range, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 170, 20));

        weight_needs.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        weight_needs.setForeground(new java.awt.Color(29, 22, 22));
        weight_needs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weight_needs.setText("(gain/lose needs)");
        jPanel1.add(weight_needs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 450, 30));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/bmi-element-1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 150, 130));

        home_background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 640, 160));

        complete_exercise_panel.setBackground(new java.awt.Color(114, 134, 211));
        complete_exercise_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        complete_exercise_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        complete_exercise_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/exercise-element-1.png"))); // NOI18N
        complete_exercise_panel.add(complete_exercise_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        exe_label2.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        exe_label2.setForeground(new java.awt.Color(255, 255, 255));
        exe_label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exe_label2.setText("Exercises");
        complete_exercise_panel.add(exe_label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 90, 30));

        execompleted_label.setFont(new java.awt.Font("Cascadia Mono", 1, 28)); // NOI18N
        execompleted_label.setForeground(new java.awt.Color(255, 255, 255));
        execompleted_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        execompleted_label.setText("(Number)");
        complete_exercise_panel.add(execompleted_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 150, 60));

        exe_label3.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        exe_label3.setForeground(new java.awt.Color(255, 255, 255));
        exe_label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exe_label3.setText("Completed");
        complete_exercise_panel.add(exe_label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 90, 30));

        home_background.add(complete_exercise_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 170, 160));

        complete_meal_panel.setBackground(new java.awt.Color(142, 167, 233));
        complete_meal_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exeincomplete_label.setFont(new java.awt.Font("Cascadia Mono", 1, 28)); // NOI18N
        exeincomplete_label.setForeground(new java.awt.Color(242, 242, 242));
        exeincomplete_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exeincomplete_label.setText("(Number)");
        complete_meal_panel.add(exeincomplete_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 150, 60));

        jLabel11.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(242, 242, 242));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Exercises");
        complete_meal_panel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 100, 30));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/incomplete-exercise-icon.png"))); // NOI18N
        complete_meal_panel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel12.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(242, 242, 242));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Incomplete");
        complete_meal_panel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 100, 30));

        home_background.add(complete_meal_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 180, 160));

        complete_note_panel.setBackground(new java.awt.Color(190, 205, 242));
        complete_note_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exercise_recommendation1.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        exercise_recommendation1.setForeground(new java.awt.Color(102, 102, 102));
        exercise_recommendation1.setText("(recommendation)");
        complete_note_panel.add(exercise_recommendation1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 470, -1));

        exercise_recommendation.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        exercise_recommendation.setForeground(new java.awt.Color(51, 51, 51));
        exercise_recommendation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exercise_recommendation.setText("(recommendation)");
        complete_note_panel.add(exercise_recommendation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 520, 40));

        exercise_recommendation2.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        exercise_recommendation2.setForeground(new java.awt.Color(102, 102, 102));
        exercise_recommendation2.setText("(recommendation)");
        complete_note_panel.add(exercise_recommendation2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 470, -1));

        label_exercise.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        label_exercise.setForeground(new java.awt.Color(51, 51, 51));
        label_exercise.setText("Recommendations:");
        complete_note_panel.add(label_exercise, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 500, 20));

        home_background.add(complete_note_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 530, 130));

        incomplete_exercise_panel.setBackground(new java.awt.Color(190, 205, 242));
        incomplete_exercise_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        meal_label1.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        meal_label1.setForeground(new java.awt.Color(102, 102, 102));
        meal_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        meal_label1.setText("Completed");
        incomplete_exercise_panel.add(meal_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, 30));

        meal_label2.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        meal_label2.setForeground(new java.awt.Color(102, 102, 102));
        meal_label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        meal_label2.setText("Meals");
        incomplete_exercise_panel.add(meal_label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 30));

        mealcompleted_label.setFont(new java.awt.Font("Cascadia Mono", 1, 28)); // NOI18N
        mealcompleted_label.setForeground(new java.awt.Color(102, 102, 102));
        mealcompleted_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mealcompleted_label.setText("(Number)");
        incomplete_exercise_panel.add(mealcompleted_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 150, 60));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/meal-element1.png"))); // NOI18N
        incomplete_exercise_panel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        home_background.add(incomplete_exercise_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 170, 160));

        incomplete_meal_panel.setBackground(new java.awt.Color(142, 167, 233));
        incomplete_meal_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mealincomplete_label.setFont(new java.awt.Font("Cascadia Mono", 1, 28)); // NOI18N
        mealincomplete_label.setForeground(new java.awt.Color(246, 246, 246));
        mealincomplete_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mealincomplete_label.setText("(Number)");
        incomplete_meal_panel.add(mealincomplete_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 150, 60));

        jLabel14.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(246, 246, 246));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Incomplete");
        incomplete_meal_panel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 30));

        jLabel13.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(246, 246, 246));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Meals");
        incomplete_meal_panel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 80, 30));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elements/incomplete-meal-icon.png"))); // NOI18N
        incomplete_meal_panel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        home_background.add(incomplete_meal_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 180, 160));

        incomplete_note_panel.setBackground(new java.awt.Color(114, 134, 211));
        incomplete_note_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_diet.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        label_diet.setForeground(new java.awt.Color(255, 255, 255));
        label_diet.setText("Recommendations:");
        incomplete_note_panel.add(label_diet, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 500, 20));

        meal_recommendation1.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        meal_recommendation1.setForeground(new java.awt.Color(255, 255, 255));
        meal_recommendation1.setText("(recommendation)");
        incomplete_note_panel.add(meal_recommendation1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 50, 500, 30));

        meal_recommendation2.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        meal_recommendation2.setForeground(new java.awt.Color(255, 255, 255));
        meal_recommendation2.setText("(recommendation)");
        incomplete_note_panel.add(meal_recommendation2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 95, 500, 30));

        label_diet1.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        label_diet1.setForeground(new java.awt.Color(255, 255, 255));
        label_diet1.setText("Weekly:");
        incomplete_note_panel.add(label_diet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 75, 500, 30));

        label_diet2.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        label_diet2.setForeground(new java.awt.Color(255, 255, 255));
        label_diet2.setText("Daily:");
        incomplete_note_panel.add(label_diet2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, 500, 30));

        home_background.add(incomplete_note_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 530, 130));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        meal_recommendation.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        meal_recommendation.setForeground(new java.awt.Color(102, 102, 102));
        meal_recommendation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        meal_recommendation.setText("(recommendation)");
        jPanel4.add(meal_recommendation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 510, 30));

        home_background.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, 520, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        motivation_exercise.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        motivation_exercise.setForeground(new java.awt.Color(102, 102, 102));
        motivation_exercise.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        motivation_exercise.setText("(message)");
        jPanel3.add(motivation_exercise, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 510, 30));

        home_background.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 520, 40));

        piechart_panel.setBackground(new java.awt.Color(224, 224, 255));
        piechart_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        weeks_cbox.setBackground(new java.awt.Color(204, 204, 204));
        weeks_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 11)); // NOI18N
        piechart_panel.add(weeks_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, -1));

        pieChart1.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        piechart_panel.add(pieChart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 310, 260));

        home_background.add(piechart_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 230, 340, 310));

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Total Macronutrients Consumed by this Week");
        home_background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 210, 340, -1));

        add(home_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void profile_edit_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_edit_btnMouseEntered
        profile_edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-edit-hover.png")));
    }//GEN-LAST:event_profile_edit_btnMouseEntered

    private void profile_edit_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_edit_btnMouseExited
        profile_edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-edit-idle.png")));
    }//GEN-LAST:event_profile_edit_btnMouseExited

    private void profile_edit_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_edit_btnMousePressed
        profile_edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-edit-click.png")));
    }//GEN-LAST:event_profile_edit_btnMousePressed

    private void profile_edit_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_edit_btnMouseReleased
        profile_edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-edit-hover.png")));
    }//GEN-LAST:event_profile_edit_btnMouseReleased

    private void profile_edit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_edit_btnActionPerformed
        UserEditForm userEditForm = new UserEditForm(this, userId);
        userEditForm.setVisible(true);
    }//GEN-LAST:event_profile_edit_btnActionPerformed

    private void profile_security_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_security_btnMouseEntered
        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-sec-hover.png")));
    }//GEN-LAST:event_profile_security_btnMouseEntered

    private void profile_security_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_security_btnMouseExited
        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-sec-idle.png")));
    }//GEN-LAST:event_profile_security_btnMouseExited

    private void profile_security_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_security_btnMousePressed
        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-sec-click.png")));
    }//GEN-LAST:event_profile_security_btnMousePressed

    private void profile_security_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_security_btnMouseReleased
        profile_security_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-sec-hover.png")));
    }//GEN-LAST:event_profile_security_btnMouseReleased

    private void profile_security_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_security_btnActionPerformed
        PasswordForm passwordForm = new PasswordForm(userId);
        passwordForm.setVisible(true);
    }//GEN-LAST:event_profile_security_btnActionPerformed

    private void profile_delete_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_delete_btnMouseEntered
        profile_delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-delete-hover.png")));
    }//GEN-LAST:event_profile_delete_btnMouseEntered

    private void profile_delete_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_delete_btnMouseExited
        profile_delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-delete-idle.png")));
    }//GEN-LAST:event_profile_delete_btnMouseExited

    private void profile_delete_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_delete_btnMousePressed
        profile_delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-delete-click.png")));
    }//GEN-LAST:event_profile_delete_btnMousePressed

    private void profile_delete_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_delete_btnMouseReleased
        profile_delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/user-delete-hover.png")));
    }//GEN-LAST:event_profile_delete_btnMouseReleased

    private void profile_delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_delete_btnActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account?",
                "Confirm Delete?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            DeleteForm deleteForm = new DeleteForm(userId);
            deleteForm.setVisible(true);
        }
    }//GEN-LAST:event_profile_delete_btnActionPerformed

    private void goal_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goal_btnMouseEntered
        goal_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/goal-hover.png")));
    }//GEN-LAST:event_goal_btnMouseEntered

    private void goal_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goal_btnMouseExited
        goal_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/goal-idle.png")));
    }//GEN-LAST:event_goal_btnMouseExited

    private void goal_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goal_btnMousePressed
        goal_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/goal-click.png")));
    }//GEN-LAST:event_goal_btnMousePressed

    private void goal_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goal_btnMouseReleased
        goal_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/goal-hover.png")));
    }//GEN-LAST:event_goal_btnMouseReleased

    private void goal_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goal_btnActionPerformed
        GoalForm goalForm = new GoalForm(userId, this);
        goalForm.setVisible(true);
    }//GEN-LAST:event_goal_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bmi_profile;
    private javax.swing.JLabel bmi_result;
    private javax.swing.JLabel classification_profile;
    private javax.swing.JLabel classification_result;
    private javax.swing.JLabel complete_exercise_icon;
    private Resources.components.PanelBorder complete_exercise_panel;
    private Resources.components.PanelBorder complete_meal_panel;
    private Resources.components.PanelBorder complete_note_panel;
    private javax.swing.JLabel email_profile;
    private javax.swing.JLabel exe_label2;
    private javax.swing.JLabel exe_label3;
    private javax.swing.JLabel execompleted_label;
    private javax.swing.JLabel exeincomplete_label;
    private javax.swing.JLabel exercise_recommendation;
    private javax.swing.JLabel exercise_recommendation1;
    private javax.swing.JLabel exercise_recommendation2;
    private javax.swing.JButton goal_btn;
    private javax.swing.JLabel healthy_range;
    private javax.swing.JLabel height_profile;
    private Resources.components.PanelBorder home_background;
    private Resources.components.PanelBorder incomplete_exercise_panel;
    private Resources.components.PanelBorder incomplete_meal_panel;
    private Resources.components.PanelBorder incomplete_note_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label_diet;
    private javax.swing.JLabel label_diet1;
    private javax.swing.JLabel label_diet2;
    private javax.swing.JLabel label_exercise;
    private javax.swing.JLabel meal_label1;
    private javax.swing.JLabel meal_label2;
    private javax.swing.JLabel meal_recommendation;
    private javax.swing.JLabel meal_recommendation1;
    private javax.swing.JLabel meal_recommendation2;
    private javax.swing.JLabel mealcompleted_label;
    private javax.swing.JLabel mealincomplete_label;
    private javax.swing.JLabel motivation_exercise;
    private javax.swing.JLabel motivation_label;
    private Resources.components.PanelBorder motivation_panel;
    private javax.swing.JLabel name_profile;
    private Resources.components.PieChart pieChart1;
    private Resources.components.PanelBorder piechart_panel;
    private Resources.components.PanelBorder profile_background;
    private javax.swing.JButton profile_delete_btn;
    private javax.swing.JButton profile_edit_btn;
    private javax.swing.JLabel profile_label;
    private javax.swing.JPanel profile_panel;
    private javax.swing.JButton profile_security_btn;
    private javax.swing.JLabel user_profile_icon;
    private javax.swing.JLabel username_profile;
    private javax.swing.JComboBox<String> weeks_cbox;
    private javax.swing.JLabel weight_needs;
    private javax.swing.JLabel weight_profile;
    // End of variables declaration//GEN-END:variables
}
