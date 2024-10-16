package com.fastcampuspay.money.adapter.out.persistence;

import com.fastcampuspay.money.common.enums.MoneyChangingStatusAdvanced;
import com.fastcampuspay.money.common.enums.MoneyChangingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "money_changing_request")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingRequestJpaEntity {
    @Id
    @GeneratedValue
    //@Generated 알아서 jpa가 관리해줌.
    private Long moneyChangingRequestId;

    private String targetMembershipId;

    private MoneyChangingType moneyChangingType;

    private int moneyAmount;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp timestamp;

    private MoneyChangingStatusAdvanced changingMoneyStatus;

    private UUID uuid;

    public MoneyChangingRequestJpaEntity(String targetMembershipId, MoneyChangingType moneyChangingType, int moneyAmount, Timestamp timestamp, MoneyChangingStatusAdvanced changingMoneyStatus, UUID uuid) {
        this.targetMembershipId = targetMembershipId;
        this.moneyChangingType = moneyChangingType;
        this.moneyAmount = moneyAmount;
        this.timestamp = timestamp;
        this.changingMoneyStatus = changingMoneyStatus;
        this.uuid = uuid;
    }

}
