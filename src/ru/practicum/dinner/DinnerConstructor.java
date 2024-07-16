package ru.practicum.dinner;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;


public class DinnerConstructor {
    Random random = new Random();
    HashMap<String, ArrayList<String>> dishList = new HashMap<>();
    ArrayList<String> selectedTypes = new ArrayList<>();

    public void addDish(String dishType, String dish) {
        if (checkType(dishType)) {
            ArrayList<String> dishName = dishList.get(dishType);
            dishName.add(dish);
        } else {
            ArrayList<String> dishName = new ArrayList<>();
            dishName.add(dish);
            dishList.put(dishType, dishName);
        }
    }

    boolean checkType(String type) {
        return dishList.containsKey(type);
    }

    public void comboGenerator (int numberOfCombos) {
       /* if (numberOfCombos > dishList.size())*/
        HashMap<Integer, ArrayList<String>> dishesCombo = new HashMap<>();


        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> dishesInCombo = new ArrayList<>();

            for (String type : selectedTypes) {
                ArrayList<String> dishesInType = dishList.get(type);
                String randomDish = dishesInType.get(random.nextInt(dishesInType.size()));
                dishesInCombo.add(randomDish);
            }
            dishesCombo.put(i, dishesInCombo);
            System.out.println("Комбо " + (i + 1));
            System.out.println(dishesCombo.get(i));

        }

    }
}
