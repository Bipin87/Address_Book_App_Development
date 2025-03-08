package com.capgemini.addressbookappdevelopment.service;

import com.capgemini.addressbookappdevelopment.dto.AddressBookDTO;
import com.capgemini.addressbookappdevelopment.model.AddressBook;
import java.util.List;

public interface IAddressBookService {
    AddressBook addContact(AddressBookDTO addressBookDTO);
    List<AddressBook> getAllContacts();
    AddressBook getContactById(Long id);
    AddressBook updateContact(Long id, AddressBookDTO addressBookDTO);
    void deleteContact(Long id);
}
