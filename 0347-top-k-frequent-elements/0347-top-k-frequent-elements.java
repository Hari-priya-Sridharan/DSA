class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minHeap.offer(new int[]{entry.getValue(),entry.getKey()});
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = minHeap.poll()[1];
        }
        return res;
    }
}