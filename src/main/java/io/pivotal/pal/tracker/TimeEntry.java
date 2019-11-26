package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {
    private Long id;
    private Long projectId;
    private Long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry(Long id, Long projectId, Long userId, LocalDate date, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(Long projectId, Long userId, LocalDate date, int hours) {
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry() {

    }
    /* public TimeEntry(long projectId, long userId, LocalDate parse, int i) {
    }*/

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeEntry)) return false;

        TimeEntry timeEntry = (TimeEntry) o;

        if (getHours() != timeEntry.getHours()) return false;
        if (getId() != null ? !getId().equals(timeEntry.getId()) : timeEntry.getId() != null) return false;
        if (getProjectId() != null ? !getProjectId().equals(timeEntry.getProjectId()) : timeEntry.getProjectId() != null)
            return false;
        if (getUserId() != null ? !getUserId().equals(timeEntry.getUserId()) : timeEntry.getUserId() != null)
            return false;
        return getDate() != null ? getDate().equals(timeEntry.getDate()) : timeEntry.getDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getProjectId() != null ? getProjectId().hashCode() : 0);
        result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + getHours();
        return result;
    }

    @Override
    public String toString() {
        return "TimeEntry{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", userId=" + userId +
                ", date=" + date +
                ", hours=" + hours +
                '}';
    }
}
