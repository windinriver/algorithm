package leetcode.backtracking;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//这题变的特殊了一点
public class Exist79 {



//    偏移量数组在二维平面内是经常使用的，可以把它的设置当做一个技巧
    private int[][] directions= {{-1,0},{0,-1},{0,1},{1,0}};
    private boolean[][]visited;
    private int row;
    private int cols;


    public boolean exist(char[][] board, String word) {
        row = board.length;
        if (row == 0){
            return false;
        }
        cols = board[0].length;
        visited = new boolean[row][cols];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board,word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    //02 递归
    private boolean dfs(char[][] board, String word, int x, int y, int begin) {
        //03 递归结束条件
        if (begin == word.length()-1) {
            return board[x][y] == word.charAt(begin);
        }

        if (board[x][y] == word.charAt(begin)) {
            visited[x][y] = true;
            //04 选择
            for (int[] direction: directions
                 ) {
                int newX = x +direction[0];
                int newY = y + direction[1];
                if(inArea(newX, newY) && !visited[newX][newY]) {
                    //05 递归
                    if (dfs(board,word, newX, newY, begin+1)) {
                        return true;
                    }
                }
            }
            //06回溯
            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >=0 && x < row && y >=0 && y < cols;
    }
}
