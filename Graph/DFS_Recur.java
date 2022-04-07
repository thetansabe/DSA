import java.util.*;

public class DFS_Recur {
    public static void main(String[] args) {
        int[][] graph = {{0,1,0,0,0,0,0},
                         {0,0,1,1,1,0,0},
                         {0,0,0,0,0,1,0},
                         {0,0,0,0,0,1,1},
                         {0,0,0,0,0,0,1},
                         {0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0}};
        
        Set<Integer> traversedNodes = new HashSet<>();

        DFS_recur(0, traversedNodes, graph);
    }
    
    static void DFS_recur(int u, Set<Integer> visited, int[][] graph){
        //danh dau node vua duyet
        visited.add(u);
        //process
        System.out.print(u + " ");
        //duyet tat ca cac node neigbor cua u
        //v la` neighbor cua u
        for(int v = 0; v < graph.length ; v++){
            if(graph[u][v] == 1 && visited.contains(v) == false){
                DFS_recur(v, visited, graph);
            }
        }
    }
}
