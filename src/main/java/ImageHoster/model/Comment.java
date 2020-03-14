package ImageHoster.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="comment")
public class Comment {
    //id - Datatype should be int. It should be a primary key. Also explicitly mention the column name as ‘id’ to be created in the database.
    //text - Datatype should be a string. Note that this column can have text-based data that will be longer than 256 characters.
    //createdDate - Datatype should be LocalDate.
    /*user - It should be of type User. The ‘comment’ table is mapped to ‘users’ table through this attribute. One user can post multiple
    comments but one comment should belong to one user. Write the suitable annotation to map the ‘comment’ table to ‘users’ table through
     this attribute.*/
    /*Image - It should be of type Image. The ‘comment’ table is mapped to ‘images’ table through this attribute.
    One image can have multiple comments but one comment can only belong to one image.
    Write the suitable annotation to map the ‘comment’ table to ‘images’ table through this attribute.*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="text")
    private String text;

    @Column(name="created_date")
    private LocalDate createdDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private  Image image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
