package pairmatching.controller;

import pairmatching.domain.Function;
import pairmatching.service.MainService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MainController {
    private static final String INIT = "START";

    private final Map<Function, Controllable> controllers = new HashMap<>();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MainService mainService = new MainService();

    public MainController() {
        controllers.put(Function.PAIR_MATCHING, new MatchingController(inputView, outputView));
    }

    public void run() {
        String command = INIT;

        while (mainService.isNotQuit(command)) {
            command = repeat(inputView::readCommand);
            Function function = mainService.findFunction(command);
            Controllable controller = controllers.get(function);
            controller.control();
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
