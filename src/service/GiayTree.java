package service;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import DAO.GiayDAO;
import model.Giay;

public class GiayTree {

	private NodeGiay listGiay;
    
	private GiayDAO giayDao;

	public GiayTree(){
		giayDao = new GiayDAO();
		setListGiay(giayDao.DocFileTree());
	}

	public NodeGiay getListGiay() {
		return listGiay;
	}

	public void setListGiay(NodeGiay listGiay) {
		this.listGiay = listGiay;
	}
	
	public void Input(int n)
    {
        for(int i=0; i<n; i++) {
            System.out.println("-----Nhap thong tin giay thu "+(i+1)+"-----");
            Giay G = new Giay();
            int id = getMaxElement(listGiay)+1;
            G.Nhap(id);
            if(listGiay==null) {
            	 listGiay = new NodeGiay(G);
            }
            insert(listGiay, G);
        }	
        giayDao.NhapFile(listGiay);
    }
	
	public int getMaxElement(NodeGiay n) {
		int maxVal = Integer.MIN_VALUE;
		if (n == null) {
			return 0;
		}
		Queue<NodeGiay> q = new LinkedList<NodeGiay>();
		q.offer(n);
		while (!q.isEmpty()) {
			NodeGiay tmp = q.poll();
			if (tmp.getLeft() != null) {
				q.offer(tmp.getLeft());
			}
			if (tmp.getRight() != null) {
				q.offer(tmp.getRight());
			}
			if (maxVal < tmp.getGiay().getma_giay())
				maxVal = tmp.getGiay().getma_giay();
		}
		return maxVal;
	}
	
	public void preOrderROLR(NodeGiay n) {
		if(n!=null) {
			n.getGiay().Xuat();
			preOrderROLR(n.getLeft());
			preOrderROLR(n.getRight());
		}
	}
	
	public void inOrderLROR(NodeGiay n) {
		if (null != this) {
			if (null != n.getLeft())
				inOrderLROR(n.getLeft());
			n.getGiay().Xuat();
			if (null != n.getRight())
				inOrderLROR(n.getRight());
		}
	}

	public void postOrderLRRO(NodeGiay n) {
		if (null != n) {
			postOrderLRRO(n.getLeft());
			postOrderLRRO(n.getRight());
			n.getGiay().Xuat();
		}
	}
	public void levelOrder(NodeGiay n) {
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
		    node.setLeft(insert(node.getLeft(), value));
		  }
		  else if(value.getma_giay() > node.getGiay().getma_giay()){
		    node.setRight(insert(node.getRight(), value));
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