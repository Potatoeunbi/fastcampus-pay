package com.fastcampuspay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FirmBankingRequest {
    @Getter private final String firmBankingRequestId;
    @Getter private final String fromBankName;
    @Getter private final String fromBankAccountNumber; //나중에 enum으로 하는 게 바람직할 거임
    @Getter private final String toBankName;
    @Getter private final String toBankAccountNumber;
    @Getter private final int moneyAmount;
    @Getter private final int firmBankingStatus; // 0 : 요청, 1 : 완료, 2 : 실패

    public static FirmBankingRequest generateFirmBankingRequest(
    ) {
        return new FirmBankingRequest(

        );
    }

    @Value
    public static class FirmBankingRequestId {
        public FirmBankingRequestId(String value) {
            this.firmBankingRequestId = value;
        }

        String firmBankingRequestId;
    }

    @Value
    public static class FromBankName {
        public FromBankName(String value) {
            this.fromBankName = value;
        }

        String fromBankName;
    }

    @Value
    public static class FromBankAccountNumber {
        public FromBankAccountNumber(String value) {
            this.fromBankAccountNumber = value;
        }

        String fromBankAccountNumber;
    }

    @Value
    public static class ToBankName {
        public ToBankName(String value) {
            this.toBankName = value;
        }

        String toBankName;
    }

    @Value
    public static class ToBankAccountNumber {
        public ToBankAccountNumber(String value) { this.toBankAccountNumber = value;}

        String toBankAccountNumber;
    }

    @Value
    public static class LinkedStatusIsValid {
        public LinkedStatusIsValid(boolean value) {
            this.linkedStatusIsValid = value;
        }

        boolean linkedStatusIsValid;
    }


}
