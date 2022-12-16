package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Mission {
    RACING(Level.LEVEL1, "자동차경주"),
    LOTTO(Level.LEVEL1, "로또"),
    BASEBALL(Level.LEVEL1, "숫자야구게임"),

    SHOPPING_BAG(Level.LEVEL2, "장바구니"),
    PAYMENT(Level.LEVEL2, "결제"),
    SUBWAY(Level.LEVEL2, "지하철노선도"),

    PERFORMANCE(Level.LEVEL4, "성능개선"),
    DEPLOY(Level.LEVEL4, "배포");

    private final Level level;
    private final String name;

    Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<Mission> findByLevel(Level level) {
        return Arrays.stream(Mission.values())
                .filter(mission -> mission.level == level)
                .collect(Collectors.toList());
    }

    public static Mission findByName(String name) {
        return Arrays.stream(Mission.values())
                .filter(mission -> mission.name == name)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("찾으시는 미션은 없습니다."));
    }
}
