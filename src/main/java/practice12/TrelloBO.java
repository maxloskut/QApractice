package practice12;

import org.testng.Assert;

import java.util.UUID;

public class TrelloBO {
    public String create() {
        Request createRequest = RequestRepo.createTrelloBoard("Board"+ UUID.randomUUID().toString().substring(0,5));
        Response createResponse=new Client().send(createRequest);
        Assert.assertEquals(createResponse.getStatusCode().intValue(),200,"invalid code");
        return createResponse.getBodyAsJson().getString("id");
    }

    public Response delete(String boardId) {
        Request deleteRequest = RequestRepo.deleteTrelloBoard(boardId);
        Response deleteResponse=new Client().send(deleteRequest);
        Assert.assertEquals(deleteResponse.getStatusCode().intValue(),200,"invalid code");
        return deleteResponse;
    }



    public String addDesc(String CardId, String IdList, String description) {
        Request createRequest = RequestRepo.AddDescriptionToCard(CardId, IdList, description);
        Response createResponse=new Client().send(createRequest);
        Assert.assertEquals(createResponse.getStatusCode().intValue(),200,"invalid code");
        return createResponse.getBodyAsJson().getString("id");
    }



    public String createList(String boardId, String nameList) {
        Request createRequest = RequestRepo.createList(boardId, nameList);
        Response createResponse=new Client().send(createRequest);
        Assert.assertEquals(createResponse.getStatusCode().intValue(),200,"invalid code");
        return createResponse.getBodyAsJson().getString("id");
    }



    public String createCard(String idList, String nameCard) {
        Request createRequest = RequestRepo.createCard(idList, nameCard);
        Response createResponse=new Client().send(createRequest);
        Assert.assertEquals(createResponse.getStatusCode().intValue(),200,"invalid code");
        return createResponse.getBodyAsJson().getString("id");
    }



    public String inviteToBoard(String boardId, String memberEmail) {
        Request createRequest = RequestRepo.inviteToBoard(boardId, memberEmail);
        Response createResponse=new Client().send(createRequest);
        Assert.assertEquals(createResponse.getStatusCode().intValue(),200,"invalid code");
        return createResponse.getBodyAsJson().getString("id");
    }


    public String renameBoard(String boardId, String newNameForBoard) {
        Request createRequest = RequestRepo.renameBoard(boardId, newNameForBoard);
        Response createResponse=new Client().send(createRequest);
        Assert.assertEquals(createResponse.getStatusCode().intValue(),200,"invalid code");
        return createResponse.getBodyAsJson().getString("id");
    }
}
