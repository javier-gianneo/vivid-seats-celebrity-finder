import model.Person;
import model.PersonsGroup;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonGroupTest {
    private PersonsGroup group;
    private List<Person> groupList = new ArrayList<>();
    private Person juan = new Person("Juan");
    private Person pedro = new Person("Pedro");
    private Person pablo = new Person("Pablo");
    private Person jenniferLopez = new Person("Jennifer Lopez");

    private void addGroupMembers() {
        groupList.add(juan);
        groupList.add(pablo);
        groupList.add(pedro);
        groupList.add(jenniferLopez);
        group = new PersonsGroup(groupList);
    }

    @Test
    public void testFindCelebrity() {
        addGroupMembers();
        Set<Person> result = group.findCelebrities();
        assertEquals(result.size(), 0);
    }

    @Test
    public void testFindCelebrity_2() {
        juan.getAcquaintances().add(jenniferLopez);
        pedro.getAcquaintances().add(jenniferLopez);
        pablo.getAcquaintances().add(jenniferLopez);
        addGroupMembers();
        Set<Person> result = group.findCelebrities();
        assertEquals(1, result.size());
    }

    @Test
    public void testFindCelebrity_3() {
        juan.getAcquaintances().add(jenniferLopez);
        pedro.getAcquaintances().add(jenniferLopez);
        pablo.getAcquaintances().add(jenniferLopez);
        jenniferLopez.getAcquaintances().add(pablo);
        addGroupMembers();
        Set<Person> result = group.findCelebrities();
        assertEquals(result.size(), 0);
    }

    @Test
    public void testFindCelebrity_4() {
        juan.getAcquaintances().add(jenniferLopez);
        juan.getAcquaintances().add(pablo);
        pedro.getAcquaintances().add(jenniferLopez);
        pedro.getAcquaintances().add(pablo);
        addGroupMembers();
        Set<Person> result = group.findCelebrities();
        assertEquals(result.size(), 2);
    }

    @Test
    public void testFindCelebrity_5() {
        List<Person> emptyGroup = new ArrayList<>();
        group = new PersonsGroup(emptyGroup);
        Set<Person> result = group.findCelebrities();
        assertEquals(result.size(), 0);
    }

    @Test
    public void testFindCelebrity_6() {
        jenniferLopez.getAcquaintances().add(juan);
        pedro.getAcquaintances().add(pablo);
        pablo.getAcquaintances().add(pedro);
        pablo.getAcquaintances().add(jenniferLopez);
        addGroupMembers();
        Set<Person> result = group.findCelebrities();
        assertEquals(result.size(), 0);
    }
}
