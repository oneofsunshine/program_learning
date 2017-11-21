package week7;

import java.util.ArrayList;

public class ArrayTest {

	public static void main(String[] args) {
		ArrayList<String> movie=new ArrayList<String>();
		String a = "Ìì¿ÕÖ®³Ç";
		movie.add(a);
		
		String b = "Ç§ÓëÇ§Ñ°";
		movie.add(b);
		
		String c = "ÁúÃ¨";
		movie.add(c);
		
		for(String s:movie)
			System.out.println(s);
		
		movie.add("Ä§Å®Õ¬¼±±ã");
		movie.remove("ÁúÃ¨");
		movie.remove(a);
		
		for(int count=0;count<movie.size();count++)
			System.out.println(movie.get(count));
	}

}
