package model;

import java.util.ArrayList;
import java.util.List;

public class Heroes {
    private String _id;
    private String name;
    private String desc;
    private String image;
    List<Comments> comments ;


    public Heroes(String name, String desc,String image , List<Comments> comments) {
        this.name = name;
        this.desc = desc;
        this.image = image;
        this.comments = comments;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Comments> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Heroes{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", image='" + image + '\'' +
                ", comments=" + comments +
                '}';
    }
}
