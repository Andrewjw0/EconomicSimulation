package economicSimulation;

public class TestProducerCurve {

	public TestProducerCurve()
	{
		ProducerCurve pc = new ProducerCurve();
		System.out.println("Original: " + pc.toString());
		
		Point op = new Point(11, 11.0); // should be true
//		op = new Point(0, 0.0); // left of curve (false)
//		op = new Point(5, 6.0); // above curve (false)
//		op = new Point(-1, -1.0); // left of and illegal? point (false)
//		op = new Point(5, 4.0); // below point (false)
//		op = new Point(5, 5.009); // above the curve but within tolerance (true)
//		op = new Point(1, 1.0); // first point (true)
//		op = new Point(10, 10.0); // last point (true)
		op = new Point(7, 3.0);
		
//		System.out.println("Is " + op5.toString() + " on the curve? " + pc.search(op5)); // should be false
	
		pc.add(op);
		System.out.println("Updated: " + pc.toString());
		pc.delete(op);
		System.out.println("Updated: " + pc.toString());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestProducerCurve testProducerCurve = new TestProducerCurve();
	}

}