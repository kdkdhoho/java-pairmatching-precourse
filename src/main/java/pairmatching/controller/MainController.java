package pairmatching.controller;

import pairmatching.service.MainService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import java.util.function.Supplier;

public class MainController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MainService mainService = new MainService();

    public void run() {
        String command = repeat(inputView::readCommand);

        while (mainService.isNotQuit(command)) {
            
        }
    }

    private <T> T repeat(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(reader);
        }
    }
}
