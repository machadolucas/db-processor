package processor.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Entity
@Data
public class AID {

    @Id
    private String AID;

    @ManyToOne
    private List<Abstract> abstracts;

}
