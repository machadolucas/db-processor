package processor.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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


    private String AB;
    
    private String TA;
    
    private String JT;
    
    private String AID;
    
    private String SB;
    
    private String AD;
    
    private String PST;
    
    private String SO;

    private String PL;

    private String LA;



    @OneToMany
    private List<IS> Iss;

    @ManyToMany
    private List<PT> PTs;

    @ManyToMany
    private List<MH> MHs;

    @OneToMany
    private List<PHST> PHSTs;

    @ManyToMany
    private List<FAU> FAUs;

    @OneToMany
    private List<AID> AIDs;

    @ManyToMany
    private List<GR> GRs;

    public void setPMID(Long aid) {
        this.PMID = aid;
    }

    public void setVI(String VI) {
        this.VI = VI;
    }

    public void setOWN(String OWN) {
        this.OWN = OWN;
    }

    public void setSTAT(String STAT) {
        this.STAT = STAT;
    }

    public void setDA(String DA) {
        this.DA = DA;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public void setTI(String TI) {
        this.TI = TI;
    }

    public void setDP(String DP) {
        this.DP = DP;
    }

    public void setPG(String PG) {
        this.PG = PG;
    }


    public void setAB(String AB) {
        this.AB = AB;
    }


    public void setTA(String TA) {
        this.TA = TA;
    }

    public void setJT(String JT) {
        this.JT = JT;
    }

    public void setSB(String SB) {
        this.SB = SB;
    }

    public void setAID(String AID) {
        this.AID = AID;
    }

    public void setAD(String AD) {
        this.AD = AD;
    }

    public void setPST(String PST) {
        this.PST = PST;
    }

    public void setSO(String SO) {
        this.SO = SO;
    }

    public void setPL(String PL) {
        this.PL = PL;
    }

    public void setLA(String LA) {
        this.LA = LA;
    }

    public void setIss(List<IS> iss) {
        Iss = iss;
    }

    public void setPTs(List<PT> PTs) {
        this.PTs = PTs;
    }

    public void setMHs(List<MH> MHs) {
        this.MHs = MHs;
    }

    public void setPHSTs(List<PHST> PHSTs) {
        this.PHSTs = PHSTs;
    }

    public void setFAUs(List<FAU> FAUs) {
        this.FAUs = FAUs;
    }

    public void setAIDs(List<processor.entity.AID> AIDs) {
        this.AIDs = AIDs;
    }

    public void setGRs(List<GR> GRs) {
        this.GRs = GRs;
    }
}
