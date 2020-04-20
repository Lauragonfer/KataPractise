public enum StatusTask {

    KO("Incomplete"),
    OK("Completed");

    public final String status ;

    StatusTask(String status) {
        this.status = status;
    }
}
