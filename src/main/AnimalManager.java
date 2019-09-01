package main;

import main.animal.sheep.Sheep;
import main.animal.sheep.SheepHandler;
import main.animal.sheep.SheepService;
import main.animal.wolf.Wolf;
import main.animal.wolf.WolfHandler;
import main.animal.wolf.WolfService;

import java.util.ArrayList;
import java.util.List;

public class AnimalManager {
    private static WolfService wolfService;
    private static WolfHandler wolfHandler;
    private static SheepService sheepService;
    private static SheepHandler sheepHandler;

    public static void main(String[] args) {
        List<Sheep> sheeps = new ArrayList<>();
        List<Wolf> wolfs = new ArrayList<>();

        wolfs.add(new Wolf("wolf_1"));

        for (int i = 0; i < 10; i++) {
            sheeps.add(new Sheep("sheep_"+sheeps.size()));
        }

        sheepHandler = new SheepHandler(sheeps);
        wolfHandler = new WolfHandler(wolfs, sheepHandler);

        sheepService = new SheepService(sheepHandler);
        wolfService = new WolfService(wolfHandler, sheepHandler);

        start();
    }


    private static void start() {
        int maxDays = 7;
        int day = 1;

        while (day < maxDays) {
            newDay();
            printState(day);
            day++;
        }
    }

    private static void newDay() {
        wolfService.update();
        sheepService.update();
    }

    private static void printState(int day) {
        int sheepsEaten = wolfHandler.getFirst().sheepsEaten;
        int sheeps = sheepHandler.getSheeps().size();
        int deadSheeps = sheepHandler.getDeadSheeps().size();

        System.out.println("******************** Day " + day + " *********************");
        System.out.println("There are now " + sheeps + " sheeps in the world!");
        System.out.println("The wolf has eaten " + sheepsEaten + " sheeps!");
        System.out.println(deadSheeps + " sheeps have died in total so far!");
        System.out.println("************************************************");
        System.out.println();
    }
}