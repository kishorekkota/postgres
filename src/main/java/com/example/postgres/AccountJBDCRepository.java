package com.example.postgres;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJBDCRepository extends CrudRepository<Account,String> {

}
