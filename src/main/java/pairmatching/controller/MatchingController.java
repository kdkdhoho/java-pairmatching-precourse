package pairmatching.controller;

import pairmatching.service.MatchingService;
import pairmatching.util.ExceptionHandler;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import java.util.List;

public class MatchingController implements Controllable {
    private final InputView inputView;
    private final OutputView outputView;
    private final ExceptionHandler exceptionHandler;
    private final MatchingService matchingService = new MatchingService();

    public MatchingController(InputView inputView, OutputView outputView, ExceptionHandler exceptionHandler) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public void control() {
        outputView.printOverView();
        List<String> details = exceptionHandler.repeat(inputView::readCourseLevelMission);

    }
}
