package com.fareye.training.validations;

import com.fareye.training.model.Todo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

import static com.fareye.training.controller.TodoController.Todos;

public class DupVal implements ConstraintValidator<Duplicates, Todo> {
//    List<String> TodoTitle= new ArrayList<>();

    @Override
    public void initialize(Duplicates dup){
    }

    @Override
    public boolean isValid(Todo todo, ConstraintValidatorContext cxt) {
        List<Todo> UserTodos = Todos.get(todo.getUser_id());
//        System.out.println(UserTodos);
        for(int i=0; i<UserTodos.size(); i++){
            if(UserTodos.get(i).getTitle().equals(todo.getTitle())){
                return false;
            }
        }
        return true;
    }
}