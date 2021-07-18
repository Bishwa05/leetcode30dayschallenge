package july21.week3;

import java.util.HashSet;
import java.util.Set;

public class Test
{

    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();

        for(Character c : brokenLetters.toCharArray()){
            set.add(c);
        }

        int count =0;

        String[] wordArr = text.split(" ");

        for(String word : wordArr){
            boolean include = true;
            for( Character c: word.toCharArray()){
                if(set.contains(c)){
                    include = false;
                    break;
                }
            }
            if(include){
                count++;
            }
        }
        return count;
    }

    public int addRungs(int[] rungs, int dist) {

        if(rungs.length ==1){
            if(dist > rungs[0]) return 0;
            else {
                if(rungs[0]%dist==0){
                    return rungs[0]/dist-1;
                }
                return (int) rungs[0]/dist;
            }
        }

        int count=0;
        int diff = rungs[0]-0;
        if(diff>dist){
            if(rungs[0]%dist==0){
                count+= diff/dist-1;
            } else {
                count += diff / dist;
            }
        }
        for(int i =0, j = i+1; i< rungs.length-1; i++, j++){
            diff = rungs[j]-rungs[i];
            if(diff>dist){
                if(diff%dist==0){
                    count+= diff/dist-1;
                } else {
                    count += diff / dist;
                }
            }
        }

        return count;

    }

    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        int[][] dp = new int[m][n];


        for(int j =0; j<n; j++){
            dp[0][j] = points[0][j];
        }

        for(int i =1; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = max(dp[i-1][j] + points[i][j],
                    (j>0)?(dp[i-1][j-1] + points[i][j]):0,
                    (j!=n-1)?(dp[i-1][j+1] + points[i][j]):0);
            }
        }

        long max =0;
        for(int j =0; j<n; j++){
            if(dp[m-1][j]>max){
                max = dp[m-1][j];
            }
        }

        return max;
    }

    private int max(int a, int b, int c){
        int d = Math.max(b, c);
        if(d > a){

            return d-1;
        } else{

            return a;
        }
    }


    public static void main (String[] args)
    {
        Test t = new Test();
        //        int [] rungs = {18,30};
        //            int dist = 4;
        //        System.out.println(t.addRungs(rungs, dist));

        int[][] points = {{1,2,3},{1,5,1},{3,1,1}};

        System.out.println(t.maxPoints(points));
    }
}
