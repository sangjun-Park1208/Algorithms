import java.util.*;

class Solution {
    static boolean[] isVisit;
    static ArrayList<String> allRoute;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        isVisit = new boolean[tickets.length];
        allRoute = new ArrayList<>();
        
        dfs("ICN", "ICN", 0, tickets);
        
        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");
        
        return answer;
    }
    
    static void dfs(String start, String route, int depth, String[][] tickets) {
        if(depth == tickets.length) { // 종료 조건
            allRoute.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(!isVisit[i] && start.equals(tickets[i][0])) {
                isVisit[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], depth+1, tickets);
                isVisit[i] = false;
            }
        }
    }
}