package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String DELIMITER = " | ";

    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public void printOverView() {
        printLine();
        printCourses();
        printMissions();
        printLine();
    }

    private void printCourses() {
        String pattern = "과정: {0}";
        String course = Arrays.stream(Course.values())
                .map(Course::getName)
                .collect(Collectors.joining(DELIMITER));
        String format = MessageFormat.format(pattern, course);
        System.out.println(format);
    }

    private void printMissions() {
        System.out.println("미션:");
        Level[] levels = Level.values();
        for (Level level : levels) {
            List<Mission> missionsByLevel = Mission.findByLevel(level);
            String pattern = "- {0}: {1}";
            String format = MessageFormat.format(pattern, level, missionsByLevel.stream()
                    .map(Mission::getName)
                    .collect(Collectors.joining(DELIMITER)));
            System.out.println(format);
        }
    }

    private void printLine() {
        System.out.println("#############################################");
    }
}
