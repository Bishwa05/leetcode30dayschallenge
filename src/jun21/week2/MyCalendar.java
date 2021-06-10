package jun21.week2;


import java.util.ArrayList;
import java.util.List;

class Interval implements Comparable {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Object o){
        if(this.end>((Interval)o).start){
            return -1;
        } else{
            return 1;
        }
    }
}

public class MyCalendar
{


    List<Interval> intervalList;
    public MyCalendar() {
        intervalList = new ArrayList<>();

    }

    public boolean book(int start, int end) {

        if(intervalList.size() ==0) {
            Interval i = new Interval(start, end);
            intervalList.add(i);
            return true;
        }


        for(int i =0; i< intervalList.size(); i++){
            Interval curr = intervalList.get(i);
            if((start < curr.end && curr.start<= start) ||
                (curr.start <end && end<= curr.end) ||
                (start <= curr.start && end>=curr.end) ||
                (start >= curr.start && end <=curr.end)){
                return false;
            }
        }

        Interval i = new Interval(start, end);
        intervalList.add(i);
        return true;
    }

    public static void main (String[] args)
    {
        MyCalendar myCal = new MyCalendar();
        System.out.println(myCal.book(97, 100));
        System.out.println(myCal.book(33, 51));
        System.out.println(myCal.book(89, 100));
        System.out.println(myCal.book(83, 100));
        System.out.println(myCal.book(75, 92));
        System.out.println(myCal.book(76, 95));
        System.out.println(myCal.book(19, 30));
        System.out.println(myCal.book(53, 63));
        System.out.println(myCal.book(8, 23));
        System.out.println(myCal.book(18, 37));
        System.out.println(myCal.book(87, 100));
        System.out.println(myCal.book(83, 100));
        System.out.println(myCal.book(54, 67));
        System.out.println(myCal.book(35,48));

        System.out.println(myCal.book(58, 75));
        System.out.println(myCal.book(70, 89));
        System.out.println(myCal.book(13,32));
        System.out.println(myCal.book(44,63));
        System.out.println(myCal.book(51,62));
        System.out.println(myCal.book(2,15));




    }
}
