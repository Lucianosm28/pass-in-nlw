package lucianomelo.com.passin.repositories;

import lucianomelo.com.passin.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository <Event,String> {
}
