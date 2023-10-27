package com.example.Chapter4.service;

import com.example.Chapter4.model.Merchant;
import com.example.Chapter4.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MerchantService {
    private final MerchantRepository merchantRepository;
    public MerchantService(MerchantRepository merchantRepository){
        this.merchantRepository=merchantRepository;
    }
    public List<Merchant> getAll(){
        return merchantRepository.findAll();
    }

    public Merchant create(Merchant merchant){
        merchant.setCreatedDate(LocalDateTime.now());
        if(merchant.getName().isEmpty()) return null;
        return merchantRepository.save(merchant);
    }
    public void editMerchant(String name, int status){
        merchantRepository.editStatus(name, status);
    }
    public void deleteMerchant(String name){
        merchantRepository.deleteMerchant(name);
    }
    public Merchant getById(UUID id){
        Optional<Merchant> merchantOptional = merchantRepository.findById(id);
        if(merchantOptional.isPresent()){
            return merchantOptional.get();
        }throw new RuntimeException();
    }
}
