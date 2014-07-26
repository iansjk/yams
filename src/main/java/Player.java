public class Player {
    private static int startingLife = 20;
    private int life = startingLife;

    public boolean isDead() {
        return life <= 0;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
