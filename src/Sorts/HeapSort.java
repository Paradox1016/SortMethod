package Sorts;
//堆，准确的说是一种完全二叉树
/*
 * 完整的堆排序需要经过两个反复的步骤：构造堆结构和堆排序输出
 * a.构造堆结构是把原始的无序数据按照对结构的定义进行调整。首先，需要将原始的无序数据放置到一个完全二叉树的各个结点中；
 * b.然后，由完全二叉树的下层向上层逐层对父子结点数据进行比较，使父节点的数据大于子结点的数据。 这里需要
 * 使用"筛"运算进行结点数据的调整，直到所有结点最后满足堆结构的条件为止。筛运算主要针对非叶结点进行调整。
 * 
 * eg：对于一个非叶结点Ai，假定Ai的左子树和右子树均已进行筛运算，即其左右子树均已构成堆结构。对Ai进行筛运算，操作：
 * 1.比较Ai的左右子树的最大值，将最大值放在Aj中，
 * 2.将Ai和Aj的数据进行比较，若Ai大于等于Aj，表示以Ai为根的子树已经完成堆结构。终结筛运算。
 * 3.若Ai小于Aj，将Ai和Aj互换位置。
 * 4.经过第3步，有可能破坏以Ai为根的堆，因为此时Ai的值为原来的Aj。下面以Aj为根重复前面步骤，直到满足堆结构定义。
 * 
 * 完成对结构之后，按照堆排序进行输出，每次输出将剩下的数据构造堆结构。
 * 
 * */
public class HeapSort {
	static final int SIZE=10;
	static void heapSort(int a[],int n) {
		int i,j,h,k;
		int t;
		for(i=n/2-1;i>=0;i--) {    //将a[0,n-1]建成大根堆
			while(2*i+1<n) {       //第i个结点有右子树
				j=2*i+1;
				if((j+1)<n) {
					if(a[j]<a[j+1])     //右左子树小于右子树，则需要比较右子树
						j++;		    //序号加1，指向右子树
				}
				if(a[i]<a[j])			//比较i与j为序号的数据
				{
					t=a[i];				//交换数据
					a[i]=a[j];
					a[j]=t;
					i=j;				//堆被破坏，需要重新调整
				}
				else {					//比较左右子结点均大则堆未破坏，不需要再调整
					break;
				}
			}
		}
		System.out.print("原数据构成的堆:");
		for(h=0;h<n;h++) {
			System.out.print(" "+a[h]);       //输出
		}
		System.out.print("\n");
		
		for(i=n-1;i>0;i--) {
			t=a[0];
			a[0]=a[i];
			a[i]=t;
			k=0;
			while(2*k+1<i) {
				j=2*k+1;
				if((j+1)<i) {
					if(a[j]<a[j+1]) {         //右左子树小于右子树需要比较右子树
						j++;				  //序号加1，指向右子树
					}
				}
				if(a[k]<a[j]) {     		  //比较i与j为序号的数据
					t=a[k];					  //交换数据
					a[k]=a[j];
					a[j]=t;
					k=j;
				}else {      				  //比较左右子节点均大则堆未被破坏，不需要在调整
					break;
				}
			}
			System.out.printf("第%d步排序结果",(n-i));			//输出每步排序的结果
			for(h=0;h<n;h++) {
				System.out.print(" "+a[h]);
			}
			System.out.print("\n");
		}
	}
	
	public  static void main(String[] args) {
		int[] shuzu=new int[SIZE];
		int i;
		for(i=0;i<SIZE;i++) {
			shuzu[i]=(int)(100+Math.random()*(100+1));     //初始化数据
		}
		System.out.print("\n");
		heapSort(shuzu, SIZE);
		System.out.print("排序后的数组:\n");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
			
		}
		System.out.print("\n");
	}
}
