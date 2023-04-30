public class TeamMember {
    private String name;
    private int id;
    private String email;

    public TeamMember(String name, int id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getHTML() {
        // This method returns the HTML code for displaying the team member's information
        return "";
    }
}
