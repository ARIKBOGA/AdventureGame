public abstract class BattleLocations extends Location {
    protected Obstacle obstacle;

    BattleLocations(Player player, String name, Obstacle obstacle) {
        super(player);
        this.name = name;
        this.obstacle = obstacle;

    }

    @Override
    public boolean getLocation() {
        int obsCount = obstacle.obstacleCount();
        System.out.println("Current Location is :" + this.getName());
        System.out.println("Be Carefull ! There are " + obsCount + " " + obstacle.getName() + ".");
        System.out.println("<F>ight or <E>scape : ");
        String selectedCase = scan.next().toUpperCase();
        if (selectedCase.equals("F")) {
            if (fight(obsCount)) {
                System.out.println("You defeated the all enemies at " + this.getName());
            } else {
                System.out.println("You are dead !!! ");
                return false;
            }
        }
        return true;
    }

    public boolean fight(int obsCount) {
        for (int i = 0; i < obsCount; i++) {
            playerStats();
            enemyStats();
        }
        return true;
    }

    private void playerStats() {
        System.out.println("Player Stats: ");
        System.out.println("Health: " + player.getHealthy() + ", Demage: " + player.getDemage()
                + ", Money : " + player.getMoney());
        if (player.getInv().getDemage() > 0) {
            System.out.println("Weapon: " + player.getInv().getWeaponName());
        }
        if (player.getInv().getArmor() > 0) {
            System.out.println("Armor: " + player.getInv().getArmorName());
        }
    }

    private void enemyStats() {
        System.out.println(obstacle.getName() + " Stats");
        System.out.println("Health: " + obstacle.getHealthy() + ", Demage: " + obstacle.getDemage()
                + ", Award : " + obstacle.getAward());
    }
}