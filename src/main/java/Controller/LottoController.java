package Controller;

import View.InputView;
import View.OutputView;
import lotto.Player;
import lotto.WinningNumbers;
import lotto.WinningStatistics;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Player player;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        player = new Player();
    }

    public void run() {
        player.buy(inputView.askPurchaseAmount());
        outputView.printUserLottoNumbers(player.getLottos());

        WinningNumbers winningNumbers = inputView.askWinningNumbers();

        WinningStatistics winningStatistics = player.calculateStatistics(winningNumbers);
        outputView.printStatistics(winningStatistics);
    }
}
