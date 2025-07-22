public class UserInfo {


    private String name;
    private int age;
    private String email;
    private boolean isActive;

    public UserInfo(String name, int age, String email, boolean isActive) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
    }

    public void displayInfo() {
        System.out.println(name + " | Age: " + age + " | Email: " + email + " | Active: " + isActive);
    }

    public static void main(String[] args) {
        UserInfo user1 = new UserInfo("Alice", 28, "alice@mail.com", true);
        UserInfo user2 = new UserInfo("Bob", 35, "bob@mail.com", false);
        UserInfo user3 = new UserInfo("Charlie", 22, "charlie@mail.com", true);

        user1.displayInfo();
        user2.displayInfo();
        user3.displayInfo();
    }
}
