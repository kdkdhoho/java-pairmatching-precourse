package pairmatching.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Level(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Level findByName(String name) {
        return Arrays.stream(Level.values())
                .filter(level -> level.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("입력하신 레벨은 없습니다."));
    }
}