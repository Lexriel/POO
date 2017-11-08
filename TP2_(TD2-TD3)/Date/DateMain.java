public class DateMain{
    public static void main(String[] args){
        
        System.out.println(2014+" bissextile ? "+Date.isBissextile(2014));
        System.out.println(2015+" bissextile ? "+Date.isBissextile(2015));
        System.out.println(2016+" bissextile ? "+Date.isBissextile(2016));
        System.out.println(2000+" bissextile ? "+Date.isBissextile(2000));

        
        Date d = new Date (31, Month.march, 2015);
        Date dd = new Date (31, Month.december, 2015);
        
        System.out.println("tomorrow for "+d+" -> "+d.tomorrow());
        System.out.println("tomorrow for "+dd+" -> "+dd.tomorrow());
        Date d1 = new Date (12, Month.march, 2015);
        System.out.println("tomorrow de "+d1+" -> "+d1.tomorrow());
        Date d2 = new Date (25, Month.march, 2015);
        System.out.println("Difference between "+d1+" et "+d2+" -> "+d1.difference(d2));
        System.out.println("Difference between "+d2+" et "+d1+" -> "+d2.difference(d1));
        Date d3 = new Date (12, Month.june, 2015);
        System.out.println("Difference between "+d1+" et "+d3+" -> "+d1.difference(d3));
        Date d4 = new Date (1, Month.february, 2016);
        System.out.println("Difference between "+d1+" et "+d4+" -> "+d1.difference(d4));

   
	System.out.println(d1.nDaysLater(10)+" is 10 days after "+d1);

	try{
	    d1.nDaysLater(-5);
	}
	catch(IllegalArgumentException e){
	    System.out.println(" *** argument of nDaysLater() must be positive");
	    // throw e;
	}
    }

}
