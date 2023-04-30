public class Engineer extends TeamMember {
    private String githubUsername;

    public Engineer(String name, int id, String email, String githubUsername) {
        super(name, id, email);
        this.githubUsername = githubUsername;
    }

    public String getGithubUsername() {
        return githubUsername;
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
                "            <img src=\"img/engineer.png\" alt=\"Icon\" />\n" +
                "            <h3>" + this.getClass().getSimpleName() + "</h3>\n" +
                "          </div>\n" +
                "        </div>\n" +
                "        <div class=\"card-body\">\n" +
                "          <ul>\n" +
                "            <li>ID: " + getId() + "</li>\n" +
                "            <li>Email: <a href=\"mailto:" + getEmail() + "\">" + getEmail() + "</a></li>\n" +
                "            <li>GitHub : <a target=\"_blank\" href=\"https://github.com/"+getGithubUsername()+ "\">"+getGithubUsername() +"</a></li>\n" +
                "          </ul>\n" +
                "        </div>\n" +
                "      </div>";
    }
}
