package pairmatching.exception;

public class DuplicatePairException extends RuntimeException {
    private static final String ERROR_MESSAGE = "같은 레벨의 미션에서 매칭한 이력이 있습니다.";

    public DuplicatePairException() {
        super(ERROR_MESSAGE);
    }
}
