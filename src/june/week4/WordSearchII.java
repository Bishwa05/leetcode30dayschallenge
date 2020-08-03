package june.week4;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII
{

    public boolean dfs(char[][] board, String word, int i, int j, int l){
        if(word.length() == l){
            return true;
        }

        if(i<0 || i>=board.length || j <0 || j>= board[i].length || board[i][j] != word.charAt(l)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] =' ';
        boolean found = dfs(board, word, i+1,j, l+1)
            || dfs(board, word, i-1,j, l+1)
            || dfs(board, word, i,j+1, l+1)
            || dfs(board, word, i,j-1, l+1);

        board[i][j] = temp;
        return found;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> output = new ArrayList<>();
        for(int k =0; k<words.length; k++){
            boolean flag = false;
            String word = words[k];
            for(int i =0;  i<board.length; i++){
                for(int j =0; j< board[0].length; j++){
                    if(dfs(board,word, i, j, 0)) {
                        flag = true;
                    }

                }
            }
            if(flag){
                output.add(word);
            }
        }
        return output;
    }


    public static void main(String arg[]){
        char [][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };

        String []words = {"oath","pea","eat","rain"};

        WordSearchII w2 = new WordSearchII();
        w2.findWords(board, words).forEach(e-> System.out.print(e));

    }

}
