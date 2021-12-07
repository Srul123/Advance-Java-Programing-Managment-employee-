package ex1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * @ Maman 12 - EX1
 * @author Israel Heiblum
 */


public class BirthdayDate {
    Calendar birthday;

    public BirthdayDate(int day, int month, int year) {
        birthday = getCalendar(day, month, year);
    }

    public boolean isCurrentMonthEmployeeBirthday() {
        Calendar cal = Calendar.getInstance();
        int currentMonth = (cal.get(Calendar.MONTH) + 1);

        int employeeMonthBirthday = (birthday.get(Calendar.MONTH) + 1);

        return currentMonth == employeeMonthBirthday;
    }

    public Calendar getCalendar(int day, int month, int year) {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, year);

        // We will have to increment the month field by 1

        date.set(Calendar.MONTH, month - 1);

        // As the month indexing starts with 0

        date.set(Calendar.DAY_OF_MONTH, day);

        return date;
    }

    public String toString() {
        Date date = this.birthday.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }


}
