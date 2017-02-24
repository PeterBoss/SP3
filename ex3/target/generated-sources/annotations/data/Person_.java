package data;

import data.Person;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-24T14:45:04")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> firstname;
    public static volatile SingularAttribute<Person, String> taxclass;
    public static volatile SingularAttribute<Person, Date> birthdate;
    public static volatile SingularAttribute<Person, Integer> sosecnr;
    public static volatile CollectionAttribute<Person, Person> personCollection;
    public static volatile SingularAttribute<Person, String> dtype;
    public static volatile SingularAttribute<Person, Integer> matnr;
    public static volatile SingularAttribute<Person, Boolean> ismarried;
    public static volatile SingularAttribute<Person, Person> supervisorId;
    public static volatile SingularAttribute<Person, String> lastname;
    public static volatile SingularAttribute<Person, Date> matdate;
    public static volatile SingularAttribute<Person, Integer> id;
    public static volatile CollectionAttribute<Person, Person> personCollection2;
    public static volatile CollectionAttribute<Person, Person> personCollection1;
    public static volatile SingularAttribute<Person, Integer> age;
    public static volatile SingularAttribute<Person, Float> wage;

}