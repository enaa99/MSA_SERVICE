package com.banking.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "request_firmbanking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestFirmbankingJapEntity {
    @Id
    @GeneratedValue
    private Long requestFrimbankingId;
    private String fromBankName;
    private String fromBankAccountNumber;
    private String toBankName;
    private String toBankAccountNumber;
    private int moneyAmount; //Only Won
    private String firmbankingStatus;
    private String uuid;
    public RequestFirmbankingJapEntity(String fromBankName, String fromBankAccountNumber, String toBankName, String toBankAccountNumber,
                                       int moneyAmount, String firmbankingStatus, UUID uuid) {
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.moneyAmount = moneyAmount;
        this.firmbankingStatus = firmbankingStatus;
        this.uuid = uuid.toString();
    }

    @Override
    public String toString() {
        return "RequestFirmbankingJapEntity{" +
                "requestFrimbankingId=" + requestFrimbankingId +
                ", fromBankName='" + fromBankName + '\'' +
                ", fromBankAccountNumber='" + fromBankAccountNumber + '\'' +
                ", toBankName='" + toBankName + '\'' +
                ", toBankAccountNumber='" + toBankAccountNumber + '\'' +
                ", moneyAmount=" + moneyAmount +
                ", firmbankingStatus='" + firmbankingStatus + '\'' +
                ", uuid=" + uuid +
                '}';
    }
}
