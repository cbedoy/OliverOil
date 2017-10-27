package iambedoy.oliveoil;

import static iambedoy.oliveoil.BaseContract.*;

/**
 * OliveOil
 * <p>
 * Created by bedoy on 10/25/17.
 */

public class BasePresenter implements IBasePresenter
{
    public IBaseInteractor interactor;
    public IBaseViewController viewController;

    public void setInteractor(IBaseInteractor interactor) {
        this.interactor = interactor;
    }

    public void setViewController(IBaseViewController viewController) {
        this.viewController = viewController;
    }

    @Override
    public void load() {

    }
}
