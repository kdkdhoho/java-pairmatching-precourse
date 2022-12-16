package pairmatching.service;

import static pairmatching.domain.Course.BACKEND;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.exception.DuplicatePairException;
import pairmatching.exception.ImpossiblePariMatching;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchingService {
    private static final int COURSE_IDX = 0;
    private static final int MISSION_IDX = 2;
    private static final int INIT_TRY_COUNT = 1;
    private static final int MAX_TRY_COUNT = 3;

    private final CrewRepository crewRepository = new CrewRepository();
    private final PairRepository pairRepository = new PairRepository();

    public List<Pair> match(List<String> details) {
        List<Crew> crews = getCrews(details.get(COURSE_IDX));
        List<String> crewNames = convertToName(crews);
        List<String> shuffledNames = shuffle(crewNames);
        return createPair(shuffledNames, Mission.findByName(details.get(MISSION_IDX)), INIT_TRY_COUNT);
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
                .collect(Collectors.toList());
    }

    private List<String> shuffle(List<String> crewNames) {
        return Randoms.shuffle(crewNames);
    }

    private List<Pair> createPair(List<String> shuffledNames, Mission mission, int tryCount) {
        checkTryCount(tryCount);

        List<Pair> pairs = new ArrayList<>();
        try {
            createPair(shuffledNames, mission);
        } catch (ArrayIndexOutOfBoundsException outOfBoundsException) {
            appendLastCrew(pairs.get(pairs.size() - 1), find(shuffledNames.get(shuffledNames.size() - 1)));
        } catch (DuplicatePairException duplicatePairException) {
            List<String> reShuffleNames = shuffle(shuffledNames);
            return createPair(reShuffleNames, mission, tryCount + 1);
        }

        return pairs;
    }

    private void createPair(List<String> shuffledNames, Mission mission) {
        for (int i = 0; i < shuffledNames.size(); i += 2) {
            Crew crewA = find(shuffledNames.get(i));
            Crew crewB = find(shuffledNames.get(i + 1));
            pairRepository.save(mission, new Pair(crewA.getCourse(), mission, new Crews(List.of(crewA, crewB))));
        }
    }

    private void appendLastCrew(Pair pair, Crew crew) {
        pair.append(crew);
    }

    private void checkTryCount(int tryCount) {
        if (tryCount >= MAX_TRY_COUNT) {
            throw new ImpossiblePariMatching();
        }
    }

    private Crew find(String name) {
        return crewRepository.findByName(name);
    }
}
