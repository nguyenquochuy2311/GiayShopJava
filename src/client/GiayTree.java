package client;

import DAO.GiayDAO;

public class GiayTree {

	private NodeGiay listGiay;
    
	private GiayDAO giayDao;

	GiayTree(){
		giayDao = new GiayDAO();
		setListGiay(giayDao.DocFileTree());
	}
	
	public NodeGiay getListGiay() {
		return listGiay;
	}

	public void setListGiay(NodeGiay listGiay) {
		this.listGiay = listGiay;
	}
	
}