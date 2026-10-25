# UML Class Diagram Explanation

## Assignment #5 — Strategy Pattern

**Project:** Navigation / Route Planning System  
**Design Pattern:** Strategy (Behavioral)  
**Programming Language:** Java 17

## 1. Introduction

This UML class diagram represents the architecture of the Navigation System using the Strategy design pattern.

The diagram contains six main components:

- RouteStrategy — Strategy Interface
- CarStrategy — Concrete Strategy
- WalkStrategy — Concrete Strategy
- CycleStrategy — Concrete Strategy
- Navigator — Context
- Main — Client

The main purpose of this design is to separate different route planning algorithms into independent classes.

## 2. UML Classes

### 2.1 RouteStrategy Interface

RouteStrategy defines the common method for all route planning algorithms.

**Method:**

`+planRoute(start: String, end: String): String`

- `+` means public visibility.
- `start` represents the starting location.
- `end` represents the destination.
- `String` is the return type.

Every Concrete Strategy must implement this method.

### 2.2 CarStrategy

CarStrategy implements the RouteStrategy interface.

It provides a route description for travelling by car.

### 2.3 WalkStrategy

WalkStrategy implements the RouteStrategy interface.

It provides a route description for travelling on foot.

### 2.4 CycleStrategy

CycleStrategy implements the RouteStrategy interface.

It provides a route description for travelling by bicycle.

### 2.5 Navigator — Context

Navigator is the Context class.

**Attribute:**

`-strategy: RouteStrategy`

The minus sign (`-`) means private visibility.

Navigator stores a reference to the selected strategy.

**Constructor:**

`+Navigator(strategy: RouteStrategy)`

The constructor receives the initial strategy.

**Method:**

`+setStrategy(strategy: RouteStrategy): void`

This method changes the selected strategy during program execution.

**Method:**

`+planRoute(start: String, end: String): String`

This method delegates route planning to the currently selected strategy.

Navigator does not contain conditional statements for choosing transportation algorithms.

### 2.6 Main — Client

Main is the Client class.

It creates the Navigator and Concrete Strategy objects.

It also demonstrates runtime strategy switching.

## 3. UML Relationships and Arrows

### 3.1 CarStrategy → RouteStrategy

**UML notation:** `CarStrategy ..|> RouteStrategy`

**Relationship:** Realization (Interface Implementation)

This dashed line with a hollow triangle means that CarStrategy implements the RouteStrategy interface.

CarStrategy provides its own implementation of the planRoute() method.

### 3.2 WalkStrategy → RouteStrategy

**UML notation:** `WalkStrategy ..|> RouteStrategy`

**Relationship:** Realization

WalkStrategy implements the RouteStrategy interface.

It provides the walking route behavior.

### 3.3 CycleStrategy → RouteStrategy

**UML notation:** `CycleStrategy ..|> RouteStrategy`

**Relationship:** Realization

CycleStrategy implements the RouteStrategy interface.

It provides the cycling route behavior.

### 3.4 Navigator ◇— RouteStrategy

**UML notation:** `Navigator o-- RouteStrategy : holds`

**Relationship:** Aggregation

The hollow diamond represents aggregation.

Navigator stores a reference to a RouteStrategy object.

The strategy object can exist independently of Navigator.

Navigator can replace the strategy during runtime.

### 3.5 Main → Navigator

**UML notation:** `Main ..> Navigator : uses`

**Relationship:** Dependency

The dashed arrow means that Main depends on Navigator.

Main creates and uses Navigator to execute route planning operations.

### 3.6 Main → CarStrategy

**UML notation:** `Main ..> CarStrategy : creates`

**Relationship:** Dependency

Main creates a CarStrategy object and passes it to Navigator.

### 3.7 Main → WalkStrategy

**UML notation:** `Main ..> WalkStrategy : creates`

**Relationship:** Dependency

Main creates a WalkStrategy object when it needs walking route behavior.

### 3.8 Main → CycleStrategy

**UML notation:** `Main ..> CycleStrategy : creates`

**Relationship:** Dependency

Main creates a CycleStrategy object when it needs cycling route behavior.

## 4. UML Symbols

| Symbol | Meaning |
|---|---|
| `+` | Public member |
| `-` | Private member |
| `..|>` | Realization / Implements interface |
| `o--` | Aggregation |
| `..>` | Dependency |
| `: void` | Method does not return a value |
| `: String` | Method returns a String |

## 5. How the Classes Work Together

1. Main creates a Concrete Strategy object.
2. Main passes the strategy to Navigator.
3. Navigator stores the strategy using the RouteStrategy interface.
4. Main calls the planRoute() method.
5. Navigator delegates execution to the selected Concrete Strategy.
6. Main can change the strategy using setStrategy().
7. Navigator uses the new strategy without changing its own implementation.

This process demonstrates runtime strategy switching and polymorphism.

## 6. Conclusion

The UML diagram demonstrates the main components and relationships of the Strategy design pattern.

The RouteStrategy interface defines common behavior.

Concrete Strategies implement different route planning variants.

Navigator works as the Context and delegates operations to the selected strategy.

Main works as the Client and controls strategy selection.

This design improves flexibility, readability, and extensibility.