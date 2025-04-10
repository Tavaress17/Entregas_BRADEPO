package com.bradepo.financial_system.step2;

public class CompoundInterestCalculatorStep2 {
    // Loan = Empréstimo, InterestRate = Taxa de Juros, PaymentPeriod = Período de Pagamento
    public double calculate(double loan, int interestRatePercent, int paymentPeriod) {  
        // Juros Compostos
        return loan * Math.pow((1 + (interestRatePercent/100.0)), paymentPeriod); 
    }
}
