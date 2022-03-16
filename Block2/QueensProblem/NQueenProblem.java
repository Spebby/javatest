// This code is contributed by Abhishek Shankhadhar, https://www.geeksforgeeks.org/n-queen-problem-recursion-3/

package QueensProblem;
import java.util.Scanner;


public class NQueenProblem 
{
    static int N = 8;

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of the board: ");
        N = scan.nextInt(); scan.close();

        NQueenProblem Queen = new NQueenProblem();
        Queen.solveNQ();
    }
 
    /* A utility function to print solution */
    void printSolution(int board[][])
    {
        char ch = '-';
        for (int i = 0; i < N; i++) 
        {
            for (int j = 0; j < N; j++)
            {
                if(board[i][j] == 1)
                    ch = 'Q';

                System.out.print(" " + ch + " ");
                ch = '-';
            }
            System.out.println();
        }
    }
 
    /** @return If a Queen is "safe" */
    boolean isSafe(int board[][], int row, int col)
    {
        int i, j;
 
        // left side check
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
 
        // upper diagonal: left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
 
        // lower diagonal: left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;
 
        return true;
    }
 
    /** A recursive utility function to solve N Queen problem */
    boolean solveNQUtil(int board[][], int col)
    {
        // base case
        if (col >= N)
            return true;
 
        // try placing this queen in all rows one by one
        for (int i = 0; i < N; i++) 
        {
            if (isSafe(board, i, col)) 
            {
                board[i][col] = 1;
 
                // recur to place rest of the queens
                if (solveNQUtil(board, col + 1) == true)
                    return true;
 
                // if placing the Queen doesn't lead to a sollution, remove the queen
                board[i][col] = 0; // BACKTRACK
            }
        }
 
        return false;
    }
 
    /** Solves the N Queen problem using recursion.
       @return False if queens cannot be placed, otherwise, return true and prints placement of queens. */
    boolean solveNQ()
    {
        int board[][] = new int[N][N];
 
        if (solveNQUtil(board, 0) == false) 
        {
            System.out.print("Solution does not exist");
            return false;
        }
 
        printSolution(board);
        return true;
    }
}