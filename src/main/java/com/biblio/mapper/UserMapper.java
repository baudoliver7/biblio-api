package com.biblio.mapper;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;
import com.biblio.domain.User;
import com.biblio.dto.UserDto;

@Configuration
@Mapper(componentModel = "spring")
public interface UserMapper {

  UserDto toUserDto(User user);

}