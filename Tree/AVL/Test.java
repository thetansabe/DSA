class Test {
    public static void main(String[] args) {
        MyAVL avl = new MyAVL();

        avl.root = avl.insert(avl.root, 10);
        avl.root = avl.insert(avl.root, 20);
        avl.root = avl.insert(avl.root, 30);
        avl.root = avl.insert(avl.root, 40);
        avl.root = avl.insert(avl.root, 50);
        avl.root = avl.insert(avl.root, 25);

        // avl.LNR(avl.root);
        /*
         * The constructed AVL Tree would be
         * 30
         * / \
         * 20 40
         * / \ \
         * 10 25 50
         */

        avl.root = avl.delete(avl.root, 30);
        avl.LNR(avl.root);
    }
}