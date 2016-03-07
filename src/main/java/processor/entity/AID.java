package processor.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Entity
@Data
public class AID {

    @Id
    private String AID;
    @Id
    private String Abstract_PMID;

    @ManyToOne
    private List<Abstract> abstracts;

    public void setAID(String aid) {
        this.AID = aid;
    }

}


