import java.io.*;
import java.util.*;

public class Fibonacci48 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.nextLine();
        
        while(T-->0){
            int n = scan.nextInt();
            System.out.println(n + " = " + findIndex(n-1));
        }
        
        }

    public static int findIndex(int n){
        
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else
            return findIndex(n-1) + findIndex(n-2);
        

    }
