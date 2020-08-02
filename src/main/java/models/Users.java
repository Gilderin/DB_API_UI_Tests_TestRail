package models;

public class Users {
    private String email;
    private String password;
    private String name;
    private String surname;
    private boolean isActive;
    private int  id;


    public Users(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Users(String email, String password, String name, String surname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Users() {

    }


    public static class Builder {
        private Users users;

        public Builder() {
            users = new Users();
        }

        public Builder setName(String name){
            users.name=name;
            return this;
        }
        public Builder setId(int id){
            users.id=id;
            return this;
        }
        public Builder setIsActive(Boolean isActive){
            users.isActive=isActive;
            return this;
        }
        public Builder setSurname(String surname){
            users.surname=surname;
            return this;
        }
        public Builder setEmail(String email){
            users.email=email;
            return this;
        }
        public Builder setPassword(String password){
            users.password=password;
            return this;
        }
        public Users build(){
            return users;
        }

    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
