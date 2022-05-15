//This program is a project management system which will create and store specifications for a project.

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class ProjectManager {

    // This method will read the data from the projects file and store it into an arraylist
    public static Object projList() {

        ArrayList<String> projects = null;  // initializing empty arraylist
        try {
            File f = new File("projects.txt");

            Scanner sc = new Scanner(f);
            projects = new ArrayList<>();

            while (sc.hasNext()) {
                String lines = sc.nextLine();
                projects.add(lines);
            }

        } catch (FileNotFoundException e) {
            System.out.println("This file does not exist.");
        }
        return projects;  // return list of projects

    }

    // This method will read from the architects file and store the data into an arraylist
    public static Object architectList() {

        ArrayList<String> architects = null;
        try {
            File f = new File("architects.txt");

            Scanner sc = new Scanner(f);
            architects = new ArrayList<>();

            while (sc.hasNext()) {
                String lines = sc.nextLine();
                architects.add(lines);
            }

        } catch (FileNotFoundException e) {
            System.out.println("This file does not exist.");
        }
        return architects;  // return list of architects

    }

    // This method will read from the customers file and store the data into an arraylist
    public static Object customerList() {

        ArrayList<String> customers = null;
        try {
            File f = new File("customers.txt");

            Scanner sc = new Scanner(f);
            customers = new ArrayList<>();

            while (sc.hasNext()) {
                String lines = sc.nextLine();
                customers.add(lines);
            }

        } catch (FileNotFoundException e) {
            System.out.println("This file does not exist.");
        }
        return customers;  // return list of customers
    }

    // This method will read from the contractors file and store the data into an arraylist
    public static Object contractorList() {

        ArrayList<String> contractors = null;
        try {
            File f = new File("contractors.txt");

            Scanner sc = new Scanner(f);
            contractors = new ArrayList<>();

            while (sc.hasNext()) {
                String lines = sc.nextLine();
                contractors.add(lines);
            }

        } catch (FileNotFoundException e) {
            System.out.println("This file does not exist.");
        }
        return contractors;  // return list of contractors
    }

    // This method will read from the incomplete projects file and store the data into an arraylist
    public static ArrayList<String> incompleteProjects(){

        ArrayList<String> incomplete = null;
        try {
            File f = new File("incomplete.txt");

            Scanner sc = new Scanner(f);
            incomplete = new ArrayList<>();

            while (sc.hasNext()) {
                String lines = sc.nextLine();
                incomplete.add(lines);
            }

        } catch (FileNotFoundException e) {
            System.out.println("This file does not exist.");
        }
        return incomplete;  // return list of incomplete projects

    }

    // This method will read from the completed projects file and store the data into an arraylist
    public static Object completedList() {

        ArrayList<String> completed = null;
        try {
            File f = new File("completed.txt");

            Scanner sc = new Scanner(f);
            completed = new ArrayList<>();

            while (sc.hasNext()) {
                String lines = sc.nextLine();
                completed.add(lines);
            }

        } catch (FileNotFoundException e) {
            System.out.println("This file does not exist.");
        }
        return completed;  // return list of completed projects
    }


    // This method takes inputs which will be used for creating objects for a project, architect, customer and contractor
    // and store them into arraylists, which will then be written back to their respective text files
    public static void newProject() throws ParseException, IOException {

        try {

            Scanner input = new Scanner(System.in);

            // Getting the architect's information
            System.out.println("Enter the architect's FIRST NAME: ");
            String archFirstName = input.next();
            System.out.println("Enter the architect's SURNAME: ");
            String archSurName = input.next();
            String archName = archFirstName + " " + archSurName;  // combining both strings to get the full name

            System.out.println("Enter the architect's phone number: ");
            String archTelephone = input.next();

            System.out.println("Enter the architect's email: ");
            String archEmail = input.next();

            System.out.println("Enter the architect's address: ");
            String archAddress = input.next();
            archAddress += input.nextLine();  // for strings with a space


            // Getting the contractor's information
            System.out.println("Enter the contractor's FIRST NAME: ");
            String contFirstName = input.next();
            System.out.println("Enter the contractor's SURNAME: ");
            String contSurName = input.next();
            String contName = contFirstName + " " + contSurName;

            System.out.println("Enter the contractor's phone number: ");
            String contTelephone = input.next();

            System.out.println("Enter the contractor's email: ");
            String contEmail = input.next();

            System.out.println("Enter the contractor's address: ");
            String contAddress = input.next();
            contAddress += input.nextLine();


            // Getting the customer's information
            System.out.println("Enter the customer's FIRST NAME: ");
            String firstName = input.next();
            System.out.println("Enter the customer's SURNAME: ");
            String surName = input.next();
            String customerName = firstName + " " + surName;

            System.out.println("Enter the customer's phone number: ");
            String customerTel = input.next();

            System.out.println("Enter the customer's email: ");
            String customerEmail = input.next();

            System.out.println("Enter the customer's address: ");
            String customerAddress = input.next();
            customerAddress += input.nextLine();


            // Getting the details of the actual project
            System.out.println("Enter the building type: ");
            String projBuilding = input.next();
            projBuilding += input.nextLine();

        /*
        The user has an option to select whether this project has a name.
        If the project does not have a name, a placeholder name will be given.
         */
            int option = 0;
            String projName = "";
            while (option != 1 || option != 2) {
                System.out.println("Please select either 1 or 2.");
                System.out.println(
                        "Does this project have a name?\n" +
                                "(1)YES     (2)NO");
                option = input.nextInt();

                // we have a project name
                if (option == 1) {
                    System.out.println("Enter the project name: ");
                    projName = input.next();
                    projName += input.nextLine();
                    break;
                }

                // no project name
                else if (option ==2) {
                    projName += projBuilding + " " + surName;
                    System.out.println("The project has been given a placeholder name.");
                    System.out.println("");
                    break;
                }
            }


            System.out.println("Enter the project number: ");
            int projNumber = input.nextInt();

            System.out.println("Enter the project address: ");
            String projAddress = input.next();
            projAddress += input.nextLine();

            System.out.println("Enter the project ERF number: ");
            String projErf = input.next();

            System.out.println("Enter the project fee: ");
            double projFee = input.nextDouble();

            System.out.println("Enter the amount paid so far: ");
            double paid = input.nextDouble();

            // Getting the deadline date
            System.out.println("Enter the project deadline (YYYY-MM-DD): ");
            String date1 = input.next();
            date1 += input.nextLine();
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
            String deadline = new SimpleDateFormat("yyyy-MM-dd").format(date2);

            // creating new architect object
            Architect architect = new Architect(archName, archTelephone, archEmail, archAddress, projNumber);
            ArrayList<Architect> arch = (ArrayList<Architect>) architectList();  // calling list of architects
            arch.add(architect); // adding the new architect
            FileWriter fw = new FileWriter("architects.txt");
            for (int i = 0; i < arch.size(); i ++) {
                fw.write(String.valueOf(arch.get(i) + "\n"));  // writing back updated architects to the file
            }
            fw.close();

            // creating new object for contractor
            Contractor contractor = new Contractor(contName, contTelephone, contEmail, contAddress, projNumber);
            ArrayList<Contractor> contr = (ArrayList<Contractor>) contractorList();
            contr.add(contractor);
            FileWriter fw2 = new FileWriter("contractors.txt");
            for (int i = 0; i < contr.size(); i ++) {
                fw2.write(String.valueOf(contr.get(i) + "\n"));
            }
            fw2.close();

            // creating new object for customer
            Customer customer = new Customer(customerName, customerTel, customerEmail, customerAddress, projNumber);
            ArrayList<Customer> cust = (ArrayList<Customer>) customerList();
            cust.add(customer);
            FileWriter fw3 = new FileWriter("customers.txt");
            for (int i = 0; i < cust.size(); i ++) {
                fw3.write(String.valueOf(cust.get(i) + "\n"));
            }
            fw3.close();


            //creating new object for project
            Projects project = new Projects(projName, projNumber, projBuilding, projAddress, projErf, projFee, paid,
                    deadline, archName, contName, customerName);
            ArrayList<Projects> proj = (ArrayList<Projects>) projList();
            proj.add(project);
            FileWriter fr = new FileWriter("Projects.txt");
            for (int i = 0; i < proj.size(); i ++) {
                fr.write(String.valueOf(proj.get(i) + "\n"));
            }
            fr.close();

            // writing to incomplete projects file
            ArrayList<String> incomplete = (ArrayList<String>) incompleteProjects();

            if (incomplete == null) {  // when there are no incomplete projects
                ArrayList<Projects> incomplete2 = new ArrayList<>();
                incomplete2.add(project);
            }

            else {

                incomplete.add(String.valueOf(project));
                FileWriter fr2 = new FileWriter("incomplete.txt");
                for (int i = 0; i < incomplete.size(); i ++) {
                    fr2.write(String.valueOf(incomplete.get(i) + "\n"));
                }
                fr2.close();

            }

            System.out.println("The project has been successfully added");
            System.out.println("");


        } catch (InputMismatchException e) {  // user will be notified about incorrect data entries and returned to main menu
            System.out.println("Incorrect data entered. Please try again");
        }

    }
    // This method will be called once a user selects the edit project option
    public static void editProj() throws ParseException {

        displayProj(); // Display projects for the user using this method
        System.out.println("");  // creating space for neat presentation
        int oldProj = 0;  // This will keep track of the index for the project that must be edited

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the project Number for the project you want to edit: ");
        int projectNum = input.nextInt();
        String projectNum2 = " " + projectNum;  // a version of the project number which is formatted as it would appear in my text file

        ArrayList<String> projects = (ArrayList<String>) projList();  // calling the list of projects
        ArrayList<String> incomplete = incompleteProjects();  // calling the list of incomplete projects
        ArrayList<String> myList = new ArrayList<>(); // This arraylist will store the project that needs to be edited

        // I am going to split this project file so that I can access individual indexes
        for (int i = 0; i < projects.size(); i ++) {
            String proj = projects.get(i);
            String [] proj1 = proj.split(",");
            proj1[10] = proj1[10].strip();  // removing all spaces next to the number

            if (projectNum == Integer.parseInt(proj1[10])) {  // if the project number matches index 10 (project numbers)
                oldProj = i;  // stores the index for the project that will be edited
                for (int x = 0; x < proj1.length; x ++) {
                    myList.add(proj1[x]);  // adding this project to my new arraylist
                }
            }
        }
        /*
         This block of code will move everything into an array to display the selected project.
         The user will then select which aspect of the project they would like to edit
        */
        String [] display = new String[11];
        for (int i = 0; i < myList.size(); i ++) {
            display[i] = myList.get(i);
        }
        System.out.println("You have selected Project Number - " + display[10]);
        System.out.println("");
        System.out.println("Project Number - " + display[10] + "\n" +
                "Project Name - " + display[0] + "\n" +
                "Building Type - " + display[1] + "\n" +
                "Project Address - " + display[2] + "\n" +
                "ERF Number - " + display[3] + "\n" +
                "Project Fee - " + display[4] + "\n" +
                "Amount Paid - " + display[5] + "\n" +
                "Project Deadline - " + display[6] + "\n" +
                "Customer Name - " + display[7] + "\n" +
                "Architect Name - " + display[8] + "\n" +
                "Contractor Name - " + display[9] + "\n");
        System.out.println("");
        System.out.println("Select the aspect of the project you would like to edit: " + "\n" +
                "(1)Project Name    (2)Building Type    (3)Address    (4)Project Fee    (5)Amount Paid" + "\n" +
                "(6)Deadline    (7)Customer Details    (8)Architect Details    (9)Contractor Details");

        try {
            int option = input.nextInt();

           // ArrayList<String> myList2 = new ArrayList<>();

            // Changing project name
            if (option == 1) {
                System.out.println("Enter new project name: ");
                String newProjName = input.next();
                newProjName += input.nextLine();

                display[0] = newProjName;  //changing the project name
                display[10] = projectNum2;  //fixing last index to match text file format
                String newProj = "";  // this empty string will be used to store the new edited project
                projects.remove(oldProj);  // removing the old unedited project from the project list
                for (int i = 0; i < (display.length - 1); i ++) {
                    newProj += display[i] + ",";  // t
                }
                newProj += projectNum2;  // adding the last index without a comma
                projects.add(newProj);  // adding the new project to the projects arraylist
                incomplete.add(newProj); // adding the new project to the incomplete projects list

                // writing back to the incomplete projects text file
                try {
                    FileWriter fr = new FileWriter("incomplete.txt");
                    for (int i = 0; i < incomplete.size(); i ++) {
                        fr.write(String.valueOf(incomplete.get(i) + "\n"));
                    }
                    fr.close();

                } catch (IOException e) {
                    System.out.println("This file does not exist");
                }


                // writing back to the projects text file
                try {
                    FileWriter fr = new FileWriter("projects.txt");
                    for (int x = 0; x < projects.size(); x ++) {
                        fr.write(String.valueOf(projects.get(x) + "\n"));
                    }
                    fr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("This file does not exist.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("The project's name has successfully been changed");
            }

            // changing the building type
            else if (option == 2) {
                System.out.println("Enter the new building type: ");
                String newBuilding = input.next();
                newBuilding += input.nextLine();

                display[1] = " " + newBuilding;
                display[10] = projectNum2;  //fixing last index
                String newProj = "";  // empty string which will be used to store the new edited project
                projects.remove(oldProj);  // removing the old unedited project
                for (int i = 0; i < (display.length - 1); i ++) {
                    newProj += display[i] + ",";
                }
                newProj += projectNum2;  // adding the last index without a comma
                projects.add(newProj);  // adding the new project to the projects arraylist
                incomplete.add(newProj); // adding the new project to the incomplete projects list

                // writing back to the incomplete projects text file
                try {
                    FileWriter fr = new FileWriter("incomplete.txt");
                    for (int i = 0; i < incomplete.size(); i ++) {
                        fr.write(String.valueOf(incomplete.get(i) + "\n"));
                    }
                    fr.close();

                } catch (IOException e) {
                    System.out.println("This file does not exist");
                }

                // writing back to the projects text file
                try {
                    FileWriter fr = new FileWriter("projects.txt");
                    for (int x = 0; x < projects.size(); x ++) {
                        fr.write(String.valueOf(projects.get(x) + "\n"));
                    }
                    fr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("This file does not exist.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("The building type has successfully been changed.");
            }

            // new project address
            else if (option == 3) {
                System.out.println("Enter the new address for the project: ");
                String newAddress = input.next();
                newAddress += input.nextLine();

                display[2] = " " + newAddress;
                display[10] = projectNum2;  //fixing last index
                String newProj = "";  // empty string which will be used to store the new edited project
                projects.remove(oldProj);  // removing the old unedited project
                for (int i = 0; i < (display.length - 1); i ++) {
                    newProj += display[i] + ",";
                }
                newProj += projectNum2;  // adding the last index without a comma
                projects.add(newProj);  // adding the new project to the projects arraylist
                incomplete.add(newProj); // adding the new project to the incomplete projects list

                // writing back to the incomplete projects text file
                try {
                    FileWriter fr = new FileWriter("incomplete.txt");
                    for (int i = 0; i < incomplete.size(); i ++) {
                        fr.write(String.valueOf(incomplete.get(i) + "\n"));
                    }
                    fr.close();

                } catch (IOException e) {
                    System.out.println("This file does not exist");
                }


                // writing back to the projects text file
                try {
                    FileWriter fr = new FileWriter("projects.txt");
                    for (int x = 0; x < projects.size(); x ++) {
                        fr.write(String.valueOf(projects.get(x) + "\n"));
                    }
                    fr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("This file does not exist.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("The project address has successfully been changed.");
            }

            // Changing the project fee
            else if (option == 4) {
                System.out.println("Enter the the new project fee: ");
                String newFee = input.next();
                newFee += input.nextLine();

                display[4] = " " + newFee;
                display[10] = projectNum2;  //fixing last index
                String newProj = "";  // empty string which will be used to store the new edited project
                projects.remove(oldProj);  // removing the old unedited project
                for (int i = 0; i < (display.length - 1); i ++) {
                    newProj += display[i] + ",";
                }
                newProj += projectNum2;  // adding the last index without a comma
                projects.add(newProj);  // adding the new project to the projects arraylist
                incomplete.add(newProj); // adding the new project to the incomplete projects list

                // writing back to the incomplete projects text file
                try {
                    FileWriter fr = new FileWriter("incomplete.txt");
                    for (int i = 0; i < incomplete.size(); i ++) {
                        fr.write(String.valueOf(incomplete.get(i) + "\n"));
                    }
                    fr.close();

                } catch (IOException e) {
                    System.out.println("This file does not exist");
                }


                // writing back to the projects text file
                try {
                    FileWriter fr = new FileWriter("projects.txt");
                    for (int x = 0; x < projects.size(); x ++) {
                        fr.write(String.valueOf(projects.get(x) + "\n"));
                    }
                    fr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("This file does not exist.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("The project fee has successfully been changed.");
            }

            // updating the paid amount
            else if (option == 5) {
                System.out.println("Enter the new amount that has been paid: ");
                String newPaidAmount = input.next();
                newPaidAmount += input.nextLine();

                display[5] = " " + newPaidAmount;
                display[10] = projectNum2;  //fixing last index
                String newProj = "";  // empty string which will be used to store the new edited project
                projects.remove(oldProj);  // removing the old unedited project
                for (int i = 0; i < (display.length - 1); i ++) {
                    newProj += display[i] + ",";
                }
                newProj += projectNum2;  // adding the last index without a comma
                projects.add(newProj);  // adding the new project to the projects arraylist
                incomplete.add(newProj); // adding the new project to the incomplete projects list

                // writing back to the incomplete projects text file
                try {
                    FileWriter fr = new FileWriter("incomplete.txt");
                    for (int i = 0; i < incomplete.size(); i ++) {
                        fr.write(String.valueOf(incomplete.get(i) + "\n"));
                    }
                    fr.close();

                } catch (IOException e) {
                    System.out.println("This file does not exist");
                }

                // writing back to the projects text file
                try {
                    FileWriter fr = new FileWriter("projects.txt");
                    for (int x = 0; x < projects.size(); x ++) {
                        fr.write(String.valueOf(projects.get(x) + "\n"));
                    }
                    fr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("This file does not exist.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("The paid amount has successfully been changed.");
            }

            // changing the project deadline
            else if (option == 6) {
                System.out.println("Enter the new project deadline (YYYY-MM-DD): ");
                String date1 = input.next();
                date1 += input.nextLine();
                Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
                String newDeadline = new SimpleDateFormat("yyyy-MM-dd").format(date2);

                display[6] = " " + newDeadline;
                display[10] = projectNum2;  //fixing last index
                String newProj = "";  // empty string which will be used to store the new edited project
                projects.remove(oldProj);  // removing the old unedited project
                for (int i = 0; i < (display.length - 1); i ++) {
                    newProj += display[i] + ",";
                }
                newProj += projectNum2;  // adding the last index without a comma
                projects.add(newProj);  // adding the new project to the projects arraylist
                incomplete.add(newProj); // adding the new project to the incomplete projects list

                // writing back to the incomplete projects text file
                try {
                    FileWriter fr = new FileWriter("incomplete.txt");
                    for (int i = 0; i < incomplete.size(); i ++) {
                        fr.write(String.valueOf(incomplete.get(i) + "\n"));
                    }
                    fr.close();

                } catch (IOException e) {
                    System.out.println("This file does not exist");
                }


                // writing back to the projects text file
                try {
                    FileWriter fr = new FileWriter("projects.txt");
                    for (int x = 0; x < projects.size(); x ++) {
                        fr.write(String.valueOf(projects.get(x) + "\n"));
                    }
                    fr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("This file does not exist.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("The project deadline has successfully been updated.");
            }

            // changing customer details
            else if (option == 7) {
                String customerName = changeCustomer(projectNum);  // call customer change method & return the name

                if (customerName != "") {  // if the above method returns a name we will update the name in projects

                    display[7] = " " + customerName;
                    display[10] = projectNum2;  //fixing last index
                    String newProj = "";  // empty string which will be used to store the new edited project
                    projects.remove(oldProj);  // removing the old unedited project
                    for (int i = 0; i < (display.length - 1); i ++) {
                        newProj += display[i] + ",";
                    }
                    newProj += projectNum2;  // adding the last index without a comma
                    projects.add(newProj);  // adding the new project to the projects arraylist
                    incomplete.add(newProj); // adding the new project to the incomplete projects list

                    // writing back to the incomplete projects text file
                    try {
                        FileWriter fr = new FileWriter("incomplete.txt");
                        for (int i = 0; i < incomplete.size(); i ++) {
                            fr.write(String.valueOf(incomplete.get(i) + "\n"));
                        }
                        fr.close();

                    } catch (IOException e) {
                        System.out.println("This file does not exist");
                    }


                    // writing back to the projects text file
                    try {
                        FileWriter fr = new FileWriter("projects.txt");
                        for (int x = 0; x < projects.size(); x ++) {
                            fr.write(String.valueOf(projects.get(x) + "\n"));
                        }
                        fr.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("This file does not exist.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("The customer's details have successfully been changed.");
                }
            }

            // changing the architect's details
            else if (option == 8) {

                String architectName = changeArchitect(projectNum);
                if (architectName != "") {  // if the above method returns a name we will update the name in projects

                    display[8] = " " + architectName;
                    display[10] = projectNum2;  //fixing last index
                    String newProj = "";  // empty string which will be used to store the new edited project
                    projects.remove(oldProj);  // removing the old unedited project
                    for (int i = 0; i < (display.length - 1); i ++) {
                        newProj += display[i] + ",";
                    }
                    newProj += projectNum2;  // adding the last index without a comma
                    projects.add(newProj);  // adding the new project to the projects arraylist
                    incomplete.add(newProj); // adding the new project to the incomplete projects list

                    // writing back to the incomplete projects text file
                    try {
                        FileWriter fr = new FileWriter("incomplete.txt");
                        for (int i = 0; i < incomplete.size(); i ++) {
                            fr.write(String.valueOf(incomplete.get(i) + "\n"));
                        }
                        fr.close();

                    } catch (IOException e) {
                        System.out.println("This file does not exist");
                    }


                    // writing back to the projects text file
                    try {
                        FileWriter fr = new FileWriter("projects.txt");
                        for (int x = 0; x < projects.size(); x ++) {
                            fr.write(String.valueOf(projects.get(x) + "\n"));
                        }
                        fr.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("This file does not exist.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("The architect's details have successfully been changed.");
            }

            // changing the contractor's details
            else if (option == 9) {

                String contractorName = changeContractor(projectNum);

                if (contractorName != "") { // if the above method returns a name we will update the name in projects

                    display[8] = " " + contractorName;
                    display[10] = projectNum2;  //fixing last index
                    String newProj = "";  // empty string which will be used to store the new edited project
                    projects.remove(oldProj);  // removing the old unedited project
                    for (int i = 0; i < (display.length - 1); i ++) {
                        newProj += display[i] + ",";
                    }
                    newProj += projectNum2;  // adding the last index without a comma
                    projects.add(newProj);  // adding the new project to the projects arraylist
                    incomplete.add(newProj); // adding the new project to the incomplete projects list

                    // writing back to the incomplete projects text file
                    try {
                        FileWriter fr = new FileWriter("incomplete.txt");
                        for (int i = 0; i < incomplete.size(); i ++) {
                            fr.write(String.valueOf(incomplete.get(i) + "\n"));
                        }
                        fr.close();

                    } catch (IOException e) {
                        System.out.println("This file does not exist");
                    }


                    // writing back to the projects text file
                    try {
                        FileWriter fr = new FileWriter("projects.txt");
                        for (int x = 0; x < projects.size(); x ++) {
                            fr.write(String.valueOf(projects.get(x) + "\n"));
                        }
                        fr.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("This file does not exist.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("The contractor's details have successfully been changed.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Incorrect data entered. Please try again.");;
        }
    }

    /*
    This method will be called when a user wants to change the architect's details.
    This method will also return a string (name)
     */
    public static String changeArchitect(int projectNum) {

        ArrayList<String> architects = (ArrayList<String>) architectList();
        ArrayList<String> myList = new ArrayList<>(); // This arraylist will store the architect that needs to be edited
        int oldArch = 0;  // Will store the index for the old architect that will be edited
        String projectNum2 = " " + projectNum;
        String newName = "";  // if the architect's name needs to be changed, it will be stored in this string


        for (int i = 0; i < architects.size(); i ++) {
            String arch = architects.get(i);
            String [] arch1 = arch.split(",");
            arch1[4] = arch1[4].strip();  // removing the space next to the number for comparison with project number

            if (projectNum == Integer.parseInt(arch1[4])) {  // if the project number matches index 10 (project numbers)
                oldArch = i;  // keeps track of the index for the project that will be edited
                for (int x = 0; x < arch1.length; x ++) {
                    myList.add(arch1[x]);  // adding this project to my new arraylist
                }
            }
        }
        String[] display = new String[5];
        for (int i = 0; i < myList.size(); i ++) {
            display[i] = myList.get(i);
        }
        // Displaying the relevant architect
        System.out.println("The architect for this project is " + display[0] + ".");
        System.out.println("-----Information-----\n");
        System.out.println("" +
                "Architect Name - " + display[0] + "\n" +
                "Architect Telephone - " + display[1] + "\n" +
                "Architect email - " + display[2] + "\n" +
                "Architect address - " + display[3] + "\n"
        );
        System.out.println("Select which aspect of the architect you would like to edit: \n" +
                "(1)Name    (2)Telephone    (3)Email    (4)Address.  ");

        Scanner input = new Scanner(System.in);

        try {
            int option = input.nextInt();

            // changing name
            if (option == 1) {
                System.out.println("Enter the new FIRST NAME for the architect: ");
                String firstName = input.next();
                System.out.println("Enter the new SURNAME for the architect: ");
                String surName = input.next();
                newName = firstName + " " + surName;

                display[0] = newName;  // updating the architect's name
                display[4] = projectNum2;  //fixing last index
                String newArch = "";  // empty string which will be used to store the new edited architect
                architects.remove(oldArch);  // removing the old unedited project
                for (int i = 0; i < (display.length - 1); i ++) {
                    newArch += display[i] + ",";
                }
                newArch += projectNum2;  // adding the last index without a comma
                architects.add(newArch);  // adding the new architect to the architect arraylist

                // writing back to the architects text file
                try {
                    FileWriter fr = new FileWriter("architects.txt");
                    for (int x = 0; x < architects.size(); x ++) {
                        fr.write(String.valueOf(architects.get(x) + "\n"));
                    }
                    fr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("This file does not exist.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // change telephone
            else if (option == 2) {
                System.out.println("Enter the new telephone number: ");
                String newTelephone = input.next();
                newTelephone += input.nextLine();

                display[1] = " " + newTelephone;
                display[4] = projectNum2;
                String newArch = "";  // empty string which will be used to store the new edited architect
                architects.remove(oldArch);  // removing the old unedited project
                for (int i = 0; i < (display.length - 1); i ++) {
                    newArch += display[i] + ",";
                }
                newArch += projectNum2;  // adding the last index without a comma
                architects.add(newArch); // adding the new architect to the architect arraylist

                // writing back to the architects text file
                try {
                    FileWriter fr = new FileWriter("architects.txt");
                    for (int x = 0; x < architects.size(); x ++) {
                        fr.write(String.valueOf(architects.get(x) + "\n"));
                    }
                    fr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("This file does not exist.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // changing email
            else if (option == 3) {
                System.out.println("Enter the new email address: ");
                String newEmail = input.next();
                newEmail += input.nextLine();

                display[2] = " " + newEmail;
                display[4] = projectNum2;
                String newArch = "";  // empty string which will be used to store the new edited architect
                architects.remove(oldArch);  // removing the old unedited project
                for (int i = 0; i < (display.length - 1); i ++) {
                    newArch += display[i] + ",";
                }
                newArch += projectNum2;  // adding the last index without a comma
                architects.add(newArch);  // adding the new architect to the architect arraylist

                // writing back to the architects text file
                try {
                    FileWriter fr = new FileWriter("architects.txt");
                    for (int x = 0; x < architects.size(); x ++) {
                        fr.write(String.valueOf(architects.get(x) + "\n"));
                    }
                    fr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("This file does not exist.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // changing address
            else if (option == 4) {
                System.out.println("Enter the architect's new address: ");
                String newAddress = input.next();
                newAddress += input.nextLine();

                display[3] = " " + newAddress;
                display[4] = projectNum2;
                String newArch = "";  // empty string which will be used to store the new edited architect
                architects.remove(oldArch);  // removing the old unedited project
                for (int i = 0; i < (display.length - 1); i ++) {
                    newArch += display[i] + ",";
                }
                newArch += projectNum2;  // adding the last index without a comma
                architects.add(newArch);  // adding the new architect to the architect arraylist

                // writing back to the architects text file
                try {
                    FileWriter fr = new FileWriter("architects.txt");
                    for (int x = 0; x < architects.size(); x ++) {
                        fr.write(String.valueOf(architects.get(x) + "\n"));
                    }
                    fr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("This file does not exist.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Incorrect data entered. Please try again.");;
        }
        return newName;
    }

    /*
    This method will be called when a user wants to change the customer's details.
    This method will also return a string (name)
    */
    public static String changeCustomer(int projectNum) {

        ArrayList<String> customers = (ArrayList<String>) customerList();
        ArrayList<String> myList = new ArrayList<>(); // This arraylist will store the customer that needs to be edited
        int oldCust = 0;  // will store the index of the project that needs to be removed
        String projectNum2 = " " + projectNum;
        String newName = "";


        for (int i = 0; i < customers.size(); i ++) {
            String cust = customers.get(i);
            String [] cust1 = cust.split(",");
            cust1[4] = cust1[4].strip();  // removing the space next to the number

            if (projectNum == Integer.parseInt(cust1[4])) {  // if the project number matches index 10 (project numbers)
                oldCust = i;  // keeps track of the index for the project that will be edited
                for (int x = 0; x < cust1.length; x ++) {
                    myList.add(cust1[x]);  // adding this project to my new arraylist
                }
            }
        }
        String[] display = new String[5];
        for (int i = 0; i < myList.size(); i ++) {
            display[i] = myList.get(i);
        }

        System.out.println("The customer for this project is " + display[0] + ".");
        System.out.println("-----Information-----\n");
        System.out.println("" +
                "Customer Name - " + display[0] + "\n" +
                "Customer Telephone - " + display[1] + "\n" +
                "Customer email - " + display[2] + "\n" +
                "Customer address - " + display[3] + "\n"
        );
        System.out.println("Select which aspect of the customer you would like to edit: \n" +
                "(1)Name    (2)Telephone    (3)Email    (4)Address.  ");

        Scanner input = new Scanner(System.in);

        try {

            int option = input.nextInt();

            // changing name
            if (option == 1) {
                System.out.println("Enter the new FIRST NAME for the customer: ");
                String firstName = input.next();
                System.out.println("Enter the new SURNAME for the customer: ");
                String surName = input.next();
                newName = firstName + " " + surName;

                display[0] = newName;
                display[4] = projectNum2;  //fixing last index
                String newCust = "";  // empty string which will be used to store the new edited customer
                customers.remove(oldCust);  // removing the old unedited project
                for (int i = 0; i < (display.length - 1); i ++) {
                    newCust += display[i] + ",";
                }
                newCust += projectNum2;  // adding the last index without a comma
                customers.add(newCust);  // adding the new customer to the customers arraylist

                // writing back to the customers text file
                try {
                    FileWriter fr = new FileWriter("customers.txt");
                    for (int x = 0; x < customers.size(); x ++) {
                        fr.write(String.valueOf(customers.get(x) + "\n"));
                    }
                    fr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("This file does not exist.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // change telephone
            else if (option == 2) {
                System.out.println("Enter the new telephone number: ");
                String newTelephone = input.next();
                newTelephone += input.nextLine();

                display[1] = " " +newTelephone;
                display[4] = projectNum2;
                String newCust = "";  // empty string which will be used to store the new edited architect
                customers.remove(oldCust);  // removing the old unedited project
                for (int i = 0; i < (display.length - 1); i ++) {
                    newCust += display[i] + ",";
                }
                newCust += projectNum2;  // adding the last index without a comma
                customers.add(newCust);   // adding the new customer to the customers arraylist

                // writing back to the customers text file
                try {
                    FileWriter fr = new FileWriter("customers.txt");
                    for (int x = 0; x < customers.size(); x ++) {
                        fr.write(String.valueOf(customers.get(x) + "\n"));
                    }
                    fr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("This file does not exist.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // change email
            else if (option == 3) {
                System.out.println("Enter the new email address: ");
                String newEmail = input.next();
                newEmail += input.nextLine();

                display[2] = " " + newEmail;
                display[4] = projectNum2;
                String newCust = "";  // empty string which will be used to store the new edited architect
                customers.remove(oldCust);  // removing the old unedited project
                for (int i = 0; i < (display.length - 1); i ++) {
                    newCust += display[i] + ",";
                }
                newCust += projectNum2;   // adding the last index without a comma
                customers.add(newCust);   // adding the new customer to the customers arraylist

                // writing back to the customers text file
                try {
                    FileWriter fr = new FileWriter("customers.txt");
                    for (int x = 0; x < customers.size(); x ++) {
                        fr.write(String.valueOf(customers.get(x) + "\n"));
                    }
                    fr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("This file does not exist.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // change address
            else if (option == 4) {
                System.out.println("Enter the customer's new address: ");
                String newAddress = input.next();
                newAddress += input.nextLine();

                display[3] = " " + newAddress;
                display[4] = projectNum2;
                String newCust = "";  // empty string which will be used to store the new edited architect
                customers.remove(newCust);  // removing the old unedited project
                for (int i = 0; i < (display.length - 1); i ++) {
                    newCust += display[i] + ",";
                }
                newCust += projectNum2;  // adding the last index without a comma
                customers.add(newCust);   // adding the new customer to the customers arraylist

                // writing back to the customers text file
                try {
                    FileWriter fr = new FileWriter("customers.txt");
                    for (int x = 0; x < customers.size(); x ++) {
                        fr.write(String.valueOf(customers.get(x) + "\n"));
                    }
                    fr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("This file does not exist.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Incorrect data entered. Please try again.");
        }
        return newName;
    }

    /*
    This method will be called when a user wants to change the contractor's details.
    This method will also return a string (name)
    */
    public static String changeContractor(int projectNum) {

        ArrayList<String> contractors = (ArrayList<String>) contractorList();
        ArrayList<String> myList = new ArrayList<>(); // This arraylist will store the contractor that needs to be edited
        int oldCont = 0;
        String projectNum2 = " " + projectNum;
        String newName = "";


        for (int i = 0; i < contractors.size(); i ++) {
            String cont = contractors.get(i);
            String [] cont1 = cont.split(",");
            cont1[4] = cont1[4].strip();  // removing the space next to the number

            if (projectNum == Integer.parseInt(cont1[4])) {  // if the project number matches index 10 (project numbers)
                oldCont = i;  // keeps track of the index for the project that will be edited
                for (int x = 0; x < cont1.length; x ++) {
                    myList.add(cont1[x]);  // adding this project to my new arraylist
                }
            }
        }
        String[] display = new String[5];
        for (int i = 0; i < myList.size(); i ++) {
            display[i] = myList.get(i);
        }

        System.out.println("The contractor for this project is " + display[0] + ".");
        System.out.println("-----Information-----\n");
        System.out.println("" +
                "Contractor Name - " + display[0] + "\n" +
                "Contractor Telephone - " + display[1] + "\n" +
                "Contractor email - " + display[2] + "\n" +
                "Contractor address - " + display[3] + "\n"
        );
        System.out.println("Select which aspect of the contractor you would like to edit: \n" +
                "(1)Name    (2)Telephone    (3)Email    (4)Address.  ");

        Scanner input = new Scanner(System.in);

        try {

            int option = input.nextInt();

            // changing name
            if (option == 1) {
                System.out.println("Enter the new FIRST NAME for the contractor: ");
                String firstName = input.next();
                System.out.println("Enter the new SURNAME for the contractor: ");
                String surName = input.next();
                newName = firstName + " " + surName;

                display[0] = newName;
                display[4] = projectNum2;  //fixing last index
                String newCont = "";  // empty string which will be used to store the new edited contractor
                contractors.remove(oldCont);  // removing the old unedited project
                for (int i = 0; i < (display.length - 1); i ++) {
                    newCont += display[i] + ",";
                }
                newCont += projectNum2;  // adding the last index without a comma
                contractors.add(newCont);  // adding the new contractor to the contractors arraylist

                // writing back to the contractors text file
                try {
                    FileWriter fr = new FileWriter("contractors.txt");
                    for (int x = 0; x < contractors.size(); x ++) {
                        fr.write(String.valueOf(contractors.get(x) + "\n"));
                    }
                    fr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("This file does not exist.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // change telephone
            else if (option == 2) {
                System.out.println("Enter the new telephone number: ");
                String newTelephone = input.next();
                newTelephone += input.nextLine();

                display[1] = " " +newTelephone;
                display[4] = projectNum2;
                String newCont = "";  // empty string which will be used to store the new edited contractor
                contractors.remove(oldCont);  // removing the old unedited contractor
                for (int i = 0; i < (display.length - 1); i ++) {
                    newCont += display[i] + ",";
                }
                newCont += projectNum2;  // adding the last index without a comma
                contractors.add(newCont);  // adding the new contractor to the contractors arraylist

                // writing back to the projects text file
                try {
                    FileWriter fr = new FileWriter("contractors.txt");
                    for (int x = 0; x < contractors.size(); x ++) {
                        fr.write(String.valueOf(contractors.get(x) + "\n"));
                    }
                    fr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("This file does not exist.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // change email
            else if (option == 3) {
                System.out.println("Enter the new email address: ");
                String newEmail = input.next();
                newEmail += input.nextLine();

                display[2] = " " + newEmail;
                display[4] = projectNum2;
                String newCont = "";  // empty string which will be used to store the new edited contractor
                contractors.remove(oldCont);  // removing the old unedited project
                for (int i = 0; i < (display.length - 1); i ++) {
                    newCont += display[i] + ",";
                }
                newCont += projectNum2;  // adding the last index without a comma
                contractors.add(newCont);  // adding the new contractor to the contractors arraylist

                // writing back to the contractors text file
                try {
                    FileWriter fr = new FileWriter("contractors.txt");
                    for (int x = 0; x < contractors.size(); x ++) {
                        fr.write(String.valueOf(contractors.get(x) + "\n"));
                    }
                    fr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("This file does not exist.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // change address
            else if (option == 4) {
                System.out.println("Enter the contractor's new address: ");
                String newAddress = input.next();
                newAddress += input.nextLine();

                display[3] = " " + newAddress;
                display[4] = projectNum2;
                String newCont = "";  // empty string which will be used to store the new edited architect
                contractors.remove(newCont);  // removing the old unedited project
                for (int i = 0; i < (display.length - 1); i ++) {
                    newCont += display[i] + ",";
                }
                newCont += projectNum2;  // adding the last index without a comma
                contractors.add(newCont);  // adding the new contractor to the contractors arraylist

                // writing back to the contractors text file
                try {
                    FileWriter fr = new FileWriter("contractors.txt");
                    for (int x = 0; x < contractors.size(); x ++) {
                        fr.write(String.valueOf(contractors.get(x) + "\n"));
                    }
                    fr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("This file does not exist.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Incorrect data entered. Please try again.");
        }

        return newName;
    }

    // This method will show the user all the projects which are past their due date
    public static void lateProjects() throws ParseException {

        ArrayList<String> projects = (ArrayList<String>) projList();
        ArrayList<String> late = new ArrayList<>();

        LocalDate d1 = LocalDate.now(); // today's date
        String today2 = "";  // empty string I will store the date in
        today2 += d1;
        Date today = new  SimpleDateFormat("yyyy-MM-dd").parse(today2);  // changing the date to match my Date format

        System.out.println("-----PROJECTS PAST THEIR DUE DATE-----\n");
        for (int i = 0; i < projects.size(); i ++) {
            String proj = projects.get(i);
            String [] proj1 = proj.split(",");
            proj1[6] = proj1[6].strip();  // removing the space next to the date
            Date projDate = new  SimpleDateFormat("yyyy-MM-dd").parse(proj1[6]);

            // showing all the late projects

            if (projDate.compareTo(today) < 0) {
                System.out.println( "Project Number - " + proj1[10] + "\n" +
                        "Project Name - " + proj1[0] + "\n" +
                        "Building Type - " + proj1[1] + "\n" +
                        "Project Address - " + proj1[2] + "\n" +
                        "ERF Number - " + proj1[3] + "\n" +
                        "Project Fee - " + proj1[4] + "\n" +
                        "Amount Paid - " + proj1[5] + "\n" +
                        "Project Deadline - " + proj1[6] + "\n" +
                        "Customer Name - " + proj1[7] + "\n" +
                        "Architect Name - " + proj1[8] + "\n" +
                        "Contractor Name - " + proj1[9] + "\n");
            }
        }
    }

    // This method will generate an invoice if a project has not been fully paid or finalize a project if it has
    public static void generateInvoice() throws IOException {

        try {

            displayProj(); // show all the projects to the user
            System.out.println("Enter the project number for the project you would like to finalize: ");
            Scanner input = new Scanner(System.in);
            int projectNum = input.nextInt();

            ArrayList<String> projects = (ArrayList<String>) projList();  // calling the list of projects
            ArrayList<String> myList = new ArrayList<>(); // This arraylist will store the project that needs to be edited
            int completedProj = 0;  // index for completed project
            ArrayList<String> incompleteProjects = incompleteProjects();

            for (int i = 0; i < projects.size(); i ++) {
                String proj = projects.get(i);
                String [] proj1 = proj.split(",");
                proj1[10] = proj1[10].strip();  // removing the space next to the number

                if (projectNum == Integer.parseInt(proj1[10])) {  // if the project number matches index 10 (project numbers)
                    completedProj = i;
                    for (int x = 0; x < proj1.length; x ++) {
                        myList.add(proj1[x]);  // adding this project to my new arraylist
                    }
                }
            }
            String [] project1 = new String[11];
            for (int i = 0; i < myList.size(); i ++) {
                project1[i] = myList.get(i);
            }

            String projTotal = project1[4].strip();
            String projPaid = project1[5].strip();
            double owed = Double.parseDouble(projTotal) - Double.parseDouble(projPaid);
            String owed2 = String.format("%.2f", owed); // for displaying to 2 decimal places

            // no money owed
            if (owed <= 0) {
                ArrayList<String> completedProjects = (ArrayList<String>) completedList();
                ArrayList<String> incomplete = incompleteProjects();
                int oldProj = 0;

                for (int i = 0; i < incomplete.size(); i ++) {
                    String incom = incomplete.get(i);
                    String [] incom1 = incom.split(",");
                    incom1[10] = incom1[10].strip();  // removing the space next to the number

                    if (projectNum == Integer.parseInt(incom1[10])) {  // if the project number matches index 10 (project numbers)
                        oldProj = i;  // keeps track of the index for the project that will be edited
                    }
                }

                incomplete.remove(oldProj); // removing project from incomplete list
                FileWriter wr = new FileWriter("incomplete.txt");
                for (int i = 0; i < incomplete.size(); i ++) {
                    wr.write(String.valueOf(incomplete.get(i) + "\n"));
                }
                wr.close();


                String complete1 = "";  // empty string that will hold the project
                complete1 += projects.get(completedProj);  // adding the project to the empty string
                LocalDate today = LocalDate.now();
                String today2 = "";
                today2 += today;  // turning today's date into a string
                complete1 += ", " + today2;  // adding today's date to string
                completedProjects.add(complete1);  // adding project to completed projects list
                projects.remove(completedProj); // removing project from projects list now that it has been completed

                // writing to the completed projects file
                FileWriter fr = new FileWriter("completed.txt");
                for (int i = 0; i < completedProjects.size(); i ++) {
                    fr.write(String.valueOf(completedProjects.get(i)) + "\n");
                }
                fr.close();

                FileWriter fr2 = new FileWriter("projects.txt");
                for (int i = 0; i < projects.size(); i ++) {
                    fr2.write(String.valueOf(projects.get(i) + "\n"));
                }
                fr2.close();
                System.out.println("This project has been finalised.");
            }

            // some money owed
            else if (owed > 0) {

                ArrayList<String> customers = (ArrayList<String>) customerList();  // arraylist of customers
                ArrayList<String> completedProjects = (ArrayList<String>) completedList();  // arraylist of completed projects
                ArrayList<String> incomplete = incompleteProjects();  // arraylist of incomplete projects
                ArrayList<String>  customer = new ArrayList<>();  // empty arraylist which will store the finalised customer
                int oldProj = 0;

                for (int i = 0; i < customers.size(); i ++) {
                    String cust = customers.get(i);
                    String [] cust1 = cust.split(",");
                    cust1[4] = cust1[4].strip();  // removing the space next to the number

                    if (projectNum == Integer.parseInt(cust1[4])) {  // if the project number matches index 10 (project numbers)
                        oldProj = i; // keeps track of the index for the project that will be edited
                        for (int x = 0; x < cust1.length; x ++) {
                            customer.add(cust1[x]);  // adding this project to my new arraylist
                        }
                    }
                }

                // storing the customer's details into an array for easy display on the invoice
                String[] customer2 = new String[5];
                for (int i = 0; i < customer.size(); i ++) {
                    customer2[i] = customer.get(i);
                }

                // removing project fom incomplete file
                incomplete.remove(oldProj); // removing project from incomplete list
                FileWriter wr = new FileWriter("incomplete.txt");
                for (int i = 0; i < incomplete.size(); i ++) {
                    wr.write(String.valueOf(incomplete.get(i) + "\n"));
                }
                wr.close();

                // storing completed projected into a string to add it into the completed projects file
                String complete1 = "";  // empty string that will hold the project
                complete1 += projects.get(completedProj);  // adding the project to the empty string
                LocalDate today = LocalDate.now();
                String today2 = "";
                today2 += today;  // turning today's date into a string
                complete1 += ", " + today2;  // adding today's date to string
                completedProjects.add(complete1);  // adding project to completed projects list
                projects.remove(completedProj); // removing project from projects list now that it has been completed

                // writing to the completed projects file
                FileWriter fr = new FileWriter("completed.txt");
                for (int i = 0; i < completedProjects.size(); i ++) {
                    fr.write(String.valueOf(completedProjects.get(i)) + "\n");
                }
                fr.close();

                // updating the projects file
                FileWriter fr2 = new FileWriter("projects.txt");
                for (int i = 0; i < projects.size(); i ++) {
                    fr2.write(String.valueOf(projects.get(i) + "\n"));
                }
                fr2.close();
                System.out.println("This project has been finalised.");

                // showing customer invoice
                System.out.println(
                        "        -----Customer Invoice-----\n" +
                                "NAME - " + customer2[0] + "|| TEL - " + customer2[1] + "\n" +
                                "EMAIL - " + customer2[2] + "|| ADDRESS - " + customer2[3] + "\n" +
                                "Total cost - R" + projTotal + "\n" +
                                "Total paid - R" + projPaid + "\n" +
                                "TOTAL OWED - R" + owed2);
            }

        } catch (InputMismatchException e) {
            System.out.println("Incorrect data entered. Please try again.");
        }

    }

    // This method will display all the incomplete projects
    public static void displayIncomplete() {

        ArrayList<String> incomplete = (ArrayList<String>) incompleteProjects();

        System.out.println("-----All Incomplete Projects-----");
        for (int i = 0; i < incomplete.size(); i ++) {
            String proj = incomplete.get(i);

            // By turning the project list into an array I am able to easily access the indexes and manipulate the data
            String [] proj1 = proj.split(",");
            System.out.println(
                            "Project Number - " + proj1[10] + "\n" +
                            "Project Name - " + proj1[0] + "\n" +
                            "Building Type - " + proj1[1] + "\n" +
                            "Project Address - " + proj1[2] + "\n" +
                            "ERF Number - " + proj1[3] + "\n" +
                            "Project Fee - " + proj1[4] + "\n" +
                            "Amount Paid - " + proj1[5] + "\n" +
                            "Project Deadline - " + proj1[6] + "\n" +
                            "Customer Name - " + proj1[7] + "\n" +
                            "Architect Name - " + proj1[8] + "\n" +
                            "Contractor Name - " + proj1[9] + "\n");
        }

    }
    // This method will display all the projects
    public static void displayProj() {

        ArrayList<String> projects = (ArrayList<String>) projList(); // calling the project list method
        System.out.println("-----All Projects-----");
        for (int i = 0; i < projects.size(); i ++) {
            String proj = projects.get(i);

            // By turning the project list into an array I am able to easily access the indexes and manipulate the data
            String [] proj1 = proj.split(",");
            System.out.println(
                            "Project Number - " + proj1[10] + "\n" +
                            "Project Name - " + proj1[0] + "\n" +
                            "Building Type - " + proj1[1] + "\n" +
                            "Project Address - " + proj1[2] + "\n" +
                            "ERF Number - " + proj1[3] + "\n" +
                            "Project Fee - " + proj1[4] + "\n" +
                            "Amount Paid - " + proj1[5] + "\n" +
                            "Project Deadline - " + proj1[6] + "\n" +
                            "Customer Name - " + proj1[7] + "\n" +
                            "Architect Name - " + proj1[8] + "\n" +
                            "Contractor Name - " + proj1[9] + "\n");
        }
    }
    // This method will display all the completed projects
    public static void displayComplete() {

        ArrayList<String> projects = (ArrayList<String>) completedList(); // calling the project list method
        System.out.println("-----All Completed Projects-----");

        for (int i = 0; i < projects.size(); i ++) {
            String proj = projects.get(i);

            // By turning the project list into an array I am able to easily access the indexes and manipulate the data
            String [] proj1 = proj.split(",");
            System.out.println("Project Number - " + proj1[10] + "|| Date Completed - " + proj1[11] + "\n" +
                            "Project Name - " + proj1[0] + "\n" +
                            "Building Type - " + proj1[1] + "\n" +
                            "Project Address - " + proj1[2] + "\n" +
                            "ERF Number - " + proj1[3] + "\n" +
                            "Project Fee - " + proj1[4] + "\n" +
                            "Amount Paid - " + proj1[5] + "\n" +
                            "Project Deadline - " + proj1[6] + "\n" +
                            "Customer Name - " + proj1[7] + "\n" +
                            "Architect Name - " + proj1[8] + "\n" +
                            "Contractor Name - " + proj1[9] + "\n");
        }
    }

    // Main
    public static void main(String args[]) throws ParseException, IOException {

        Scanner input = new Scanner(System.in);
        boolean logged = true;

        while (logged) {  // while loop will keep the program running
            System.out.println("");
            System.out.println("----Welcome, please select a menu item----\n" +
                    "a -     Add a new project\n" +
                    "ed -     Edit a project\n" +
                    "vl -    View all late projects\n" +
                    "f -     Finalize projects\n" +
                    "va -    View all projects\n" +
                    "vi -    View all incomplete projects\n" +
                    "vc -    View completed projects\n" +
                    "e -     Exit program");

            try {

                String option = input.next().toLowerCase();

                // adding a new project
                if (Objects.equals(option, "a")) {
                    newProject();
                }

                // editing a project
                else if (Objects.equals(option, "ed")) {
                    editProj();
                }

                // viewing incomplete projects
                else if (Objects.equals(option, "vi")) {
                    displayIncomplete();
                }

                // viewing overdue projects
                else if (Objects.equals(option, "vl")) {
                    lateProjects();
                }

                // finalizing a project
                else if (Objects.equals(option, "f")) {
                    generateInvoice();
                }

                // displaying all projects
                else if (Objects.equals(option, "va")) {
                    displayProj();
                }

                // displaying completed projects
                else if (Objects.equals(option, "vc")) {
                    displayComplete();
                }

                //exiting program
                else if (Objects.equals(option, "e")) {
                    System.out.println("Goodbye :)");
                    int e = 0;
                    System.exit(e);
                }

            } catch (ParseException e) {
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input, please try again.");
            }
        }
    }
}
