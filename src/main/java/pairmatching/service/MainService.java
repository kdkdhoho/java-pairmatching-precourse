package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Function;
import pairmatching.repository.CrewRepository;
import pairmatching.util.Reader;
import java.io.IOException;
import java.util.List;

public class MainService {
    private static final String BACKEND_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_PATH = "src/main/resources/frontend-crew.md";

    private final Reader reader = new Reader();
    private final CrewRepository crewRepository = new CrewRepository();

    public MainService() throws IOException {
        List<String> backEndNames = reader.readNames(BACKEND_PATH);
        List<String> frontEndNames = reader.readNames(FRONTEND_PATH);

        for (String name : backEndNames) {
            crewRepository.saveBackEnd(name, new Crew(Course.BACKEND, name));
        }
        for (String name : frontEndNames) {
            crewRepository.saveFrontEnd(name, new Crew(Course.FRONTEND, name));
        }
    }

    public boolean isNotQuit(String command) {
        return Function.isNotQuit(command);
    }

    public Function findFunction(String command) {
        return Function.findByCommand(command);
    }
}
