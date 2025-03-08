package com.capgemini.addressbookappdevelopment.controller;

import com.capgemini.addressbookappdevelopment.dto.AddressBookDTO;
import com.capgemini.addressbookappdevelopment.model.AddressBook;
import com.capgemini.addressbookappdevelopment.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @PostMapping("/add")
    public ResponseEntity<AddressBook> addContact(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(addressBookService.addContact(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AddressBook>> getAllContacts() {
        return ResponseEntity.ok(addressBookService.getAllContacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getContactById(@PathVariable Long id) {
        return ResponseEntity.ok(addressBookService.getContactById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBook> updateContact(@PathVariable Long id, @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(addressBookService.updateContact(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        addressBookService.deleteContact(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
