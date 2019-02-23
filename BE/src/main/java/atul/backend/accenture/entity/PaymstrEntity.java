package atul.backend.accenture.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "paymstr", schema = "creditrecord", catalog = "")
public class PaymstrEntity {
    private int payId;
    private String payDesc;

    @Id
    @Column(name = "payId", nullable = false)
    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    @Basic
    @Column(name = "PayDesc", nullable = false, length = 100)
    public String getPayDesc() {
        return payDesc;
    }

    public void setPayDesc(String payDesc) {
        this.payDesc = payDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymstrEntity that = (PaymstrEntity) o;
        return payId == that.payId &&
                Objects.equals(payDesc, that.payDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payId, payDesc);
    }
}
