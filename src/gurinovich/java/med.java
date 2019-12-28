package gurinovich.java;

public class med extends Food
{
    public med()
    {
        super("med");
    }

    @Override
    public void consume()
    {
        System.out.println(this + " consumed");
    }

    @Override
    public double calculateCalories()
    {
        return 120;
    }
}
