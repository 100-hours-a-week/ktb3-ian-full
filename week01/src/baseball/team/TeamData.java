package baseball.team;

import baseball.player.ContactHitter;
import baseball.player.Pitcher;
import baseball.player.PowerHitter;

import java.util.List;

public class TeamData {

    public static List<String> getTeamNames() {
        return List.of("LG", "한화", "SSG", "KT", "롯데", "삼성", "NC", "KIA", "두산", "키움");
    }

    public static Team getDefaultTeam() {
        return LG_TWINS();
    }

    public static Team LG_TWINS() {
        return new Team("LG 트윈스", new Pitcher("임찬규"),
                List.of(
                        new ContactHitter("신민재"),
                        new ContactHitter("문성주"),
                        new PowerHitter("오스틴"),
                        new PowerHitter("문보경"),
                        new ContactHitter("김현수"),
                        new PowerHitter("오지환"),
                        new PowerHitter("박동원"),
                        new ContactHitter("최원영"),
                        new ContactHitter("박해민")
                ));
    }

    public static Team HANHWA_EAGLES() {
        return new Team("한화 이글스", new Pitcher("류현진"),
                List.of(
                        new ContactHitter("손아섭"),
                        new ContactHitter("리베라토"),
                        new PowerHitter("문현빈"),
                        new PowerHitter("노시환"),
                        new PowerHitter("채은성"),
                        new ContactHitter("하주석"),
                        new ContactHitter("김태연"),
                        new ContactHitter("최재훈"),
                        new ContactHitter("심우준")
                ));
    }

    public static Team SSG_LANDERS() {
        return new Team("SSG 랜더스", new Pitcher("김광현"),
                List.of(
                        new ContactHitter("박성한"),
                        new ContactHitter("에레디아"),
                        new PowerHitter("최정"),
                        new PowerHitter("한유섬"),
                        new ContactHitter("류효승"),
                        new ContactHitter("최지훈"),
                        new PowerHitter("고명준"),
                        new ContactHitter("안상현"),
                        new ContactHitter("조형우")
                ));
    }

    public static Team KT_WIZ() {
        return new Team("KT 위즈", new Pitcher("고영표"),
                List.of(
                        new ContactHitter("허경민"),
                        new ContactHitter("스티븐슨"),
                        new PowerHitter("안현민"),
                        new PowerHitter("강백호"),
                        new PowerHitter("장성우"),
                        new PowerHitter("황재균"),
                        new ContactHitter("김상수"),
                        new ContactHitter("권동진"),
                        new ContactHitter("안치영")
                ));
    }

    public static Team LOTTE_GIANTS() {
        return new Team("롯데 자이언츠", new Pitcher("박세웅"),
                List.of(
                        new ContactHitter("황성빈"),
                        new ContactHitter("고승민"),
                        new ContactHitter("윤동희"),
                        new PowerHitter("레이예스"),
                        new ContactHitter("김민성"),
                        new PowerHitter("나승엽"),
                        new ContactHitter("손호영"),
                        new ContactHitter("전민재"),
                        new ContactHitter("정보근")
                ));
    }

    public static Team SAMSUNG_LIONS() {
        return new Team("삼성 라이온즈", new Pitcher("원태인"),
                List.of(
                        new ContactHitter("이재현"),
                        new ContactHitter("김지찬"),
                        new PowerHitter("구자욱"),
                        new PowerHitter("디아즈"),
                        new ContactHitter("전병우"),
                        new ContactHitter("김성윤"),
                        new PowerHitter("강민호"),
                        new PowerHitter("김영웅"),
                        new ContactHitter("류지혁")
                ));
    }

    public static Team NC_DINOS() {
        return new Team("NC 다이노스", new Pitcher("신민혁"),
                List.of(
                        new ContactHitter("김주원"),
                        new ContactHitter("최원준"),
                        new ContactHitter("박건우"),
                        new PowerHitter("데이비슨"),
                        new ContactHitter("오영수"),
                        new ContactHitter("권희동"),
                        new PowerHitter("김형준"),
                        new ContactHitter("도태훈"),
                        new PowerHitter("김휘집")
                ));
    }

    public static Team KIA_TIGERS() {
        return new Team("KIA 타이거즈", new Pitcher("양현종"),
                List.of(
                        new ContactHitter("윤도현"),
                        new ContactHitter("박찬호"),
                        new ContactHitter("김선빈"),
                        new PowerHitter("최형우"),
                        new PowerHitter("나성범"),
                        new PowerHitter("위즈덤"),
                        new PowerHitter("오선우"),
                        new PowerHitter("한준수"),
                        new ContactHitter("김호령")
                ));
    }

    public static Team DOOSAN_BEARS() {
        return new Team("두산 베어스", new Pitcher("곽빈"),
                List.of(
                        new ContactHitter("정수빈"),
                        new ContactHitter("안재석"),
                        new PowerHitter("케이브"),
                        new PowerHitter("양의지"),
                        new ContactHitter("김인태"),
                        new ContactHitter("박준순"),
                        new ContactHitter("홍성호"),
                        new PowerHitter("김기연"),
                        new ContactHitter("이유찬")
                ));
    }

    public static Team KIWOOM_HEROES() {
        return new Team("키움 히어로즈", new Pitcher("하영민"),
                List.of(
                        new PowerHitter("송성문"),
                        new ContactHitter("임지열"),
                        new ContactHitter("최주환"),
                        new PowerHitter("주성원"),
                        new PowerHitter("이주형"),
                        new PowerHitter("김건희"),
                        new ContactHitter("어준서"),
                        new ContactHitter("오선진"),
                        new ContactHitter("박주홍")
                ));
    }
}
