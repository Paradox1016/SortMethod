package Search;
import java.util.*;
//二分查找
/*要求数据序列呈线性结构
 * 
 * 
 * 
 * */
public class Half_divided {
	static final int N=15;
	static void quickSort(int[] arr,int left,int right) {     //快速排序
		int f,t;
		int rtemp,ltemp;
		ltemp=left;
		rtemp=right;
		f=arr[(left+right)/2];								  //确定分界值
		while(ltemp<rtemp) {
			while(arr[ltemp]<f) {
				++ltemp;
			}
			while(arr[rtemp]>f) {
				--rtemp;
			}
			if(ltemp<=rtemp) {
				t=arr[ltemp];
				arr[ltemp]=arr[rtemp];
				arr[rtemp]=t;
				--rtemp;
				++ltemp;
			}
		}
		if(ltemp==rtemp) {
			ltemp++;
		}
		if(left<rtemp) {
			quickSort(arr, left, ltemp-1);             		//递归调用
		}
		if(ltemp<right) {
			quickSort(arr, rtemp+1, right); 				//递归调用
		}
	}
	
	static int searchFun(int a[],int n,int x) {				//折半查找
		int mid,low,high;
		low=0;
		high=n-1;
		while(low<=high) {
			mid=(low+high)/2;
			if(a[mid]==x) {
				return mid;
			}else if(a[mid]>x) {
				high=mid-1;
			}else {
				low=mid+1;
			}
			
		}
		return -1;
	}
	public static void main(String[] args) {
		int shuzu[]=new int[N];
		int x,n,i;
		for(i=0;i<N;i++) {
			shuzu[i]=(int)(100+Math.random()*(100+1));    //产生数组
		}
		System.out.print("二分查找算法演示！\n");
		System.out.print("排序前数据排列\n");
		for(i=0;i<N;i++) {
			System.out.print(" "+shuzu[i]);
		}
		System.out.print("\n");
		quickSort(shuzu, 0, N-1);
		System.out.print("排序后数据序列:\n");
		for(i=0;i<N;i++) {
			System.out.print(" "+shuzu[i]);
		}
		System.out.print("\n");
		System.out.print("输入要查找的数:");
		Scanner sc=new Scanner(System.in);
		x=sc.nextInt();
		n=searchFun(shuzu, N, x);
		if(n<0) {
			System.out.println("没找到数据:"+x);
		}else {
			System.out.println("数据:"+x+"位于数组 的第"+(n+1)+"个元素处。");
		}
	}
}
