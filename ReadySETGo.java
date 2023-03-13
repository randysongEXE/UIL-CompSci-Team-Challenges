import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        TreeSet<Integer> set1 = new TreeSet<>();
        TreeSet<Integer> set2 = new TreeSet<>();

        
        
        String[] set1Array = input.nextLine().split(" ");
        for (String element : set1Array) {
            set1.add(Integer.parseInt(element));
        }

      
        
        String[] set2Array = input.nextLine().split(" ");
        for (String element : set2Array) {
            set2.add(Integer.parseInt(element));
        }

        
        TreeSet<Integer> union = new TreeSet<>(set1);
        union.addAll(set2);

        
        TreeSet<Integer> intersection = new TreeSet<>(set1);
        intersection.retainAll(set2);

        
        TreeSet<Integer> difference1 = new TreeSet<>(set1);
        difference1.removeAll(set2);

   
        TreeSet<Integer> difference2 = new TreeSet<>(set2);
        difference2.removeAll(set1);

        
        System.out.println(union.toString().replaceAll("[\\[\\],]", ""));
        System.out.println(intersection.toString().replaceAll("[\\[\\],]", ""));
        System.out.println(difference1.toString().replaceAll("[\\[\\],]", ""));
        System.out.println(difference2.toString().replaceAll("[\\[\\],]", ""));
    }
}
