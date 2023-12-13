import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    private int id;

    @SerializedName("FirstName")
    private String firstName;

    @SerializedName("LastName")
    private String lastName;

    @SerializedName("age")
    private int age;

    @SerializedName("email")
    private String email;

    @SerializedName("phone")
    private String phone;

    @SerializedName("birthDate")
    private String birthDate;

    @SerializedName("uNiVersity")
    private String university;

    @SerializedName("image")
    private String image;

    @SerializedName("address")
    private Address address;

    // Get methods for all instance variables

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getUniversity() {
        return university;
    }

    public String getImage() {
        return image;
    }

    public Address getAddress() {
        return address;
    }
}
