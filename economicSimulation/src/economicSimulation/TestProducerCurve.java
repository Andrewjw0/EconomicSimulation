package economicSimulation;

public class TestProducerCurve {

	public TestProducerCurve()
	{
		testConstructors();
		testSearch();
		testAdd();
		testDelete();
	}
	
	private void testConstructors()
	{
		// Default constructor
		ProducerCurve pc = new ProducerCurve();
		System.out.println("Default: " + pc.toString());
		// Testing different start and end points
		pc = new ProducerCurve(new Point(1, 1.0), new Point(20, 20.0), 10);
		System.out.println("Custom: " + pc.toString());
		pc = new ProducerCurve(new Point(1, 1.0), new Point(10, 10.0), 10);
		System.out.println("Custom: " + pc.toString());
	}
	
	private void testSearch()
	{
		ProducerCurve pc = new ProducerCurve();
		// Default constructor
		System.out.println("Original: " + pc.toString());
		Point op = new Point(5, 5.0); // should be true
		System.out.println("Is " + op.toString() + " on the curve? " + pc.search(op));
		op = new Point(0, 0.0); // left of curve (false)
		System.out.println("Is " + op.toString() + " on the curve? " + pc.search(op));
		op = new Point(5, 6.0); // above curve (false)
		System.out.println("Is " + op.toString() + " on the curve? " + pc.search(op));
		op = new Point(-1, -1.0); // left of and illegal? point (false)
		System.out.println("Is " + op.toString() + " on the curve? " + pc.search(op));
		op = new Point(5, 4.0); // below point (false)
		System.out.println("Is " + op.toString() + " on the curve? " + pc.search(op));
		op = new Point(5, 5.009); // above the curve but within tolerance (true)
		System.out.println("Is " + op.toString() + " on the curve? " + pc.search(op));
		op = new Point(1, 1.0); // first point (true)
		System.out.println("Is " + op.toString() + " on the curve? " + pc.search(op));
		op = new Point(10, 10.0); // last point (true)
		System.out.println("Is " + op.toString() + " on the curve? " + pc.search(op));s
	}
	
	private void testAdd()
	{
		// Default constructor
		ProducerCurve pc = new ProducerCurve();
		System.out.println("Original: " + pc.toString());
		Point op = new Point(5, 5.0); // already on the point (ignore)
		System.out.println("Updated: "+ pc.toString());
		op = new Point(-1, 1.0); // negative quantity (ignore)
		System.out.println("Updated: "+ pc.toString());
		op = new Point(1, -1.0); // negative price (ignore)
		System.out.println("Updated: "+ pc.toString());
		op = new Point(11, 11.0); // above and to the right of curve (add to end)
		System.out.println("Updated: "+ pc.toString());
		op = new Point(5, 7.0); // quantity already on the point (replace);
		System.out.println("Updated: "+ pc.toString());
	}
	
	private void testDelete()
	{
		// Default constructor
		ProducerCurve pc = new ProducerCurve();
		System.out.println("Original: " + pc.toString());
		Point op = new Point(5, 5.0); // on the point (delete);
		pc.delete(op);
		System.out.println("Updated: "+ pc.toString());
		op = new Point(11, 11.0); // not on the point (ignore);
		pc.delete(op);
		System.out.println("Updated: "+ pc.toString());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestProducerCurve testProducerCurve = new TestProducerCurve();
	}

}
