package processor.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Entity
@Data
public class Abstract {

    @Id
    private Long PMID;

    private String OWN;

    private String STAT;

    @ManyToMany
    private List<PT> PTs;
}
