package com.rkz98.registrodeatividades.Models;

public class DayOfWeek {

    private String day;
    private Integer quantityHours;

    public DayOfWeek() {

    }

    public DayOfWeek(String day, Integer quantityHours) {
        this.day = day;
        this.quantityHours = quantityHours;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getQuantityHours() {
        return quantityHours;
    }

    public void setQuantityHours(Integer quantityHours) {
        this.quantityHours = quantityHours;
    }
}
