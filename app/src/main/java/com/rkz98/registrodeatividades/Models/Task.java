package com.rkz98.registrodeatividades.Models;

public class Task {

    private String dayOfWeek;
    private Integer quantityHours;
    private String taskEnd;

    public Task() {

    }

    public Task(String taskEnd, String dayOfWeek, Integer quantityHours) {
        this.taskEnd = taskEnd;
        this.dayOfWeek = dayOfWeek;
        this.quantityHours = quantityHours;
    }

    public String getTaskEnd() { return taskEnd; }

    public void setTaskEnd(String taskEnd) { this.taskEnd = taskEnd; }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getQuantityHours() {
        return quantityHours;
    }

    public void setQuantityHours(Integer quantityHours) {
        this.quantityHours = quantityHours;
    }
}
