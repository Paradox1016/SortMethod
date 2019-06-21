package Sorts;
//归并排序，将多个有序数据表合并成一个有序数据表。(若参与合并的只有两个有序表，称为二路归并)
public class MergeSort {
	static final int SIZE=15;
	static void mergeOne(int a[],int b[],int n,int len) {//完成一遍合并的函数
		int i,j,k,s,e;
		s=0;
		while(s+len<n) {
			e=s+2*len-1;
			if(e>=n) {    						//最后一段可能少于len个结点
				e=n-1;
			}
			//相邻有序段合并
			k=s;
			i=s;
			j=s+len;
			while(i<s+len&&j<=e) {				//如果两个有序表都未结束，循环比较
				if(a[i]<=a[j]){					//如果较小的元素复制到数组b中
					b[k++]=a[i++];					
				}else {
					b[k++]=a[j++];
				}				
			}
			while(i<s+len) {					//未合并的部分复制到数组b
				b[k++]=a[i++];
			}
			while(j<=e) {
				b[k++]=a[j++];					//未合并的部分复制到数组b
			}
			s=e+1;
		}
		if(s<n) {
			for(;s<n;s++) {
				b[s]=a[s];
			}
		}
	}
	
	static void mergeSort(int a[],int n) {
		//归并排序
		int h,count,len,f;
		count=0;								//排序步骤
		len=1;									//有序序列长度
		f=0;									//变量f作为标志
		
		int[] p=new int[n];
		while(len<n) {
			if(f==1) {							//交替在A和p之间合并
				mergeOne(p,a,n,len);			//P合并到a
			}else {
				mergeOne(a, p, n, len);
			}
			len*=2;								//增加有序序列长度
			f=1-f;								//使f值在0和1之间变化
			count++;
			System.out.printf("第%d步排序结果:",count);
			for(h=0;h<SIZE;h++) {
				System.out.printf(" "+a[h]);
			}
			System.out.print("\n");
			
		}
		if(f==1) {								//将内存p中的数据复制回数组a
			for(h=0;h<n;h++) {
				a[h]=p[h];
			}
		}		
			
		}
	public static void main(String[] args) {
		int[] shuzu=new int[SIZE];
		int i;
		for(i=0;i<SIZE;i++) {
			shuzu[i]=(int)(100+Math.random()*(100+1));
		}
		System.out.print("排序前数组:\n");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.print("\n");
		mergeSort(shuzu, SIZE);
		System.out.print("排序后的数组 :\n");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		
		System.out.print("\n");
	}
}
