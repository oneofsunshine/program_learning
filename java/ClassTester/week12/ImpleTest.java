package week12;

class Camera implements Usb
{
	public void start()
	{
		System.out.println("相机启动");
	}

	public void stop() {
		System.out.println("相机停止");
	}
}

class Phone implements Usb
{
	public void start() {
		System.out.println("手机启动");
	}

	public void stop() {
		System.out.println("手机停止");
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
