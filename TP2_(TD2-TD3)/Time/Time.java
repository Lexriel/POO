import java.lang.Math;

public class Time{

    // Attributs de la classe Time
    private int ms;
    private int sec;
    private int min;
    private int hours, days;

    // Constructeurs de la classe Time
    public Time(){
	this.ms = 0;
	this.sec = 0;
	this.min = 0;
	this.hours = 0;
	this.days = 0;
    }
    public Time(int days, int hours, int min, int sec, int ms){
	this();
	this.addMs(ms);
	this.addSec(sec);
	this.addMin(min);
	this.addHours(hours);
	this.addDays(days);
    }

    public Time(long begin, long end){
	if (end < begin){
	    long tmp = end;
	    end = begin;
	    begin = tmp;
	}
	long val = end - begin;
	this.ms= (int) (val % 1000);
	val /= 1000;
	this.sec = (int) (val % 60);
	val /= 60;
	this.min = (int) (val % 60);
	val /= 60;
	this.hours = (int) (val % 24);
	val /= 24;
	this.days = (int) val;
    }

    // Méthodes de la classe Time
    public void addMs(int val){
	this.ms += val;
    }
    public void addSec(int val){
	this.sec += val;
    }
    public void addMin(int val){
	this.min += val;
    }
    public void addHours(int val){
	this.hours += val;
    }
    public void addDays(int val){
	this.days += val;
    }

    public Time addTime(Time T){
	Time res = new Time(this.days, this.hours, this.min, this.sec, this.ms);
	res.addMs(T.ms);
	if (res.ms >= 1000){
	    res.addMs(-1000);
	    res.addSec(1);
	}
	res.addSec(T.sec);
	if (res.sec >= 60){
	    res.addSec(-60);
	    res.addMin(1);
	}
	res.addMin(T.min);
	if (res.min >= 60){
	    res.addMin(-60);
	    res.addHours(1);
	}
	res.addHours(T.hours);
	if (res.hours >= 24){
	    res.addHours(-24);
	    res.addDays(1);
	}
	res.addDays(T.days);
	return res;
    }

    public Time substractTime(Time T){
	Time res = new Time(this.days, this.hours, this.min, this.sec, this.ms);
	res.addMs(-T.ms);
	if (res.ms < 0){
	    res.addMs(1000);
	    res.addSec(-1);
	}
	res.addSec(-T.sec);
	if (res.sec < 0){
	    res.addSec(60);
	    res.addMin(-1);
	}
	res.addMin(-T.min);
	if (res.min < 0){
	    res.addMin(60);
	    res.addHours(-1);
	}
	res.addHours(-T.hours);
	if (res.hours < 0){
	    res.addHours(24);
	    res.addDays(-1);
	}
	res.addDays(-T.days);
	return res;
    }

    // returns true if this >= T
    public boolean higherThan(Time T){
	if (this.days > T.days)
	    return true;
	else if (this.days < T.days)
	    return false;
	if (this.hours > T.hours)
	    return true;
	else if (this.hours < T.hours)
	    return false;
	if (this.min > T.min)
	    return true;
	else if (this.min < T.min)
	    return false;
	if (this.sec > T.sec)
	    return true;
	else if (this.sec < T.sec)
	    return false;
	if (this.ms > T.ms)
	    return true;
	else if (this.ms < T.ms)
	    return false;
	return true;
    }


    public String toString(){
	return this.days + " days " + this.hours + "h" + this.min + "min" + this.sec + "sec" + this.ms +"ms";
    }

    public void display() {
        System.out.println(this.toString());
    }

    public static void main(String[] args){
	long begin = 2365468231L;
	long end = 1484658868L;
	Time T1 = new Time(begin, end);
	Time T2 = new Time(9, 17, 43, 17, 164);
	Time T3 = T1.addTime(T2);
	Time T4 = T1.substractTime(T2);
	T1.display();
	T2.display();
	T3.display();
	T4.display();
	System.out.println(T1.higherThan(T2));
	
    }    
}
