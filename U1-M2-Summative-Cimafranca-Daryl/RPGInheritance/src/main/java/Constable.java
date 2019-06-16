public class Constable extends Character {
    private String jurisdiction;

    public Constable() {
        this.setStrength(75);
        this.setHealth(100);
        this.setStamina(75);
        this.setSpeed(10);
        this.setAttackPower(1);
    }


    public String arrest(String target){
        return this.getName() + "arrests " + target + "!";
    }


}
