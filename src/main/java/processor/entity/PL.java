package processor.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Entity
@Data
public class PL {

    @Id
    private String PL;

    @OneToMany
    private List<Abstract> abstracts;

    public void setPL(String aid) {
        this.PL = aid;
    }

}