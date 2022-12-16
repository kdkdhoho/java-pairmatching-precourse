package pairmatching.repository;

import pairmatching.domain.Crew;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrewRepository {
    private final Map<String, Crew> backEndStore = new HashMap<>();
    private final Map<String, Crew> frontEndStore = new HashMap<>();

    public void saveBackEnd(String name, Crew crew) {
        backEndStore.put(name, crew);
    }

    public void saveFrontEnd(String name, Crew crew) {
        frontEndStore.put(name, crew);
    }

    public Crew findByName(String name) {
        if (backEndStore.containsKey(name)) {
            return backEndStore.get(name);
        }
        return frontEndStore.get(name);
    }

    public List<Crew> getBackEndCrews() {
        return new ArrayList<>(backEndStore.values());
    }

    public List<Crew> getFrontEndCrews() {
        return new ArrayList<>(frontEndStore.values());
    }
}
