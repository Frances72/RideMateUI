package fa.tp2.ridemateui.services;

import java.util.List;

/**
 * Created by User on 2015/09/12.
 */
public interface Services <S, ID> {
    public S findById(ID id);

    public String save(S entity);

    public String update(S entity);

    public String delete(S entity);

    public List<S> findAll();

}
