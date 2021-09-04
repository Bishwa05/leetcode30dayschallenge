package sept21;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Point{
    int x;
    int y;
}
public class ErectTheFence
{
    public List<Point> outerTrees(Point[] points){
        Point first = points[0];
        int firstIndex = 0;
        //find the leftmost point
        for(int i=0; i< points.length; i++){
            Point point = points[i];
            if(point.x<first.x){
                first = point;
                firstIndex = i;
            }
        }

        Set<Point> answer = new HashSet<>();
        Point cur = first;
        int curIndex = firstIndex;
        answer.add(first);

        do{
            Point next = points[0];
            int nextIndex = 0;
            for(int i =1; i<points.length; i++){
                if(i==curIndex) continue;
                Point p = points[i];
                int cross = crossProductLength(p, cur, next);
                if(nextIndex == curIndex || cross>0||
                // handle nulti points in a line
                    (cross == 0 && distance(p, cur)> distance(next, cur))){
                    next = p;
                    nextIndex = i;
                }
            }

            // Handle multi points in a line
            for(int i =0; i<points.length; i++){
                Point p = points[i];
                int cross = crossProductLength(p, cur, next);
                if(i != curIndex && cross ==0){
                    answer.add(p);
                }
            }
            cur= next;
            curIndex = nextIndex;
        } while(curIndex != firstIndex);
        return new ArrayList<>(answer);
    }

    private int crossProductLength(Point A, Point B, Point C){
        int BAx = A.x - B.x;
        int BAy = A.y - B.y;
        int BCx = C.x - B.x;
        int BCy = C.y - B.y;

        // calc the Z coordinate of the cross product.
        return (BAx * BCy - BAy* BCx);
    }

    private int distance(Point p1, Point p2){
        return (p1.x - p2.x) * (p1.x - p2.x) +
            (p1.y - p2.y) * (p1.y - p2.y);
    }
}
