package abstractPackage;

import java.util.*;

public class ProducerCurve extends AbstractCurve
{
	private ArrayList<Point> pCurveArrayList;
	
	public ProducerCurve(Point sp, Point ep, int numPoints)
	{
		super(sp, ep, numPoints);
		pCurveArrayList = getCurveArrayList();
	}
	
	public void sort()
	{
		ArrayList<Point> tc = pCurveArrayList;
		
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
