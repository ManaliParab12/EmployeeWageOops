package employeeWageOops;

import java.util.ArrayList;
import java.util.HashMap;

import empWageOops.CompanyEmpWage;

class EmployeeWageOops implements InEmployeeWageOop {

public static final int IS_FULL_TIME=1;
public static final int IS_PART_TIME=2;
int daySalary;

ArrayList<Integer> dailyWage = new ArrayList<Integer>();
ArrayList<CompanyEmpWage> CompanyEmpWageArrayList;
HashMap<String, CompanyEmpWage> CompanyEmpWageMap;

public EmployeeWageOop() {
	CompanyEmpWageArrayList = new ArrayList<>();
	CompanyEmpWageMap = new HashMap<>();
	}

public void dailyWage() {
	dailyWage.add(daySalary);
	}
public void addCompanyEmpWage(String company, int empRatePerHr, int numberOfWorkingDays, int maxHrPerMonth) {
	CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHr, numberOfWorkingDays, maxHrPerMonth);
	CompanyEmpWageArrayList.add(companyEmpWage);
    CompanyEmpWageMap.put(company, companyEmpWage);
	}

public void computeEmpWage() {
	  for(int i=0;i<CompanyEmpWageArrayList.size();i++) {
	    CompanyEmpWage companyEmpWage = CompanyEmpWageArrayList.get(i);
	    companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
	  }
	}

public int computeEmpWage(CompanyEmpWage companyEmpWage) {
	int empHrs = 0;
	int totalEmpHrs = 0;
	int totalWorkingDays = 0;
	}

}