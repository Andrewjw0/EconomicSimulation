
public class TestPoint {
	
	public void testEquals()
	{
		Point p0 = new Point(1, 1.0);
		Point p1 = new Point(1, 1.0);
		
		System.out.println("Are p0 and p1 equal?" + p0.equals(p1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestPoint testPoint = new TestPoint();
	}

}
