package Objektverarbeitung;

import java.io.*;

public class VereineBearbeiten{
	private static final String file = "Vereine.txt";

	public static void speichern(Verein verein){
		try{
			File f1 = new File(file);
			FileOutputStream fos = new FileOutputStream(f1);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(verein);
			oos.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

	public static void ausgeben(){
		try{
			File f1 = new File(file);
			FileInputStream fis = new FileInputStream(f1);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			String ueber = ois.readObject().toString();
			System.out.println(ueber);
			System.out.println();
			BeispielObjekt o;
			for(int i = 0; i<3; i++){
				o = (BeispielObjekt) ois.readObject();
				System.out.println(o.toString());
			}
			ois.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
