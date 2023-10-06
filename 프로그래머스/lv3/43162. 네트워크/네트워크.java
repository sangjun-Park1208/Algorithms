import java.util.*;

class Solution {
    static int[] network, copyNetwork;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        network = new int[n];
        for(int i=0; i<n; i++) {
            network[i] = i;
        }
        
        for(int i=0; i<computers.length; i++) {
            for(int j=i; j<computers[i].length; j++) {
                if(computers[i][j] == 1) {
                    Union(i, j);
                }
            }
        }
        
        for(int i=0; i<network.length; i++) {
            if(network[i] == i) answer++;
        }
        
        return answer;
    }
    
    int Find(int x) { // 루트 노드 찾기
        if(network[x] == x) {
            return x;
        }
        return Find(network[x]);
    }
    
    void Union(int x, int y) { 
        int xRoot = Find(x);
        int yRoot = Find(y);
        if(xRoot == yRoot) return;
        if(xRoot < yRoot) network[yRoot] = xRoot;
        else network[xRoot] = yRoot;
        
        return;
    }
    
    boolean isUnion(int x, int y) {
        if(Find(x) == Find(y)) return true;
        return false;
    }
    
}