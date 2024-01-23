package com.teamd.teamdspringapi.DTO;

import java.sql.Date;

public class CertificationDTO {
private Long CertificateID;
private Long CertificateSerialNo;
private Long course_id;
private Long UserID;
private Long InstructorID;
private Long SupportID;
private Date DateIssued;
private String CertificateFile;
private Long BadgeID;
private String Criteria;



    public Long getCertificateID() {
        return this.CertificateID;
    }

    public void setCertificateID(Long CertificateID) {
        this.CertificateID = CertificateID;
    }

    public Long getCertificateSerialNo() {
        return this.CertificateSerialNo;
    }

    public void setCertificateSerialNo(Long CertificateSerialNo) {
        this.CertificateSerialNo = CertificateSerialNo;
    }

    public Long getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public Long getUserID() {
        return this.UserID;
    }

    public void setUserID(Long UserID) {
        this.UserID = UserID;
    }

    public Long getInstructorID() {
        return this.InstructorID;
    }

    public void setInstructorID(Long InstructorID) {
        this.InstructorID = InstructorID;
    }

    public Long getSupportID() {
        return this.SupportID;
    }

    public void setSupportID(Long SupportID) {
        this.SupportID = SupportID;
    }

    public Date getDateIssued() {
        return this.DateIssued;
    }

    public void setDateIssued(Date DateIssued) {
        this.DateIssued = DateIssued;
    }

    public String getCertificateFile() {
        return this.CertificateFile;
    }

    public void setCertificateFile(String CertificateFile) {
        this.CertificateFile = CertificateFile;
    }

    public Long getBadgeID() {
        return this.BadgeID;
    }

    public void setBadgeID(Long BadgeID) {
        this.BadgeID = BadgeID;
    }

    public String getCriteria() {
        return this.Criteria;
    }

    public void setCriteria(String Criteria) {
        this.Criteria = Criteria;
    }

}
