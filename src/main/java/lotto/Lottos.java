package lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Lottos implements Iterable<Lotto> {
    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void buy(int money) {
        while (money >= 1000) {
            money -= 1000;
            Lotto lotto = LottoGenerator.generate();
            lottos.add(lotto);
        }
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }

    @Override
    public void forEach(Consumer<? super Lotto> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Lotto> spliterator() {
        return Iterable.super.spliterator();
    }
}