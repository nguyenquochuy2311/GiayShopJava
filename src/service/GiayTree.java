package service;

import java.util.LinkedList;
import java.util.Queue;

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
        listGiay.preOrderROLR(listGiay);
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
}