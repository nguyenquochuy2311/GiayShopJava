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
}
