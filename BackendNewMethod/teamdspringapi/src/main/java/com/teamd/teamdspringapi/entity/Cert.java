package com.teamd.teamdspringapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Cert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long certID;

    @Lob
    private byte[] file;

    // Constructors, getters, and setters

    public long getCertID() {
        return this.certID;
    }

    public void setCertID(long certID) {
        this.certID = certID;
    }

    public byte[] getFile() {
        return this.file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
