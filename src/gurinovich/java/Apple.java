package gurinovich.java;

import java.util.*;

import static java.util.Map.entry;

public class Apple extends Food
{
    String size = null;
    Map<String, Double> map = Map.ofEntries(
            entry("big", 20.0),
            entry("small", 15.0),
            entry("medium", 17.0)
    );

    public Apple(String size)
    {
        super("Apple");
        this.size = size;
    }

    public String getSize()
    {
        return size;
    }
    public void setSize(String size)
    {
        this.size = size;
     //   if (size == "big" || size == "small")
      //      this.size = size;
        //else
        //{
         //   System.out.println("try again");
           // Scanner keyboard = new Scanner(System.in);
            //setSize(keyboard.next());
        //}
    }
    public void printSize()
    {
        System.out.println("size " + size);
    }

    @Override
    public String toString()
    {
        return super.toString() + '/' + size;
    }

    @Override
    public void consume()
    {
        System.out.println(this + " consumed");
    }

    @Override
    public boolean equals(Object arg0)
    {
        if (!(arg0 instanceof Apple))
            return false;
        if (name == null || size == null || ((Apple) arg0).name == null || ((Apple) arg0).size == null)
            return false;
        return (name.equals(((Apple) arg0).name) && size.equals(((Apple) arg0).size));
    }

    @Override
    public double calculateCalories()
    {
        return map.get(size);
    }
}
