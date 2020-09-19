package sept.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits
{

    public List<Integer> sequentialDigits(int low, int high) {


        List<Integer> result = new ArrayList();

        for (int i =1; i<10; i++){
            int next = 0;

            for(int j =i; j<10; j++){
                next = next*10 +j;

                if(next>=low && next <= high){
                    result.add(next);
                } else if(next>high){
                    break;
                }
            }
        }
        Collections.sort(result);
    return result;
    }

    public static void main(String arg[]) {
        int l = 1000;
        int h = 13000;
        SequentialDigits s = new SequentialDigits();
        s.sequentialDigits(l,h).forEach(e -> System.out.println(e));
    }
}
