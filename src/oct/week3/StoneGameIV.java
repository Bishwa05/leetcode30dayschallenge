package oct.week3;

/**
 *
 * Alice and Bob take turns playing a game, with Alice starting first.
 *
 * Initially, there are n stones in a pile.  On each player's turn, that player makes a move consisting of removing any non-zero square number of stones in the pile.
 *
 * Also, if a player cannot make a move, he/she loses the game.
 *
 * Given a positive integer n. Return True if and only if Alice wins the game otherwise return False, assuming both players play optimally.
 *
 *                              7
 *              A=1                    A=4
 *                  6                   3
 *         B =1         B =4             B=1
 *          5              2                2
 *     A=1     A=4      A=1              A=1
 *      4       1          1                1
 *      B       B           B               B
 *
 *
 *
 *
 *
 */
public class StoneGameIV
{
    Boolean[] dp = new Boolean[100001];

    public boolean winnerSqaureGame(int n){
        if(n == 0) return false;
        if(dp[n] != null) return dp[n];
        boolean winner = false;
        for(int i =1; i*i <= n; i++){
            if(!winnerSqaureGame(n-i*i)){
                winner = true;
                break;
            }
        }
        return dp[n] = winner;
    }
}
