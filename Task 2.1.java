//Emil Davlityarov
//e.davlityarov@innopolis.university
//1) Principles which violated are Single responsibility and Open-closed
//2) First of all, class PayPall is violated by Open-closed, because by getting new type of employee we can not use this
// method therefore need to modification this class, thus I change on universe method.
// Secondly, class Employee is violated by Single responsibility, because this class has not solo purpose, it connected
// with SalariedEmployee and HourlyEmployee, so it is incorrect for Single responsibility principle.
//3) Below
abstract class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract double calculatePay();
}
class Payroll {

    public double calculatePay(Employee employee) {
        return employee.calculatePay();
    }
}
class HourlyEmployee extends Employee {
    private double hoursWorked;
    private double hourlyRate;
    public HourlyEmployee(String name, double hourlyRate, double hoursWorked) {
        super(name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }
}
class SalariedEmployee extends Employee {
    private double salary;
    public SalariedEmployee(String name,  double salary) {
        super(name);
        this.salary = salary;
    }

    public double calculatePay() {
        return this.salary;
    }
}

