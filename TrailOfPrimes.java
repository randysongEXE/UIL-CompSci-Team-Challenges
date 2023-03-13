import java.util.*;


public class TrailOfPrimes {
   private final int X;
   private final LinkedList<Integer>[] list;




   TrailOfPrimes(int y)
   {
       this.X = y;
       list = new LinkedList[y];
       for (int i = 0; i < y; i++)
           list[i] = new LinkedList<>();
   }




   public void GraphEdge(int e1, int e2)
   {
       list[e1].add(e2);
       list[e2].add(e1);
   }


   public int BreadthFSearch(int n1, int n2)
   {
       int[] visited = new int[X];
       Arrays.fill(visited, 0);
       Queue<Integer> que = new LinkedList<>();
       visited[n1] = 1;
       que.add(n1);


       while (!que.isEmpty()) {
           int p = que.poll();
           for (int i : list[p]) {
               if (visited[i] == 0) {
                   visited[i] = visited[p] + 1;
                   que.add(i);
               }
               if (i == n2) {
                   return visited[i] - 1;
               }
           }
       }


       return 0;
   }


   public static int pathFinder(int n1, int n2)
   {


       LinkedList<Integer> link = new LinkedList<>();
       BoolArrayPrimes(link);


       Solution g = new Solution(link.size());
       for (int i = 0; i < link.size(); i++) {
           for (int j = i + 1; j < link.size(); j++) {
               if (compare(link.get(i), link.get(j)))
                   g.GraphEdge(i, j);
           }
       }


       int i1 = 0;
       int i2 = 0;
       for (int j = 0; j < link.size(); j++) {
           if (link.get(j) == n1)
               i1 = j;
       }


       for (int j = 0; j < link.size(); j++) {
           if (link.get(j) == n2)
               i2 = j;
       }


       return g.BreadthFSearch(i1, i2);
   }
  




   public static void BoolArrayPrimes(LinkedList<Integer> v)
   {


       int n = 9999;
       Boolean[] prime = new Boolean[n + 1];
       Arrays.fill(prime, true);


       for (int p = 2; p * p <= n; p++) {


           if (prime[p]) {


               for (int i = p * p; i <= n; i += p)
                   prime[i] = false;
           }
       }


       for (int p = 1000; p <= n; p++) {
           if (prime[p])
               v.add(p);
       }
   }








  public static Boolean compare(int n1, int n2)
   {
       char[] s1 = (Integer.toString(n1)).toCharArray();
       char[] s2 = (Integer.toString(n2)).toCharArray();
       int c = 0;
       if (s1[0] != s2[0])
           c++;
       if (s1[1] != s2[1])
           c++;
       if (s1[2] != s2[2])
           c++;
       if (s1[3] != s2[3])
           c++;


       return (c == 1);
   }


 
   public static void main(String[] args)
   {


       Scanner scan = new Scanner(System.in);




       int N1 = scan.nextInt();
       int N2 = scan.nextInt();






       int ans = pathFinder(N1, N2);
       System.out.println(ans);
   }
}

