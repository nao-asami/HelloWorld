package com.trial.helloworld.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "todo")
public class TodoEntity {
  @Id private int id;
  private String title;
  private String detail;
  private Boolean done;
}
