package com.example.madprojectvolunteer;

public class UploadCVHelper {

    public String username, activityKey, status, fileName, url;

    public UploadCVHelper(){}

    public UploadCVHelper(String activityKey, String status, String fileName, String url, String username) {
        this.activityKey = activityKey;
        this.status = status;
        this.fileName = fileName;
        this.url = url;
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UploadCVHelper(String fileName, String url) {
        this.fileName = fileName;
        this.url = url;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getActivityKey() {
        return activityKey;
    }

    public void setActivityKey(String activityKey) {
        this.activityKey = activityKey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
