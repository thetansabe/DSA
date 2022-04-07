import java.util.*;

public class DFS_Stack{
    public static void main(String[] args) {
        int[][] graph = {{0,1,0,0,0,0,0},
                         {0,0,1,1,1,0,0},
                         {0,0,0,0,0,1,0},
                         {0,0,0,0,0,1,1},
                         {0,0,0,0,0,0,1},
                         {0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0}};

        Stack<Integer> stack = new Stack<>();
        Set<Integer> traversedNodes = new HashSet<>();
        
        //add node dau tien + danh dau 
        stack.add(0);
        traversedNodes.add(0);

        //thuc hien thuat toan DFS
        while(!stack.isEmpty()){
            int u = stack.pop();
            //process u
            System.out.print(u + " ");
            //add tat ca dinh ke v (chua duoc duyet) cua u
            //v la neigbor cua u
            for(int v = 0 ; v < graph.length ; v++){
                if(graph[u][v] == 1 && traversedNodes.contains(v) == false){
                    stack.add(v);
                    traversedNodes.add(v);
                }
            }
        }
    }
}