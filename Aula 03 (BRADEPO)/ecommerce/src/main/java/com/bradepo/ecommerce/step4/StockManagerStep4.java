package com.bradepo.ecommerce.step4;

public class StockManagerStep4 implements InterfaceStockManagerStep4 {
    // Checar disponibilidade no estoque
    public boolean checkStockAvailability(int orderQuantity, int stockQuantity) {
        return (stockQuantity > 0 && stockQuantity >= orderQuantity);
    }

    @Override
    public void connect(OrderProcessingStep4 orderProcessing) {
        orderProcessing.update(checkStockAvailability(orderProcessing.orderQuantity, orderProcessing.stockQuantity));
    }
}
