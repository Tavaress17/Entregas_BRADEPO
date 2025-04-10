package com.bradepo.hr_system;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bradepo.hr_system.step2.PaymentCalculatorStep2;
import com.bradepo.hr_system.step2.WorkedHoursCalculatorStep2;

import com.bradepo.hr_system.step3.PaymentCalculatorStep3;
import com.bradepo.hr_system.step3.WorkedHoursCalculatorStep3;

import com.bradepo.hr_system.step4.PaymentCalculatorStep4;
import com.bradepo.hr_system.step4.WorkedHoursCalculatorStep4;

@SpringBootApplication
public class HrSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrSystemApplication.class, args);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Dados do RH
            System.out.print("Informe o horário de entrada do funcionário no turno: ");
            int entryTime = scanner.nextInt();
            System.out.print("Informe o horário de saída do funcionário no turno: ");
            int exitTime = scanner.nextInt();
            System.out.print("Informe a quantidade de turnos cumpridos pelo funcionário: ");
            int workedShifts = scanner.nextInt();
            System.out.print("Digite o valor da hora trabalhada pelo funcionário: ");
            double workedHoursValue = scanner.nextDouble();

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
                    calculatePayment(entryTime, exitTime, workedShifts, workedHoursValue);
                    System.out.println();
                break;
                case 2:
                    PaymentCalculatorStep2 paymentCalculatorStep2 = new PaymentCalculatorStep2(entryTime, exitTime, workedShifts, workedHoursValue);
                    WorkedHoursCalculatorStep2 workedHoursCalculatorStep2 = new WorkedHoursCalculatorStep2();
                    paymentCalculatorStep2.calculatePayment(workedHoursCalculatorStep2);
                    System.out.println();
                break;
                case 3:
                    WorkedHoursCalculatorStep3 workedHoursCalculatorStep3 = new WorkedHoursCalculatorStep3();
                    workedHoursCalculatorStep3.connect(new PaymentCalculatorStep3(entryTime, exitTime, workedShifts, workedHoursValue));
                    System.out.println();
                break;
                case 4:
                    WorkedHoursCalculatorStep4 workedHoursCalculatorStep4 = new WorkedHoursCalculatorStep4();
                    workedHoursCalculatorStep4.connect(new PaymentCalculatorStep4(entryTime, exitTime, workedShifts, workedHoursValue));
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
    // Calcular horas trabalhadas
    public static int calculateWorkedHours(int entryTime, int exitTime) {
        return (exitTime < entryTime) ? (24 - entryTime) + exitTime : exitTime - entryTime;
    }

    // Calcular valor do pagamento
    public static void calculatePayment(int entryTime, int exitTime, int workedShifts, double workedHoursValue) {
        int totalWorkedTime = workedShifts * calculateWorkedHours(entryTime, exitTime);
        System.out.printf("\nO valor do pagamento será de R$ %.2f\n", totalWorkedTime * workedHoursValue);
    }
}
