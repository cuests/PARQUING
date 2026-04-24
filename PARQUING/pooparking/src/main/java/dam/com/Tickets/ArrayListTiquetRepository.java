package dam.com.Tickets;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArrayListTiquetRepository implements TiquetRepository {

    private final ArrayList<Tiquet> tiquets = new ArrayList<>();

    @Override
    public void save(Tiquet tiquet) {
        tiquets.add(tiquet);
    }

    @Override
    public Optional<Tiquet> findById(int id) {
        return tiquets.stream()
                .filter(t -> t.getNumero() == id)
                .findFirst();
    }

    @Override
    public boolean delete(Tiquet tiquet) {
        return tiquets.remove(tiquet);
    }

    @Override
    public List<Tiquet> findAll() {
        return new ArrayList<>(tiquets);
    }
}
