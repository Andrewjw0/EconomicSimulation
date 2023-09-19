package abstractPackage;

import java.util.*;

public abstract class AbstractCurve implements CurveInterface 
{
	private ArrayList<Point> curveArrayList;
	
	public AbstractCurve(Point sp, Point ep, int numPoints) 
	{
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
	 * goes through curveArrayList searching Point op,
	 * returns true if it's found
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
	 * searches for point op, returns the index where it's found
	 * returns -1 (impossible index) if not
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
	 * Less specific search() method that
	 * solely looks for a matching quantity
	 * returns the index if found, -1 if not
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
	 * Sorts curveArrayList by quantity
	 */
	public abstract void sort();

	/**
	 * Adds Point p to curveArrayList.
	 * Does not add if:
	 * - Point is on the line
	 * - Point has a quantity of 0 or less
	 * - Point has a price of 0 or less
	 * If p is not on the line but has a matching quantity
	 * the matching point is swapped, otherwise adds p
	 * to the line
	 */
	public void add(Point p)
	{
		// Checks if p is on the line, if so doesn't add
		if (search(p) == true)
		{
			System.out.println("Point is already on the curve!");
			return;
		}
		
		// Checks if p has a quantity below or equal to 0, if so doesn't add
		if (p.getQuantity() <= 0)
		{
			System.out.println("Quantity can't be 0 or less!");
			return;
		}
		
		// Checks if p has a price below or equal to 0, if so doesn't add
		if (p.getPrice() <= 0)
		{
			System.out.println("Price can't be less than or equal to 0!");
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
	 * swaps i1 and i2's positions, helper method
	 */
	public void swap(int i1, int i2)
	{
		ArrayList tc = curveArrayList;
		
		Object temp = tc.set(i1, tc.get(i2));
		tc.set(i2, temp);
	}
}
