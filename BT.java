package ai.lab.project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BT 
{
	int colour[];
	int a;
	int vcount;
	List<Integer>[] adj;
	
	public int getvcount()
	{
		return vcount;
	}
	
	public void addEdge(int i, int j)
	{
		adj[i].add(j);
		adj[j].add(i);
	}
	
	public void removeEdge(int i, int j)
	{
		Iterator<Integer> it1 = adj[i].iterator();
		while(it1.hasNext())
		{
			if(it1.next() == j)
			{
				it1.remove();
				break;
			}
		}
		Iterator<Integer> it2 = adj[j].iterator();
		while(it2.hasNext())
		{
			if(it2.next() == i)
			{
				it2.remove();
				break;
			}
		}
	}
	
	public boolean hasEdge(int i, int j)
	{
		return adj[i].contains(j);
	}
	
	public BT(int vcount)
	{
		this.vcount = vcount;
		adj = (List<Integer>[]) new List[vcount];
		for(int i = 0; i < vcount; i++)
		{
			adj[i] = new ArrayList<Integer>();
		}
	}
	
	public List<Integer> edge(int v)
	{
		return adj[v];
	}
	
	boolean isSafe(int v, BT bt, int colour[],int c)
	{
		for (int i = 0; i < bt.getvcount(); i++)
			if (bt.hasEdge(v,i) && c == colour[i])
				{
					return false;				
				}
		return true;
	}

	boolean graphColouringUtil(BT bt, int m, int colour[], int v)
	{
		if (v == bt.getvcount())
		{
			return true;
		}
		for (int c = 1; c <= m; c++) 
		{
			if (isSafe(v, bt, colour, c))
			{
				colour[v] = c;
				if (graphColouringUtil(bt, m, colour, v + 1))
					{
						return true;
					}
				colour[v] = 0;
			}
		}
		return false;
	}
	
	boolean graphColouring(BT bt, int m)
	{
		int V = bt.getvcount();
		colour = new int[V];
		a = m;
		for (int i = 0; i < V; i++)
		{
			colour[i] = 0;
		}
		if (!graphColouringUtil(bt, m, colour, 0)) 
		{
			return false;
		}
		printSolution(colour);
		return true;
	}
	
	public void printgraph()
	{
		for(int i = 0; i < vcount; i++)
		{
			List<Integer> edge = edge(i);
			System.out.print(i+" : ");
			for(int j = 0; j < edge.size(); j++)
			{
				System.out.print(edge.get(j)+" ");
			}
			System.out.println();
		}
	}
	
	void printSolution(int colour[])
	{
		System.out.println("The Assigned Colours with Backtracking : ");
		System.out.println("Vertex\tColour");
		for(int i = 0; i < colour.length; i++)
			{
				System.out.println("  "+i+"\t  "+colour[i]);
			}
	}
}
