package middleExam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadUrls {
	/*
	 * topic3: 读取urls.inp文件，并以“/”为分隔符将前后的内容按行输出;
	 * @Author: 苑浩;
	 * Sno: 15130041045;
	 * */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = scan.nextLine();
	    Scanner scanFile = new Scanner(new File(fileName));
	    
	    ArrayList<String> scanLine = new ArrayList<String>();

	    while(scanFile.hasNext())
	    {
	    	scanLine.add(scanFile.nextLine());
	    }

	    
	    for(int i=0;i<scanLine.size();i++)
	    {
	    	Scanner sc = new Scanner(scanLine.get(i));
		    sc.useDelimiter("/");
	    	System.out.print("URL: ");
	    	System.out.println(scanLine.get(i));
	    	while(sc.hasNext())
	    		System.out.println("\t"+sc.next());
	    }
	}

}
