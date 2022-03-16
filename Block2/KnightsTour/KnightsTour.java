// Code by SaeedZarinfam, https://www.geeksforgeeks.org/warnsdorffs-algorithm-knights-tour-problem/

package KnightsTour;
import java.util.concurrent.ThreadLocalRandom;
 
class GFG
{
    public static final int SIZE = 8;
    
    public static void main(String[] args)
    {
        // While we don't get a solution
        while (!new GFG().findClosedTour())
        {
            ;
        }
    }

    /** Displays the chessboard with all the legal knight's moves */
    void print(int board[])
    {
        for (int i = 0; i < SIZE; ++i)
        {
            String space = " ";
            for (int j = 0; j < SIZE; ++j)
            {
                if(board[j * SIZE + i] > 9)
                    space = " ";
                else
                    space = "  ";
                System.out.print(board[j * SIZE + i] + space);
                
            }
            System.out.printf("\n");
        }
    }
 
    /** Move pattern on basis of the change of x coordinates and y coordinates respectively */
    public static final int cx[] = {1, 1, 2, 2, -1, -1, -2, -2};
    public static final int cy[] = {2, -2, 1, -1, 2, -2, 1, -1};
 
    /** Function restricts the knight to remain within the 8x8 chessboard */
    boolean limits(int x, int y)
    {
        return ((x >= 0 && y >= 0) &&
                 (x < SIZE && y < SIZE));
    }
 
    /** Checks whether a square is valid and empty or not */
    boolean isempty(int a[], int x, int y)
    {
        return (limits(x, y)) && (a[y * SIZE + x] < 0);
    }
 
    /* Returns the number of empty squares
    adjacent to (x, y) */
    int getDegree(int a[], int x, int y)
    {
        int count = 0;
        for (int i = 0; i < SIZE; ++i)
            if (isempty(a, (x + cx[i]),
                           (y + cy[i])))
                count++;
 
        return count;
    }
 
    /** Picks next point using Warnsdorff's heuristic.
    // @return false if it is not possible to pick next point. */
    Cell nextMove(int a[], Cell cell)
    {
        int min_deg_idx = -1, c,
            min_deg = (SIZE + 1), nx, ny;
 
        // Try all N adjacent of (*x, *y) starting from a random adjacent. Find the adjacent with minimum degree.
        int start = ThreadLocalRandom.current().nextInt(1000) % SIZE;
        for (int count = 0; count < SIZE; ++count)
        {
            int i = (start + count) % SIZE;
            nx = cell.x + cx[i];
            ny = cell.y + cy[i];
            if ((isempty(a, nx, ny)) &&
                (c = getDegree(a, nx, ny)) < min_deg)
            {
                min_deg_idx = i;
                min_deg = c;
            }
        }
 
        // IF we could not find a next cell
        if (min_deg_idx == -1)
            return null;
 
        // Store coordinates of next point
        nx = cell.x + cx[min_deg_idx];
        ny = cell.y + cy[min_deg_idx];
 
        // Mark next move
        a[ny * SIZE + nx] = a[(cell.y) * SIZE +
                           (cell.x)] + 1;
 
        // Update next point
        cell.x = nx;
        cell.y = ny;
 
        return cell;
    }
 
    /* checks its neighbouring squares */
    /* If the knight ends on a square that is one
    knight's move from the beginning square,
    then tour is closed */
    boolean neighbour(int x, int y, int xx, int yy)
    {
        for (int i = 0; i < SIZE; ++i)
            if (((x + cx[i]) == xx) &&
                ((y + cy[i]) == yy))
                return true;
 
        return false;
    }
 
    /* Generates the legal moves using warnsdorff's
    heuristics. Returns false if not possible */
    boolean findClosedTour()
    {
        // Filling up the chessboard matrix with -1's
        int board[] = new int[SIZE * SIZE];
        for (int i = 0; i < SIZE * SIZE; ++i)
        board[i] = -1;
 
        // initial position
        int sx = 3;
        int sy = 2;
 
        // Current points are same as initial points
        Cell cell = new Cell(sx, sy);
 
        board[cell.y * SIZE + cell.x] = 1; // Mark first move.
 
        // pick next points
        Cell ret = null;
        for (int i = 0; i < SIZE * SIZE - 1; ++i)
        {
            ret = nextMove(board, cell);
            if (ret == null)
                return false;
        }
 
        // Check if tour is closed (Can end
        // at starting point)
        if (!neighbour(ret.x, ret.y, sx, sy))
            return false;
        
        int[][] printed = new int[SIZE][SIZE];
        // populated printed with board's members in an 8x8 configuartion
        for (int i = 0; i < SIZE; ++i)
            for (int j = 0; j < SIZE; ++j)
                printed[i][j] = board[j * SIZE + i];
        ChessPrint.PrintChess(printed);
        return true;
    }
}