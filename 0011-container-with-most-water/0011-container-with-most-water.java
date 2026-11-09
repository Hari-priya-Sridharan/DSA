class Solution {
    public int maxArea(int[] height) {
        int l=0, r= height.length-1;
        int maxArea=Integer.MIN_VALUE;
        while(l<r){
            int area = Math.min(height[l],height[r]) * (r-l);
            maxArea = Math.max(maxArea, area);
            if(height[r]<height[l]){
                r--;
            }else{
                l++;
            }
        }
        return maxArea;
    }
}