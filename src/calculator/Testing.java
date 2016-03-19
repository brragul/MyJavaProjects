package calculator;


public abstract class Testing {

	public static void main(String[] args) {
		/*int countac=2;
		String s="5+3-4";
		int start=0,end=0;
		//System.out.println(s.indexOf("+",2));
		double[] d= new double[countac+1];
		for(int i=0;i<countac;i++){
			end=s.indexOf("+", start);
			d[i]=Double.parseDouble(s.substring(start, end));
			start=end+1;
		}
		d[countac]=Double.parseDouble(s.substring(start,s.length() ));
		System.out.println(d[0]+" "+d[1]+" "+d[2]);*/
		
		String file="E:/Compressed/a.zip";
		
		String outfolder =file.substring(0, file.lastIndexOf('/'));
		String filename= outfolder+"/"+"a.txt";
		System.out.println(filename);
	}

}
