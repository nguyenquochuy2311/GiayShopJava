package client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Giay;
import service.GiayMang;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int choose;
        GiayMang giayMn = new GiayMang();
//        GiayDanhSachLienKetDon giayMn = new GiayDanhSachLienKetDon();
        
        do{
                System.out.println("==================== MENU CHUONG TRINH QUAN LY GIAY====================");
				System.out.println("1. Nhap vao n giay");
				System.out.println("2. Hien thi thong tin tat ca giay ra man hinh");
				System.out.println("3. Hien thi tat ca thuong hieu giay");
				System.out.println("4. Hien thi giay co don gia cao nhat va thap nhat");
                System.out.println("5. Chen giay moi vao vi tri bat ky");
                System.out.println("6. Tim kiem giay theo ma giay");
                System.out.println("7. Tim kiem giay theo ten giay");
                System.out.println("8. Tim kiem giay theo thuong hieu giay");
                System.out.println("9. Tim kiem tat ca giay theo ngay san xuat");
                System.out.println("10. Cap nhat giay");
                System.out.println("11. Xoa giay theo ma giay");
                System.out.println("12. Sap xep giay theo thu tu don gia giam dan");
                System.out.println("13. Sap xep giay theo thu tu ten giay theo bang chu cai (tang dan)");
                System.out.println("0. Thoat");
                System.out.println("===================================================================");
                System.out.println("Moi ban nhap lua chon: ");
                choose = Integer.parseInt(sc.nextLine());
                switch(choose){
                	case 0:
	                	System.out.println("Chuong trinh da ket thuc");
	                	return;
                    case 1: 
                        System.out.println("1. Nhap vao n giay");
                        System.out.println("Moi ban nhap so giay can them: ");
                        int n = Integer.parseInt(sc.nextLine());
                        giayMn.Input(n);
                        break;
                    case 2:
                        System.out.println("2. Hien thi tat ca cac giay ra man hinh");
                        giayMn.Output();
                        break;
                    case 3:
                    	System.out.println("3. Hien thi tat ca thuong hieu giay");
                    	giayMn.XemThuongHieu();
                    	break;
                    case 4:
                        System.out.println("4. Hien thi giay co don gia cao nhat va thap nhat");
                        giayMn.DGia_Max_Min();
                        break;
                    case 5:
                        System.out.println("5. Chen giay moi vao vi tri bat ky");
                        giayMn.ChenGiay();
                        break;                              
                    case 6:
                        System.out.println("6. Tim kiem giay theo ma giay");	
                        System.out.println("Moi ban nhap ma giay can tim: ");
                        int id = Integer.parseInt(sc.nextLine());
                        giayMn.TimGiay_TheoID(id);
                        break;
                    case 7: 
                    	System.out.println("7. Tim kiem giay theo ten giay");
                    	System.out.println("Moi ban ten giay can tim: ");
                    	String tenGiay = sc.nextLine();
                    	System.out.println("Ket qua tim kiem:");
                    	giayMn.TimGiay_TheoTen(tenGiay);
                    	break;
                    case 8:
                        System.out.println("8. Tim kiem giay theo thuong hieu giay");
                        System.out.println("Moi ban nhap ten thuong hieu giay can tim: ");
                        String th = sc.nextLine();
                        giayMn.TimGiay_TheoThuongHieu(th);
                        break;      
                    case 9:
                        System.out.println("9. Tim kiem giay theo ngay san xuat");
                        System.out.println("Moi ban nhap ngay san xuat (dd/MM/yyyy) can tim: ");
                        Date ngay = new Date();
                        try{
                            ngay = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
                        }catch(ParseException ex){
                            Logger.getLogger(Giay.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        giayMn.TimGiay_TheoNgaySanXuat(ngay);
                        break;
                    case 10:
                    	System.out.println("10. Cap nhat giay");
                    	System.out.println("Moi ban nhap ma giay cap nhat: ");
                    	int id1 = Integer.parseInt(sc.nextLine());
                    	if(giayMn.CapNhatGiay(id1)) {
                    		System.out.println("Cap nhat thanh cong");
                    	}else {
                    		System.out.println("**Khong ton tai giay co ma "+id1);
                    	}
                    	break;
                    case 11:
                        System.out.println("11. Xoa giay theo ma giay");
						System.out.println("Moi ban nhap ma giay xoa: ");
						int id_d = Integer.parseInt(sc.nextLine());
                        if(giayMn.XoaGiay(id_d)){
                            System.out.println("Xoa giay co ma "+id_d+" thanh cong");
                        }
                        else{
                            System.out.println("**Khong ton tai giay co ma "+id_d);
                        }
                        break;
                    case 12:
                        System.out.println("12. Sap xep giay theo thu tu don gia giam dan");
                        giayMn.Sapxep_DongiaGiam();
                        giayMn.Output();
                        break;
                    case 13:
                        System.out.println("13. Sap xep giay theo thu tu ten giay theo bang chu cai (tang dan)");
                        giayMn.Sapxep_TengiayTang();
                        giayMn.Output();
                        break;
                    default:
                    	System.err.println("Nhap sai! Moi ban nhap lai lua chon");
                    	break;
                }
        }while(choose!=0);
	}
}
