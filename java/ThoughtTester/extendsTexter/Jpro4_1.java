package extendsTexter;

class Animal {
	int weight = 10;
	int height;
	Animal()
	{
		System.out.println("Animal construct");
	}
	public void eat()
	{
		System.out.println("Animal eat");
	}
	public void sleep()
	{
		System.out.println("Animal sleep");
	}
}
class Fish extends Animal
{
	Fish()
	{
		System.out.println("Fish construct");
	}
}
class Dog extends Animal
{
	int leg;
	Dog(int leg)
	{
		this.leg = leg;
		System.out.println("Dog construct");
	}
}
public class Jpro4_1 {

	public static void main(String[] args) {
		Animal am = new Animal();
		Fish fs = new Fish();
		Dog dg = new Dog(4);
		am.eat();
		fs.eat();
		am.weight = 100;
		System.out.println(am.weight);
		System.out.println(fs.weight);
	}

}
