package pairmatching.domain;

import java.util.Objects;

public class Pair {
    private final Course course;
    private final Mission mission;
    private final Crews crews;

    public Pair(Course course, Mission mission, Crews crews) {
        this.course = course;
        this.mission = mission;
        this.crews = crews;
    }

    public void append(Crew crew) {
        crews.append(crew);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return course == pair.course && mission == pair.mission && Objects.equals(crews, pair.crews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, mission, crews);
    }
}
