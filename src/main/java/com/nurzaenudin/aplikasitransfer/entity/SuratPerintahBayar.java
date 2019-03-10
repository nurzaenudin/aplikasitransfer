/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.aplikasitransfer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author nurza
 */

@Entity
public class SuratPerintahBayar {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable = false, length = 36)      
    private String id;
    
    @NotNull
    private int nomor;
    
    @NotNull @NotEmpty
    private String ppk;
    
    @NotNull @NotEmpty
    private String rekanan;
    
    private String pagu;
    
    @NotNull
    private double nilai;
    
    private double pajak;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }

    public String getPpk() {
        return ppk;
    }

    public void setPpk(String ppk) {
        this.ppk = ppk;
    }

    public String getRekanan() {
        return rekanan;
    }

    public void setRekanan(String rekanan) {
        this.rekanan = rekanan;
    }

    public String getPagu() {
        return pagu;
    }

    public void setPagu(String pagu) {
        this.pagu = pagu;
    }

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }

    public double getPajak() {
        return pajak;
    }

    public void setPajak(double pajak) {
        this.pajak = pajak;
    }
    
    
}
