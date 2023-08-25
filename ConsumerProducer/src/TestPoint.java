
public class TestPoint {
	
	public void testEquals()
	{
		Point p0 = new Point(1, 1.0);
		Point p1 = new Point(1, 1.0);
		Object pobj0 = (Object) p0;
		Object obj0 = new Object();
		
		System.out.println("Are p0 and p1 equal?" + p0.equals(p1));
		System.out.println("Are pobj0 and p1 equal?" + pobj0.equals(p1));
		System.out.println("Are pobj0 and obj0 equal?" + pobj0.equals(obj0));
	}
	
	public void testConstructors()
	{
		Point p0 = new Point();
		Point p1 = new Point(2, 3.4);
		
		System.out.println("p0 equals" + p0.toString());
		System.out.println("p1 equals" + p1.toString());
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestPoint testPoint = new TestPoint();
		testPoint.testConstructors();
		testPoint.testEquals();
	}

}
