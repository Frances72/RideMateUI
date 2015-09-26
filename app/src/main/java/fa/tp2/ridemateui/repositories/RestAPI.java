package fa.tp2.ridemateui.repositories;

import java.util.List;

/**
 * Created by User on 2015/09/12.
 */
public interface RestAPI<S, ID> {
    S getAll(ID id);

    String post(S entity);

    String put(S entity);

    String delete(S entity);

    List<S> getAll();
}

