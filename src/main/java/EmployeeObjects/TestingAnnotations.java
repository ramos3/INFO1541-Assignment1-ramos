package EmployeeObjects;

import EmployeeBlueprints.Employee;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestingAnnotations
{
    public static void main(String[] args)
    {
        //provided employee objects
        CommissionEmployee comEmp = new CommissionEmployee("Clint", "Barton", 6847, "Sales", "Customer Representative", .0265);
        HourlyEmployee hrEmp = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);
        SalaryEmployee salEmp = new SalaryEmployee("Steve", "Rodgers", 3781, "Sales", "Manager", 64325);

        //counter to check annotations exist
        int count = 0;
        if (comEmp.getClass().isAnnotationPresent(EmployeeType.class))
        {
            count++;
        }

        if (hrEmp.getClass().isAnnotationPresent(EmployeeType.class))
        {
            count++;
        }

        if (salEmp.getClass().isAnnotationPresent(EmployeeType.class))
        {
            count++;
        }

        //should be 3
        System.out.println(count);

        //checking PayRate and WeeklyPayCalculator annotations
        checkOtherAnnotations(hrEmp);
        checkOtherAnnotations(comEmp);
        checkOtherAnnotations(salEmp);
    }

    public static void checkOtherAnnotations(Employee emp)
    {
        //checking which employee type it is
        Class<?> c = emp.getClass();
        System.out.println("\nEmployee type: " + c.getSimpleName());

        //printing pay rate results
        for (Field f : c.getDeclaredFields())
        {
            if (f.isAnnotationPresent(PayRate.class))
            {
                f.setAccessible(true);
                double pay = 0;
                try
                {
                    pay = (double) f.get(emp);
                }
                catch (IllegalAccessException e)
                {
                    throw new RuntimeException(e);
                }
                System.out.println("Employee pay rate: $" + pay);
            }
        }

        //printing weekly pay results
        for (Method m : c.getDeclaredMethods())
        {
            if (m.isAnnotationPresent(WeeklyPayCalculator.class))
            {
                m.setAccessible(true);
                double pay = 0;
                try
                {
                    pay = (double) m.invoke(emp);
                }
                catch (IllegalAccessException | InvocationTargetException e)
                {
                    throw new RuntimeException(e);
                }
                System.out.println("Weekly pay: $" + pay);
            }
        }
    }
}
