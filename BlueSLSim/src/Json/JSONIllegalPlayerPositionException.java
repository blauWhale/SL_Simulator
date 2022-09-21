package Json;

/**
 * JSONException class if there is a Typo in the Position in the JSONfile
 */
public class JSONIllegalPlayerPositionException extends Exception{
        public JSONIllegalPlayerPositionException() {
            System.out.println("Something went wrong during reading your JSON File (Please check the players positions for typos)");
        }


}
