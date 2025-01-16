// Time Complexity :O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public void gameOfLife(int[][] board) {

        if(board == null || board.length == 0) return ;

        int m = board.length;
        int n = board[0].length;
        //1 -> 0 == 2
        //0 -> 1 == 3

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int live = countLive(board,i, j, m, n);
                if(board[i][j] == 1 && (live > 3 || live < 2)){
                    board[i][j] = 2; // live -> dead
                }else if(board[i][j] == 0 && live == 3 ){
                     board[i][j] = 3;
                }

            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
                
                
            
            }
        }
        
    }

    private int countLive(int[][] board, int row, int col, int m, int n){
        int[][] dirs = {{-1, 0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};

        int count = 0;
        for(int[] dir : dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];

            if(nr < m && nr >= 0 && nc >=0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2 )){
                count++;
            }
        }

        return count;
    }
}