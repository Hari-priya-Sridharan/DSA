class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0)break;
            if(i>0 && nums[i]==nums[i-1]) continue;

            int l=i+1, r= nums.length-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if(sum==0){
                   list.add(Arrays.asList(nums[i],nums[l],nums[r]));
                   r--;
                   l++;
                    while(l<r && nums[l]==nums[l-1]){
                            l++;
                    } 
                }else if(sum>0){
                    r--;
                }else{
                    l++;
                }
            }

        }
        return list;
    }
}