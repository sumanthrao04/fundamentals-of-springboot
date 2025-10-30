package com.sumanth.fundamentals_of_springboot.project2.service.impl;

import com.sumanth.fundamentals_of_springboot.project2.dto.TodoDto;
import com.sumanth.fundamentals_of_springboot.project2.entity.Todo;
import com.sumanth.fundamentals_of_springboot.project2.repository.TodoRepository;
import com.sumanth.fundamentals_of_springboot.project2.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    TodoRepository repository;

    @Override
    public TodoDto addTodo( TodoDto todoDto) {
        //convert TodoDTo into ToDo JPA entity
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        //save to database
        Todo savedTodo = repository.save(todo);

        //convert saved todo jpa object into tododto object
        TodoDto savedTodoDto = new TodoDto();
        savedTodoDto.setId(savedTodo.getId());
        savedTodoDto.setDescription(savedTodo.getDescription());
        savedTodoDto.setTitle(savedTodo.getTitle());
        savedTodoDto.setCompleted(savedTodo.isCompleted());

        //return the saved object from database to user

        return savedTodoDto;

    }

    @Override
    public List<TodoDto> getAll() {
  List<Todo> getallTodo = repository.findAll();

        return getallTodo.stream()
                .map(todo -> new TodoDto(
                        todo.getId(),
                        todo.getTitle(),
                        todo.getDescription(),
                        todo.isCompleted()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto findById(Long id) {
        Todo todoFromDatabase = repository.findById(id).get();
        TodoDto todoById = new TodoDto();
        todoById.setId(todoFromDatabase.getId());
        todoById.setCompleted(todoFromDatabase.isCompleted());
        todoById.setTitle(todoFromDatabase.getTitle());
        todoById.setDescription(todoFromDatabase.getDescription());
        return todoById;
    }

    @Override
    public TodoDto update(TodoDto todoDto, Long id) {
        Todo ByIdTodo =  repository.findById(id).get();

        ByIdTodo.setTitle(todoDto.getTitle());
        ByIdTodo.setDescription(todoDto.getDescription());
        ByIdTodo.setCompleted(todoDto.isCompleted());
        Todo savedTodo=  repository.save(ByIdTodo);
        //convert saved todo jpa object into tododto object
        TodoDto savedTodoDto = new TodoDto();
        savedTodoDto.setId(savedTodo.getId());
        savedTodoDto.setDescription(savedTodo.getDescription());
        savedTodoDto.setTitle(savedTodo.getTitle());
        savedTodoDto.setCompleted(savedTodo.isCompleted());
        return savedTodoDto;
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id).get());

    }
}
