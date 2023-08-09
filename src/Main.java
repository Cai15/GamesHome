import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    public static void main(String[] args) throws IOException {
        //Инициализируем BufferedReader
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        //Инициализируем класс для боя
        BattleScene battleScene = new BattleScene();
        //Первое, что нужно сделать при запуске игры, это создать персонажа, поэтому мы предлагаем ввести его имя
        System.out.println("Введите имя персонажа:");
        //Далее ждем ввод от пользователя
        try {
            Compiler.command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        private static void command (String string) throws IOException {
            //Если это первый запуск, то мы должны создать игрока, именем будет служить первая введенная строка из консоли
            if (player == null) {
                player = new Hero(
                        string,
                        100,
                        20,
                        20,
                        0,
                        0
                );
                System.out.println(String.format("Спасти наш мир от драконов вызвался %s! Да будет его броня крепка и бицепс кругл!", player.getName()));
                //Метод для вывода меню
                printNavigation();
            }
            //Варианты для команд
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
            //Снова ждем команды от пользователя
            command(br.readLine());
        }
    }

    private static void command(String any) {
    }

    private static void printNavigation() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К Торговцу");
        System.out.println("2. В темный лес");
        System.out.println("3. Выход");
    }
    private static void commitFight() {
        battleScene.fight(player, createMonster(), new FightCallback() {
            @Override
            public void fightWin() {
                System.out.println(String.format("%s победил! Теперь у вас %d опыта и %d золота, а также осталось %d едениц здоровья.", player.getName(), player.getXp(), player.getGold(), player.getHealthPoints()));
                System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");
                try {
                    command(br.readLine());
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