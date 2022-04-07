class TreeNode{
    Integer key;
    TreeNode left, right;
    int height;

    public TreeNode(Integer key) {
        this.height = 0;
        this.key = key;
        this.left = this.right = null; 
    }
}