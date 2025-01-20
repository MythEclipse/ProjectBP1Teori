package asepharyana.database.model;

/**
 *
 * @author asephs
 */
public class UploaderModel {
    private String id;
    private String output;
    private String userId; // Added userId field

    // Constructor, getters, and setters
    public UploaderModel() {}

    public UploaderModel(String id, String output, String userId) {
        this.id = id;
        this.output = output;
        this.userId = userId; // Initialize userId
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
