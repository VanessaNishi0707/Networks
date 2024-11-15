public class User {
    String username;
    int age;
    String gender;
    String region;

    public User(String username, int age, String gender, String region) {
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.region = region;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getRegion() {
        return region;
    }
}