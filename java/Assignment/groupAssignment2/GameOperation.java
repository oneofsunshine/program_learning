package groupAssignment2;

import java.applet.*;
import sun.audio.*;
import java.util.ArrayList;
import java.util.Collections;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameOperation extends JFrame{
	private int times;// 记录猜测次数;
	private int scores;// 记录分数
	private ArrayList<String> choiceList;// 储存用户选择的坐标;
	private ArrayList<String> correctList;// 储存用书输入的正确坐标;
	private ArrayList<String> choiceCorrectList;
	private int[] sink = new int[3];
	private SoundPlayer player;
	
	public GameOperation()
	{
		times = 0;
		scores = 100;
		choiceList = new ArrayList<>();
		correctList = createRandomGrid();
		choiceCorrectList = new ArrayList<>();
		sink[0] = 0;
		sink[1] = 0;
		sink[2] = 0;
	}
	
	public int getTime()
	{
		return times;
	}// 获取次数;
	
	public void setTime()
	{
			times = choiceList.size();
	}// 设置次数;
	
	public int getScore()
	{
		return scores;
	}// 获取分数;
	
	public void setScore()
	{
		switch(times/5)
		{
		case 0:break;
		case 1:scores = 90;break;
		case 2:scores = 80;break;
		case 3:scores = 70;break;
		default:scores = 60;
		}
	}// 设置分数;
	
	public boolean judgeSelect(int xln, int yln)
	{
		boolean tf = false;
		if(xln < 50 || xln > 400 || yln < 10 || yln >360)
			return tf;
		else
			tf = true;
		System.out.printf("mouseX,mouseY (%3d,%3d)\n", xln, yln);
		return tf;
	}// 用于判断鼠标点击的坐标位置是否有效;
	
	public int selectCharacter(int yln)
	{
		return (yln - 10) / 50;
	}// 判断用户选择的字母坐标;

	public int selectNumber(int xln)
	{
		return xln / 50;
	}// 判断用户选择的数字坐标;

	public ArrayList<String> getChoice()
	{
		return choiceList;
	}// 返回用户输入的选择坐标数组;

	public void addChoice(String s)
	{
		this.choiceList.add(s);
	}// 将用户选择的坐标添加到数组中;
	
	public boolean isSelected(String s)
	{
		if(this.choiceList.contains(s))
			return true;
		else
			return false;
	}// 判断用户选择的坐标是否选择过;
	
	public ArrayList<String> createRandomGrid()
	{
		ArrayList<String> ran = new ArrayList<>();
		String s;
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
		return ran;
	}
	
	public String getCorrectGrid()
	{
		String s = "Correct Grid: ";
		for(String s1 : correctList)
			s += s1 + " "; 
		return s;
	}// 返回代表正确坐标位置的字符串;
	
	public void setChoiceCorrectList(String cc)
	{
		if(correctList.contains(cc))
		{
			choiceCorrectList.add(cc);
			Collections.sort(choiceCorrectList);
		}
	}
	
	public String getChoiceCorrectList()
	{
		String s = "";
		for(String s1 : choiceCorrectList)
			s += s1 + " "; 
		return s;
	}
	
	public void clearCorrectGrid()
	{
		correctList.clear();
	}
	
	public void setCorrectGrid(String sln)
	{
		String s = sln.toUpperCase();
		String one;
		if(!setBefore(s))
		{
			for(int i = 0; i < 3; i++)
			{
				one = Character.toString(s.split(" ")[i].charAt(0)) + s.split(" ")[i].charAt(1);
				System.out.println("cl["+correctList.size()+"]add" + one);
				correctList.add(one);
			}
			System.out.println("cl:\t" + correctList);
		}
		else
			System.out.println("wrong");
	}// 弹出输入框，提示用户输入正确的坐标;
	
	public boolean setBefore(String s1)
	{
		
		boolean tf = false;
		s1.toUpperCase();
		String one;
		if(!setMakeSense(s1))
		{
			System.out.println("not make sense ");
			tf = true;
			return tf;
		}
		else if(setMakeSense(s1))
		{
			for(int i = 0; i < 3; i++)
			{
				one = s1.split(" ")[i];
				if(correctList.contains(one))
				{
					tf = true;
					System.out.println("set before");
					return tf;
				}
			}
			return tf;
		}
		else
			return tf;
	}// 判断用户输入的正确坐标是否已输入;
	
	
	public boolean setMakeSense(String sln)
	{
		sln = sln.toUpperCase();
		boolean tf = true;
		String[] s = new String[3];
		char[] a = new char[3];
		int[] b = new int[3];
		int min, max;
		for(int i = 0; i < 3; i++)
		{
			s[i] = sln.split(" ")[i];
			a[i] = s[i].charAt(0);
			b[i] = (int)(s[i].charAt(1)) - 48;
			if(a[i] < 'A' || a[i] > 'G' || b[i] < 0 || b[i] > 6)
			{
				tf = false;
				return tf;
			}
		}
		if(a[0] == a[1])
		{
			min = b[0] < b[1] ? b[0] : b[1];
			min = b[2] < min ? b[2] : min;
			max = b[0] > b[1] ? b[0] : b[1];
			max = b[2] > max ? b[2] : max;
			if(a[1] != a[2] || max - min != 2)
			{
				tf = false;
				return tf;
			}
			else if(b[0] == b[1] || b[1] == b[2] || b[0] == b[2])
			{
				tf = false;
				return tf;
			}
		}
		else
		{
			min = a[0] < a[1] ? a[0] : a[1];
			min = a[2] < min ? a[2] : min;
			max = a[0] > a[1] ? a[0] : a[1];
			max = a[2] > max ? a[2] : max;
			if(b[1] != b[2] || max - min != 2)
			{
				tf = false;
				return tf;
			}
			else if(a[0] == a[1] || a[1] == a[2] || a[0] == a[2])
			{
				tf = false;
				return tf;
			}
		}
		return tf;
	}// 判断用户输入的正确坐标是否有效;
	
	public void soundSelect() throws Exception
	{
		player = new SoundPlayer("src/groupAssignment2/select.wav");
		player.play();
	}
	
	public void soundMiss() throws Exception
	{
		player = new SoundPlayer("src/groupAssignment2/miss.wav");// 选错声音文件
		player.play();
	}
	
	public void soundHit() throws Exception
	{
		player = new SoundPlayer("src/groupAssignment2/hit.wav");// 击中声音文件
		player.play();
	}
	
	public void soundSink() throws Exception
	{
		player = new SoundPlayer("src/groupAssignment2/sink.wav");// 击沉声音文件
		player.play();
	}
	
	public void soundWin() throws Exception
	{
		player = new SoundPlayer("src/groupAssignment2/win.wav");// 获胜声音文件
		player.play();
	}
	
	public void soundLost() throws Exception
	{
		player = new SoundPlayer("src/groupAssignment2/lost.wav");// 失败声音文件
		player.play();
	}
	
	public int getCorrectNum(String s)
	{
		for(int i = 0; i < correctList.size(); i++)
		{
			if(s.equals(correctList.get(i)))
				return i;
		}
		return -1;
	}

	public boolean isHit(String s)
	{
		if(this.isSelected(s))
			return false;
		else
		{
			if(correctList.contains(s))
			{
				int j;
				for(int i = 0; i < 9; i++)
				{
					if(s.equals(correctList.get(i)))
					{
						j = i/3;
						sink[j] = sink[j] + 1;
						System.out.println("sink[" + j + "] : " + sink[j]);
					}
				}
				return true;
			}
			else
				return false;
		}
	}
	
	public boolean isSink()
	{
		for(int j = 0; j < 3; j++)
		{
			if(sink[j] == 3)
			{
				sink[j]++;
				return  true;
			}
		}
		return false;
	}// 返回一个boolean 类型的值，代表是否已经击沉;
	
	
	public int gameOver()
	{
		if(choiceCorrectList.size() + 1 == correctList.size())
			return 1;
		else if(choiceList.size() + 1 >= 32)
			return -1;
		else
			return 0;
	}// 如果游戏结束，返回结束原因;
	
}
