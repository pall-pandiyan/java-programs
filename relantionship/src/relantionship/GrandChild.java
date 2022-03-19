/**
 * 
 */
package relantionship;

/**
 * @author github.com/pall-pandiyan
 *
 */
public class GrandChild extends Child{

	/**
	 * @param name
	 * @param age
	 */
	String gender;
	
	public GrandChild(String name, int age, String gender) {
		super(name, age);
		// TODO Auto-generated constructor stub
		this.gender = gender;
	}
	public void get_gender() {
		System.out.println("Gender is "+this.gender);
	}

}
