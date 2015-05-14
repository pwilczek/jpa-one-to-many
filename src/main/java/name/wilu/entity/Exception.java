package name.wilu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Exception {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "system") private String system;
    @Column(name = "code") private String code;

    private boolean active;

    public Exception(String system, String code, boolean active) {
        this.system = system;
        this.code = code;
        this.active = active;
    }

    public Exception() {}
}
