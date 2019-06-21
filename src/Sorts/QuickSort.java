package Sorts;
//快速排序，通过多次比较和交换实现排序
/*
 * 1.首先设定一个分界值，该值将数组分为左右两部分，分值
 * 2.左边和右边的数据可以独立排序
 * 3.重复过程、递归定义
 * 
 * */
public class QuickSort {
	static final int SIZE=18;
	static void quickSort(int[] arr,int left,int right) {
		int f,t;
		int rtemp,ltemp;
		ltemp=left;
		rtemp=right;
		f=arr[(left+right)/2];
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
			quickSort(arr, left, ltemp-1);
		}
		if(ltemp<right) {
			quickSort(arr, rtemp+1, right);
		}
	}
	
	public static void main(String[] args) {
		int[] shuzu=new int[SIZE];
		int i;
		
		for(i=0;i<SIZE;i++) {
			shuzu[i]=(int)(100+Math.random()*(100+1));
		}
		System.out.printf("排序前的数组为：\n");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.print("\n");
		quickSort(shuzu, 0, SIZE-1);
		System.out.print("排序后的数组:");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.print("\n");
	}
	
	
}

