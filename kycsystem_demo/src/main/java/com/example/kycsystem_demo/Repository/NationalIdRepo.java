package com.example.kycsystem_demo.Repository;

import com.example.kycsystem_demo.Model.Nationalid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NationalIdRepo extends JpaRepository<Nationalid,Integer> {
    List<Nationalid> findByFiydaNumber(Long faydanumber);
}
