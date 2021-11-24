package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.GiayDAO;
import model.Giay;

public class GiayMang {
	private List<Giay> listGiay;
    
	private GiayDAO giayDao;
	
	public GiayMang() {
		giayDao = new GiayDAO();
		setListGiay(giayDao.DocFile());
	}
	
    public List<Giay> getListGiay() {
		return listGiay;
	}

	public void setListGiay(List<Giay> listGiay) {
		this.listGiay = listGiay;
	}
	
	public void Input(int n)
    {
        for(int i = 0; i <n; i++) {
            System.out.println("-----Nhap thong tin giay thu "+(i+1)+"-----");
            Giay G = new Giay();
            int id = (listGiay.size()>0) ? (listGiay.get(listGiay.size()-1).getma_giay()+1) : 1;
            G.Nhap(id);
            listGiay.add(G);
        }	
        giayDao.NhapFile(getListGiay());
    }
	
    public void Output()
    {
		if(listGiay.size()==0) {
			System.out.println("Danh sach giay trong");
			return;
		}
    	for(int i = 0; i < listGiay.size(); i++) {
            if(i==0)
            {
                System.out.println("------------------------------");
                System.out.printf("%-7s%-11s%-20s%-20s%-11s%s\n","STT","Ma giay","Ten giay","Thuong hieu","Don gia","Ngay san xuat");
            }
            System.out.printf("%-7d",(i+1));
            listGiay.get(i).Xuat();
        }   
    }
    
    public void XemThuongHieu() {
    	for(int i=0; i<listGiay.size(); i++) {
    		if(i==0) {
    			System.out.printf("STT   ");
    			System.out.printf("Ten thuong hieu\n");
    			System.out.println((i+1) + ".    " + listGiay.get(i).getthuong_hieu());
    		}else {
    			int count = 0;
    			for(int j=i-1; j>=0; j--) {
        			if(listGiay.get(i).getthuong_hieu().compareTo(listGiay.get(j).getthuong_hieu())==0) {
        				count++;
        				break;
        			}
        		}
    			if(count==0) {
    				System.out.println(i + ".    " + listGiay.get(i).getthuong_hieu());
    			}
    		}
    	}
    }
    
    public void DGia_Max_Min()
    {
        int minIndex = 0, maxIndex = 0;
        float minGia, maxGia;

        minGia = listGiay.get(0).getdon_gia();
        maxGia = listGiay.get(0).getdon_gia();

        for(int i = 1; i < listGiay.size(); i++) {
                if(listGiay.get(i).getdon_gia() < minGia) {
                    minIndex = i;
                    minGia = listGiay.get(i).getdon_gia();
                }
                if(listGiay.get(i).getdon_gia() > maxGia) {
                    maxIndex = i;
                    maxGia = listGiay.get(i).getdon_gia();
                }
        }

        System.out.println("------------------------------");
        System.out.println("Giay co don gia cao nhat la: ");
        System.out.printf("%-11s%-20s%-20s%-11s%s\n","Ma giay","Ten giay","Thuong hieu","Don gia","Ngay san xuat");
        listGiay.get(maxIndex).Xuat();

        System.out.println("------------------------------");
        System.out.println("Giay co don gia thap nhat la: ");
        System.out.printf("%-11s%-20s%-20s%-11s%s\n","Ma giay","Ten giay","Thuong hieu","Don gia","Ngay san xuat");
        listGiay.get(minIndex).Xuat();
    }
        
    public void ChenGiay()
    {
        System.out.println("Moi ban nhap vi tri can chen (nho hon "+listGiay.size()+"): ");
        Scanner sc = new Scanner(System.in);
        int chiso = Integer.parseInt(sc.nextLine());
        do{
            if(chiso>listGiay.size()){
                System.out.println("!!! Vi tri can chen khong duoc lon hon vi tri cuoi cung cua mang, moi ban nhap lai vi tri: ");
                chiso = Integer.parseInt(sc.nextLine());
            }
            else{
                System.out.println("-----Nhap thong tin giay vi tri thu "+chiso+"-----");
                Giay G = new Giay();
                int id = (listGiay.size()>0) ? (listGiay.get(listGiay.size()-1).getma_giay()+1) : 1;
                G.Nhap(id);
                listGiay.add(chiso-1, G);
                giayDao.NhapFile(listGiay);
            }
        }while(chiso>listGiay.size());  
    }
    
    public void TimGiay_TheoID(int id)
    {
        int dem = 0;
				
        for(int i=0;i<listGiay.size();i++) {
            if(listGiay.get(i).getma_giay()==id)
            {
                if(dem==0)
                {
                    System.out.printf("%-11s%-20s%-20s%-11s%s\n","Ma giay","Ten giay","Thuong hieu","Don gia","Ngay san xuat");
                }
                listGiay.get(i).Xuat();
                dem++;
            }   
        }
        if(dem == 0) {
                System.out.println("**Khong tim thay giay nao co ma = "+id);
        }
    }
    
    public void TimGiay_TheoTen(String tenGiay)
    {
        int dem = 0;
				
        for(int i=0;i<listGiay.size();i++) {
            if(listGiay.get(i).getten_giay().contains(tenGiay))
            {
                if(dem==0)
                {
                    System.out.printf("%-11s%-20s%-20s%-11s%s\n","Ma giay","Ten giay","Thuong hieu","Don gia","Ngay san xuat");
                }
                listGiay.get(i).Xuat();
                dem++;
            }   
        }
        if(dem == 0) {
                System.out.println("**Khong tim thay giay nao co ten : "+tenGiay);
        }
    }
    
    public void TimGiay_TheoThuongHieu(String th)
    {
        int dem_th = 0;			
        for(int i=0;i<listGiay.size();i++) {
            if(th.compareTo(listGiay.get(i).getthuong_hieu())==0)
            {
                if(dem_th==0)
                {
                    System.out.println("------- Danh sach giay co thuong hieu "+th+" -------");
                    System.out.printf("%-11s%-20s%-20s%-11s%s\n","Ma giay","Ten giay","Thuong hieu","Don gia","Ngay san xuat");
                }
                listGiay.get(i).Xuat();
                dem_th++;
            }   
        }
        if(dem_th == 0) {
                System.out.println("**Khong tim thay giay nao co thuong hieu "+th);
        }
    }
    
    public void TimGiay_TheoNgaySanXuat(Date ngay)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String ngay_sx_c=formatter.format(ngay);
        int dem1 = 0;				
        for(int i=0;i<listGiay.size();i++) {
            String strDate = formatter.format(listGiay.get(i).getngay_sx());

            if(ngay_sx_c.compareTo(strDate)==0)
            {
                if(dem1==0)
                {
                    System.out.println("------- Danh sach giay co san xuat vao ngay "+ngay_sx_c+" -------");
                    System.out.printf("%-11s%-20s%-20s%-11s%s\n","Ma giay","Ten giay","Thuong hieu","Don gia","Ngay san xuat");
                }
                listGiay.get(i).Xuat();
                dem1++;
            }   
        }
        if(dem1 == 0) {
                System.out.println("**Khong tim thay giay nao co ngay san xuat la "+ngay_sx_c);
        }
    }
    
    public boolean CapNhatGiay(int id) {
    	int dem = 0;
    	Scanner sc = new Scanner(System.in);
		System.out.println("---------------------------------");
		
		for(int i=0; i<listGiay.size(); i++) {
			if(listGiay.get(i).getma_giay()==id) {
				System.out.println("Nhap ten giay moi (enter de bo qua): ");
				String tenGiay1 = sc.nextLine();
				if(!tenGiay1.isEmpty() && tenGiay1!=null && !tenGiay1.isBlank()) {
					listGiay.get(i).setten_giay(tenGiay1);
				}
				System.out.println("Nhap thuong hieu moi (enter de bo qua): ");
				String thGiay1 = sc.nextLine();
				if(!thGiay1.isEmpty() && thGiay1!=null && !thGiay1.isBlank()) {
					listGiay.get(i).setthuong_hieu(thGiay1);           		
				}
				System.out.println("Nhap don gia moi (enter de bo qua): ");
				String dongiaGiay1 = sc.nextLine();
				if(dongiaGiay1!=null) {
					try{
						listGiay.get(i).setdon_gia(Float.parseFloat(dongiaGiay1));
		    	    }catch(NumberFormatException e){
		    	    	listGiay.get(i).setdon_gia(listGiay.get(i).getdon_gia());
		    	    }
				}
				System.out.println("Nhap ngay san xuat moi (enter de bo qua): ");
				String ngaysxGiay1 = sc.nextLine();
				if(ngaysxGiay1!=null) {
					try{
						listGiay.get(i).setngay_sx(new SimpleDateFormat("dd/MM/yyyy").parse(ngaysxGiay1));
		    	    }catch(ParseException e){
		    	    	listGiay.get(i).setngay_sx(listGiay.get(i).getngay_sx());
		    	    }
				}
				giayDao.NhapFile(listGiay);
				dem++;
				break;
			}
		}
		
		if(dem==0) {
			return false;
		}
		return true;
    }
    
    public boolean XoaGiay(int id_d)
    {
        int dem_d=0;                               
        for(int i=0;i<listGiay.size();i++){
            if(listGiay.get(i).getma_giay()==id_d){
                listGiay.remove(i); 
                giayDao.NhapFile(listGiay);
                dem_d++;
                break;
            }
        }
        if(dem_d==0){
            return false;    
        }
        return true;
    }
    
    public void Sapxep_DongiaGiam()
    {
        Giay temp = new Giay();
        for (int i = 0 ; i < listGiay.size() - 1; i++) {
            for (int j = i + 1; j < listGiay.size(); j++) {
                if (listGiay.get(i).getdon_gia() < listGiay.get(j).getdon_gia()) {
                    temp = listGiay.get(j);
                    listGiay.set(j, listGiay.get(i));
                    listGiay.set(i, temp);
                }
            }
        }
    }
    
    public void Sapxep_TengiayTang()
    {
        Giay temp = new Giay();
        for (int i = 0 ; i < listGiay.size() - 1; i++) {
            for (int j = i + 1; j < listGiay.size(); j++) {
                if (listGiay.get(i).getten_giay().compareTo(listGiay.get(j).getten_giay())>0) {
                    temp = listGiay.get(j);
                    listGiay.set(j, listGiay.get(i));
                    listGiay.set(i, temp);
                }
            }
        }
    }
}
