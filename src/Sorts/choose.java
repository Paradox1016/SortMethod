package Sorts;
/*
 	void selectSort(int[] a){
 		int index;
 		int temp;			//交换临时变量
 		for(int i=0;i<a.length-1;i++){
 			index=i;
 			for(int j=i+1;j<a.length;j++){
 				if(a[j]<a[index]){
 					index=j;
 				}
 			}
 			//交换两个数
 			  if(index!=i){
 			 	temp=a[i];
 			 	a[i]=a[index];
 			 	a[index]=temp;
 			  }
 		}
 	}
 */


public class choose {
	static final int SIZE=10;
	public static void selectSort(int[] a) {
		int index;
 		int temp;			//交换临时变量
 		for(int i=0;i<a.length-1;i++){
 			index=i;
 			for(int j=i+1;j<a.length;j++){
 				if(a[j]<a[index]){
 					index=j;
 				}
 			}
 			//交换两个数
 			  if(index!=i){
 			 	temp=a[i];
 			 	a[i]=a[index];
 			 	a[index]=temp;
 			  }
 			  System.out.printf("第%d步排序结果:",i);
 			  for(int h=0;h<a.length;h++) {
 				  System.out.print(" "+a[h]);
 			  }
 			  System.out.print("\n");
 		}
	}
	public static void main(String[] args) {
		int [] shuzu=new int[SIZE];
		int i;
		for(i=0;i<SIZE;i++) {
			shuzu[i]=(int)(100+Math.random()*(100+1));//初始化数组
		}
		System.out.print("排序前数组：");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.print("\n");
		selectSort(shuzu);
		System.out.print("排序后数组");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.print("\n");
	}
}
