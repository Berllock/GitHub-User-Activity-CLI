import org.json.JSONArray;
import org.json.JSONObject;

public class GitHubActivityCLI {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Use: java GitHubActivityCLI <username>");
            System.exit(1);
        }

        String username = args[0];
        System.out.println("\nSearching for " + username + " activity on GitHub... ");

        try {
            JSONArray activities = fetchGitHubActivities(username);
        }
    }

    private static JSONArray fetchGitHubActivities(String username) {
        return null;
    }
}