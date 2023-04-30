import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name, email, githubUsername, school, officeNumber;
        int id;

        // Get manager's information
        System.out.println("Enter the team manager's information:");
        System.out.print("Name: ");
        name = getValidString(input);
        System.out.print("ID: ");
        id = validateNumber(input);
        System.out.print("Email: ");
        email = getEmail(input);
        System.out.print("Office number: ");
        officeNumber = String.valueOf(validateNumber(input));

        // Create manager object
        Manager manager = new Manager(name, id, email, officeNumber);

        // Create team object
        Team team = new Team(manager);

        // Loop to add engineers or interns
        boolean addMore = true;
        while (addMore) {
            System.out.println("\nAdd an engineer or an intern, or finish building your team:");
            System.out.println("1. Engineer");
            System.out.println("2. Intern");
            System.out.println("3. Finish building my team");
            System.out.print("Enter your choice: ");

            int choice = 0;
            while (choice < 1 || choice > 3) {
                try {
                    choice = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e) {
                    System.out.print("Invalid choice. Please enter a valid number: ");
                    continue;
                }
                if (choice < 1 || choice > 3) {
                    System.out.print("Invalid choice. Please enter a number between 1 and 3: ");
                }
            }

            switch (choice) {
                case 1: // Add engineer
                    System.out.println("Enter the engineer's information:");
                    System.out.print("Name: ");
                    name = getValidString(input);
                    System.out.print("ID: ");
                    id = validateNumber(input);
                    System.out.print("Email: ");
                    email = getEmail(input);
                    System.out.print("GitHub username: ");
                    githubUsername = input.nextLine();

                    // Create engineer object and add to team
                    Engineer engineer = new Engineer(name, id, email, githubUsername);
                    team.addEngineer(engineer);
                    break;

                case 2: // Add intern
                    System.out.println("Enter the intern's information:");
                    System.out.print("Name: ");
                    name = getValidString(input);
                    System.out.print("ID: ");
                    id = validateNumber(input);
                    System.out.print("Email: ");
                    email = getEmail(input);
                    System.out.print("School: ");
                    school = input.nextLine();

                    // Create intern object and add to team
                    Intern intern = new Intern(name, id, email, school);
                    team.addIntern(intern);

                    break;

                case 3: // Finish building team
                    addMore = false;
                    break;

                default: // Invalid choice
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    break;
            }
        }

        // Generate HTML file
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "    <link href=\"style.css\" rel=\"stylesheet\" />\n" +
                "    <title>My Team</title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <header>\n" +
                "      <h1>My Team</h1>\n" +
                "    </header>\n" +
                "    <main>\n" +
                    team.getHTML() +
                "    </main>\n" +
                "  </body>\n" +
                "</html>\n";

        // Write HTML file
        try {
            FileWriter fileWriter = new FileWriter("team.html");
            fileWriter.write(html);
            fileWriter.close();
            System.out.println("HTML file generated successfully.");

            File file = new File("team.html");
            if (file.exists() && file.isFile()) {
                // open the file in the default browser
                try {
                    System.out.println("URL : " + file.toURI());
                    Desktop.getDesktop().browse(file.toURI());
                } catch (IOException e) {
                    System.out.println("Failed to open file in browser: " + e.getMessage());
                }
            } else {
                System.out.println("File does not exist or is not a file.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while generating the HTML file.");
            e.printStackTrace();
        }
    }

    public static String getEmail(Scanner scanner) {
        String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailPattern);

        while (true) {
            String email = scanner.nextLine().trim();
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return email;
            } else {
                System.out.print("Invalid email address, please try again: ");
            }
        }
    }

    public static String getValidString(Scanner scanner) {
        String input;
        boolean isValid = false;
        while (!isValid) {
            input = scanner.nextLine();
            if (input.matches("^[a-zA-Z]+(\\s[a-zA-Z]+)*$")) {
                isValid = true;
                String[] words = input.toLowerCase().split("\\s");
                StringBuilder sb = new StringBuilder();
                for (String word : words) {
                    sb.append(word.substring(0, 1).toUpperCase() + word.substring(1)).append(" ");
                }
                return sb.toString().trim();
            }
            System.out.print("Invalid input. Please enter alphabetical characters only: ");
        }
        return null;
    }


    public static int validateNumber(Scanner scanner) {
        int number = 0;
        boolean validInput = false;
        while (!validInput) {
            String input = scanner.nextLine();
            try {
                number = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a valid number: ");
            }
        }

        return number;
    }


    public static String getValidPhoneNumber(Scanner scanner) {
        String phoneNumber = "";
        boolean valid = false;

        while (!valid) {
            phoneNumber = scanner.nextLine();
            if (phoneNumber.matches("[0-9]+") && phoneNumber.length() == 10) {
                valid = true;
            } else {
                System.out.print("Invalid phone number. Please enter 10 digits only: ");
            }
        }

//         Format the phone number as (XXX) XXX-XXXX
        String formattedPhoneNumber = "(" + phoneNumber.substring(0, 3) + ") " +
                phoneNumber.substring(3, 6) + "-" +
                phoneNumber.substring(6);
        return formattedPhoneNumber;
    }

}