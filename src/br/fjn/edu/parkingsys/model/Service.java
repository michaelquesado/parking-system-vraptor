package br.fjn.edu.parkingsys.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Double amount;
	private Integer stay;
	private Calendar dateTimeEntry;
	private Calendar dateTimeOut;
	private String created;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	private Vehicle vehicle;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getStay() {
		return stay;
	}

	public void setStay(Integer stay) {
		this.stay = stay;
	}

	public Calendar getDateTimeEntry() {
		return dateTimeEntry;
	}

	public void setDateTimeEntry(Calendar dateTimeEntry) {
		this.dateTimeEntry = dateTimeEntry;
	}

	public Calendar getDateTimeOut() {
		return dateTimeOut;
	}

	public void setDateTimeOut(Calendar dateTimeOut) {
		this.dateTimeOut = dateTimeOut;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result
				+ ((dateTimeEntry == null) ? 0 : dateTimeEntry.hashCode());
		result = prime * result
				+ ((dateTimeOut == null) ? 0 : dateTimeOut.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((stay == null) ? 0 : stay.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Service other = (Service) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (dateTimeEntry == null) {
			if (other.dateTimeEntry != null)
				return false;
		} else if (!dateTimeEntry.equals(other.dateTimeEntry))
			return false;
		if (dateTimeOut == null) {
			if (other.dateTimeOut != null)
				return false;
		} else if (!dateTimeOut.equals(other.dateTimeOut))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (stay == null) {
			if (other.stay != null)
				return false;
		} else if (!stay.equals(other.stay))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.equals(other.vehicle))
			return false;
		return true;
	}

}
