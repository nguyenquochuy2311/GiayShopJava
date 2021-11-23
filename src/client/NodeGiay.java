package client;

import model.Giay;

public class NodeGiay {
	private NodeGiay left, right;
	private Giay giay;
	
	public NodeGiay(Giay g) {
		giay.setma_giay(g.getma_giay());
		giay.setten_giay(g.getten_giay());
		giay.setdon_gia(g.getdon_gia());
		giay.setthuong_hieu(g.getthuong_hieu());
		giay.setngay_sx(g.getngay_sx());
		left = right = null;
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
	
	public static <Giay> void preOrderTraverse() {

        System.out.print(listGiay. + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
        return null;
    }
}
