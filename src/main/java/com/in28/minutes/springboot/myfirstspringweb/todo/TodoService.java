package com.in28.minutes.springboot.myfirstspringweb.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    static {
        todos.add(new Todo(1, "kim",
                "Learn AWS",
                LocalDate.now().plusYears(1),
                false));
        todos.add(new Todo(2, "kim",
                "Learn DevOps",
                LocalDate.now().plusYears(1),
                false));
        todos.add(new Todo(3, "kim",
                "Learn Full Stack Development",
                LocalDate.now().plusYears(1),
                false));
    }
    public List<Todo> findByUsername(String username) {
        return todos;
    }
}
