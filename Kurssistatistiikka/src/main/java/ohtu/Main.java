package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/courses/students/"+studentNr+"/submissions";
        String coursesUrl = "https://studies.cs.helsinki.fi/courses/courseinfo";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        String coursesText = Request.Get(coursesUrl).execute().returnContent().asString();

        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        int totalExcercises = 0;
        int totalHours = 0;

        System.out.format("opiskelijanumero %s\n", studentNr);
        for (Submission submission : subs) {
            totalHours += submission.getHours();
            totalExcercises += submission.excercisesDone();
            System.out.println(submission);
        }
        System.out.format("yhteensä: %d tehtävää %d tuntia\n", totalExcercises, totalHours);
    }
}