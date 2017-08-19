package com.github.spb.tget.uitests.utils.GithubApiUtils;

import org.apache.http.client.methods.HttpPost;

public class HttpDeleteWithBody extends HttpPost {

    public HttpDeleteWithBody(String uri) {
        super(uri);
    }

    @Override
    public String getMethod(){
        return "DELETE";
    }
}
