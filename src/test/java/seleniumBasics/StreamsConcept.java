package seleniumBasics;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsConcept {
    //executes in alphabetical order
    @Test
    public void filterAndCount(){
        System.out.println("Count names starting with A");
        List<String> names= Arrays.asList("Abhi","Dom","Alekhya","Rama","Adam");
        long count=names.stream()
                .filter(s -> s.startsWith("A"))
                .count();
        System.out.println(count);
    }

    @Test
    public void limitTheOutput(){
        System.out.println("print only 2 names starting with A");
        List<String> names= Arrays.asList("Abhi","Dom","Alekhya","Rama","Adam");
        names.stream()
                .filter(s -> s.startsWith("A"))
                .limit(2)
                .forEach(s->System.out.println(s));

    }

    @Test
    public void anyMatchFunction(){
        System.out.println("Name found with Adam");
        List<String> names= Arrays.asList("Abhi","Dom","Alekhya","Rama","Adam");
        System.out.println(names.stream()
                .anyMatch(s->s.equals("Adam")));
    }

    @Test
    public void mapFunctionality(){
        //convert the names starting with "A" to uppercase
        System.out.println("Mapping all the elements starting with A to uppercase and print using forEach");
        List<String> names= Arrays.asList("Abhi","Dom","Alekhya","Rama","Adam");
        names.stream()
                .filter(s -> s.startsWith("A"))
                .map(s->s.toUpperCase())
                .forEach(s->System.out.println(s));
    }

    @Test
    public void sortedAndForEach(){
        //sort the names starting with "A"
        System.out.println("Mapping all the elements starting with A to Uppercase,Sorted and print using forEach");
        List<String> names= Arrays.asList("Abhi","Dom","Alekhya","Rama","Adam");
        names.stream()
                .filter(s -> s.startsWith("A"))
                .sorted()
                .map(s->s.toUpperCase())
                .forEach(s->System.out.println(s));
    }

    @Test
    public void distinctFunction(){
        System.out.println("print the distinct numbers in array");
        List<Integer> numbers=Arrays.asList(2,2,4,1,5,6,1,3);
        System.out.println(Arrays.toString(numbers.toArray()));
        numbers.stream()
                .distinct()
                .forEach(s->System.out.println(s));
    }

    @Test
    public void storeInNewList(){

        //store the list generated in new list
        List<Integer> numbers=Arrays.asList(2,2,4,1,5,6,1,3);
        List<Integer> uniqueNumbers=numbers.stream()
                .distinct()
                .toList();
        System.out.println("unique numbers collected as list");
        uniqueNumbers.forEach(i->System.out.println(i));


        //print sorted string list
        List<String> names= Arrays.asList("Abhinaya","Dom","Alekhya","Rama","Adam");
        List<String> sortedNames=names.stream()
                .filter(s->s.endsWith("a"))
                .sorted()
                .map(s->s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("Sorted uppercase names ending with A and collected as list");
        sortedNames.forEach(s->System.out.println(s));
    }



}
