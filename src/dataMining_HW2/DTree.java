package dataMining_HW2;

public class DTree {

	private treeNode root;
	private int size;

	static int[][] trainData={{0,0,1},{1,0,0},{0,0,1},{1,1,0},{1,0,0},{0,0,0},{1,1,1},{0,0,1},{0,0,1},{1,0,0}};
	static int[][] testData={{1,0,0},{1,0,1},{1,0,0},{0,0,1},{1,1,0}};
	
	public DTree()
	{
		root=null;
		size=0;
	}
	
	public double Hy(int[][] data,int position){
		double Pt=Tcounter(data,position)/data.length;
		double Pf=Fcounter(data,position)/data.length;
		
		return -1*Pt*Math.log(Pt)-(Pf*Math.log(Pf));	
	}
	
	public int Tcounter(int[][] countData,int p)
	{
		int count=0;
		for(int i=0;i<countData.length;i++)
		{
			if(countData[i][p]==1)
			{
				count++;
			}
		}
		return count;
	}
	
	public int Fcounter(int[][] countData,int p)
	{
		int count=Tcounter(countData,p);
		return countData.length-count;
	}
}
