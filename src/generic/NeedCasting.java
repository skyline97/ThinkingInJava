package generic;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;


public class NeedCasting {

	@SuppressWarnings("unchecked")
	public void f(String[] args) throws Exception {
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("E:/temp/transaction.txt"));
		//fList<Widget> shapes = (List<Widget>) in.readObject();
		List<Widget> lw1 = List.class.cast(in.readObject());
	}
}
