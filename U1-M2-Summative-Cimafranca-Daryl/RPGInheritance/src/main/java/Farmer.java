public class Farmer extends Character {


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

}