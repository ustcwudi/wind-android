package platform.client.android.page;

import java.util.List;

import platform.client.android.base.IBasePresenter;
import platform.client.android.base.IBaseView;
import platform.client.android.bean.ArticleBean;

public class HomeContract {
    interface View extends IBaseView {
        void showArticleList(List<ArticleBean> articleList);
    }

    interface Presenter extends IBasePresenter<View> {
        void getHomeArticle();
    }
}
