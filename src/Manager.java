public class Manager extends TeamMember {
    private String officeNumber;

    public Manager(String name, int id, String email, String officeNumber) {
        super(name, id, email);
        this.officeNumber = officeNumber;
    }

    public String getOfficeNumber() {
        return officeNumber;
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
                "            <img src=\"img/manager.png\" alt=\"Icon\" />\n" +
                "            <h3>" + this.getClass().getSimpleName() + "</h3>\n" +
                "          </div>\n" +
                "        </div>\n" +
                "        <div class=\"card-body\">\n" +
                "          <ul>\n" +
                "            <li>ID: " + getId() + "</li>\n" +
                "            <li>Email: <a href=\"mailto:" + getEmail() + "\">" + getEmail() + "</a></li>\n" +
                "            <li>Office number : " + getOfficeNumber() + "</li>\n" +
                "          </ul>\n" +
                "        </div>\n" +
                "      </div>";
    }
}

