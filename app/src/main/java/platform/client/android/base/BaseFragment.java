package platform.client.android.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment<T extends IBasePresenter> extends Fragment implements IBaseView {

    protected T presenter;
    private Toast toast;
    private BaseFrameLayout baseFrameLayout;
    private Unbinder unbinder;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (baseFrameLayout == null) {
            baseFrameLayout = new BaseFrameLayout(getActivity()) {
                @Override
                public View getSuccessView(ViewGroup container) {
                    return LayoutInflater.from(getContext()).inflate(getLayoutId(), container, false);
                }
            };
        }
        baseFrameLayout.setStatus(BaseFrameLayout.Status.SUCCESS);
        unbinder = ButterKnife.bind(this, baseFrameLayout);
        initEvent();
        return baseFrameLayout;
    }

    protected abstract int getLayoutId();

    protected abstract void initEvent();

    @Override
    public void showToastMsg(String msg) {
        if (toast == null) {
            toast = Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            toast.setText(msg);
            toast.show();
        }
    }

    @Override
    public void showEmptyView() {
        baseFrameLayout.setStatus(BaseFrameLayout.Status.EMPTY);
    }

    @Override
    public void showErrorView() {
        baseFrameLayout.setStatus(BaseFrameLayout.Status.ERROR);
    }

    @Override
    public void showLoadingView() {
        baseFrameLayout.setStatus(BaseFrameLayout.Status.LOADING);
    }

    @Override
    public void showNoNetWorkView() {
        baseFrameLayout.setStatus(BaseFrameLayout.Status.NO_NETWORK);
    }

    @Override
    public void showSuccessView() {
        baseFrameLayout.setStatus(BaseFrameLayout.Status.SUCCESS);
    }

    @Override
    public void onDestroyView() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
        super.onDestroyView();
    }
}