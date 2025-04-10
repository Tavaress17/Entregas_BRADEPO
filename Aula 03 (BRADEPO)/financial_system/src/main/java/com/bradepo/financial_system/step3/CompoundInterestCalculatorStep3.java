package com.bradepo.financial_system.step3;

public class CompoundInterestCalculatorStep3 {
    // Loan = Empréstimo, InterestRate = Taxa de Juros, PaymentPeriod = Período de Pagamento
    public double calculate(double loan, int interestRatePercent, int paymentPeriod) {  
        // Juros Compostos
        return loan * Math.pow((1 + (interestRatePercent/100.0)), paymentPeriod); 
    }

    public void connect(BuildAmortizationPlanStep3 amortizationPlan) {
        amortizationPlan.update(calculate(amortizationPlan.getLoan(), amortizationPlan.getInterestRatePercent(), amortizationPlan.getPaymentPeriod()));
    }
}
