class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s:strs){
            int[] count = new int[26];
            for(char c:s.toCharArray()){
                count[c-'a']++;
            }
            String key= Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            List<String> lis = map.get(key);
            lis.add(s);
            map.put(key, lis);
        }
        List<List<String>> res = new ArrayList<>();

        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}