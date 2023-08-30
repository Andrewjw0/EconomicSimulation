package economicSimulation;

public class TestProducerCurve 
{
	public TestProducerCurve()
	{
		Point op1 = new Point(5, 5.0);
		Point op2 = new Point(1, 1.0);
		Point op3 = new Point(11, 11.0); // OK to add
		new ProducerCurve();
		ProducerCurve pc = new ProducerCurve();
		System.out.println("ProducerCurve default points "+pc.toString());
		
//		Point op = new Point(0,0.0);
//		System.out.println("is "+op.toString()+" on the curve? "+pc.search(op)); // should be false
//		op = new Point(-1,-1.0);
//		System.out.println("is "+op.toString()+" on the curve? "+pc.search(op)); // should be false
//		op = new Point(5,4.0);
//		System.out.println("is "+op.toString()+" on the curve? "+pc.search(op)); // should be false	
//		System.out.println("is "+op.toString()+" on the curve? "+pc.search(op)); // should be false
//		op = new Point(4,5.0);
		
		// time to deal with rounding issues
		//	default is 16 digits right for decimal point of accuracy
		// nearest penny (2 decimal) rounding would be preferrable
		
		// BREAKS at (1,1.0) point exists on curve already IGNORE
		// BREAKS at (-1,-2.0) point is negative (NOT ALLOWED) IGNORE
		// BREAKS at (1,2.0) above curve SHOULD REPLACE EXISTING if quantities match
		// BREAKS at (2,1.0) below curve SHOULD REPLACE EXISTING if quantities match
		// BREAKS at (0,0.0) IMPOSSIBLE negotiation should be IGNORE
		pc.add(op3);
		System.out.println("ProducerCurve changed points "+pc.toString());
		

	}
	
	public static void main(String[] argv)
	{
		new TestProducerCurve();
	}
}
