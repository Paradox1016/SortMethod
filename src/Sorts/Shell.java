package Sorts;
//希尔(插入)排序，缩小增量排序
/*
 * 1.将有n个元素的数组分成n/2个数字序列，第1个数据和第n/2+1个数据为一对，....
 * 2.一次循环使每一个序列对排好顺序
 * 3.然后，再变为n/4序列，再次排序
 * 4.不断重复上述过程，随着序列减少最后变为一个，最终完成排序
 * */
public class Shell {
	static final int SIZE=16;
	static void shellSort(int[] a) {
		int i,j,h;
		int r,temp;
		int x=0;
		for(r=a.length/2;r>=1;r/=2) {//分组排序
			for(i=r;i<a.length;i++) {
			temp=a[i];
			j=i-r;
			while(j>=0&&temp<a[j]) {
				a[j+r]=a[j];
				j-=r;
			}
			a[j+r]=temp;
			}
			x++;
			System.out.printf("第%d步排序结果",x);
			for(h=0;h<a.length;h++) {
				System.out.print(" "+a[h]);
				
			}
			System.out.print("\n");
			
		}
	}
	public static void main(String[] args) {
		int[] shuzu=new int[SIZE];
		int i;
		for(i=0;i<SIZE;i++) {
			shuzu[i]=(int)(Math.random()*(30+1));
		}
		System.out.print("第0步排序结果");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
			
		}
		System.out.print("\n");
		shellSort(shuzu);
		System.out.print("排序后的数组：\n");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
			
		}
		System.out.print("\n");
	}
}
