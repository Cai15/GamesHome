import java.io.BufferedReader;

public class Realm {
    static BufferedReader br;
    static FantasyCharacter player = null;

    static BattleScene battleScene = null;

    public class FightCallback {
        public void fightLost() {
        }

        public void fightWin() {
        }
    }
}
