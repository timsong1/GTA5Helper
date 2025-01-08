package application;

public class Time {
	int minute;
	int second;
	
	public Time(int minute , int second)
	{
		this.minute = minute;
		this.second = second;
	}
	
	public String getCurrentTime()
	{
		if(minute >= 10)
			if(second >= 10)
				return minute+":"+second;
			else
				return minute+":0"+second;
		else
			if(second >= 10)
				return "0"+minute+":"+second;
			else 
				return "0"+minute+":0"+second;
	}
	public void oneSecondPassed()
	{
		
		if(second == 0)
		{
			if(minute == 0)
			{
				
			}
			else
			{
				minute --;
				second = 59;
			}
		}
		else
			second--;
	}
}
