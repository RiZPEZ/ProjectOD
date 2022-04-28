import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Club {

    private String name = "";

    private Deque<String> member = new ArrayDeque<>();

    public Club(String name)
    {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public Deque<String> getMember() {
        return member;
    }

    public void addMember(String member)
    {
        this.member.add(member);
    }


    public void start()
    {
        System.out.println("Start Club" + getName());
    }



    

}
