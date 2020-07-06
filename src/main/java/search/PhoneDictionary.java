package search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param
     * @return Список подощедщих пользователей.
     */

    public ArrayList<Person> find(String key) {
        Predicate<Person> predicateAdress = person -> person.getAddress().contains(key);
        Predicate<Person> predicateName = person -> person.getName().contains(key);
        Predicate<Person> predicatePhone = person -> person.getPhone().contains(key);
        Predicate<Person> predicateSurname = person -> person.getSurname().contains(key);
        Predicate<Person> predicateCombine = predicateAdress.or(predicateName).or(predicatePhone).or(predicateSurname);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (predicateCombine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }


}