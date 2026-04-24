package dam.com.Tickets;

import java.util.List;
import java.util.Optional;

public interface TiquetRepository {

    void save(Tiquet tiquet);

    Optional<Tiquet> findById(int id);

    boolean delete(Tiquet tiquet);

    List<Tiquet> findAll();
}
