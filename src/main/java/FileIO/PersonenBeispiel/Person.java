package FileIO.PersonenBeispiel;

public class Person {
    private int id;
    private String name;
    private String bundesland;
    private int birthday;

    public Person(int id, String name, String bundesland, int birthday) {
        this.id = id;
        this.name = name;
        this.bundesland = bundesland;
        this.birthday = birthday;
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

    public String getBundesland() {
        return bundesland;
    }

    public void setBundesland(String bundesland) {
        this.bundesland = bundesland;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bundesland='" + bundesland + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
