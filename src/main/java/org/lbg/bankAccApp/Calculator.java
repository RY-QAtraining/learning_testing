package org.lbg.bankAccApp;

public class Calculator {
    double initVal = 0;

    public double getInitVal()
    {
        return initVal;
    }

    public double add(double x)
    {
        return (initVal+=x);
    }

    public double subtract(double x)
    {
        return (initVal-=x);
    }

    public double multiply(double x)
    {
        return (initVal*=x);
    }

    public double divide(double x)
    {
        return (initVal/=x);
    }
}
