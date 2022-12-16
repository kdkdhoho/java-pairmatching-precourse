package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;
import pairmatching.domain.Function;
import pairmatching.util.Reader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MainService {
    private static final String BACKEND_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_PATH = "src/main/resources/frontend-crew.md";

    private final Reader reader = new Reader();
    private Crews backEnd;
    private Crews frontEnd;

    public MainService() throws IOException {
        List<String> backEndNames = reader.readNames(BACKEND_PATH);
        List<String> frontEndNames = reader.readNames(FRONTEND_PATH);

        backEnd = new Crews(backEndNames.stream()
                .map(name -> new Crew(Course.BACKEND, name))
                .collect(Collectors.toList()));
        frontEnd = new Crews(frontEndNames.stream()
                .map(name -> new Crew(Course.FRONTEND, name))
                .collect(Collectors.toList()));
    }

    public boolean isNotQuit(String command) {
        return Function.isNotQuit(command);
    }

    public Function findFunction(String command) {
        return Function.findByCommand(command);
    }
}
