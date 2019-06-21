package Sorts;
//插入排序
public class insertion_Sort {
	static final int SIZE=10;
	static void insertSort(int[] a) {
		int i,j,t,h;
		for(i=1;i<a.length;i++) {
			t=a[i];
			j=i-1;
			while(j>=0&&t<a[j]) {
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=t;
			System.out.printf("第%d步排序的结果:",i);
			for(h=0;h<a.length;h++) {
				System.out.print(" "+a[h]);
				
			}System.out.print("\n");
		}
	}
		public static void main(String[] args) {
			int shuzu[]=new int[SIZE];
			int i;
			for(i=0;i<SIZE;i++) {
				shuzu[i]=(int)(100*Math.random()*(100+1));
			}
			System.out.print("排序前的数组为：\n");
			for(i=0;i<SIZE;i++) {
				System.out.print(shuzu[i]+" ");
			}
			System.out.print("\n");
			insertSort(shuzu);
			System.out.print("排序后的数组:");
			for(i=0;i<SIZE;i++) {
				System.out.printf(shuzu[i]+" ");
			}
			System.out.print("\n");
		}
		
	
}
