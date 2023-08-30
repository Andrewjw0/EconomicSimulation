package economicSimulation;

import java.util.*;

public class ConsumerCurve 
{
	private ArrayList<Point> myCurveArrayList;
	
	public ConsumerCurve()
	{
		// instantiate ArrayList of Points
		myCurveArrayList = new ArrayList<Point>(); // default size is 10
		for(int i=0; i<10; i++)
		{
			int q = i+1;
			double p = 10-(i+1);
			myCurveArrayList.add(new Point(q,p));
		}
		Point p1 = new Point(1,10.0);
		myCurveArrayList.add(p1);
	}
	
	public String toString()
	{
		String temp = "ConsumerCurve: ";
		for (Point p : myCurveArrayList)
		{
			temp = temp + p.toString() + ", ";
		}
		return temp;
	}
}