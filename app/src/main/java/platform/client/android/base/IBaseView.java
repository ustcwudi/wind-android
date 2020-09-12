package platform.client.android.base;

public interface IBaseView {

    void showToastMsg(String msg);

    void showEmptyView();

    void showErrorView();

    void showLoadingView();

    void showNoNetWorkView();

    void showSuccessView();
}