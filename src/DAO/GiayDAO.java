package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Giay;

public class GiayDAO{
	
	private static final String GIAY_FILE = "giay.txt";
	
	public void NhapFile(List<Giay> TList) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(new File(GIAY_FILE));
			oos = new ObjectOutputStream(fos);
			oos.writeObject(TList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeStream(oos);
		}
	}
	
	public void NhapFile(LinkedList<Giay> TList) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(new File(GIAY_FILE));
			oos = new ObjectOutputStream(fos);
			oos.writeObject(TList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeStream(oos);
		}
	}
	
	public List<Giay> DocFile(){
		List<Giay> TList = new ArrayList<>();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(new File(GIAY_FILE));
			ois = new ObjectInputStream(fis);
			TList = (List<Giay>) ois.readObject();
		} catch (FileNotFoundException e) {
//            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
		return TList;
	}
	
	public LinkedList<Giay> DocFileDSLKD(){
		List<Giay> TList = new ArrayList<>();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(new File(GIAY_FILE));
			ois = new ObjectInputStream(fis);
			TList = (List<Giay>) ois.readObject();
		} catch (FileNotFoundException e) {
//            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
		
		List<Giay> linkedList = new LinkedList<>();
		for (Giay e: TList) {
            linkedList.add(e);
        }
		return (LinkedList<Giay>) linkedList;
	}
	
	private void closeStream(OutputStream os) {
		if(os != null) {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void closeStream(InputStream is) {
		if(is != null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
