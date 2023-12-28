package rewards;

public class Rewards {
    private int resourceId;
    private String title;
    private String point;

    public Rewards(int resourceId, String title, String point) {
        this.resourceId = resourceId;
        this.title = title;
        this.point = point;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
