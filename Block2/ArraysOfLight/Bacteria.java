package ArraysOfLight;

public class Bacteria extends Entity
{
    public int health;
    public int maxHealth;

    public boolean isAlive;

    public Bacteria(int health) 
    {
        this.maxHealth = health;
        this.health = health;
    }

    public void takeDamage(int damage) 
    {
        this.health -= damage;
        if(this.health <= 0)
        {
            
        }
    }

    public void eat(Food food) 
    {
        this.health = maxHealth;
    }

    public void die()
    {
        isAlive = false;
    }
}