
public class TestProducerCurve {

	public TestProducerCurve()
	{
		ProducerCurve pc = new ProducerCurve();
		System.out.println(pc.toString());
		
		Point p0 = new Point(0, 0.0);
		Point p1 = new Point(1, 1.0);
		System.out.println("Is " + p0.toString() + " on the curve? " + pc.searchPoint(p0)); // should be false
		System.out.println("Is " + p1.toString() + " on the curve? " + pc.searchPoint(p1)); // should be true
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestProducerCurve testProducerCurve = new TestProducerCurve();
	}

}
