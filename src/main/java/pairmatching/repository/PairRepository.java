package pairmatching.repository;

import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.exception.DuplicatePairException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PairRepository {
    private final Map<Mission, Pair> pairStore = new HashMap<>();

    public void save(Mission mission, Pair pair) {
        if (pairStore.containsValue(pair)) {
            throw new DuplicatePairException();
        }
        pairStore.put(mission, pair);
    }

    public Optional<Pair> find(Mission mission) {
        if (pairStore.containsKey(mission)) {
            return Optional.of(pairStore.get(mission));
        }
        return Optional.empty();
    }
}
