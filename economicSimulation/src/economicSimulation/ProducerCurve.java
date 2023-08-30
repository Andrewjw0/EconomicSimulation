package economicSimulation;

public class ProducerCurve 
{
	private Point[] pCurveArray; // declares an array of Points. currently null
	
	public ProducerCurve()
	{
		pCurveArray = new Point[10]; // 10 empty slots instantiated
	
		// time to fill each one of those slots
		for (int i = 0; i<pCurveArray.length; i++)
		{
			int q = i+1;
			double p = i+1;
			pCurveArray[i] = new Point(q,p);
		}
	}
	
	public boolean search(Point op)
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
	
	 
	
	private int searchIndex(Point op)
	{
		for(int i=0; i<pCurveArray.length; i++)
		{
			Point p = pCurveArray[i];
			if (p.equals(op))
			{
				return i;
			}
		}
		return -1;
	}
	
	public void add(Point p)
	{
		if (search(p) == true) 
		{
			System.out.println("This point is already on the curve! Try a different one.");
			return;
		}
		if (p.getQuantity() < 1 || p.getPrice() <= 0)
		{
			System.out.println("You can't use a negative or 0!");
		}
		
		Point[] newArray = new Point[pCurveArray.length+1];
		for (int i=0; i<pCurveArray.length; i++)			
		{
			newArray[i] = pCurveArray[i];
		}
		newArray[newArray.length-1] = p;
		pCurveArray = newArray;
	}
	
	public void delete(Point p)
	{
		int foundIndex = searchIndex(p);
		if(foundIndex==-1) 
		{
			System.out.println("Requested point for deletion does not exist! Try a point on the line.");
			return;
		}
		Point tempArray[] = new Point[pCurveArray.length-1];
		for(int i=0; i<foundIndex; i++)
		{
			tempArray[i] = pCurveArray[i];
		}
		for(int i=foundIndex; i<tempArray.length; i++)
		{
			tempArray[i] = pCurveArray[i+1];
		}
		pCurveArray = tempArray;
	}
	
	
	public String toString()
	{
		String temp = "ProducerCurve: ";
		for (Point p : pCurveArray)
		{
			temp = temp + p.toString();
		}
		return temp;
	}
}
