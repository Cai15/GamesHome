import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args, String string) throws IOException {
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        BattleScene battleScene = new BattleScene();
        System.out.println("Введите имя персонажа:");
        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        private static void command (String string;) throws IOException {
            if (Realm.player == null) {
                Hero player = new Hero(
                        string,
                        100,
                        20,
                        20,
                        0,
                        0
                );
                System.out.println(String.format("Спасти наш мир от драконов вызвался %s! Да будет его броня крепка и бицепс кругл!", Realm.player.getName()));
                printNavigation();
            }
            switch (string) {
                case "1": {
                    System.out.println("Торговец еще не приехал");
                    command(br.readLine());
                }
                break;
                case "2": {
                    commitFight();
                }
                break;
                case "3":
                    System.exit(1);
                    break;
                case "да":
                    command("2");
                    break;
                case "нет": {
                    printNavigation();
                    command(br.readLine());
                }
            }
            command(br.readLine());
        }
        System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");
        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void command(String string) {
    }

    private static void printNavigation() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К Торговцу");
        System.out.println("2. В темный лес");
        System.out.println("3. Выход");

    }

    private static void commitFight() {
        Realm.battleScene.fight(Realm.player, FantasyCharacter.createMonster(), new FightCallback() {
            @Override
            public void fightWin() {
                System.out.println(String.format("%s победил! Теперь у вас %d опыта и %d золота, а также осталось %d едениц здоровья.", Realm.player.getName(), Realm.player.getXp(), Realm.player.getGold(), Realm.player.getHealthPoints()));
                System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");
                try {
                    command(Realm.br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void fightLost() {

            }
        });
    }


}