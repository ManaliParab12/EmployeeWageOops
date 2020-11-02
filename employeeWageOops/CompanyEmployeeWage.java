package employeeWageOops;

import java.util.ArrayList;

class CompanyEmployeeWage {

public final String company;
public final int empRatePerHr;
public final int numberOfWorkingDays;
public final int maxHrPerMonth;
public int totalEmpWage;
ArrayList<Integer> dailyWage = new ArrayList<Integer>();

public CompanyEmployeeWage(String company, int empRatePerHr, int numberOfWorkingDays, int maxHrPerMonth) {
	  this.company = company;
	  this.empRatePerHr = empRatePerHr;
	  this.numberOfWorkingDays = numberOfWorkingDays;
	  this.maxHrPerMonth = maxHrPerMonth;
	}

	public void setTotalEmpWage(int totalEmpWage) {
	  this.totalEmpWage = totalEmpWage;
	}

	public String toString() {
	  return "Total employee wages for: " + company + " is " + totalEmpWage;
	}


}
