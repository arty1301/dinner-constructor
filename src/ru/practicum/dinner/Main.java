package ru.practicum.dinner;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.addDish(dishType, dishName);
        // добавьте новое блюдо
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");


        ArrayList<String> typesDishes = new ArrayList<>();
        //реализуйте ввод типов блюд
        while (true) {
            String nextItem = scanner.nextLine();
            if (nextItem.isEmpty()) {
                break;
            }
            if (dc.checkType(nextItem)) {
                typesDishes.add(nextItem);
            } else {
                System.out.println("Такого типа блюда не найдено. Пропробуйте ввести другой тип");
            }
        }

        ArrayList<ArrayList<String>> combinations = dc.generateCombinations(numberOfCombos, typesDishes);

        for (ArrayList<String> combo : combinations) {
            System.out.println("Комбо: " + combo);
        }

        // сгенерируйте комбинации блюд и выведите на экран

    }
}
