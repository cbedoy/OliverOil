package iambedoy.oliveoil;

import static iambedoy.oliveoil.BaseContract.*;

/**
 * OliveOil
 * <p>
 * Created by bedoy on 10/25/17.
 */

public class BaseViewController implements IBaseViewController {
    public IBasePresenter presenter;

    public void setPresenter(IBasePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void show() {

    }
}
