package com.company.codingscales.leetcode.concepts.design;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class ValidSudoko {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Integer>> rows = new ArrayList<>();
        List<HashSet<Integer>> cols = new ArrayList<>();
        List<HashSet<Integer>> boxes = new ArrayList<>();
        
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }
        
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    HashSet<Integer> row = rows.get(i);
                    HashSet<Integer> col = cols.get(j);

                    int box_id = (i / 3) * 3 + j / 3; 
                    HashSet<Integer> box = boxes.get(box_id);
                    
                    int val = Character.getNumericValue(board[i][j]);
                    
                    if (row.contains(val) || col.contains(val) || box.contains(val)) {
                        return false;
                    }
                    
                    row.add(val);
                    col.add(val);
                    box.add(val);
                }
            }
        }
        
        return true;
    }
}
