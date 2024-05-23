package cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.model.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.exceptions.FruitNotFoundException;
import cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.model.DTO.FruitDTO;
import cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.model.domain.FruitEntity;
import cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.model.repositories.FruitRepository;
import cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.utils.Constants;




@Service("FruitService")
public class FruitServiceImpl implements FruitService{

	@Autowired
	private FruitRepository fruitsRepository;

	@Override
	public boolean add(FruitDTO fruit) {
		
		FruitEntity fruitEntity = fruitsRepository.save(mappingFruitDTOToFruitEntity(fruit));
		return fruitEntity != null ? true : false;
	}
	
	@Override
	public boolean update(FruitDTO fruit) {
		
		FruitEntity fruitEntity = fruitsRepository.save(mappingFruitDTOToFruitEntity(fruit));
		return fruitEntity != null ? true : false;
	}
	
	@Override
	public void delete(String id) throws FruitNotFoundException{ 
		
		FruitEntity fruit = fruitsRepository.findById(id).orElse(null);

		 if (fruit != null){
			 fruitsRepository.deleteById(id);
		 }else{
			 throw new FruitNotFoundException(Constants.Messages.FOUND);
		 }           
	}

	@Override
	public FruitDTO getOne(String id) {

		FruitEntity fruit = fruitsRepository.findById(id).orElse(null);
		
		if(fruit != null) {
			
			return mappingFruitEntityToFruitDTO(fruit);
		}
		
		return null;
	}
	
	@Override
	public List<FruitDTO> getAll() {
		
		List<FruitDTO> fruitDtoList = new ArrayList<>();
		List<FruitEntity> fruits = fruitsRepository.findAll();
		
		for(FruitEntity fruit : fruits) {
			fruitDtoList.add(mappingFruitEntityToFruitDTO(fruit));
		}
		return fruitDtoList;
	}
	
	
	private FruitDTO mappingFruitEntityToFruitDTO(FruitEntity fruitEntity) {
		
		FruitDTO fruit = new FruitDTO();
		fruit.setName(fruitEntity.getName());
		fruit.setKilograms(fruitEntity.getKilograms());
		
		
		return fruit;
	}
	
	private FruitEntity mappingFruitDTOToFruitEntity(FruitDTO fruitDto) {
		
		FruitEntity fruit = new FruitEntity();
		fruit.setName(fruitDto.getName());
		fruit.setKilograms(fruitDto.getKilograms());
		
		
		return fruit;
	}	
}
