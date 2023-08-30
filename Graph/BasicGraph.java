package Graph;
import java.util.*;

public class BasicGraph {
    static class graphUsingMatrix{
        int a[][];
        int v;
        graphUsingMatrix(int v){
            this.v=v;
            a=new int[v][v];
        }

        public void addEdge(int src,int desc) {
            a[src][desc]=1;
            a[desc][src]=1;
        }
    }
    static class graphUsingList{
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        int v;
        graphUsingList(int v){
            this.v=v;
            for (int i = 0; i < v; i++) {
                 list.add(new ArrayList<>());
            }
        }
        public void addEdge(int src,int desc) {
            list.get(src).add(desc);
            list.get(desc).add(src);
        }
        public  void DFS(int src,boolean vis[]) {
            vis[src]=true;
            System.out.print(src +" ");
    
            for (Integer neighbour :list.get(src)) {
                if (!vis[neighbour]) {
                    DFS(neighbour, vis);
                }
            }
        }
        public void dfsUsingStack(int src,boolean vis[]){
            ArrayDeque<Integer>s=new ArrayDeque<>();
            s.push(src);
            vis[src]=true;
            while(!s.isEmpty()){
                int cur=s.pop();
                System.out.print(cur+" ");
                for (Integer neightbour : list.get(cur)) {
                    if (!vis[neightbour]) {
                        s.push(neightbour);
                        vis[neightbour]=true;
                    }
                }
            }
        }
        public void BFS(int src,boolean vis[],int Dis[]) {
            Queue<Integer>q=new LinkedList<>();
            q.add(src);
            vis[src]=true;
             Dis[src]=0;

            while (!q.isEmpty()) {
                int cur=q.poll();
                System.out.println(cur+" ");

                for (Integer neighbour :list.get(cur)) {
                    if (!vis[neighbour]) {
                        Dis[neighbour]=Dis[cur]+1;
                        q.add(neighbour);
                        vis[neighbour]=true;
                    }
                }
            }
        }
        // undirected graph 
        public  boolean isCyclePresent(int src,boolean vis[],int parent) {
            vis[src]=true;
            // System.out.print(src +" ");
    
            for (Integer neighbour :list.get(src)) {
                if (!vis[neighbour]) {
                   if (isCyclePresent(neighbour, vis,src)) return true;
                }else if (neighbour != parent) {
                    return true;
                }
            }
            return false;
        }

    }

    public static void main(String[] args) {
        int v=6;
        graphUsingList g=new graphUsingList(v);

        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 4);
        g.addEdge(3, 4);

        boolean vis[]=new boolean[v];
        //  g.BFS(0, vis);

            // g.dfsUsingStack(0, vis);

        // no of componenent in graph
        // int cnt=0;
        // for (int i = 0; i < v; i++) {
        //     if (!vis[i]) {
        //         cnt++;
        //        g.DFS(i, vis);
        //     }
        // }
        // System.out.println();
        // System.out.println(cnt);

        // shortest path in graph 
        //  int Dis[]=new int[v];
        //  g.BFS(0, vis,Dis);

        //  for (int i : Dis) {
        //     System.out.print(i+" ");
        //  }
        
        // cycle present in graph 
        // System.out.println(g.isCyclePresent(0, vis, -1));

    }
}
