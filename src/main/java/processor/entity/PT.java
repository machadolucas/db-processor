package processor.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Entity
@Data
public class PT {

    @Id
    private String PT;

    @ManyToMany
    private List<Abstract> abstracts;

    public void setPT(String aid) {
        this.PT = aid;
    }
}
