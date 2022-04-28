import java.io.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {

    private static Scanner keyboard = new Scanner(System.in);
    private static List<Club> allClub = new ArrayList<>();

    private static    Swim swim = new Swim("Swim");
    private static    Soccer soccer = new Soccer("Soccer");
    private static    Basketball basketball = new Basketball("String");


    public static void main(String[] args) {

        allClub.add(swim);
        allClub.add(soccer);
        allClub.add(basketball);



        for (int i = 0; i < allClub.size() ; i++)
        {
            System.out.println( (i+1) + "." + allClub.get(i).getName() );
        }

        int select = selection("Selection club : ", "Error", 0, allClub.size());

        System.out.println("join " + allClub.get(select).getName() + " club");

        System.out.print("Enter Your Name : ");
        String memberName = keyboard.nextLine();

        allClub.get(select).addMember(memberName);

        System.out.println("Suc");

//        System.out.println(allClub.get(select).getMember());

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


    public static List<Club> loadUser()
    {

        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/UserAll/user.txt"))))
        {
            String[] fields = null;
            String line = null;

            for (int i = 0 ; ((line = reader.readLine()) != null); i++) {
                fields = line.split(",");

//
//                user.setName(fields[0]);
//                user.setPassword(fields[1]);
//                user.setMoney(Integer.parseInt(fields[2]));

//                if (fields.length-1 > 2)
//                {
//                    for (int j = 3; j < fields.length; j++)
//                    {
//                        Game game = new Game(String.valueOf(fields[j]));
//
//                        user.addGames(game);
//
//                    }


                }


                userList.addLast(user);

            }

        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }


        return userList;

    }




//    public static void writeUser()
//    {
//
//        try(BufferedWriter bW = new BufferedWriter(new FileWriter(new File("src/UserAll/user.txt"))))
//
//        {
//            for (User loopUser: loadUsers)
//            {
//                bW.write(loopUser.getName());
//                bW.write(',');
//                bW.write(loopUser.getPassword());
//                bW.write(',');
//                bW.write(String.valueOf(loopUser.getMoney()));
//
//                if (loopUser.getGames().isEmpty() == false)
//                {
//
//                    for (int j = 0; j < loopUser.getGames().size() ; j++)
//                    {
//                        bW.write(',');
//                        bW.write(loopUser.getGames().get(j).getName());
//
//                    }
//                }
//
//                bW.newLine();
//            }
//
//        }
//        catch (IOException e)
//        {
//            System.out.println("Error" + e.getMessage());
//        }
//
//    }


//
//
////    public Deque<Book> listBook = loadBook();
//
//    public static void writeOn(Deque<Book> listBook)
//    {
//
//
//        try (BufferedWriter bW = new BufferedWriter(new FileWriter(new File("src/book.txt"))))
//        {
////            System.out.printf("\t\t\t%1$s  %2$s  %3$s  %4$s  %5$s  %6$s " + "\r\n",  newBook.getCode(), newBook.getName()
////                    , newBook.getPrice(), newBook.getRent_day(), newBook.getStatus(), newBook.getStatus());
//
//            for (Book loopBook: listBook)
//            {
//                bW.write(loopBook.getCode()+ "," + loopBook.getName()
//                        +  "," +loopBook.getPrice()+ "," + loopBook.getRent_day() + "," + loopBook.getStatus()+ "," + loopBook.getStatus());
//                bW.newLine();
//            }
//
//
//        }
//
//        catch (IOException e)
//        {
//            System.out.println("Error: " + e.getMessage());
//        }
//
//    }
//
//
//    public static Book checkTheBook(Deque<Book> listBook ,String aCode)
//    {
//
//        for (Book book : listBook)
//        {
//
//            if (Objects.equals(book.getCode(), aCode)) {
//
//                return book;
//            }
//
//        }
//
//        return new Book("Not found");
//
//    }

}
