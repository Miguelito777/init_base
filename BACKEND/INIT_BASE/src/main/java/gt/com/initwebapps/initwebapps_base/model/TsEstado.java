package gt.com.initwebapps.initwebapps_base.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TS_ESTADO")
public class TsEstado extends TsAudit {
    @Id
    @GeneratedValue(generator = "ts_estado_generator")
    @SequenceGenerator(name = "ts_estado_generator", sequenceName = "ts_estado_sequence", initialValue = 8)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String estado;

    @Column(columnDefinition = "text")
    private String description;
	public TsEstado() {
		super();
		// TODO Auto-generated constructor stub
	}
    public TsEstado(Date createdAt, Date updatedAt, Long id, @NotBlank @Size(min = 3, max = 100) String estado,
            String description) {
        super(createdAt, updatedAt);
        this.id = id;
        this.estado = estado;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TsEstado(Date createdAt, Date updatedAt) {
        super(createdAt, updatedAt);
    }
}