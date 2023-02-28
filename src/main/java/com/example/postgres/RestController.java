package com.example.postgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

@org.springframework.web.bind.annotation.RestController
@ComponentScan
public class RestController {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    @Autowired
    Environment env;

    @Autowired
    AccountJBDCRepository repository;


    @PostMapping("/account")
    public void insertRecord() {

        try {
            String id = sdf.format(Calendar.getInstance().getTime());

            Account account = new Account(id, "acc_number" + Math.random(), "CL");


            //account.setNew_row(true);

            repository.save(account);

            System.out.println(account.toString());

            System.out.println(" INSERT "+ Arrays.stream(env.getActiveProfiles()).findFirst() +" "+ id);


        } catch (Exception e) {
            e.printStackTrace();;
            System.out.println(e.getMessage());
        }


    }

    @GetMapping("/account")
    public Account readRecord() {

        try {
            String id = sdf.format(Calendar.getInstance().getTime());

            Account acct =  repository.findById("20230210165827666").get();

            System.out.println(" READ "+ Arrays.stream(env.getActiveProfiles()).findFirst() +" " + id );

            return acct;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

}
