package com.example.postgres;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("sample_table_account")
public class Account implements Persistable<String> {



    @Id

    private String id;
    @Column("account_number")
    private String accountNumber;
    @Column("premium_tier")
    private String tier;
//
//    @Transient
//    private boolean new_row = false;

    public boolean isNew()
    {
        return true;
    }
}
