package com.matkon.teachme.domain.learn.mapper;

import org.mapstruct.Mapper;

import com.matkon.teachme.domain.learn.dto.LogBookRequest;
import com.matkon.teachme.domain.learn.dto.LogBookResponse;
import com.matkon.teachme.domain.learn.entity.LogBook;

@Mapper(componentModel = "spring")
public interface LogBookMapper {

    LogBook logBookRequestToLogBook(LogBookRequest request);

    LogBookResponse logBookToLogBookResponse(LogBook logBook);
}
