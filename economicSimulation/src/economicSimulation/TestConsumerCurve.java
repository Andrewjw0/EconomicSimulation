package economicSimulation;

public class TestConsumerCurve {

	public TestConsumerCurve()
	{
		ConsumerCurve cc = new ConsumerCurve(new Point(1, 10.0), new Point(10, 1.0), 10);
		System.out.println("Original: " + cc.toString());
		
		Point op = new Point(5, 7.0); // should be true
//		op = new Point(0, 0.0); // left of curve (false)
//		op = new Point(5, 7.0); // above curve (false)
//		op = new Point(-1, -1.0); // left of and illegal? point (false)
//		op = new Point(5, 5.0); // below point (false)
//		op = new Point(5, 6.009); // above the curve but within tolerance (true)
//		op = new Point(1, 10.0); // first point (true)
//		op = new Point(10, 1.0); // last point (true)
//		op = new Point(5, 11.0);
//		
//		System.out.println("Is " + op5.toString() + " on the curve? " + cc.search(op5)); // should be false
	
		cc.add(op);
		System.out.println("Updated" + cc.toString());
		cc.delete(op);
		System.out.println("Updated" + cc.toString());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestConsumerCurve testProducerCurve = new TestConsumerCurve();
	}

}
