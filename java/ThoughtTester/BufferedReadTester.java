import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReadTester {

	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("src/breakTester/breakTester1.java")));
			String line;
			while((line = in.readLine()) != null)
			{
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
