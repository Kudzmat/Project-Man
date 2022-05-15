import java.util.Date;

public class Projects {

    // Setting the project attributes

    String name;
    int number;
    String building_type;
    String proj_address;
    String erf_num;
    double proj_fee;
    double amount_paid;
    String deadline;
    String architect;
    String customer;
    String contractor;

    public Projects(String name, int number, String building_type, String proj_address, String erf_num, double proj_fee, double amount_paid, String deadline, String architect, String contractor, String customer) {

        this.name = name;
        this.number = number;
        this.building_type = building_type;
        this.proj_address = proj_address;
        this.erf_num = erf_num;
        this.proj_fee = proj_fee;
        this.amount_paid = amount_paid;
        this.deadline = deadline;
        this.architect = architect;
        this.contractor = contractor;
        this.customer = customer;
    }

    // Name
    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String getName() {
        return name;
    }

    // Project number
    public int setNumber(int number) {
        this.number = number;
        return number;
    }

    public int getNumber() {
        return number;
    }

    // Building type
    public String setBuilding_type(String building_type) {
        this.building_type = building_type;
        return building_type;
    }

    public String getBuilding_type() {
        return building_type;
    }

    // Project address
    public String setProject_address(String proj_address) {
        this.proj_address = proj_address;
        return proj_address;
    }

    public String getProj_address() {
        return proj_address;
    }

    // ERF number
    public String setErf_num(String erf_num) {
        this.erf_num = erf_num;
        return erf_num;
    }

    public String getErf_num() {
        return erf_num;
    }

    // Project fee
    public double setProj_fee(double proj_fee) {
        this.proj_fee = proj_fee;
        return proj_fee;
    }

    public double getProj_fee() {
        return proj_fee;
    }

    public double setAmount_paid(double amount_paid) {
        this.amount_paid = amount_paid;
        return amount_paid;
    }

    public double getAmount_paid() {
        return amount_paid;
    }

    //Deadline
    public String getDeadline() {
        return deadline;
    }

    // architect
    public String setArchitect(String architect) {
        this.architect = architect;
        return architect;
    }

    public String getArchitect() {
        return architect;
    }

    // contractor
    public String setContractor(String contractor) {
        this.contractor = contractor;
        return contractor;
    }

    public String getContractor() {
        return contractor;
    }

    // customer
    public String setCustomer() {
        this.customer = customer;
        return customer;
    }

    public String getCustomer() {
        return customer;
    }

    // toString
    public String toString() {

        String output = "";

        output += name + ", ";
        output += building_type + ", ";
        output += proj_address + ", ";
        output += erf_num + ", ";
        output += proj_fee + ", ";
        output += amount_paid + ", ";
        output += deadline + ", ";
        output += customer + ", ";
        output += architect + ", ";
        output += contractor + ", ";
        output += number;

        return output;
    }

}
