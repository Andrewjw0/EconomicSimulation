package economicSimulation;

import java.util.*;

/**
 * Date: Sep 2023
 * Group: Evan McNaughton, Nicholas Henson, Andrew Wang, and Jackson Amick
 * Description:
 * Producer curve is one of two curve methods that uses an array of Points.
 * Price DECREASES over the curve.
 */
public class ProducerCurve {
	
	private Point[] pCurveArray;
	
	/**
	 * Default constructor, sets points as 1 to 10
	 */
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
	
	/**
	 * Proper constructor, uses a starting point (sp)
	 * and an ending point (ep) to fill in the array
	 * Number of points is specified with numPoints
	 */
	public ProducerCurve(Point sp, Point ep, int numPoints)
	{
		pCurveArray = new Point[numPoints];
		pCurveArray[0] = sp;
		
		int    deltaQ = (int) Math.round((ep.getQuantity() - sp.getQuantity()) / (numPoints * 1.0));
		double deltaP = (ep.getPrice() - sp.getPrice()) / (numPoints - 1);
		
		for (int i = 1; i < numPoints - 1; i++)
		{
			int    q = sp.getQuantity() + deltaQ * (i);
			double p = sp.getPrice() + deltaP * (i);
			pCurveArray[i] = new Point(q, p);
		}
		pCurveArray[(pCurveArray.length-1)] = ep;
	}
	
	/**
	 * Prints the quantity and price of every point in
	 * pCurveArray in order as a String
	 */
	public String toString()
	{
		String temp = "ProducerCurve: ";
		
		for (Point p : pCurveArray)
		{
			temp = temp + p.toString() + ", ";
		} 
		return temp;
	}
	
	/**
	 * Goes through pCurveArray to check if Point op is
	 * already in the array, if so returns true
	 */
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
	
	/**
	 * Helper method that searches for the index of an identical point
	 * to p, returns -1 if there is none
	 */
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
	
	/**
	 * Helper method that searches for the index of a point with
	 * the quantity q, returns -1 if there is none
	 */
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
	
	/**
	 * Helper method that searches for the index of a point with
	 * the price p, returns -1 if there is none
	 */
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
	
	/**
	 * Helper method used by add, less specific version of
	 * search that only searches for identical quantities
	 */
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
	
	/**
	 * Bubble sorts pCurveArray from least to greatest quantity
	 */
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
	
	/**
	 * add adds Point p to pCurveArray
	 * It will not add Point p if:
	 * - p is already on the curve
	 * - p has a quantity of 0 or less
	 * - p has a price of 0 or less
	 * add also swaps point p with a point of identical
	 * quantity if it finds one, so long as they
	 * aren't identical
	 */
	public void add(Point p)
	{	
		// Checks if point is on the line, if so doesn't add
		if (search(p) == true)
		{
			System.out.println("Point is already on the curve!");
			return;
		}
		
		// Checks if quantity is 0 or less, if so doesn't add
		if (p.getQuantity() <= 0)
		{
			System.out.println("Quantity can't be 0 or less!");
			return;
		}
		
		// Checks if price is 0 or less, if so doesn't add
		if (p.getPrice() <= 0)
		{
			System.out.println("Price can't be less than or equal to 0!");
			return;
		}
		
		int index = searchMatchingQuantity(p);
		
		// swaps points of the same quantity but different prices
		if (index >= 0) 
		{
			pCurveArray[index] = p;
			return;
		}
		
		Point[] newArray = new Point[pCurveArray.length + 1];
		
		// Replaces pCurveArray with newArray
		for (int i = 0; i < pCurveArray.length; i++)
		{
			newArray[i] = pCurveArray[i];
		}
		
		newArray[newArray.length - 1] = p;
		pCurveArray = newArray;
		sortByQuantity(); // Sorts pCurveArray after adding p
	}
	
	/**
	 * Checks if point p is on the line,
	 * if so replaces pCurveArray with a newArray without it
	 */
	public void delete(Point p)
	{
		int foundIndex = searchForIndex(p);
		
		if (foundIndex == -1)
		{
			System.out.println("Point is not on the line!");
			return;
		}
		
		
		Point[] newArray = new Point[pCurveArray.length - 1];
		
		// instantiates points that were before the deleted point
		for (int i = 0; i < foundIndex; i++)
		{
			newArray[i] = pCurveArray[i];
		}
		
		// instantiates points that were after the deleted point, moved left 1
		for (int i = foundIndex; i < newArray.length; i++)
		{
			newArray[i] = pCurveArray[i + 1];
		}
		
		pCurveArray = newArray;
	}
	
	/**
	 * swap is a helper method used to switch the quantity and
	 * price of two points. Used in sortByQuantity
	 */
	private void swap(int i1, int i2)
	{
		Point tp = pCurveArray[i1];
		
		pCurveArray[i1] = pCurveArray[i2];
		pCurveArray[i2] = tp;
	}
}