package sortImplementation;

public class Test {

	public static void main(String[] args) {
		int temp=0,iiicount=0;
		int[] iii = new int[]{9,8,7,6,5,4,3,2,1};
		int[] sort= new int[iii.length];

		//selection Sort	3,7,10,1,141,23
		int min=-1,ks;
		for(int j=0;j<iii.length-1;j++){
			min=j;
			for( ks=j+1;ks<iii.length;ks++)
			{
				if(iii[j]>iii[ks])
				{
					min=ks;
					
				}
			}
			if(j!=min){
			temp=iii[j];
			iii[j]=iii[min];
			iii[min]=temp;}
			
		}
	}

}
