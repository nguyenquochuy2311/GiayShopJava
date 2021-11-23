package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Giay implements Serializable {
	private int ma_giay;
    private String ten_giay;
    private String thuong_hieu;
    private float don_gia;
    private Date ngay_sx;
    
    public Giay(){}
    
    public Giay(int ma_giay, String ten_giay, String thuong_hieu, float don_gia, Date ngay_sx)
    {
        this.ma_giay=ma_giay;
        this.ten_giay=ten_giay;
        this.thuong_hieu=thuong_hieu;
        this.don_gia=don_gia;
        this.ngay_sx=ngay_sx;
    }
    
    public int getma_giay(){
        return ma_giay;
    }
    public void setma_giay(int ma_giay){
        this.ma_giay=ma_giay;
    }
    
    public String getten_giay(){
        return ten_giay;
    }
    public void setten_giay(String ten_giay){
        this.ten_giay=ten_giay;
    }
    
    public String getthuong_hieu(){
        return thuong_hieu;
    }
    public void setthuong_hieu(String thuong_hieu){
        this.thuong_hieu=thuong_hieu;
    }
    
    public float getdon_gia(){
        return don_gia;
    }
    public void setdon_gia(float don_gia){
        this.don_gia=don_gia;
    }
    
    public Date getngay_sx(){
        return ngay_sx;
    }
    public void setngay_sx(Date ngay_sx){
        this.ngay_sx=ngay_sx;
    }
    
    public void Nhap(int id)
    {
        Scanner inp = new Scanner(System.in);
        ma_giay = id;
        System.out.println("Nhap ten giay: ");
        ten_giay=inp.nextLine();
        System.out.println("Chon thuong hieu: ");
        thuong_hieu=inp.nextLine();
        System.out.println("Nhap don gia: ");
        try{
        	don_gia=Float.parseFloat(inp.nextLine());
        }catch(NumberFormatException e){
            don_gia = 0;
        }
        System.out.println("Nhap ngay san xuat (dd/MM/yyyy)");
        try{
            ngay_sx=new SimpleDateFormat("dd/MM/yyyy").parse(inp.nextLine());
        }catch(ParseException ex){
//            Logger.getLogger(Giay.class.getName()).log(Level.SEVERE, null, ex);
        	ngay_sx=null;
        }  
    }
    
    public void Xuat()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(ngay_sx);
        System.out.printf("%-11d%-20s%-20s%-11.2f%s\n",ma_giay,ten_giay,thuong_hieu,don_gia,strDate);
    }
}
