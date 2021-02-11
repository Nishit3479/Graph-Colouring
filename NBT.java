package ai.lab.project;

import java.util.*;

public class NBT
{
	int vcount;
	List<Integer>[] adj;
	
	public int getvCount()
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
	
	public NBT(int vcount)
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
	
	public static void graphColouring(NBT nbt)
	{
		int V = nbt.getvCount();
		int colours[] = new int[V];
		Arrays.fill(colours, -1);
		colours[0] = 0;
		boolean available[] = new boolean[V];
		Arrays.fill(available, true);
		for(int k = 1; k < V; k++)
		{
			Iterator<Integer> it = nbt.edge(k).iterator();
			while(it.hasNext())
			{
				int i = it.next();
				if(colours[i] != -1)
				{
					available[colours[i]] = false;
				}
			}
			int c;
			for(c = 0; c < V; c++)
			{
				if(available[c])
				{
					break;
				}
			}
			colours[k] = c;
			Arrays.fill(available, true);
		}
		printcol(colours);
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
	
	public static void printcol(int []colours)
	{
		System.out.println("The Assigned Colours without Backtracking : ");
		System.out.println("Vertex\tColour");
		for(int i = 0; i < colours.length; i++)
		{
			System.out.println("  "+i+"\t  "+(colours[i]+1));
		}
	}
}