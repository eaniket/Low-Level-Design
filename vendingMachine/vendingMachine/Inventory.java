package vendingMachine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    public final Map<Product, Integer> products;

    public Inventory(){
        products = new ConcurrentHashMap<>();
    }

    public void addProduct(Product product, int qty){
        products.put(product, qty);
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public void updateQuantity(Product product, int qty){
        products.put(product, qty);
    }

    public int getQuantity(Product product){
        return products.getOrDefault(product, 0);
    }

    public boolean isAvailable(Product product){
        return products.containsKey(product) && products.get(product) > 0;
    }
}
