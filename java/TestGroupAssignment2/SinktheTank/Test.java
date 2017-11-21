package SinktheTank;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Test {
	static int score123 = 10;
	static JPanel panel2 = new JPanel();
	static JLabel anotherLable = new JLabel("Game.sunk()");
	static JLabel score = new JLabel("YourScore: "+score123);
	
	public static void main(String args[]){
		Game.start();
		
		JFrame f = new JFrame("Sink the Tank");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(50, 50, 1000, 700);
        f.setResizable(false);
        
        FlowLayout layout = new FlowLayout();
		 f.setLayout(layout);
	        
        JPanel panel1 =new JPanel();//panel1
        panel1.setPreferredSize(new Dimension(1000,60));
        JLabel Lable = new JLabel("Welcome to SINK THE TANK!!! Good Luck!!!");
        Font font=new Font("New Times Rome",Font.PLAIN,24);
        Lable.setFont(font);
        panel1.add(Lable);
        f.add(panel1);
        
		// JPanel panel2 = new JPanel();
	        panel2.setPreferredSize(new Dimension(150,560));
	        JLabel RuleLable1 = new JLabel("��49�������У�����3");
	        JLabel RuleLable2 = new JLabel("��ռ3���С�����뽫");
	        JLabel RuleLable3 = new JLabel("��������������");
	        
	        panel2.add(anotherLable);
	        panel2.add(score);
	        panel2.add(RuleLable1);
	        panel2.add(RuleLable2);
	        panel2.add(RuleLable3);
	        f.add(panel2);
	        
        
        JPanel panel = new JPanel();//panel
        setMypanel(panel);
        f.add(panel);
        
        f.setVisible(true);
	}
	
	 private static void setMypanel(JPanel panel){
		 panel.setPreferredSize(new Dimension(600,560));
		 GridLayout gridLayout = new GridLayout(7,7);
		 panel.setLayout(gridLayout);
		 JButtonShip jbl[][] = new JButtonShip[7][7];
		 
		 for(int i = 0;i < 7;i ++){
			 for(int j = 0;j < 7;j ++){
				 jbl[i][j] = new JButtonShip();
				 setMyButton(i,j,jbl);
				 panel.add(jbl[i][j]); 
			 }
		 }
	 }
	 
	 public static void setMyButton(final int i, final int j,final JButtonShip[][] jbl){
		 jbl[i][j].setBackground(Color.ORANGE);
		 

			 jbl[i][j].addActionListener(new ActionListener(){
			@Override
				public void actionPerformed(ActionEvent e) {
				 if(!jbl[i][j].isClicked()) {
					jbl[i][j].setClicked(true);
					if(e.getSource() == jbl[i][j]){
						if(Game.sunk().equals("ս������ ȫ������ ��Ӯ��")) {
							score.setText("������˻������");
						}
						else{
							if(Game.hit(i,j)){
								jbl[i][j].setBackground(Color.red);
								score.setText("���������ɶ�һ��: "+ ++score123);
								System.out.println(i+" "+j);
								}
							else{
								jbl[i][j].setBackground(Color.blue);
								score.setText("̫���ˣ�ʧȥ��һ��: "+ --score123);
							}
						}
						write();
				}
			}
			}
		}); 
		
	 }
	public static void write(){
    anotherLable.setText(Game.sunk());
	}
}
