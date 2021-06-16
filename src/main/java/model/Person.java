package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Person {
    public Person(String name) {
        this.name = name;
        this.acquaintances = new HashSet();
    }

    private String name;
    private Set<Person> acquaintances;

    public Set<Person> getAcquaintances() {
        return acquaintances;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
