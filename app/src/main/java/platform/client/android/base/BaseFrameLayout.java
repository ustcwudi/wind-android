package platform.client.android.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import platform.client.android.R;

public abstract class BaseFrameLayout extends FrameLayout {

    public enum Status {
        EMPTY, NO_NETWORK, LOADING, ERROR, SUCCESS, NONE
    }

    private BaseFrameLayout.Status status = Status.NONE;
    private View successView;
    private View emptyView;
    private View errorView;
    private View loadingView;
    private View noNetworkView;

    public BaseFrameLayout(@NonNull Context context) {
        super(context);
        switchView();
    }

    public void setStatus(BaseFrameLayout.Status status) {
        this.status = status;
        switchView();
    }

    private void switchView() {
        if (successView == null) {
            successView = getSuccessView(this);
            addView(successView);
        }
        successView.setVisibility(status == Status.SUCCESS ? VISIBLE : GONE);

        if (emptyView == null) {
            emptyView = LayoutInflater.from(getContext()).inflate(R.layout.part_error, this, false);
            addView(emptyView);
        }
        emptyView.setVisibility(status == Status.EMPTY ? VISIBLE : GONE);

        if (errorView == null) {
            errorView = LayoutInflater.from(getContext()).inflate(R.layout.part_error, this, false);
            addView(errorView);
        }
        errorView.setVisibility(status == Status.ERROR ? VISIBLE : GONE);

        if (loadingView == null) {
            loadingView = LayoutInflater.from(getContext()).inflate(R.layout.part_error, this, false);
            addView(loadingView);
        }
        loadingView.setVisibility(status == Status.LOADING ? VISIBLE : GONE);

        if (noNetworkView == null) {
            noNetworkView = LayoutInflater.from(getContext()).inflate(R.layout.part_error, this, false);
            addView(noNetworkView);
        }
        noNetworkView.setVisibility(status == Status.NO_NETWORK ? VISIBLE : GONE);
    }

    public abstract View getSuccessView(ViewGroup container);
}