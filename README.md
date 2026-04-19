# Stream API Demo

## Java version

- **Minimum**: Java 8 (streams, `filter`, `map`, `Optional`, `Collectors.groupingBy`, `String.chars`, etc.)
- **Java 9**: `List.of(...)` factory methods used for creating small immutable lists.
- **Java 11**: `String.isBlank()` used in the string filter demo.
- **Java 16+**: `Stream.toList()` used instead of `collect(Collectors.toList())`.

## Stream `filter()` demo

- **File**: `src/main/java/org/cleancoding/stream/filter/FilterDemo.java`
- **Covers**:
  - Filtering even numbers
  - Chaining `filter()` with `map()`
  - Null-safe + blank-safe filtering for strings (`Objects::nonNull`, `isBlank`)

### Run

```bash
mvn -q -DskipTests package
java -cp target/classes org.matools.stream.filter.FilterDemo
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
java -cp target/classes org.matools.stream.filter.FilterEntityDemo
```
