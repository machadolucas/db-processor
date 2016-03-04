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

    @ManyToOne
    private List<Abstract> abstracts;

}