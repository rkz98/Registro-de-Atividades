package com.rkz98.registrodeatividades.Models.Enum;

public enum Days {
    MONDAY("Segunda-feira"),
    TUESDAY("Terça-feira"),
    WEDNESDAY("Quarta-feira"),
    THURSDAY("Quinta-feira"),
    FRIDAY("Sexta-feira"),
    SATURDAY("Sábado"),
    SUNDAY("Domingo");

    private String value;

    Days(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
