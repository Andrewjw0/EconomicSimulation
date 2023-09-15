package economicSimulation;

public class TestPoint {
	
	// typical constructor
	public void testConstructors()
	{
		Point p0 = new Point(); 						 //demonstrates a default point
		Point p1 = new Point(2, 3.4);
		
		System.out.println("p0 equals" + p0.toString()); // Should be the default, or (0, 0.0)
		System.out.println("p1 equals" + p1.toString()); // Should be (2, 3.4)
	}
	
	/**
	 * This tests various situations for the equals() methods.
	 */
	public void testEquals()
	{
		Point p0 = new Point(1, 1.0);
		Point p1 = new Point (1, 1.0);
		Point p2 = new Point(1, 1.009);
		Object pobj0 = (Object) p0;
		Object obj0 = new Object();
		
		System.out.println("Are p0 and p1 equal?" + p0.equals(p1)); 		  // They are equal and uses the overLOAD method (true)
		System.out.println("Are p0 and p2 equal?" + p0.equals(p2)); 		  // They are less than 1 cent apart and uses the overLoad method (true)
		System.out.println("Are pobj0 and p1 equal?" + pobj0.equals(p1));	  // They are equal and uses the overRIDE method (true)
		System.out.println("Are pobj0 and obj0 equal?" + pobj0.equals(obj0)); // obj0 is not a Point and uses the overRIDE method (false)
	}
	
	/**
	 * Method to ensure getting and setting works as intended.
	 */
	public void testGetSet()
	{
		Point p0 = new Point();
		
		//checking if get and sets work properly
		p0.setPrice(3.9);
		p0.setQuantity(12);
		System.out.println("p0's price is "+p0.getPrice()+" and its quantity is "+p0.getQuantity());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestPoint testPoint = new TestPoint();
		testPoint.testConstructors();
		testPoint.testEquals();
		testPoint.testGetSet();
	}

}
