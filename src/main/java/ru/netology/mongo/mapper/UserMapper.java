
package ru.netology.mongo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.netology.mongo.dto.UserDto;
import ru.netology.mongo.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(UserDto dto);

    UserDto toDto(User user);
}