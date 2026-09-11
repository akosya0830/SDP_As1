# Movie Ticket Booking System — Builder Pattern

## Product Description
This project implements the Builder Creational Design Pattern in Java for a
Cinema Booking System. The system allows flexible, step-by-step construction
of complex `com.aitu.moviebuilder.MovieTicket` objects. A movie ticket requires several parameters
such as movie title, hall number, show time, seat type, and optional
additions like popcorn and drinks. Using the Builder pattern separates the
construction process from the final representation.

## Pattern Components
| Component | Class | Role |
|---|---|---|
| Product | `com.aitu.moviebuilder.MovieTicket` | The complex object being built. |
| Builder | `com.aitu.moviebuilder.TicketBuilder` (interface) + `com.aitu.moviebuilder.StandardTicketBuilder` (impl) | Fluent, chainable step-by-step construction with validation in `build()`. |
| Director | `com.aitu.moviebuilder.TicketDirector` | Known, reusable construction recipe (`constructVIPPackage`). |
| Client | `com.aitu.moviebuilder.Main` | Demonstrates director-built ticket, manual custom build, and validation failure. |

## Clean Code Principles Applied

### 1. Meaningful and Intention-Revealing Names
Class, interface, and method names clearly express their domain purpose
without needing extra comments.

```java
import com.aitu.moviebuilder.MovieTicket;
import com.aitu.moviebuilder.TicketBuilder;

public MovieTicket constructVIPPackage(TicketBuilder builder, String movieTitle) {
    // clear, domain-specific method name — no comment needed to explain what it does
}
```

### 2. Small Methods, Each Doing One Thing
Every setter in `com.aitu.moviebuilder.StandardTicketBuilder` assigns exactly one field and
returns `this`; no setter does more than its name promises.

```java
import com.aitu.moviebuilder.TicketBuilder;

@Override
public TicketBuilder setSeatType(String seat) {
    this.seatType = seat;
    return this;
}
```

### 3. Consistent Formatting and Small, Focused Classes
Responsibilities are split across small classes instead of one large class:
`com.aitu.moviebuilder.MovieTicket` only holds data, `com.aitu.moviebuilder.StandardTicketBuilder` only builds,
`com.aitu.moviebuilder.TicketDirector` only orchestrates known recipes. Formatting (field
ordering, `@Override` usage, brace style) is uniform across all classes.

### 4. Validated Construction
`build()` throws a clear, descriptive exception instead of returning an
incomplete ticket.
```java
// Before: would silently create a ticket with movieTitle == null
return new com.aitu.moviebuilder.MovieTicket(movieTitle, hallNumber, showTime, seatType, includePopcorn, includeDrink);

// After: fails fast with a specific message
if (movieTitle == null || movieTitle.isEmpty()) {
    throw new IllegalStateException("Movie title cannot be empty!");
}
return new com.aitu.moviebuilder.MovieTicket(movieTitle, hallNumber, showTime, seatType, includePopcorn, includeDrink);
```

### 5. No Magic Numbers/Strings
The default seat type used to be a raw string literal assigned directly to
the field. It is now a named constant with one place to change it.
```java
// Before
private String seatType = "Standard";

// After
private static final String DEFAULT_SEAT_TYPE = "Standard";
private String seatType = DEFAULT_SEAT_TYPE;
```

## How to Run
```bash
javac src/*.java -d out
java -cp out com.aitu.moviebuilder.Main
```