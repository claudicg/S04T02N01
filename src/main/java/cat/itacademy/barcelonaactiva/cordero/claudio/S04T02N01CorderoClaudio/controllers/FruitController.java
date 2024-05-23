package cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.model.DTO.FruitDTO;
import cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.model.DTO.FruitResponse;
import cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.model.services.FruitService;
import cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.utils.Constants;
import cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.utils.Validations;


@RestController
@RequestMapping("/fruits") 
public class FruitController{
	
	@Autowired
	private FruitService fruitService;
	
	
	@PostMapping("/add")
	public ResponseEntity<FruitResponse> add(@RequestBody FruitDTO fruit) {
		
		if(!Validations.isValidName(fruit.getName().trim())) {
			FruitResponse response = new FruitResponse();
			response.setError(Constants.Messages.INVALID_NAME);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		if(fruit.getKilograms() <= 0) {
			FruitResponse response = new FruitResponse();
			response.setError(Constants.Messages.INVALID_KILOGRAMS);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		
		if(fruitService.add(fruit)) {
			FruitResponse response = new FruitResponse();
			response.setMessage(Constants.Messages.ADDED);
			response.setFruit(fruit);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}else {
			FruitResponse response = new FruitResponse();
			response.setError(Constants.Messages.ERROR_INSERT);
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(response);
		}
	}
	
	
	@PutMapping("/update")
    public ResponseEntity<FruitResponse> update(@RequestBody FruitDTO fruit) {
		
		if(!Validations.isValidName(fruit.getName().trim())) {
			FruitResponse response = new FruitResponse();
			response.setError(Constants.Messages.INVALID_NAME);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		if(fruit.getKilograms() <= 0) {
			FruitResponse response = new FruitResponse();
			response.setError(Constants.Messages.INVALID_KILOGRAMS);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		if(fruitService.update(fruit)) {
			FruitResponse response = new FruitResponse();
			response.setMessage(Constants.Messages.UPDATED);
			response.setFruit(fruit);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}else {
			FruitResponse response = new FruitResponse();
			response.setError(Constants.Messages.ERROR_UPDATE);
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(response);
		}
    }	    

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<FruitResponse> delete(@PathVariable String id) {
		
		if(!Validations.isValidName(id.trim())) {
			FruitResponse response = new FruitResponse();
			response.setError(Constants.Messages.INVALID_ID);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		fruitService.delete(id);
		
	    FruitResponse response = new FruitResponse();
	    response.setMessage(Constants.Messages.DELETED);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}   

	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<FruitResponse> getOne(@PathVariable String id) {
		
		if(!Validations.isValidName(id.trim())) {
			FruitResponse response = new FruitResponse();
			response.setError(Constants.Messages.INVALID_ID);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		FruitDTO fruitDto = fruitService.getOne(id);
		
		if(fruitDto != null) {
			FruitResponse response = new FruitResponse();
			response.setMessage(Constants.Messages.FOUND);
			response.setFruit(fruitDto);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}else {
			FruitResponse response = new FruitResponse();
			response.setMessage(Constants.Messages.NOT_FOUND);
			response.setFruit(fruitDto); //fruitDto is null.
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}	    

	
	@GetMapping("/getAll")
	public ResponseEntity<List<FruitDTO>> getAll() {
		
		List<FruitDTO> fruits = fruitService.getAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(fruits);
	}
}
