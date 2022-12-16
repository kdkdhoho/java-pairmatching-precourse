package pairmatching.controller;

import pairmatching.domain.Function;
import pairmatching.service.MainService;
import pairmatching.util.ExceptionHandler;
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
    private final ExceptionHandler exceptionHandler = new ExceptionHandler(outputView);

    public MainController() {
        controllers.put(Function.PAIR_MATCHING, new MatchingController(inputView, outputView, exceptionHandler));
    }

    public void run() {
        String command = INIT;

        while (mainService.isNotQuit(command)) {
            command = exceptionHandler.repeat(inputView::readCommand);
            Function function = mainService.findFunction(command);
            Controllable controller = controllers.get(function);
            controller.control();
        }
    }
}
