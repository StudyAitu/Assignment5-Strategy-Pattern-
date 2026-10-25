
package kz.aitu.strategy;

public class CarStrategy implements RouteStrategy {

    @Override
    public String planRoute(String start, String end) {
        return "Car route: " + start + " -> " + end
                + ". Travel by car using roads.";
    }
}
