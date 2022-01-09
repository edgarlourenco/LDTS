package com.aor.refactoring.example6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Tree {
    public LocalDateTime plantedAt;
    public Location location;
    private List<LocalDateTime> appraisalDates;

    public Tree(LocalDateTime plantedAt, String locationLatitude, String locationLongitude, String locationName){
        this.plantedAt = plantedAt;
        this.setLocation(locationLatitude, locationLongitude, locationName);
        this.appraisalDates = new ArrayList<>();
    }

    public void setLocation(String locationLatitude, String locationLongitude, String locationName){
        this.location = new Location(locationLatitude, locationLongitude, locationName);
    }

    @Override
    public String toString() {
        return "Tree planted at " + this.plantedAt.toString() + " in location " +
                this.location.getLocationLatitude() + "," + this.location.getLocationLongitude() + " (" +
                this.location.getLocationName() + ")";
    }

    void addAppraisal(LocalDateTime appraisalDate) {
        this.appraisalDates.add(appraisalDate);
    }

    public List<LocalDateTime> getAppraisals(){
        return this.appraisalDates;
    }

    public boolean isNextAppraisalOverdue(){
        LocalDateTime today = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime latestAppraisalDate = today;

        if (this.appraisalDates.size() > 0) {
            latestAppraisalDate = this.appraisalDates.get(0);
        }
        for(LocalDateTime appraisalDate : this.appraisalDates) {
            if (latestAppraisalDate.isBefore(appraisalDate)) {
                latestAppraisalDate = appraisalDate;
            }
        }

        // Calculate next appraisal date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Date.from(latestAppraisalDate.atZone(ZoneId.systemDefault()).toInstant()));
        calendar.add(Calendar.MONTH, 3);

        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 2);

        LocalDateTime nextAppraisalDate = calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        // Appraisal is only overdue if its date is in the past
        return nextAppraisalDate.isBefore(today);
    }
}
