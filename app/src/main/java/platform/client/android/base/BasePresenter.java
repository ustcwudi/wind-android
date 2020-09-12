package platform.client.android.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import platform.client.android.Api;
import platform.client.android.util.RetrofitUtil;

public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter<T> {

    protected T view;
    private CompositeDisposable compositeDisposable;
    protected Api api = RetrofitUtil.getApi();

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (view != null) {
            view = null;
        }
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    protected void addRequest(Disposable disposable){
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }
}