package employeeWageOops;

import java.util.ArrayList;
import java.util.HashMap;

class EmployeeWageOops implements EmployeeWageInterface {

public static final int IS_FULL_TIME=1;
public static final int IS_PART_TIME=2;
int daySalary;

ArrayList<Integer> dailyWage = new ArrayList<Integer>();
ArrayList<CompanyEmployeeWage> CompanyEmployeeWageArrayList;
HashMap<String, CompanyEmployeeWage> CompanyEmployeeWageMap;

public EmployeeWageOops() {
	CompanyEmployeeWageArrayList = new ArrayList<>();
	CompanyEmployeeWageMap = new HashMap<>();
	}

public void dailyWage() {
	dailyWage.add(daySalary);
	}
public void addCompanyEmpWage(String company, int empRatePerHr, int numberOfWorkingDays, int maxHrPerMonth) {
	CompanyEmployeeWage companyEmployeeWage = new CompanyEmployeeWage(company, empRatePerHr, numberOfWorkingDays, maxHrPerMonth);
	CompanyEmployeeWageArrayList.add(companyEmployeeWage);
    CompanyEmployeeWageMap.put(company, companyEmployeeWage);
	}

public void computeEmployeeWage() {
	  for(int i=0;i<CompanyEmployeeWageArrayList.size();i++) {
	    CompanyEmployeeWage companyEmployeeWage = CompanyEmployeeWageArrayList.get(i);
	    companyEmployeeWage.setTotalEmpWage(this.computeEmployeeWage(companyEmployeeWage));
	  }
	}

public int computeEmployeeWage(CompanyEmployeeWage companyEmployeeWage) {
	int empHrs = 0;
	int totalEmpHrs = 0;
	int totalWorkingDays = 0;
	
while(totalEmpHrs <= companyEmployeeWage.maxHrPerMonth && totalWorkingDays < companyEmployeeWage.numberOfWorkingDays) {
    totalWorkingDays++;
    double empCheck = Math.floor(Math.random() * 10) % 3;
    switch ((int) empCheck) {
      case IS_FULL_TIME:
        empHrs = 8;
        break;
      case IS_PART_TIME:
        empHrs = 4;
        break;
      default:
        empHrs = 0;
    }
    int daySalary = empHrs * companyEmployeeWage.empRatePerHr;
    companyEmployeeWage.dailyWage.add(daySalary);
    totalEmpHrs += empHrs;
    System.out.println("totalWorkingDays: " + totalWorkingDays + "/ daily empHrs: " + empHrs + "/ totalEmpHrs: " + totalEmpHrs);
  }
  System.out.println("\nTotal emp wage : " +  (totalEmpHrs * companyEmployeeWage.empRatePerHr) + "\n");
  return totalEmpHrs * companyEmployeeWage.empRatePerHr;
}

public int getTotalEmpWage(String company) {
  return CompanyEmployeeWageMap.get(company).totalEmpWage;
}

public static void main(String[] args) {
  EmployeeWageOops empWageBuilder = new EmployeeWageOops();
  empWageBuilder.addCompanyEmpWage("sbi", 50, 20, 100);
  empWageBuilder.addCompanyEmpWage("sc", 40, 20, 100);
  empWageBuilder.addCompanyEmpWage("boi", 30, 20, 100);
  empWageBuilder.addCompanyEmpWage("uco", 30, 20, 100);
  empWageBuilder.addCompanyEmpWage("sbi", 50, 20, 100);
  empWageBuilder.computeEmployeeWage();
  System.out.println("Total wage of the searched company: " + empWageBuilder.getTotalEmpWage("sbi"));
}
}