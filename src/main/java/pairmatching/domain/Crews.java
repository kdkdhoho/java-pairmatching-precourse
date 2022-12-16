package pairmatching.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Crews {
    private final List<Crew> crews;

    public Crews(List<Crew> crews) {
        this.crews = crews;
    }

    public void append(Crew crew) {
        crews.add(crew);
    }

    @Override
    public String toString() {
        return crews.stream()
                .map(Crew::getName)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crews crews1 = (Crews) o;
        return Objects.equals(crews, crews1.crews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crews);
    }
}
