class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxLen=0;
        int l=0, maxFreq=0;
        for(int r=0;r<s.length();r++){
            maxFreq = Math.max(maxFreq,++count[s.charAt(r)-'A']);
            while(l<r && (r-l+1)-maxFreq >k){
                count[s.charAt(l)-'A']--;
                l++;
            }
            maxLen= Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}