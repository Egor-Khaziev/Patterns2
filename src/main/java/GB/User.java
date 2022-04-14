package GB;

public class User {

    private int id;
    private String name;
    private String test;

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

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public User(int id, String name, String test) {
        this.id = id;
        this.name = name;
        this.test = test;
    }

    public User() {
    }

    @Override
    public String toString(){
        String string = id + " " + name + " " +test;
        return string;
    }
}

