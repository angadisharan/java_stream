# gof_design_patterns

## Java version

- **Minimum**: Java 8 (streams, `filter`, `map`, etc.)
- **Recommended**: Java 16+ (for `Stream.toList()` and `List.of(...)` used in the demos)

## Stream `filter()` demo

- **File**: `src/main/java/org/cleancoding/stream/filter/FilterDemo.java`
- **Covers**:
  - Filtering even numbers
  - Chaining `filter()` with `map()`
  - Null-safe + blank-safe filtering for strings (`Objects::nonNull`, `isBlank`)

### Run

```bash
mvn -q -DskipTests package
java -cp target/classes org.cleancoding.stream.filter.FilterDemo
```

## Stream `filter()` with entities

- **Entity**: `src/main/java/org/cleancoding/stream/entity/Employee.java`
  - With static factory `sampleEmployees()` for demo data.
- **Demo**: `src/main/java/org/cleancoding/stream/filter/FilterEntityDemo.java`
  - Filters active Engineering employees above a salary threshold.
  - Shows filtering inactive employees.

### Run

```bash
mvn -q -DskipTests package
java -cp target/classes org.cleancoding.stream.filter.FilterEntityDemo
```
