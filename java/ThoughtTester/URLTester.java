import java.net.MalformedURLException;
import java.net.URL;

public class URLTester {

	public static void main(String[] args) {
		new URLTester();
	}
		public static void soundSelect()
		{
			try
			{
				URL t = new URL("file:/D:test.txt");// 已选声音剪辑对象
				
				System.out.println(t.toString());
			} 
			catch (MalformedURLException murle) 
			{
				System.out.println(murle.toString());
			}
		}
}
