public class Character {
    private String name;
    private int strength;
    private int health;
    private int stamina;
    private int speed;
    private int attackPower;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void run(){
        System.out.println(this.name + " runs!");
    }

    public String attack(String target){
      return this.name + " attacks " + target + "!";
    }

    public String heal(int healed) {
        this.health += healed;
        return this.name + " recovered " + healed + " HP!";
    }

    public String decreaseHealth(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            return this.name + " has died!";
        } else {
            return this.name + " took " + damage + " HP of damage! " + this.name + " has " + this.health + " HP remaining!";
        }
    }

    public String increaseStamina(int stam) {
        this.stamina += stam;
        return this.name + "'s stamina increased by " + stam + ", it is now"  + this.stamina + "!";
    }

    public String decreaseStamina(int stam) {
        this.stamina -= stam;
        return this.name + "'s stamina decreased by " + stam + ", it is now"  + this.stamina + "!";
    }


}
