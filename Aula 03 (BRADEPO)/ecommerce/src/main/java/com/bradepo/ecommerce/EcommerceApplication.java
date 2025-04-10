package com.bradepo.ecommerce;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bradepo.ecommerce.step2.OrderProcessingStep2;
import com.bradepo.ecommerce.step2.StockManagerStep2;

import com.bradepo.ecommerce.step3.OrderProcessingStep3;
import com.bradepo.ecommerce.step3.StockManagerStep3;

import com.bradepo.ecommerce.step4.OrderProcessingStep4;
import com.bradepo.ecommerce.step4.StockManagerStep4;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Dados do E-commerce
            System.out.print("Escolha a quantidade do item no pedido: ");
            int orderQuantity = scanner.nextInt();
            System.out.print("Digite a quantidade em estoque: ");
            int stockQuantity = scanner.nextInt();

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
                    placeOrder(orderQuantity, stockQuantity);
                    System.out.println();
                break;
                case 2:
                    OrderProcessingStep2 orderProcessingStep2 = new OrderProcessingStep2(orderQuantity, stockQuantity);
                    StockManagerStep2 stockManagerStep2 = new StockManagerStep2();
                    orderProcessingStep2.placeOrder(stockManagerStep2);
                    System.out.println();
                break;
                case 3:
                    StockManagerStep3 stockManagerStep3 = new StockManagerStep3();
                    stockManagerStep3.connect(new OrderProcessingStep3(orderQuantity, stockQuantity));
                    System.out.println();
                break;
                case 4:
                    StockManagerStep4 stockManagerStep4 = new StockManagerStep4();
                    stockManagerStep4.connect(new OrderProcessingStep4(orderQuantity, stockQuantity));   
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
    // Checar disponibilidade no estoque
    public static boolean checkStockAvailability(int orderQuantity, int stockQuantity) {
        return (stockQuantity > 0 && stockQuantity >= orderQuantity);
    }

    // Fazer pedido
    public static void placeOrder(int orderQuantity, int stockQuantity) {
        if (checkStockAvailability(orderQuantity, stockQuantity)) {
            stockQuantity -= orderQuantity;
            System.out.println("Pedido feito com sucesso!");
            System.out.println("Estoque atualizado!\nNova quantidade em estoque: " + stockQuantity);
        } else {
            System.out.println("Não possuimos essa quantidade do pedido em nossos estoques!");
        }
    }
}
