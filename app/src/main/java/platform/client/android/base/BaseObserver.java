package platform.client.android.base;

import io.reactivex.observers.ResourceObserver;

public abstract class BaseObserver<T> extends ResourceObserver<BaseData<T>> {

    private IBaseView baseView;

    public BaseObserver(IBaseView view){
        this.baseView = view;
    }

    @Override
    protected void onStart() {
        baseView.showLoadingView();
        super.onStart();
    }


    @Override
    public void onNext(BaseData<T> baseData) {
        if (baseData.getErrorCode() == 0){
            onSuccess(baseData.getData());
            baseView.showSuccessView();
        }else {
            baseView.showErrorView();
        }
    }

    @Override
    public void onError(Throwable e) {
        baseView.showErrorView();
        baseView.showToastMsg(e.getMessage());
    }

    @Override
    public void onComplete() {
    }

    public abstract void onSuccess(T data);
}