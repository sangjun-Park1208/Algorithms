import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        int[] move_i = {-1, 1, 0, 0};
        int[] move_j = {0, 0, -1, 1};
        int next_i, next_j;
        
        ArrayDeque<Node> queue = new ArrayDeque<>();
        boolean[][] isVisit = new boolean[n][m];
        isVisit[0][0] = true; // 시작 지점 방문체크
        queue.add(new Node(0, 0, 1)); // 시작 지점
        
        Node cur;
        int moved;
        while(!queue.isEmpty()) {
            cur = queue.poll();
            moved = cur.moved;
            if(cur.i == n-1 && cur.j == m-1) {
                return cur.moved;
            }
            for(int k=0; k<4; k++) {
                next_i = cur.i + move_i[k];
                next_j = cur.j + move_j[k];
                
                if(next_i < 0 || next_j < 0 || next_i >= n || next_j >= m) { // maps의 가장자리
                    continue;
                }
                
                if(isVisit[next_i][next_j]) { // 방문했다면 패스
                    continue;
                }
                
                if(maps[next_i][next_j] == 0) { // 벽
                    continue;
                }
                
                queue.add(new Node(next_i, next_j, moved+1));
                isVisit[next_i][next_j] = true;
                
            }
        }
        
        return -1;
    }
    
    class Node {
        int i, j, moved;
        public Node(int i, int j, int moved) {
            this.i = i;
            this.j = j;
            this.moved = moved;
        }
    }
}