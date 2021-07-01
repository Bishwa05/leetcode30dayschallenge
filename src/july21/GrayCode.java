package july21;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrayCode
{
    public List<Integer> grayCode(int n){
        List<Integer> result = new ArrayList<>();
        result.add(0);

        Set<Integer> isPresent = new HashSet<>();
        isPresent.add(0);
        grayCodeHelper(result, n, isPresent);
        return result;
    }

    public boolean grayCodeHelper(List<Integer> result, int n, Set<Integer> isPresent){
        if(result.size() ==(1<<n)) return true;

        int current = result.get(result.size()-1);

        for(int i =0; i<n; i++){
            int next = current ^ (1<<i);
            if(!isPresent.contains(next)){
                isPresent.add(next);
                result.add(next);
                // if valid sequence found no need to search further
                if(grayCodeHelper(result,n , isPresent)) return true;
                // if no valid sequence found delete the last added number and continue search;
                isPresent.remove(next);
                result.remove(result.size()-1);
            }
        }
        return false;
    }
}
