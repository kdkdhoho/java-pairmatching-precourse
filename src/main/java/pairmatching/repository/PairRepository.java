package pairmatching.repository;

import pairmatching.domain.Pair;
import pairmatching.exception.DuplicatePairException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PairRepository {
    private static final PairRepository instance = new PairRepository();

    private final List<Pair> pairStore = new ArrayList<>();

    public static PairRepository getInstance() {
        return instance;
    }

    public void save(Pair pair) {
        if (pairStore.contains(pair)) {
            throw new DuplicatePairException();
        }
        pairStore.add(pair);
    }

    public Pair find(Pair targetPair) {
        return pairStore.stream()
                .filter(pair -> pair.equals(targetPair))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("찾으시는 페어는 없습니다."));
    }
}
