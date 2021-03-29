package  edu.umb.cs680.hw02;

public class Calculator {
	
    public static float add(float x, float y)
    {
    	float result = x + y;
        return result;
    }
    public static float sub(float x, float y)
    {
    	float result = x-y;
        return result;
    }
    public static float multiply(float x, float y)
    {
    	float result = x*y;
        return result;
    }
    public static float divide(float x, float y)
    {	
    	if(y==0)
    	{ 
    		throw new IllegalArgumentException("division by zero");
    	}
    	float result = x/y;
        return result;
    }

}