/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.aplikasitransfer.controller;

import com.nurzaenudin.aplikasitransfer.DAO.PegawaiDao;
import com.nurzaenudin.aplikasitransfer.entity.Pegawai;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author nurzaenudin
 */
@Controller
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
@RequestMapping(path="/pegawai")
public class PegawaiController {
    
    @Autowired
    private PegawaiDao pegawaiDao;
    
    @GetMapping(path="")
    @ResponseBody
    
    public Iterable <Pegawai> getAllPegawai(){
        return pegawaiDao.findAll();
    }
    
    @PostMapping("")
    @ResponseBody
    public void tambahPegawai(@RequestBody @Valid Pegawai pegawai){
        pegawaiDao.save(pegawai);
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    public void hapusPegawai (@PathVariable String id){
        pegawaiDao.deleteById(id);
    }
    
    @PutMapping("/{id}")
    @ResponseBody
    public void updatePegawai(@RequestBody @Valid Pegawai pegawai, @PathVariable String id){
        Optional <Pegawai> p = pegawaiDao.findById(id);
        if (!p.isPresent())
            return;
        pegawai.setId(id);
        pegawaiDao.save(pegawai);
        
    }
    
    @GetMapping("/cariNama/{nama}")
    @ResponseBody
    public Optional <Pegawai> getPegawaiNama (@PathVariable String nama){
        return pegawaiDao.findByNama(nama);
    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Pegawai> getPegawaiId(@PathVariable String id) {
        return pegawaiDao.findById(id);
    }
      
}
