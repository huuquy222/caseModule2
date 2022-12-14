package model;

public class User {
    private long  id;
    private String name;

    private String phone;
    private String email;
    private String address;
    private Role role;
    private String password;
    private String username;

    public User(){

    }
    public User( String username, String password, String name, String phone, String email, String address, Role role){

        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.role = role;
    }

    public static User parseUser(String raw){
        User user = new User();
        String[] strings = raw.split(",");
        user.id = Long.parseLong(strings[0]);
        user.username = strings[1];
        user.password = strings[2];
        user.name = strings[3];
        user.phone = strings[4];
        user.email = strings[5];
        user.address = strings[6];
        user.role = Role.parseStaff(strings[7]);
        return user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    @Override
    public String toString(){
        return String.format("%S,%s,%s,%s,%s,%s,%s,%s",
                id,username, password,name,phone,email,address,role);
    }

}
