package ru.kpfu.itis.group903.nurkaev.dto;

import lombok.*;
import ru.kpfu.itis.group903.nurkaev.models.User;
import ru.kpfu.itis.group903.nurkaev.validation.ValidNames;
import ru.kpfu.itis.group903.nurkaev.validation.ValidPassword;

import javax.validation.constraints.Email;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ValidNames(
        message = "{errors.invalid.names}",
        name = "firstName",
        surname = "lastName")
public class UserDto {
    private String firstName;

    private String lastName;

    @Email(message = "{errors.incorrect.email}")
    private String email;

    @ValidPassword(message = "{errors.invalid.password}")
    private String password;

    //TODO: Перенести поле confirmPassword в UserForm
    private String confirmPassword;

    private String uuid;

    /*public static UserDto from(User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getHashPassword())
                .confirmPassword(user.getHashPassword())
                .u
                .build()
    }*/
}
