package oct.week3;

import java.util.Arrays;

/**
 *
 * Solution is straightforward.
 * Always aim for highest point
 * Sort the tokens so we can buy from lowest & sell from highest which means =>
 *      If we have enough power, no worries. Just lose token[l(eft)], and increase score by 1.
 *      If we have at least 1 score and we are not in the last processed token, gain token[r(ight)] and decrease score by 1.
 *      Otherwise, we are finished.
 *
 */
public class BagOfTokens
{

    public int bagOfTokensScore(int[] tokens, int p){
        Arrays.sort(tokens);
        int res =0, points =0, i=0, j = tokens.length-1;
        while(i<=j){
            if(p>=tokens[i]){
                p-=tokens[i++];
                res = Math.max(res, ++points);
            } else if(points>0){
                points--;
                p+=tokens[j--];
            }  else {
                break;
            }
        }
        return res;
    }

    public static void main(String arg[]){
        BagOfTokens b = new BagOfTokens();
        int[] tokens = {100,200,300,400};
        int P = 200;
        System.out.println(b.bagOfTokensScore(tokens, P));
    }
}
