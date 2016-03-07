package processor.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Entity
@Data
public class LA {

    @Id
    private String LA;

    @OneToMany
    private List<Abstract> abstracts;

    public void setLA(String aid) {
        this.LA = aid;
    }
}
