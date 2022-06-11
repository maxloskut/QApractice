package task17;

import java.util.HashMap;
import java.util.Map;

public class RequestRepository {
    static String key = "bf24871cd382840b7c99eb1cb0364f77";
    static String token = "d80b0a71e57109e36cde177c6eb2076e75f211d2136310601355ccda71ab586f";

    public static Request buildCreateBoardRequest(String boardName) {
        Request request = new Request();
//        Response response= given()
//                .when()
//                .contentType("application/json")
//                .body("{\"idOrganization\":\"60fefe65beb2b76caa04761c\"}")
//                .post("https://api.trello.com/1/boards/?name="
//                        +boardName+"&key="+
//                        key+"&token="
//                        +token+
//                        "");
        request.setUrl("https://api.trello.com/1/boards/?name="
                + boardName + "&key=" +
                key + "&token="
                + token +
                "");

        request.setBody("{\"idOrganization\":\"60fefe65beb2b76caa04761c\"}");

        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        request.setHeaders(headers);
        request.setMethod(RequestMethod.POST);
        return request;
    }
}