package EmployeeObjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommissionEmployeeTest
{
    CommissionEmployee emp = new CommissionEmployee("Clint", "Barton", 6847, "Sales", "Customer Representative", .0265);

    @Test
    public void testIncreaseSalesWithPositivesAndNegatives()
    {
        //test with pos and neg values
        //neg values should be skipped
        emp.increaseSales(2);
        emp.increaseSales(3);
        emp.increaseSales(10);
        emp.increaseSales(-20); //skipped

        assertEquals(15, emp.getSales());
    }

    @Test
    public void testHolidayBonusShouldReturnZero()
    {
        assertEquals(0, emp.holidayBonus());
    }

    @Test
    public void testAnnualRaise()
    {
        //adds .002 to rate field of emp
        //call twice then use getter
        emp.annualRaise();
        emp.annualRaise();

        assertEquals(.0305, emp.getRate());
    }
}