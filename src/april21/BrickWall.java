package april21;

import java.util.*;

/**
 *
 * The idea is straightforward, since each brick length is positive, we can record all the edge index in the wall and figure out which edge index is the most common. We cut through that edge index, it will cross number of rows - most common edge count rows
 *
 */
public class BrickWall
{
    public int leastBricks(List<List<Integer>> wall) {
        if(wall.size() ==0) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> list : wall){
            int len = 0;
            for(int i = 0; i<list.size()-1; i++){
                len += list.get(i);
                map.put(len, map.getOrDefault(len, 0)+1);
                count = Math.max(count, map.get(len));
            }
        }
        return wall.size()-count;

    }

    public static void main(String arg[]){
        List<List<Integer>> wall = Arrays.asList(
        Arrays.asList(1,2,2,1),
               Arrays.asList(3,1,2),
                Arrays.asList(1,3,2),
                    Arrays.asList(2,4),
                Arrays.asList(3,1,2),
                Arrays.asList(1,3,1,1));
        BrickWall b = new BrickWall();

        System.out.println(b.leastBricks(wall));
    }
}
