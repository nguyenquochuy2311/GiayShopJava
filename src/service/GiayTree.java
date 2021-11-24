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
            listGiay.insert(listGiay, G);
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
}