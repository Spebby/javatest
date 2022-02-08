package ArraysOfLight;

public class Bacteria extends Entity
{
    public int health;

    public boolean isAlive;

    public Bacteria(int health) 
    {
        this.health = health;
    }

    public void takeDamage(int damage) 
    {
        this.health -= damage;
        if(this.health <= 0)
        {
            
        }
    }

    public void die()
    {
        isAlive = false;
    }
}