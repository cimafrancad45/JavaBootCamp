public class Warrior extends Character {

    private int shieldStrength;

    public Warrior() {
        this.setStrength(75);
        this.setHealth(100);
        this.setStamina(100);
        this.setSpeed(50);
        this.setAttackPower(10);
        setShieldStrength(100);
    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }

    public String shieldBlock(int damage) {
        shieldStrength -= damage;
        return "Attack blocked with shield! " + damage + " damage blocked!";
    }
}
