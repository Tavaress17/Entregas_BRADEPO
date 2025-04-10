package com.bradepo.hr_system.step3;

public class WorkedHoursCalculatorStep3 {
    // Calcular horas trabalhadas
    public int calculateWorkedHours(int entryTime, int exitTime) {
        return (exitTime < entryTime) ? (24 - entryTime) + exitTime : exitTime - entryTime;
    }

    public void connect(PaymentCalculatorStep3 paymentCalculator) {
        paymentCalculator.update(calculateWorkedHours(paymentCalculator.getEntryTime(), paymentCalculator.getExitTime()));
    }
}
