package week12;

class Camera implements Usb
{
	public void start()
	{
		System.out.println("�������");
	}

	public void stop() {
		System.out.println("���ֹͣ");
	}
}

class Phone implements Usb
{
	public void start() {
		System.out.println("�ֻ�����");
	}

	public void stop() {
		System.out.println("�ֻ�ֹͣ");
	}
	
}

public class ImpleTest {

	public static void main(String[] args) {
		Camera camera = new Camera();
		camera.start();
		camera.stop();
		Usb phone = new Phone();
		phone.start();
		phone.stop();
	}

}
