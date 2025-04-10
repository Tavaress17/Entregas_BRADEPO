package com.bradepo.ecommerce.step2;

public class StockManagerStep2 {
    // Checar disponibilidade no estoque
    public boolean checkStockAvailability(int orderQuantity, int stockQuantity) {
        return (stockQuantity > 0 && stockQuantity >= orderQuantity);
    }
}
