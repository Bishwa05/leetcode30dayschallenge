package may.week2;

import java.util.*;

/**
 *
 * Example 1:
 *
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 * Example 2:
 *
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Example 3:
 *
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * Example 4:
 *
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * Example 5:
 *
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 *
 *
 */
public class FindTheTownJudge {

    public int findJudge(int N, int[][] trust) {



        Map<Integer, List<Integer>> judgeKeyMap= new HashMap<>();
        Set<Integer> followers = new HashSet<>();

        int  rows  = trust.length;
        if (rows ==0 && N ==1) return 1;

        for(int i =0; i< rows; i++){
            List<Integer> a = judgeKeyMap.get(trust[i][1]);
            if(a == null){
                a  = new ArrayList<>();
            }
            a.add(trust[i][0]);
            followers.add(trust[i][0]);
            judgeKeyMap.put(trust[i][1],a);
        }

        for(Map.Entry<Integer, List<Integer>> e : judgeKeyMap.entrySet()){
            List vals = e.getValue();
            if(vals.size() == N-1 && !followers.contains(e.getKey())){
                return e.getKey();
            }
        }

        return -1;

    }


    public int findJudgeOptimized(int N, int[][] trust) {
        if(trust.length<  N-1){
            return -1;
        }

        int [] inEdges = new int[N+1];
        int [] outEdges =new int[N+1];
        for(int[] relation :trust){
            outEdges[relation[0]]++;
            inEdges[relation[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (inEdges[i] == N - 1 && outEdges[i] == 0) {
                return i;
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        FindTheTownJudge c=new FindTheTownJudge();
//        int[][] trust = {{1,2}};
//        int N =2;

//        int[][] trust = {{1,3},{2,3}};
//         int N =  3;

//         int[][] trust = {{1,3},{2,3},{3,1}};
        int  N = 4;
         int [][] trust ={{1,3},{1,4},{2,3},{2,4},{4,3}};
        System.out.println(c.findJudge(N, trust));

    }
}
