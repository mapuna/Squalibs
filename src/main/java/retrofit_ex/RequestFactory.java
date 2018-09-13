package retrofit_ex;

class RequestFactory {
    static IRequest getRequest(RequestType type) {
        switch (type) {
            case SYNC:
                return new SynchronousRequest();
            default:
                return new AsynchronousRequest();
        }
    }
}
