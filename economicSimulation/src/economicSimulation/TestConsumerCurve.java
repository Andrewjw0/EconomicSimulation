package economicSimulation;

public class TestConsumerCurve {

	public TestConsumerCurve()
	{
		testConstructors();
		testSearch();
		testAdd();
		testDelete();
	}
	
	private void testConstructors()
	{
		// Default constructor
		ConsumerCurve cc = new ConsumerCurve();
		System.out.println("Default: " + cc.toString());
		// Testing different start and end points
		cc = new ConsumerCurve(new Point(1, 20.0), new Point(20, 1.0), 10);
		System.out.println("Custom: " + cc.toString());
		cc = new ConsumerCurve(new Point(1, 10.0), new Point(10, 1.0), 10);
		System.out.println("Custom: " + cc.toString());
	}
	
	private void testSearch()
	{
		ConsumerCurve cc = new ConsumerCurve();
		// Default constructor
		System.out.println("Original: " + cc.toString());
		Point op = new Point(5, 6.0); // should be true
		System.out.println("Is " + op.toString() + " on the curve? " + cc.search(op));
		op = new Point(0, 0.0); // left of curve (false)
		System.out.println("Is " + op.toString() + " on the curve? " + cc.search(op));
		op = new Point(5, 7.0); // above curve (false)
		System.out.println("Is " + op.toString() + " on the curve? " + cc.search(op));
		op = new Point(-1, -1.0); // left of and illegal? point (false)
		System.out.println("Is " + op.toString() + " on the curve? " + cc.search(op));
		op = new Point(5, 5.0); // below curve (false)
		System.out.println("Is " + op.toString() + " on the curve? " + cc.search(op));
		op = new Point(5, 6.009); // above the curve but within tolerance (true)
		System.out.println("Is " + op.toString() + " on the curve? " + cc.search(op));
		op = new Point(1, 10.0); // first point (true)
		System.out.println("Is " + op.toString() + " on the curve? " + cc.search(op));
		op = new Point(10, 1.0); // last point (true)
		System.out.println("Is " + op.toString() + " on the curve? " + cc.search(op));
	}
	
	private void testAdd()
	{
		// Default constructor
		ConsumerCurve cc = new ConsumerCurve();
		System.out.println("Original: " + cc.toString());
		Point op = new Point(5, 6.0); // already on the point (ignore)
		System.out.println("Updated: "+ cc.toString());
		op = new Point(-1, 1.0); // negative quantity (ignore)
		System.out.println("Updated: "+ cc.toString());
		op = new Point(1, -1.0); // negative price (ignore)
		System.out.println("Updated: "+ cc.toString());
		op = new Point(11, 1.0); // right of curve (add to end)
		System.out.println("Updated: "+ cc.toString());
		op = new Point(5, 8.0); // quantity already on the point (replace);
		System.out.println("Updated: "+ cc.toString());
	}
	
	private void testDelete()
	{
		// Default constructor
		ConsumerCurve cc = new ConsumerCurve();
		System.out.println("Original: " + cc.toString());
		Point op = new Point(5, 6.0); // on the point (delete);
		cc.delete(op);
		System.out.println("Updated: "+ cc.toString());
		op = new Point(11, 11.0); // not on the point (ignore);
		cc.delete(op);
		System.out.println("Updated: "+ cc.toString());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestConsumerCurve testConsumerCurve = new TestConsumerCurve();
	}

}
