package com.movieapp.dahp_ccptpm_be.mapper;

import com.movieapp.dahp_ccptpm_be.dto.AccountDTO;
import com.movieapp.dahp_ccptpm_be.model.entity.Account;
import org.mapstruct.*;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AccountMapper {
    AccountDTO toAccountDto(Account account);

    Account toAccount(AccountDTO accountDTO);
}
