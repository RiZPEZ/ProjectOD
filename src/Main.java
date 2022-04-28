import java.io.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.io.IOException;


public class Main {

    private static Scanner keyboard = new Scanner(System.in);
    private static List<Club> allClub = new ArrayList<>();

    private static    Swim swim = new Swim("Swim");
    private static    Soccer soccer = new Soccer("Soccer");
    private static    Basketball basketball = new Basketball("Basketball");


    public static void main(String[] args) throws IOException {

        allClub.add(swim);
        allClub.add(soccer);
        allClub.add(basketball);

        loadUser();



        for (int i = 0; i < allClub.size() ; i++)
        {
            System.out.println( (i+1) + "." + allClub.get(i).getName() );
        }

        int select = selection("Selection club : ", "Error", 0, allClub.size());

        System.out.println("join " + allClub.get(select).getName() + " club");


        boolean found = false;

        do
        {

            System.out.print("Enter Your Name : ");
            String newMember = keyboard.nextLine();

            for (String member : allClub.get(select).getMember()) {

                if (Objects.equals(newMember, member)) {
                    found = true;
                    break;
                }

                else
                {
                    found = false;
                }

            }

            if (found == true) {
                System.out.println("Du");
            }

            else
            {
                System.out.println("Suc");
                allClub.get(select).addMember(newMember);
                writeUser();
                break;

            }

        } while (found == true);



    }


    public static int selection(String inPutMessage, String showError, int low, int hight) {

        int selection = -1;
        boolean again = true;


        while(again)
        {

            try
            {

                System.out.print(inPutMessage);
                selection = Integer.parseInt(keyboard.nextLine());

                selection = selection-1;

                if (selection < low || selection > hight)
                    throw new NumberFormatException();

                again = false;

            }

            catch (NumberFormatException e)
            {
                System.out.println(showError);

            }

        }

        return selection;
    }


    public static void loadUser() throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/memberClub.txt"))))
        {
            String[] fields = null;
            String line = null;

            for (int i = 0 ; ((line = reader.readLine()) != null); i++) {
                fields = line.split(",");

                if (Objects.equals(fields[0], allClub.get(i).getName()))
                {
                    for (int j = 1; j < fields.length; j++)
                    {
                        allClub.get(i).addMember(fields[j]);

                    }
                }

                }

            }


        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }

    }




    public static void writeUser()
    {

        try(BufferedWriter bW = new BufferedWriter(new FileWriter(new File("src/memberClub.txt"))))

        {
            for (Club club: allClub)
            {
                bW.write(club.getName());

                if (club.getMember().isEmpty() == false)
                {

                    for (int j = 0; j < club.getMember().size() ; j++)
                    {
                        bW.write(',');
                        bW.write(club.getMemberName(j));

                    }
                }

                bW.newLine();
            }

        }
        catch (IOException e)
        {
            System.out.println("Error" + e.getMessage());
        }

    }

}
