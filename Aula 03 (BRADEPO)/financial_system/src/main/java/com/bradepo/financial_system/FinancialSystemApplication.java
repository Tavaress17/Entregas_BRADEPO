package com.bradepo.financial_system;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bradepo.financial_system.step2.BuildAmortizationPlanStep2;
import com.bradepo.financial_system.step2.CompoundInterestCalculatorStep2;

import com.bradepo.financial_system.step3.BuildAmortizationPlanStep3;
import com.bradepo.financial_system.step3.CompoundInterestCalculatorStep3;

import com.bradepo.financial_system.step4.BuildAmortizationPlanStep4;
import com.bradepo.financial_system.step4.CompoundInterestCalculatorStep4;

@SpringBootApplication
public class FinancialSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialSystemApplication.class, args);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Dados do Empréstimo
            System.out.print("Escolha o valor do empréstimo: ");
            double loanValue = scanner.nextDouble();
            System.out.print("Informe a porcentagem da taxa de juros: ");
            int interestRatePercent = scanner.nextInt();
            System.out.print("Escolha o periodo para o pagamento do empréstimo: ");
            int paymentPeriod = scanner.nextInt();

            // Exibe o menu
            System.out.println("\n=== ETAPAS ===");
            System.out.println("1 - Etapa 1");
            System.out.println("2 - Etapa 2");
            System.out.println("3 - Etapa 3");
            System.out.println("4 - Etapa 4");
            System.out.print("Digite qualquer outra coisa para sair: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    buildAmortizationPlan(loanValue, interestRatePercent, paymentPeriod);
                    System.out.println();
                break;
                case 2:
                    BuildAmortizationPlanStep2 buildAmortizationPlanStep2 = new BuildAmortizationPlanStep2(loanValue, interestRatePercent, paymentPeriod);
                    buildAmortizationPlanStep2.generatePlan(new CompoundInterestCalculatorStep2());
                    System.out.println();
                break;
                case 3:
                    CompoundInterestCalculatorStep3 compoundInterestCalculatorStep3 = new CompoundInterestCalculatorStep3();
                    compoundInterestCalculatorStep3.connect(new BuildAmortizationPlanStep3(loanValue, interestRatePercent, paymentPeriod));
                    System.out.println();
                break;
                case 4:
                    CompoundInterestCalculatorStep4 compoundInterestCalculatorStep4 = new CompoundInterestCalculatorStep4();
                    compoundInterestCalculatorStep4.connect(new BuildAmortizationPlanStep4(loanValue, interestRatePercent, paymentPeriod));
                    System.out.println();
                break;
                default:
                    System.out.println("Finalizando!");
                    scanner.close();
                    // Encerra o programa
                return;
            }
        }
	}

    // Etapa 1
    // Calculadora de Juros Compostos
    // Loan = Empréstimo, InterestRate = Taxa de Juros, PaymentPeriod = Período de Pagamento
    public static double compoundInterestCalculator(double loan, int interestRatePercent, int paymentPeriod) {

        // Juros Compostos
        return loan * Math.pow((1 + (interestRatePercent/100.0)), paymentPeriod);
    }

    //Gerar Plano de Amortização

    // Loan = Empréstimo, InterestRate = Taxa de Juros, PaymentPeriod = Período de Pagamento
    static void buildAmortizationPlan(double loan, int interestRatePercent, int paymentPeriod) {
        
        // Montante Final
        double finalAmount = compoundInterestCalculator(loan, interestRatePercent, paymentPeriod); 

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
