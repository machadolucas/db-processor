package processor.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Entity
@Data
public class Abstract {

    @Id
    private Long PMID;

    private String OWN;

    private String STAT;
    
    private String DA;
    
    private String VI;
    
    private String IP;
    
    private String DP;
    
    private String TI;
    
    private String PG;
    
    private String TA;
    
    private String JT;
    
    private String AID;
    
    private String SB;
    
    private String AD;
    
    private String PST;
    
    private String SO;

    @ManyToMany
    private List<PL> Pl_PL;
    
    @ManyToOne
    private List<LA> LA_LA;
}
