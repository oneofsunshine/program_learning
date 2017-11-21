package experimentCourse;

import javax.swing.JOptionPane;
public class JOptionDome {

	public static void main(String[] args) {
		// 弹出一个输入框，输入苹果的个数
		String appleCount=JOptionPane.showInputDialog("输入苹果的个数");
//		弹出一个输入输入框，输入香蕉的个数
		String bananaCount=JOptionPane.showInputDialog("输入香蕉的个数");

		System.out.println(appleCount);
		System.out.println(bananaCount);
		//消息框，水果的个数
		int countApple,countBanana;
		countApple = Integer.parseInt(appleCount);
		countBanana = Integer.parseInt(bananaCount);
		JOptionPane.showMessageDialog(null, "苹果和香蕉总共有"+(countApple+countBanana)+"个");
		System.exit(0);
	}

}
