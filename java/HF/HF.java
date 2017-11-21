import javax.swing.JOptionPane;
public class HF {

	public static void main(String[] args) {
		// 弹出一个输入框，输入男方姓名
		String boyName=JOptionPane.showInputDialog("输入男方的姓名");
//		弹出一个输入输入框，输入女方的姓名
		String girlName=JOptionPane.showInputDialog("输入女方的姓名");

//		System.out.println(boyName);
//		System.out.println(girlName);
		//消息框，情侣登记

		JOptionPane.showMessageDialog(null,"现在，"+boyName+"和"+girlName+"结为夫妇，送入洞房");
		System.exit(0);
	}

}
