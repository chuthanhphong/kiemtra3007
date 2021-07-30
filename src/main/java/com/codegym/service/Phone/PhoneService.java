package com.codegym.service.Phone;

import com.codegym.model.Phone;
import com.codegym.repository.IPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhoneService implements IPhoneService {
    @Autowired
    private IPhoneRepository phoneRepository;
    @Override
    public Iterable<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Optional<Phone> findById(Long id) {
        return phoneRepository.findById(id);
    }

    @Override
    public void save(Phone phone) {
            phoneRepository.save(phone);
    }

    @Override
    public void remove(Long id) {
        phoneRepository.deleteById(id);
    }
}
