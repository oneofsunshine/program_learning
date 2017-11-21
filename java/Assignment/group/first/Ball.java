package group.first;

import java.awt.Color;

public class Ball
{
	private int x; //圆心坐标 x
	private int y; //圆心坐标 y
	private int radius = 20; //球的半径
	private Color color=Color.LIGHT_GRAY;
	private String number = ""; //球的号码
	private String ballType; //球的类型
	
	public String getNumber()
	{
		return number;
	}
	public void setNumber(String number)
	{
		this.number = number;
	}
	public String getBallType()
	{
		return ballType;
	}
	public void setBallType(String ballType)
	{
		this.ballType = ballType;
	}
	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getY() 
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public Color getColor()
	{
		return color;
	}
	public void setColor(Color color)
	{
		this.color = color;
	}
	public int getRadius()
	{
		return radius;
	}
	public void setRadius(int radius)
	{
		this.radius = radius;
	}
}
