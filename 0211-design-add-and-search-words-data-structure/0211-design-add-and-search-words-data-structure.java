class WordDictionary {
    /*
    1.  Create a TrieNode with children and isWord flag
    2.  Add word  : is similar to insert
                    for each char in the word, if the char[] is null, then add the char to the children array
                    increament the curr node to children
                    mark the isWord true
    3. search : there is a small tweak as the . can represent any char. DFS can be used to search
                this will call the dfs method with all req parameters
    4. DFS :    for each char in word, check if the char[] is null, if its null, return false
                when the char is '.', iterate through each children, compare if its null, if yes return false
                increament the curr node to children node
                return the value of isWord
    */
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            int idx = c-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode node){
        TrieNode curr = node;
        for(int i=j;i<word.length();i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(TrieNode child:curr.children){
                    if(child!=null && dfs(word, i+1, child)){
                        return true;
                    }
                }
                return false;
            }else{
                if(curr.children[c-'a']==null){
                    return false;
                }
                curr = curr.children[c-'a'];
            }
        }
        return curr.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */