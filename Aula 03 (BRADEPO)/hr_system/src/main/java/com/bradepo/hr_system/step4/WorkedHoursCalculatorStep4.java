package com.bradepo.hr_system.step4;

public class WorkedHoursCalculatorStep4 implements InterfaceWorkedHoursCalculatorStep4 {
    // Calcular horas trabalhadas
    public int calculateWorkedHours(int entryTime, int exitTime) {
        return (exitTime < entryTime) ? (24 - entryTime) + exitTime : exitTime - entryTime;
    }

    @Override
    public void connect(PaymentCalculatorStep4 paymentCalculator) {
        paymentCalculator.update(calculateWorkedHours(paymentCalculator.getEntryTime(), paymentCalculator.getExitTime()));
    }
}
