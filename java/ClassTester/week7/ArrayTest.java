package week7;

import java.util.ArrayList;

public class ArrayTest {

	public static void main(String[] args) {
		ArrayList<String> movie=new ArrayList<String>();
		String a = "���֮��";
		movie.add(a);
		
		String b = "ǧ��ǧѰ";
		movie.add(b);
		
		String c = "��è";
		movie.add(c);
		
		for(String s:movie)
			System.out.println(s);
		
		movie.add("ħŮլ����");
		movie.remove("��è");
		movie.remove(a);
		
		for(int count=0;count<movie.size();count++)
			System.out.println(movie.get(count));
	}

}
