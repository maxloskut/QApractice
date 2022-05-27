package practice12;

public class RequestRepo {
    public static Request getPostman() {
        Request request=new Request();
        request.setProtocol("https");
        request.setHost("postman-echo.com");
        request.setPath("get");
        request.setMethod("GET");
        return request;
    }

    private final static String KEY="95444cd1c94ed3ba021fb91aa204969e";
    private final static String TOKEN="6b0b4d3e16b0814601e849157b2938b124f12031bcc9c9feba5e64404cc74c58";



    public static Request createTrelloBoard(String boardName) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/?name="+boardName+"&key="+KEY +
                "&token="+TOKEN);
        request.setMethod("POST");
        request.setBody("{\"defaultLists\":false,\"name\":\"test_board1\",\"prefs_permissionLevel\"" +
                ":\"org\",\"prefs_selfJoin\":true,\"idOrganization\":\"60fefe65beb  2b76caa04761c\"}");
        return request;
    }

    public static Request AddDescriptionToCard(String cardId, String idList, String text) {
        Request request=baseTrelloRequest();
        request.setPath("1/cards/"+ cardId +"?&key="+KEY + "&token="+TOKEN + "&idList="+idList +"&desc="+text);
        request.setMethod("PUT");
        return request;
    }



    public static Request createCard(String idList, String nameCard) {
        Request request=baseTrelloRequest();
        request.setPath("1/cards?&key="+KEY + "&token="+TOKEN + "&idList="+idList +"&name="+nameCard);
        request.setMethod("POST");
        return request;
    }


    public static Request inviteToBoard(String boardID, String memberEmail) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/"+boardID +"/members?&key="+KEY + "&token="+TOKEN +"&email=" +memberEmail);
        request.setMethod("PUT");
        return request;
    }



    public static Request renameBoard(String boardID, String newNameForBoard) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/"+boardID +"?&key="+KEY + "&token="+TOKEN +"&name=" + newNameForBoard);
        request.setMethod("PUT");
        return request;
    }


    private static Request baseTrelloRequest() {
        Request request=new Request();
        request.setProtocol("https");
        request.setHost("api.trello.com");
        return request;
    }
    public static Request createList(String boardID, String nameList) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/"+boardID +"/lists?name="+nameList+"&key="+KEY + "&token="+TOKEN);
        request.setMethod("POST");
        return request;
    }

    public static Request deleteTrelloBoard(String boardId) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/"+boardId+"?key="+KEY +
                "&token="+TOKEN);
        request.setMethod("DELETE");
        return request;
    }
}
