package lotto;

import java.util.Arrays;

public enum Rank {
    NOTHING(0, 0, "0개 일치 (0원) - %d개"),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - %d개"),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - %d개"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개");

    private final int matchCount;
    private final int prize;
    private final String printFormat;

    Rank(int matchCount, int prize, String printFormat) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.printFormat = printFormat;
    }

    public static Rank valueOf(int matchCount, boolean isBonusNumberMatched) {
        if (SECOND.matchCount == matchCount && isBonusNumberMatched) {
            return SECOND;
        }
        if (matchCount < FIFTH.matchCount) {
            return NOTHING;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getPrize() {
        return prize;
    }

    public String getPrintFormat() {
        return printFormat;
    }
}