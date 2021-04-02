package ru.kpfu.itis.group903.nurkaev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.group903.nurkaev.dto.LoginDto;
import ru.kpfu.itis.group903.nurkaev.dto.UserDto;
import ru.kpfu.itis.group903.nurkaev.exceptions.DuplicateEntryException;
import ru.kpfu.itis.group903.nurkaev.exceptions.WrongEmailOrPasswordException;
import ru.kpfu.itis.group903.nurkaev.models.User;
import ru.kpfu.itis.group903.nurkaev.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 2
 */

@Service(value = "usersService")
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public void save(User entity) {
        usersRepository.save(entity);
    }

    @Override
    public void delete(User entity) {
        usersRepository.delete(entity);
    }

    @Override
    public void deleteByEmail(String email) {
        usersRepository.deleteByEmail(email);
    }

    /*@Override
    public void update(User entity) {
        usersRepository.update(entity);
    }*/

    @Override
    public void updateByEmail(String firstName, String lastName, String email) {
        usersRepository.updateByEmail(firstName, lastName, email);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Optional<User> findOneByEmail(String email) {
        return usersRepository.findOneByEmail(email);
    }

    @Override
    public void signUp(UserDto userDto) throws DuplicateEntryException {
        Optional<User> userOptional = findOneByEmail(userDto.getEmail());
        // Разрешаем регистрацию, если данных нового пользователя нет в БД.
        if (!userOptional.isPresent()) {
            User user = User.builder()
                    .firstName(userDto.getFirstName())
                    .lastName(userDto.getLastName())
                    .email(userDto.getEmail())
                    .hashPassword(encoder.encode(userDto.getPassword()))
                    .build();
            save(user);
        } else throw new DuplicateEntryException();
    }

    @Override
    public void signIn(LoginDto loginDto) throws WrongEmailOrPasswordException {
        Optional<User> userOptional = findOneByEmail(loginDto.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (!encoder.matches(loginDto.getPassword(), user.getHashPassword())) {
                throw new WrongEmailOrPasswordException();
            }
        } else throw new WrongEmailOrPasswordException();
    }
}
