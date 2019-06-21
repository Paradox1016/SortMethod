package basicThink;

import java.util.Scanner;

//以硬币问题描述分治算法；一直对半比较，假币轻
public class fenzhi {
	//static final int MAXNUM=30;
	static int FalseCoin(int coin[],int low,int high) {
		int i,sum1,sum2,sum3;
		int re=0;sum1=sum2=sum3=0;
		if(low+1==high) {
			if(coin[low]<coin[high]) {
				re=low+1;
				return re;
			}else {
				re=high+1;
				return re;
			}
		}
		if((high-low+1)%2==0) {
			for(i=low;i<=low+(high-low)/2;i++) {
				sum1+=coin[i];
			}
			for(i=low+(high-low)/2;i<=high;i++) {
				sum2+=coin[i];
			}
			if(sum1>sum2) {
				re=FalseCoin(coin, low+(high-low)/2+1, high);
				return re;
			}else if(sum1<sum2) {
				re=FalseCoin(coin, low, low+(high-low)/2);
				return re;
			}else {
				
			}
		}else {
			for(i=low;i<=low+(high-low)/2-1;i++) {
				sum1+=coin[i];
				}
			for(i=low+(high-low)/2+1;i<=high;i++) {
				sum2+=coin[i];
			}
			sum3=coin[low+(high-low)/2];
			if(sum1>sum2) {
				re=FalseCoin(coin, low+(high-low)/2+1, high);
				return re;
			}else if(sum1<sum2){
				re=FalseCoin(coin, low, low+(high-low)/2-1);
				return re;
			}else {}
			if(sum1+sum3==sum2+sum3) {re=low+(high-low)/2+1;return re;}
		}
		
		
		
		return re;
	}
	
	public static void main(String[] args) {
		
		int i,n;
		int weizhi;
		System.out.println("分治法求解假币");
		System.out.println("硬币总数量");
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int MAXNUM=n;
		int[] coin=new int[MAXNUM];
		System.out.println("输入硬币重量");
		for(i=0;i<n;i++) {
			coin[i]=sc.nextInt();
		}
		weizhi=FalseCoin(coin, 0, n-1);
		System.out.printf("在上述%d个硬币中，第%d个是假的",MAXNUM,weizhi);
	}
}
