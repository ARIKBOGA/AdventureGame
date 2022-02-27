import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);

    public void login() {

        System.out.println("Welcome to Adventure Game !");
        System.out.print("Please enter your gamer name: ");
        player = new Player(scan.nextLine());
        start();
    }

    public void start() {
        System.out.println("\n==================================================================\n");
        while (true) {
            switch (selectAction()) {
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
                case 1:
                default:
                    location = new SafetyHouse(player);
            }
            if (!location.getLocation()) {
                System.out.println("GAME OVER !!!");
                break;
            }
        }
    }

    public int selectAction() {
        System.out.println("1. Safety House --> A safe location for you, there is no enemy !");
        System.out.println("2. Cave      --> You may encounter a Bear !");
        System.out.println("3. Forest    --> You may encounter a Zombie !");
        System.out.println("4. River     --> You may encounter a Vampire !");
        System.out.println("5. Gun shop  --> You can buy Weapons or Armor !");
        System.out.print("Select a location number to next action according to above explanations: ");
        int action = scan.nextInt();
        while (action < 1 || action > 5) {
            System.out.print("Please enter avalid number for selecting an action between 1-5: ");
            action = scan.nextInt();
        }
        return action;
    }
}
