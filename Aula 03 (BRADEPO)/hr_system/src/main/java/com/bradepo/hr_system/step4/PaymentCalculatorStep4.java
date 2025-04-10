package com.bradepo.hr_system.step4;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class PaymentCalculatorStep4 implements InterfacePaymentCalculatorStep4 {
    int entryTime;
    int exitTime;
    int workedShifts;
    double workedHoursValue;
    // Calcular valor do pagamento
    public void calculatePayment(int workedTime) {
        System.out.printf("\nO valor do pagamento será de R$ %.2f\n", (workedTime * this.workedShifts) * this.workedHoursValue);
    }

    @Override
    public void update(int workedTime) {
        this.calculatePayment(workedTime);
    }
}
