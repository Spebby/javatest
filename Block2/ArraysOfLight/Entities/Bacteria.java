package ArraysOfLight.Entities;

import ArraysOfLight.GameBoard;

public class Bacteria extends Entity
{
    int _generation; // the generation of the bacteria

    public int health;
    public int maxHealth;
    public int damage; // amount of damage the bacteria deals

    public boolean isAlive = true;
    boolean isStarving;
    boolean inCombat;
    boolean shouldFlee;
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

        if(fights > 0 && (int)Math.random() * 10 >= 9)
            this.fights = fights;
        else
            this.fights = 0;
    }

    public void Logic()
    {
        if(isStarving && inCombat)
            shouldFlee = true;

        if(isStarving)
            health -= (int)maxHealth/6;

        if(health <= 0)
        {
            Die();
            return;
        }
        
            // this makes starvation an equal threat to all bacteria, regardless of health.
    }

    public void TakeDamage(int damage) 
    {
        this.health -= damage;
    }

    public void Eat(Food food) 
    {
        this.health = maxHealth;
        GameBoard.removeEntity(food);
    }

    public void Die()
    {
        isAlive = false;
        GameBoard.removeEntity(position);
    }

    public void reproduce()
    {
        Die();
        GameBoard.addEntity(new Bacteria(maxHealth), this.position);
    }
}