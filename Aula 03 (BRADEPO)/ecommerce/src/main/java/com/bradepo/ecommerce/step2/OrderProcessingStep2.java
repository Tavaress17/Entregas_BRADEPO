package com.bradepo.ecommerce.step2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class OrderProcessingStep2 {
    int orderQuantity;
    int stockQuantity;
    
    // Fazer pedido
    public void placeOrder(StockManagerStep2 stockManager) {
        if (stockManager.checkStockAvailability(this.orderQuantity, this.stockQuantity)) {
            this.stockQuantity -= this.orderQuantity;
            System.out.println("Pedido feito com sucesso!");
            System.out.println("Estoque atualizado!\nNova quantidade em estoque: " + this.stockQuantity);
        } else {
            System.out.println("Não possuimos essa quantidade do pedido em nossos estoques!");
        }
    }
}
