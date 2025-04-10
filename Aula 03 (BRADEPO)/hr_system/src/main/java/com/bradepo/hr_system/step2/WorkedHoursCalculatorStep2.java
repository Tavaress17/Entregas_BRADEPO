package com.bradepo.hr_system.step2;

public class WorkedHoursCalculatorStep2 {
    // Calcular horas trabalhadas
    public int calculateWorkedHours(int entryTime, int exitTime) {
        return (exitTime < entryTime) ? (24 - entryTime) + exitTime : exitTime - entryTime;
    }
}
