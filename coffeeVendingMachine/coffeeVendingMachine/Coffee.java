package coffeeVendingMachine.coffeeVendingMachine;

import java.util.Map;

public class Coffee {
    private String name;
    private Double price;
    private Map<Ingredient, Integer> recipe;

    public Coffee(String name, Double price, Map<Ingredient, Integer> recipe) {
        this.name = name;
        this.price = price;
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Map<Ingredient, Integer> getRecipe() {
        return recipe;
    }

    public void setRecipe(Map<Ingredient, Integer> recipe) {
        this.recipe = recipe;
    }

}
