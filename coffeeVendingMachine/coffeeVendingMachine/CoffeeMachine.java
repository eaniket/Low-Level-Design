package coffeeVendingMachine.coffeeVendingMachine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CoffeeMachine {
    private static CoffeeMachine coffeeMachine;
    private Map<String, Coffee> menu;
    private Map<String, Ingredient> ingredients;

    private CoffeeMachine(){
        menu = new HashMap<>();
        ingredients = new ConcurrentHashMap<>();
        initializeIngredients();
        initializeCoffeeMenu();
    }

    public synchronized static CoffeeMachine getInstance(){
        if(coffeeMachine == null)
            return new CoffeeMachine();
        return coffeeMachine;
    }

    private void initializeIngredients(){
        ingredients.put("Coffee", new Ingredient("Coffee", 10));
        ingredients.put("Milk", new Ingredient("Milk", 15));
        ingredients.put("Water", new Ingredient("Water", 5));
    }

    private void initializeCoffeeMenu(){
        Map<Ingredient, Integer> espressoRecipe = new HashMap<>();
        espressoRecipe.put(ingredients.get("Coffee"), 1);
        espressoRecipe.put(ingredients.get("Water"), 2);
        menu.put("Espresso", new Coffee("Espresso", 2.5, espressoRecipe));

        Map<Ingredient, Integer> cappuccinoRecipe = new HashMap<>();
        cappuccinoRecipe.put(ingredients.get("Coffee"), 1);
        cappuccinoRecipe.put(ingredients.get("Water"), 1);
        cappuccinoRecipe.put(ingredients.get("Milk"), 1);
        menu.put("Cappuccino", new Coffee("Cappuccino", 3.5, cappuccinoRecipe));
    }

    public void displayMenu(){
        System.out.println("Coffee Menu");
        Collection<Coffee> coffeeMenu = menu.values();
        for(Coffee coffee: coffeeMenu){
            System.out.println(coffee.getName() + " - $" + coffee.getPrice());
        }
    }

    public synchronized Coffee selectCoffee(String coffeeName){
        return menu.get(coffeeName);
    }

    public synchronized void dispenseCoffee(Coffee coffee, Payment payment){
        if(payment.getPrice() >= coffee.getPrice()){
            if(hasInventory(coffee)){
                updateIngredients(coffee.getRecipe());
                System.out.println("Dispensing Coffee: " + coffee.getName());
                double change = payment.getPrice()-coffee.getPrice();
                if(change > 0){
                    System.out.println("Please collect your change: $" + change);
                }else{
                    System.out.println("Insufficient ingridents for: " + coffee.getName());
                }
            }else{
                System.out.println("Insufficient ammount, required amount: " + coffee.getPrice());
            }
        }
    }

    private boolean hasInventory(Coffee coffee){
        Map<Ingredient, Integer> recipe = coffee.getRecipe();
        for(Ingredient currIngredient: recipe.keySet()){
            if(ingredients.get(currIngredient.getName()).getQty() < recipe.get(currIngredient))
                return false;
        }
        return true;
    }

    private void updateIngredients(Map<Ingredient, Integer> recipe){
        for(Ingredient currIngredient: recipe.keySet()){
            int value = recipe.get(currIngredient);
            currIngredient.updateQty(-value);
            if(currIngredient.getQty() < 3){
                System.out.println("Low inventory alert for :" + currIngredient.getName());
            }
            
        }
    }
}
