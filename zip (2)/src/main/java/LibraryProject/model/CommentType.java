package LibraryProject.model;

public enum CommentType {

    TEMASIVIZUNE(1),

    CARACTERIZARE(2),

    RELATIIPERSONAJE(3);

    private int choice;

    CommentType(int choice) {
        this.choice = choice;
    }
}
