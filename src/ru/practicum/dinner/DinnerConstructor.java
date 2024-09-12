package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesType;
    Random random;

    public DinnerConstructor() {
        dishesType = new HashMap<>();
        random = new Random();
    }

    public void addDish(String dishType, String dishName) {
        if (dishesType.containsKey(dishType)) {
            ArrayList<String> dishes = dishesType.get(dishType);
            dishes.add(dishName);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dishesType.put(dishType, dishes);
        }
        System.out.println("Блюдо добавлено: " + dishType + " - " + dishName);
    }

    public ArrayList<ArrayList<String>> generateCombinations(int numberOfCombinations, ArrayList<String> types) {
        ArrayList<ArrayList<String>> combinations = new ArrayList<>();

        for (int i = 0; i < numberOfCombinations; i++) {
            ArrayList<String> combination = new ArrayList<>();
            for (String type : types) {
                ArrayList<String> dishes = dishesType.get(type);
                if (!dishes.isEmpty()) {
                    int randomKey = random.nextInt(dishes.size());
                    String randomDish = dishes.get(randomKey);
                    combination.add(randomDish);
                } else {
                    System.out.println("Блюда нет");
                }
            }
            combinations.add(combination);
        }
        return combinations;
    }

    public boolean checkType(String type) {
        return dishesType.containsKey(type);
    }
}
