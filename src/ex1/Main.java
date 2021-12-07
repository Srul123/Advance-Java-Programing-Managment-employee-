package ex1;

import ex1.employees.*;


/**
 * @ Maman 12 - EX1
 * @author Israel Heiblum
 */

public class Main {

    public static void main(String[] args) {
        // create subclass objects
        BirthdayDate birthdayDateEmployee1 = new BirthdayDate(27, 12, 1988);
        SalariedEmployee salariedEmployee =
                new SalariedEmployee("Israel", "Heiblum", "111-11-1111", 800.00, birthdayDateEmployee1);

        BirthdayDate birthdayDateEmployee2 = new BirthdayDate(8, 11, 1989);
        HourlyEmployee hourlyEmployee =
                new HourlyEmployee("Inbal", "Heiblum", "222-22-2222", 16.75, 40, birthdayDateEmployee2);

        BirthdayDate birthdayDateEmployee3 = new BirthdayDate(3, 10, 1988);
        CommissionEmployee commissionEmployee =
                new CommissionEmployee(
                        "Leo", "Igel", "333-33-3333", 10000, .06, birthdayDateEmployee3);

        BirthdayDate birthdayDateEmployee4 = new BirthdayDate(22, 11, 1986);
        BasePlusCommissionEmployee basePlusCommissionEmployee =
                new BasePlusCommissionEmployee(
                        "Neta", "Weinberger", "444-44-4444", 5000, .04, 300, birthdayDateEmployee4);

        BirthdayDate birthdayDateEmployee5 = new BirthdayDate(13, 1, 1985);
        PieceWorkerEmployee pieceWorkerEmployee =
                new PieceWorkerEmployee(
                        "David", "Heiblum", "555-55-5555", birthdayDateEmployee5);
        pieceWorkerEmployee.addItemProduced("Item1", 15.5, 10);
        pieceWorkerEmployee.addItemProduced("Item2", 30, 10);
        pieceWorkerEmployee.addItemProduced("Item3", 40, 5);


        // create four-element Employee array
        Employee[] employees = new Employee[5];

        // initialize array with Employees
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;
        employees[4] = pieceWorkerEmployee;

        System.out.printf("Employees processed polymorphically:%n%n");

        // generically process each element in array employees
        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee); // invokes toString

            // determine whether element is a BasePlusCommissionEmployee
            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                // downcast Employee reference to
                // BasePlusCommissionEmployee reference
                BasePlusCommissionEmployee employee =
                        (BasePlusCommissionEmployee) currentEmployee;

                employee.setBaseSalary(1.10 * employee.getBaseSalary());

                System.out.printf(
                        "new base salary with 10%% increase is: $%,.2f%n",
                        employee.getBaseSalary());
            }

            if (currentEmployee.getBirthdayDate().isCurrentMonthEmployeeBirthday()) {
                System.out.printf(
                        "earned $%.2f - got special birthday present (200) bonus %n%n", currentEmployee.earnings());
            } else {
                System.out.printf(
                        "earned: $%,.2f%n%n", currentEmployee.earnings());
            }

        }
        System.out.println();
        // get type name of each object in employees array
        for (int j = 0; j < employees.length; j++) {
            System.out.printf("Employee %d is a %s%n", j,
                    employees[j].getClass().getName());
        }


    }

}

