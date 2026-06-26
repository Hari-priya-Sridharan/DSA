/* 
1. Create a TrieNode with children and isWord flag 
2. Add word : Write an add word method to add all the words in the array to trie datastructure. This will improve the search optimization.
              Iterate through all letters of a word. Add in the children array.
3. The findwords method will use a DFS to seach the board adn verify if the char form a word that's in the trie.
4. DFS : used to search the words and add the word to result if its available.
            
*/
class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;

    public void addWord(String word){
        TrieNode curr = this;
        for(char c:word.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a']= new TrieNode();
            }
            curr =curr.children[c-'a'];
        }
        curr.isWord= true;
    }
}
class Solution {
    HashSet<String> result;
    boolean[][] visited;
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words){
            root.addWord(word);
        }
        int r= board.length;
        int c= board[0].length;
        result = new HashSet<>();
        visited = new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                dfs(board,i,j,"",root);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int r, int c, String word, TrieNode node){
        int rows = board.length;
        int cols = board[0].length;
        if(r<0 || c<0 ||r>=rows || c>=cols || node.children[board[r][c] -'a']==null || visited[r][c]){
            return ;
        }
        visited[r][c] = true;
        word+=board[r][c];
        node = node.children[board[r][c]-'a'];
        if(node.isWord){
            result.add(word);
        }
        dfs(board,r+1,c,word,node);
        dfs(board,r-1,c,word,node);
        dfs(board,r,c+1,word,node);
        dfs(board,r,c-1,word,node);

        visited[r][c]=false;
    }
}