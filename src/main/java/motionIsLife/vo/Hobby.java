package motionIsLife.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "hobby")
public class Hobby implements Serializable {
    private String hobbyId;

    @Id
    @Column(name = "HOBBY_ID")
    public String getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }
}
