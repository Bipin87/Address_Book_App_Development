package com.capgemini.addressbookappdevelopment.service;

import com.capgemini.addressbookappdevelopment.dto.AddressBookDTO;
import com.capgemini.addressbookappdevelopment.model.AddressBook;
import com.capgemini.addressbookappdevelopment.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService {

    private final AddressBookRepository repository;

    @Autowired  // Constructor-based injection (recommended over field injection)
    public AddressBookService(AddressBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public AddressBook addContact(AddressBookDTO addressBookDTO) {
        AddressBook contact = new AddressBook(
                addressBookDTO.getName(),
                addressBookDTO.getAddress(),
                addressBookDTO.getPhoneNumber()
        );
        return repository.save(contact);
    }

    @Override
    public List<AddressBook> getAllContacts() {
        return repository.findAll();
    }

    @Override
    public AddressBook getContactById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));
    }

    @Override
    public AddressBook updateContact(Long id, AddressBookDTO addressBookDTO) {
        Optional<AddressBook> contactOptional = repository.findById(id);
        if (contactOptional.isPresent()) {
            AddressBook contact = contactOptional.get();
            contact.setName(addressBookDTO.getName());
            contact.setAddress(addressBookDTO.getAddress());
            contact.setPhoneNumber(addressBookDTO.getPhoneNumber());
            return repository.save(contact);
        } else {
            throw new RuntimeException("Contact not found with id: " + id);
        }
    }

    @Override
    public void deleteContact(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Contact not found with id: " + id);
        }
    }
}
