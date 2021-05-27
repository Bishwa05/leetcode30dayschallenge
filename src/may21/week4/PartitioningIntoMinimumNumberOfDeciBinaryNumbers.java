package may21.week4;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers
{
    public int minPartitions(String n) {
        int result = Integer.MIN_VALUE;
        char cArr[] = n.toCharArray();
        for(int i = 0;i <cArr.length;i++)
        {
            int val = cArr[i] - '0';
            result = Math.max(val,result);
        }
        return result;
    }
}
