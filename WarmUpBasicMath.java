import java.io.*;
import java.util.*;
import java.lang.Math.*;
import java.text.DecimalFormat;

public class WarmUpBasicMath {


    public static void main(String[] args) {
     
        
        Scanner key = new Scanner(System.in);
        
        System.out.print("");
        int input = key.nextInt();
        
        ListNums(input);
        System.out.println();
        YesOrNo(input);
        piMulti(input);
        lcmMethod(input,4);
    }
    
    
    public static void ListNums(int num){
        for(int i = 1; i <= num; i++){
            System.out.print(i + " ");
        }
    }
    
    public static void YesOrNo(int num){
        if(num > 5 && num <=10){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
    
    public static void piMulti(int num){
        double pi = Math.PI;
        double Placeholder = num * pi;
        
        DecimalFormat obj = new DecimalFormat("#.######");
        System.out.println(obj.format(Placeholder));
    }
    
    public static void lcmMethod(int n1, int n2){
        
        int lcm;
        
        lcm = (n1>n2) ? n1 : n2;
        
        while(true){
            if(lcm%n1 == 0 & lcm % n2 == 0){
                System.out.print(lcm);
                break;
            }
            ++lcm;
        }
                
        
    }
}
