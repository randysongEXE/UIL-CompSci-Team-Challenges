import java.util.*;
public class CountingIslands1{
    private int n;
    private int m;
    
    public int numIslands(int[][] grid){
        int count = 0;
        n = grid.length;
        
        if(n == 0) return 0;
        m = grid[0].length;
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(grid[i][j] == 1){
                    DFS(grid, i, j);
                    ++count;
                }
        return count;
    }
    
    public void DFS(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 1) return;
        
        grid[i][j] = 0;
        
        DFS(grid, i+1, j);
        DFS(grid, i-1, j);
        DFS(grid, i, j+1);
        DFS(grid, i, j-1);
        
    }
    
    

    
    public static void main(String args[]){
        
        Scanner key = new Scanner(System.in);
        
        int[][] test = new int[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                test[i][j] = key.nextInt();
            }
        }
        
        
        
      
        Solution obj = new Solution();
        System.out.println(obj.numIslands(test));
        
        }
}
    
    
