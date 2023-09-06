package economicSimulation;

public class ProducerCurve {
	
	private Point[] pCurveArray;
	
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
	
	public ProducerCurve(Point sp, Point ep, int numPoints)
	{
		pCurveArray = new Point[numPoints];
		pCurveArray[0] = sp;
		
		int    deltaQ = (int) Math.round((ep.getQuantity() - sp.getQuantity()) / (numPoints * 1.0));
		double deltaP = (ep.getPrice() - sp.getPrice()) / (numPoints - 1);
		
		for (int i = 0; i < numPoints - 1; i++)
		{
			int    q = sp.getQuantity() + deltaQ * (i + 1);
			double p = sp.getPrice() + deltaP * (i + 1);
			pCurveArray[i + 1] = new Point(q, p);
		}
	}
	
	public String toString()
	{
		String temp = "ProducerCurve: ";
		
		for (Point p : pCurveArray)
		{
			temp = temp + p.toString() + ", ";
		} 
		
		return temp;
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
	
	private int searchForIndex(Point op)
	{
		for (int i = 0; i < pCurveArray.length; i++)
		{
			if (pCurveArray[i].equals(op))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	private int searchForIndex(int q)
	{
		for (int i = 0; i < pCurveArray.length; i++)
		{
			if (pCurveArray[i].getQuantity() == q)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	private int searchForIndex(double p)
	{
		for (int i = 0; i < pCurveArray.length; i++)
		{
			if (pCurveArray[i].getPrice() == p)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	private int searchMatchingQuantity(Point p)
	{	
		for (int i = 0; i < pCurveArray.length; i++)
		{
			Point temp = pCurveArray[i];
			
			if (p.getQuantity() == temp.getQuantity())
			{
				return i;
			}
		}
		
		return -1;
	}
	
	private void sortByQuantity()
	{
		Point[] tc = pCurveArray;
		
		for (int a = 0; a < tc.length; a++)
		{
			for (int i = 0; i < tc.length - 1; i++)
			{
				int rhi = i + 1;
				Point leftP = tc[i];
				Point rightP = tc[rhi];
				
				if (leftP.getQuantity() > rightP.getQuantity())
				{
					swap(i, rhi);
				}
			}
		}
	}
	
	public void add(Point p)
	{	
		if (search(p) == true)
		{
			return;
		}
		
		if (p.getQuantity() <= 0)
		{
			return;
		}
		
		if (p.getPrice() <= 0)
		{
			return;
		}
		
		int index = searchMatchingQuantity(p);
		
		if (index >= 0) 
		{
			pCurveArray[index] = p;
			return;
		}
		
		Point[] newArray = new Point[pCurveArray.length + 1];
		
		for (int i = 0; i < pCurveArray.length; i++)
		{
			newArray[i] = pCurveArray[i];
		}
		
		newArray[newArray.length - 1] = p;
		pCurveArray = newArray;
		sortByQuantity();
	}
	
	public void delete(Point p)
	{
		int foundIndex = searchForIndex(p);
		
		if (foundIndex == -1)
		{
			return;
		}
		
		Point[] newArray = new Point[pCurveArray.length - 1];
		
		for (int i = 0; i < foundIndex; i++)
		{
			newArray[i] = pCurveArray[i];
		}
		
		for (int i = foundIndex; i < newArray.length; i++)
		{
			newArray[i] = pCurveArray[i + 1];
		}
		
		pCurveArray = newArray;
	}
	
	private void swap(int i1, int i2)
	{
		Point tp = pCurveArray[i1];
		
		pCurveArray[i1] = pCurveArray[i2];
		pCurveArray[i2] = tp;
	}
}
