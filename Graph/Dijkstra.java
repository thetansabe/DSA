//find shortest path
import java.util.Arrays;
public class Dijkstra {

    public static boolean isAllVisted(boolean[] arr, int n){
        int count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == true) count++;
        }

        return count == n;
    }
    public static void main(String[] args) {
        //khai bao cac bien
        int N = 5; //number of vertices

        int graph[][] = {   {0,6,0,1,0},
                            {6,0,5,2,2},
                            {0,5,0,0,5},
                            {1,2,0,0,1},
                            {0,2,5,1,0}};

        int[] distance = new int[N];

        boolean[] visited = new boolean[N];

        int[] previous = new int[N];

        //B1: Khoi tao cac gia tri ban dau
        for(int i = 0 ; i < N ; i++){
            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[0] = 0;
        
        

        ////XU LI CHINH
        while(!isAllVisted(visited,N)){
            //CHU Y: can khoi tao 2 bien sau ben trong ham while
            int target = 0; //khong nhat thiet phai trong ham while
            int minDist = Integer.MAX_VALUE; //CHU Y: max value + buoc phai o trong vong while de khi tim min ko bo qua oo

            //B2: Tim dinh can xet
            //-> dinh do' phai: chua duoc duyet + distance[i] < minDist
            for(int i = 0 ; i < N ; i ++ ){
                if(visited[i] == false && distance[i] < minDist){
                    target = i;
                    minDist = distance[i];
                }
            }

            //B3: Tim dinh ke dinh target + chua duoc duyet
            //=> update distance roi update previous
            for(int i = 0 ; i < N ; i++){
                if(visited[i] == false && graph[target][i] != 0){
                    //new distance = kc tu dinh 0 -> dinh dang xet (target) + kc dinh target -> dinh ke
                    int newDist = distance[target] + graph[target][i]; //CHU Y
                    if(newDist < distance[i]){
                        distance[i] = newDist;
                        previous[i] = target;
                    }
                }
            }

            //B4: update da duyet
            visited[target] = true;
        }
        System.out.println(Arrays.toString(visited));
        System.out.println(Arrays.toString(previous));
        //Truy vet duong tu` 0 -> 2
        // int i = 2; //destination
        // while(i != 0){//!= start
        //     System.out.print(i + "<-");
        //     i = previous[i];
        // }
        // System.out.print(0);
    }

}
