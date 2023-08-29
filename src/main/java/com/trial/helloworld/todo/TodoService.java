package com.trial.helloworld.todo;

import java.util.List;

public interface TodoService {

  List<TodoEntity> findAll();

  void create(TodoEntity todoEntity);

  // TODO 削除処理
}
