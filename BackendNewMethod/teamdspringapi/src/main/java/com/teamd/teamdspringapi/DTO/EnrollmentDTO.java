package com.teamd.teamdspringapi.DTO;

import java.time.LocalDate;

public class EnrollmentDTO {
    private long EnrollmentID;
    private long courseId;
    private long UserID;
    private long InstructorID;
    private long SupportID;
    private LocalDate EnrollmentDate;
    private String Cancelled;
    private String CancellationReason;


    public long getEnrollmentID() {
        return this.EnrollmentID;
    }

    public void setEnrollmentID(long EnrollmentID) {
        this.EnrollmentID = EnrollmentID;
    }

    public long getCourseId() {
        return this.courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getUserID() {
        return this.UserID;
    }

    public void setUserID(long UserID) {
        this.UserID = UserID;
    }

    public long getInstructorID() {
        return this.InstructorID;
    }

    public void setInstructorID(long InstructorID) {
        this.InstructorID = InstructorID;
    }

    public long getSupportID() {
        return this.SupportID;
    }

    public void setSupportID(long SupportID) {
        this.SupportID = SupportID;
    }

    public LocalDate getEnrollmentDate() {
        return this.EnrollmentDate;
    }

    public void setEnrollmentDate(LocalDate EnrollmentDate) {
        this.EnrollmentDate = EnrollmentDate;
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
