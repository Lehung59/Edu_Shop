package com.example.ttversion1;
package com.example.shop;

import com.example.ttversion1.login.dto.AccountDTO;
import com.example.ttversion1.login.dto.UserDTO;
import com.example.ttversion1.login.entity.Account;
import com.example.ttversion1.login.entity.Decentralization;
import com.example.ttversion1.login.repository.DecentralizationRepo;
import com.example.ttversion1.login.serviceImpl.AccountService;
import com.example.ttversion1.login.serviceImpl.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class AccountServiceTest {

    @Mock
    private DecentralizationRepo decentralizationRepo;

    @Mock
    private UserService userService;

    private AccountService accountService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        accountService = new AccountService(decentralizationRepo, userService);
    }

    @Test
    public void testAccountToDTO() {
        Account account = new Account();
        // Set properties of the account object

        when(decentralizationRepo.findByName("USER")).thenReturn(Optional.of(new Decentralization()));
        when(userService.findUserByEmail(account.getUser().getEmail())).thenReturn(Optional.of(new UserDTO()));

        AccountDTO accountDTO = accountService.AccountToDTO(account);

        // Now, you can assert the properties of accountDTO to check if they are as expected
        assertEquals("Không thể hiển thị", accountDTO.getMatchingPassword());
        assertEquals("Không thể hiển thị", accountDTO.getPassword());
        // ...
    }
}