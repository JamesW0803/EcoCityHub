package com.example.ecocityhub;

public class Item {
    private int imageItem;
    private int imageProfile;
    private int imageFavourite;
    private String username;
    private String itemDescription;
    private String type;

    public Item(){ }

    public Item (int imageItem, int imageProfile, int imageFavourite, String username, String itemDescription, String type) {
        this.imageItem = imageItem;
        this.imageProfile = imageProfile;
        this.imageFavourite = imageFavourite;
        this.username = username;
        this.itemDescription = itemDescription;
        this.type = type;
    }

    public int getImageItem() {
        return imageItem;
    }

    public void setImageItem(int imageItem) {
        this.imageItem = imageItem;
    }

    public int getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(int imageProfile) {
        this.imageProfile = imageProfile;
    }

    public int getImageFavourite() {
        return imageFavourite;
    }

    public void setImageFavourite(int imageFavourite) {
        this.imageFavourite = imageFavourite;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}