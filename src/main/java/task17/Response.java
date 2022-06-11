package task17;

public class Response {
    private String body;
    private int statusCode;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "Response{" +
                "body='" + body + '\'' +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }
}