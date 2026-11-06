class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer>[] list = new List[nums.length + 1];// doubt on the initialisation
        for(int i=0;i<nums.length+1;i++){
            list[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            list[entry.getValue()].add(entry.getKey());
        }

        int[] res= new int[k];
        int index=0;
        for(int i= list.length-1;i>0 && index<k;i--){
            for(int n: list[i]){
                res[index++] = n;
                if(index==k){
                    return res;
                }
            } 
        }
        return res;
    }
}