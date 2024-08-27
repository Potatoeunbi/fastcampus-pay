package com.fastcampuspay.money.domain;

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
    @Getter private final ChangingType changingType; //enum. 0:증액, 1:감액

    enum ChangingType {
        INCREASING, DECREASING
    }

    //증액 또는 감액 요청의 금액
    @Getter private final int changingMoneyAmount;
    //머니 변액 요청에 대한 상태
    @Getter private final ChangingMoneyStatus changingMoneyStatus; //enum

    enum ChangingMoneyStatus {
        REQUESTED,
        SUCCEEDED,
        FAILED,
        CANCELLED
    }
    @Getter private final String uuid;
    @Getter private final Date createdAt;

    //membership은 오염이 되면 안 되는 클래스. 고객 정보이며 핵심 도메인. 그래서 AccessLevel을 private으로.
    // member 정의
    // getter, setter @Data

    public static MoneyChangingRequest generateRegisteredBankAccount(
            MoneyChangingRequestId moneyChangingRequestId,
            TargetMembershipId targetMembershipId,
            MoneyChangingType moneyChangingType,
            ChangingMoneyAmount changingMoneyAmount,
            MoneyChangingStatus moneyChangingStatus,
            Uuid uuid
    ) {
        return new MoneyChangingRequest(
            moneyChangingRequestId.getMoneyChangingRequestId(),
                targetMembershipId.getTargetMembershipId(),
                moneyChangingType.getChangingType(),
                Integer.parseInt(changingMoneyAmount.getChangingMoneyAmount()),
                moneyChangingStatus.getChangingMoneyStatus(),
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
    public static class MoneyChangingType {
        public MoneyChangingType(ChangingType value) {
            this.changingType = value;
        }

        ChangingType changingType;
    }

    @Value
    public static class ChangingMoneyAmount {
        public ChangingMoneyAmount(String value) {
            this.changingMoneyAmount = value;
        }

        String changingMoneyAmount;
    }

    @Value
    public static class MoneyChangingStatus {
        public MoneyChangingStatus(ChangingMoneyStatus value) {
            this.changingMoneyStatus = value;
        }

        ChangingMoneyStatus changingMoneyStatus;
    }

    @Value
    public static class Uuid {
        public Uuid(UUID uuid) {
            this.uuid = uuid.toString();
        }

        String uuid;
    }
}
