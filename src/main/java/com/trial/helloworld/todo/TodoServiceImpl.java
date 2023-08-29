package com.trial.helloworld.todo;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoServiceImpl implements TodoService {

  private final TodoRepository todoRepository;

  @Override
  public List<TodoEntity> findAll() {
    return todoRepository.findAll();
  }

  @Override
  public void create(TodoEntity todoEntity) {
    todoRepository.save(todoEntity);
  }

  // TODO 削除処理
}
