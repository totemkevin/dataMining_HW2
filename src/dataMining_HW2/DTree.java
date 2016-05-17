package dataMining_HW2;

public class DTree {

	private static treeNode root;
	private int size;
	private static int Ypoint=0;

	static int[][] trainData={{0,0,1},{1,0,0},{0,0,1},{1,1,0},{1,0,0},{0,0,0},{1,1,1},{0,0,1},{0,0,1},{1,0,0}};
	static int[][] testData={{1,0,0},{1,0,1},{1,0,0},{0,0,1},{1,1,0}};
	public static treeNode DT;
	public static void DTree()
	{
		int data=entropy(trainData);
		
		DT=new treeNode(data,root,null,null);
		
		creatDTree(trainData,DT);
	}
	public static void creatDTree(int[][] data,treeNode DT)
	{
		int cutPoint=entropy(data);
		System.out.print(cutPoint+"\n");
		DT.setData(cutPoint);
		
		
		int[][] cutDataT;
		int[][] cutDataF;
		int countT=0;
		int countF=0;
		
		for(int i=0;i<data.length;i++)
		{
			if(data[i][cutPoint]==1)
			{
				countT++;
			}
			else
			{
				countF++;
			}
				
		}
		cutDataT=new int[countT][];
		cutDataF=new int[countF][];
		countT=0;
		countF=0;
		
		for(int i=0;i<data.length;i++)
		{
			if(data[i][cutPoint]==1)
			{
				cutDataT[countT]=data[i];
				countT++;
			}
			else
			{
				cutDataF[countF]=data[i];
				countF++;
			}	
		}

		
		

		if(!endCheck(cutDataT))
		{
			treeNode leftNode=new treeNode(0,DT,null,null);
			DT.setLeft(leftNode);
			creatDTree(cutDataT,leftNode);
		}
		
		if(!endCheck(cutDataF))
		{
			treeNode rightNode=new treeNode(0,DT,null,null);
			DT.setRight(rightNode);
			creatDTree(cutDataT,rightNode);
		}
		
	}
	
	public static boolean endCheck(int[][] data)
	{
		boolean bool=true;
		int checkData=data[0][Ypoint];
		for(int i=0;i<data.length;i++)
		{
			if(data[i][Ypoint]!=checkData)
			{
				bool=false;
			}
		}
		return bool;
	}
	
	public static int entropy(int[][] data)
	{
		int bestDPoint=-2;
		
		for(int i=1;i<data[0].length;i++)
		{
			double ig=IG(data,i);
			if(ig>bestDPoint)
			{
				bestDPoint=i;
			}
		}
		return bestDPoint;
		
	}
	
	public static double IG(int[][] data,int p)
	{
		return H(data)-Hyx(data,p);
	}
	
	public static double H(int[][] data){
		double Pt=Tcounter(data,Ypoint);
		double Pf=1-Pt;
		

		double output= -1*Pt*Math.log(Pt)-(Pf*Math.log(Pf));
		return output;	
		
	}
	
	public static double Hyx(int[][] data,int p)
	{
		double output=0;
		double pxt=Tcounter(data,p);
		double pxf=1-pxt;
		double xtyt=YtXtcounter(data,p);
		double xtyf=1-xtyt;
		double xfyf=YfXfcounter(data,p);
		double xfyt=1-xfyf;
		
		//System.out.print(pxt+"\n");
		//System.out.print(pxf+"\n");
		//System.out.print(xtyt+"\n");
		//System.out.print(xtyf+"\n");
		//System.out.print(xfyf+"\n");
		//System.out.print(xfyt+"\n");
		
		
		output=-1*pxt*(xtyt*Math.log(xtyt)+xtyf*Math.log(xtyf))-(pxf*(xfyt*Math.log(xfyt)+xfyf*Math.log(xfyf)));
		System.out.print(output+"\n");
		return output;
	}
	
	public static double Tcounter(int[][] data,int p)
	{
		int count=0;
		for(int i=0;i<data.length;i++)
		{
			if(data[i][p]==1)
			{
				count++;
			}
		}
		double output=(double) count/data.length;
		return output;
	}
	
	public static double YtXtcounter(int[][] data,int p)
	{
		int count=0;
		int xlength=0;
		
		for(int i=0;i<data.length;i++)
		{
			if(data[i][p]==1 )
			{
				xlength++;
				if(data[i][Ypoint]==1)
				{
					count++;
				}
			}
		}
		double output=(double) count/xlength;
		return output;
	}
	public static double YfXfcounter(int[][] data,int p)
	{
		int count=0;
		int xlength=0;
		
		for(int i=0;i<data.length;i++)
		{
			if(data[i][p]==0 )
			{
				xlength++;
				if(data[i][Ypoint]==0)
				{
					count++;
				}
			}
		}
		double output=(double) count/xlength;
		return output;
	}
}
