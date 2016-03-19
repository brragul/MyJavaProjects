package sortImplementation;

public class Sorting {
public static void main(String[] args)
{
	int inscount=0,bubcount=0;
	DisplaySort ds = new DisplaySort();
	int temp=0;
	int[] i = new int[]{3,7,10,1,141,23};
	int[] bu = new int[]{3,7,10,1,141,23};

//Insertion Sort
	for (int c=0;c<i.length;c++)
	{
		for(int b=c;b>0;b--)
		{
			inscount++;

			if(i[b]<i[b-1])
			{
				temp=i[b];
				i[b]=i[b-1];
				i[b-1]=temp;
			}
		}
	}
//Bubble Sort
	for (int j=0;j<bu.length;j++)
	{
		for(int k=1;k<bu.length;k++)
		{
			bubcount++;

			if(bu[k]<bu[k-1])
			{
				temp=bu[k-1];
				bu[k-1]=bu[k];
				bu[k]=temp;
			}
		}
	}

	
	for(int k=0;k<i.length;k++){
	System.out.println("The sorted array Insertion:"+i[k]);}
	for(int k=0;k<bu.length;k++){
		System.out.println("The sorted array Bubble:"+bu[k]);}
	
	System.out.println("count of Bubble:"+bubcount+"Count of Inser "+inscount);
}
}

