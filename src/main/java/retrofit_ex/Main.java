package retrofit_ex;

public class Main {
    public static void main(String[] args) {
        String baseUrl = "https://api.github.com/";
        IRequest syncRequest = RequestFactory.getRequest(RequestType.SYNC);
        syncRequest.printUserResponse("mapuna");

        IRequest asyncRequest = RequestFactory.getRequest(RequestType.ASYNC);
        asyncRequest.printUserResponse("mapuna");
    }
}
