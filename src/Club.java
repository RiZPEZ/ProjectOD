import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Club {

    private String name = "";

    private List<String> member = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Club(String name)
    {
        this.name = name;
    }


    public List<String> getMember() {
        return member;
    }

    public String getMemberName(int i) {
        return member.get(i);
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
