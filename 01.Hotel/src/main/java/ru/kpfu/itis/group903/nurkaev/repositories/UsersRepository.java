package ru.kpfu.itis.group903.nurkaev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.group903.nurkaev.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = "DELETE FROM user_hotel WHERE email = :email;")
    void deleteByEmail(String email);

    /*@Query(nativeQuery = true, value = "UPDATE user_hotel " +
            "SET firstName = :first_name, lastName = :lastName, email = :email, roomsId = :rooms_id " +
            "WHERE id = :id;")
    void update(User entity);*/

    @Query(nativeQuery = true, value = "UPDATE user_hotel " +
            "SET firstName = :firstName, lastName = :lastName WHERE email = :email;")
    void updateByEmail(@Param("firstName") String firstName,
                       @Param("lastName") String lastName,
                       @Param("email") String email);

    Optional<User> findOneByEmail(String email);
}
