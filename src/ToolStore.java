public class ToolStore extends NormalLocations {
    ToolStore(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean getLocation() {
        int selItemID;
        switch (showStoreMenu()) {
            case 1:
                selItemID = weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;
            case 3:
        }
        return true;
    }

    private void buyArmor(int selItemID) {
        int avoid = 0, price = 0;
        String armorName = null;
        switch (selItemID) {
            case 1:
                avoid = 1;
                armorName = "Slight";
                price = 15;
                break;
            case 2:
                avoid = 3;
                armorName = "Regular";
                price = 25;
                break;
            case 3:
                avoid = 5;
                armorName = "Solid";
                price = 40;
                break;
            case 4:
                System.out.println("Exiting !");
                break;
            default:
                System.out.println("Invalid entry !");
                break;
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInv().setArmor(avoid);
                player.getInv().setArmorName(armorName);
                player.setMoney(player.getMoney() - price);
                System.out.println("You have bought a " + armorName + ", Amount of damage blocked: "
                        + player.getInv().getArmor());
                player.setDemage(player.getTotalDemage());
            } else {
                System.out.println("Insufficient Balance !");
            }
        }
    }

    private int armorMenu() {
        System.out.println("1. Slight  :   < Money: 15 - Deamge: 1 >");
        System.out.println("2. Regular :   < Money: 25 - Deamge: 3 >");
        System.out.println("3. Solid   :   < Money: 40 - Deamge: 5 >");
        System.out.println("4. Exit.");
        System.out.print("Select a armor, please: ");
        int selectedArmor = scan.nextInt();
        while (selectedArmor < 1 || selectedArmor > 4) {
            System.out.println("Enter a valid number between 1-4 please: ");
            selectedArmor = scan.nextInt();
        }
        return selectedArmor;
    }

    private void buyWeapon(int selItemID) {
        int demage = 0, price = 0;
        String weaponName = null;
        switch (selItemID) {
            case 1:
                demage = 2;
                weaponName = "Gun";
                price = 25;
                break;
            case 2:
                demage = 3;
                weaponName = "Sword";
                price = 35;
                break;
            case 3:
                demage = 7;
                weaponName = "Rifle";
                price = 45;
                break;
            case 4:
                System.out.println("Exiting !");
                break;
            default:
                System.out.println("Invalid entry !");
                break;
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInv().setDemage(demage);
                player.getInv().setWeaponName(weaponName);
                player.setMoney(player.getMoney() - price);
                System.out.println("You have bought a " + weaponName + " Previous Demage : "
                        + player.getDemage() + " Current Deamge: " + player.getTotalDemage());
                player.setDemage(player.getTotalDemage());
            } else {
                System.out.println("Insufficient Balance !");
            }
        }
    }


    private int weaponMenu() {
        System.out.println("1. Gun  :   < Money: 25 - Deamge: 2 >");
        System.out.println("2. Sword:   < Money: 35 - Deamge: 5 >");
        System.out.println("3. Rifle:   < Money: 45 - Deamge: 7 >");
        System.out.println("4. Exit.");
        System.out.print("Select a weapon, please ");
        int selectedWeapon = scan.nextInt();
        while (selectedWeapon < 1 || selectedWeapon > 4) {
            System.out.println("Enter a valid number between 1-4 please: ");
            selectedWeapon = scan.nextInt();
        }
        return selectedWeapon;
    }

    private int showStoreMenu() {
        System.out.println("Money amount: " + player.getMoney());
        System.out.println("1. Weapons");
        System.out.println("2. Armors");
        System.out.println("3. Exit");
        System.out.print("Select a category, please: ");
        int selectedCategory = scan.nextInt();
        while (selectedCategory < 1 || selectedCategory > 3) {
            System.out.println("Enter a valid number between 1-3 please: ");
            selectedCategory = scan.nextInt();
        }
        return selectedCategory;
    }
}