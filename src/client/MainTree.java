package client;

import java.util.Scanner;

import service.GiayTree;
import service.NodeGiay;

public class MainTree {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int choose;
		GiayTree giayTree = new GiayTree();
		
		do {
			System.out.println("==================== MENU CHUONG TRINH QUAN LY GIAY - TREE ====================");
			System.out.println("1. Nhap vao n giay");
			System.out.println("2. Hien thi thong tin theo chieu Root Left Right");	
			System.out.println("3. Hien thi thong tin theo chieu Left Root Right");	
			System.out.println("4. Hien thi thong tin theo chieu Left Right Root");	
			System.out.println("5. Hien thi thong tin theo theo cap do (duyet theo chieu rong)");	
			System.out.println("6. Tim kiem giay theo ma giay");
			System.out.println("7. Tim kiem giay theo ten giay");
			System.out.println("8. Cap nhat giay");
			System.out.println("9. Xoa giay theo ma giay");
			System.out.println("0. Thoat");
            System.out.println("==============================================================================");
            System.out.println("Moi ban nhap lua chon: ");
            choose = Integer.parseInt(sc.nextLine());
            switch(choose) {
	            case 0:
	            	System.out.println("Chuong trinh da ket thuc");
	            	return;
	            case 1: 
	            	System.out.println("1. Nhap vao n giay");
	                System.out.println("Moi ban nhap so giay can them: ");
	                int n = Integer.parseInt(sc.nextLine());
	                giayTree.Input(n);
	                break;
	            case 2:
	            	System.out.println("2. Hien thi thong tin theo chieu Root Left Right");
	            	if(giayTree.getListGiay()!=null) {
	            		System.out.printf("%-11s%-20s%-20s%-11s%s\n","Ma giay","Ten giay","Thuong hieu","Don gia","Ngay san xuat");
	        			giayTree.preOrderROLR(giayTree.getListGiay());
	        		}else {
	        			System.out.println("Danh sach rong");
	        		}
	            	break;
	            case 3:
	            	System.out.println("3. Hien thi thong tin theo chieu Left Root Right");
	            	if(giayTree.getListGiay()!=null) {
	            		System.out.printf("%-11s%-20s%-20s%-11s%s\n","Ma giay","Ten giay","Thuong hieu","Don gia","Ngay san xuat");
	            		giayTree.inOrderLROR(giayTree.getListGiay());
	        		}else {
	        			System.out.println("Danh sach rong");
	        		}
	            	break;
	            case 4:
	            	System.out.println("4. Hien thi thong tin theo chieu Left Right Root");
	            	if(giayTree.getListGiay()!=null) {
	            		System.out.printf("%-11s%-20s%-20s%-11s%s\n","Ma giay","Ten giay","Thuong hieu","Don gia","Ngay san xuat");
	        			giayTree.postOrderLRRO(giayTree.getListGiay());
	        		}else {
	        			System.out.println("Danh sach rong");
	        		}
	            	break;
	            case 5:
	            	System.out.println("5. Hien thi thong tin theo theo cap do (duyet theo chieu rong)");
	            	if(giayTree.getListGiay()!=null) {
	            		System.out.printf("%-11s%-20s%-20s%-11s%s\n","Ma giay","Ten giay","Thuong hieu","Don gia","Ngay san xuat");
	        			giayTree.levelOrder(giayTree.getListGiay());
	        		}else {
	        			System.out.println("Danh sach rong");
	        		}
	            	break;
	            case 6:
	            	System.out.println("6. Tim kiem giay theo ma giay");
	            	System.out.println("Moi ban nhap ma giay can tim: ");
                    int id = Integer.parseInt(sc.nextLine());
	            	if(giayTree.getListGiay().search_ID(giayTree.getListGiay(), id)!=null) {
	            		giayTree.setListGiay(giayTree.getListGiay().search_ID(giayTree.getListGiay(), id));
	            		System.out.printf("%-11s%-20s%-20s%-11s%s\n","Ma giay","Ten giay","Thuong hieu","Don gia","Ngay san xuat");
	            		giayTree.getListGiay().getGiay().Xuat();
	            	}else {
	            		System.out.println("Khong tim thay");
	            	}
	            	break;
	            case 7:
	            	System.out.println("7. Tim kiem giay theo ten giay");
	            	System.out.println("Moi ban nhap ten giay can tim: ");
                    String ten = sc.nextLine();
	            	System.out.printf("%-11s%-20s%-20s%-11s%s\n","Ma giay","Ten giay","Thuong hieu","Don gia","Ngay san xuat");
	            	giayTree.setListGiay(giayTree.getListGiay().search_Ten(giayTree.getListGiay(), ten));
	            	break;
	            case 8:
	            	System.out.println("8. Cap nhat giay");
	            	System.out.println("Moi ban nhap ma giay can xoa: ");
                    int id1 = Integer.parseInt(sc.nextLine());
	            	if(giayTree.getListGiay().search_ID(giayTree.getListGiay(), id1)==null) {
	            		System.out.println("Khong tim thay ma giay = "+ id1);
	            		break;
	            	}else {
	            		
	            	}
	            	break;
	            case 9:
	            	System.out.println("9. Xoa giay theo ma giay");
	            	System.out.println("Moi ban nhap ma giay can xoa: ");
                    int id2 = Integer.parseInt(sc.nextLine());
	            	if(giayTree.getListGiay().search_ID(giayTree.getListGiay(), id2)==null) {
	            		System.out.println("Khong tim thay ma giay = "+ id2);
	            		break;
	            	}else {
	            		giayTree.getListGiay().deleteNode(giayTree.getListGiay(), id2);
	            		System.out.println("Xoa thanh cong");
	            	}
	            	break;
	            default:
                	System.err.println("Nhap sai! Moi ban nhap lai lua chon");
                	break;
            }
		}while(choose!=0);

	}
}
