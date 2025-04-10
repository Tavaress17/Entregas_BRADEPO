package com.bradepo.ecommerce.step3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class OrderProcessingStep3 {
    int orderQuantity;
    int stockQuantity;
    
    // Fazer pedido
    public void placeOrder(boolean availability) {
        if (availability) {
            this.stockQuantity -= this.orderQuantity;
            System.out.println("Pedido feito com sucesso!");
            System.out.println("Estoque atualizado!\nNova quantidade em estoque: " + this.stockQuantity);
        } else {
            System.out.println("Não possuimos essa quantidade do pedido em nossos estoques!");
        }
    }

    public void update(boolean availability) {
        this.placeOrder(availability);
    }
}
