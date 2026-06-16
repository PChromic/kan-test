package com.sii.domain;

import com.sii.api.BoardResponse;
import com.sii.domain.db.BoardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BoardMapper {

        BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

        BoardResponse entityToResponse(BoardEntity entity);
}
