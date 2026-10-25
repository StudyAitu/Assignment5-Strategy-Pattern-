package kz.aitu.strategy;

public class Main {

    public static void main(String[] args) {

        String start = "AITU";
        String end = "Khan Shatyr";

        Navigator navigator =
                new Navigator(new CarStrategy());

        System.out.println("=== STRATEGY PATTERN DEMO ===");

        System.out.println("\n1. Car strategy:");
        System.out.println(navigator.planRoute(start, end));

        navigator.setStrategy(new WalkStrategy());

        System.out.println("\n2. Walking strategy:");
        System.out.println(navigator.planRoute(start, end));

        navigator.setStrategy(new CycleStrategy());

        System.out.println("\n3. Cycling strategy:");
        System.out.println(navigator.planRoute(start, end));

        System.out.println("\nAll strategies executed.");
    }
}