package program;    
import java.util.Scanner;

    public class arrayinsert

    {

        public static void main(String[] args) 

        {

            int n, x;

            Scanner s = new Scanner(System.in);

            System.out.print("Enter no. of elements you want in array:");

            n = s.nextInt();

            int a[] = new int[n];

            System.out.println("Enter all the elements:");

            for (int i = 0; i < n; i++) 

            {

                a[i] = s.nextInt();

            }

            System.out.print("Enter the position you want to insert:");

            x = s.nextInt();
            
            System.out.print("Enter the element you want to insert:");

            
            int p = s.nextInt();

            for (int i = 0; i < n; i++) 

            {

                if(a[x] == a[i])

                {

                    a[i]= p;

                 

                }

                
            }

            
                System.out.print("After inserting:      ");
                
                for(int i = 0; i < n; i++)

                {

                    System.out.print(a[i]+"--");
                }

                
        }

    }