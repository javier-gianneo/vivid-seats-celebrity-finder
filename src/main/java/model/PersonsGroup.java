package model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonsGroup {
    private List<Person> group;

    public PersonsGroup(List<Person> group) {
        this.group = group;
    }

    /**
     * Celebrities is result of the interception of all group people acquaintances with candidates.
     * A candidate is a person who doesn´t know anybody.
     *
     * @return Celebrities set.
     */
    public Set<Person> findCelebrities() {

        Set<Person> candidates = group.stream().filter(
                p ->  p.getAcquaintances().isEmpty()).collect(Collectors.toSet());

        Set<Person> normies = group.stream().filter(p -> !candidates.contains(p)).collect(Collectors.toSet());

        Set<Person> acquaintances = normies.stream().map(Person::getAcquaintances).reduce((a,b) -> {
            if(Objects.isNull(b)) {
                return a;
            } else {
                return a.stream().filter(b::contains).collect(Collectors.toSet());
            }
        }).orElse(new HashSet<>());
        return candidates.stream().filter(acquaintances::contains).collect(Collectors.toSet());

    }


}
