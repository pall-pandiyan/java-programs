/**
 * 
 */
package relantionship;

/**
 * @author github.com/pall-pandiyan
 *
 */
public class Child extends Parent{
	int age;
	
	public Child(String name, int age) {
		super(name);
		this.age = age;
	}
	
	public void get_age() {
		System.out.println("Age is "+this.age);
	}
}
