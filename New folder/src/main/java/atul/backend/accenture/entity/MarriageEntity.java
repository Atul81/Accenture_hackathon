package atul.backend.accenture.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "marriage", schema = "creditrecord", catalog = "")
public class MarriageEntity {
    private int marriageId;
    private String marriageNm;

    @Id
    @Column(name = "marriageId", nullable = false)
    public int getMarriageId() {
        return marriageId;
    }

    public void setMarriageId(int marriageId) {
        this.marriageId = marriageId;
    }

    @Basic
    @Column(name = "marriageNm", nullable = false, length = 100)
    public String getMarriageNm() {
        return marriageNm;
    }

    public void setMarriageNm(String marriageNm) {
        this.marriageNm = marriageNm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarriageEntity that = (MarriageEntity) o;
        return marriageId == that.marriageId &&
                Objects.equals(marriageNm, that.marriageNm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marriageId, marriageNm);
    }
}
