package gurinovich.java;

public class Cheese extends Food
{
    public Cheese()
    {
        super("Cheese");
    }

    @Override
    public void consume()
    {
        System.out.println(this + " consumed");
    }

    @Override
    public double calculateCalories()
    {
        return 12;
    }
}
