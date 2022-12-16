package pairmatching.service;

import static pairmatching.domain.Course.BACKEND;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.repository.CrewRepository;
import java.util.List;
import java.util.stream.Collectors;

public class MatchingService {
    private static final int COURSE_IDX = 0;

    private final CrewRepository crewRepository = new CrewRepository();

    public void match(List<String> details) {
        List<Crew> crews = getCrews(details.get(COURSE_IDX));
        List<String> crewNames = convertToName(crews);
    }

    private List<Crew> getCrews(String courseName) {
        Course course = Course.findByName(courseName);
        if (course.equals(BACKEND)) {
            return crewRepository.getBackEndCrews();
        }
        return crewRepository.getFrontEndCrews();
    }

    private List<String> convertToName(List<Crew> crews) {
        return crews.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());;
    }
}
