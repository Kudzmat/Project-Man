public class Customer {
    // Attributes

    String name;
    String telephone;
    String email;
    String address;
    int projNumber;

    public Customer(String name, String telephone, String email, String address, int projNumber) {

        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.projNumber = projNumber;
    }

    // Name
    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String getName() {
        return name;
    }

    // Telephone
    public String setTelephone(String telephone) {
        this.telephone = telephone;
        return telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    // Email
    public String setEmail(String email) {
        this.email = email;
        return email;
    }

    public String getEmail() {
        return email;
    }

    // Address
    public String setAddress(String address) {
        this.address = address;
        return address;
    }

    public String getAddress() {
        return address;
    }

    // Project number
    public void setProjNumber(int projNumber) {
        this.projNumber = projNumber;
    }

    public int getProjNumber() {
        return projNumber;
    }

    // toString
    public String toString() {
        String output = "";

        output += name + ", ";
        output += telephone + ", ";
        output += email + ", ";
        output += address + ", ";
        output += projNumber;

        return output;
    }
}
