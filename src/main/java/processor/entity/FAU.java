package processor.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Entity
@Data
public class FAU {

    @Id
    private String FAU;

    @ManyToMany
    private List<Abstract> abstracts;

    public void setFAU(String aid) {
        this.FAU = aid;
    }

}
