package com.ha.padaria.Repository;

import com.ha.padaria.Model.PadariaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PadariaRepository extends JpaRepository<PadariaModel, Long> {
}
