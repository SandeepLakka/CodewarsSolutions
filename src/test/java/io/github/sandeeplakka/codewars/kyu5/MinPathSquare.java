package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Minimum path in squares

You're given a square consisting of random numbers, like so:

var square = [
    [1,2,3],
    [4,8,2],
    [1,5,3]];

Your job is to calculate the minimum total cost when
moving from the upper left corner to the coordinate given.
You're only allowed to move right or down.

In the above example the minimum path would be:
var square = [
    [1,2,3],
    [_,_,2],
    [_,_,3]];

Giving a total of 11. Start and end position are included.

Note: Coordinates are marked as x horizontally and y vertically.

Categories : Dynamic Programming,Algorithms

 */
public class MinPathSquare {
    private static int[][] smallSquare = new int[][]
            {
                    {1, 2, 3, 6, 2, 8, 1},
                    {4, 8, 2, 4, 3, 1, 9},
                    {1, 5, 3, 7, 9, 3, 1},
                    {4, 9, 2, 1, 6, 9, 5},
                    {7, 6, 8, 4, 7, 2, 6},
                    {2, 1, 6, 2, 4, 8, 7},
                    {8, 4, 3, 9, 2, 5, 8}
            };

    @Test
    public void smallTests() {
        assertEquals(1, minPath(smallSquare, 0, 0));
        assertEquals(5, minPath(smallSquare, 0, 1));
        assertEquals(11, minPath(smallSquare, 2, 2));
        assertEquals(24, minPath(smallSquare, 4, 2));
        assertEquals(39, minPath(smallSquare, 6, 6));
        assertEquals(24, minPath(smallSquare, 4, 5));
    }

    //TODO implement memoized and then dp version of this
    public static int minPath(int[][] grid, int x, int y) {

        return minPathRecur(grid, x, y, 0, 0, 0);
    }

    public static int minPathRecur(int[][] grid, int x, int y, int xPos, int yPos, int sum) {
        if (xPos == x && yPos == y) {
            return sum + grid[yPos][xPos];
        }

        if (yPos > y || xPos > x) {
            return Integer.MAX_VALUE;
        }

        //if(memo[xPos][yPos] != -1) return memo[xPos][yPos];

        return /*memo[xPos][yPos] =*/ Math.min(
                minPathRecur(grid, x, y, xPos + 1, yPos, sum + grid[yPos][xPos]),
                minPathRecur(grid, x, y, xPos, yPos + 1, sum + grid[yPos][xPos])
        );

    }
}