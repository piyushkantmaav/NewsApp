package com.tna.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class NewsArticleLoader extends AsyncTaskLoader<List<NewsArticle>> {

    private String mUrl;
    public static boolean mPrefThumbnail;
    public NewsArticleLoader(Context context, String url, Boolean prefThumbnail) {
        super(context);
        mUrl = url;
        mPrefThumbnail = prefThumbnail;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
    @Override
    public List<NewsArticle> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of newsArticles.
        List<NewsArticle> newsArticles = NewsQueryUtils.fetchArticleData(mUrl);
        return newsArticles;
    }
}