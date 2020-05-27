package may.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Graph building. Apparently, there are N nodes in the graph and each node
 * represents a person. For any two person who dislikes each other, create a
 * edge between the two nodes.
 *
 * Graph coloring. Each node in the group can be colored with 0 or 1 which
 * denotes the group the person belongs to. The color of each node is initiated
 * to -1. We traverse each node to color it and nodes that connected to
 * current node. For any edge in the graph, if the colors of its two nodes
 * are equal, then contradiction occurs which means we can not split these
 * people in two groups. Otherwise, we can split them in two groups.
 *
 */
public class PossibleBipartition {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        // 1. Create the graph
        List<Integer> dislikeArray[] = new List[N + 1];
        for(int i = 0; i < dislikeArray.length; i++) {
            dislikeArray[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < dislikes.length; i++) {
            dislikeArray[dislikes[i][0]].add(dislikes[i][1]);
            dislikeArray[dislikes[i][1]].add(dislikes[i][0]);
        }

        // 2. Color the graph
        int group[] = new int[N + 1];
        Arrays.fill(group, -1);
        for(int i = 1; i <= N; i++) {
            if( group[i] == -1 && !paint(group, i, dislikeArray, 0) )
                return false;
        }
        return true;
    }

    public boolean paint(int group[], int index, List<Integer> dislikeArray[], int color) {
        group[index] = color;
        for(int i = 0; i < dislikeArray[index].size(); i++) {
            int nextIndex = dislikeArray[index].get(i);
            if( group[nextIndex] == color )
                return false;
            if( group[nextIndex] == -1 && !paint(group, nextIndex, dislikeArray, 1 - color))
                return false;
        }
        return true;
    }

    public static void main(String arg[]){

        PossibleBipartition p = new PossibleBipartition();
        int N = 4; int[][] dislikes = {{1,2},{1,3},{2,4}};
        System.out.println(p.possibleBipartition(N, dislikes));

    }
}
