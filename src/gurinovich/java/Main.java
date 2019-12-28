package gurinovich.java;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.FormatFlagsConversionMismatchException;

public class Main
{

    public static void main(String[] args)
    {
       Food[] breakfast = new Food[20];

       int number = 0;
       boolean needCalculateCalories = false, needSort = false;
       for(String arg: args)
       {
           System.out.println(arg);
            if (arg.charAt(0) == '-')
            {
                if (arg.equals("-calories"))
                    needCalculateCalories = true;
                else if (arg.equals("-sort"))
                    needSort = true;
                continue;
            }

            String [] parts = arg.split("/");

            try
            {
                Class fromArg = Class.forName("gurinovich.java." + parts[0]);

                if (parts.length == 1)
                {
                    Constructor constructor = fromArg.getConstructor();
                    breakfast[number] = (Food)constructor.newInstance();
                }
                else if (parts.length == 2)
                {
                    Constructor constructor = fromArg.getConstructor(String.class);
                    breakfast[number] = (Food)constructor.newInstance(parts[1]);
                }
                else if (parts.length == 3)
                {
                    Constructor constructor = fromArg.getConstructor(double.class, double.class);
                    breakfast[number] = (Food)constructor.newInstance(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));
                }
                else
                {
                    throw new java.lang.ClassNotFoundException();
                }
            }
            catch (ClassNotFoundException e)
            {
                System.out.println("Class not found");
                continue;
            }
            catch (NoSuchMethodException e)
            {
                System.out.println("Constructor not found");
                continue;
            }
            catch (InstantiationException e)
            {
                System.out.println(e);
            }
            catch (IllegalAccessException e)
            {
                System.out.println(e);
            }
            catch (InvocationTargetException e)
            {
                System.out.println(e);
            }

            number++;
       }

       double calories = 0;

       if (needCalculateCalories)
       {
           for (int i = 0; i < number; i++)
               calories += breakfast[i].calculateCalories();
           System.out.println("Calories: " + calories);
       }

       if (needSort)
       {
           System.out.println("\npresorted");
           for (Food item: breakfast)
               if (item != null)
                 System.out.println(item);

           Arrays.sort(breakfast, new Comparator()
           {
               @Override
               public int compare(Object o1, Object o2)
               {
                   if (o1 == null || o2 == null)
                       return 0;

                   Class hz1 = o1.getClass();
                   Constructor[] c1 = hz1.getConstructors();

                   int maxCount1 = 0;
                   for (int i = 0; i < c1.length; i++)
                   {
                       int count = c1[0].getParameterCount();
                       if (count > maxCount1)
                           maxCount1 = count;
                   }

                   Class hz2 = o2.getClass();
                   Constructor[] c2 = hz2.getConstructors();

                   int maxCount2 = 0;
                   for (int i = 0; i < c2.length; i++)
                   {
                       int count = c2[0].getParameterCount();
                       if (count > maxCount2)
                           maxCount2 = count;
                   }

                   if (maxCount1 > maxCount2)
                       return -1;
                   else if (maxCount1 < maxCount2)
                       return 1;
                   return 0;
               }
           });
       }

        System.out.println("\nbre");
        for (Food item: breakfast)
            if (item != null)
                System.out.println(item);

        System.out.println();

       for (Food item: breakfast)
           if (item != null)
               item.consume();
           else
               break;
    }
}
