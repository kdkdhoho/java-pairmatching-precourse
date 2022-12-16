package pairmatching.util;

import pairmatching.view.OutputView;
import java.util.function.Supplier;

public class ExceptionHandler {
    private final OutputView outputView;

    public ExceptionHandler(OutputView outputView) {
        this.outputView = outputView;
    }

    public <T> T repeat(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(reader);
        }
    }
}
