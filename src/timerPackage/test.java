package timerPackage;

import java.util.Timer;
import java.util.TimerTask;



public class test {
	static Timer timer;
	static int second =5;
	static int settime=0;
public static void main(String[] args){
	 timer = new Timer();
	timer.scheduleAtFixedRate(new TimerTask() {
		public void run(){
			setTimer();
		}
	},1000,1000);
	System.out.println("Your Food is Ready");
}
private static void setTimer() {
	--second;
	if(second==0 && settime==0) {
		timer.cancel();}
System.out.println(settime+" "+second);
if(second==0)
{
	settime--;
	second=59;
}

}
}

