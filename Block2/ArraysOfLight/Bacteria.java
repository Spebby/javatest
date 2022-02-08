package ArraysOfLight;

public class Bacteria extends Entity
{
    int _generation; // the generation of the bacteria

    public int health;
    public int maxHealth;

    public boolean isAlive;
    boolean isStarving;
    int fights; // the number of fights the bacteria has had

    public Bacteria(int health) 
    {
        this.maxHealth = health;
        this.health = health;
    }
    public Bacteria(int health, int fights, boolean isStarving)// overload, meant for reproducton.
    {
        this.maxHealth = health;
        this.health = health;
    }

    public void Logic()
    {
        if(health <= 0)
        {
            die();
        }

        if(isStarving)
            health -= (int)maxHealth/6;
            // this makes starvation an equal threat to all bacteria, regardless of health.
    }

    public void takeDamage(int damage) 
    {
        this.health -= damage;
    }

    public void eat(Food food) 
    {
        this.health = maxHealth;
    }

    public void die()
    {
        isAlive = false;
        GameBoard.removeEntity(position);
    }

    public void reproduce()
    {
        die();
        GameBoard.addEntity(new Bacteria(maxHealth), this.position);
    }
}