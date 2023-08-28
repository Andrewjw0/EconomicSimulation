
public class ProducerCurve {
	
	private Point[] pCurveArray;
	
	public String toString()
	{
		String temp = "ProducerCurve default points: ";
		
		for (Point p : pCurveArray)
		{
			temp += p.toString();
		} 
		
		return temp;
	}
	
	public boolean searchPoint(Point op)
	{
		for (Point p : pCurveArray)
		{
			if (p.equals(op))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public ProducerCurve()
	{
		pCurveArray = new Point[10];
		
		for (int i = 0; i < pCurveArray.length; i++)
		{
			int q = i + 1;
			double p = i + 1.0;
			pCurveArray[i] = new Point(q, p);
		}
	}
}
