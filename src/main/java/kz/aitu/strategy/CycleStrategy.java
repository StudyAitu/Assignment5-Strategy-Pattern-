
package kz.aitu.strategy;

public class CycleStrategy implements RouteStrategy {

    @Override
    public String planRoute(String start, String end) {
        return "Cycling route: " + start + " -> " + end
                + ". Travel by bicycle using cycle paths.";
    }
}
