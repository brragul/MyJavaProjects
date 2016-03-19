package midtermExam;

public class GetEleCoord {
	static int[] co = new int[4];
	public static int[] getCoordinate(int liftno,int curpos){
		co[2]=190;
		co[3]=113;
		if(liftno==1)
		{
			co[0]=12;
		}else if(liftno==2){
			co[0]=232;
		}
		else if(liftno==3){
			co[0]=440;
		}
		switch(curpos){
		case 1:
			co[1]=517;
			break;
		case 2:
			co[1]=391;
			break;
		case 3:
			co[1]=265;
			break;
		case 4:
			co[1]=139;
			break;
		case 5:
			co[1]=13;
			break;
		}
		
		return co;
		
	}
}
