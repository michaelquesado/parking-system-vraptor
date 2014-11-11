package br.fjn.edu.parkingsys.model;

import java.util.Calendar;

import javax.persistence.*;

@Entity
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	private Service service;

	private Calendar dateEntry;

	private Calendar dateOut;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Calendar getDateEntry() {
		return dateEntry;
	}

	public void setDateEntry(Calendar dateEntry) {
		this.dateEntry = dateEntry;
	}

	public Calendar getDateOut() {
		return dateOut;
	}

	public void setDateOut(Calendar dateOut) {
		this.dateOut = dateOut;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateEntry == null) ? 0 : dateEntry.hashCode());
		result = prime * result + ((dateOut == null) ? 0 : dateOut.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
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
		Operation other = (Operation) obj;
		if (dateEntry == null) {
			if (other.dateEntry != null)
				return false;
		} else if (!dateEntry.equals(other.dateEntry))
			return false;
		if (dateOut == null) {
			if (other.dateOut != null)
				return false;
		} else if (!dateOut.equals(other.dateOut))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		return true;
	}

}
