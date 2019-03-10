/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.aplikasitransfer.controller;

import com.nurzaenudin.aplikasitransfer.DAO.SuratPerintahBayarDao;
import com.nurzaenudin.aplikasitransfer.entity.SuratPerintahBayar;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author nurza
 */

@Controller
@RequestMapping(path="/spby")
public class SuratPerintahBayarController {
    @Autowired
    private SuratPerintahBayarDao suratPerintahBayarDao;
    
    @GetMapping(path="all")
    @ResponseBody
    @ResponseStatus( HttpStatus.OK) 
    public Iterable <SuratPerintahBayar> getAllSuratPerintahBayar(){
        return suratPerintahBayarDao.findAll();
    }
    
    @PostMapping(path="")
    @ResponseBody
    public void tambahSuratPerintahBayar(@RequestBody @Valid SuratPerintahBayar suratPerintahBayar){
        suratPerintahBayarDao.save(suratPerintahBayar);
    }
    
    @DeleteMapping(path="/{id}")
    @ResponseBody
    public void hapusSuratPerintahBayar(@PathVariable String id){
        suratPerintahBayarDao.deleteById(id);
    }
    
    @PutMapping(path="/{id}")
    @ResponseBody
    public void updateSuratPerintahBayar(
        @RequestBody @Valid SuratPerintahBayar suratPerintahBayar,
        @PathVariable String id){
            Optional <SuratPerintahBayar> spby= suratPerintahBayarDao.findById(id);
            if(!spby.isPresent())
                return;
            suratPerintahBayar.setId(id);
            suratPerintahBayarDao.save(suratPerintahBayar);
    }
    
    @GetMapping(path="/{id}")
    @ResponseBody
    public Optional <SuratPerintahBayar> getSuratPerintahBayarById (@PathVariable String id){
        return suratPerintahBayarDao.findById(id);
    }
  
}
