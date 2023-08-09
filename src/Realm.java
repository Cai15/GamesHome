import java.io.BufferedReader;

public class Realm {
    //Класс для чтения введенных строк из консоли
    static BufferedReader br;
    //Игрок должен храниться на протяжении всей игры
    private static FantasyCharacter player = null;
    //Класс для битвы можно не создавать каждый раз, а переиспользовать
    static BattleScene battleScene = null;

    public class FightCallback {
        public void fightLost() {
        }

        public void fightWin() {
        }
    }
}
