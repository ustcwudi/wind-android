package platform.client.android.page;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import platform.client.android.R;
import platform.client.android.adapter.HomeAdapter;
import platform.client.android.base.BaseFragment;
import platform.client.android.bean.ArticleBean;

public class HomePage extends BaseFragment<HomeContract.Presenter> implements HomeContract.View {

    HomeAdapter adapter;

    @BindView(R.id.main_recycler)
    RecyclerView recyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.pager_home;
    }
    
    @Override
    protected void initEvent() {
        List<String> dataList = new ArrayList<>();
        for (int i = 'A'; i < 'Z'; i++) {
            dataList.add("" + (char) i);
        }
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        recyclerView.setLayoutManager(manager);
        adapter = new HomeAdapter(getContext(), dataList);
        recyclerView.setAdapter(adapter);

        presenter = new HomePresenter();
        presenter.attachView(this);
        presenter.getHomeArticle();
    }

    @Override
    public void showArticleList(List<ArticleBean> articleList) {
        List<String> dataList = new ArrayList<>();
        for (int i = 'A'; i < 'Z'; i++) {
            dataList.add("" + (char) i);
        }
        adapter.setNewData(dataList);
    }
}
