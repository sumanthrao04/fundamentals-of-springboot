package com.sumanth.fundamentals_of_springboot.project2.controller;
import com.sumanth.fundamentals_of_springboot.project2.dto.TodoDto;
import com.sumanth.fundamentals_of_springboot.project2.service.TodoService;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
@AllArgsConstructor
public class TodoController {

   private TodoService todoService;

    @PostMapping("/create")
    public ResponseEntity<TodoDto>createTodo(@RequestBody TodoDto todoDto){
       TodoDto savedDto = todoService.addTodo(todoDto);
        return  new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TodoDto>>getAllTodo(){
     List<TodoDto>  getAllTodo =  todoService.getAll();
      return  new ResponseEntity<>(getAllTodo,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getById(@RequestParam Long id){
       TodoDto findById= todoService.findById(id);
       return  new ResponseEntity<>(findById,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @RequestParam Long id){
       TodoDto updatedUser= todoService.update(todoDto,id);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@RequestParam Long id){
        todoService.delete(id);
        return new ResponseEntity<>("The Todo is deleted",HttpStatus.OK);
    }


}
