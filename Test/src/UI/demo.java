package UI;

class test{

	private String name;
	
	public test(String name) {
		this.name = name;
	}
	
	public String makeChanges() {
		return name + "aaa";
	}
	
}

public class demo{
	public static void main(String[] args) {
		
		test t1 = new test("Vishwa");
		System.out.println(t1.makeChanges());
	}
}

