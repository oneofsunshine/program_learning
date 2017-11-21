package week8;

import java.text.DecimalFormat;
	/*
	 * Assignment1:创建 Cylinder类，以存储标签、半径和高度;
	 * 				方法包括获得及设置这些成员变量， 计算直径、周长、圆柱表面积及圆柱体积;
	 * @Author YuanHao;
	 * Sno: 15130041045;
	 * */
public class Cylinder {

	private String label;//用以储存标签;
	private double radius;//用以储存半径;
	private double height;//用以储存高度;
	protected static int count = 0;//用于统计共创建多少对象;
	
	Cylinder(String labelln,double radiusln,double heightln)
	{
		this.label = labelln.trim();//使用trim方法去除字符串前后的空格，并将其赋值给label;
		this.radius = radiusln;
		this.height = heightln;
		count++;
	}//对变量进行初始化;
	
	public String getLabel()
	{
		return this.label;
	}//返回label的字符串;
	
	public boolean setLabel(String lab)
	{
		if(lab.length() == 0)//if(!lab.Empty())
			return false;
		else
		{
			this.label = lab.trim();
			return true;
		}
	}//如果输入接收到的字符串是空的，返回false，且不设置标签；否则返回true，对字符串用trim方法处理后对lable进行设置;
	
	public double getRadius()
	{
		return this.radius;
	}//返回代表radius的double类型值;
	
	public void setRadius(double rad)
	{
		this.radius = rad;
	}//接收一个double类型的数，设置radius;
	
	public double getHeight()
	{
		return this.height;
	}//返回代表 height的 double 类型值;
	
	public void setHeight(double hei)
	{
		this.height = hei;
	}//接收一个double类型的数，设置height;
	
	public double diameter()
	{
		return radius*2;
	}//返回代表直径的 double 类型值;
	
	public double circumference()
	{
		return 2*radius*Math.PI;
	}//返回代表周长的 double 类型值;
	
	public double area()
	{
		return Math.PI*Math.pow(radius, 2)*2 + 2*Math.PI*radius*height;
	}//返回代圆柱表面积的 double 类型值;
	
	public double volume()
	{
		return Math.PI*Math.pow(radius, 2)*height;
	}//返回代表圆柱体积的 double 类型值;
	
	public String toString()
	{
		DecimalFormat cy = new DecimalFormat("#,##0.0##");
		String result = "";
		result += "\"" + getLabel() + "\"" + " is a cylinder with radius = " + getRadius();
		result += " units and height = " + getHeight() + " units,\nwhich has diameter = " + diameter();
		result += " units, circumference = " + cy.format(circumference()) + " units,\narea = ";
		result += cy.format(area()) + " square units, and volume = " + cy.format(volume()) + " cubic units.";
		return result;
	}//返回Cylinder 对象的格式化输出信息;
}
