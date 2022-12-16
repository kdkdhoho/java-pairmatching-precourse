package pairmatching.controller;

import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController implements Controllable {
    private final InputView inputView;
    private final OutputView outputView;
    private final MatchingService matchingService = new MatchingService();

    public MatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void control() {
        outputView.printOverView();
    }
}
