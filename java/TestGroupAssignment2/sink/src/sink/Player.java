package sink;

public class Player {
	 private Dotcom[] dotcom = new Dotcom[3];
	 
	    
	    public Player(){
	        int i,j,k,l;
	        boolean bool= true;
	        for(;bool;){
	            bool= false;
	            Dotcom d0 = new Dotcom();
	            Dotcom d1 = new Dotcom();
	            Dotcom d2 = new Dotcom();
	            dotcom[0] = d0;dotcom[1] = d1;dotcom[2] = d2;
	            for(i=0;i<3;i++){
	                for(j=i+1;j<3;j++){
	                    for(k=0;k<3;k++){
	                        for(l=0;l<3;l++)
	                            if(dotcom[i].getdot()[k]==dotcom[j].getdot()[l])
	                                bool = true;
	                    }
	                }
	            }
	        }
	    }
	    public Dotcom[] getDotcom(){
	        return dotcom;
	    }
	    public boolean hit(int i){
	        if(compare(i))
	        return true;
	        else return false;
	    }
	    public boolean sink(){
	        int i=0,j;
	        boolean bool = true;
	        for(i=0;i<3;i++){
	            bool = true;
	            for(j=0;j<3&&bool;j++){
	                if(dotcom[i].getdot()[j]!=-1){
	                    bool = false;
	                }
	            }
	            if(bool)
	                break;
	        }
	        if(bool)
	            for(j=0;j<3;j++){
	                dotcom[i].getdot()[j] = -2;
	            }
	        if(bool){
	            return true;
	        }
	        else return false;
	    }
	    public boolean compare(int x){
	        int i,j;
	        boolean bool = false;
	        for(i=0;i<3;i++){
	            for(j=0;j<3;j++){
	                if(dotcom[i].getdot()[j]==x){
	                    bool = true;
	                    dotcom[i].getdot()[j] = -1;
	                }
	            }
	        }
	        return bool;
	    }
}
