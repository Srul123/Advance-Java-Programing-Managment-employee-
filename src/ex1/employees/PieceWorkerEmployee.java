package ex1.employees;

import ex1.BirthdayDate;

import java.util.HashMap;
import java.util.Map;


/**
 * @ Maman 12 - EX1
 * @author Israel Heiblum
 */


public class PieceWorkerEmployee extends Employee {
    Map<String, Details > items = new HashMap<>();

    class Details {
        double price;
        int quantity;
        Details(double _price, int _quantity) {
            price = _price;
            quantity = _quantity;
        }
    }

    public PieceWorkerEmployee(String firstName, String lastName,
                               String socialSecurityNumber, BirthdayDate birthdayDate) {
        super(firstName, lastName, socialSecurityNumber, birthdayDate);
    }


    public void addItemProduced(String itemName, double itemPrice, int itemQuantity ) {
            Details details = new Details(itemPrice, itemQuantity);
            items.put(itemName, details);
    }

    private int getTotalJobsQuantity() {
        int total = 0;
        for (Details detail: items.values()){
            int quantity = detail.quantity;
            total = total + quantity;
        }
        return total;
    }

    private int getHowManyDifferentItems() {
        return items.size();
    }


    @Override
    public double earnings() {
        double sum = 0;
        for (Details detail: items.values()){
            double itemSum = detail.price * detail.quantity;
            sum = sum + itemSum;
        }
        return getBirthdayDate().isCurrentMonthEmployeeBirthday()? sum + 200 : sum;
    }

    // return String representation of PieceWorkerEmployee object
    @Override
    public String toString() {
        return String.format("%s %s %n%s %s %s",
                "piece worker employee:", super.toString(),
                "total: this month done", getTotalJobsQuantity() + " jobs",
                "from " + getHowManyDifferentItems() +
                " different items");

    }


}
