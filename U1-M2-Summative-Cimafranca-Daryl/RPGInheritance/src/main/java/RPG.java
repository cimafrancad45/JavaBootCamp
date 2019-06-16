public class RPG {
    public static void main(String[] args) {
        Farmer farmer = new Farmer();
        Constable constable = new Constable();
        Warrior warrior = new Warrior();

        farmer.setName("David");

        System.out.println(farmer.plow());
    }
}

