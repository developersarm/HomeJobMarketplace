package org.care.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Job {
    private int jobId;
    private String title;
    //    private int postedBy;
    private Timestamp startDate;
    private Timestamp endDate;
    private double payPerHour;
    private Status status;
    private Seeker seeker;
    private Set<JobApplication> jobAppSet = new HashSet<>();

//    public Job(int jobId, String title, Timestamp startDate, Timestamp endDate, double payPerHour) {
//        this.jobId = jobId;
//        this.title = title;
//        this.postedBy = 0;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.payPerHour = payPerHour;
//    }

    public Job(String title, Seeker seeker, Timestamp startDate, Timestamp endDate, double payPerHour) {
        this.title = title;
        this.seeker = seeker;
        this.startDate = startDate;
        this.endDate = endDate;
        this.payPerHour = payPerHour;
        this.status = Status.ACTIVE;
    }

    public Job(int jobId, String title, Seeker seeker, Timestamp startDate, Timestamp endDate, double payPerHour) {
        this(title, seeker, startDate, endDate, payPerHour);
        this.jobId = jobId;
    }

    public Job(int jobId, String title, Seeker seeker, Timestamp startDate, Timestamp endDate, double payPerHour, Status status) {
        this.jobId = jobId;
        this.title = title;
        this.seeker = seeker;
        this.startDate = startDate;
        this.endDate = endDate;
        this.payPerHour = payPerHour;
        this.status = status;
    }

    public Seeker getSeeker() {
        return seeker;
    }

    public void setSeeker(Seeker seeker) {
        this.seeker = seeker;
    }

    public Set<JobApplication> getJobAppSet() {
        return jobAppSet;
    }

    public void setJobAppSet(Set<JobApplication> jobAppSet) {
        this.jobAppSet = jobAppSet;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public int getPostedBy() {
//        return postedBy;
//    }

    //    public void setPostedBy(int postedBy) {
//        this.postedBy = postedBy;
//    }
//
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public double getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(double payPerHour) {
        this.payPerHour = payPerHour;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {ACTIVE, INACTIVE}
}
