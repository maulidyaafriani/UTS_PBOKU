public class JumpingZombie extends Zombie {
    public JumpingZombie(int health, int level) {
        super(health, level);
    }

    @Override
    public void heal() {
        switch (level) {
            case 1 -> health += health * 0.3;
            case 2 -> health += health * 0.4;
            case 3 -> health += health * 0.5;
        }
    }

    @Override
    public void destroyed() {
        health -= health * 0.1;
        if (health < 0) health = 0;
    }

    @Override
    public String getZombieInfo() {
        return "Jumping Zombie Info:\n" + super.getZombieInfo();
    }
}
