package com.fastcampuspay.membership.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "membership")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembershipJpaEntity {

    @Id
    @Generated
    private Long membershipId;

    private String name;

    private String address;

    private String email;

    private String isValid;

    private String isCorp;


    @Override
    public String toString() {
        return "MembershipJpaEntity{" +
                "membershipId=" + membershipId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", isValid='" + isValid + '\'' +
                ", isCorp='" + isCorp + '\'' +
                '}';
    }
}
