package august.week2;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII
{
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        if (rowIndex < 0)
            return result;

        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = result.size() - 2; j >= 0; j--) {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }
            result.add(1);
        }
        return result;
    }

    public static void main(String arg[]){

        PascalsTriangleII p = new PascalsTriangleII();
        p.getRow(3).forEach(e -> System.out.println(e));
    }
}
