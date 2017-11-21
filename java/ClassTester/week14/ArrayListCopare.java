package week14;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListCopare {

	public static void main(String[] args) {
		ArrayList<String > a = new ArrayList<>();
		
		String s = "2";
		a.add(s);
		s = new String("1");
		a.add(s);
		s = new String("3");
		a.add(s);
		
		System.out.println(a);
		Collections.sort(a);
		System.out.println("\n"+a);
	}

}
