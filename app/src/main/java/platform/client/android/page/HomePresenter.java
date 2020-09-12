package platform.client.android.page;

import io.reactivex.Observable;
import platform.client.android.base.BaseData;
import platform.client.android.base.BaseObserver;
import platform.client.android.base.BasePresenter;
import platform.client.android.bean.PageBean;
import platform.client.android.util.RxUtil;

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    @Override
    public void getHomeArticle() {
        BaseObserver<PageBean> observer = new BaseObserver<PageBean>(view) {
            @Override
            public void onSuccess(PageBean data) {
                view.showArticleList(data.getDatas());
            }
        };
        Observable<BaseData<PageBean>> observable = api.getHomeArticleList(1);
        addRequest(observable.compose(RxUtil.schedulerTransformer()).subscribeWith(observer));
    }
}