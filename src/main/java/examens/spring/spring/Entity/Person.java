package examens.spring.spring.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Person {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    private String name;
    private int age;
    private String country;

    private String favouritColour;

    Person() {

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

    public String getFavouritColour() {
        return favouritColour;
    }

    public void setFavouritColour(String favouritColour) {
        this.favouritColour = favouritColour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((favouritColour == null) ? 0 : favouritColour.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        if (favouritColour == null) {
            if (other.favouritColour != null)
                return false;
        } else if (!favouritColour.equals(other.favouritColour))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
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
        return "Person [age=" + age + ", country=" + country + ", favouritColour=" + favouritColour + ", id=" + id
                + ", name=" + name + "]";
    }

    public Person(Long id, String name, int age, String country, String favouritColour) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
        this.favouritColour = favouritColour;
    }

}
