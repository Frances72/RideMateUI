package fa.tp2.ridemateui.model;

/**
 * Created by User on 2015/09/12.
 */
public class Cyclist {
    private Long id;
    private String firstname;
    private String lastname;
    private String age;

    public Long getId(){
        return id;
    }

    public void setID(Long id){
        this.id = id;
    }

    public String getName() {
        return firstname;
    }

    public void setName(String name) {
        this.firstname = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
