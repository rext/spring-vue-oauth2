package me.rext.example.spring_vue_oauth2.web;

import org.springframework.web.servlet.resource.WebJarsResourceResolver;

public class SpaWebJarResourceResolver extends WebJarsResourceResolver {
    private final String indexName;

    public SpaWebJarResourceResolver(String indexName) {
        this.indexName = indexName;
    }

    public String getIndexName() {
        return indexName;
    }

    @Override
    protected String findWebJarResourcePath(String path) {
        String res = super.findWebJarResourcePath(path);
        if (res != null) {
            return res;
        }

        int startOffset = (path.startsWith("/") ? 1 : 0);
        int endOffset = path.indexOf('/', 1);
        if (endOffset != -1) {
            String webjar = path.substring(startOffset, endOffset);
            String partialPath = path.substring(endOffset + 1);
            if (!indexName.equals(partialPath)) {
                return super.findWebJarResourcePath(webjar + "/" + indexName);
            }
        }
        return null;
    }
}
