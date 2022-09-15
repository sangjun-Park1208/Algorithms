class Solution {
    public int solution(String str1, String str2) {  
        String[] s1 = new String[str1.length()-1];
        String[] s2 = new String[str2.length()-1];
        char ci, cip;
        
        int s1_len=0;
        for(int i=0; i<s1.length; i++){
            ci = str1.charAt(i); cip = str1.charAt(i+1);
            if((65 <= ci && ci <= 90) || (97<=ci && ci<=122) )
                if((65 <= cip && cip <= 90) || (97<=cip && cip<=122))
                    s1[s1_len++] = str1.substring(i, i+2);
                
        }
        
        int s2_len=0;
        for(int i=0; i<s2.length; i++){
            ci = str2.charAt(i); cip = str2.charAt(i+1);
            if((65<=ci && ci<=90) || (97<=ci && ci<=122) )
                if((65<=cip && cip<=90) || (97<=cip && cip<=122))
                    s2[s2_len++] = str2.substring(i, i+2);    
            
        }
        int inter = intersection(s1, s2, s1_len, s2_len);
        int uni = s1_len + s2_len - inter;
        if(uni == 0) return 65536;
        int answer = (int)(((double)inter / uni)*65536);
        
        return answer;
    }
    
    public int intersection(String[] s1, String[] s2, int s1_len, int s2_len){
        int ret=0;
        boolean[] b = new boolean[s2_len];
        for(int i=0; i<s1_len; i++){
            for(int j=0; j<s2_len; j++){
                if(!b[j] && (s1[i].equalsIgnoreCase(s2[j]))){ 
                    ret++;
                    b[j] = true;
                    break;
                }
            }
        }
        return ret;
    }
}