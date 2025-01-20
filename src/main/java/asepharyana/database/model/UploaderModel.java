package asepharyana.projectbp1teori;

/**
 *
 * @author asephs
 */
public class UploaderModel {
    private int id;
    private String output;

    // Constructor, getters, and setters
    public UploaderModel() {}

    public UploaderModel(int id, String output) {
        this.id = id;
        this.output = output;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
