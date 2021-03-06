package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.FuncionarioEntity;
import com.example.demo.repositories.FuncionarioRepository;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funRepo;
	
	@GetMapping
	public ResponseEntity<List<FuncionarioEntity>> recupera(){
		List<FuncionarioEntity> list = funRepo.findAll();		
		return ResponseEntity.ok().body(list);
		
	}
	
	@PostMapping
	public ResponseEntity<FuncionarioEntity> cria(@RequestBody FuncionarioEntity fun){
		fun = funRepo.save(fun);
		return ResponseEntity.created(null).body(fun);
	}
	
	@PutMapping
	public ResponseEntity<FuncionarioEntity> atualiza(@PathVariable Integer id, @RequestBody FuncionarioEntity fun){
		fun = funRepo.getById(id);
		return ResponseEntity.ok().body(fun);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<FuncionarioEntity>deleta(@PathVariable Integer id){
		funRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
