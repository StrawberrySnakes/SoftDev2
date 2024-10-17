package unit03.gvt;

public interface Combat {
    Attack attack();
    void takeDamage(Attack attack);
    boolean isAlive();
    void regenerate();
}
