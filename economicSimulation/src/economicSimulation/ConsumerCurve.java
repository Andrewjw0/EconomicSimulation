package economicSimulation;

import java.util.*;

public class ConsumerCurve {
	
	private ArrayList<Point> cCurveArrayList;
	
	public ConsumerCurve()
	{
		cCurveArrayList = new ArrayList<Point>();
		
		for (int i = 0; i < 10; i++)
		{
			int q = i + 1;
			double p = 10 - i;
			cCurveArrayList.add(new Point(q, p));
		}
	}
	
	public ConsumerCurve(Point sp, Point ep, int numPoints)
	{
		cCurveArrayList = new ArrayList<Point>(numPoints + 1);
		cCurveArrayList.add(sp);
		
		int    deltaQ = (int) Math.round((ep.getQuantity() - sp.getQuantity()) / (numPoints * 1.0));
		double deltaP = (ep.getPrice() - sp.getPrice()) / (numPoints - 1);
		
		for (int i = 1; i < numPoints - 1; i++)
		{
			int    q = sp.getQuantity() + deltaQ * (i);
			double p = sp.getPrice() + deltaP * (i);
			cCurveArrayList.add(new Point(q, p));
		}
		
		cCurveArrayList.add(ep);
	}
	
	public String toString()
	{
		String temp = "ConsumerCurve: ";
		
		for (Point p : cCurveArrayList)
		{
			temp = temp + p.toString() + ", ";
		} 
		
		return temp;
	}
	
	public boolean search(Point op)
	{
		for (Point p : cCurveArrayList)
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
		for (int i = 0; i < cCurveArrayList.size(); i++)
		{
			if (cCurveArrayList.get(i).equals(op))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	private int searchMatchingQuantity(Point op)
	{
		ArrayList<Point> tc = cCurveArrayList;
		
		for (int i = 0; i < tc.size(); i++)
		{
			Point temp = tc.get(i);
			
			if (op.getQuantity() == temp.getQuantity())
			{
				return i;
			}
		}
		
		return -1;
	}
	
	private void sortByQuantity()
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
			cCurveArrayList.set(index, p);
			return;
		}
		
		cCurveArrayList.add(p);
		
		sortByQuantity();
	}
	
	public void delete(Point p)
	{
		cCurveArrayList.remove(searchForIndex(p));
	}
	
	private void swap(int i1, int i2)
	{
		ArrayList tc = cCurveArrayList;
		
		Object temp = tc.set(i1, tc.get(i2));
		tc.set(i2, temp);
	}
}
