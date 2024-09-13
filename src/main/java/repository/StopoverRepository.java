package repository;

import com.example.eldorado.entidades.Stopover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface StopoverRepository extends JpaRepository<Stopover, Integer> {
    @Query("SELECT stpVer FROM Stopover stpVer WHERE stpVer.stopoverTime = ?1")
    List<Stopover> findByStopoverTime(LocalDate stopoverTime);
}
