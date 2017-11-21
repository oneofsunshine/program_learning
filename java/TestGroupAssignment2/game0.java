import java.util.Scanner;

public class game0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub						
		
		Dot[] acom=new Dot[3];
		
		Dot a = new Dot((int)(1+Math.random()*(5-1+2)), (int)(1+Math.random()*(5-1+2)));
		acom[0]=a;
		Dot a1 = new Dot(a.getx()-1,a.gety());
		acom[1]=a1;		
		Dot a2 = new Dot(a.getx()+1,a.gety());
		acom[2]=a2;
		
		Dot[] bcom= new Dot[3];
		Dot b =new Dot((int)(1+Math.random()*(5-1+2)), (int)(1+Math.random()*(5-1+2)));
		System.out.println(b.toString());
		if(a.x==b.x&&a.y==b.y){
			b.x=(int)(1+Math.random()*(5-1+2));
			b.y=(int)(1+Math.random()*(5-1+2));
		}
		while(a.y==b.y){
		if(a.x-b.x<=3){
			b.x=(int)(1+Math.random()*(5-1+2));
			b.y=(int)(1+Math.random()*(5-1+2));
		}}
		bcom[0]=b;
		Dot b1 = new Dot(b.getx()-1,b.gety());
		bcom[1]=b1;
		Dot b2 = new Dot(b.getx()+1,b.gety());
		bcom[2]=b2;
		
		Dot[] ccom= new Dot[3];
		Dot c = new Dot((int)(1+Math.random()*(5-1+2)), (int)(1+Math.random()*(5-1+2)));
		while(Math.abs(c.y-b.y)<2&&Math.abs(c.x-b.y)<2||Math.abs(c.y-a.y)<2&&Math.abs(c.x-a.y)<2){
			c.x=(int)(1+Math.random()*(5-1+2));
			c.y=(int)(1+Math.random()*(5-1+2));
		}
		System.out.println(c.toString());
		ccom[0]=c;
		Dot c1 = new Dot(c.getx(),c.gety()-1);
		ccom[1]=c1;
		Dot c2 = new Dot(c.getx(),c.gety()+1);
		ccom[2]=c2;
	  
		;
		int g1=1,g2 = 1,g3 =1;	  	
		Scanner  sc = new Scanner(System.in);
		Dot useless = new Dot(-1,-1);
	  	while(g1+g2+g3!=0){
	  	System.out.println("输入坐标(例d2)");
	  	
	  	int score=100;
	  	score=score--;
	  	
	  	String str = sc.next();
	  	
	  	if(str.length()>2){
	  		System.out.println("请认真输入，别乱搞");
	  		str =sc.next();
	  	}
	  	String sz = str.replaceAll("[0-9]","");
	  	sz=sz.toUpperCase();
	        String shuzi = sz.substring(1);        
	        char[] chars = sz.toCharArray();	        
	        String zm1 = chars[0]-64+shuzi;	        
	        System.out.println(zm1);
	        int  num  = Integer.valueOf(zm1);
	        
	    String zm = str.replaceAll("[a-zA-Z]","");
	    int  num2 = Integer.valueOf(zm);
	        Dot killer =new Dot(num,num2);//确定击点
	  	 System.out.println(killer.toString());
	  	  	
	  	for(int i=0;i<=2;i++){
	  		if(killer.x==acom[i].x&&killer.y==acom[i].y){
	  			acom[i]=useless;
	  			
	  			System.out.println("打中了");
	  			break;
	  		}
	  	}
	  	
	  	if(acom[0]==useless&&acom[1]==useless&&acom[2]==useless){
	  		System.out.println("你击沉了acom");
	  		g1=0;
	  	}
	  	for(int i=0;i<=2;i++){
	  		if(killer.x==bcom[i].x&&killer.y==bcom[i].y){
	  			bcom[i]=useless;
	  			
	  			System.out.println("打中了");
	  			break;
	  		}
	  	}
	  	if(bcom[0]==useless&&bcom[1]==useless&&bcom[2]==useless){
	  		System.out.println("你击沉了bcom");
	  		g2=0;
	  	}
	  	for(int i=0;i<=2;i++){
	  		if(killer.x==ccom[i].x&&killer.y==ccom[i].y){
	  			ccom[i]=useless;
	  			
	  			System.out.println("打中了");
	  			break;
	  		}
	  	}
	  	if(ccom[0]==useless&&ccom[1]==useless&&ccom[2]==useless){
	  		System.out.println("你击沉了ccom");	  		
	  		 g3=0;
	  	}
	  	if(g1==0 && g2==0&&g3==0){
	  		System.out.println("你击沉了所有能击落的东西"+"/n"+"你的分数是："+score);
	  	}
	  	
	  	}
}
}

