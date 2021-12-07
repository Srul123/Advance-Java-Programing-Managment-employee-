package ex1.employees;

import ex1.BirthdayDate;

public abstract class Employee {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private BirthdayDate birthdayDate;

    // constructor
    public Employee(String firstName, String lastName,
                    String socialSecurityNumber, BirthdayDate dateOfBirthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.birthdayDate = dateOfBirthday;
    }

    // return first name
    public String getFirstName() {
        return firstName;
    }

    // return last name
    public String getLastName() {
        return lastName;
    }

    // return social security number
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public BirthdayDate getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(BirthdayDate birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    // return String representation of Employee object
    @Override
    public String toString() {
        return String.format("%s %s%nbirthday: %s%nsocial security number: %s",
                getFirstName(), getLastName(), getBirthdayDate(), getSocialSecurityNumber());
    }

    // abstract method must be overridden by concrete subclasses
    public abstract double earnings(); // no implementation here


}