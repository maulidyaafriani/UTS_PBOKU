public abstract class Zombie {
    protected int health;
    protected int level;

    public Zombie(int health, int level) {
        this.health = health;
        this.level = level;
    }

    abstract void heal();
    abstract void destroyed();

    public String getZombieInfo() {
        return "Health = " + health + "\nLevel = " + level + "\n";
    }
    public int getHealth() {
    return health;
}

}
