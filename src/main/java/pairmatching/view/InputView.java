package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCommand() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
        String input = Console.readLine();
        validateEmpty(input);
        return input;
    }

    private void validateEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("올바른 값을 입력해주세요.");
        }
    }
}
