package ex1.employees;

import ex1.BirthdayDate;
import ex1.employees.Employee;

public class HourlyEmployee extends Employee {
    private double wage; // wage per hour
    private double hours; // hours worked for week

    // constructor
    public HourlyEmployee(String firstName, String lastName,
                          String socialSecurityNumber, double wage, double hours, BirthdayDate birthdayDate) {
        super(firstName, lastName, socialSecurityNumber, birthdayDate);

        if (wage < 0.0) { // validate wage
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        }

        if ((hours < 0.0) || (hours > 168.0)) { // validate hours
            throw new IllegalArgumentException(
                    "Hours worked must be >= 0.0 and <= 168.0");
        }

        this.wage = wage;
        this.hours = hours;
    }

    // set wage
    public void setWage(double wage) {
        if (wage < 0.0) { // validate wage
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        }

        this.wage = wage;
    }

    // return wage
    public double getWage() {
        return wage;
    }

    // set hours worked
    public void setHours(double hours) {
        if ((hours < 0.0) || (hours > 168.0)) { // validate hours
            throw new IllegalArgumentException(
                    "Hours worked must be >= 0.0 and <= 168.0");
        }

        this.hours = hours;
    }

    // return hours worked
    public double getHours() {
        return hours;
    }

    // calculate earnings; override abstract method earnings in Employee
    @Override
    public double earnings() {
        double sum = 0;
        if (getHours() <= 40) { // no overtime
            sum = getWage() * getHours();
        } else {
            sum = 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
        }
        return getBirthdayDate().isCurrentMonthEmployeeBirthday()? sum + 200 : sum;
    }

    // return String representation of HourlyEmployee object
    @Override
    public String toString() {
        return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f",
                super.toString(), "hourly wage", getWage(),
                "hours worked", getHours());
    }
}
