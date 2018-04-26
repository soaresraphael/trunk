package com.cminsurance.model;

import java.util.Date;

public class Validity {
	
	private Date initialDate;
	
	private Date finalDate;
	
	public Validity() {
		initialDate = new Date(0);
		finalDate = new Date(0);
	}
	
	public boolean isCurrent() {
		Date currentDate = new Date(0);
		if ((currentDate.compareTo(initialDate) >= 0) && (currentDate.compareTo(finalDate) <= 0)) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((finalDate == null) ? 0 : finalDate.hashCode());
		result = prime * result + ((initialDate == null) ? 0 : initialDate.hashCode());
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
		Validity other = (Validity) obj;
		if (finalDate == null) {
			if (other.finalDate != null)
				return false;
		} else if (!finalDate.equals(other.finalDate))
			return false;
		if (initialDate == null) {
			if (other.initialDate != null)
				return false;
		} else if (!initialDate.equals(other.initialDate))
			return false;
		return true;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}
	
	

}
