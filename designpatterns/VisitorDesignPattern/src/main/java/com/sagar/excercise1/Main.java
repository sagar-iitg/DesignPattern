package com.sagar.excercise1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Planet mars = new Mars();
        Planet saturn = new Saturn();
        Planet mercury = new Mercury();

        Explorer explorer = new LifeExplorer();

        List<Planet> planetsToBeVisited = new ArrayList<>();
        planetsToBeVisited.add(mars);
        planetsToBeVisited.add(saturn);
        planetsToBeVisited.add(mercury);

        explorer.visit(planetsToBeVisited.get(0));

        for (Planet planet : planetsToBeVisited) {
            explorer.visit(planet);
        }
    }
}
