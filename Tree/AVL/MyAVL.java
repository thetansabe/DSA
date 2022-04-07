public class MyAVL {
    TreeNode root = null;
    MyAVL(){}

    public int height(TreeNode node){
        if(node == null) return -1;
        return node.height;
    }

    public int checkBalance(TreeNode x){
        return height(x.left) - height(x.right);
    }


    public void LNR(TreeNode x){
        if(x != null){
            LNR(x.left);
            System.out.print(x.key + " ");
            LNR(x.right);
        }
    }

    public TreeNode balance(TreeNode x){
        
        if(checkBalance(x) < -1){//mat can bang phai
            //TH mat can bang phai -> trai
            //right rotate -> left rotate
            if(checkBalance(x.right) > 0){
                x.right = rotateRight(x.right);
            }
            x = rotateLeft(x);
        }else if(checkBalance(x) > 1){//TH mat can bang trai
            //mat can bang trai -> phai
            //left rotate -> right rotate
            if(checkBalance(x.left) < 0){
                x.left = rotateLeft(x.left);
            }
            x = rotateRight(x);
        }
        return x;
    }

    public TreeNode rotateLeft(TreeNode x){
        TreeNode y = x.right;
        x.right = y.left;
        y.left = x;
        x.height = 1+Math.max(height(x.left),height(x.right));
        y.height = 1+Math.max(height(y.left),height(y.right));
        return y;
    }

    public TreeNode rotateRight(TreeNode x){
        TreeNode y = x.left;
        x.left = y.right;
        y.right = x;
        x.height = 1+Math.max(height(x.left),height(x.right));
        y.height = 1+Math.max(height(y.left),height(y.right));
        return y;
    }

    public TreeNode insert(TreeNode x, Integer key){
        ////////////////////B1: insert nhu BST
        if(x == null) 
            return new TreeNode(key);
        
        int cmp = key.compareTo(x.key);
        if(cmp < 0) //new node < parent -> left
            x.left = insert(x.left, key);
        else if (cmp > 0) //new node > parent -> right
            x.right = insert(x.right, key);
        //not allow duplicate node to insert
        else
            return x;

        //////////////////B2: xu li balancing
        //update height
        x.height = 1 + Math.max(height(x.left),height(x.right));
        //balancing
        x = balance(x);
        return x;
    }

    //deleting
    public TreeNode delete(TreeNode x, Integer key){
        ///////////B1: delete nhu binh thuong
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

            TreeNode t = x;
            x = min(t.right);

            x.right = deleteMin(t.right);

            x.left = t.left;
        }
        
        ////////B2: balance tree
        //update height
        x.height = 1 + Math.max(height(x.left),height(x.right));
        //balancing
        x = balance(x);
        return x;
    }

    public TreeNode min(TreeNode x){
        if(x.left == null) return x;
        return min(x.left);   
    }

    public TreeNode deleteMin(TreeNode x){
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }
}
