package abstractPackage;

import java.util.*;

public class ConsumerCurve extends AbstractCurve
{
	private ArrayList<Point> cCurveArrayList;
	
	public ConsumerCurve(Point sp, Point ep, int numPoints)
	{
		super(sp, ep, numPoints);
		cCurveArrayList = getCurveArrayList();
	}
	
	public void sort()
	{
		ArrayList<Point> tc = cCurveArrayList;
		
		for (int a = 0; a < tc.size(); a++)
		{
			for (int i = 0; i < tc.size() - 1; i++)
			{
				int   rhi = i + 1;
				Point leftP = tc.get(i);
				Point rightP = tc.get(rhi);
				
				if (leftP.getQuantity() > rightP.getQuantity())
				{
					swap(i, rhi);
				} 	
			} // end of individual cycle	
		} // end of all cycles
	} // end of sort()
}