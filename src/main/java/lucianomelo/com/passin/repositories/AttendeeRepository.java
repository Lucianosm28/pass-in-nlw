package lucianomelo.com.passin.repositories;

import lucianomelo.com.passin.domain.attendee.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee,String> {
}
