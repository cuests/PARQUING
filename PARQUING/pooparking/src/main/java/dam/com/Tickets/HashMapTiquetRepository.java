package dam.com.Tickets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class HashMapTiquetRepository implements TiquetRepository {

    private final HashMap<Integer, Tiquet> tiquets = new HashMap<>();

    @Override
    public void save(Tiquet tiquet) {
        tiquets.put(tiquet.getNumero(), tiquet);
    }

    @Override
    public Optional<Tiquet> findById(int id) {
        return Optional.ofNullable(tiquets.get(id));
    }

    @Override
    public boolean delete(Tiquet tiquet) {
        return tiquets.remove(tiquet.getNumero(), tiquet);
    }

    @Override
    public List<Tiquet> findAll() {
        return new ArrayList<>(tiquets.values());
    }
}