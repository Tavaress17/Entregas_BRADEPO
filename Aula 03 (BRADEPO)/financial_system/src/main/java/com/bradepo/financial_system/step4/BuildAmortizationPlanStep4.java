package com.bradepo.financial_system.step4;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class BuildAmortizationPlanStep4 implements InterfaceBuildAmortizationPlanStep4{
    private double loan;
    private int interestRatePercent;
    private int paymentPeriod;

    public void generatePlan(double finalAmount) {
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

    @Override
    public void update(double finalAmount) {
        this.generatePlan(finalAmount);
    }
}
