package com.fastcampuspay.banking.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "request_firmbanking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirmBankingRequestJpaEntity {
    @Id
    @GeneratedValue
    //@Generated 알아서 jpa가 관리해줌.
    private Long requestFirmBankingId;
    private String fromBankName;
    private String fromBankAccountNumber;
    private String toBankName;
    private String toBankAccountNumber;
    private int MoneyAmount;
    private int firmBankingStatus;
    private String uuid;

    public FirmBankingRequestJpaEntity(String fromBankName, String fromBankAccountNumber, String toBankName, String toBankAccountNumber, int moneyAmount, int firmBankingStatus, UUID uuid) {
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        MoneyAmount = moneyAmount;
        this.firmBankingStatus = firmBankingStatus;
        this.uuid = uuid.toString(); //안그러면 DB에서 값이 이상해짐.
    }

    @Override
    public String toString() {
        return "RequestFirmBankingJpaEntity{" +
                "requestFirmBankingId=" + requestFirmBankingId +
                ", fromBankName='" + fromBankName + '\'' +
                ", fromBankAccountNumber='" + fromBankAccountNumber + '\'' +
                ", toBankName='" + toBankName + '\'' +
                ", toBankAccountNumber='" + toBankAccountNumber + '\'' +
                ", MoneyAmount=" + MoneyAmount +
                ", firmBankingStatus=" + firmBankingStatus +
                '}';
    }
}
