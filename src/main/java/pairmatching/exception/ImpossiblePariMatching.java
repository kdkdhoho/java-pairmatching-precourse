package pairmatching.exception;

public class ImpossiblePariMatching extends RuntimeException {
    private static final String ERROR_MESSAGE = "3회 이상 페어 매칭에 실패했습니다.";

    public ImpossiblePariMatching() {
        super(ERROR_MESSAGE);
    }
}
