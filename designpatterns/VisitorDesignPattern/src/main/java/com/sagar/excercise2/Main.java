package com.sagar.excercise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Planet mars = new Mars();
        Planet saturn = new Saturn();
        Planet mercury = new Mercury();

        Explorer explorer = (Explorer) new LifeExplorer();

        List<Planet> planetsToBeVisited = new ArrayList<>();
        planetsToBeVisited.add(mars);
        planetsToBeVisited.add(saturn);
        planetsToBeVisited.add(mercury);

        for (Planet planet : planetsToBeVisited) {
            planet.accept(explorer);
        }
    }
}
