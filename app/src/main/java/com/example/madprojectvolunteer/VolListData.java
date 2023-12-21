package com.example.madprojectvolunteer;

import java.time.LocalDate;
import java.time.LocalTime;

public class VolListData {
    String title, location, date, time;
    Boolean isFav;

    public VolListData(String title, String location, String date, String time, Boolean isFav) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.isFav = isFav;
    }
}

