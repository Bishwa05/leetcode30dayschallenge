package july.week3;

public class AddBinary
{

    public String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int i =a.length()-1; int j =b.length()-1;
        int carry =0;
        while(i>=0 && j >=0) {
            if(a.charAt(i)=='1' && b.charAt(j)=='1'){
                s.append(carry);
                carry =1;
            } else if(a.charAt(i)=='0' && b.charAt(j)=='0'){
                s.append(carry);
                carry =0;
            }else if((a.charAt(i)=='0' && b.charAt(j)=='1') ||
                (a.charAt(i)=='1' && b.charAt(j)=='0')){
                    if(carry==1)
                        s.append("0");
                    else
                        s.append("1");
            }
            i--;
            j--;
        }

        if(i>=0){
            while(i>=0){
                if(carry ==0){
                    s.append(a.charAt(i));
                } else{
                    if(a.charAt(i)=='0'){
                        s.append(carry);
                        carry=0;
                    } else if(a.charAt(i)=='1'){
                        s.append(0);
                    }
                }
                i--;
            }
        }

        if(j>=0){
            while(j>=0){
                if(carry ==0){
                    s.append(b.charAt(j));
                } else{
                    if(b.charAt(j)=='0'){
                        s.append(carry);
                        carry=0;
                    } else if(b.charAt(j)=='1'){
                        s.append(0);
                    }
                }
                j--;
            }
        }

        if(carry ==1)
            s.append(carry);

        return s.reverse().toString();
    }

    public static  void main(String arg[]){
        AddBinary a = new AddBinary();
        System.out.println(a.addBinary("110010", "10111"));
    }
}
