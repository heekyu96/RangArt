package imtt96.com.rangart;

/**
 * Created by imtt9 on 2017-02-05.
 */

public class ShowOwnPieceData {
    private String name;
    private String comment;

    public ShowOwnPieceData(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
