package com.bradepo.ecommerce.step3;

public class StockManagerStep3 {
    // Checar disponibilidade no estoque
    public boolean checkStockAvailability(int orderQuantity, int stockQuantity) {
        return (stockQuantity > 0 && stockQuantity >= orderQuantity);
    }

    public void connect(OrderProcessingStep3 orderProcessing) {
        orderProcessing.update(checkStockAvailability(orderProcessing.orderQuantity, orderProcessing.stockQuantity));
    }
}
