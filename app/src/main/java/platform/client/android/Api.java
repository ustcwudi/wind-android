package platform.client.android;

import io.reactivex.Observable;
import platform.client.android.base.BaseData;
import platform.client.android.bean.PageBean;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/22 22:37
 * @description
 */
public interface Api {

    /**
     * 获取主页文章
     * @return Observable<BaseData<PageBean>>
     */
    @GET("article/list/{pageNum}/json")
    Observable<BaseData<PageBean>> getHomeArticleList(@Path("pageNum") int pageNum);
}