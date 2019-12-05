package com.alucardkrk.randompolakgenerator;

import com.alucardkrk.randompolakgenerator.persongenerator.Man;
import com.alucardkrk.randompolakgenerator.persongenerator.Person;
import com.alucardkrk.randompolakgenerator.persongenerator.Woman;
import com.alucardkrk.randompolakgenerator.utilities.TestData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/female")
    public Woman getRandomWoman(){
        TestData testData = new TestData();
        try {
            return testData.generateRandomWoman();
        } catch (SQLException e) {
            return null;
        }
    }
    @GetMapping("/male")
    public Man getRandomMan(){

        TestData testData = new TestData();

        try {
            return testData.generateRandomMan();
        } catch (SQLException e) {
            return null;
        }
    }
    @GetMapping("/person")
    public Person getRandomPerson(){

        int who = new Random().nextInt(2);
        if (who==0)
            return getRandomWoman();
        else
            return getRandomMan();
    }
    @GetMapping("/pesel")
    public String getRandomPesel(){
        Person person = new Person();
        return person.getPesel();
    }

    @GetMapping("/id")
    public String getRandomID(){
        Person person = new Person();

        return person.getIdNumber();
    }
}
