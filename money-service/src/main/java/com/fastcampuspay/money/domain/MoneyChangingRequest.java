package com.fastcampuspay.money.domain;

import com.fastcampuspay.money.common.enums.MoneyChangingStatusAdvanced;
import com.fastcampuspay.money.common.enums.MoneyChangingType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MoneyChangingRequest {
    @Getter private final String moneyChangingRequestId;
    //어떤 고객이 증/감액 요청을 했는지의 멤버 정보
    @Getter private final String targetMembershipId;
    @Getter private final MoneyChangingType changingMoneyType; //enum. 0:증액, 1:감액


    //증액 또는 감액 요청의 금액
    @Getter private final int changingMoneyAmount;
    //머니 변액 요청에 대한 상태
    @Getter private final MoneyChangingStatusAdvanced changingMoneyStatus; //enum

    @Getter private final String uuid;
    @Getter private final Date createdAt;

    //membership은 오염이 되면 안 되는 클래스. 고객 정보이며 핵심 도메인. 그래서 AccessLevel을 private으로.
    // member 정의
    // getter, setter @Data

    public static MoneyChangingRequest generateMoneyChangingRequest(
            MoneyChangingRequestId moneyChangingRequestId,
            TargetMembershipId targetMembershipId,
            ChangingMoneyType changingMoneyType,
            ChangingMoneyAmount changingMoneyAmount,
            ChangingMoneyStatus changingMoneyStatus,
            Uuid uuid
    ) {
        return new MoneyChangingRequest(
            moneyChangingRequestId.getMoneyChangingRequestId(),
                targetMembershipId.getTargetMembershipId(),
                changingMoneyType.getChangingMoneyType(),
                changingMoneyAmount.getChangingMoneyAmount(),
                changingMoneyStatus.getChangingMoneyStatus(),
                uuid.getUuid(),
                new Date()
        );
    }

    @Value
    public static class MoneyChangingRequestId {
        public MoneyChangingRequestId(String value) {
            this.moneyChangingRequestId = value;
        }

        String moneyChangingRequestId;
    }

    @Value
    public static class TargetMembershipId {
        public TargetMembershipId(String value) {
            this.targetMembershipId = value;
        }

        String targetMembershipId;
    }

    @Value
    public static class ChangingMoneyType {
        public ChangingMoneyType(MoneyChangingType value) {
            this.changingMoneyType = value;
        }

        MoneyChangingType changingMoneyType;
    }

    @Value
    public static class ChangingMoneyAmount {
        public ChangingMoneyAmount(int value) {
            this.changingMoneyAmount = value;
        }

        int changingMoneyAmount;
    }

    @Value
    public static class ChangingMoneyStatus {
        public ChangingMoneyStatus(MoneyChangingStatusAdvanced value) {
            this.changingMoneyStatus = value;
        }

        MoneyChangingStatusAdvanced changingMoneyStatus;
    }

    @Value
    public static class Uuid {
        public Uuid(UUID uuid) {
            this.uuid = uuid.toString();
        }

        String uuid;
    }
}
