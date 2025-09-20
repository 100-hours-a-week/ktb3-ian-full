package baseball.game;

public enum HitResult {
    SINGLE("안타"),
    DOUBLE("2루타"),
    TRIPLE("3루타"),
    HOMERUN("홈런"),
    MISS("헛스윙 스트라이크"),
    FOUL("파울"),
    STRIKE("스트라이크"),
    BALL("볼"),
    ;

    private final String description;

    HitResult(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
