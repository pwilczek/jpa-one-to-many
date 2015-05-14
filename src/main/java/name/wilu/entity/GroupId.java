package name.wilu.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GroupId {
    @Column(name = "system") private String system;
    @Column(name = "code") private String code;
}
