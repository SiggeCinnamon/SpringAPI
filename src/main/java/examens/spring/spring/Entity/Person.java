package examens.spring.spring.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
    private String country;
    private String favourit_colour;

    Person() {

    }

    Person(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavourit_colour() {
        return favourit_colour;
    }

    public void setFavourit_colour(String favourit_colour) {
        this.favourit_colour = favourit_colour;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((favourit_colour == null) ? 0 : favourit_colour.hashCode());
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age != other.age)
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (favourit_colour == null) {
            if (other.favourit_colour != null)
                return false;
        } else if (!favourit_colour.equals(other.favourit_colour))
            return false;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", country=" + country + ", favourit_colour=" + favourit_colour + ", id=" + id
                + ", name=" + name + "]";
    }

}
