package name.wilu.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ExceptionGroup implements Serializable{
    @Id
    @GeneratedValue
    private Long id;

    /*
    @Embedded
    private GroupId groupId = new GroupId();
    */

    @Column(name = "system") private String system;
    @Column(name = "code") private String code;

    @OneToMany
    @JoinColumns({
            @JoinColumn(name = "system", referencedColumnName = "system"),
            @JoinColumn(name = "code", referencedColumnName = "code")
    })
    Set<Exception> exceptions = new HashSet();

    public void add(Exception first) {
        exceptions.add(first);
    }

    public Set<Exception> exceptions() {
        return exceptions;
    }

    public ExceptionGroup(String system, String code) {
        this.system = system;
        this.code = code;
    }

    public ExceptionGroup() {}

}
