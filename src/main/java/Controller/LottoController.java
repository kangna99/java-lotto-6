package Controller;

import View.InputView;
import View.OutputView;
import lotto.Calculator;
import lotto.Lottos;
import lotto.WinningNumbers;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int amount = inputView.askPurchaseAmount();

        Lottos lottos = new Lottos();
        lottos.buy(amount);
        outputView.printUserLottoNumbers(lottos.getLottos());

        WinningNumbers winningNumbers = inputView.askWinningNumbers();

        Calculator calculator = new Calculator(lottos, winningNumbers);

//        WinningResults winningResults = new WinningResults(calculator.calculateRank(),
//                calculator.calculateWinningRate(),
//                rank, winningRate);
//        outputView.printWinningResults(winningResults);
    }
}
