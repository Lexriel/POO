public class Date implements Comparable<Date>{

    private int day;
    private Month month;
    private int year;

    public Date(int day, Month month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay(){
        return day;
    }

    public Month getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }

    /** returns the date corresponding to  tomorrow fot this date
     * @return the date corresponding to  tomorrow fot this date
     */
    public Date tomorrow(){
	// cas où passer au jour suivant ne change pas de mois
        if (this.day != this.month.getNbDays(this.year)){
            return new Date(this.day + 1, this.month, this.year);
        }
	// cas où passer au mois suivant ne change pas l'année
	if (this.month != Month.december){
	    return new Date(1, this.month.next(), this.year);
	}
	// cas Bonne Année :-)
	return new Date(1, Month.january, this.year + 1);
    }

    /** computes the date reached in <code>nbDays</code> after this
     * @param nbDays the number of days between this and wanted date
     * @result the date reached in <code>nbDays</code> after this
     * @exception IllegalArgumentException if <code>nbDays</code> is negative
     */
    public Date nDaysLater(int nbDays){
	if (nbDays < 0)
	    throw new IllegalArgumentException("argument should be positive");
	Date result = this;
	for (int i = 0; i < nbDays; i++){
	    result = result.tomorrow();
	}
	return result;
    }


    public int difference(Date d){
	if (this.compareTo(d)>0)
	    return -d.difference(this);
	// case this<= d
	Date d2 = this;
	int cpt = 0;
	while (!d2.equals(d)){
	    d2 = d2.tomorrow();
	    cpt++;
	}
	return cpt;
    }
    
    /** 
     * @param d
     * @return 0 if equal dates, -1 if this<d, 1 else
     * @see Comparable#compareTo(Object)
     */
    public int compareTo(Date d){// permet l'implémentation de l'interface Comparable<Date>
        if (this.equals(d)){
            return 0;
        }
	// cas années distinctes
        if (this.year < d.year){
            return -1;
        }
        if (this.year > d.year){
            return 1;
        }
	// cas années identiques, mois distincts
	if (this.month.compareTo(d.month) < 0){
	    return -1;
	}
	if (this.month.compareTo(d.month) > 0){
	    return 1;
	}
	// cas années et mois identiques, jours distincts
	return (this.day < d.day) ? -1 : 1;
	// this.day != d.day comme on a this != d avec le premier if
    }

    public boolean equals(Object o){
        if (o instanceof Date){
            Date other = (Date) o;
            return this.day == other.day
		&& this.month == other.month
		&& this.year == other.year; 
        } else {
            return false;
        }
    }

    public String toString(){
        return this.day + " " + this.month + " " + this.year;
    }

    /** indique si year est ou non une année bissextile
     * @param year l'année prise en compte
     * @return <tt>true</tt> si year est bissextile
     */
    public static boolean isBissextile(int year){
        return (year % 4 == 0) && (year % 400 != 0);
    }

}
