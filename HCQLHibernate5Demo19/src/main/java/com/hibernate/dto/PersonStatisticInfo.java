package com.hibernate.dto;

public class PersonStatisticInfo {
	private long totalPerson;
	private double totalSalary;
	private double maxSalary;
	private double minSalary;
	private double avgSalary;
	private long distinctPerson;

	public PersonStatisticInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonStatisticInfo(long totalPerson, double totalSalary, double maxSalary, double minSalary,
			double avgSalary, long distinctPerson) {
		super();
		this.totalPerson = totalPerson;
		this.totalSalary = totalSalary;
		this.maxSalary = maxSalary;
		this.minSalary = minSalary;
		this.avgSalary = avgSalary;
		this.distinctPerson = distinctPerson;
	}

	@Override
	public String toString() {
		return "PersonStatisticInfo [totalPerson=" + totalPerson + ", totalSalary=" + totalSalary + ", maxSalary="
				+ maxSalary + ", minSalary=" + minSalary + ", avgSalary=" + avgSalary + ", distinctPerson="
				+ distinctPerson + "]";
	}

	public long getTotalPerson() {
		return totalPerson;
	}

	public void setTotalPerson(long totalPerson) {
		this.totalPerson = totalPerson;
	}

	public double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}

	public double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}

	public double getAvgSalary() {
		return avgSalary;
	}

	public void setAvgSalary(double avgSalary) {
		this.avgSalary = avgSalary;
	}

	public long getDistinctPerson() {
		return distinctPerson;
	}

	public void setDistinctPerson(long distinctPerson) {
		this.distinctPerson = distinctPerson;
	}

}
