package aug21.week3;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku
{
    public boolean isValidSudoku(char[][] board) {
        boolean res = true;

        Set<Character> duplicateSet;

        int M = 9;
        int N = 9;

        for (int i = 0; i < M; i++) {
            char[] row = board[i];
            duplicateSet = new HashSet<>();
            for (char c : row) {
                if ('.' != c) {
                    if (!duplicateSet.add(c)) {
                        return false;
                    }
                }
            }
        }


        for (int i = 0; i < N; i++) {
            duplicateSet = new HashSet<>();
            for (int j = 0; j < M; j++) {
                char c = board[j][i];
                if ('.' != c) {
                    if (!duplicateSet.add(c)) {
                        return false;
                    }
                }
            }
        }

        // for each block
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {


                duplicateSet = new HashSet<>();
                for (int i = m * 3 + 0; i < (m * 3) + 3; i++) {
                    for (int j = n * 3 + 0; j < (n * 3) + 3; j++) {
                        char c = board[j][i];
                        if ('.' != c) {
                            if (!duplicateSet.add(c)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }


        return true;
    }
}
