package io_;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Blip3 implements Externalizable{

	private int i;
	private String s;
	
	public Blip3() {
		System.out.println("Blip3 Constructor");
	}
	
	public Blip3(String x,int a) {
		System.out.println("Blip(String x,int a)");
		s = x;
		i = a;
	}
	
	@Override
	public String toString() {
		return s + i;
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip3.writeExternal");
		out.writeObject(s);
		out.writeInt(i);
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("Blip3.readExternal");
		s = (String)in.readObject();
		i = in.readInt();
	}
	
	public static void main(String[] args) throws IOException,ClassNotFoundException{
		System.out.println("COnstructing objects:");
		Blip3 b3 = new Blip3("A String",47);
		System.out.println(b3);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
		System.out.println("Saving object:");
		out.writeObject(b3);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
		System.out.println("Recovering b3:");
		b3 = (Blip3) in.readObject();
		in.close();
		System.out.println(b3);
	}
}
