package com.fastcampuspay.money.domain;

import com.fastcampuspay.money.common.enums.MoneyChangingType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberMoney {
    @Getter private final String memberMoneyId;
    @Getter private final String membershipId;
    //잔액
    @Getter private final int balance;

    //수강생들 따로 구현해보깅
//    @Getter private final int linkedBankAccountId;

    //membership은 오염이 되면 안 되는 클래스. 고객 정보이며 핵심 도메인. 그래서 AccessLevel을 private으로.
    // member 정의
    // getter, setter @Data

    public static MemberMoney generateMemberMoney(
            MemberMoneyId memberMoneyId,
            MembershipId membershipId,
            MoneyBalance moneyBalance
    ) {
        return new MemberMoney(
                memberMoneyId.getMemberMoneyId(),
                membershipId.getMembershipId(),
                moneyBalance.getBalance()
        );
    }

    @Value
    public static class MemberMoneyId {
        public MemberMoneyId(String value) {
            this.memberMoneyId = value;
        }

        String memberMoneyId;
    }

    @Value
    public static class MembershipId {
        public MembershipId(String value) {
            this.membershipId = value;
        }

        String membershipId;
    }

    @Value
    public static class MoneyBalance {
        public MoneyBalance(int value) {
            this.balance = value;
        }

        int balance;
    }

}
