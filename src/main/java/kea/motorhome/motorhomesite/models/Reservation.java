package kea.motorhome.motorhomesite.models;


import java.util.List;
import java.util.Objects;

public class Reservation {

	private int reservationID;
	private int customerID;
	private int employeeID;
	private Period period;
	private Motorhome motorhome;
	private List<Service> services;
	private String notes;
	private String internalNotes;

	private List<Appointment> appointments;

	public Reservation()
	{
	}

	public Reservation(int reservationID, int customerID, int employeeID, Period period, Motorhome motorhome, List<Service> services, String notes, String internalNotes)
	{
		this.reservationID = reservationID;
		this.customerID = customerID;
		this.employeeID = employeeID;
		this.period = period;
		this.motorhome = motorhome;
		this.services = services;
		this.notes = notes;
		this.internalNotes = internalNotes;
	}

	public int getReservationID()
	{
		return reservationID;
	}

	public void setReservationID(int reservationID)
	{
		this.reservationID = reservationID;
	}

	public int getCustomerID()
	{
		return customerID;
	}

	public void setCustomerID(int customerID)
	{
		this.customerID = customerID;
	}

	public int getEmployeeID()
	{
		return employeeID;
	}

	public void setEmployeeID(int employeeID)
	{
		this.employeeID = employeeID;
	}

	public Period getPeriod()
	{
		return period;
	}

	public void setPeriod(Period period)
	{
		this.period = period;
	}

	public Motorhome getMotorhome()
	{
		return motorhome;
	}

	public void setMotorhome(Motorhome motorhome)
	{
		this.motorhome = motorhome;
	}

	public List<Service> getServices()
	{
		return services;
	}

	public void setServices(List<Service> services)
	{
		this.services = services;
	}

	public String getNotes()
	{
		return notes;
	}



	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	public String getInternalNotes()
	{
		return internalNotes;
	}

	public void setInternalNotes(String internalNotes)
	{
		this.internalNotes = internalNotes;
	}

	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof Reservation)) return false;
		Reservation that = (Reservation)o;
		return getReservationID() == that.getReservationID() &&
			   getCustomerID() == that.getCustomerID() &&
			   getEmployeeID() == that.getEmployeeID() &&
			   Objects.equals(getPeriod(), that.getPeriod()) &&
			   Objects.equals(getMotorhome(), that.getMotorhome()) &&
			   Objects.equals(getServices(), that.getServices()) &&
			   Objects.equals(getNotes(), that.getNotes()) &&
			   Objects.equals(getInternalNotes(), that.getInternalNotes());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(getReservationID(), getCustomerID(), getEmployeeID(), getPeriod(), getMotorhome(), getServices(), getNotes(), getInternalNotes());
	}

	@Override
	public String toString()
	{
		return "Reservation{" +
			   "reservationID=" + reservationID +
			   ", customerID=" + customerID +
			   ", employeeID=" + employeeID +
			   ", period=" + period +
			   ", motorhome=" + motorhome +
			   ", services=" + services +
			   ", notes='" + notes + '\'' +
			   ", internalNotes='" + internalNotes + '\'' +
			   '}';
	}
}