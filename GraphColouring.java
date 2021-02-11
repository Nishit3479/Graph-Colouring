package ai.lab.project;

import java.util.*;

public class GraphColouring 
{
	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Choose Option :\n1.Graph Colouring with Backtracking\n2.Graph Colouring without Backtracking");
		int a = in.nextInt();
		if(a==1)
		{
			BT bt = new BT(4);
			bt.addEdge(0, 1);
			bt.addEdge(0, 2);
			bt.addEdge(0, 3);
			bt.addEdge(1, 2);
			bt.addEdge(2, 3);
			System.out.println("The Graph : ");
			bt.printgraph();
		    bt.graphColouring(bt, 3);
		}
		else if(a==2)
		{
			NBT nbt = new NBT(4);
			nbt.addEdge(0, 1);
			nbt.addEdge(0, 2);
			nbt.addEdge(0, 3);
			nbt.addEdge(1, 2);
			nbt.addEdge(2, 3);
			System.out.println("The Graph : ");
			nbt.printgraph();
			nbt.graphColouring(nbt);
		}
		else
		{
			System.out.println("Invalid Choice...!!");
		}
	}
}
