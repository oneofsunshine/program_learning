package week12;


class People {
	private String name;
	private int age;

	public People() {
		System.out.println("��ʼ�� People ��ʵ������--�޲ι�����");
	}

	public People(String name, int age) {
		System.out.println("��ʼ�� People ��ʵ������--�вι�����");
		this.name = name;
		this.age = age;
	}
}

public class Student extends People {
	private int sno;

	public Student() {
		System.out.println("��ʼ��Student��ʵ������--�޲ι����������ø�����޲ι�����");

	}

	public Student(int sno) {
		System.out.println("��ʼ��Student��ʵ������--�вι����������ø�����޲ι�����");
		this.sno = sno;
	}

	public Student(String nameIn, int ageIn, int sno) {
		super(nameIn, ageIn);
		System.out.println("��ʼ��Student��ʵ������--�вι�������ͨ��super���ø�����в� ������");
		this.sno = sno;
	}

	public static void main(String[] args) {
		Student p1 = new Student();
		System.out.println();
		Student p2 = new Student(1);
		System.out.println();
		Student p3 = new Student("��������", 20, 1002016007);
		System.out.println();
	}
}