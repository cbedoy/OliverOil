package iambedoy.oliveoil;

/**
 * OliveOil
 * <p>
 * Created by bedoy on 10/25/17.
 */

public interface BaseContract
{
    interface IBasePresenter{
        void load();
    }

    interface IBaseInteractor{
        void request();
    }

    interface IBaseViewController{
        void show();
    }
}
