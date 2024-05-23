package cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.model.domain.FruitEntity;

@Repository
public interface FruitRepository extends JpaRepository<FruitEntity, String>{

}
