package kz.aitu.strategy;

import java.util.Objects;

public class Navigator {

    private RouteStrategy strategy;

    public Navigator(RouteStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = Objects.requireNonNull(
                strategy, "Strategy cannot be null"
        );
    }

    public String planRoute(String start, String end) {
        return strategy.planRoute(start, end);
    }
}