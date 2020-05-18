package kea.motorhome.motorhomesite.models;
// KCN
import kea.motorhome.motorhomesite.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date; // java.util.Dates can be used with class because
import java.util.Objects;

/**
 * A period object wraps two LocalDateTime objects, and exposes instance methods that
 * allow comparison of this and other periods.
 */
public class Period
{

    private int periodID;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime start;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime end;
    public Period(){ }

    public Period(LocalDateTime startDate, LocalDateTime endDate)
    {
        this.start = startDate;
        this.end = endDate;


    }

    public int getPeriodID()
    {
        return periodID;
    }

    public void setPeriodID(int periodID)
    {
        this.periodID = periodID;
    }

    /*
     constructor avoided for integration with Spring/Thymeleaf (which requires
     exactly one parameterless public and one fully parameterized constructor)
    */
    /** Method returns an initialized Period object */
    public static Period periodfromDates(Date startDate, Date endDate)
    {
        return new Period(DateUtil.convertToLocalDateTime(startDate),
                          DateUtil.convertToLocalDateTime(endDate));
    }

    /**
     * Method returns true if this period overlaps with
     */
    public boolean overlapsWith(Period otherPeriod)
    {
        return DateUtil.doPeriodsOverlap(
                start, end, otherPeriod.getStart(), otherPeriod.getEnd());
    }

    /**
     * Method returns false if periods overlap or the other start date is earlier than the start date
     * of this period; so you can !/not the return value and be sure the other period is earlier than this
     * period.
     */
    public boolean isEarlierThan(Period otherPeriod)
    {
        /* if periods overlap, this implies that neither period i entirely ealier than the other */
        if(overlapsWith(otherPeriod)){ return false; }
        return start.isBefore(otherPeriod.getStart());

        // could also be handled in a single line:
        // return end.isBefore(otherPeriod.getStart());
    }



    /**
     * Method returns true if supplied date is before start or after end of period.
     */
    public boolean dateOverlapsWithPeriod(LocalDateTime date)
    {
        return !(date.isBefore(start) || date.isAfter(end));
    }

    public boolean isPeriodConsistent()
    {
        return DateUtil.isPeriodConsistent(start, end);
    }

    public LocalDateTime getStart(){ return start; }

    public void setStart(LocalDateTime start){ this.start = start; }

    public Date getStartAsDate(){return DateUtil.convertToDate(start);}

    public LocalDateTime getEnd(){ return end; }

    public Date getEndAsDate(){return DateUtil.convertToDate(end);}

    public void setEnd(LocalDateTime end){ this.end = end; }


    @Override
    public String toString()
    {
        return "Period{" +
               "start=" + start +
               ", end=" + end +
               '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof Period)) return false;
        Period period = (Period)o;
        return getStart().equals(period.getStart()) &&
               getEnd().equals(period.getEnd());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getStart(), getEnd());
    }
}
