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

    public ArrayList<String> generateCombinations(numberOfCombos, ){

    }

    public boolean checkType(String type){
        return dishesType.containsKey(type);
    }
}
