package com.trial.helloworld.todo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/todo")
@Tag(name = "todo", description = "TODO")
public class TodoController {

  private TodoService todoService;

  @GetMapping("/get")
  @Operation(description = "TODOデータ取得")
  public List<TodoEntity> getTodoList() {
    return todoService.findAll();
  }

  @PostMapping("/post")
  @Operation(description = "TODOデータ作成")
  @ResponseStatus(HttpStatus.CREATED)
  public TodoEntity addTodo(@Valid @RequestBody final TodoRequest request) {
    var entity =
        TodoEntity.builder()
            .id(request.id)
            .title(request.title)
            .detail(request.detail)
            .done(false)
            .build();
    todoService.create(entity);
    return entity;
  }

  // TODO 削除処理

  @Getter
  @Schema(description = "TODO作成リクエスト")
  @AllArgsConstructor
  public static class TodoRequest {

    @NotNull
    @Schema(description = "id", example = "1")
    private int id;

    @NotNull
    @Size(min = 1, max = 20)
    @Schema(description = "タイトル", example = "テストタイトル")
    private String title;

    @NotNull
    @Size(min = 1, max = 100)
    @Schema(description = "内容", example = "テスト内容")
    private String detail;

    @Schema(description = "可否", example = "false")
    private Boolean done;
  }
}
