package com.kakaoix.todoapp.service;

import com.kakaoix.todoapp.dto.TodoItemDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoItemServiceTest {

    @Autowired
    private TodoItemService todoItemService;

    @Test
    public void todoItem_가져오기() {
        TodoItemDto todo = todoItemService.getModifyTodoItem(4L);
        log.info("todo : {}", todo.toString());
    }

    @Test
    public void todoItem_수정() {
        TodoItemDto todo = todoItemService.getModifyTodoItem(4L);
        todo.setContent("안녕하세요");

        Assert.assertEquals("수정 완료 하였습니다.", todoItemService.modifyTodoItem(4L, todo));
    }

    @Test
    public void todoItem_삭제() throws Exception {
        todoItemService.deleteTodoItem(22L);
    }

    @Test
    public void todoItem_완료여부_체크() throws Exception {
        Assert.assertEquals("테스트", todoItemService.checkTodoItem(1L, null));
    }
}
