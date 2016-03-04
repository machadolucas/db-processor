package processor.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OnToMany;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Entity
@Data
public class GR {

    @Id
    private String GR;

    @OneToMany
    private List<Abstract> abstracts;
