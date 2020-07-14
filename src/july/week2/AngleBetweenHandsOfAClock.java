package july.week2;

public class AngleBetweenHandsOfAClock
{

    public double angleClock(int hour, int minutes) {
        double h = hour*360/12 + minutes*360/(12*60);

        double m = minutes*360/60;

        double angle = Math.abs(h-m);

        if(angle>180){
            angle = 360-angle;
        }
        return angle;

    }

}
