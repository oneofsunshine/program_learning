package week12;


class People {
	private String name;
	private int age;

	public People() {
		System.out.println("初始化 People 的实例变量--无参构造器");
	}

	public People(String name, int age) {
		System.out.println("初始化 People 的实例变量--有参构造器");
		this.name = name;
		this.age = age;
	}
}

public class Student extends People {
	private int sno;

	public Student() {
		System.out.println("初始化Student的实例变量--无参构造器：调用父类的无参构造器");

	}

	public Student(int sno) {
		System.out.println("初始化Student的实例变量--有参构造器：调用父类的无参构造器");
		this.sno = sno;
	}

	public Student(String nameIn, int ageIn, int sno) {
		super(nameIn, ageIn);
		System.out.println("初始化Student的实例变量--有参构造器：通过super调用父类的有参 构造器");
		this.sno = sno;
	}

	public static void main(String[] args) {
		Student p1 = new Student();
		System.out.println();
		Student p2 = new Student(1);
		System.out.println();
		Student p3 = new Student("王二麻子", 20, 1002016007);
		System.out.println();
	}
}