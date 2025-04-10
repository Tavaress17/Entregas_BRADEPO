package com.bradepo.ecommerce.step4;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class OrderProcessingStep4 implements InterfaceOrderProcessingStep4 {
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

    @Override
    public void update(boolean availability) {
        this.placeOrder(availability);
    }
}
