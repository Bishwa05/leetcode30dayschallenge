package july.week3;

/**
 *
 *
 * [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
 * "ABCB"
 *
 * char replacement is needed
 */
public class WordSearch
{

    public boolean dfs(char[][] board, String word, int i , int j, int pos){

        if(word.length() ==pos) {
            return true;
        }

        if(i<0 || i>= board.length || j<0 || j>= board[i].length || board[i][j] != word.charAt(pos)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] =' ';
            boolean found = dfs(board, word, i + 1, j,pos + 1)
                || dfs(board, word, i - 1, j,pos + 1)
                || dfs(board, word, i, j + 1,pos + 1)
                || dfs(board, word, i, j - 1,pos + 1);

        board[i][j] = temp;
        return found;
    }

    public boolean exist(char[][] board, String word) {

        for(int i =0; i<board.length; i++){
            for(int j =0; j <board[i].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, word, i,j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String arg[]){
        WordSearch w = new WordSearch();

        char [][]board =
            {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
            };

        System.out.println(w.exist(board, "ABCB"));
    }
}
