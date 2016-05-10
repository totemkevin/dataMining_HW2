package dataMining_HW2;

public class treeNode {
	private int[] data;
	private int position;
	private treeNode parent;
	private treeNode right;
	private treeNode left;

	public treeNode(int[] data,treeNode parent,treeNode left,treeNode right)
	{
		setData(data);
		setParent(parent);
		setLeft(left);
		setRight(right);
	}
	
	
	public void setData(int[] setdata) {
		// TODO Auto-generated method stub
		data=setdata;
	}
	public void setRight(treeNode setright) {
		// TODO Auto-generated method stub
		right=setright;
	}

	public void setLeft(treeNode setleft) {
		// TODO Auto-generated method stub
		left=setleft;
	}

	public void setParent(treeNode setparent) {
		// TODO Auto-generated method stub
		parent=setparent;
	}

	
	public int[] getData() {
		// TODO Auto-generated method stub
		return data;
	}
	public treeNode getRight() {
		return right;
		// TODO Auto-generated method stub
	}
	public treeNode getLeft() {
		return left;
		// TODO Auto-generated method stub
	}
	public treeNode getParent() {
		return parent;
		// TODO Auto-generated method stub
	}


	public int left(int position)
	{
		return position;
	}
	public int right(int position)
	{
		return position;
	}
	public boolean hasleft(int position)
	{
		return true;
	}
	public boolean hasright(int position)
	{
		return true;
	}
}
