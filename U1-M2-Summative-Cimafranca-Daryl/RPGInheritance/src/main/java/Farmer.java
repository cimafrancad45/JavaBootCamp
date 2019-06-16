public class Farmer extends Character {
    private int vegetables = 0;


    public Farmer() {
        this.setStrength(75);
        this.setHealth(100);
        this.setStamina(75);
        this.setSpeed(10);
        this.setAttackPower(1);
    }

    public String plow(){
        return this.getName() + " plows the fields!";
    }

    public String harvest(int amount) {
        vegetables =+ amount;
        return this.getName() + "harvests the crops! Get one vegetable!";
    }

    public int getVegetables() {
        return vegetables;
    }

    public void setVegetables(int vegetables) {
        this.vegetables = vegetables;
    }

}