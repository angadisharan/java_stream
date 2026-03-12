# gof_design_patterns

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
