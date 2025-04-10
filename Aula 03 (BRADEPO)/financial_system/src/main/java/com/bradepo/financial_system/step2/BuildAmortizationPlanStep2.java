package com.bradepo.financial_system.step2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class BuildAmortizationPlanStep2 {
    private double loan;
    private int interestRatePercent;
    private int paymentPeriod;

    public void generatePlan(CompoundInterestCalculatorStep2 compoundInterestCalculator) {
        // Montante Final
        double finalAmount = compoundInterestCalculator.calculate(loan, interestRatePercent, paymentPeriod); 

        // Parcela
        double installment =  finalAmount / paymentPeriod; 
        
        // Saldo Devedor
        double outstandingBalance = finalAmount; 
        
        // Cabeçalho
        System.out.printf("\n%-5s %-13s %-13s\n", "Per", "Installment", "Balance");

        for (int period = 1; period <= paymentPeriod; period++) {
            // Pagar uma parcela
            outstandingBalance -= installment;

            // Corrige eventual valor negativo por arredondamento
            if (period == paymentPeriod || outstandingBalance < 0.01) outstandingBalance = 0;

            // Imprime
            System.out.printf("%-5d R$ %-10.2f R$ %-10.2f\n", period, installment, outstandingBalance);
        }
    }
}
