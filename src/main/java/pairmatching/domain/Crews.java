package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Crews {
    private final List<Crew> crews;

    public Crews(List<Crew> crews) {
        this.crews = crews;
    }

    @Override
    public String toString() {
        return crews.stream()
                .map(Crew::getName)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
