package pairmatching.domain;

import java.util.Arrays;

public enum Function {
    PAIR_MATCHING("1", "페어 매칭"),
    PAIR_LOOKUP("2", "페어 조회"),
    PAIR_INITIALIZATION("3", "페어 초기화"),
    QUIT("Q", "종료");

    private final String command;
    private final String description;

    Function(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static boolean isNotQuit(String command) {
        return !QUIT.command.equals(command);
    }
}
