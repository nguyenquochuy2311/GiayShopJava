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
	
	public void preOrderROLR(NodeGiay n) {
		if(n!=null) {
			n.getGiay().Xuat();
			preOrderROLR(n.getLeft());
			preOrderROLR(n.getRight());
		}
	}
	
	public void inOrderLROR() {
		if (null != this) {
			if (null != this.getLeft())
				this.getLeft().inOrderLROR();
			this.getGiay().Xuat();
			if (null != this.getRight())
				this.getRight().inOrderLROR();
		}
	}

	public static void postOrderLRRO(NodeGiay n) {
		if (null != n) {
			postOrderLRRO(n.getLeft());
			postOrderLRRO(n.getRight());
			n.getGiay().Xuat();
		}
	}
	public static void levelOrder(NodeGiay n) {
		if(null==n) return;
		Queue<NodeGiay> q=new LinkedBlockingDeque<>();
		q.add(n);
		while(!q.isEmpty()){
			if(null!=q.peek().getLeft())
				q.add(q.peek().getLeft());
			if(null!=q.peek().getRight())
				q.add(q.peek().getRight());
			q.poll().getGiay().Xuat();
		}
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
}
