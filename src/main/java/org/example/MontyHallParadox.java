package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {
    public static void main(String[] args) {
        int count = 1000;
        int winsWithSwitch = 0;
        int winsWithoutSwitch = 0;

        //Начинаем 1000 итераций игры
        for (int i = 1; i <= count; i++) {
            //Случаным образо определяем дверь, закоторой машина
            boolean[] doors = {false, false, false};
            Random random = new Random();
            int prizeDoor = random.nextInt(3);
            doors[prizeDoor] = true;

            //Случайным образом определяем какую дверь выбрал игрок
            int chosenDoor = random.nextInt(3);

            //Случайным образом определяем какую дверь откроет ведущий(она не должна быть  двербю с машиной и дверью, которую выбрал игрок
            int revealedDoor;
            do {
                revealedDoor = random.nextInt(3);
            } while (revealedDoor == chosenDoor || doors[revealedDoor]);

            //Определяем дверь, которую выбрал игрок, если бы принял предложени5е ведущего о смене двери
            int switchedDoor;
            do {
                switchedDoor = random.nextInt(3);
            } while (switchedDoor == chosenDoor || switchedDoor == revealedDoor);

            //Осталось только пароверить возможность выигрыша:
            //Если бы игрок не поменял решение
            if (doors[chosenDoor]) {
                winsWithoutSwitch++;
            }
            //Если бы игрок изменил выбор двери
            if (doors[switchedDoor]) {
                winsWithSwitch++;
            }
        }

        //Полученный результат записываем в HashMap и воводим в консоль
        Map<String, Integer> results = new HashMap<>();
        results.put("Игрок не менял выбор двери", winsWithoutSwitch);
        results.put("Игрок выбрал другую дверь", winsWithSwitch);

        System.out.println("Результат проверки Парадокса Монти Холла:");
        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}