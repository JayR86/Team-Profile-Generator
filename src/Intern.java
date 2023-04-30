public class Intern extends TeamMember {
    private String school;

    public Intern(String name, int id, String email, String school) {
        super(name, id, email);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    @Override
    public String getHTML() {
        // This method overrides the getHTML method in TeamMember to add the manager's office number
        return "<div class=\"card\">\n" +
                "        <div class=\"card-header\">\n" +
                "          <div class=\"title\">" +
                getName() +
                "</div>\n" +
                "          <div class=\"subtitle\">\n" +
                "            <img src=\"img/intern.png\" alt=\"Icon\" />\n" +
                "            <h3>" + this.getClass().getSimpleName() + "</h3>\n" +
                "          </div>\n" +
                "        </div>\n" +
                "        <div class=\"card-body\">\n" +
                "          <ul>\n" +
                "            <li>ID: " + getId() + "</li>\n" +
                "            <li>Email: <a href=\"mailto:" + getEmail() + "\">" + getEmail() + "</a></li>\n" +
                "            <li>School : " + getSchool() +"</li>\n" +
                "          </ul>\n" +
                "        </div>\n" +
                "      </div>";
    }
}
