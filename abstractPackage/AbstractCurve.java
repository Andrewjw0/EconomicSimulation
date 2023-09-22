package abstractPackage;

import java.util.*;

public abstract class AbstractCurve implements CurveInterface 
{
	private ArrayList<Point> curveArrayList;
	
	/**
	 * Proper constructor, uses a starting point (sp)
	 * and an ending point (ep) to fill in the ArrayList.
	 * Number of points is specified with numPoints.
	 */
	
	public AbstractCurve(Point sp, Point ep, int numPoints) 
	{
		if (sp.getQuantity() == ep.getQuantity()) 
		{
			curveArrayList = new ArrayList<Point>(1);
			curveArrayList.add(ep);
			return;
		}
		
		curveArrayList = new ArrayList<Point>(numPoints + 1);
		curveArrayList.add(sp);
		
		int    deltaQ = (int) Math.round((ep.getQuantity() - sp.getQuantity()) / (numPoints * 1.0));
		double deltaP = (ep.getPrice() - sp.getPrice()) / (numPoints - 1);
		
		for (int i = 1; i < numPoints - 1; i++)
		{
			int    q = sp.getQuantity() + deltaQ * (i);
			double p = sp.getPrice() + deltaP * (i);
			curveArrayList.add(new Point(q, p));
		}
		
		curveArrayList.add(ep);
	}

	/**
	 * Returns curveArrayList because 
	 * we're not allowed to make it protected.
	 */
	public ArrayList getCurveArrayList()
	{
		return curveArrayList;
	}
		
	public String toString()
	{
		String temp = "Curve: ";
		
		for (Point p : curveArrayList)
		{
			temp = temp + p.toString() + ", ";
		} 
		
		return temp;
	}
	
	/**
	 * Searches for a Point with quantity and price equal to op on the curve.
	 * If there is one, returns true
	 */
	public boolean search(Point op)
	{
		for (Point p : curveArrayList)
		{
			if (p.equals(op))
			{
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Searches for a Point with quantity and price equal to op on the curve.
	 * If there is one, return the index. Otherwise return -1 (impossible index).
	 */
	private int searchForIndex(Point op)
	{
		for (int i = 0; i < curveArrayList.size(); i++)
		{
			if (curveArrayList.get(i).equals(op))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Searches for a Point with quantity and price equal to op on the curve.
	 * If there is one, return the index. Otherwise return -1 (impossible index).
	 */
	private int searchMatchingQuantity(Point op)
	{
		ArrayList<Point> tc = curveArrayList;
		
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
	
	/**
	 * Sorts curveArrayList by quantity.
	 */
	public abstract void sort();

	/**
	 * Adds Point p to the curve.
	 * Doesn't add p if:
	 * - p is on the curve
	 * - p has a quantity/price of 0 or less
	 * - p has an identical quantity to one of the points (SWAPS)
	 * If all these checks are cleared, adds p and sorts.
	 */
	public void add(Point p)
	{
		// Checks if p is on the line, if so doesn't add
		if (search(p) == true)
		{
			return;
		}
		
		// Checks if p has a quantity below or equal to 0, if so doesn't add
		if (p.getQuantity() <= 0)
		{
			return;
		}
		
		// Checks if p has a price below or equal to 0, if so doesn't add
		if (p.getPrice() <= 0)
		{
			return;
		}
		
		// Checks if p has a matching quantity on the line, if so swaps instead
		int index = searchMatchingQuantity(p);
		
		if (index >= 0) 
		{
			curveArrayList.set(index, p);
			return;
		}
		
		curveArrayList.add(p);
		
		sort(); // Sorts to keep points in order
	}
	
	/**
	 * Deletes p if it's on the line.
	 */
	public void delete(Point p)
	{
		if (search(p))
		{
			curveArrayList.remove(searchForIndex(p));
		}
	}
	
	/**
	 * Swaps i1 and i2's positions, helper method.
	 */
	public void swap(int i1, int i2)
	{
		ArrayList tc = curveArrayList;
		
		Object temp = tc.set(i1, tc.get(i2));
		tc.set(i2, temp);
	}
}
