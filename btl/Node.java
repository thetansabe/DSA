public class Node {
    private Receipt receipt;
    private Node left, right;
    private int height;

    public Receipt getReceipt() {
        return this.receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Node getLeft()
    {
		return this.left;
	}

    public void setLeft(Node left)
    {
		this.left = left;
	}

    public Node getRight()
    {
        return this.right;
    }

    public void setRight(Node right)
    {
        this.right = right;
    }
    
    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node(Receipt receipt){
        this.height = 0;
        this.receipt = receipt;
        this.left = this.right = null;
    }
}
