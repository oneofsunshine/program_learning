package experimentCourse;

import javax.swing.JOptionPane;
public class JOptionDome {

	public static void main(String[] args) {
		// ����һ�����������ƻ���ĸ���
		String appleCount=JOptionPane.showInputDialog("����ƻ���ĸ���");
//		����һ����������������㽶�ĸ���
		String bananaCount=JOptionPane.showInputDialog("�����㽶�ĸ���");

		System.out.println(appleCount);
		System.out.println(bananaCount);
		//��Ϣ��ˮ���ĸ���
		int countApple,countBanana;
		countApple = Integer.parseInt(appleCount);
		countBanana = Integer.parseInt(bananaCount);
		JOptionPane.showMessageDialog(null, "ƻ�����㽶�ܹ���"+(countApple+countBanana)+"��");
		System.exit(0);
	}

}
