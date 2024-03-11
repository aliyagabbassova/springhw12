package com.example.spring_data_exam.controllers;


import com.example.spring_data_exam.dto.TransferRequest;
import com.example.spring_data_exam.model.Account;
import com.example.spring_data_exam.services.FileGateWay;
import com.example.spring_data_exam.services.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class AccountController {

  private final TransferService transferService;
  private final FileGateWay fileGateWay;

  @PostMapping("/transfer")
  public void transferMoney(
      @RequestBody TransferRequest request
      ) {
        transferService.transferMoney(
        request.getSenderAccountId(),
        request.getReceiverAccountId(),
        request.getAmount());
  }

  @GetMapping("/accounts")
  public Iterable<Account> getAllAccounts(
      @RequestParam(required = false) String name
  ) {
    if (name == null) {
      return transferService.getAllAccounts();
    } else {
      return transferService.findAccountsByName(name);
    }
  }

  @PostMapping("/accounts")
  public ResponseEntity<Account> createAccount(@RequestBody Account account) {
      fileGateWay.writeToFile(account.getName() + "txt", account.toString());
 return new ResponseEntity<> (HttpStatus.CREATED);
  }

}
