import java.util.ArrayList;

public class AVL {
    private Node root;

    public AVL(){
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int height(Node node){		
		if (node == null) 
            return -1;   
        return node.getHeight();
	}

    private int checkBalance(Node x){  
		return height(x.getLeft()) - height(x.getRight());
	}

    private Node balance(Node x) {
        //bo sung code
        if(checkBalance(x) <- 1){ //mat can bang phai
            //check co mat can bang trai trc ko
            if(checkBalance(x.getRight()) > 0){
                x.setRight(rotateRight(x.getRight()));
            }
            x = rotateLeft(x);
        }
        else if(checkBalance(x) > 1){//mat can bang trai
            //check mat can phai trc
            if(checkBalance(x.getLeft()) < 0){
                x.setLeft(rotateLeft(x.getLeft()));
            }
            x = rotateRight(x);
        }
		return x;
	}

    //rotate methods => code bo sung
    private Node rotateLeft(Node x){
        Node y = x.getRight();
        x.setRight(y.getLeft());
        y.setLeft(x);

        x.setHeight(1+Math.max(height(x.getLeft()),height(x.getRight())));
        y.setHeight(1+Math.max(height(y.getLeft()),height(y.getRight())));
        
        return y;
    }

    private Node rotateRight(Node x){
        Node y = x.getLeft();
        x.setLeft(y.getRight());
        y.setRight(x);

        x.setHeight(1+Math.max(height(x.getLeft()),height(x.getRight())));
        y.setHeight(1+Math.max(height(y.getLeft()),height(y.getRight())));

        return y;
    }

    private Node insert(Node node, Receipt receipt){
		//code here and change the return value
        if(node == null)
            return new Node(receipt);
        
        //so sanh dua tren id
        Receipt nodeReceipt = node.getReceipt();
        if(receipt.getReceiptId() < nodeReceipt.getReceiptId()){
            //new node < parent -> add left
            node.setLeft(insert(node.getLeft(),receipt));
        }
        else if(receipt.getReceiptId() > nodeReceipt.getReceiptId()){
            //new node > parent -> add right
            node.setRight(insert(node.getRight(),receipt));
        }
        else
            return node;

        //balancing
        node.setHeight(1 + Math.max(height(node.getLeft()),height(node.getRight())));
        node = balance(node);

		return node;
	}

    public void insertReceipt(Receipt receipt){
		this.root = insert(this.root, receipt);
	}

    private void NLR(Node node, ArrayList<String> result){
		if (node != null) 
        { 
			result.add(node.getReceipt().toString()) ; 
            NLR(node.getLeft(), result);             
            NLR(node.getRight(), result); 
        } 
	}
	
	public void NLR(ArrayList<String> result){
		NLR(this.root, result);
	}

    private Node search(Node x, int receiptId) {
		//code here and change the return value
        if(x == null) return null;

        Receipt nodeReceipt = x.getReceipt();
        if(receiptId < nodeReceipt.getReceiptId()) //tim receipt id be hon root
            return search(x.getLeft(),receiptId);
        else if (receiptId > nodeReceipt.getReceiptId()) //tim receipt id lon hon root
            return search(x.getRight(), receiptId);

		return x;
	}
	
	public String search(int receiptId){
        return search(root, receiptId).getReceipt().toString();
	}
}
