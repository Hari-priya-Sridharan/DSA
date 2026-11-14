class Solution {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        for(char c: t.toCharArray()) need[c]++;
        
        int l=0,start=0,minLen=Integer.MAX_VALUE;
        int missing = t.length();
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            if(need[c]>0) missing--;
            need[c]--;

            while(missing==0){
                if(r-l+1 <minLen){
                    minLen = r-l+1;
                    start=l;
                }
                char d= s.charAt(l);
                if(need[d]>=0) missing++;
                need[d]++;
                l++;
            }
        }
        return minLen==Integer.MAX_VALUE? "" : s.substring(start, start+minLen);
    }
}