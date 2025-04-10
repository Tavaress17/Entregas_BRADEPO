package com.bradepo.hr_system.step2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class PaymentCalculatorStep2 {
    int entryTime;
    int exitTime;
    int workedShifts;
    double workedHoursValue;
    // Calcular valor do pagamento
    public void calculatePayment(WorkedHoursCalculatorStep2 workedHoursCalculator) {
        int totalWorkedTime = this.workedShifts * workedHoursCalculator.calculateWorkedHours(this.entryTime, this.exitTime);
        System.out.printf("\nO valor do pagamento será de R$ %.2f\n", totalWorkedTime * this.workedHoursValue);
    }
}
