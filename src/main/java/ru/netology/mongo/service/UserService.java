package ru.netology.mongo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.mongo.dto.UserDto;
import ru.netology.mongo.mapper.UserMapper;
import ru.netology.mongo.model.User;
import ru.netology.mongo.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public List<UserDto> findAllByName(String name) {
        return userRepository.findByName(name)
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public List<UserDto> findAllByAge(Integer age) {
        return userRepository.findByAge(age)
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public void deleteById(String id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User by id" + id + "not found"));
        userRepository.delete(user);
    }

    public UserDto createUser(UserDto dto) {
        User user = userMapper.toEntity(dto);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    public UserDto updateUser(String id, UserDto dto) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User by id" + id + "not found"));
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setAge(dto.age());
        User userUpdated = userRepository.save(user);
        return userMapper.toDto(userUpdated);
    }
}
