package com.teamd.teamdspringapi.DTO;

public class BadgeDTO {

private int BadgeID;
private String BadgeImage;
private String BadgeName;



    public int getBadgeID() {
        return this.BadgeID;
    }

    public void setBadgeID(int BadgeID) {
        this.BadgeID = BadgeID;
    }

    public String getBadgeImage() {
        return this.BadgeImage;
    }

    public void setBadgeImage(String BadgeImage) {
        this.BadgeImage = BadgeImage;
    }

    public String getBadgeName() {
        return this.BadgeName;
    }

    public void setBadgeName(String BadgeName) {
        this.BadgeName = BadgeName;
    }

}
