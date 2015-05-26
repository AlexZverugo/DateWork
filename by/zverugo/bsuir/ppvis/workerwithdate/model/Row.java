package by.zverugo.bsuir.ppvis.workerwithdate.model;

import by.zverugo.bsuir.ppvis.workerwithdate.model.Human;

import java.util.GregorianCalendar;

/**
 * Created by Alex on 23.05.2015.
 */
public class Row {

    private Human fullName;
    private GregorianCalendar birthDate;
    private GregorianCalendar receiptDate;
    private GregorianCalendar endDate;

    public Row() {
        setFullName(null);
        setBirthDate(null);
        setReceiptDate(null);
        setEndDate(null);
    }

    public Row(Human fullName, GregorianCalendar birthDate, GregorianCalendar receiptDate, GregorianCalendar endDate) {
        setFullName(fullName);
        setBirthDate(birthDate);
        setReceiptDate(receiptDate);
        setEndDate(endDate);
    }

    public void setFullName(Human fullName) {
        this.fullName = fullName;
    }

    public Human getFullName() {

        return fullName;
    }

    public void setBirthDate(GregorianCalendar birthDate) {
        this.birthDate = birthDate;
    }

    public GregorianCalendar getBirthDate() {

        return birthDate;
    }

    public void setReceiptDate(GregorianCalendar receiptDate) {
        this.receiptDate = receiptDate;
    }

    public GregorianCalendar getReceiptDate() {

        return receiptDate;
    }

    public void setEndDate(GregorianCalendar endDate) {
        this.endDate = endDate;
    }

    public GregorianCalendar getEndDate() {

        return endDate;
    }

    public String buildFullDate(GregorianCalendar date) {

        String helpDayString = "";
        String helpMonthString = "";

        if (date.get(GregorianCalendar.DAY_OF_MONTH) < 10) {
            helpDayString = "0";
        }
        if (date.get (GregorianCalendar.MONTH) < 10) {
            helpMonthString = "0";
        }

        return helpDayString + date.get(GregorianCalendar.DAY_OF_MONTH) + "/"
                + helpMonthString + date.get(GregorianCalendar.MONTH) + "/"
                + date.get(GregorianCalendar.YEAR);
    }


    public String buildFullName() {

        return fullName.getSurname() + "" + fullName.getName() + "" + fullName.getSecondName();
    }

}
