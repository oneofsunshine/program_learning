package week7;
import java.util.ArrayList;
public class ArrayListExample {

	public static void main(String[] args) {
		ArrayList<String> tutor = new ArrayList<String>();
		tutor.add("����");
		tutor.add("�Ň�");
		tutor.add("����");
		tutor.add("�㷢��");
		for(int n=0;n<tutor.size();n++)
			System.out.println(tutor.get(n));
		System.out.println(tutor.indexOf("����")+1);
		tutor.remove("����");
		for(String s:tutor)
			System.out.println(s);
		System.out.println(tutor.get(1));
		tutor.add(2,"����");
		System.out.println(tutor.size());
	}

}
