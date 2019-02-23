package atul.backend.accenture.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sexmstr", schema = "creditrecord", catalog = "")
public class SexmstrEntity {
    private int sexId;
    private String sexDesc;

    @Id
    @Column(name = "sexId", nullable = false)
    public int getSexId() {
        return sexId;
    }

    public void setSexId(int sexId) {
        this.sexId = sexId;
    }

    @Basic
    @Column(name = "sexDesc", nullable = true, length = 100)
    public String getSexDesc() {
        return sexDesc;
    }

    public void setSexDesc(String sexDesc) {
        this.sexDesc = sexDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SexmstrEntity that = (SexmstrEntity) o;
        return sexId == that.sexId &&
                Objects.equals(sexDesc, that.sexDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sexId, sexDesc);
    }
}
