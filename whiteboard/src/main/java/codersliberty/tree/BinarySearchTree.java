package codersliberty.tree;

public class BinarySearchTree<T extends Comparable> {
	protected Node<T> root;

	public void insert(T data) {
		Node temp = new Node<T>(data);
		if (root == null) {
			root = temp;
			return;
		} else {
			Node current = root;
			while (true) {
				Node parent = current;
				if (data.compareTo(current.getData()) < 0) {
					current = current.getLeft();
					if (current == null) {
						temp.setHeight(parent.getHeight()+1);
						parent.setLeft(temp);
						return;
					}
				} else {
					current = current.getRight();
					if (current == null) {
						temp.setHeight(parent.getHeight()+1);
						parent.setRight(temp);
						return;
					}
				}
			}
		}
	}

	public void insertRecord(T data) {
		Node<Integer> temp = new Node(data);
		this.root = insertRecursive(root, data);
	}

	public Node insertRecursive(Node node, T key) {
		if(this.root == null) {
			node = new Node(key);
		}
		if (key.compareTo(node.getData()) > 0) {
			node.setRight(insertRecursive(node.getRight(), key)); 
		} else if (key.compareTo(node.getData()) < 0) {
			node.setLeft(insertRecursive(node.getLeft(), key));
		}
		return node;
	}
	public boolean search(T data) {
		return search(root, data);
	}

	public boolean search(Node root, T data) {
		if (root == null) {
			return false;
		}
		if (data.compareTo(root.getData()) == 0) {
			return true;
		} else {
			if (data.compareTo(root.getData()) < 0) {
				return search(root.getLeft(), data);
			} else {
				return search(root.getRight(), data);
			}
		}
	}

	public void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.getData() + " ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	public void inOrder(Node root) {
		if (root != null) {
			inOrder(root.getLeft());
			System.out.print(root.getData() + " ");
			inOrder(root.getRight());
		}
	}

	public void postOrder(Node node) {
		if (node != null) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.print(node.getData() + " ");
		}
	}

	public Node<T> getRoot() {
		return root;
	}
	
	public int height() {
		return heightRecusive(root);
	}
	
	public int heightRecusive(Node node) {
		if(node == null) {
			return 0;
		}
		int lHeight = heightRecusive(node.getLeft());
		int rHeight = heightRecusive(node.getRight());
		if(lHeight > rHeight) {
			return ++lHeight;
		} else {
			return ++rHeight;
		}
	}
	
	int maxDepth(Node node)  
    { 
        if (node == null) 
            return 0; 
        else 
        { 
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.getLeft()); 
            int rDepth = maxDepth(node.getRight()); 
   
            /* use the larger one */
            if (lDepth > rDepth) 
                return (lDepth + 1); 
             else 
                return (rDepth + 1); 
        } 
    }

	/* Functions to delete data */
    public void delete(int k)
	{
		if (root == null)
			System.out.println("Tree Empty");
		else {
			root = delete(root, k);
			System.out.println(k + " deleted from the tree");
		}
	}
    private Node delete(Node root, int k)
	{
		Node p, p2, n;
		if ((int) root.getData() == k) {
			Node lt, rt;
			lt = root.getLeft();
			rt = root.getRight();
			if (lt == null && rt == null)
				return null;
			else if (lt == null) {
				p = rt;
				return p;
			} else if (rt == null) {
				p = lt;
				return p;
			} else {
				p2 = rt;
				p = rt;
				while (p.getLeft() != null)
					p = p.getLeft();
				p.setLeft(lt);
				return p2;
			}
		}
		if (k < (int) root.getData()) {
			n = delete(root.getLeft(), k);
			root.setLeft(n);
		} else {
			n = delete(root.getRight(), k);
			root.setRight(n);
		}
		return root;
	}
    
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(20);
		bst.insert(5);
		bst.insert(25);
		bst.insert(3);
		bst.insert(7);
		bst.insert(27);
		bst.insert(24);
		System.out.println("\nIn Order ");
		bst.inOrder(bst.getRoot());
		System.out.println("\nPre Order ");
		bst.preOrder(bst.getRoot());
		System.out.println("\nPost order ");
		bst.postOrder(bst.getRoot());
		System.out.println(bst.search(3));
		System.out.println(bst.getRoot());
		bst.insertRecord(20);
		bst.insertRecord(5);
		bst.insertRecord(25);
		bst.insertRecord(3);
		bst.insertRecord(7);
		bst.insertRecord(27);
		bst.insertRecord(24);
		System.out.println();
		System.out.println("\nIn Order ");
		bst.inOrder(bst.getRoot());
		System.out.println("\nPre Order ");
		bst.preOrder(bst.getRoot());
		System.out.println("\nPost order ");
		bst.postOrder(bst.getRoot());
		System.out.println(bst.search(3));
		System.out.println(bst.getRoot());
		System.out.println("Height: "+bst.height());
		System.out.println("Height: "+bst.maxDepth(bst.root));
		
	}
			
/*	 20
   5    25
  3 7 24  27
  		*/ 
}
