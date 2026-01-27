class Tree {
    public int x;
    public Tree l;
    public Tree r;

    public Tree(int x) {
        this.x = x;
        this.l = null;
        this.r = null;
    }
}

class Solution_ZigZag {
    private int maxZigZag = 0;

    public int solution(Tree T) {

        if (T.l != null) 
          dfs(T.l, true, 0);

        if (T.r != null) 
          dfs(T.r, false, 0);

        return maxZigZag;
    }

    private void dfs(Tree node, boolean isLeft, int currentZigZag) {
        if (node == null) 
          return;

        this.maxZigZag = Math.max(maxZigZag, currentZigZag);

        if (isLeft) {
            dfs(node.l, true, currentZigZag);

            dfs(node.r, false, currentZigZag + 1);
        } else {
            dfs(node.l, true, currentZigZag + 1);

            dfs(node.r, false, currentZigZag);
        }
    }
}