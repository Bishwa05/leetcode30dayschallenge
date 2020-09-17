package sept.week3;

public class RobotBoundedInCircle
{
    public boolean isRobotBounded(String instructions) {
        char direction ='N';
        int x =0;
        int y =0;

        for(char ins : instructions.toCharArray()){
            if(ins == 'G'){
                if(direction == 'N'){
                    y++;
                } else if(direction =='S'){
                    y--;
                } else if(direction == 'W'){
                    x--;
                } else {
                    x++;
                }
            } else if(ins == 'L') {
                if(direction =='N'){
                    direction = 'W';
                } else if(direction == 'S'){
                    direction = 'E';
                } else if(direction == 'W'){
                    direction = 'S';
                } else{
                    direction = 'N';
                }
            } else {
                if(direction =='N'){
                    direction = 'E';
                } else if(direction == 'S'){
                    direction = 'W';
                } else if(direction == 'W'){
                    direction = 'N';
                } else{
                    direction = 'S';
                }
            }
        }
        return (x ==0 && y == 0)|| (direction != 'N');
    }
}
