import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        char[][] Map = new char[wallpaper.length][wallpaper[0].length()];
        int min_i, min_j, max_i, max_j;
        max_i = max_j = 0;
        min_i = wallpaper.length;
        min_j = wallpaper[0].length();
        
        for(int i=0; i<wallpaper.length; i++) {
            for(int j=0; j<wallpaper[i].length(); j++) {
                Map[i][j] = wallpaper[i].charAt(j);
                
                // 파일의 최대/최소 좌표 식별
                if(Map[i][j] == '#') {
                    if(i < min_i) min_i = i;
                    if(i > max_i) max_i = i;
                    if(j < min_j) min_j = j;
                    if(j > max_j) max_j = j;
                }
            }
        }
        
        // 최대좌표는 +1씩, 최소좌표는 그대로 적용
        answer[0] = min_i;
        answer[1] = min_j;
        answer[2] = max_i + 1;
        answer[3] = max_j + 1;
        
        return answer;
    }
}