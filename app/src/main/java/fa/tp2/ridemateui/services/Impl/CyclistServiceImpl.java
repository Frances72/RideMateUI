package fa.tp2.ridemateui.services.Impl;

import java.util.List;

import fa.tp2.ridemateui.model.Cyclist;
import fa.tp2.ridemateui.repositories.RestAPI;
import fa.tp2.ridemateui.repositories.rest.RestCyclistAPI;
import fa.tp2.ridemateui.services.CyclistService;

/**
 * Created by User on 2015/09/12.
 */
public class CyclistServiceImpl implements CyclistService {

    final RestAPI<Cyclist,Long> rest = new RestCyclistAPI();
    @Override
    public Cyclist findById(Long id) {
        return rest.getAll(id);
    }

    @Override
    public String save(Cyclist entity) {

        return rest.post(entity);
    }

    @Override
    public String update(Cyclist entity) {
        return rest.put(entity);
    }

    @Override
    public String delete(Cyclist entity) {
        return rest.delete(entity);

    }

    @Override
    public List<Cyclist> findAll() {
        return rest.getAll();
    }
}
