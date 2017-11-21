package sink;

public class Dotcom {
	
    private int[] dot={-1,-1,-1} ;
    
    public Dotcom(){
    	for(;!(noborder(dot[0])&&noborder(dot[1])&&noborder(dot[2]));)
        fordot(formprint());
    }
    public int formprint(){
        return (int)(Math.random()*7)*10+(int)(Math.random()*7);
    }
    public void fordot(int x){
        int y=(int)(Math.random()*6);
            if(y==0)
            	dot[0] = x;dot[1] = x+1;dot[2] = x+2;
            if(y==1)
            	dot[0] = x-1;dot[1] = x;dot[2] = x+1;
            if(y==2)
            	dot[0] = x-2;dot[1] = x-1;dot[2] = x;
            if(y==3)
            	dot[0] = x;dot[1] = x+10;dot[2] = x+20;
            if(y==4)
            	dot[0] = x-10;dot[1] = x;dot[2] = x+10;
            if(y==5)
            	dot[0] = x-20;dot[1] = x-10;dot[2] = x;
        }
    
    public static boolean noborder(int x){
        if(x/10<0||x/10>6||x%10>6||x%10<0)
            return false;
        else return true;
    }
    public int[] getdot(){
        return dot;
    }
}
