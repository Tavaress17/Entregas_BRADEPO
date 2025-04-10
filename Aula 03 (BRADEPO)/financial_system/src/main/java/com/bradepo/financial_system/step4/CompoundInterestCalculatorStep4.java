package com.bradepo.financial_system.step4;

public class CompoundInterestCalculatorStep4 implements InterfaceCompoundInterestCalculatorStep4{
    // Loan = Empréstimo, InterestRate = Taxa de Juros, PaymentPeriod = Período de Pagamento
    public double calculate(double loan, int interestRatePercent, int paymentPeriod) {  
        // Juros Compostos
        return loan * Math.pow((1 + (interestRatePercent/100.0)), paymentPeriod); 
    }

    @Override
    public void connect(BuildAmortizationPlanStep4 amortizationPlan) {
        amortizationPlan.update(calculate(amortizationPlan.getLoan(), amortizationPlan.getInterestRatePercent(), amortizationPlan.getPaymentPeriod()));
    }
}
