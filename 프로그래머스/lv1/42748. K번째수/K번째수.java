import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] tmp;
        int s, b, t, c;
        for(int i=0; i<commands.length; i++) {
            s = commands[i][0];
            b = commands[i][1];
            t = commands[i][2];
            tmp = new int[b - s + 1]; // 4칸
            c = 0;
            for(int j = s-1; j < b; j++, c++) { // j: 1,2,3,4
                tmp[c] = array[j];
            }
            Arrays.sort(tmp);
            answer[i] = tmp[t-1];
        }

        return answer;
    }
}