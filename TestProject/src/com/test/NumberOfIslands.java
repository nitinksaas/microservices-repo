package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '1', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands: " + numIslands(grid)); // Output: 3
        
        HashSet<Integer> hashset = new HashSet<Integer>();
        hashset.add(1);
        hashset.add(6);
        hashset.add(2);
        hashset.add(5);
        hashset.add(1);
        hashset.add(3);
        hashset.add(2);	
        hashset.add(4);
        
        System.out.println(hashset);
    }
}