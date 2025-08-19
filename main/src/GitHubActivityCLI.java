import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
            displayActivities(activities);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    private static void displayActivities(JSONArray activities) {
    }

    private static JSONArray fetchGitHubActivities(String username) throws Exception {

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL("https://api.github.com/users/" + username + "/events");
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("User-Agent", "GitHubActivityCLI/1.0");

            connection.setConnectTimeout(5000);
            connection.setReadTimeout(10000);

            int responseCode = connection.getResponseCode();

            if (responseCode == 404) {
                throw new Exception("User '" + username + "' not found");
            } else if (responseCode != 200) {
                throw new Exception("Error: " + responseCode);
            }

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return new JSONArray(response.toString());
        } catch (MalformedURLException e) {
            throw new Exception("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            throw new Exception("IO Exception: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error closing stream: " + e.getMessage());
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}