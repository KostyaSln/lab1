package gurinovich.java;
import java.util.Scanner;

public class Milk extends Food
{
    public Milk(double fat, double size)
    {
        super("Milk");
        this.fat = fat;
        this.size = size;
    }

    private double fat;
    private double size;

    public double getfat()
    {
        return fat;
    }
    public void setfat(double fat)
    {
        this.fat = fat;
//        if (fat == 1.5 || fat == 2.5 || fat == 5)
  //          this.fat = fat;
    //    else
      //  {
        //    System.out.println("you cant set such fat. choose another");
          //  Scanner keyboard = new Scanner(System.in);
            //this.setfat(keyboard.nextDouble());
        //}
    }
    public void printfat()
    {
         System.out.println("fat: " + fat);
    }

    public double getSize()
    {
        return size;
    }
    public void setSize(double size)
    {
        this.size = size;
    }
    public void printSize()
    {
        System.out.println("size: " + size);
    }

    @Override
    public String toString()
    {
        return super.toString() + '/' + fat + '/' + size;
    }

    @Override
    public void consume()
    {
        System.out.println(this + " consumed");
    }

    @Override
    public boolean equals(Object arg0)
    {
        if (!(arg0 instanceof Milk))
            return false;
        if (name == null || ((Milk) arg0).name == null)
            return false;
        return (name.equals(((Milk) arg0).name) && (fat == ((Milk) arg0).fat) && (size == (((Milk) arg0).size)));
    }

    @Override
    public double calculateCalories()
    {
        return size / 100 + fat * 2;
    }
}
