import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class recursionCls10 {
  public static boolean isSafe(int [][]maze, int n, int x, int y, int [][]visited){
     if ((x >= 0 && x < n)&& (y >= 0 && y < n)&& visited[x][y]==0 && maze[x][y]==1) {
       return true;
     }
     return false;
  }
    //  Rat in maze
   public static void printPath(ArrayList<String>path) {
     for (int i = 0; i < path.size(); i++) {
       System.out.print(path.get(i)+" ");
     }
     System.out.println();
   }
 public static void moveRat(int [][]maze, int n, int x, int y, int [][]visited,ArrayList<String>path) {
   if (x == n-1 && y == n-1) {
    printPath(path);
     return;
   }
    
     visited[x][y]=1;
     // down left right up
     // down
     int newx=x+1;
     int newy=y;
      if (isSafe(maze, n, newx, newy, visited)) {
        path.add("D");
       moveRat(maze, n, newx, newy, visited, path);
        path.remove("D");
      }
     // left
      newx=x;
      newy=y-1;
      if (isSafe(maze, n, newx, newy, visited)) {
        path.add("L");
       moveRat(maze, n, newx, newy, visited, path);
        path.remove("L");
      }
      // right
       newx=x;
       newy=y+1;
       if (isSafe(maze, n, newx, newy, visited)) {
         path.add("R");
        moveRat(maze, n, newx, newy, visited, path);
         path.remove("R");
       }
      // up
       newx=x-1;
       newy=y;
       if (isSafe(maze, n, newx, newy, visited)) {
         path.add("U");
        moveRat(maze, n, newx, newy, visited, path);
         path.remove("U");
       }
       
     visited[x][y]=0;

 }
  public static void ratMaze(int [][] maze,int n) {
    if (maze[0][0]==0) {
      System.out.println("rat can't enter in the maze");
      return;
    }

     int srcx=0;
     int srcy=0;
      
     int [][]visited=new int [n][n];

      for (int i = 0; i < visited.length; i++) {
          for (int j = 0; j < visited.length; j++) {
             visited[i][j]=0;
          }
      }
      
     ArrayList<String>path=new ArrayList<>();

    moveRat(maze,n,srcx,srcy,visited,path);

  }
  
    public static void main(String[] args) {
      int [][]maze={{1,0,0,0},
                    {1,1,0,0},
                    {1,1,0,0},
                    {0,1,1,1}};
 
       int n=maze.length;
     
       ratMaze(maze, n);
    
    }
}