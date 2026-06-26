class Trie {
    //Create a TrieNode
    //Insert :  for each letter in word, add the next letter to the childer HashMap. 
    //          increament the trie node from current node to children node
    //          at the end of the word, set the isWord boolean to true.
    //Search :  for each letter in the word, check if the map has children that matches the letter.
    //          retrun false if it doesnt match
    //          increament the trie node from current node to children node
    //          at the end return the value of isWord boolean, because matching alone will not indicate that the word is present
    //startsWith:   Same as search, but the isWord need not be true as we are only checking if its a word. we only need to know if its present.

    TrieNode root;
    class TrieNode{
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            curr.children.putIfAbsent(c,new TrieNode());
            curr=curr.children.get(c);
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char c :word.toCharArray()){
            if(!curr.children.containsKey(c)){
                return false;
            }
            curr=curr.children.get(c);
        }
        return curr.isWord;
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c: prefix.toCharArray()){
            if(!curr.children.containsKey(c)){
                return false;
            }
            curr= curr.children.get(c);
        }   
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */