import java.util.ArrayList;

public class text {

	public static void main(String[] args) {
		// 生成3个网址
		String s;
		ArrayList<String> ran = new ArrayList<>();
		
		int x, y;
		x = (int)(Math.random() * 7);
		y = (int)(Math.random() * 7);
		while(ran.size() < 9)
		{
			if(x < 3&&y<3)
			{
				for(int k = 0; k < 3; k++)
				{
					s = Character.toString((char)('A' + x + k))+y;
					ran.add(s);
				}
				x += 3;
				y += 4;
			}
			else if(x>=3&&y<3)
			{
				for(int k = 0; k < 3; k++)
				{
					
					s = Character.toString((char)('A' + x - k))+y;
					ran.add(s);
				}
				if(x == 6)
				{
					x -= 5;
					y += 4;
				}
				else
				{
					x -= 3;
					y += 4;
				}
			}
			else if(x<3&&y>=3)
			{
				for(int k = 0; k < 3; k++)
				{
					s = Character.toString((char)('A' + x))+(y-k);
					ran.add(s);
				}
				x += 4;
				y -= 3;
			}
			else
			{
				for(int k = 0; k < 3; k++)
				{
					s = Character.toString((char)('A' + x))+(y-k);
					ran.add(s);
				}
				if((int)(Math.random()*2) == 1)
					y -= 3;
				else
				{
					if(x == 3)
						x -= 1;
					else
						x -= 4;
				}
			}
		}
		
		System.out.println(ran);
			
	}

}
