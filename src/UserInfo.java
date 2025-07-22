public class UserInfo {
    // Create these variables with proper access modifiers
    private String name;
    private int age;
    private String email;
    private boolean IsActive;

    // Create constructor that takes all parameters
    public UserInfo(String name, int age, String email, boolean IsActive){
        this.name = name;
        this.age = age;
        this.email = email;
        this.IsActive = IsActive;
    }

    // Create getter and setter methods for all variables
    public void setName(String name){this.name = name;}

    public String getName(){return name;}

    public void setAge(int age){this.age = age;}

    public int getAge(){return age;}

    public void setEmail(String email){this.email = email;}

    public String getEmail(){return email;}

    public void setIsActive(boolean IsActive){this.IsActive = IsActive;}

    public boolean getIsActive(){return IsActive;}

    // Create a method that displays user info nicely formatted
    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("IsActive: " + IsActive);
    }

    // Main method for testing

    public static void main(String[] args){
        // Create 3 different users
        UserInfo user1 = new UserInfo("Younas", 18, "yellowjacket@gmail.com", true);
        UserInfo user2 = new UserInfo("Martha", 18, "Marthaboring@gmail.com", false);
        UserInfo user3 = new UserInfo("Hannah", 12, "hannahapocalyse@gmail.com", true);

        // Display their information
        user1.displayInfo();
        user2.displayInfo();
        user3.displayInfo();

        // Test your getters and setters
        user1.setName("Younas mickel");
        user1.getName();
        user2.setName("Younas's aunt");
        user2.getName();
        user3.setAge(45);
        user3.getAge();
        user1.setEmail("endisbeginning@gmail.com");
        user1.getEmail();
        user3.setIsActive(false);
        user3.getIsActive();
    }



}

