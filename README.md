# Assignment #5 — Strategy Design Pattern

## Navigation and Route Planning System

**Astana IT University — School of Software Engineering**

| Information | Details |
|---|---|
| Course | ShP-2216 — Software Design Patterns |
| Assignment | Assignment #5 — Strategy Pattern |
| Topic | Navigation / Route Planning |
| Student | Muratbek Ibrai |
| Group | SE-2529 |
| Academic Year | 2026–2027 |
| Programming Language | Java |
| Java Version | JDK 17 |
| Development Environment | IntelliJ IDEA |
| Design Pattern | Strategy (Behavioral Pattern) |
| Assignment Type | Individual Project |

---

## 1. Project Overview

This project demonstrates the implementation of the **Strategy Design Pattern** in Java using a simple navigation and route planning application.

The main purpose of the project is to understand how different algorithms can be separated into independent classes and selected during program execution.

The application allows the user to work with different transportation strategies without changing the main navigation logic.

The project includes three transportation strategies:

1. **CarStrategy** — represents route planning for car transportation.
2. **WalkStrategy** — represents route planning for walking.
3. **CycleStrategy** — represents route planning for cycling.

Each strategy implements the same interface, but provides its own implementation of the route planning method.

The application uses a Navigator class that works as the Context in the Strategy pattern.

The Navigator does not need to know the details of each transportation strategy.

Instead, it delegates route planning to the currently selected strategy.

This approach makes the application flexible, readable, and easy to extend.

**Important:** This is an educational demonstration of route planning. The strategies generate different route descriptions. They do not calculate real roads, distances, traffic conditions, or geographical paths.

---

## 2. Project Objectives

The main objectives of this project are:

- Understand the purpose of the Strategy design pattern.
- Implement a common Strategy interface.
- Create at least three concrete strategies.
- Implement a Context class.
- Demonstrate runtime strategy switching.
- Use polymorphism instead of conditional statements.
- Apply important Clean Code principles.
- Follow object-oriented programming principles.
- Understand the difference between Strategy and State patterns.
- Design and explain a UML class diagram.
- Make the application easy to maintain and extend.

The project also helps demonstrate how design patterns solve common software design problems.

---

## 3. Technologies Used

### Java 17

Java is the main programming language used in this assignment.

The application uses basic Java features such as:

- Classes and objects
- Interfaces
- Method overriding
- Encapsulation
- Constructors
- Polymorphism
- Object references
- Access modifiers

### IntelliJ IDEA

IntelliJ IDEA is the recommended development environment.

It provides tools for writing, compiling, running, and debugging Java applications.

### PlantUML

PlantUML is used to create the UML class diagram.

The diagram represents the relationships between the Context, Strategy interface, Concrete Strategies, and Client.

### Git and GitHub

Git is used for version control.

GitHub is used to store the project source code and documentation.

---

## 4. Project Structure

```text
Assignment5-Strategy-Pattern/
│
├── src/
│   └── main/
│       └── java/
│           └── kz/
│               └── aitu/
│                   └── strategy/
│                       ├── RouteStrategy.java
│                       ├── CarStrategy.java
│                       ├── WalkStrategy.java
│                       ├── CycleStrategy.java
│                       ├── Navigator.java
│                       └── Main.java
│
├── docs/
│   ├── strategy-pattern.puml
│   └── UML-EXPLANATION.md
│
├── README.md
├── REPORT.md
└── .gitignore
```

### Description of Project Files

| File | Responsibility |
|---|---|
| RouteStrategy.java | Declares the common route planning method |
| CarStrategy.java | Implements the car route strategy |
| WalkStrategy.java | Implements the walking route strategy |
| CycleStrategy.java | Implements the cycling route strategy |
| Navigator.java | Stores and executes the selected strategy |
| Main.java | Creates objects and demonstrates runtime switching |
| strategy-pattern.puml | Contains the UML class diagram source |
| UML-EXPLANATION.md | Explains UML relationships |
| REPORT.md | Contains the assignment reflection |
| README.md | Provides project documentation |
| .gitignore | Excludes unnecessary files from Git |

The project structure separates source code from documentation.

This makes the repository easier to understand and maintain.

---

## 5. What Is the Strategy Design Pattern?

The Strategy pattern is a behavioral design pattern.

It defines a family of algorithms, places each algorithm into a separate class, and makes the algorithms interchangeable.

The Context uses a common interface to execute the selected algorithm.

The main idea is to separate the algorithm implementation from the object that uses it.

### Problem Without Strategy

Imagine a navigation application that supports different transportation types.

A simple implementation could contain many conditional statements:

```java
if (type.equals("CAR")) {
    // Car route
} else if (type.equals("WALK")) {
    // Walking route
} else if (type.equals("CYCLE")) {
    // Cycling route
}
```

This solution may work for a small application.

However, it becomes harder to maintain when more transportation types are added.

Every new transportation type may require changes to the existing conditional logic.

This increases complexity and creates a risk of errors.

### Solution With Strategy

The Strategy pattern separates each transportation algorithm into its own class.

All strategies implement the same interface.

The Navigator works with the interface instead of checking the transportation type.

```java
return strategy.planRoute(start, end);
```

The selected strategy decides how the route description is generated.

As a result, the Context does not contain transportation-specific conditional logic.

---

## 6. Strategy Pattern Components

The project contains four main components of the Strategy pattern.

### 6.1 Strategy Interface — RouteStrategy

The RouteStrategy interface defines the common method used by every route planning strategy.

```java
public interface RouteStrategy {
    String planRoute(String start, String end);
}
```

The interface acts as a contract.

Every class implementing RouteStrategy must provide the planRoute() method.

The interface does not contain transportation-specific implementation details.

### 6.2 Concrete Strategies

Concrete Strategies implement the algorithm defined by the Strategy interface.

This project contains three implementations.

**CarStrategy**

CarStrategy represents car transportation.

It returns a route description for travelling by car.

**WalkStrategy**

WalkStrategy represents pedestrian transportation.

It returns a route description for travelling on foot.

**CycleStrategy**

CycleStrategy represents bicycle transportation.

It returns a route description for travelling by bicycle.

Each strategy has its own class and implementation.

This follows the Single Responsibility Principle.

### 6.3 Context — Navigator

Navigator is the Context class.

It stores a reference to the RouteStrategy interface.

```java
private RouteStrategy strategy;
```

The Context receives a strategy through its constructor.

```java
public Navigator(RouteStrategy strategy) {
    setStrategy(strategy);
}
```

The setStrategy() method allows the selected strategy to be replaced.

```java
public void setStrategy(RouteStrategy strategy) {
    this.strategy = Objects.requireNonNull(
        strategy, "Strategy cannot be null"
    );
}
```

The planRoute() method delegates the operation to the selected strategy.

```java
public String planRoute(String start, String end) {
    return strategy.planRoute(start, end);
}
```

The Navigator does not depend on a specific transportation class.

This is one of the most important advantages of the Strategy pattern.

### 6.4 Client — Main

The Main class works as the Client.

It creates the Navigator and Concrete Strategy objects.

It also selects and changes strategies during execution.

For example:

```java
Navigator navigator =
    new Navigator(new CarStrategy());

navigator.setStrategy(new WalkStrategy());

navigator.setStrategy(new CycleStrategy());
```

The Client controls which strategy is used.

The Context executes the selected strategy without checking its concrete type.

---

## 7. UML Class Diagram

The UML class diagram represents the structure of the application.

It contains the following elements:

- RouteStrategy interface
- CarStrategy class
- WalkStrategy class
- CycleStrategy class
- Navigator class
- Main class

The diagram is stored in:

`docs/strategy-pattern.puml`

### UML Relationships

**Realization**

CarStrategy, WalkStrategy, and CycleStrategy implement the RouteStrategy interface.

A dashed line with a hollow triangle represents this relationship.

**Aggregation**

Navigator holds a reference to RouteStrategy.

A solid line with a hollow diamond represents this relationship in the diagram.

The strategy object can exist independently of the Navigator object.

**Dependency**

Main uses Navigator and creates Concrete Strategy objects.

A dashed arrow represents this dependency.

### Why Is UML Important?

UML helps explain the structure of the program without reading every line of Java code.

It shows how the Strategy pattern separates the algorithm implementations from the Context.

It is also useful during the assignment defense.

---

## 8. How the Application Works

The application follows a simple execution process.

### Step 1 — Create a Strategy

The Client creates a CarStrategy object.

```java
new CarStrategy()
```

### Step 2 — Create the Context

The Client passes the strategy to Navigator.

```java
Navigator navigator =
    new Navigator(new CarStrategy());
```

### Step 3 — Execute the Algorithm

The Client calls the route planning method.

```java
navigator.planRoute("AITU", "Khan Shatyr");
```

Navigator delegates the operation to CarStrategy.

### Step 4 — Change the Strategy

The Client selects another algorithm.

```java
navigator.setStrategy(new WalkStrategy());
```

The Navigator object remains the same.

Only its strategy reference changes.

### Step 5 — Execute Again

The Client calls planRoute() again.

The Navigator now delegates execution to WalkStrategy.

### Step 6 — Select Another Strategy

The Client can also select CycleStrategy.

```java
navigator.setStrategy(new CycleStrategy());
```

This demonstrates runtime strategy switching.

---

## 9. How to Run the Project in IntelliJ IDEA

### Step 1 — Install Java

Install JDK 17 or a compatible newer version.

Check the Java installation in Terminal:

```bash
java -version
```

### Step 2 — Open IntelliJ IDEA

Launch IntelliJ IDEA.

Choose **Open** and select the project folder.

### Step 3 — Configure Project SDK

Open:

`File → Project Structure → Project`

Select JDK 17 as the Project SDK.

### Step 4 — Configure Sources Root

Find the folder:

`src/main/java`

Right-click the folder.

Select:

`Mark Directory as → Sources Root`

The folder should become blue in IntelliJ IDEA.

### Step 5 — Open Main.java

Navigate to:

`src/main/java/kz/aitu/strategy/Main.java`

### Step 6 — Run the Application

Click the green Run button next to the main() method.

Alternatively, right-click Main.java and select **Run 'Main.main()'**.

### Step 7 — Check the Console

The console should display the output for all three strategies.

---

## 10. Expected Program Output

```text
=== STRATEGY PATTERN DEMO ===

1. Car strategy:
Car route: AITU -> Khan Shatyr. Travel by car using roads.

2. Walking strategy:
Walking route: AITU -> Khan Shatyr. Travel on foot using pedestrian paths.

3. Cycling strategy:
Cycling route: AITU -> Khan Shatyr. Travel by bicycle using cycle paths.

All strategies executed.
```

The output demonstrates that one Navigator object can execute three different strategy implementations.

The application does not need to create a new Navigator object when the strategy changes.

---

## 11. Clean Code Principles

The project demonstrates several Clean Code principles.

### 11.1 Meaningful Names

Class and method names clearly describe their responsibilities.

Examples include:

- RouteStrategy
- CarStrategy
- WalkStrategy
- CycleStrategy
- Navigator
- setStrategy()
- planRoute()

Meaningful names make the source code easier to understand.

### 11.2 Single Responsibility Principle

Each class has one main responsibility.

Concrete Strategy classes contain their own route planning behavior.

Navigator manages the selected strategy.

Main demonstrates how the application is used.

This separation improves readability and maintainability.

### 11.3 Open/Closed Principle

The application is open for extension but closed for unnecessary modification.

A new strategy can be added by creating a class that implements RouteStrategy.

The existing Navigator class does not need to change.

### 11.4 Dependency on Abstraction

Navigator depends on RouteStrategy rather than a concrete class such as CarStrategy.

This reduces coupling between the Context and Concrete Strategies.

### 11.5 Elimination of Conditional Logic

Navigator does not use if/else or switch statements to select the transportation algorithm.

It delegates execution through the Strategy interface.

This reduces complexity inside the Context.

### 11.6 Encapsulation

The strategy reference in Navigator is private.

The selected strategy can be changed through the public setStrategy() method.

This allows the Context to control access to its internal reference.

### 11.7 Separation of Concerns

The project separates different responsibilities.

Strategy classes contain algorithm variants.

Navigator delegates execution.

Main creates objects and demonstrates the application.

This makes the design easier to extend.

---

## 12. Runtime Strategy Switching

Runtime strategy switching is one of the main features of this project.

It means that the application can replace one algorithm with another while the program is running.

For example:

```java
Navigator navigator =
    new Navigator(new CarStrategy());

System.out.println(
    navigator.planRoute("AITU", "Khan Shatyr")
);

navigator.setStrategy(new WalkStrategy());

System.out.println(
    navigator.planRoute("AITU", "Khan Shatyr")
);
```

The first method call uses CarStrategy.

The second method call uses WalkStrategy.

The Navigator object is not recreated.

This demonstrates the flexibility of the Strategy design pattern.

---

## 13. How to Add a New Strategy

One important advantage of the Strategy pattern is extensibility.

For example, a developer may want to add a new transportation option called BusStrategy.

### Step 1 — Create BusStrategy.java

```java
package kz.aitu.strategy;

public class BusStrategy implements RouteStrategy {

    @Override
    public String planRoute(String start, String end) {
        return "Bus route: " + start + " -> " + end
                + ". Travel using public transportation.";
    }
}
```

### Step 2 — Select the New Strategy

The Client can use the new strategy:

```java
navigator.setStrategy(new BusStrategy());
```

### Step 3 — Execute the Strategy

```java
System.out.println(
    navigator.planRoute("AITU", "Khan Shatyr")
);
```

### Step 4 — Check the Result

The application will execute BusStrategy.

No changes to the Navigator class are required.

This demonstrates the Open/Closed Principle.

The new strategy can be added without modifying the existing Context implementation.

---

## 14. Strategy Pattern vs. State Pattern

Strategy and State are both behavioral design patterns.

They can have similar class structures, but their purposes are different.

| Strategy Pattern | State Pattern |
|---|---|
| Selects interchangeable algorithms | Changes behavior according to internal state |
| Focuses on algorithm selection | Focuses on state-dependent behavior |
| Client commonly selects the strategy | State transitions control behavior |
| Algorithms are independent alternatives | States represent different conditions of an object |
| Example: Car, Walk, Cycle | Example: Draft, Published, Archived |

### Why Strategy Is Used in This Project

The navigation application needs different route planning algorithms.

The transportation options are independent alternatives.

The Client selects the appropriate strategy.

The Navigator does not change its internal lifecycle state.

Therefore, Strategy is more suitable than State for this project.

---

## 15. Advantages of the Strategy Pattern

### Flexibility

The application can switch between algorithms during execution.

### Extensibility

New strategies can be added without changing the Navigator implementation.

### Readability

Each algorithm is located in its own class.

### Maintainability

A change in one strategy does not normally require modifications to other strategies.

### Reusability

The same strategy implementation can be used by different Navigator objects.

### Testability

Concrete Strategies can be tested independently.

### Reduced Coupling

Navigator depends on an interface instead of concrete implementation classes.

---

## 16. Disadvantages of the Strategy Pattern

The Strategy pattern also has some disadvantages.

### More Classes

Each algorithm requires a separate class.

For a small application, this may increase the number of files.

### Additional Abstraction

Developers need to understand the Strategy interface, Context, and Concrete Strategies.

### Client Responsibility

The Client must know which strategy should be selected.

### Possible Overengineering

If an application has only one simple algorithm that will never change, Strategy may introduce unnecessary complexity.

In this project, the additional classes are useful because they clearly demonstrate interchangeable behavior.

---

## 17. Testing and Verification

The following checks can be performed to verify the implementation.

| Test | Expected Result |
|---|---|
| Create Navigator with CarStrategy | Car route description |
| Change to WalkStrategy | Walking route description |
| Change to CycleStrategy | Cycling route description |
| Use the same Navigator object | All strategies execute |
| Pass null to setStrategy() | NullPointerException |
| Add BusStrategy | New strategy works without modifying Navigator |

These are expected behaviors based on the implementation.

Actual test results should be recorded after running the project.

### Manual Testing Procedure

1. Run Main.java.
2. Check the CarStrategy output.
3. Check the WalkStrategy output.
4. Check the CycleStrategy output.
5. Confirm that the same Navigator object is used.
6. Confirm that Navigator contains no transportation-specific conditions.
7. Try adding a new strategy.
8. Verify that the application compiles successfully.

### Error Handling

The Navigator uses Objects.requireNonNull().

This prevents a null strategy reference from being assigned.

For example:

```java
navigator.setStrategy(null);
```

This operation throws a NullPointerException with the message:

```text
Strategy cannot be null
```

Additional input validation can be implemented for empty or invalid route locations.

---

## 18. Design Decisions

The implementation uses a common interface because all transportation strategies perform the same general operation.

Each concrete strategy has a separate class to keep its behavior independent.

Navigator stores a RouteStrategy reference instead of a concrete class reference.

The setStrategy() method is public because runtime switching is required.

The Main class is responsible for creating and selecting strategies.

This keeps the Navigator independent from transportation-specific implementations.

The application uses String values for route locations to keep the example simple.

A more advanced application could use Location objects and actual route calculation algorithms.

---

## 19. Possible Future Improvements

The project can be extended with additional features.

### More Transportation Strategies

Possible strategies include:

- BusStrategy
- TrainStrategy
- TaxiStrategy
- ScooterStrategy

### User Input

The application could allow users to enter a starting location and destination.

### Distance Calculation

A future version could calculate approximate travel distances.

### Travel Time Estimation

Different strategies could estimate travel time based on transportation speed.

### Real Map Integration

A more advanced version could integrate a mapping service.

### Graphical User Interface

The console interface could be replaced with a JavaFX application.

### Automated Testing

JUnit tests could verify each strategy and runtime switching.

These improvements would make the application more realistic while keeping the Strategy pattern architecture.

---

## 20. GitHub Repository

The project is intended to be stored in a GitHub repository.

### Repository Contents

The repository should contain:

- Complete Java source code
- Project documentation
- UML diagram
- Assignment report
- Git commit history

### Example Git Commands

Initialize a repository:

```bash
git init
```

Add project files:

```bash
git add .
```

Create a commit:

```bash
git commit -m "Add initial Strategy Pattern implementation"
```

Connect the remote repository:

```bash
git remote add origin YOUR_REPOSITORY_URL
```

Push the project:

```bash
git branch -M main
git push -u origin main
```

Replace `YOUR_REPOSITORY_URL` with the actual GitHub repository URL.

### Incremental Development

Git commits should represent real development steps.

Examples include:

1. Create the initial project structure.
2. Add the Strategy interface.
3. Implement Concrete Strategies.
4. Implement the Navigator Context.
5. Add runtime strategy switching.
6. Add UML documentation.
7. Add the report and testing documentation.

---

## 21. Assignment Requirements Checklist

- [ ] Java 17 project compiles successfully.
- [ ] RouteStrategy interface is implemented.
- [ ] At least three Concrete Strategies are available.
- [ ] Navigator works as the Context.
- [ ] Runtime strategy switching is demonstrated.
- [ ] Navigator does not contain strategy-selection conditions.
- [ ] UML class diagram matches the source code.
- [ ] At least five Clean Code principles are explained.
- [ ] Strategy and State patterns are compared.
- [ ] README contains build and run instructions.
- [ ] New strategies can be added without modifying Navigator.
- [ ] GitHub repository contains real incremental commits.
- [ ] Markdown report is completed.
- [ ] GitHub repository URL is included in the submission.
- [ ] The student is prepared for the in-class defense.

---

## 22. Defense Preparation

During the defense, the student should be able to explain the architecture and demonstrate the application.

### Question 1: What is the Strategy pattern?

The Strategy pattern is a behavioral design pattern that allows different algorithms to be placed in separate classes and selected during runtime.

### Question 2: What is the Context?

Navigator is the Context because it stores a Strategy reference and delegates execution to the selected algorithm.

### Question 3: What is the Strategy interface?

RouteStrategy is the Strategy interface. It defines the common planRoute() method.

### Question 4: What are the Concrete Strategies?

CarStrategy, WalkStrategy, and CycleStrategy are the Concrete Strategies.

### Question 5: How do you switch strategies?

I use the setStrategy() method and pass another RouteStrategy implementation.

### Question 6: Why is polymorphism important?

Polymorphism allows Navigator to work with different Strategy implementations through one interface.

### Question 7: Why does Navigator not use if/else?

Navigator does not need to identify the concrete strategy type. It delegates the operation through the interface.

### Question 8: How can a new strategy be added?

A new class can implement RouteStrategy. The Client can then pass an instance of that class to Navigator.

### Question 9: What is the Open/Closed Principle?

Software components should be open for extension but closed for unnecessary modification.

### Question 10: What is the difference between Strategy and State?

Strategy is used for interchangeable algorithms. State is used when behavior depends on an object's internal state.

### Question 11: What is the main advantage of your implementation?

The main advantage is flexibility. Different strategies can be used without changing Navigator.

### Question 12: What is the main disadvantage?

The number of classes increases because every strategy has a separate implementation.

---

## 23. Conclusion

This project demonstrates the Strategy design pattern using a simple navigation and route planning application.

The application contains a common RouteStrategy interface, three Concrete Strategies, a Navigator Context, and a Main Client.

The implementation demonstrates polymorphism and runtime strategy switching.

The Context does not depend on concrete transportation classes.

This makes the application easier to extend and maintain.

The project also demonstrates important Clean Code principles, including meaningful naming, Single Responsibility, dependency on abstraction, and the Open/Closed Principle.

Although the implementation is simple, it provides a useful example of how design patterns can improve object-oriented software architecture.

---

## 24. References

1. Freeman, E., & Robson, E. (2021). *Head First Design Patterns* (2nd ed.). O'Reilly Media.
2. Martin, R. C. (2008). *Clean Code: A Handbook of Agile Software Craftsmanship*. Prentice Hall.
3. Refactoring.Guru. *Strategy Design Pattern*. https://refactoring.guru/design-patterns/strategy
4. Astana IT University. *Software Design Patterns — Lecture 7*. Course materials, Moodle LMS.

---

## 25. Author

**Muratbek Ibrai**  
Group: SE-2529  
Astana IT University  
School of Software Engineering  
Academic Year: 2026–2027

**GitHub Repository:** https://github.com/StudyAitu/Assignment5-Strategy-Pattern-/edit/main/README.md

**Academic integrity:** This README is a reference draft. The final submission should reflect the student's own implementation, testing, explanations, and any required acknowledgment of external assistance.
