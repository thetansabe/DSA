
class MyBST{
    TreeNode root = null;
    MyBST(){}

    public TreeNode insert(TreeNode x, Integer key){
        if(x == null) 
            return new TreeNode(key);
        
        int cmp = key.compareTo(x.key);
        if(cmp < 0) //new node < parent -> left
            x.left = insert(x.left, key);
        else if (cmp > 0) //new node > parent -> right
            x.right = insert(x.right, key);
        
        return x;
    }

    public void LNR(TreeNode x){
        if(x != null){
            LNR(x.left);
            System.out.print(x.key + " ");
            LNR(x.right);
        }
    }

    public TreeNode search(TreeNode x, Integer key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) //key can tim < current -> di ve ben trai
            return search(x.left, key);
        else if(cmp > 0)
            return search(x.right, key);
        return x;
    }

    //min max
    public TreeNode min(TreeNode x){
        if(x.left == null) return x;
        return min(x.left);   
    }

    //height

    public int height(TreeNode x){
        if(x == null) return 0;

        int left_count = height(x.left);
        int right_count = height(x.right);

        return Math.max(left_count,right_count) + 1;
    }

    //sum
    public Integer sum(TreeNode x){
        if(x == null) return 0;
        return x.key + sum(x.left) + sum(x.right);
    }

    //deleting
    public TreeNode delete(TreeNode x, Integer key){
        if(x == null) return null;
        //B1: tim node can xoa
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            x.left = delete(x.left, key);
        else if(cmp > 0)
            x.right = delete(x.right, key);
        else{
            //B2: xoa
            // Th1 & 2:
            if(x.left == null) return x.right;
            if(x.right == null) return x.left;
            //TH3: xoa node co' 2 child
            //cach 1:
            TreeNode t = x;
            x = min(t.right);

            x.right = deleteMin(t.right);

            x.left = t.left;

            
            //cach 2
            // TreeNode leftMost = min(x.right);
            // x.key = leftMost.key;
            // x.right = delete(x.right, key);
        }
        return x;
    }

    public TreeNode deleteMin(TreeNode x){
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    ///init for debugging
    public TreeNode init(){
        TreeNode n0 = new TreeNode(30);
        TreeNode n1 = new TreeNode(20);
        TreeNode n2 = new TreeNode(40);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(25);
        TreeNode n5 = new TreeNode(50);
        TreeNode n6 = new TreeNode(60);
        TreeNode n7 = new TreeNode(70);

        n0.left = n1; n0.right = n2;
        n1.left = n3; n1.right = n4;
        n2.right = n5;
        n5.right = n6;
        n6.right = n7;
        return n0;
    }
}