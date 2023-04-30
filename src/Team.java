import java.util.ArrayList;

public class Team {
    private Manager manager;
    private ArrayList<Engineer> engineers;
    private ArrayList<Intern> interns;

    public Team(Manager manager) {
        this.manager = manager;
        this.engineers = new ArrayList<>();
        this.interns = new ArrayList<>();
    }

    public Manager getManager() {
        return manager;
    }

    public ArrayList<Engineer> getEngineers() {
        return engineers;
    }

    public ArrayList<Intern> getInterns() {
        return interns;
    }

    public void addEngineer(Engineer engineer) {
        engineers.add(engineer);
    }

    public void addIntern(Intern intern) {
        interns.add(intern);
    }

    public String getHTML() {
        // This method returns the HTML code for displaying the entire team's information
        StringBuilder sb = new StringBuilder();
        sb.append(manager.getHTML()); // Add manager's information

        for (Engineer e : engineers) {
            sb.append(e.getHTML()); // Add each engineer's information
        }

        for (Intern i : interns) {
            sb.append(i.getHTML()); // Add each intern's information
        }

        return sb.toString();
    }
}