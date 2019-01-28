/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.aplikasitransfer.DAO;

import com.nurzaenudin.aplikasitransfer.entity.Pegawai;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author nurzaenudin
 */

public interface PegawaiDao extends PagingAndSortingRepository<Pegawai, String>{
    Optional <Pegawai> findByNama(String nama);
    
}
