/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.aplikasitransfer.controller;

import com.nurzaenudin.aplikasitransfer.DAO.PegawaiDao;
import com.nurzaenudin.aplikasitransfer.entity.Pegawai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author nurzaenudin
 */
@Controller
@RequestMapping(path="/pegawai")
public class PegawaiController {
    
    @Autowired
    private PegawaiDao pegawaiDao;
    
    @GetMapping(path="/all")
    @ResponseBody
    public Iterable <Pegawai> getAllPegawai(){
        return pegawaiDao.findAll();
    }
    
    
    
    
}
