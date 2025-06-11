package EmployeeObjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryEmployeeTest
{
    SalaryEmployee emp = new SalaryEmployee("Steve", "Rodgers", 3781, "Sales", "Manager", 64325);

    @Test
    public void testCalculateWeeklyPay()
    {
        //Steve should get paid 1237.02
        //salary divided by 52
        assertEquals(1237.02, emp.calculateWeeklyPay());
    }

    @Test
    public void testHolidayBonus()
    {
        //3.365% is holiday bonus
        assertEquals(2164.54, emp.holidayBonus());
    }
}