package com.sumanth.fundamentals_of_springboot.project2.service;

import com.sumanth.fundamentals_of_springboot.project2.dto.TodoDto;
import com.sumanth.fundamentals_of_springboot.project2.entity.Todo;

import java.util.List;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);
    List<TodoDto> getAll();
   TodoDto findById( Long id)  ;

   TodoDto update(TodoDto todoDto , Long id);
    void delete(Long id);
}
