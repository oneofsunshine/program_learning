package week7;

import java.text.DecimalFormat;
import java.util.ArrayList;

import week8.Cylinder;
/*
 * Assignment1:：创建 CylinderList类,对几个Cylinder组成的集合进行信息处理，获得汇总信息;
 * 				方法包括：获得集合名，求对象数，求表面积和，求体积和，求平均表面积，求平均体积以及汇总信息;
 * @Author YuanHao；
 * Sno: 15130041045
 * */
public class CylinderList {
	private String listName;
	private ArrayList<Cylinder> cList;
	
	CylinderList(String ln,ArrayList<Cylinder> cl)
	{
		this.listName = ln;
		this.cList = cl;
	}//包含两个参数，第一个参数是代表集合名字的字符串；第二个参数是 ArrayList<Cylinder>类型的集合变量 ;
	
	public String getName()
	{
		return this.listName;
	}//返回一个代表集合名字的字符串 
	
	public int numberOfCylinders()
	{
		return cList.size();
	}//返回代表集合中 Cylinder 对象个数的整型值;
	
	public double totalArea()
	{
		double sumOfArea = 0.0;
		for(int i=0;i<cList.size();i++)
			sumOfArea += cList.get(i).area();
		return sumOfArea;
	}//返回代表所有 Cylinder 对象表面积和的 double 类型值;
	
	public double totalVolume()
	{
		double sumOfVolume = 0.0;
		for(int i=0;i<cList.size();i++)
			sumOfVolume += cList.get(i).volume();
		return sumOfVolume;
	}//返回代表所有 Cylinder 对象体积和的 double 类型值;
	
	public double averageArea()
	{
		if(cList.size()!=0)
			return totalArea()/cList.size();
		else
			return 0.0;
	}//返回代表所有 Cylinder对象表面积平均值的 double 类型值,如果对象数为0，则返回0.0;
	
	public double averageVolume()
	{
		if(cList.size()!=0)
			return totalVolume()/cList.size();
		else
			return 0.0;
	}//返回代表所有 Cylinder对象体积平均值的 double 类型值,如果对象数为0，则返回0.0;
	
	public String toString()
	{
		String result;
		result = "\n"+getName();
		for(int i =0;i<cList.size();i++)
			result += "\n\n"+cList.get(i);
		return result;
	}//返回一个字符串，包含集合的名字及集合中的每一个对象（调用对象的 toString 方法）;
	
	public String summaryInfo()
	{
		DecimalFormat cy = new DecimalFormat("#,##0.0#");
		DecimalFormat cyl = new DecimalFormat("#,##0.0##");
		String result;
		double sumOfHeight = 0.0;
		for(int i=0;i<cList.size();i++)
			sumOfHeight += cList.get(i).getHeight();
		double sumOfDiameter = 0.0;
		for(int i=0;i<cList.size();i++)
			sumOfDiameter += cList.get(i).diameter();
		result = "----- "+getName()+" Summary -----\n";
		result += "Number of Cylinders: "+cList.size()+"\n";
		result += "Total Area: "+cy.format(totalArea())+"\n";
		result += "Total Volume: "+cy.format(totalVolume())+"\n";
		result += "Total Height: "+cy.format(sumOfHeight)+"\n";
		result += "Total Diameter: "+cy.format(sumOfDiameter)+"\n";
		result += "Average Area: "+cyl.format(averageArea())+"\n";
		result += "Average Volume: "+cy.format(averageVolume());
		return result;
	}//返回一个字符串，包含集合的名字及 Cylinder对象的个数，总表面积， 总体积，总高度，总直径，平均表面积及平均体积;
}
