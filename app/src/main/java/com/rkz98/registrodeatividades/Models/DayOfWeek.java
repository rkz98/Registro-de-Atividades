package com.rkz98.registrodeatividades.Models;

import com.rkz98.registrodeatividades.Models.Enum.Days;

public class DayOfWeek {

    private Days day;
    private Integer quantityHours;

    public DayOfWeek(Days day, Integer quantityHours) {
        this.day = day;
        this.quantityHours = quantityHours;
    }

    public Days getDay() {
        return day;
    }

    public void setDay(Days day) {
        this.day = day;
    }

    public Integer getQuantityHours() {
        return quantityHours;
    }

    public void setQuantityHours(Integer quantityHours) {
        this.quantityHours = quantityHours;
    }
}
