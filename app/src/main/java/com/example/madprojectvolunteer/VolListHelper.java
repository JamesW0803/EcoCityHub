package com.example.madprojectvolunteer;

public class VolListHelper {
    private String title;
    private String location;
    private String dateActivity;
    private String key;
    private String startTimeActivity;
    private String organizerName;

    public VolListHelper(){
    }

    public VolListHelper(String title, String location, String dateActivity, String startTimeActivity, String key, String organizerName) {
        this.title = title;
        this.location = location;
        this.startTimeActivity = startTimeActivity;
        this.dateActivity = dateActivity;
        this.key = key;
        this.organizerName = organizerName;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getStartTimeActivity(){
        return startTimeActivity;
    }

    public String getDateActivity() {
        return dateActivity;
    }

    public String getKey(){
        return key;
    }

    public String getOrganizerName() { return organizerName; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public void setDateActivity(String date) {
        this.dateActivity = date;
    }

    public void setKey(String key){
        this.key = key;
    }

    public void setStartTimeActivity(String startTime){
        this.startTimeActivity = startTime;
    }
    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }
}