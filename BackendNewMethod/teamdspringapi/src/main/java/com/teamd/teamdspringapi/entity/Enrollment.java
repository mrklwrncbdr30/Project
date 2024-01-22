package com.teamd.teamdspringapi.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Enrollment {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long EnrollmentID;
private Long courseId;
private Long UserID;
private Long InstructorID;
private Long SupportID;
private Date enrollmentDate;
private String Cancelled;
private String CancellationReason;



   

    public Long getEnrollmentID() {
        return this.EnrollmentID;
    }

    public void setEnrollmentID(Long EnrollmentID) {
        this.EnrollmentID = EnrollmentID;
    }

    public Long getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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

    public Date getEnrollmentDate() {
        return this.enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getCancelled() {
        return this.Cancelled;
    }

    public void setCancelled(String Cancelled) {
        this.Cancelled = Cancelled;
    }

    public String getCancellationReason() {
        return this.CancellationReason;
    }

    public void setCancellationReason(String CancellationReason) {
        this.CancellationReason = CancellationReason;
    }

}
