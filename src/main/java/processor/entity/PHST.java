package processor.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Entity
@Data
public class PHST {

    @Id
    private String PHST;
    
    @Id
    private String Abstract_PMID;

    @ManyToOne
    private List<Abstract> abstracts;

    public void setPHST(String aid) {
        this.PHST = aid;
    }

}
