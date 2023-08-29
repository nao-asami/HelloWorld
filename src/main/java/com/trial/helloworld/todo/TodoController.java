package com.trial.helloworld.todo;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/todo")
public class TodoController {

  private TodoService todoService;

  @GetMapping("/get")
  public List<TodoEntity> getTodoList() {
    return todoService.findAll();
  }

  @GetMapping("/post")
  @ResponseStatus(HttpStatus.CREATED)
  public TodoEntity addTodo(
      @RequestParam("id") String id,
      @RequestParam("tl") String title,
      @RequestParam("dl") String detail) {
    var entity =
        TodoEntity.builder()
            .id(Integer.parseInt(id))
            .title(title)
            .detail(detail)
            .done(false)
            .build();
    todoService.create(entity);
    return entity;
  }
  // TODO 削除処理
}
