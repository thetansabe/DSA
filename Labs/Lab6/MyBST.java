class MyBST{
    public TreeNode root = null;
    
    public MyBST(){}

    public TreeNode insert(TreeNode x, Integer key){
        if(x == null)
            return new TreeNode(key);
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            x.left = insert(x.left,key);
        else if (cmp > 0)
            x.right = insert(x.right,key);
        else
            x.key = key;
        return x;
    }

    //print pre-order or node-left-right 
    //root -> left -> right
    public void NLR(TreeNode x){
        if(x != null){
            System.out.print(x.key + " ");
            NLR(x.left);
            NLR(x.right);
        }
    }

    //print in-order or left-node-right => ASCENDING ORDER
    //leaf left -> parent -> right -> grandpa -> repeat
    public void LNR(TreeNode x){
        if(x != null){
            NLR(x.left);
            System.out.print(x.key + " ");
            NLR(x.right);
        }
    }

    //print post order or left right node
    public void LRN(TreeNode x){
        if(x!=null){
            LRN(x.left);
            LRN(x.right);
            System.out.print(x.key + " ");
        }
    }

    //Search a TreeNode by its key
    public TreeNode search(TreeNode x, Integer key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            return search(x.left, key);
        else if(cmp > 0)
            return search(x.right, key);
        else
            return x;
    }

    //Find min/max TreeNode by its key
    public TreeNode min(TreeNode x){
        if(x.left == null)
            return x;
        return min(x.left);
    }

    public TreeNode max(TreeNode x){
        if(x.right == null)
            return x;
        return max(x.right);
    }

    //Delete TreeNode that contains key
    public TreeNode delete(TreeNode x, Integer key){
        if(x == null) return null;

        //B1: xac dinh node can xoa
        int cmp = key.compareTo(x.key);

        if(cmp < 0) //node can xoa < root -> di ben trai
            x.left = delete(x.left,key);
        else if(cmp > 0) //node can xoa > root -> di ben phai
            x.right = delete(x.right,key);

        //B2: xoa
        else{//found root can tim -> tien hanh xoa
            //TH 1 & 2: node ko co' con hoac co' 1 con
            if(x.right == null)
                return x.left;
            if(x.left == null)
                return x.right;
            //TH 3: node co' 2 con

                //tim trai' cung cay con ben phai
                //-> move gia tri len thang can xoa               
                TreeNode t = x;
                x = min(t.right); 
                //-> xoa trai' cung`
                x.right = deleteMin(t.right);
                //sau khi move -> mat' lien ket
                //phai relink
                x.left = t.left;
        } 
        return x; 
    }

    //xoa node co' key nho nhat'
    //**ap dung de xoa trai cung`
    public TreeNode deleteMin(TreeNode x){
        if(x.left == null){
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }

    ///////////////Ex5 to Ex10
    //ex5
    public boolean contains(Integer key){
        TreeNode tmp = root;
        TreeNode x = search(tmp,key);
        if(x != null) return true;
        return false;
    }

    //ex6
    public void deleteMax()
	{
		deleteMax(root);
	}
	
	private TreeNode deleteMax(TreeNode root) 
	{
		if (root.right == null)
			return root.left;
		root.right = deleteMax(root.right);
		return root;
	}

    //ex7
    public void delete_pre(Integer key){
        root = delete_pre(root, key);
    }

    private TreeNode delete_pre(TreeNode x, Integer key) 
	{
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = delete(x.left, key);
		else if (cmp > 0)
			x.right = delete(x.right, key);
		else 
		{
			TreeNode t = x;
			x = max(t.left);

			x.left = deleteMax(t.left);

			x.right = t.right;
		}
		return x;
	}

    //ex8
    public int height(){
        TreeNode tmp = root;
        int count_left = 0;

        while(tmp != null && tmp.left != null && tmp.right != null){
            count_left ++;
            tmp = tmp.left;
        }

        tmp = root;
        int count_right = 0;
        while(tmp != null && tmp.left != null && tmp.right != null){
            count_right ++;
            tmp = tmp.right;
        }

        return count_right < count_left ? count_left+1: count_right+1;
    }

    //ex9
    public Integer sum(TreeNode x){
        if(x == null) return 0;
        return x.key + sum(x.left) + sum(x.right);
    }

    //ex10
    public Integer sum(){
        return sum(root);
    }
}