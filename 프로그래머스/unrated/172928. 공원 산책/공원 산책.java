import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        String[] tmp;
        int[] move_i = {-1, 1, 0, 0};
        int[] move_j = {0, 0, -1, 1};
        int next_i, next_j;
        
        char[][] Map = new char[park.length][park[0].length()];
        int curI = 0;
        int curJ = 0;
        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[i].length(); j++) {
                Map[i][j] = park[i].charAt(j);
                if(Map[i][j] == 'S') {
                    curI = i;
                    curJ = j;
                }
            }
        }
        
        ArrayList<Operation> operations = new ArrayList<>();
        for(String route : routes) {
            tmp = route.split(" ");
            operations.add(new Operation(tmp[0].charAt(0), Integer.parseInt(tmp[1])));
        }
        
        // N: 0, S: 1, W: 2, E: 3
        int k = -1;
        for(Operation operation : operations) {
            if(operation.op == 'N') k = 0;
            else if(operation.op == 'S') k = 1;
            else if(operation.op == 'W') k = 2;
            else if(operation.op == 'E') k = 3;
            
            next_i = curI;
            next_j = curJ;
            
            boolean isBarrier = false;
            for(int i=0; i<operation.n; i++) {
                next_i += move_i[k];
                next_j += move_j[k];
                
                if(next_i < 0 || next_i >= park.length || next_j < 0 || next_j >= park[0].length()) {
                    isBarrier = true;
                    break;
                }
                if(Map[next_i][next_j] == 'X') {
                    isBarrier = true;
                    break;
                }
                
            }
            
            if(!isBarrier) {
                curI = next_i;
                curJ = next_j;
            }
            

        }
        
        answer[0] = curI;
        answer[1] = curJ;
        return answer;
    }
}

class Operation {
    Character op;
    Integer n;
    public Operation (Character op, Integer n) {
        this.op = op;
        this.n = n;
    }
}