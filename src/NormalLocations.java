public abstract class NormalLocations extends Location {

    NormalLocations(Player player, String name) {
        super(player);
        this.name = name;
    }

    @Override
    public boolean getLocation() {
        return true;
    }
}
