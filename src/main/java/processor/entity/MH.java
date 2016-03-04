package processor.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Entity
@Data
public class MH {

    @Id
    private String MH;

    @ManyToMany
    private List<Abstract> abstracts;

}
