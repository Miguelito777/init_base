package gt.com.initwebapps.initwebapps_base.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * TcUsuario
 */
@Entity
@Table(name="TC_USUARIO")
public class TcUsuario extends TsAudit{
    @Id
    @GeneratedValue(generator = "tc_usuario_generator")
    @SequenceGenerator(
            name = "tc_usuario_generator",
            sequenceName = "tc_usuario_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(columnDefinition = "text")
    private String usuario;

    @Column(columnDefinition = "text")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_tc_usuario_ref_ts_estado"), name = "id_estado", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private TsEstado tsEstado;

    public TcUsuario() {
        super();
    }

    public TcUsuario(Long id, String usuario, String password, TsEstado tsEstado) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.tsEstado = tsEstado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TsEstado getTsEstado() {
        return tsEstado;
    }

    public void setTsEstado(TsEstado tsEstado) {
        this.tsEstado = tsEstado;
    }
}