package com.teamd.teamdspringapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Badge {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long BadgeID;
private String BadgeImage;
private String BadgeName;




    public Long getBadgeID() {
        return this.BadgeID;
    }

    public void setBadgeID(Long BadgeID) {
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
