class Solution {
    public String solution(int n, int t, int m, int p) { // n진법, t개 숫자, m명 참가, (p배수)번째 수
        String answer = "";        
        StringBuilder tmp = new StringBuilder("");
        String cur;
        int i, k, cnt;
        i=k=cnt=0;
        for(int j=0; j<t*m; j++){
            if(k>=t*m) break;
            cur = Integer.toString(i,n).toUpperCase();
            while(cur.length() > 0){
                if(cur.length() == 1){
                    for(int l=0; l<cur.length(); l++){
                        tmp.append(cur.charAt(l));
                    }
                    k++;
                    break;
                }
                tmp.append(cur.charAt(0));
                cur = cur.substring(1, cur.length());
            }
            i++;
        }

        for(int s=0; s<tmp.length(); s++)
            if(s%m == p-1 && cnt<t) {answer += String.valueOf(tmp.charAt(s)); cnt++;}
        return answer;
    }
}