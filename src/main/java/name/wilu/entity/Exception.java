package name.wilu.entity;

import javax.persistence.*;

@Entity
public class Exception {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "system") private String system;
    @Column(name = "code") private String code;

    @ManyToOne
    private ExceptionGroup group;

    private boolean active;

    public Exception(String system, String code, boolean active) {
        this.system = system;
        this.code = code;
        this.active = active;
    }

    public Exception() {}

    public ExceptionGroup group() {
        return group;
    }
}
