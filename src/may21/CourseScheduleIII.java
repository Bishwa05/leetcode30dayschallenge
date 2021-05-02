package may21;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII
{
    public int scheduleCourse(int[][] courses){
        Arrays.sort(courses, (a, b) -> a[1]-b[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b-a);
        int time  = 0;
        for(int[] c: courses){
            if(time+ c[0] <=c[1]){
                queue.offer(c[0]);
                time +=c[0];
            } else if(!queue.isEmpty() && queue.peek()>c[0]){
                time+=c[0] - queue.poll();
                queue.offer(c[0]);
            }
        }
        return queue.size();
    }

    public static void main(String arg[]){
       int[][] courses = {{100,200},{200,1300},
                          {1000,1250},{2000,3200}};
        CourseScheduleIII c = new CourseScheduleIII();
        System.out.println(c.scheduleCourse(courses));

    }

}
