package Graph_tu;

import java.util.Scanner;


class GraphMatrix{//准备数据，图结构
	static final int MaxNum=20;  
	static final int MaxValue=65535;
	char[] Vertex=new char[MaxNum];//保存顶点信息
	int Gtype; //图的类型 0无向图 1有向图
	int VertexNum; //顶点数量
	int EdgeNum; //边的数量
	int[][] EdgeWeight=new int[MaxNum][MaxNum];
	int[] isTrav=new int[MaxNum];
	
}
public class P2_6{
	static Scanner input=new Scanner(System.in);
	static void CreateGraph(GraphMatrix GM) {   //创建邻接矩阵图
		int i,j,k;
		int weight;					//权
		char EstartV,EendV;			//边的起始顶点
		
		System.out.println("输入图中各顶点信息");
		for(i=0;i<GM.VertexNum;i++) {
			System.out.printf("第%d个顶点:",i+1);
			GM.Vertex[i]=(input.next().toCharArray())[0];//保存到各顶点数组元素中
			}
		System.out.println("输入构成各边的顶点及权值:\n");
		for(k=0;k<GM.EdgeNum;k++) {
			System.out.printf("第%d条边:",k+1);
			EstartV=input.next().charAt(0);
			EendV=input.next().charAt(0);
			weight=input.nextInt();
			for(i=0;EstartV!=GM.Vertex[i];i++);//在已有顶点中查找开始点
			for(j=0;EendV!=GM.Vertex[j];j++);//在已有顶点中查找终结点
			GM.EdgeWeight[i][j]=weight;      //对应位置保存权值，表示有一条边
			if(GM.Gtype==0) {
				GM.EdgeWeight[j][i]=weight;
			}
		}
		
	}
	static void ClearGraph(GraphMatrix GM) {
		int i,j;
		for(i=0;i<GM.VertexNum;i++) //清空矩阵
		{
			for(j=0;j<GM.VertexNum;j++) {
				GM.EdgeWeight[i][j]=GraphMatrix.MaxValue;//设置矩阵个元素的值为MaxValue
			}
		}
	}
	
	static void OutGraph(GraphMatrix GM) {//输出邻接矩阵
		int i,j;
		for(j=0;j<GM.VertexNum;j++) {
			System.out.printf("\t%c",GM.Vertex[j]);//在第一行输出顶点信息
		}
		System.out.printf("\n");
		for(i=0;i<GM.VertexNum;i++) {
			System.out.printf("%c",GM.Vertex[i]);
			for(j=0;j<GM.VertexNum;j++) {
			if(GM.EdgeWeight[i][j]==GraphMatrix.MaxValue)
			{System.out.printf("\tZ");}
			else {System.out.printf("\t%d",GM.EdgeWeight[i][j]);}//输出边的权值
			
		}
		System.out.printf("\n");
	}
	}
	
	static void DeepTraOne(GraphMatrix GM,int n) {
		//从第n个节点开始，深度遍历图
		int i;
		GM.isTrav[n]=1;
		System.out.printf("->%c",GM.Vertex[n]);
		
		//增加处理结点的操作
		for(i=0;i<GM.VertexNum;i++) {
			if(GM.EdgeWeight[n][i]!=GraphMatrix.MaxValue&&GM.isTrav[n]==0) {
				DeepTraOne(GM, i);//递归进行遍历
			}
		}
		
	}
	static void DeepTraGraph(GraphMatrix GM) {//深度优先遍历
		int i;
		for(i=0;i<GM.VertexNum;i++) {
			GM.isTrav[i]=0;
		}
		System.out.printf("深度优先遍历结点：");
		for(i=0;i<GM.VertexNum;i++) {
			if(GM.isTrav[i]==0) //若该点没有遍历
			{DeepTraOne(GM, i);}
		}
		System.out.printf("\n");
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

			GraphMatrix GM=new GraphMatrix();
			System.out.printf("输入生成图的类型:");
			GM.Gtype=input.nextInt();
			System.out.printf("输入图的顶点的数量:");
			GM.VertexNum=input.nextInt();
			System.out.printf("输入图的边的数量:");
			GM.EdgeNum=input.nextInt();
			ClearGraph(GM);
			CreateGraph(GM);
			System.out.printf("该图的邻接矩阵数据如下:\n");
			OutGraph(GM);
			DeepTraGraph(GM);
			
			
	}
}