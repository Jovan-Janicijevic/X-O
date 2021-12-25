import java.util.Scanner;

public class IksOks
{
    static String[] tabla = new String[9];

    static String iks = " X ";
    static String oks = " O ";
    static String naPotezu = " X ";

    static String igrac1;
    static String igrac2;

    public static void main(String[] args)
    {
        popuniTablu();

        igrac1 = igracIgraKao();
        if(igrac1.equals(iks))
        {
            igrac2 = oks;
        }
        else
        {
            igrac2 = iks;
        }

        ispis();

        while (tablaPopunjena() == false && imamoPobednika() == false)
        {
            if(igrac1.equals(naPotezu))
            {
                tabla[potezIgraca()] = igrac1;
                ispis();
                naPotezu = igrac2;
            }
            else
            {
                tabla[potezProtivnika()] = igrac2;
                ispis();
                naPotezu = igrac1;
            }
        }

        System.out.println("kraj");
    }

    private static void ispis()
    {
        for (int i = 0; i < 9; i++) {
            System.out.print(tabla[i]);
            if (i == 2) {
                System.out.println();
            }
            if (i == 5) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }

    private static boolean tablaPopunjena()
    {
        for (int i = 0; i < 9; i++)
        {
            if (tabla[i].equals(" n "))
            {
                return false;
            }
        }

        return true;
    }

    private static int potezProtivnika()
    {
        while (true)
        {
            int randomIndex = (int) Math.floor((Math.random()) * 9);

            if(tabla[randomIndex].equals(" n "))
            {
                return randomIndex;
            }
        }
    }

    private static String igracIgraKao()
    {
        while (true)
        {
            System.out.println("Unestie X ili O: ");
            Scanner s = new Scanner(System.in);

            String odabir = s.next();
            if (odabir.equalsIgnoreCase("X"))
            {
                return " X ";
            }
            if (odabir.equalsIgnoreCase("O"))
            {
                return " O ";
            }
        }
    }

    private static int potezIgraca()
    {
        while (true)
        {
            System.out.println("Odigrajte: ");
            Scanner s = new Scanner(System.in);
            int odabir = s.nextInt();

            if(tabla[odabir].equals(" n "))
            {
                return odabir;
            }
        }
    }

    private static void popuniTablu()
    {
        for (int i = 0; i < 9; i++)
        {
            tabla[i] = " n ";
        }
    }

    private static boolean imamoPobednika()
    {
        // Ovde ide kod provere
        if(tabla[0].equals(" X ") && tabla[1].equals(" X ") && tabla[2].equals(" X "))
        {
            System.out.println("X je pobedio");
            return true;
        }
        if(tabla[3].equals(" X ") && tabla[4].equals(" X ") && tabla[5].equals(" X "))
        {
            System.out.println("X je pobedio");
            return true;
        }
        if(tabla[6].equals(" X ") && tabla[7].equals(" X ") && tabla[8].equals(" X "))
        {
            System.out.println("X je pobedio");
            return true;
        }
        return false;
    }
}

