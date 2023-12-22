package com.in28.minutes.springboot.myfirstspringweb.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "kim",
                "Learn AWS",
                LocalDate.now().plusYears(1),
                false));
        todos.add(new Todo(++todosCount, "kim",
                "Learn DevOps",
                LocalDate.now().plusYears(1),
                false));
        todos.add(new Todo(++todosCount, "kim",
                "Learn Full Stack Development",
                LocalDate.now().plusYears(1),
                false));
    }
    public List<Todo> findByUsername(String username) {
        Predicate<? super Todo> predicate
                = todo -> todo.getUsername().equals(username);
        return todos
                .stream()
                .filter(predicate)
                .toList();
    }


    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);
    }

    public void deleteById(int id) {
        // 조건을 검사하는 함수형 인터페이스
        Predicate<? super Todo> predicate
                = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate
                = todo -> todo.getId() == id;
        Todo todo = todos.stream()
                        .filter(predicate)
                        .findFirst()
                        .get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
