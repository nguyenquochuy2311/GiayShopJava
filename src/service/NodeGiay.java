package service;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import model.Giay;

public class NodeGiay {
	private NodeGiay left, right;
	private Giay giay;
	
	public NodeGiay(Giay g) {
		setGiay(g);
	}

	public void setNodeGiay(NodeGiay g) {
		setLeft(g.getLeft());
		setRight(g.getRight());
		setGiay(g.getGiay());
	}
	
	public NodeGiay getLeft() {
		return left;
	}

	public void setLeft(NodeGiay left) {
		this.left = left;
	}

	public NodeGiay getRight() {
		return right;
	}

	public void setRight(NodeGiay right) {
		this.right = right;
	}

	public Giay getGiay() {
		return giay;
	}

	public void setGiay(Giay giay) {
		this.giay = giay;
	}
	
	public NodeGiay insert(NodeGiay node, Giay value){
		  if(node == null){
		    return new NodeGiay(value);
		  }
		  if(value.getma_giay() < node.getGiay().getma_giay()){
		    node.setLeft(insert(node.left, value));;
		  }
		  else if(value.getma_giay() > node.getGiay().getma_giay()){
		    node.setRight(insert(node.right, value));
		  }
		  return node;
	}
   
    public NodeGiay search_ID(NodeGiay root, int key)  { 
        // Base Cases: root is null or key is present at root 
        if (root==null || root.getGiay().getma_giay()==key) 
            return root; 
        // val is greater than root's key 
        if (root.getGiay().getma_giay() > key) 
            return search_ID(root.getLeft(), key); 
        // val is less than root's key 
        return search_ID(root.getRight(), key); 
    } 
    
    public NodeGiay search_Ten(NodeGiay root, String key)  { 
    	if(root==null)
    		return root;
    	if (root.getGiay().getten_giay().contains(key))
            root.getGiay().Xuat();  
        if (root.getLeft()!=null) 
            return search_Ten(root.getLeft(), key);  
        return search_Ten(root.getRight(), key); 
    } 
    
    public NodeGiay deleteNode(NodeGiay root, int value) {
        if (root == null)
            return null;
        if (root.getGiay().getma_giay() > value) {
            root.setLeft(deleteNode(root.getLeft(), value));
        } else if (root.getGiay().getma_giay() < value) {
            root.setRight(deleteNode(root.getRight(), value));;
 
        } else {
            // if nodeToBeDeleted have both children
            if (root.getLeft() != null && root.getRight() != null) {
            	NodeGiay temp = root;
                // Finding minimum element from right
            	NodeGiay minNodeForRight = minimumElement(temp.getRight());
                // Replacing current node with minimum node from right subtree
                root.getGiay().setma_giay(minNodeForRight.getGiay().getma_giay());
                // Deleting minimum node from right now
                root.setLeft(deleteNode(root.getRight(), minNodeForRight.getGiay().getma_giay()));
 
            }
            // if nodeToBeDeleted has only left child
            else if (root.getLeft() != null) {
                root.setNodeGiay(root.getLeft());
            }
            // if nodeToBeDeleted has only right child
            else if (root.getRight() != null) {
                root.setNodeGiay(root.getRight());
            }
            // if nodeToBeDeleted do not have child (Leaf node)
            else
                root.setNodeGiay(null);;
        }
        return root;
    }
    
    public static NodeGiay minimumElement(NodeGiay root) {
        if (root.getLeft() == null)
            return root;
        else {
            return minimumElement(root.getLeft());
        }
    }
}
