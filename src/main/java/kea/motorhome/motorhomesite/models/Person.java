package kea.motorhome.motorhomesite.models;

import kea.motorhome.motorhomesite.enums.SiteRole;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Person {

	private int personID;
	private String firstName;
	private String lastName;
	private Address address;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	private SiteRole userType;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joinDate;

	public Person()	{	}

	public Person(int personID, String firstName, String lastName, Address address, LocalDate birthDate, SiteRole userType, LocalDate joinDate)
	{
		this.personID = personID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.birthDate = birthDate;
		this.userType = userType;
		this.joinDate = joinDate;
	}

	public int getPersonID()
	{
		return personID;
	}

	public void setPersonID(int personID)
	{
		this.personID = personID;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public LocalDate getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate)
	{
		this.birthDate = birthDate;
	}

	public SiteRole getUserType()
	{
		return userType;
	}

	public void setUserType(SiteRole userType)
	{
		this.userType = userType;
	}

	public LocalDate getJoinDate()
	{
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate)
	{
		this.joinDate = joinDate;
	}

	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof Person)) return false;
		Person person = (Person)o;
		return getPersonID() == person.getPersonID() &&
			   Objects.equals(getFirstName(), person.getFirstName()) &&
			   Objects.equals(getLastName(), person.getLastName()) &&
			   Objects.equals(getAddress(), person.getAddress()) &&
			   Objects.equals(getBirthDate(), person.getBirthDate()) &&
			   getUserType() == person.getUserType() &&
			   Objects.equals(getJoinDate(), person.getJoinDate());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(getPersonID(), getFirstName(), getLastName(), getAddress(), getBirthDate(), getUserType(), getJoinDate());
	}
}