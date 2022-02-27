import java.util.Scanner;

public class Player {
    private int demage, healthy, money, reHealthy;
    private String name, charName;
    private Inventory inv;
    Scanner scan = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inv = new Inventory();
        selectCharacter();
    }

    public void selectCharacter() {
        characterMenu();
        System.out.print("Please select a character: ");
        int charID = scan.nextInt();
        while (charID < 1 || charID > 3) {
            System.out.print("Please enter a valid Character number between 1-3: ");
            charID = scan.nextInt();
        }
        switch (charID) {
            case 2:
                initPlayer("Archer", 7, 18, 20);
                break;
            case 3:
                initPlayer("Knigth", 8, 24, 5);
                break;
            case 1:
            default:
                initPlayer("Samurai", 5, 21, 15);
        }
        System.out.println("Your Character's Name: " + getCharName() + ", Demage: " + getDemage() + ", Healthy: " + getHealthy() + ", Money: " + getMoney());
    }

    public int getTotalDemage() {
        return this.getDemage() + this.getInv().getDemage();
    }

    private void initPlayer(String name, int demage, int healthy, int money) {
        setCharName(name);
        setHealthy(healthy);
        setDemage(demage);
        setMoney(money);
        setReHealthy(healthy);
    }

    private void characterMenu() {
        System.out.println("1- Samurai\tDemage: 5\tHealthy: 21 \tMoney: 15");
        System.out.println("2- Archer\tDemage: 7\tHealthy: 18 \tMoney: 20");
        System.out.println("3- Knight\tDemage: 8\tHealthy: 24 \tMoney: 5");
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getDemage() {
        return demage;
    }

    public void setDemage(int demage) {
        this.demage = demage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getReHealthy() {
        return reHealthy;
    }

    public void setReHealthy(int reHealthy) {
        this.reHealthy = reHealthy;
    }
}
