package Kofi_Co;

import java.util.ArrayList;

public class OrderManager {
    private static OrderManager instance;
    private ArrayList<OrderItem> currentOrder;
    
    private OrderManager() {
        currentOrder = new ArrayList<>();
    }
    
    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }
    
    public void addToOrder(OrderItem item) {
        // Check if an item with the same name exists
        for (OrderItem existingItem : currentOrder) {
            if (existingItem.name.equals(item.name)) {
                // Update the quantity instead of adding a new item
                existingItem.quantity += item.quantity;
                return;
            }
        }
        // If no matching item found, add the new item
        currentOrder.add(item);
    }
    
    public ArrayList<OrderItem> getCurrentOrder() {
        return currentOrder;
    }
    
    public void clearOrder() {
        currentOrder.clear();
    }
    
    public void removeFromOrder(String itemName) {
        currentOrder.removeIf(item -> item.name.equals(itemName));
    }
    
    public void updateQuantity(String itemName, int newQuantity) {
        for (OrderItem item : currentOrder) {
            if (item.name.equals(itemName)) {
                item.quantity = newQuantity;
                if (newQuantity <= 0) {
                    currentOrder.remove(item);
                }
                break;
            }
        }
    }

    public static void resetInstance() {
        instance = null;
    }
} 