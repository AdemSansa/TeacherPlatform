package tn.rnu.isetr.tp.Entity;

public class User {
    private String name;
    private String email;
    private String password;
    private String ImageURL;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.ImageURL = null;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public String getImageURL() {
        return ImageURL;
    }
    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }
}
