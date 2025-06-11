package EmployeeObjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HourlyEmployeeTest
{
    HourlyEmployee emp = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);

    @Test
    public void testGoodIncreaseHoursPositiveAndNegative()
    {
        //Test with both positive and negative values
        emp.increaseHours(12); //positive
        emp.increaseHours(-20); //should get ignored cause it's negative
        emp.increaseHours(2.7); //positive

        //added positive numbers together to get the expected value
        assertEquals(14.7, emp.getHoursWorked());
    }

    @Test
    public void testBadIncreaseHoursNegative()
    {
        //Test with only negative values should equal 0
        emp.increaseHours(-30); //negative so skipped
        emp.increaseHours(-2); // negative so skipped

        assertEquals(0, emp.getHoursWorked());
    }

    @Test
    public void testAnnualRaiseIncrease()
    {
        //wage of (32.85 * .05 * 100) / 100 should equal 34.49
        emp.annualRaise();

        assertEquals(34.49, emp.getWage());
    }

    @Test
    public void testCalculateWeeklyPayWithoutOvertime()
    {
        //35 hours works, should return 1149.75
        emp.increaseHours(35);

        assertEquals(1149.75, emp.calculateWeeklyPay());
    }

    @Test
    public void testCalculateWeeklyPayWithOvertime()
    {
        //45 hours worked, should return 1560.38
        emp.increaseHours(45);

        assertEquals(1560.38, emp.calculateWeeklyPay());
    }
}