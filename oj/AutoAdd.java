package test1;

import java.util.Iterator;
import java.util.TreeSet;

public class AutoAdd {
	public TreeSet ts=new TreeSet();
	public void core(TreeSet ts,int n,int num[],int maxN,int temp,int weight[]){
		for(int i=0;i<=num[n];i++){
			temp=temp+weight[n]*i;
			if(n==maxN){
				ts.add(temp);
			}
			else{
				this.core(ts, n+1, num, maxN, temp, weight);
			}
			//if(n==maxN)
			temp=temp-weight[n]*i;
		}
		
	}
	public static void main(String[] args){
		int num[]={2,3,4};
		int weight[]={50,20,10};
		AutoAdd aa=new AutoAdd();
		int temp=0;
		aa.core(aa.ts, 0, num, 2, temp, weight);
		Iterator it=aa.ts.iterator();
		while(it.hasNext()){
			System.out.println(String.valueOf(it.next()));
		}
		
	}
}
