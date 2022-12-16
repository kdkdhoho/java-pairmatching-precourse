package pairmatching.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String ERROR_MESSAGE = "올바른 값을 입력해주세요.";
    private static final int DETAILS_SIZE = 3;

    public String readCommand() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
        String input = readLine();
        validateEmpty(input);
        return input;
    }

    private void validateEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public List<String> readCourseLevelMission() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        String[] details = readLine().split(",");
        validateDetails(details);
        return Arrays.asList(trimAllString(details));
    }

    private void validateDetails(String[] details) {
        for (String detail : details) {
            validateEmpty(detail);
        }

        if (details.length != DETAILS_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private String[] trimAllString(String[] input) {
        for (int i = 0; i < input.length; i++) {
            input[i] = input[i].trim();
        }
        return input;
    }
}
