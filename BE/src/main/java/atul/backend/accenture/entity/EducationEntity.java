package atul.backend.accenture.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "education", schema = "creditrecord", catalog = "")
public class EducationEntity {
    private int eduId;
    private String eduNm;

    @Id
    @Column(name = "eduId", nullable = false)
    public int getEduId() {
        return eduId;
    }

    public void setEduId(int eduId) {
        this.eduId = eduId;
    }

    @Basic
    @Column(name = "eduNm", nullable = false, length = 100)
    public String getEduNm() {
        return eduNm;
    }

    public void setEduNm(String eduNm) {
        this.eduNm = eduNm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationEntity that = (EducationEntity) o;
        return eduId == that.eduId &&
                Objects.equals(eduNm, that.eduNm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eduId, eduNm);
    }
}
