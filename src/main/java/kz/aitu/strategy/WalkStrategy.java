
package kz.aitu.strategy;

public class WalkStrategy implements RouteStrategy {

    @Override
    public String planRoute(String start, String end) {
        return "Walking route: " + start + " -> " + end
                + ". Travel on foot using pedestrian paths.";
    }
}
