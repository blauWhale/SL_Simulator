/**
 * Simple Exception Handeling Class for different Use cases
 */
public class JSONException extends Exception{
        public JSONException() {
            System.out.println("Something went wrong during reading your JSON File (Please check the players positions for typos)");
        }


}
