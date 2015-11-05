package test.maven;

/**
 * Created by Alexey on 05.11.2015.
 */
public class Box {

    private String description;
    private Integer id;
    private Integer height;
    private Integer width;
    private Integer depth;

    public Box() {
    }

    public Box(Integer id, String description, Integer height, Integer width, Integer depth) {
        this.description = description;
        this.id = id;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }
}
