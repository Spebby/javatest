package ArraysOfLight;

public class Life 
{
    // create a 3x3 2D array of bacteria
    Bacteria[][] bacteria = new Bacteria[3][3];

    void Awake()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                bacteria[i][j] = new Bacteria();
            }
        }
    }
}