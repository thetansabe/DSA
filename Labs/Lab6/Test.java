class Test{
    public static void main(String[] args) {
        MyBST bst = new MyBST();

        bst.root = bst.insert(bst.root, 5);
        bst.root = bst.insert(bst.root, 1);
        bst.root = bst.insert(bst.root, 6);
        bst.root = bst.insert(bst.root, 2);
        
        bst.NLR(bst.root);
        System.out.println();
        bst.LNR(bst.root);
        System.out.println();
        bst.LRN(bst.root);
        System.out.println();

        System.out.println(bst.search(bst.root,6));
        System.out.println(bst.height());
        System.out.println(bst.sum());

        bst.delete(bst.root, 6);
        bst.delete_pre(1);
        bst.LNR(bst.root);
    }
}