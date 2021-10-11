public class FindNearest
{
    public void Find(Vector2Int pos)
    {
        // Iterates 2000 times
        for (int d = 1; d < 2000; d++)
        {
            for (int i = 0; i < d + 1; i++)
            {
                // Check point (x1, y1)
                int x1 = pos.x - d + i;
                int y1 = pos.y - i;
                // Check point (x2, y2)
                int x2 = pos.x + d - i;
                int y2 = pos.y + i;
            }
            for (int i = 1; i < d; i++)
            {
                // Check point (x1, y1)
                int x1 = pos.x - i;
                int y1 = pos.y + d - i;
                // Check point (x2, y2)
                int x2 = pos.x + i;
                int y2 = pos.y - d + i;
            }
        }
        
        
    }
}