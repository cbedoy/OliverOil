package iambedoy.oliveoil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {
    @Test
    public void shouldReturnNotNullInstancesAfterInject() throws Exception {
        OilInjector.inject(
                BaseInteractor.class,
                BasePresenter.class,
                BaseViewController.class
        );

        BaseInteractor interactor = (BaseInteractor) OilInjector
                .getInstanceFromClass(BaseInteractor.class);

        BasePresenter presenter = (BasePresenter) OilInjector
                .getInstanceFromClass(BasePresenter.class);

        BaseViewController viewController = (BaseViewController) OilInjector
                .getInstanceFromClass(BaseViewController.class);

        assertNotNull(interactor);
        assertNotNull(presenter);
        assertNotNull(viewController);
    }
}