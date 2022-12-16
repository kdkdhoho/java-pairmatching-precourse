package pairmatching.service;

import pairmatching.domain.Function;

public class MainService {

    public boolean isNotQuit(String command) {
        return Function.isNotQuit(command);
    }

    public Function findFunction(String command) {
        return Function.findByCommand(command);
    }
}
