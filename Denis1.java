import java.util.Scanner;


public class Denis
{




   public static  String reduceFraction(String fraction)
   {
       int num;


       String str1 = fraction.substring(0,fraction.indexOf("/"));
       num = Integer.parseInt(str1);
      
       int den;
       int count = 0;
    
    String str2 = fraction.substring(fraction.indexOf("/")+1,fraction.length());
       den = Integer.parseInt(str2);
       if(num>0&&den<0){
           den = Integer.parseInt(str2.substring(str2.indexOf("-")+1,str2.length()));
           count++;

       }
       int dcount = 0;
     

       int d;
       d = __gcd(num, den);


       num = num/ d;
       int den1 = den/ d;

       if(count>0){
           count=0;
           return "-"+num+"/"+den1;

       }
       if(Integer.parseInt(fraction.substring(0,fraction.indexOf("/")))<0&&num>0&&den1<0){
           return "-"+num+"/"+ -1*den1;

       }

   else
       return num + "/" + den1;

   }


   public static int __gcd(int a, int b)
   {
       if (b == 0)
           return a;
       return __gcd(b, a % b);


   }



   public static void main(String[] args)
   {


       Scanner key = new Scanner(System.in);
       int input = key.nextInt();
       key.nextLine();


       while(input --> 0){


           String inputFraction = key.nextLine();


           System.out.println(inputFraction + " reduced is " + reduceFraction(inputFraction));


       }
   }
}
