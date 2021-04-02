package ru.kpfu.itis.group903.nurkaev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kpfu.itis.group903.nurkaev.dto.AvailabilityDto;
import ru.kpfu.itis.group903.nurkaev.exceptions.NoRoomsAvailableException;
import ru.kpfu.itis.group903.nurkaev.models.Room;

import java.util.List;
import java.util.Optional;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 2
 */

public interface RoomsRepository extends JpaRepository<Room, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM room_hotel WHERE name = :name")
    Optional<Room> findByName(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM room_hotel WHERE dateto < :date_from")
    List<Room> getAvailableRooms(AvailabilityDto availabilityDto) throws NoRoomsAvailableException;

    /*@Query(nativeQuery = true, value = "UPDATE room_hotel " +
            "SET name = :name, photo = :photo, datefrom = :date_from, " +
            "dateto = :date_to, roomsnumber = :rooms_number, " +
            "adultsnumber = :adults_number, childnumber = :child_number, price = :price " +
            "WHERE id = :id;")
    void update(Room entity);*/
}
