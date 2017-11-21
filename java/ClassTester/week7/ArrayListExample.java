package week7;
import java.util.ArrayList;
public class ArrayListExample {

	public static void main(String[] args) {
		ArrayList<String> tutor = new ArrayList<String>();
		tutor.add("王三");
		tutor.add("张囧");
		tutor.add("理化生");
		tutor.add("你发将");
		for(int n=0;n<tutor.size();n++)
			System.out.println(tutor.get(n));
		System.out.println(tutor.indexOf("王三")+1);
		tutor.remove("理化生");
		for(String s:tutor)
			System.out.println(s);
		System.out.println(tutor.get(1));
		tutor.add(2,"撒法");
		System.out.println(tutor.size());
	}

}
