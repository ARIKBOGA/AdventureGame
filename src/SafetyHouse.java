public class SafetyHouse extends NormalLocations{
    SafetyHouse(Player player) {
        super(player, "Safety House");
    }

    @Override
    public boolean getLocation() {
        player.setHealthy(player.getReHealthy());
        System.out.println("You are fully HEALED !");
        System.out.println("You are in Safety House.");
        return true;
    }
}
