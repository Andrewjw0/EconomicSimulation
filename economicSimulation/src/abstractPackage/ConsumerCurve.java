package abstractPackage;

import java.util.*;

public class ConsumerCurve extends AbstractCurve 
{	
	/**
	 * Proper constructor, uses a starting point (sp)
	 * and an ending point (ep) to fill in the ArrayList
	 * Number of points is specified with numPoints
	 */
	public ConsumerCurve(Point sp, Point ep, int numPoints)
	{
		super(sp, ep, numPoints);
	}
	
	/**
	 * Sorts curveArrayList by quantity
	 */
	public void sort()
	{
		ArrayList<Point> tc = getCurveArrayList();
		
		for (int a = 0; a < tc.size(); a++)
		{
			for (int i = 0; i < tc.size() - 1; i++)
			{
				int   rhi = i + 1;
				Point leftP = tc.get(i);
				Point rightP = tc.get(rhi);
				
				if (leftP.getPrice() > rightP.getPrice())
				{
					swap(i, rhi);
				}
			}
		}
	}
}
