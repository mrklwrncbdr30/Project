package com.teamd.teamdspringapi.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Badge {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@NonNull
private long BadgeID;
private String badge_image;
private String badge_name;

    public long getBadgeID() {
        return this.BadgeID;
    }

    public void setBadgeID(long BadgeID) {
        this.BadgeID = BadgeID;
    }

    public String getBadge_image() {
        return this.badge_image;
    }

    public void setBadge_image(String badge_image) {
        this.badge_image = badge_image;
    }

    public String getBadge_name() {
        return this.badge_name;
    }

    public void setBadge_name(String badge_name) {
        this.badge_name = badge_name;
    }

}
