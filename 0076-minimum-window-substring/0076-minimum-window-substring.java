class Solution {
    public String minWindow(String s, String t) {
        int[] need  = new int[128];
        for(char c: t.toCharArray()) need[c]++;

        int l=0, minLen=Integer.MAX_VALUE, start=0;
        int missing = t.length();
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            if(need[c]>0) missing--;
            need[c]--;
            while(missing==0){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    start = l;
                }
                char d = s.charAt(l);
                l++;
                if(need[d]>-1) missing++;
                need[d]++;
            }
        }
        return start+minLen<=s.length()? s.substring(start, start + minLen) : "";
    }
}