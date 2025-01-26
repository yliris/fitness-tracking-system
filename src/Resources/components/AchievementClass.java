package Resources.components;

public class AchievementClass {
    private String title;
    private String description;
    private int milestone;

    public AchievementClass(String title, String description, int milestone) {
        this.title = title;
        this.description = description;
        this.milestone = milestone;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getMilestone() {
        return milestone;
    }
}
