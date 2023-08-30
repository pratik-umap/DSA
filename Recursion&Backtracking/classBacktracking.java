import java.util.*;

public class classBacktracking {
    public static boolean isSafe(int maze[][],int n,int x,int y,int visited[][]) {
        
        if ((x >= 0 && x < n) && (y >= 0 && y < n) && maze[x][y]==1 &&visited[x][y]==0) {
            return true;
        }
        return false;
    }

    public static void printPath(ArrayList<String>ans) {
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
        }
        System.out.println();
    }
    public static void moveRat(int maze[][],int n,int x,int y,int visited[][],ArrayList<String>ans) {
        if (x==n-1 && y==n-1) {
            printPath(ans);
            return;
        }

        visited[x][y]=1;
           // down left right up
           // down
        int newx=x+1;
        int newy=y;
        if (isSafe(maze,n,newx,newy,visited)) {
            ans.add("D");
            moveRat(maze, n, newx, newy, visited, ans);
            ans.remove("D");
        }
        // left
        newx=x;
        newy=y-1;
        if (isSafe(maze,n,newx,newy,visited)) {
            ans.add("L");
            moveRat(maze, n, newx, newy, visited, ans);
            ans.remove("L");
        }
        // right
        newx=x;
        newy=y+1;
        if (isSafe(maze,n,newx,newy,visited)) {
            ans.add("R");
            moveRat(maze, n, newx, newy, visited, ans);
            ans.remove("R");
        }
        // up
         newx=x-1;
         newy=y;
        if (isSafe(maze,n,newx,newy,visited)) {
            ans.add("U");
            moveRat(maze, n, newx, newy, visited, ans);
            ans.remove("U");
        }
        
          visited[x][y]=0;
    }
   public static void ratInMaze(int maze[][],int n) {
     if (maze[0][0]==0) {
        System.out.println("rat can't enter in maze");
        return;
     }

     int visited[][]=new int[n][n];
     for (int i = 0; i < visited.length; i++) {
        for (int j = 0; j < visited.length; j++) {
            visited[i][j]=0;
        }
     }

     ArrayList<String>ans=new ArrayList<>();
     int x=0,y=0;
    moveRat(maze,n,x,y,visited,ans);
     
   }
   public static boolean isPossible(int arr[][],int n,int row,int col) {
       for (int i = 0; i < n; i++) {
          if(arr[i][col] == 1 ) return false;
       }
        // upper leftside
       for (int i = row,j=col; i>=0 && j>=0; i--,j--) {
          if (arr[i][j]==1) {
            return false;
          }
       }
        // upper rightside
       for (int i = row,j=col; i>=0 && j < n; i--,j++) {
        if (arr[i][j]==1) {
          return false;
        }
     }
     return true;
   }
   public static boolean nQueen(int arr[][],int n,int row) {
      if (row==n) {
        return true;
      }  
      for (int col = 0; col < n; col++) {
         if (isPossible(arr,n,row,col)) {
            arr[row][col]=1;
            if (nQueen(arr, n, row+1)) {
                return true;
            }
            arr[row][col]=0;
         }
      }
      return false;
   }
    public static void main(String[] args) {
        // int maze[][]={
        //     {1,0,0,0},
        //     {1,1,0,0},
        //     {1,1,0,0},
        //     {0,1,1,1}};

        // int n=maze.length;
    //   ratInMaze(maze, n);

      int m=4;
    int arr[][]=new int[m][m];
    nQueen(arr, m, 0);
    
    for (int[] array : arr) {
        for (int e: array) {
            System.out.print(e +" ");
        }
        System.out.println();
    }

    }
}
