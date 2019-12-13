package br.com.mjv.yoyo.repository;

import br.com.mjv.yoyo.model.Yoyo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YoyoRepository extends JpaRepository<Yoyo, Integer> {
}
