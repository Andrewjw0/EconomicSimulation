package economicSimulation;

public class TestPoint 
{
	private Point p0;
	private Point p1;
	
	public TestPoint()
	{
		new Point();
		Point pt = new Point();
		System.out.println("Point default coords "+pt.toString());
		
		Point op = new Point(0,0.0);
		System.out.println("is "+op.toString()+" equal to pt? "+pt.equals(op));
		testEquals();
	}
	
	public void testEquals()
	{
		p0 = new Point(7,7.0);
		p1 = new Point(7,7.01);
		System.out.println("Are p0 "+p0.toString()+" and p1 "+p1.toString()+" equal (or less than a cent in difference)? "+p0.equals(p1));
	}
	
	public static void main(String[] argv)
	{
		new TestPoint();
		
	}
}
