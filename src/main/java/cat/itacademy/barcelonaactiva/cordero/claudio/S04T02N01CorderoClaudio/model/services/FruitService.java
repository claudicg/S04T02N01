package cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.model.services;

import java.util.List;

import cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.model.DTO.FruitDTO;


public interface FruitService {

	
	public boolean add(FruitDTO fruit);
	public boolean update(FruitDTO fruit);
	public void delete(String id);
	public FruitDTO getOne(String id);
	public List<FruitDTO> getAll();
}
